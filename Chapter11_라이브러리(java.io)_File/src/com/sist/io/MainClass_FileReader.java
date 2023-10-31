package com.sist.io;
import java.io.*;
// 파일 읽기 => 송수신 => 2byte 씩 읽어 온다 => 문자 스트림 
// 파일 자체 제어 : Reader / Writer 	
public class MainClass_FileReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr=null; // 초기화 안하면 try 에서 오류 발생 
		try
		{
			fr=new FileReader("/Users/maclovin/git/java_data/sawon.txt");
			int i=0;
			while((i=fr.read())!=-1) // EOF 
			{
				System.out.print((char)i);
			}
		}catch(Exception ex)
		{
			ex.printStackTrace(); // 에러 위치 확인 
		}
		finally
		{
			try
			{
				fr.close();
			}catch(Exception ex) {}
		}
	}

}