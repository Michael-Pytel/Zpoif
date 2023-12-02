package pl.edu.pw.mini.zpoif.task5.solution.annotation;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ PARAMETER, CONSTRUCTOR })
public @interface LengthValidator {
	int minLength() default 5;
	int maxLength() default 10;
}
