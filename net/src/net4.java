import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

//0628 크롤링2
public class net4 {

	public static void main(String[] args) throws Exception{
	
		String page= "https://www.kr.playblackdesert.com/ko-KR/Main/Index";
		URL url = new URL(page);
		/* !Stream단어가 들어가면 read만 사용 무조건 int야아~(Byte 이용), Reader readLine (String)! */
		/* !flush(): BufferedOUtputStream때 사용 ! */
		InputStream is = url.openStream(); //net에서만 사용 
		BufferedInputStream bs = new BufferedInputStream(is); //배열 byte[]
		byte html[]=new byte[is.available()]; //1024써도됨 
		//FileOutputStream fs = new FileOutputStream("game.html"); //방법1) 배열 값 로드 저장 
		BufferedOutputStream fs = new BufferedOutputStream(new FileOutputStream("gamae.html")); //방법2) 이것도 가능 속도차이.
		
		int s = 0;
		while((s=bs.read(html))!=-1) { 	//Stream은 read에 byte배열명 입력 				//String = "null" int = -1;
			fs.write(html,0,s);
			//System.out.println(s);
		}
		//is.close(); //얘는 안 해도 무방
		fs.flush();
		bs.close(); //
		fs.close(); //얘는 꼭 닫아주기
 //		FileWriter //불러올 때는 Stream이어도 FileWriter로 저장 가능
 //		System.out.println(); //readLine은 못씀
		
		
	}

}
