//!!Thread는 메인 class에서 사용안함!!
//extends(class), implement(interface)

public class Thread1 {

	public static void main(String[] args) {

		class_box cb = new class_box();
// 순차적으로 출력 (0~9)
		int dw = 0;
		do {
// cb.run("클래스 처리현황 " + dw);
			dw++;
		} while (dw < 10);

		cpu_box cp = null;
// Thread를 이용하여 먼저 처리된 결과순으로 출력 ex)0523169874
		for (int f = 0; f < 10; f++) {
			cp = new cpu_box("쓰레드 처리현황" + f);
// cp.start();
		}

		call_box ca = null;
// Thread를 이용하여 강제 예외처리 방식이며, 문제가 발생하더라도
// 해단 문제가 발생한 Thread예외처리. 그 외 사항은 모두 처리하는 예시
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
	public void run() { // 쓰레드쓰면 run 메소드 오버라이드
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
			System.out.println("해당 값 중 잘못된 값이 발생하였습니다.");
		}
	}
}
