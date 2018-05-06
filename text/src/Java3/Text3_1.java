package Java3;
interface myInterface{
		int i=4;
		int k=5;
		void myFunc1();
		int myFunc2(int x);
		}
	class UseInterface implements myInterface{
		int j;
		public void myFunc1(){
		//在使用接口的类中一定要实现接口中的所有抽象方法
		System.out.println("myFunc1="+1); }
		public int myFunc2(int i){
		System.out.println("func2="+1); return i;}
		public static void main(String srgs[]){
		UseInterface x = new UseInterface();
		x.myFunc1();
		x.myFunc2(k);
		}
		}


