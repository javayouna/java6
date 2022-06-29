/*응용문제 클라이언트 exit단어 입력하면 OOO님이 퇴장하셨습니다.
  클라이언트에서도 채팅 종료+서버에서도 채팅종료*/

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Client_t {
	public static void main(String[] args) {

		try {
			Client_chat cc = new Client_chat();
			cc.chat();
		} catch (Exception a) {
			if (a.getMessage() != null) {
				System.out.println(a);
			}
		}
	}
}

class Client_chat {
	private final String ip = "192.168.100.138";
	final int port = 8009;
	Scanner sc = null;
	InputStream is = null;
	OutputStream os = null;
	private String mid = null;
	Socket sk = null;
	String msg = null; // 사용자 입력
	String msg2 = null; // 입장메세지
	String smsg = null; // 서버로 전송하는 메세지
	String check=null;// exit 단어 검토

	public void chat() {
//! 각종 Stream을 close하지 않습니다. 왜냐하면, 모든 Stream이 소켓과 연결되어있음
//! 그래서 close시 소켓도 함께 종료됩니다.
//! Socket은 본 데이터가 변경되면 접속이 끊어짐 

		try {
			this.sc = new Scanner(System.in);
			System.out.println("아이디를 생성해주세요.");
			this.mid = this.sc.next();

			int c = 0;
			while (true) {

				this.sk = new Socket(this.ip, this.port);
				this.is = this.sk.getInputStream();
				this.os = this.sk.getOutputStream();

				
				
				if (c == 0) { // 입장하셨습니다가 한번만 뜨게하기.
					this.msg = "[" + this.mid + "]: 님 입장하였습니다.";
				} else {
					this.sc = new Scanner(System.in);
					System.out.println("내용을 입력해주세요: ");
					this.check =this.sc.nextLine().intern();
					this.msg = "[" + this.mid + "]:" + this.sc.nextLine().intern();
				
				}
					if(this.check=="exit"){
						this.msg="[" + this.mid + "]: 님이 퇴장하셨습니다.";
						this.os.write(this.msg.getBytes());
						this.os.flush();
						this.is.close();
						this.os.close();
						this.sk.close();
					}
					
					else {
						this.os.write(this.msg.getBytes());
						this.os.flush();
		
				}
				this.os.write(this.msg.getBytes());
				this.os.flush(); //얘가 밑에 있으면 일시정지되는 

				byte data[] = new byte[1024];
				int n = this.is.read(data);
				this.smsg = new String(data, 0, n);
				System.out.println(this.smsg);
				c++;
				
			}

		} catch (Exception e) {
			System.out.println(e); //error메세지 설정가능 cmd창의 오류 메세지를
			//indexo 사용해서 뜰 떄 나오는 문구로 설정 할 수 있음 
		}
		
		
		
	}
}
