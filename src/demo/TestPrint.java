package demo;

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
			
		System.out.println("ѧ���ɼ���");
			for(Map.Entry<String, String> entry : getcontent.scoreMap.entrySet()){
				    System.out.println(entry.getKey()+" : "+entry.getValue());
				}
			
		System.out.println("ѧ���γ̱�");
		for(String[] arr : getcontent.clasStrings){
			for(String arr2 : arr){
				if (arr2!=null) {
					System.out.println(arr2+"\t");
				}
			}
		}
	        
	   System.out.println("ѧ�����԰��ű�");
	   for(String[] arr : getcontent.examStrings){
			for(String arr2 : arr){
				if (arr2!=null) {
					System.out.println(arr2+"\t");
				}
			}
		}   
	
	}
}
	
