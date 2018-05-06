package myReflect;

import java.lang.reflect.Field;

public class Main2 {
	public static void main(String[] args) {
		Demo2 dd = new Demo2();
		Class exampleC = dd.getClass();
		//��ȡ���г�Ա����
		Field[] declaredFields = exampleC.getDeclaredFields();
		for(int i=0 ; i<declaredFields.length ; i++){
			Field field = declaredFields[i];
			System.out.println("����: " + field.getName() );
			Class fieldType = field.getType();
			System.out.println("���ͣ� " + fieldType);
			boolean isTurn = true;
			while(isTurn){
				try {
					isTurn = false;
					System.out.println("�޸�ǰ��ֵ��" + field.get(dd));
					if(fieldType.equals(int.class)){
						System.out.println("���÷���setInt()�޸ĳ�Ա������ֵ");
						field.setInt(dd, 168);		//ΪInt�ͳ�Ա��ֵ
					}else if(fieldType.equals(float.class)){
						System.out.println("���÷���setFloat()�޸ĳ�Ա������ֵ");
						field.setFloat(dd, 99.9F);		//ΪFlaot�ͳ�Ա��ֵ
					}else if(fieldType.equals(boolean.class)){
						System.out.println("���÷���setBoolean()�޸ĳ�Ա������ֵ");
						field.setBoolean(dd, true);		//Ϊboolean�ͳ�Ա��ֵ
					}else{
						System.out.println("����set()�޸ĳ�Ա������ֵ");
						field.set(dd, "MWQ");		//Ϊ�������ͳ�Ա������ֵ						
					}
					System.out.println("�޸Ĺ���ֵΪ�� " + field.get(dd) );
				} catch (Exception e) {
					System.out.println("�����ó�Ա����ʱ�׳��쳣 �� ����ִ��setAccessible����");
					field.setAccessible(true);
					//��ȡprivate����ʱҪsetAccessible(true)
					isTurn = true;
				}
			}
			System.out.println();
		}
		
	}
	
}
