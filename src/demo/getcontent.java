package demo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * ���������Լ�cookie��ȡ�������
 * �����صģʣӣϣ���Ϣ
 * ÿ����������Ҫ��login��ý�����ַ
 * ����������ÿ����ҳԪ��װ�ص�map�У�Ȼ��ת����JSON
 * �γ̱�ŵ���ά������
 * �����Ϳ��Դﵽ��ƽ̨������
 */
public class getcontent {
	
		//����ѧ����Ϣmap
		static Map<String,String> infoMap = new HashMap<String,String>();
		//ѧ���ɼ�map
		static Map<String,String> scoreMap = new HashMap<String,String>();
		
		//���ظ�����Ϣ
		public static String getinfo(String infolink){
			//ʹ��cookies����ĵ�¼��Ϣ����ģ���¼��ȡ��Ϣϵͳ��ҳ
			Document course_jsp=getpage(infolink);
			//��ȡ����ѧ�ŵȻ�����Ϣ
			Elements stuinfo = course_jsp.select("#form1 > table.table1 > tbody > tr > td > table > tbody > tr > td ");
			
			for (int i = 0; i < stuinfo.size(); i=i+2) {
		        String studentinfo = stuinfo.get(i).text();
					      if(!(studentinfo ==null || studentinfo.isEmpty())){
					    	  //ɾ�����ţ�����д������
					    	  studentinfo=studentinfo.replaceAll(" ��", "");
					    	  infoMap.put(studentinfo, stuinfo.get(i+1).text());   
					      }
					}
			
			return null;
		};
		
		//����ѧ���ɼ�
				public static String getscore(String infolink){
					//��÷���ҳ��DOM����
					Document score_jsp=getpage(infolink);
					//��ȡ����ѧ�ŵȻ�����Ϣ
					Elements stuscore = score_jsp.select("#form1 > table:nth-child(6) > tbody > tr");
					
					//��ȡ���޿γ̷���
					for (int i = 0; i < stuscore.size(); i=i+1) {
						//����ѵ�ѧ�ֵı��Ϊ��
						if (!(stuscore.get(i).select(" td:nth-child(10)").text().toString().length()==0)) {
						    	  scoreMap.put(stuscore.get(i).select(" td:nth-child(3)").text(), 
						    			  	   stuscore.get(i).select(" td:nth-child(9)").text());
						}
					}
					
				  //��ȡѡ�޿γ̷���
					 stuscore = score_jsp.select("#form1 > table:nth-child(10) > tbody > tr");
						for (int i = 0; i < stuscore.size(); i=i+1) {
							//����ѵ�ѧ�ֵı��Ϊ��
							if (!(stuscore.get(i).select(" td:nth-child(9)").text().toString().length()==0)) {
							    	  scoreMap.put(stuscore.get(i).select(" td:nth-child(2)").text(), 
							    			  	   stuscore.get(i).select(" td:nth-child(8)").text());
							      
							}
						}
					return null;
				};
		
				
		//���ؿγ̱�Ĭ�Ϸ��ص�ǰѧ�ڿα�
		public static String getclass(String classlink){
			/*
			 * ���������������
			 * �� clasStrings[1][2]��ʾ���ڶ���һ��
			 * ��clasStrings[0][2] ��ʾ���ڶ��ַ���
			 */
			String [][] clasStrings = new String [9][8]; 
			Document class_jsp=getpage(classlink);
			Elements stuclass = class_jsp.select("body > form > table:nth-child(5) > tbody > tr:nth-child(1)");
			//��ֵ���� �ַ���������
			for (int i = 1; i <=7; i++) {
				clasStrings[0][i]=stuclass.select("td").get(i).text();
				
			}
			
			//д��γ�����
			for (int i = 2; i <=9; i++) {
				String selecString="body > form > table:nth-child(5) > tbody > tr:nth-child("+ i +")";
				stuclass = class_jsp.select(selecString);
					for (int j = 0; j <stuclass.select("td").size(); j++) {
						//�ϸ��жϱ�������Ƿ�������壬����td�Ƿ���������Ŀγ�
						if (!(stuclass.select("td").get(j).text().toString().length()==0||(stuclass.select("td").get(j).toString().indexOf("nbsp")>=0))) {
							selecString="td:nth-child("+ (j+1) +")";
							clasStrings[i-1][j]=stuclass.select(selecString).text();
						}else {
							clasStrings[i-1][j]="-1";
						}		
					}		
			}
			 
			return null;
		};
		
		//���ؿ��԰��ű�
		public static String getexam(String examlink){
			/*
			 * ����ʮ��8������
			 *  
			 *  
			 */
			System.out.println(examlink);
			String [][] clasStrings = new String [10][8]; 
			Document exam_jsp=getpage(examlink);
			Elements stuexam = exam_jsp.select("#form1");
			
			//��ֵ���� �ַ���������
			for (int i = 1; i <=7; i++) {
				clasStrings[0][i]=stuexam.select("td").get(i).text();
				
			}
			
			//д�뿼�԰��ű�
			for (int i = 2; i <=9; i++) {
				String selecString="body > form > table:nth-child(5) > tbody > tr:nth-child("+ i +")";
				stuexam = exam_jsp.select(selecString);
					for (int j = 0; j <stuexam.select("td").size(); j++) {
						//�ϸ��жϱ�������Ƿ�������壬����td�Ƿ���������Ŀγ�
						if (!(stuexam.select("td").get(j).text().toString().length()==0||(stuexam.select("td").get(j).toString().indexOf("nbsp")>=0))) {
							selecString="td:nth-child("+ (j+1) +")";
							clasStrings[i-1][j]=stuexam.select(selecString).text();
						}else {
							clasStrings[i-1][j]="-1";
						}		
					}		
			}
			
			return null;
		};
		
		//��ȡÿ����ҳ�棬������Document����
		public static Document getpage(String examlink){
			Document pageDocument;
			try {
				pageDocument = Jsoup.connect(examlink).cookies(login.cookies).post();
				pageDocument.charset(Charset.forName("UTF-8"));
				//System.out.println(pageDocument);
				return pageDocument;
			} catch (IOException e) {
				//�׳��쳣��˵��404����
				e.printStackTrace();
				return null;
			}
		}
}
