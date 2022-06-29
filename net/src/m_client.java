import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class m_client {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ���̵� �Է����ּ���.");
		String user = sc.nextLine();
		chatClient cc = new chatClient(user);
	}
}
class chatClient {
	static final String ip = "127.0.0.1";
	static final int port = 9009;
	Socket sk = null;
	InputStream is = null;
	OutputStream os = null;
	String message = null;
	String result = null;

	public chatClient(String mid) {
		try {
			System.out.println(mid + "�� �����ϼ̽��ϴ�.");
			this.sk = new Socket(this.ip, this.port);
			this.os = this.sk.getOutputStream();
			this.is = this.sk.getInputStream();
			System.out.println("ä�� ������ �Է��ϴ� �ڵ�.");

			this.message = mid + ": ����";
			this.os.write(this.message.getBytes());
			this.os.flush();
			//System.out.println("1");
			
			while (true) {
				byte[] data = new byte[4096];
				int n = this.is.read(data);
				this.result = new String(data, 0, n);
				System.out.println(this.result);
			}
		} catch (Exception q) {
			System.out.println("���� ���� ���");
		}
	}
}