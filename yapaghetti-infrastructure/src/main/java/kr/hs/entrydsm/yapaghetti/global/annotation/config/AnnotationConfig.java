package kr.hs.entrydsm.yapaghetti.global.annotation.config;

import kr.hs.entrydsm.yapaghetti.annotation.ReadOnlyUseCase;
import kr.hs.entrydsm.yapaghetti.annotation.UseCase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.Filter;

@Configuration
@ComponentScan(
        basePackages = {"kr.hs.entrydsm.yapaghetti"},
        includeFilters = {
                @Filter(
                        type = FilterType.ANNOTATION,
                        value = UseCase.class
                ),
                @Filter(
                        type = FilterType.ANNOTATION,
                        value = ReadOnlyUseCase.class
                )
        }
)
public class AnnotationConfig {
}
