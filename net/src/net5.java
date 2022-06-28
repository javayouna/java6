import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//Socket : (양방향) Server, Client :메세지 전달 송수신통신
//HTTP통신 : (단방향) image, 동영상, 음악 사용자(요청)랑 송수신통신
public class net5 {
	//Server
	public static void main(String[] args) {
		System.out.println("Server Connect");
		int port = 8080; //오픈할 포트번호(중복 포트 절대 사용 불가)
		String msg = "Success Connect!!";

		try { //try도 되고 throws도 됨 
			
		ServerSocket ss = new ServerSocket(port); //ServerSocket :오픈시킬 포트 적용
		//연결지속유지하기 위해서는 ServerSocket은 재로드하면 안됩
		//반복문에 socket포함 안 하기
		while(true) {
		System.out.println("연결 대기중....");
		Socket sc = ss.accept(); //accept():클라이언트가 들어오는 것을 대기하는 역할
		System.out.println("호스트:통신 연결 성공");
		/*Server에서 Client로 받는 통로*/ 
		InputStream is = sc.getInputStream();//Client에서 보내는 값을 읽어들임 
		/*Client로 보내는 통로*/
		OutputStream os = sc.getOutputStream();//Client로 값을 전송
		byte data[]=new byte[1024]; //Client에서 받는 값을 byte로 받음 
		int n = is.read(data); //해당 값을 읽어들임
		String msgclient = new String(data,0,n); //해당 값을 배열로 확인,변수이관
		System.out.println(msgclient);//이관된 값을 출력시킴
		
		String aws = "반갑습니다."; //서버에서 보내는 메세지 
		os.write(aws.getBytes()); //클라이언트로 보내기 위한 메모리 저장
		os.flush();
		
		is.close();
		os.close();
		sc.close();
		}
		}
	catch(Exception e) {
		System.out.println("현재 서버 포트가 중복되어 서버를 강제 종료합니다.");
	}

}
}

//-v 
//
//-s
//sh+insert
//net5.java