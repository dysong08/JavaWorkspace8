package com.kh.client.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


//	클라이언트 TCP 소켓 프로그래밍 작업 순서
//	
//	1. 연결을 하고자 하는 서버의 IP주소와 서버가 정한 포트번호를 매개변수로 하여 소켓 객체 생성
//	2. 서버와의 입출력 스트림 오픈
//	2-2 보조스트림을 통한 성능 개선
//	3. 스트림을 통한 읽고 쓰기
//	4. 통신종료(스트림 및 소켓 반납)
	
	
	
	
	public class Client {
	
	public void clientStart() {
		
//		0. 변수 셋팅
		int port = 30027;
		String str = null;
		String serverIp = null; 	// "192.168.30.2" 문자열제시도 가능
		Socket socket = null;
		
		
		try {
			// 1) 연결을 하고자하는 서버의 IP주소와 서버가 정한 포트번호를 매개변수로 하여 소켓 객체 생성
			serverIp = InetAddress.getLocalHost().getHostAddress();  // "192.168.XX.X"
			socket = new Socket(serverIp, port);  // 잘못된 ip주소나 잘못된 port번호 제시시 null값 반환. 즉, 연결실패시 null값 반환
			
			// 2) 서버와의 입출력 스트림 오픈
			if(socket != null) {
				// 2) 서버와의 입출력 스트림 오픈
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				// 2_2) 성능개선
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				PrintWriter pw = new PrintWriter(os, true);  /// 서버로 값을 내보낼때
				
				// 3) 스트림을 통한 읽고 쓰기
				Scanner sc = new Scanner(System.in);
				
				do {
					System.out.print("서버에 보낼 내용 : ");
					str = sc.nextLine();
					
					pw.println(str); // 내가 내보낸 내용을 저장
					
					if(str == null || "exit".equals(str)) {
						System.out.println("접속 종료");
						break;
					}
					
					String message = br.readLine(); // 응답성공 메시지
					System.out.println("받은 메시지 : " +message);
					
				}while(true);
				
				// 5) 자원반납
				pw.close();
				br.close();
				socket.close();
				
			}else {
				System.out.println("연결하고자하는 서버가 존재하지 않습니다.");
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}