package com.sist.io;
// git => genie.txt => 읽어서 출력 
import java.io.*;
public class MainClass_Example_1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr=null; // 초기화 안하면 try 에서 null 오류 발생 
		try
		{
			fr=new FileReader("/Users/maclovin/git/genie.txt");
			int i=0; // 문자 저장 
			while((i=fr.read())!=-1) // EOF (파일 끝까지 읽어라)
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
				fr.close(); // 파일 닫아주기 finally-try 안에 
			}catch(Exception ex) {}
		}
	}

}