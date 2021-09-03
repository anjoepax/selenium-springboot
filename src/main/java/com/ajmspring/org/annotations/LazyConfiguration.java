package com.ajmspring.org.annotations;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import java.lang.annotation.*;

@Lazy
@Configuration
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LazyConfiguration {
}
