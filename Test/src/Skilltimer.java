
public class Skilltimer extends Thread{
	int i=0;
	public void run() {
		try {
			while(true) {
				i++;
				this.sleep(20);
				if(i == 7)
					break;
			}
		} catch (Exception e) {
			
		}
		
	}
}
