import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class chat_client2 {
	//8002
	public static void main(String[] args) {
		port_chat2 pc = new port_chat2();
		pc.connect();
		
	}

}
class port_chat2{
	String ip = "127.0.0.1";
	int port = 8002;
	InputStream is = null;
	OutputStream os =null;
	String msg = "";
	Socket sc = null;
	public void connect() {
		
		try {
			this.sc = new Socket(this.ip,this.port);
			while(true) {
			this.is =this.sc.getInputStream();
			this.os =this.sc.getOutputStream();
			this.msg = "클라이언트"+port;
			this.os.write(this.msg.getBytes());
			this.os.flush();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("내용입력: ");
			String say =sc.nextLine();
			this.os.write(say.getBytes());
			this.os.flush();
			}
		}catch(Exception e) {
			
		}
	}
}