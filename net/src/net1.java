import java.net.InetAddress;
import java.net.UnknownHostException;

public class net1 {
	//Terminal = ��+��+��+T
	//�鿣��� �׳� �˾ƾ��� �׳� ������ �˾ƾ��� 
	//UnknownHostException : HOST ������ Ȯ�� ���� ���� ���
	public static void main(String[] args) throws Exception { //server�� ���� �ϱ�����
		//InetAddress : IPnetworkAddress
		//getByName : ������ ������ �ּҸ��� ���մϴ�.
		
		InetAddress ia = InetAddress.getByName("localhost"); //!!�ڱ� �⺻ ���� Ȯ��!!
		System.out.println(ia);
		//System.out.println(ia.getHostName()); // ������ �� 
		//System.out.println(ia.getHostAddress()); //�����ο� Ip�ּ� 

		//System.out.println(ia.toString());
		
		//getAllbyName : ������ IP���� Ȯ�� (�迭)
		InetAddress[] ia2 = InetAddress.getAllByName("google.com");//�迭
		System.out.println(ia2.length); //ip4�� ���� Ȯ��
		int w=0;
		while(w<ia2.length) {
			System.out.println(ia2[w].getHostAddress()); //�� ��� 
			w++;
		}
		
//		System.out.println(ia2[0].getHostAddress());
//		System.out.println(ia2[1].getHostAddress());
		
		
		
	}
}
