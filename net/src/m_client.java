import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class m_client {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("접속할 아이디를 입력해주세요.");
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
			System.out.println(mid + "님 접속하셨습니다.");
			this.sk = new Socket(this.ip, this.port);
			this.os = this.sk.getOutputStream();
			this.is = this.sk.getInputStream();
			System.out.println("채팅 내용을 입력하는 코드.");

			this.message = mid + ": 내용";
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
			System.out.println("서버 접속 장애");
		}
	}
}