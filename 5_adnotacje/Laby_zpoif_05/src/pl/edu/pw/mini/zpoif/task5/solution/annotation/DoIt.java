package pl.edu.pw.mini.zpoif.task5.solution.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface DoIt {
	int times() default 1;
}
