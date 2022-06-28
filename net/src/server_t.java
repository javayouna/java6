import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//Server
public class server_t {

	static ServerSocket server_sock = null; //Socket만 클래스안으로!!
	static Scanner sc=null;
	static InputStream is = null;
	static OutputStream os = null;
	static byte[] data = null;
	static String mid = null;
	
	
	public static void main(String[] args) {
		int port = 9090;
		
		try {
		server_sock= new ServerSocket(port);
		sc = new Scanner(System.in);
		System.out.println("서버에서 사용하실 아이디를 입력해주세요.");
		mid = sc.next();
		//sc.close();
		System.out.println("대기중.....");
		
		while(true) {
		Socket sk = server_sock.accept();
		System.out.println("내용을 입력해주세요.");
		String msg ="["+mid+"]"+sc.nextLine();

		is =sk.getInputStream();
		os =sk.getOutputStream();
		
		os.write(msg.getBytes());
		os.flush();
		
		byte[]data=new byte[1024];
		int arr =is.read(data);
		String message = new String(data,0,arr);
		is.close();
		os.close();
		sc.close();
			
		}
		
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
	}

}
