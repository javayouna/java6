import java.net.*;
import java.io.*;
public class client1 {
 //소켓 생성
 private Socket cli=null;
 //Writer 클라이언트, 서버
 BufferedWriter bw=null;
 //Reader 클라이언트
 BufferedReader br=null;
 //Reader 서버
 BufferedReader br1=null;
 
 client1(String ip,int port){
  try {
   //서버 연결
   cli = new Socket(ip,port);
   System.out.println("서버와 연결되었습니다.");
   
   InputStream is1 = cli.getInputStream();
   OutputStream os1 =  cli.getOutputStream();
   
   //client
   br = new BufferedReader(new InputStreamReader(System.in));
   //server
   br1 = new BufferedReader(new InputStreamReader(is1));
   bw =  new BufferedWriter(new OutputStreamWriter(os1));
   
   //server 메세지 
   String msg="";
   //client 메세지
   String msg1="";
   
  do{
   //화면단
   //client 메세지 입력
   System.out.print("할말 : ");
   msg1 = br.readLine();
   bw.write(msg1+"\n");
   bw.flush();
   //server 메세지 출력
   msg=br1.readLine();
   System.out.println("서버 : "+msg);
    
   }while(!(msg1.equals("exit")));
   
  } catch (UnknownHostException e) {
   e.printStackTrace();
  } catch (IOException e) {
   e.printStackTrace();
  }
  
  try {
   bw.close();
   br.close();
   cli.close();
  } catch (IOException e) {
   e.printStackTrace();
   
   
  }
 }
 
 public static void main(String args[]){
  new client1("127.0.0.1", 8080);
 }
 
}