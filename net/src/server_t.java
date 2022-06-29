import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//0629 시작점 어제했던 채팅프로그램 갈아엎고 재시작
//서버에서 나가면 안되고 클라이언트에서 나가게 하기 
public class server_t {

	public static void main(String[] args) throws Exception {
		chat ch = new chat();
		ch.chattingserver();
	}
}

class chat {
	private int port = 8009;
	ServerSocket ss = null;
	Socket sk = null;
	Scanner sr = null;
	InputStream is = null;
	OutputStream os = null;
	private String msg = null;
	private String cmsg = null;

	public void chattingserver() throws IOException  {
		this.ss = new ServerSocket(port);
		this.sr = new Scanner(System.in);
		nickName nnm = new nickName();
		nnm.setName();
		
		System.out.println("서버 연결 대기 중!");
		System.out.println("채팅방 개설되었습니다♡");
		
		while(true) {
		this.sk = ss.accept();
		this.is = sk.getInputStream();
		this.os = sk.getOutputStream();
		
		byte[] data = new byte[4072];
		int n = this.is.read(data);
		this.msg = new String(data, 0, n);
		System.out.println(this.msg);
		
		if(this.msg.indexOf("퇴장")!=-1) {
			sk.close();
			sr.close();
			break;
		}			
	
		this.sr = new Scanner(System.in);
		System.out.println("내용을 입력해 주세요");
		this.cmsg = "["+nnm.getName()+"]:"+ this.sr.nextLine().intern();
		this.os.write(this.cmsg.getBytes());
		this.os.flush();
		}
		
		
	}
}

class nickName {
	String nick = null;

	public void setName() {
		Scanner Nicck = new Scanner(System.in);
		System.out.print("[서버에서 사용하실 아이디를 입력해 주세요] >> ");
		this.nick = Nicck.next();
	}

	public String getName() {
		return this.nick;
	}
}