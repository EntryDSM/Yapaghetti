package kr.hs.entrydsm.yapaghetti.global.property;

import kr.hs.entrydsm.yapaghetti.domain.auth.spi.GetAuthPropertiesPort;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("auth")
@Getter
@RequiredArgsConstructor
public class AuthProperties implements GetAuthPropertiesPort {

	private final Long authTime;

	private final Long limitTime;
}
