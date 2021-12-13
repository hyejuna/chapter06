package echo.ex03;

public class ThreadApp {
	
	public static void main(String[] args)throws InterruptedException {
		
		Thread thread = new DigitThread();
		thread.start(); // 준비되면 digitthread 의 run 진행. 
		//그냥 run을 하면 순서대로 진행되는거라 지금까지 해오던 거랑 같음.
		
		for(char ch='A'; ch<='Z'; ch++) {
			System.out.println(ch);
			Thread.sleep(1000);
		}
		
	}
	
	
	

}
