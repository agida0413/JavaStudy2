package com.sist.io;
import java.io.*;
public class MainClass_FileInputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			// FileInputStream -> 1바이트씩 읽어와서 한글이 깨지지만, 
			// FileReader => 2바이트씩 읽어와서 한글도 안깨진다 
			FileInputStream fis=
					new FileInputStream("/Users/maclovin/git/java_data/category.txt");
			int i=0; // 한글자씩 읽어온다 => ASC(문자번호)
			// A => 65 로 불러온다
			// 파일 끝날 때까지 읽어온다 => -1(EOF)
			// 바이트 스트림 은 한글파일 읽기 용도가 아니라 업로드, 다운로드 에 사용 
			String msg="";
			while((i=fis.read())!=-1) // EOF (파일 끝까지 다 읽어와라)
			{
				msg+=(char)i;
			}
			fis.close();
			System.out.println(msg);
		}catch(Exception ex) {}
	}

}