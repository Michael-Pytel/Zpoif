package pl.edu.pw.mini.zpoif.task5.solution.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import pl.edu.pw.mini.zpoif.task5.solution.AllowedValues;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MethodInvoker {
	AllowedValues licznikWywolan();
}


