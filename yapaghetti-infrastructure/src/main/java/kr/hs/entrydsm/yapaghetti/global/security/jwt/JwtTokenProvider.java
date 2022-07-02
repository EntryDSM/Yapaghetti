package kr.hs.entrydsm.yapaghetti.global.security.jwt;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import kr.hs.entrydsm.yapaghetti.domain.user.spi.UserJwtPort;
import kr.hs.entrydsm.yapaghetti.global.exception.InternalServerErrorException;
import kr.hs.entrydsm.yapaghetti.global.property.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider implements UserJwtPort {

    private final JwtProperties jwtProperties;

    @Override
    public String generateAccessToken(String email, String role) {
        try {
            Date expiration = getAccessExpiration();
            JWSSigner signer = new MACSigner(jwtProperties.getSecret());

            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                    .subject(email)
                    .claim("role", role)
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

}
