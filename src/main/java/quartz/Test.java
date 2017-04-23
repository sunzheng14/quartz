package quartz;

public class Test {
	public static void main(String[] args) {
		System.out.println("hello");
		Test t = new Test();
		t.test();
	}
	
	public void test(){
		new Thread(new Runnable() {
		public void run() {
			for(int i =0;i<10;i++){
				System.out.println(Thread.currentThread().getName() + "," +i);
				}
			}
		}).start();
	}
}
