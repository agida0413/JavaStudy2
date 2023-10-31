package com.sist.io;
// 패키지 읽기 
import java.io.*;
public class MainClass_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			// 메모리 입출력 
			BufferedReader in=
				new BufferedReader(new InputStreamReader(System.in)); // 키보드로 읽어와서 문자로 변환 
			System.out.print("이름 입력:");
			String name=in.readLine();
			System.out.println(name);
			
		}catch(Exception ex) {}
	}

}