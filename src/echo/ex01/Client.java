package echo.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

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
		
		String str = "안녕하세요";
		bw.write(str);
		bw.newLine();
		bw.flush(); // buffer에 채워서 옮기는거라 매우 적으면 안감 -> flush 쓰면 안 차도 감
		
		//메세지 받기
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		String reMsg = br.readLine();
		System.out.println("Server:[" +reMsg + "]");
				
		
		
		br.close();
		bw.close();
		socket.close();
	}

}
