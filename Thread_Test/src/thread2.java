
public class thread2 {
	//Thread�� ������� ���������� ���� �ȳ��� !! 
	public static void main(String[] args) {
			/*[���빮��]
			 *Thread�� �̿��Ͽ� �� �迭�� ���� ������������ ��� ���Ͽ� 
			 *����� ����ϴ� �������α׷��� �����ϼ���.
			 */
		
		/*��Ʈ : 6�̶�� �迭���� �μ������� Thread�� ����
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
	
	public plusbox(int no) { //Thread���� ���� ����ϱ� ���� �⺻ method
		this.number = no;
	}
	@Override
	public void run() { //run�޼ҵ�� ���� �μ��� ������!
	//�ݺ��� 	
		int sum=0;
		for(int z=this.number; z>0; z--) {
			sum+=z;
		}
		System.out.println(sum);
		
	
}
}