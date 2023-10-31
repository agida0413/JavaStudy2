package com.sist.io;
// 파일 정보 출력 
import java.io.*;
import java.util.*;
import java.text.*;
/*
	getName() (= 파일명) , getPath() (= 경로명+파일명), length() (= 파일 크기)
*/
public class MainClass_File_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			File file=new File("/Users/maclovin/git/movie.txt");
			System.out.println("최종 수정일:"+
			new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));
			System.out.println("====== 기타 정보 ======");
			System.out.println("***파일명:"+file.getName());
			System.out.println("***경로명+파일명:"+file.getPath());
			System.out.println("경로명:"+file.getParent());
			System.out.println("읽기 가능:"+file.canRead());
			System.out.println("쓰기 가능:"+file.canWrite());
			System.out.println("숨김 파일:"+file.isHidden());
			System.out.println("절대 경로:"+file.getAbsolutePath());
			System.out.println("정규 경로:"+file.getCanonicalPath());
//			System.out.println("***파일 크기:"+file.length());
			System.out.println("File.pathSeparator-"+file.pathSeparator);
			System.out.println(file.separator); // separator = 구분자 
			// Git 에서 윈도우 <--> 맥 경로명 호환가능하게 해주는 !!
			// Window : \ , Mac : /
			long size=file.length();
			String s="";
			if(size/1024>0)
			{
				s=(size/1024)+"KB";
			}
			else
			{
				s=size+"Bytes";
			}
			System.out.println("파일 크기:"+s);
		}catch(Exception ex) {}
	}

}