import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/*전송 형태 프로토콜*/
//TCP(연결 프로토콜) -전송 속도 빠름 ,
//UDP(사용자 데이터 프로토콜) - 전송 속도 느림 1:1경우 굉장히 빠름 ex)스타크래프트
/*PORT (TCP)
 80 : WEB 가상으로 만든 포트 (http://) 
 21 : FTP 포트  
 22 : SSH - Linux, Unix (파일전송, 서버외부접속)
 23 : TELNET - Window
 443 : WEB (http://) 
 25 : SMTP (메일서버) - 메일 보내기
 110 : POP3 (메일받기) - 문자, 파일 받기 (비동기화)
 143 : IMAP (메일받기) - 문자, 파일 받기  (서버와 동기화)
 */
/* SNMP : UDP(문자발송시스템) , VPN(가상IP)- UDP*/

public class net2 {
	public static void main(String[] args) throws Exception{
		
		Scanner sc= new Scanner(System.in);
		System.out.println("웹에서 가져올 이미지주소를 입력해주세요.");
		String url = sc.next();
		//String url = "~~";
		URL u = new URL(url); //URL9클래스) : 네트워크 경로를 말합니다.
		
		
		URLConnection con = u.openConnection(); //해당 경로를 연결
		int imgsize = con.getContentLength(); //indexOf -1은 없음,그 외에는 파일 확인 
		String imgtype=con.getContentType(); //Type 확인 
		
		System.out.println(imgsize);
		System.out.println(imgtype);
		
		long data=con.getDate();// 파일 로드 날짜 
		System.out.println(data);
		
		//openStream():URL에만 사용 
		InputStream is =u.openStream(); //!URL에서만! 파일을 읽어올 때 사용함
		BufferedInputStream bi = new BufferedInputStream(is); //URL에서 읽은 파일을 임시저장 
		byte data1[] = new byte[1024]; //1024=1KB 해당 파일을 조각냄
		FileOutputStream fo = new FileOutputStream("copy.jpg");
		int imgdata=0;
		int cnt=0; //반복값 체크 
		
		while((imgdata=bi.read(data1))!=-1) {
			fo.write(data1,0,imgdata); //조각난 파일을 붙여넣기하는 상태 
			cnt+=imgdata; //1024++
			System.out.println("다운로드중...."+(cnt*100)/imgsize+"%");
		}
			fo.flush();
			fo.close();
		//fo.write(bi.read(data1));
		System.out.println("다운로드가 완료 되었습니다.");
		
	}

}
