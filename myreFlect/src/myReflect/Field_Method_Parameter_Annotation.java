package myReflect;

import java.lang.annotation.*;
//�����ֶΡ������Ͳ���
@Target({ElementType.FIELD , ElementType.METHOD , ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
//������ʱ����Annotation��JVM��
public @interface Field_Method_Parameter_Annotation {
	String describe();
	Class type() default void.class;
}
