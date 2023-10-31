package com.sist.io;
/*
 => 한글 파일 읽기 는 잘 안쓰고, 다운로드 / 업로드 에서 많이 사용한다 IO
 read() / write() / => append
 => new FileInputStream / new FileOutputStream("경로명")
 => create => new FileOutputStream("경로명", true) => 이게 append 방식 (덮어쓰기)
 파일을 불러오면 반드시 닫아야 한다 => fox.close()
*/
import java.util.*;
import java.io.*;
public class MainClass_FileOutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			String[] cate= {
					"얼큰한 칼국수 맛집 베스트 20곳",
					"여의도 맛집 베스트 50곳",
					"일본 라멘 맛집 베스트 70곳",
					"어복쟁반 맛집 베스트 15곳",
					"한식 주점 베스트 30곳"
			};
			// category.txt 에 저장 
			for(String s:cate)
			{
				// 파일 저장 
				FileOutputStream fos=
						new FileOutputStream("/Users/maclovin/git/java_data/category.txt",true);
				// new FileOutputStream("경로명",true); => append 모드 (덮어쓰기)
				fos.write((s+"\r\n").getBytes()); // 파일에서는 \r\n 해야 띄어쓴다
				// 문자열을 byte[] 변환 
				fos.close();
			}
			System.out.println("파일 저장 완료!!");
		}catch(Exception ex) {}
	}

}