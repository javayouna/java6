import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//0629 ������ �����ߴ� ä�����α׷� ���ƾ��� �����
//�������� ������ �ȵǰ� Ŭ���̾�Ʈ���� ������ �ϱ� 
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
		
		System.out.println("���� ���� ��� ��!");
		System.out.println("ä�ù� �����Ǿ����ϴ٢�");
		
		while(true) {
		this.sk = ss.accept();
		this.is = sk.getInputStream();
		this.os = sk.getOutputStream();
		
		byte[] data = new byte[4072];
		int n = this.is.read(data);
		this.msg = new String(data, 0, n);
		System.out.println(this.msg);
		
		if(this.msg.indexOf("����")!=-1) {
			sk.close();
			sr.close();
			break;
		}			
	
		this.sr = new Scanner(System.in);
		System.out.println("������ �Է��� �ּ���");
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
		System.out.print("[�������� ����Ͻ� ���̵� �Է��� �ּ���] >> ");
		this.nick = Nicck.next();
	}

	public String getName() {
		return this.nick;
	}
}