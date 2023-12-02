package pl.edu.pw.mini.zpoif.task5.solution.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface InitiateObject {
	int ilosc() default 1;
}
