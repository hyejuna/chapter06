package echo.ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException{

		Socket socket = new Socket(); // 종이컵 전화기 한쪽 종이컵
		
		System.out.println("<클라이언트 시작>");
		System.out.println("=============================");
		System.out.println("[서버에 연결을 요청합니다.]");
		
		socket.connect(new InetSocketAddress("192.168.0.22", 10001)); // 종이컵 연결 시도
		
		System.out.println("[서버에 연결되었습니다.]");
		
		//메세지 보내기
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String str = sc.nextLine();
			if("/q".equals(str)) { // nullpoint 예외 발생 대비. str.equals는 str 주소 없는 null 발생할수도 있어서...
				System.out.println("종료키 입력");
				break;
			}
			
			bw.write(str);
			bw.newLine();
			bw.flush();
			
			
			String reMsg = br.readLine();
			System.out.println("Server:[" +reMsg + "]");
			
			
		}
		
		System.out.println("============================");
		System.out.println("클라이언트 종료");				
		
		sc.close();
		br.close();
		bw.close();
		socket.close();
	}

}
