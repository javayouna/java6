import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

//0628 ũ�Ѹ�2
public class net4 {

	public static void main(String[] args) throws Exception{
	
		String page= "https://www.kr.playblackdesert.com/ko-KR/Main/Index";
		URL url = new URL(page);
		/* !Stream�ܾ ���� read�� ��� ������ int�߾�~(Byte �̿�), Reader readLine (String)! */
		/* !flush(): BufferedOUtputStream�� ��� ! */
		InputStream is = url.openStream(); //net������ ��� 
		BufferedInputStream bs = new BufferedInputStream(is); //�迭 byte[]
		byte html[]=new byte[is.available()]; //1024�ᵵ�� 
		//FileOutputStream fs = new FileOutputStream("game.html"); //���1) �迭 �� �ε� ���� 
		BufferedOutputStream fs = new BufferedOutputStream(new FileOutputStream("gamae.html")); //���2) �̰͵� ���� �ӵ�����.
		
		int s = 0;
		while((s=bs.read(html))!=-1) { 	//Stream�� read�� byte�迭�� �Է� 				//String = "null" int = -1;
			fs.write(html,0,s);
			//System.out.println(s);
		}
		//is.close(); //��� �� �ص� ����
		fs.flush();
		bs.close(); //
		fs.close(); //��� �� �ݾ��ֱ�
 //		FileWriter //�ҷ��� ���� Stream�̾ FileWriter�� ���� ����
 //		System.out.println(); //readLine�� ����
		
		
	}

}
