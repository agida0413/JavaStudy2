package com.sist.io;
// BufferedInputStream => 파일 데이터 읽기 
import java.io.*;
public class MainClass_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			// InputStream = 1byte => 한글 깨진다 
			FileInputStream fis=
					new FileInputStream("/Users/maclovin/git/genie.txt");
			BufferedInputStream bis=
					new BufferedInputStream(fis); // 파일에서 읽어온 걸 메모리에 저장
			int i=0;
			while((i=bis.read())!=-1)
			{
				System.out.print((char)i);
			}
			bis.close();
		}catch(Exception ex) {}
	}

}