
public class thread2 {
	//Thread는 결과값이 순차적으로 절대 안나옴 !! 
	public static void main(String[] args) {
			/*[응용문제]
			 *Thread를 이용하여 각 배열의 값을 내림차순으로 모두 더하여 
			 *결과를 출력하는 응용프로그램을 제작하세요.
			 */
		
		/*힌트 : 6이라는 배열값이 인수값으로 Thread로 전달
		  6+5+4+3+1 print
		  9+8+7+6+5+4+3+2+1
		 */	
		
		
		
		int data[]= {6,9,10,15,3,17};
		int ea = data.length;
		plusbox pb = null;
		for(int a=0; a<ea; a++) {
			pb = new plusbox(data[a]);
			pb.start();
		}
		
		
		// cb = new call_box(data[]);
		
		
		
}
}

class plusbox extends Thread {
	int number = 0;
	
	public plusbox(int no) { //Thread에서 값을 사용하기 위한 기본 method
		this.number = no;
	}
	@Override
	public void run() { //run메소드는 절대 인수값 못받음!
	//반복문 	
		int sum=0;
		for(int z=this.number; z>0; z--) {
			sum+=z;
		}
		System.out.println(sum);
		
	
}
}