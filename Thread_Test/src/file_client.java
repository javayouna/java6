import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class file_client {

	public static void main(String[] args) {
		f_client fc = new f_client();
		fc.files();
		
		
	}

}


class f_client {
	Socket sk = null;
	String ip = "127.0.0.1";
	int port = 8005;
	InputStream is = null;
	OutputStream os = null;
	
	public void files() {
		try {	
			this.sk = new Socket(this.ip,this.port);
			
			this.is=this.sk.getInputStream();
			this.os=this.sk.getOutputStream();
			
			String url = "C:\\Orange.jpg";
			FileInputStream fs = new FileInputStream(url);
			BufferedInputStream bs = new BufferedInputStream(fs);
			byte img [] = new byte[bs.available()];
			System.out.println(bs.read(img));
			//System.out.println(fs.read()); //용량이 체크되어야함 
			//this.os.write(url.getBytes());
		}
		catch(Exception e) {
			
		}
	}
}

