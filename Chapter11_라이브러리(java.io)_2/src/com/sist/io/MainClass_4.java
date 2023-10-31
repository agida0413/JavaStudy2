package com.sist.io;
// BufferedOutputStream => 파일 쓰기 
import java.io.*;
public class MainClass_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			FileOutputStream fos=
					new FileOutputStream("/Users/maclovin/git/java_data/sawon.txt");
			BufferedOutputStream bos=
					new BufferedOutputStream(fos);
			String data="홍길동|개발부|서울|대리|3600\r\n";
			bos.write(data.getBytes()); // 항상 바이트로 변환해서 넣어야 한다 (메모리)
			bos.close(); // 메모리 끄고 File 에 연결해서 저장할 수 있게 한다 
		}catch(Exception ex) {}
	}

}