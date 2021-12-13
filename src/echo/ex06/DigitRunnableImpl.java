package echo.ex06;

public class DigitRunnableImpl implements Runnable {
	
	public void run() {
		
		for(int n=0; n<=10; n++) {
			System.out.println(n);
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
