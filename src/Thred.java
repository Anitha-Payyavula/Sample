

public class Thred {
	public static void main(String args[]) {
		Hi obj=new Hi();
		Hi obj1=new Hi();
		obj.start();
		obj1.start();
		
	}

}
class Hi extends Thread {
	public void run() {
		for(int i=0;i<4;i++) {
			System.out.println("hi"+currentThread().getId());
		}
	}
	
}
