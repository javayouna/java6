import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//Server�� �������� ��Ʈ ���� 8001,8002
//Exception : bind Exception (PORT �浹)

public class chat_server {

	public static void main(String[] args) {
		
		int port = 8003;
		openchat oc =null;
		oc = new openchat(port);
		oc.start();
		
		/* ��Ʈ�� 2���� ���
		 * int port[] = {8001,8002};
		 *
		int ea = port.length;
		int w = 0;
		openchat oc = null;
		while (w < ea) {
			oc = new openchat(port[w]);
			oc.start();
			w++;
		}*/
	}
}

class openchat extends Thread {
	String ip = "127.0.0.1";
	int pt = 0;
	ServerSocket sk = null;
	InputStream is = null;
	OutputStream os = null;
	
	public openchat(int p) {
		this.pt = p;
	}
	@Override
	public void run() {
		try {
			this.sk = new ServerSocket(this.pt);//��� �ݺ��� �ۿ� �־�� OK
			while(true) {
			Socket s= this.sk.accept(); //�ش� port ��� ����
			
			this.is = s.getInputStream();
			this.os = s.getOutputStream();		
			//System.out.println("��������");
			
			/*Ŭ���̾�Ʈ���� �޴� �޼��� */
			byte[] data = new byte[1024];
			int n = is.read(data);
			String message = new String(data,0,n);
			System.out.println(message);		
			
			//Scanner sc = new Scanner(System.in);		
			}
		}catch(Exception e) {
			System.out.println(e);
		}		
	}
}
