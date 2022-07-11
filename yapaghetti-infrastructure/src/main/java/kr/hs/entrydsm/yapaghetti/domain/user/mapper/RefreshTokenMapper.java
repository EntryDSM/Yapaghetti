package kr.hs.entrydsm.yapaghetti.domain.user.mapper;

import kr.hs.entrydsm.yapaghetti.domain.user.domain.RefreshToken;
import kr.hs.entrydsm.yapaghetti.domain.user.persistence.entity.RefreshTokenEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RefreshTokenMapper {
    RefreshToken entityToDomain(RefreshTokenEntity refreshTokenEntity);
    RefreshTokenEntity domainToEntity(RefreshToken refreshToken);
}
