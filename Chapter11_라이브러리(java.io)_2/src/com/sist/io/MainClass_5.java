package com.sist.io;
import java.io.*;
public class MainClass_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try // 아래 코드 => 다운로드 할 때 쓰는 코드 
		{
			FileInputStream fis=
					new FileInputStream("/Users/maclovin/git/genie.txt");
			FileOutputStream fos=
					new FileOutputStream("/Users/maclovin/git/java_data/genie.txt");
			BufferedInputStream bis=
					new BufferedInputStream(fis);
			BufferedOutputStream bos=
					new BufferedOutputStream(fos);
			
			int i=0; // read() => 한글자씩 읽기 
			         // read(byte[]) => 읽은 바이트 수  / i 의 의미가 다르다 
			byte[] buffer=new byte[1024];
			// => 1024byte 를 읽어서 => 새로운 파일에 전송 
			while((i=bis.read(buffer,0,1024))!=-1)
			{
				bos.write(buffer, 0, i); // i => 읽은 바이트 수만큼만 가져온다 
			}
			bis.close();
			bos.close();
			System.out.println("파일 복사 완료");
		}catch(Exception ex) {}
	}

}