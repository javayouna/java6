import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class m_server {

	public static void main(String[] args) {
		chatroom cr = new chatroom();
	}
}
class chatroom { // 기본사항 ->각 접속마다 thread를 분할
	ServerSocket server = null;
	static final int port = 9009;// Thread에서 공용 사용하기 위해!
	Socket sk = null;

	public chatroom() {
		try {
			this.server = new ServerSocket(this.port);

		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("****멀티 채팅 시작!!****");
		while (true) {
			try {
				sk = this.server.accept(); // 클라이언트 접속 허가 부분
				chat_thread ct = new chat_thread(sk); // accept 정보 보내기
				Thread t = new Thread(ct);
				t.start();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}
}

class chat_thread implements Runnable {
	Socket sk = null;
	InputStream is = null;
	OutputStream os = null;
	String message = null;
	String result = null;
	Scanner sc = null;
	
	//!!배열을 메모리에 기억시킴 이유? 누적시켜야하니까요!!!//
	//접속자 발생시 thread가 새롭게 생성되어서 static에 올리지 않으면 누적 없이
	//계속 1로만 저장 
	static ArrayList<Socket> user=new ArrayList<>();//접속자 주거을 시켜야하니까 static
	
	public chat_thread(Socket s) { // 여기에다가 t를 넣으려고함 port 넘기려고
		this.sk = s; // 너의 역할은 끝났단다
		this.user.add(this.sk); //소켓을 배열에 추가 
		
		
		try {
			System.out.println("채팅에 참여 하셨습니다.");
			System.out.println(this.sk);//접속자 정보?
			this.is = this.sk.getInputStream(); // 가져오기(읽기)
			this.os = this.sk.getOutputStream();// 내보내기(쓰기)
		} catch (Exception e) {
			System.out.println("클라이언트 접속 정보가 올바르지않습니다.");
		}
	}

	@Override
	public void run() {
		try {
				byte data[] = new byte[1024];
				int n = this.is.read(data);
				this.message = new String(data, 0, n);
				System.out.println(this.message);
				
				
				while (true) {
				System.out.println(this.user.size());
				this.sc = new Scanner(System.in);//
				System.out.println("보낼 메세지를 입력하세요: ");
				this.result = sc.nextLine();
				
				/*배열에 있는 vport 정보를 담은 수 만큼 반복함*/
				for(int j=0;j<this.user.size();j++) { 
				//배열에있는 사용자 vport로 전송을 하게 됩니다.
				OutputStream all = this.user.get(j).getOutputStream();
				//사용자별로 Stream 생성 
				all.write(this.result.getBytes()); //전송
				all.flush(); //해당 전송 메세지를 비움(메모리)
				
				
				//this.os.write(this.result.getBytes());
				//this.os.flush();
				} 
				 /*
				   this.os.write(this.message.getBytes()); //회신
				   this.os.flush();
				   Thread.sleep(10000);
				   String m = "관리자메세지출력!!"; //client애들한테 공지
				   this.os.write(m.getBytes());
				   this.os.flush();
				   */
			}
		} catch (Exception a) {
			System.out.println("클라이언트가 종료되었습니다.");
		} finally {
			try {
				this.is.close();
				this.os.close();
				this.sk.close();

			} catch (Exception e) {

			}
		}
	}

}
