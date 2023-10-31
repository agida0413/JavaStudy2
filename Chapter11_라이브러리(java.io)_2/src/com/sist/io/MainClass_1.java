package com.sist.io;
/*
	IO => 입력 , 출력 
	= 메모리 입출력 
	= 파일 입출력 
	= 네트워크 입출력 
	-------------------
	 1. 클래스의 종류 
	    1) 송수신 => 1byte 씩 === 바이트 스트림 
	    2) 송수신 => 2byte 씩 === 문자 스트림 
	       ** 스트림 : 데이터를 이동하는 통로 
	    메모리, 파일, 네트워크 ==== 자바 응용 프로그램 ==== 화면 출력 
	                       |                   |
	                  InputStream(1byte)   OutputStream
	                  Reader(2byte)        Writer
	    3) 클래스 
	       = 1byte(바이트 스트림)
	         => 파일 전송, 업로드, 다운로드 => byte 단위로 전송 
	         InputStream : 읽기 
	             |                 
	     -----------------    
	     |               |
 **FileInputStream  FilterInputStream
                         |
                  **BufferedInputStream 
                  
             OutputStream : 쓰기 
                  | 
         ---------------------
         |                   |
 **FileOutputStream   FilterOutputStream
                             |
                   **BufferedOutputStream 
                   
    ** Buffer : 임시 기억 장소 => 속도 최적화
       => 파일이나 웹서버에 있는 모든 데이터를 메모리에 올려놓고 시작
       
           = 2byte => 파일 제어 (파일 읽기/파일 쓰기)
      *** (= 문자 스트림 ) : 한글 => 2byte
      Reader   /   Writer
        |             |
  **FileReader   **FileWriter
    ----------     ---------- 
 **BufferedReader  BufferedWriter
 
	= 객체 단위 저장 
	  = **ObjectInputStream 
	  = **ObjectOutputStream 
	  = 직렬화 / 역직렬화 
	  객체 저장 
	  
	  class A
	  {
	  	int age;
	  	String name;
	  	int kor;
	  }
	  
	  A a=new A(); // 메모리 공간을 만들어서 저장한다
	  
	  메모리에 저장 
	   ----------
	   
	   -------------------------- => 직렬화 
	    age        name      kor 
	           |          |
	   --------------------------
	  
	  메모리에서 값 읽기 => 역직렬화 : ObjectOutputStream
	  ---a---
	  
	  -------  ---100---
	            --age--
	               0      a.age => . 연산자 (주소 접근 연산자)
	            -------
	            
	            --name--
	              null 
	            --------
	            
	            --kor--
	               0 
	            -------
	           ---------
	           
	=> 파일 관련 
	   .txt (파일 자체를 제어)
	   
	   Spring, MyBatis => xml 사용 ==> XML 을 대체 => 어노테이션 
	   ------ xml 없이 사용하는 부분 => Spring-Boot (순수 자바로만 코딩)
	   .xml , .json , .csv , .properties ==> 웹 에서 주로 사용하는 파일들 
	   ----   ------  -----
	     |       |      |  => 데이터 분석 (공공포털)
	           => JavaScript 와 연결해서 데이터 보내는 .json
	              ---------- 자바의 데이터형과 연동이 안된다 
	              =>
	                class A
	                {
	                   String name="a";
	                   int age=20;
	                }
	                
	                {name:"a",age:20} => JSON 
	                => Ajax , Vue , React ==> RestFul
	  제어 (읽기/쓰기) 클래스가 이미 라이브러리로 제공  
	  
	=> 파일 정보 => File 
	   File : 파일, 디렉토리까지 관리 
	   ---- 일반 클래스 
	   사용법 
	    File file=new File("c:\\javaDev\\aa.txt");
	             파일 정보 읽기 
	    File dir=new File("c:\\javaDev");
	             폴더 정보 읽기 
	   주요 메소드)
	    => long length() :  파일 크기 => 단위 Bytes
	    => String getName() : 파일이나 폴더 이름만 읽는 경우 
	    => String getPath() : 경로명+이름 
	    => String getParent() : 경로명만 
	    => boolean isFile(), boolean isDirectory()
	    => boolean exists() : 존재여부 확인 
	    => File[] listFiles() : 폴더 안에 있는 모든 파일 읽기 
	    => delete() : 파일 삭제 
	    => createNewFile() : 파일 생성 
	    => mkdir() : 폴더 생성 
	  ---------------------------------------------
	  FileInputStream / FileReader
	   => read() , read(byte[],offset,len) , close()
	  FileOutputStream / FileWriter 
	   => write() , wrtie(String...), close()
	   
	               
*/
// => Buffered (속도가 빠르다) => 파일 읽기 
import java.io.*;
// 패키지 설정 => 예외처리 (체크예외) => 컴파일러가 예외처리 했는지 체크 
// java.net , java.sql => 체크예외 
// 파일 열기 => 종료시에 파일 닫기를 한다 close()
public class MainClass_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try
//		{
//			String data="";
//			FileReader fr=new FileReader("/Users/maclovin/git/genie.txt");
//			int i=0; // 파일을 하나씩 읽어들일 예정 
//			while((i=fr.read())!=-1) // -1 이 아닐 때 까지 읽어라 => EOF = 파일 끝까지 읽어라
//			{
//				data+=(char)i;
//			}
//			
//			fr.close();
//			
//			System.out.println(data);
//		}catch(Exception ex) {}
		try
		{
			FileInputStream fis=
					new FileInputStream("/Users/maclovin/git/genie.txt");
			BufferedReader in=
					new BufferedReader(new InputStreamReader(fis));
			     // InputStream => FileInputStream , URL 
			// 필터 스트림 ==> 1byte를 읽어서 => 2byte로 변환해서 사용 
			// Input 을 Reader 로 바꿔준다 
			String data="";
			while(true)
			{
				String s=in.readLine(); // 한줄씩 읽어 들인다 
				if(s==null) // 데이터가 없는 경우 
				{
					break;
				}
				data+=s;
			}
			in.close();
			System.out.println(data);
		}catch(Exception ex) {}
	}

}