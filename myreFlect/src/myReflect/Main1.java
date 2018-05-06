package myReflect;

import java.lang.reflect.*;

public class Main1 {
	public static void main(String[] args) {
		Demo1 d1 = new Demo1();
		Class exampleC = d1.getClass();
		Constructor[] declaredConstructors = exampleC.getDeclaredConstructors();
		for(int i=0 ; i<declaredConstructors.length ; i++){
			Constructor constructor = declaredConstructors[i];
			System.out.println("查看是否允许带有可变数量的参数：  " + constructor.isVarArgs());
			System.out.println("该构造方法的入口参数类型依次为： " );
			Class[] parameterTypes = constructor.getParameterTypes();
			for(int j=0; j<parameterTypes.length; j++){
				System.out.println("" + parameterTypes[j]);
			}
			System.out.println("该构造方法可能抛出的异常累心为 ： " );
			Class[] exceptionTypes = constructor.getExceptionTypes();
			for(int j=0; j<exceptionTypes.length; j++){
				System.out.println("" + exceptionTypes[j]);
			}
			Demo1 example = null;
			while(example == null){
				try {
					if(i==2){
						example = (Demo1) constructor.newInstance();
					}else if(i==1){
						example = (Demo1) constructor.newInstance("7", 5);
					}else{
						Object[] parameters = new Object[]{
								new String[]{
										"100", "200", "300"
								}
						};
						example = (Demo1) constructor.newInstance(parameters);
					}
				} catch (Exception e) {
					// TODO: handle exception
					constructor.setAccessible(true);
				}
			}
			example.print();
			System.out.println();
		}
		
	}
		
}
