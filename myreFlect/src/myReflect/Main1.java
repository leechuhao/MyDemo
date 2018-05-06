package myReflect;

import java.lang.reflect.*;

public class Main1 {
	public static void main(String[] args) {
		Demo1 d1 = new Demo1();
		Class exampleC = d1.getClass();
		Constructor[] declaredConstructors = exampleC.getDeclaredConstructors();
		for(int i=0 ; i<declaredConstructors.length ; i++){
			Constructor constructor = declaredConstructors[i];
			System.out.println("�鿴�Ƿ�������пɱ������Ĳ�����  " + constructor.isVarArgs());
			System.out.println("�ù��췽������ڲ�����������Ϊ�� " );
			Class[] parameterTypes = constructor.getParameterTypes();
			for(int j=0; j<parameterTypes.length; j++){
				System.out.println("" + parameterTypes[j]);
			}
			System.out.println("�ù��췽�������׳����쳣����Ϊ �� " );
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
