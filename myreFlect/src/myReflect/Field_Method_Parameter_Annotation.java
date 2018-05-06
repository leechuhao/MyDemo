package myReflect;

import java.lang.annotation.*;
//用于字段、方法和参数
@Target({ElementType.FIELD , ElementType.METHOD , ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
//在运行时加载Annotation到JVM中
public @interface Field_Method_Parameter_Annotation {
	String describe();
	Class type() default void.class;
}
