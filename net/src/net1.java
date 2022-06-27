import java.net.InetAddress;
import java.net.UnknownHostException;

public class net1 {
	//Terminal = 컨+알+쉽+T
	//백엔드는 그냥 알아야함 그냥 무조건 알아야함 
	//UnknownHostException : HOST 정보가 확인 되지 않을 경우
	public static void main(String[] args) throws Exception { //server에 연결 하기위해
		//InetAddress : IPnetworkAddress
		//getByName : 접속할 도메인 주소명을 말합니다.
		
		InetAddress ia = InetAddress.getByName("localhost"); //!!자기 기본 정보 확인!!
		System.out.println(ia);
		//System.out.println(ia.getHostName()); // 도메인 명 
		//System.out.println(ia.getHostAddress()); //도메인에 Ip주소 

		//System.out.println(ia.toString());
		
		//getAllbyName : 도메인 IP정보 확인 (배열)
		InetAddress[] ia2 = InetAddress.getAllByName("google.com");//배열
		System.out.println(ia2.length); //ip4개 있음 확인
		int w=0;
		while(w<ia2.length) {
			System.out.println(ia2[w].getHostAddress()); //다 출력 
			w++;
		}
		
//		System.out.println(ia2[0].getHostAddress());
//		System.out.println(ia2[1].getHostAddress());
		
		
		
	}
}
