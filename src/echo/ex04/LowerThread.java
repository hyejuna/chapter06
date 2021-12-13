package echo.ex04;

public class LowerThread extends Thread {
	
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
