package myReflect;

import java.lang.reflect.Field;

public class Main2 {
	public static void main(String[] args) {
		Demo2 dd = new Demo2();
		Class exampleC = dd.getClass();
		//获取所有成员变量
		Field[] declaredFields = exampleC.getDeclaredFields();
		for(int i=0 ; i<declaredFields.length ; i++){
			Field field = declaredFields[i];
			System.out.println("名称: " + field.getName() );
			Class fieldType = field.getType();
			System.out.println("类型： " + fieldType);
			boolean isTurn = true;
			while(isTurn){
				try {
					isTurn = false;
					System.out.println("修改前的值：" + field.get(dd));
					if(fieldType.equals(int.class)){
						System.out.println("利用方法setInt()修改成员变量的值");
						field.setInt(dd, 168);		//为Int型成员赋值
					}else if(fieldType.equals(float.class)){
						System.out.println("利用方法setFloat()修改成员变量的值");
						field.setFloat(dd, 99.9F);		//为Flaot型成员赋值
					}else if(fieldType.equals(boolean.class)){
						System.out.println("利用方法setBoolean()修改成员变量的值");
						field.setBoolean(dd, true);		//为boolean型成员赋值
					}else{
						System.out.println("利用set()修改成员变量的值");
						field.set(dd, "MWQ");		//为各种类型成员变量赋值						
					}
					System.out.println("修改过的值为： " + field.get(dd) );
				} catch (Exception e) {
					System.out.println("在设置成员变量时抛出异常 ， 下面执行setAccessible（）");
					field.setAccessible(true);
					//获取private属性时要setAccessible(true)
					isTurn = true;
				}
			}
			System.out.println();
		}
		
	}
	
}
