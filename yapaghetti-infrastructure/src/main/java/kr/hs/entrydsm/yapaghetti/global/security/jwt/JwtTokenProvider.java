package kr.hs.entrydsm.yapaghetti.global.security.jwt;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import kr.hs.entrydsm.yapaghetti.domain.user.domain.UserRole;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserJwtPort;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.dto.SpiTokenResponse;
import kr.hs.entrydsm.yapaghetti.global.exception.InternalServerErrorException;
import kr.hs.entrydsm.yapaghetti.global.property.JwtProperties;
import kr.hs.entrydsm.yapaghetti.global.security.exception.InvalidTokenException;
import kr.hs.entrydsm.yapaghetti.global.security.exception.InvalidTokenTypeException;
import kr.hs.entrydsm.yapaghetti.global.security.principle.AuthDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider implements UserJwtPort {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";
    private static final String JWT_ACCESS_TOKEN_TYPE = "access_token";
    private static final String JWT_REFRESH_TOKEN_TYPE = "refresh_token";

    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader(AUTHORIZATION_HEADER);
        if (bearer != null && bearer.length() > 7 && bearer.startsWith(BEARER_PREFIX)) {
            return bearer.substring(7);
        }
        return null;
    }

    public Authentication getAuthentication(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWTClaimsSet claimsSet = signedJWT.getJWTClaimsSet();
            String type = claimsSet.getStringClaim("type");
            if (!type.equals(JWT_ACCESS_TOKEN_TYPE)) {
                throw InvalidTokenTypeException.EXCEPTION;
            }
            String subject = claimsSet.getSubject();

            UserDetails userDetails = authDetailsService.loadUserByUsername(subject);

            return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());

        } catch (ParseException e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

    @Override
    public SpiTokenResponse getToken(UUID userId, UserRole userRole) {
        return new SpiTokenResponse(
                generateToken(userId, userRole, JWT_ACCESS_TOKEN_TYPE, getAccessExpiration()),
                generateToken(userId, userRole, JWT_REFRESH_TOKEN_TYPE, getRefreshExpiration()),
                jwtProperties.getRefreshExp()
        );
    }


    private String generateToken(UUID userId, UserRole role, String type, Date expiration) {
        try {
            JWSSigner signer = new MACSigner(jwtProperties.getSecret());

            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                    .subject(userId.toString())
                    .claim("role", role.name())
                    .claim("type", type)
                    .expirationTime(expiration)
                    .build();

            JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.HS512)
                    .type(JOSEObjectType.JWT)
                    .build();

            SignedJWT signedJWT = new SignedJWT(header, claimsSet);
            signedJWT.sign(signer);

            return signedJWT.serialize();
        } catch (JOSEException e) {
            throw InternalServerErrorException.EXCEPTION;
        }
    }

    private Date getAccessExpiration() {
        return new Date(System.currentTimeMillis() + jwtProperties.getAccessExp());
    }

    private Date getRefreshExpiration() {
        return new Date(System.currentTimeMillis() + jwtProperties.getRefreshExp());
    }

}
