package echo.ex06;

public class ThreadApp {

	public static void main(String[] args) {

		Thread thread1 = new Thread(new DigitRunnableImpl()); // 출장대기+마무리 코드 쓰려고 new Thread, override 하려고 생성자 안에 digit
		Thread thread2 = new Thread(new LowerRunnableImpl());
		Thread thread3 = new Thread(new UpperRunnableImpl());
		
		thread1.start();
		thread2.start();
		thread3.start();

	}

}
