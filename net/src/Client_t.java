/*���빮�� Ŭ���̾�Ʈ exit�ܾ� �Է��ϸ� OOO���� �����ϼ̽��ϴ�.
  Ŭ���̾�Ʈ������ ä�� ����+���������� ä������*/

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
	String msg = null; // ����� �Է�
	String msg2 = null; // ����޼���
	String smsg = null; // ������ �����ϴ� �޼���
	String check=null;// exit �ܾ� ����

	public void chat() {
//! ���� Stream�� close���� �ʽ��ϴ�. �ֳ��ϸ�, ��� Stream�� ���ϰ� ����Ǿ�����
//! �׷��� close�� ���ϵ� �Բ� ����˴ϴ�.
//! Socket�� �� �����Ͱ� ����Ǹ� ������ ������ 

		try {
			this.sc = new Scanner(System.in);
			System.out.println("���̵� �������ּ���.");
			this.mid = this.sc.next();

			int c = 0;
			while (true) {

				this.sk = new Socket(this.ip, this.port);
				this.is = this.sk.getInputStream();
				this.os = this.sk.getOutputStream();

				
				
				if (c == 0) { // �����ϼ̽��ϴٰ� �ѹ��� �߰��ϱ�.
					this.msg = "[" + this.mid + "]: �� �����Ͽ����ϴ�.";
				} else {
					this.sc = new Scanner(System.in);
					System.out.println("������ �Է����ּ���: ");
					this.check =this.sc.nextLine().intern();
					this.msg = "[" + this.mid + "]:" + this.sc.nextLine().intern();
				
				}
					if(this.check=="exit"){
						this.msg="[" + this.mid + "]: ���� �����ϼ̽��ϴ�.";
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
				this.os.flush(); //�갡 �ؿ� ������ �Ͻ������Ǵ� 

				byte data[] = new byte[1024];
				int n = this.is.read(data);
				this.smsg = new String(data, 0, n);
				System.out.println(this.smsg);
				c++;
				
			}

		} catch (Exception e) {
			System.out.println(e); //error�޼��� �������� cmdâ�� ���� �޼�����
			//indexo ����ؼ� �� �� ������ ������ ���� �� �� ���� 
		}
		
		
		
	}
}
