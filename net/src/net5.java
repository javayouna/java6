import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//Socket : (�����) Server, Client :�޼��� ���� �ۼ������
//HTTP��� : (�ܹ���) image, ������, ���� �����(��û)�� �ۼ������
public class net5 {
	//Server
	public static void main(String[] args) {
		System.out.println("Server Connect");
		int port = 8080; //������ ��Ʈ��ȣ(�ߺ� ��Ʈ ���� ��� �Ұ�)
		String msg = "Success Connect!!";

		try { //try�� �ǰ� throws�� �� 
			
		ServerSocket ss = new ServerSocket(port); //ServerSocket :���½�ų ��Ʈ ����
		//�������������ϱ� ���ؼ��� ServerSocket�� ��ε��ϸ� �ȵ�
		//�ݺ����� socket���� �� �ϱ�
		while(true) {
		System.out.println("���� �����....");
		Socket sc = ss.accept(); //accept():Ŭ���̾�Ʈ�� ������ ���� ����ϴ� ����
		System.out.println("ȣ��Ʈ:��� ���� ����");
		/*Server���� Client�� �޴� ���*/ 
		InputStream is = sc.getInputStream();//Client���� ������ ���� �о���� 
		/*Client�� ������ ���*/
		OutputStream os = sc.getOutputStream();//Client�� ���� ����
		byte data[]=new byte[1024]; //Client���� �޴� ���� byte�� ���� 
		int n = is.read(data); //�ش� ���� �о����
		String msgclient = new String(data,0,n); //�ش� ���� �迭�� Ȯ��,�����̰�
		System.out.println(msgclient);//�̰��� ���� ��½�Ŵ
		
		String aws = "�ݰ����ϴ�."; //�������� ������ �޼��� 
		os.write(aws.getBytes()); //Ŭ���̾�Ʈ�� ������ ���� �޸� ����
		os.flush();
		
		is.close();
		os.close();
		sc.close();
		}
		}
	catch(Exception e) {
		System.out.println("���� ���� ��Ʈ�� �ߺ��Ǿ� ������ ���� �����մϴ�.");
	}

}
}

//-v 
//
//-s
//sh+insert
//net5.java