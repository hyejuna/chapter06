package echo.ex03;

public class DigitThread extends Thread {
	
	
	public void run() {
		for (int cnt=0; cnt<=10; cnt++){
			System.out.println(cnt);
			
			try {
				Thread.sleep(1000); // 천천히 진행. Thread.인 이유는 sleep 메소드가 static이라
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		
		}
	}

}
