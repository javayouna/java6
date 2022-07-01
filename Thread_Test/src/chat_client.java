import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class chat_client {
	//8001
	public static void main(String[] args) {
		port_chat pc = new port_chat();
		pc.connect();
		

	}

}
class port_chat{
	String ip = "127.0.0.1";
	int port = 8001; //서버에서 오픈한 포트
	InputStream is = null;
	OutputStream os =null;
	String msg = "";
	Socket sc = null;
	public void connect() {
		
		try {
			while(true) {
			this.sc = new Socket(this.ip,this.port);//이게 반복문 밖에 있으면 스캐너 한번 입력후 끊김 (?)
			this.is =this.sc.getInputStream();
			this.os =this.sc.getOutputStream();
			
			/*서버로 해당 메세지를 전송*/
			this.msg = "클라이언트"+port;
			this.os.write(this.msg.getBytes());
			this.os.flush();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("내용입력: ");
			String say =sc.nextLine();
			this.os.write(say.getBytes());
			this.os.flush();
			
			//System.out.println(say);
			}
		}catch(Exception e) {
			
		}
	}
}