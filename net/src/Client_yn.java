import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client_yn {

	public static void main(String[] args) {
		
		String ip="192.168.1.117";
		int port = 9090;
		Scanner sn = null;
		OutputStream os= null;
		InputStream is = null;
		Socket sc = null;	
		String notice =null;
	
		try {
			sc=new Socket(ip,port);
			System.out.println("채팅에 사용하실 아이디를 입력해주세요.");
			String user=sn.nextLine();
			for(;;) {
				sn=new Scanner(System.in);
				notice=sn.nextLine();
				is=sc.getInputStream();
				os=sc.getOutputStream();
				System.out.println("내용을 입력해주세요");
				String msg = user+" : "+notice;
				/* String word = sc2.nextLine().intern();
				 * if(word=="exit")
				 * system.exit(0)
				 * 
				 */
				os.write(msg.getBytes());
				os.flush();
				
				byte[]data= new byte[1024];
				int n=is.read(data);
				String cmsg = new String(data,0,n);
				System.out.println(cmsg);
				//indexOf(exit) != -1
				if(msg.equals("exit")){
					String memo=user+"님이 퇴장하셨습니다.";
					os.write(memo.getBytes());
					//os.write(msg.getBytes());
					os.close();
					is.close();
					sc.close();
					break;
					}
				
			}
		}
		catch(Exception e) {
			System.out.println("채팅이 종료되었습니다.");
	
		}
		
		
		
	}

}
