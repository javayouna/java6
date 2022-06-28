
import java.io.*;
import java.net.*;
public class server1 {
 
 //서버생성
 private ServerSocket server=null;
 //Writer 클라이언트, 서버
 BufferedWriter bw=null;
 //Reader 클라이언트
 BufferedReader br=null;
 //Reader 서버
 BufferedReader br1=null;
 
 server1(){
  try {
   //IP 주소 + 포트 번호 보여주기
   InetAddress ia= InetAddress.getLocalHost();
   System.out.println("IP : "+ia+"에 개설 되었습니다.");
  
   //포트 생성
   server = new ServerSocket(8080);
   //서버 대기
   Socket client = server.accept();
   
   //클라이언트 읽어 오기
   InputStream is = client.getInputStream();
   //클라이언트 뿌려주기
   OutputStream os = client.getOutputStream();
   System.out.println("client와 연결됨");
   
   //client
   br = new BufferedReader(new InputStreamReader(is));
   //server
   br1 = new BufferedReader(new InputStreamReader(System.in));
   bw = new BufferedWriter(new OutputStreamWriter(os));
   
   //client 출력
   String msg="";
   //server 입력
   String msg1="";
   
   while(true){
    //client 메세지 읽어오기
    msg = br.readLine();
    
    //화면단
    if(msg.equals("exit")){
     System.out.println("접속종료");
     break;
    }else{
     //client 출력
     System.out.println("client 말 : "+msg);
     System.out.print(ia+" 님의 말 : ");
     //server 메시지 입력
     msg1 = br1.readLine();
     bw.write(msg1+"\n");
     bw.flush();
    }
    
   }
   
  } catch (UnknownHostException e) {
   e.printStackTrace();
  } catch (IOException e) {
   e.printStackTrace();
  }
  try {
   br.close();
   bw.close();
   server.close();
  } catch (IOException e) {
   e.printStackTrace();
  }
  
    
 }//server2 생성자 종료
 
 //메인 생성 실행
 public static void main(String[] args) {
  new server1();
 }
}