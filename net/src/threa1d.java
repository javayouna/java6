//Thread 사용방식
//0629
public class threa1d {

	public static void main(String[] args) {
		/* Extends Thread */
		int w = 0;
		while (w < 6) {
//			box b = new box(w);
//			Thread t = new Thread(b);
//			t.start(); // Thread는 무조건 start사용함
			w++;
		}
		/* interface Runnable Thread */
		for(int f=0;f<10;f++) {
		//쓰레드 메소드호출 해당 클래스에 CPU 한 개를 할당
		box2 b2 = new box2(f); 
		Thread t2 = new Thread(b2); //쓰레드 선언(쓰레드로 작동시킬 클래스명)
		
		t2.start(); //run메소드를 작동시키기 위한 명렁어 
		}
	}
}

//extends
class box extends Thread {
	int no = 0;

	public box(int a) {
		this.no = a;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		System.out.println(this.no);
	}
}

class box2 implements Runnable { // Runnable interface형태의 쓰레드
	int no = 0;
	public box2(int b) {
		this.no=b;
	}
	
	public void run() { //thread의 기본 메소드 (run) 이거 없이는 thread가동 못함 
		try {
			Thread.sleep(1000);
		}
		catch(Exception e) {			
		}
		System.out.println(this.no);
}
}
