package com.sist.io;
/*
	FileReader / FileWriter => 영어 말고 다른 언어 사용 가능 
	                                   ------- 한국어, 중국어, 일본어(2byte)
	                                   => 한글 깨짐 방지 
	                                   => 문자 스트림(2byte)
	FileInputStream / FileOutputStream
	-----------------------------------
	 => 파일 입출력이 가능 Stream 은 1byte => 알파벳, 숫자는 문제없이 출력 가능
	
*/
import java.io.*;
import java.util.*;
// 여러 문장을 저장하려 할 때 2가지 방법 
// => 1. append => new FileWriter("경로명",true) => 크롤링할 때 append 모드 이용 
// => 2. 문자열을 결합 => 한번에 출력 
public class Mainclass_FileWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter fw=null; // 초기화 필수 !
		try
		{
			// 처리 기능 => 정상적으로 수행할 수 있는 문장 
			fw=new FileWriter("/Users/maclovin/git/java_data/sawon.txt",true);
			// 경로 ~ 파일명 까지 => 자동으로 createNewFile() 처리.
			//                          sawon.txt 파일이 없으면 자동으로 생성해준다
			Scanner sc=new Scanner(System.in);
			System.out.print("사번 입력:");
			int sabun=sc.nextInt();
			System.out.print("이름 입력:");
			String name=sc.next();
			System.out.print("부서 입력:");
			String dept=sc.next();
			// 파일 단점 => 구분이 안된다 
			String msg=sabun+"|"+name+"|"+dept+"\r\n"; // 파일에선 \r\n 띄어쓰기 
			
			// 파일 저장 
			fw.write(msg);
			
			System.out.println("파일 저장 완료!!");
			
			
		}catch(Exception ex) 
		{
			// 에러가 있는 경우 => 복구 / 에러 위치 확인 (O)
			ex.printStackTrace(); // 에러 위치 확인 
		}
		finally // 생략되어 있지만 항상 존재 
		{
			// 파일 => 리소스 를 닫기 
			// 서버 => 서버 닫기 
			// 오라클 닫기 
			try
			{
				fw.close();
			}catch(Exception ex) {}
		}
	}

}