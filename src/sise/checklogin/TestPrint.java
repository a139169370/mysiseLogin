package sise.checklogin;

import java.util.Map;

/**
 *  Class Name: TestPrint.java
 *  Description: �������
 *  @author Abel TSE  DateTime 2016��5��15�� ����10:06:14 
 *  @email romennts@gmail.com 
 *  @version 1.0
 */
public class TestPrint {
	public static void print() {
		//�������
		System.out.println("ѧ��������Ϣ��");
			for(Map.Entry<String, String> entry : getcontent.infoMap.entrySet()){
				    System.out.println(entry.getKey()+" : "+entry.getValue());
				}
			
		System.out.println("\nѧ���ɼ���");
		System.out.print("��ð칫����ɼ���");
		System.out.println(getcontent.scoreMap.get("�칫���"));
		System.out.println(getcontent.scoreMap.get("��ѧ����I"));
			
		System.out.println("\nѧ���γ̱�");
		//��ʵ���Ը��������һ������֪ ���жϵڼ���
		System.out.print("�������ڶ��ڿΣ�"+ "ʱ���ǣ�"+ getcontent.clasStrings[2][0]);
		System.out.println(" \t" + getcontent.clasStrings[2][3]);
		System.out.print("���ڶ���һ�ڿΣ�"+ "ʱ���ǣ�"+ getcontent.clasStrings[1][0]);
		System.out.println(" \t" + getcontent.clasStrings[1][2]);
		System.out.print("�������һ�ڿΣ�"+ "ʱ���ǣ�"+ getcontent.clasStrings[1][0]);
		System.out.println(" \t" + getcontent.clasStrings[1][5]);
	        
	   System.out.println("\nѧ�����԰��ű�");
	   int i=0;
	   //�����һ�ſ�������
	   for(String arr : getcontent.examStrings[1]){
			System.out.print(getcontent.examStrings[0][i]+":  ");
			System.out.println(arr);
			i++;
		}   
	
	}
}
	
