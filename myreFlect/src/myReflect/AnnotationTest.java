package myReflect;

public class AnnotationTest{
    /*      
     * @param args
     */
    @SuppressWarnings(":deprecation")
     //�������ע�⣬��Ϊѹ�����棬����JDK�ڲ��Դ���һ��ע�⣬һ��ע�����һ���࣬������ʹ�������ע����Ǵ�����SuppressWarnings���һ��ʵ������
     public static void main(String[] args) {
         System.runFinalizersOnExit(true);
         //The method runFinalizersOnExit(boolean) from the type System is deprecated(��ʱ�ģ�������)
        //�����runFinalizersOnExit()��������һ�����߱�ʾ�˷����Ѿ���ʱ�ˣ�������ʹ����
    }
     @Deprecated //��Ҳ��JDK�ڲ��Դ���һ��ע�⣬��˼����˵��������Ѿ������ˣ�������ʹ����
     public static void sayHello(){
         System.out.println("hi,�°�����");
     }
     @Override //��Ҳ��JDK1.5֮���ڲ��ṩ��һ��ע�⣬��˼����Ҫ��д(����)JDK�ڲ���toString()����
     public String toString(){
         return "�°�����";
     }
}