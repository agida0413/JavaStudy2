package com.sist.io;
// ObjectInputStream : FileInputStream
import java.util.*;
import java.io.*;
public class MainClass_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			FileInputStream fis= // InputStream(1byte)으로 가져와서 안열린다 하지만 깨진 문자열은 아니다 숨겨진 것
					new FileInputStream("/Users/maclovin/git/java_data/emp.txt");
			ObjectInputStream ois=
					new ObjectInputStream(fis);
			ArrayList<Sawon> list=
					(ArrayList<Sawon>)ois.readObject(); // Object 이니 형변환 
			// 형변환시에 => 제네릭을 포함한다 
			fis.close();
			ois.close();
			for(Sawon s:list)
			{
				System.out.println(s.getSabun());
				System.out.println(s.getName());
				System.out.println(s.getDept());
				System.out.println(s.getJob());
				System.out.println(s.getPay());
				System.out.println("=============");
			}
		}catch(Exception ex) {}
	}

}