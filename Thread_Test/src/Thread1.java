//!!Thread�� ���� class���� ������!!
//extends(class), implement(interface)

public class Thread1 {

	public static void main(String[] args) {

		class_box cb = new class_box();
// ���������� ��� (0~9)
		int dw = 0;
		do {
// cb.run("Ŭ���� ó����Ȳ " + dw);
			dw++;
		} while (dw < 10);

		cpu_box cp = null;
// Thread�� �̿��Ͽ� ���� ó���� ��������� ��� ex)0523169874
		for (int f = 0; f < 10; f++) {
			cp = new cpu_box("������ ó����Ȳ" + f);
// cp.start();
		}

		call_box ca = null;
// Thread�� �̿��Ͽ� ���� ����ó�� ����̸�, ������ �߻��ϴ���
// �ش� ������ �߻��� Thread����ó��. �� �� ������ ��� ó���ϴ� ����
		int w = 0;
		String msg = "";
		String msg2 = "";
		while (w < 10) {
			if (w == 5) {
				msg2 = "5";
			} else {
				msg2 = "";
			}
			ca = new call_box(msg + msg2);
			ca.start();
			w++;
		}
	}
}

class cpu_box extends Thread {
	String name = null;

	public cpu_box(String a) {
		this.name = a;
	}

	@Override
	public void run() { // �����徲�� run �޼ҵ� �������̵�
		System.out.println(this.name);
	}

}

class class_box {

	public void run(String name) {
		System.out.println(name);
	}

}

class call_box extends Thread {
	String callname = null;

	public call_box(String z) {
		this.callname = z;
	}

	@Override
	public void run() {
		try {
			if (this.callname.length() > 0) {
				Exception ec = new Exception();
				throw ec;
// throw new Exception();
			} else {
				System.out.println(this.callname.length());
			}
		} catch (Exception e) {
			System.out.println("�ش� �� �� �߸��� ���� �߻��Ͽ����ϴ�.");
		}
	}
}
