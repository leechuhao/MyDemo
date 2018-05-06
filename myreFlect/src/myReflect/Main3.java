package myReflect;

import java.lang.reflect.Method;

public class Main3 {
	public static void main(String[] args) {
		Demo3 d3 = new	Demo3();
		Class C = d3.getClass();
		Method[] declaredMethods = C.getDeclaredMethods();
		for(int i=0 ; i<declaredMethods.length ; i++){
			Method method = declaredMethods[i];
			System.out.println("����Ϊ�� " + method.getName());
			System.out.println("�Ƿ�������пɱ������Ĳ����� " + method.isVarArgs());
			System.out.println("��ڲ�����������Ϊ����");
			//��ȡ���в�������
			Class[] parameterTypes = method.getParameterTypes();
			for(int j=0 ; j<parameterTypes.length ; j++){
				System.out.println("" + parameterTypes[j]);
			}
			//��÷�������ֵ����
			System.out.println("����ֵ����Ϊ����" + method.getReturnType());
			System.out.println("�����׳����쳣�����У���" );
			//��÷��������׳��������쳣����
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
							System.out.println("����ֵΪ����" + method.invoke(d3, 168));
					else if("protectedMethod".equals(method.getName()))
						System.out.println("����ֵΪ����" + method.invoke(d3, "7", 5));
					else if("privateMethod".equals(method.getName())){
						Object[] parameters = new Object[]{		
								new String[]{	
										"M", "W", "Q"
								}
						};
						System.out.println("����ֵΪ����" + method.invoke(d3, parameters));
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("��ִ�з���ʱ�׳��쳣������ִ��setAccessible()");
					method.setAccessible(true);
					isTurn = true;
				}
			}
			System.out.println();
		}
		
	}
}
