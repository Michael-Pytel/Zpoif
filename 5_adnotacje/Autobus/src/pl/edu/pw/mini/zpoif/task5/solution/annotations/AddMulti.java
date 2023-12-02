package pl.edu.pw.mini.zpoif.task5.solution.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface AddMulti {
	Class<?>[] value();
}
