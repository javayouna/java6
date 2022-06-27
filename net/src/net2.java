import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/*���� ���� ��������*/
//TCP(���� ��������) -���� �ӵ� ���� ,
//UDP(����� ������ ��������) - ���� �ӵ� ���� 1:1��� ������ ���� ex)��Ÿũ����Ʈ
/*PORT (TCP)
 80 : WEB �������� ���� ��Ʈ (http://) 
 21 : FTP ��Ʈ  
 22 : SSH - Linux, Unix (��������, �����ܺ�����)
 23 : TELNET - Window
 443 : WEB (http://) 
 25 : SMTP (���ϼ���) - ���� ������
 110 : POP3 (���Ϲޱ�) - ����, ���� �ޱ� (�񵿱�ȭ)
 143 : IMAP (���Ϲޱ�) - ����, ���� �ޱ�  (������ ����ȭ)
 */
/* SNMP : UDP(���ڹ߼۽ý���) , VPN(����IP)- UDP*/

public class net2 {
	public static void main(String[] args) throws Exception{
		
		Scanner sc= new Scanner(System.in);
		System.out.println("������ ������ �̹����ּҸ� �Է����ּ���.");
		String url = sc.next();
		//String url = "~~";
		URL u = new URL(url); //URL9Ŭ����) : ��Ʈ��ũ ��θ� ���մϴ�.
		
		
		URLConnection con = u.openConnection(); //�ش� ��θ� ����
		int imgsize = con.getContentLength(); //indexOf -1�� ����,�� �ܿ��� ���� Ȯ�� 
		String imgtype=con.getContentType(); //Type Ȯ�� 
		
		System.out.println(imgsize);
		System.out.println(imgtype);
		
		long data=con.getDate();// ���� �ε� ��¥ 
		System.out.println(data);
		
		//openStream():URL���� ��� 
		InputStream is =u.openStream(); //!URL������! ������ �о�� �� �����
		BufferedInputStream bi = new BufferedInputStream(is); //URL���� ���� ������ �ӽ����� 
		byte data1[] = new byte[1024]; //1024=1KB �ش� ������ ������
		FileOutputStream fo = new FileOutputStream("copy.jpg");
		int imgdata=0;
		int cnt=0; //�ݺ��� üũ 
		
		while((imgdata=bi.read(data1))!=-1) {
			fo.write(data1,0,imgdata); //������ ������ �ٿ��ֱ��ϴ� ���� 
			cnt+=imgdata; //1024++
			System.out.println("�ٿ�ε���...."+(cnt*100)/imgsize+"%");
		}
			fo.flush();
			fo.close();
		//fo.write(bi.read(data1));
		System.out.println("�ٿ�ε尡 �Ϸ� �Ǿ����ϴ�.");
		
	}

}
