//Thread �����
//0629
public class threa1d {

	public static void main(String[] args) {
		/* Extends Thread */
		int w = 0;
		while (w < 6) {
//			box b = new box(w);
//			Thread t = new Thread(b);
//			t.start(); // Thread�� ������ start�����
			w++;
		}
		/* interface Runnable Thread */
		for(int f=0;f<10;f++) {
		//������ �޼ҵ�ȣ�� �ش� Ŭ������ CPU �� ���� �Ҵ�
		box2 b2 = new box2(f); 
		Thread t2 = new Thread(b2); //������ ����(������� �۵���ų Ŭ������)
		
		t2.start(); //run�޼ҵ带 �۵���Ű�� ���� ���� 
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

class box2 implements Runnable { // Runnable interface������ ������
	int no = 0;
	public box2(int b) {
		this.no=b;
	}
	
	public void run() { //thread�� �⺻ �޼ҵ� (run) �̰� ���̴� thread���� ���� 
		try {
			Thread.sleep(1000);
		}
		catch(Exception e) {			
		}
		System.out.println(this.no);
}
}
