package com.kh.server.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//	작업순서
//  0. 포트번호 및 변수지정
// 1024~65535의 포트번호 사용하는 것을 추천
// 0~1023까지는 시스템이 사용하고 있을 수 있음.

//	1. 서버의 소켓 객체 생성
//	2. 클라이언트의 접속 요청대기
//	3. 요청이 오면 수락
//	4. 클라이언트 소켁 정보를 저장
//	5. 클라이언트의 정보(소켓)를 통해서 OutputStream 객체 생성
//	6. 클라이언트의 정보를 통해서 InputStream 객체 생성
//	7. 스트림을 통해 읽고 쓰기
//	8. 통신 종료

public class Server {
	
	public void serverStart() {
		
		// 0) 포트번호 및 변수 지정
		int port = 30027; // 1024~65535의 포트번호 사용하는 것을 추천. 0~1023까지는 시스템이 사용하고 있을 수 있음
		int clientCnt = 0;
		
		// 1) 서버의 소켓 객체 생성
		ServerSocket server = null;
		
		
		try {
			server = new ServerSocket(port);
			
			System.out.println("서버 시작");
			
			while(true) {
				
				// 2) 클라이언트의 접속 요청 대기
				System.out.println("클라이언트 대기중....");
				Socket client = server.accept(); 
				
				//3)4) 접속요청이 오면 요청 수락후, 클라이언트의 소켓 객체를 반환하면서 클라이언트의 정보를 저장
				System.out.println(++clientCnt + "번째 클라이언트 연결됨...");
				
				// 5)6) 연결된 클라이언트와 입출력 스트림 생성
				OutputStream os = client.getOutputStream();
				InputStream is = client.getInputStream();
				
				// 5_2)6_2) 보조 스트림을 통한 성능 개선
				// 클라이언트로부터 전달된 값을 한줄단위로 읽어들이기 위한 입력용 스트림
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				
				// 클라이언트에게 값을 한줄단위로 출력하는 스트림
				PrintWriter pw = new PrintWriter(os, true);
				
				// 7) 스트림을 통해 읽고 쓰기
				while(true) {
					String message = br.readLine();  // 클라이언트의 입력이 오기까지 대기
					
					if(message == null || "exit".equals(message)) {
						System.out.println("연결 종료");
						break;
					}
					
					System.out.println(client.getInetAddress().getHostAddress() +"가 보낸 메시지 내용 : " + message);
					pw.println("메시지 응답 성공");
					pw.flush();  // 현재 출력스트림에 존재하는 데이터를 강제로 내보내는 메소드
				}
				
				br.close();
				pw.close();
				client.close();
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}