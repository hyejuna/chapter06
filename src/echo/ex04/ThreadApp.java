package echo.ex04;

public class ThreadApp {

	public static void main(String[] args) throws InterruptedException {
		
		Thread thread1 = new DigitThread();
		Thread thread2 = new LowerThread();
		Thread thread3 = new UpperThread();
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		/*
		 * 준비되면 실행이 아니라 순서대로 실행. 숫자다 찍고 소문자 다 찍고 대문자
		thread1.run();
		thread2.run();
		thread3.run();
		 */
	}

}
