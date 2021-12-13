package echo.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("192.168.0.22", 10001));
		//192.168.219.105 10001(뒤에 다섯글자는 내가 정한 port 번호)
		
		System.out.println("<서버시작>");
		System.out.println("============================");
		System.out.println("[연결을 기다리고 있습니다.]");
	
		
		Socket socket = serverSocket.accept(); // accept 메소드가 client랑 연결하고 socket 만듬
		
		System.out.println("[클라이언트가 연결되었습니다.]");
		
		
		//메세지 받기
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		String msg = br.readLine();
		System.out.println("받은메세지:" +msg);
		
		//메세지 보내기
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter isw = new OutputStreamWriter(os,"UTF-8");
		BufferedWriter bw = new BufferedWriter(isw);
		
		bw.write(msg);
		bw.newLine();
		bw.flush();
		
		
		bw.close();
		br.close();
		
		socket.close();
		serverSocket.close();
	}

}
