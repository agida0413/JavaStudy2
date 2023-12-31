package com.sist.io;
/*
	FileInputStream / FileOutputStream 의 주역할 => 파일 복사 
	파일 복사 (웹 에서는 업로드, 다운로드)
	파일 이용 => 메모리 (데이터 => 프로그램 종료시에 자동으로 해제)
	------ 영구적으로 저장 
	보안 => 파일의 단점 = 보안이 취약 => 파일은 종속적이다 (여러개의 파일을 연결해서 사용하기 어렵다)
	파일 => 로컬(갖고 있어야 한다) 
	=> 데이터베이스 => 원격이 가능 ***
*/
import java.io.*;
public class MainClass_FileCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			FileInputStream fis=
					new FileInputStream("/Users/maclovin/git/java_data/back.jpeg");
			// 파일 읽기 ==> 서버 
			FileOutputStream fos=
					new FileOutputStream("/Users/maclovin/git/java_data/back.jpeg");
			// 파일 쓰기 ==> 클라이언트 
			// 파일 복사 
			int i=0; // => 읽은 바이트 수 가지고 온다 
			byte[] buffer=new byte[1024];
			// 한번에 1024바이트씩 읽어서 복사 
			// read() => 한글자씩 , read(byte[]) => 원하는 바이트만큼 씩 읽어온다 
			while((i=fis.read(buffer, 0, 1024))!=-1) // EOF
			{
				fos.write(buffer, 0, i);
			}
			fis.close();
			fos.close();
			System.out.println("파일 복사 완료!!");
		}catch(Exception ex) {}
	}

}