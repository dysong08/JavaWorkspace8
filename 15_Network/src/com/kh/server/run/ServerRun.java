package com.kh.server.run;

import com.kh.server.tcp.Server;

public class ServerRun {

//	★ TCP(Tranmission control Protocol)
//	- 서버와 클라이언트 간의 1:1 소켓 통신
//	- 데이터를 교환하기 앞서 서버와 클라이언트가 서로 연결되어 있어야 한다.
//		(서버가 먼저 실행되어서 클라이언트의 요청을 대기하고 있어야 한다.)
//		
//	★ 특징 ?
//	: 신뢰성 있는 데이터 전달이 가능.
//	
//	★ ServerSocket
//	- 서버에서 클라이언트의 요청을 대기하는 클래스
//	- 사용법 : ServerSocket server = new ServerSocket(int portNumber)
//	- 메서드 :
//		Socket client = server.accept() 메서드를 통해 클라이언트의 연결을 기다리고 연결이 오면
//		클라이언트의 Socket객체를 반환한다.
//	★ Socket
//	- 클라이언트에서 서버에 요청을 하거나 서버에서 클라이언트의 요청을 받았을때 사용하는 클래스
//	- 사용법 : Socket socket = new Socket(String IPAddress, int portNumber)
//	- 메서드 :
//		> Client.getOutputStream() 데이터를 출력할 수 있는 OutputStream 객체 생성
//		> Client.getInputStream() 데이터를 입력받을 수 있는 INputStream 객체 생성 가능
	
	
	public static void main(String[] args) {

		new Server().serverStart();
		
		
		
		
		
		
	}

}
