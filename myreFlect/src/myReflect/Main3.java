package myReflect;

import java.lang.reflect.Method;

public class Main3 {
	public static void main(String[] args) {
		Demo3 d3 = new	Demo3();
		Class C = d3.getClass();
		Method[] declaredMethods = C.getDeclaredMethods();
		for(int i=0 ; i<declaredMethods.length ; i++){
			Method method = declaredMethods[i];
			System.out.println("名称为： " + method.getName());
			System.out.println("是否允许带有可变数量的参数： " + method.isVarArgs());
			System.out.println("入口参数类型依次为：　");
			//获取所有参数类型
			Class[] parameterTypes = method.getParameterTypes();
			for(int j=0 ; j<parameterTypes.length ; j++){
				System.out.println("" + parameterTypes[j]);
			}
			//获得方法返回值类型
			System.out.println("返回值类型为：　" + method.getReturnType());
			System.out.println("可能抛出的异常类型有：　" );
			//获得方法可能抛出的所有异常类型
			Class[] exceptionTypes = method.getExceptionTypes();
			for(int j=0 ; j<exceptionTypes.length ; j++){
				System.out.println("" + exceptionTypes[j]);
			}
			boolean isTurn = true;
			while(isTurn){
				try {
					isTurn =false;
					if("staticMethod".equals(method.getName()))
						method.invoke(d3);
					else if("publicMethod".equals(method.getName()))
							System.out.println("返回值为：　" + method.invoke(d3, 168));
					else if("protectedMethod".equals(method.getName()))
						System.out.println("返回值为：　" + method.invoke(d3, "7", 5));
					else if("privateMethod".equals(method.getName())){
						Object[] parameters = new Object[]{		
								new String[]{	
										"M", "W", "Q"
								}
						};
						System.out.println("返回值为：　" + method.invoke(d3, parameters));
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("在执行方法时抛出异常，下面执行setAccessible()");
					method.setAccessible(true);
					isTurn = true;
				}
			}
			System.out.println();
		}
		
	}
}
