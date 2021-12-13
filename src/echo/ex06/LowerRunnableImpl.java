package echo.ex06;

public class LowerRunnableImpl implements Runnable {
	
public void run() {
		
		for(char ch='a'; ch<='z'; ch++) {
			System.out.println(ch);
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
