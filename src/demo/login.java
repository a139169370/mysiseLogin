package demo;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class login {
	//Ϊ�˷����������֮�����cookies ,���ⶨ�������̬����
	static Map<String,String> cookies =null;
	public static String getloginvalue() throws Exception {
		//���Ȼ�ȡ��ѧ����Ϣ����ϵͳҳ��
		Connection con = Jsoup.connect("http://class.sise.com.cn:7001/sise/login.jsp");
		con.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; MALC)");
		Connection.Response rs = con.execute();
		try {
			rs = con.execute();
		} catch (Exception e) {
			System.out.println("false");
		}
		
		Document doc=Jsoup.parse(rs.body());
		//��ȡ��¼��ز���
		 Elements hidden = doc.select("div > form > input[type=\"hidden\"]:nth-child(1)");
		 String hiddename=hidden.attr("name");
		 String hiddenvalue=hidden.attr("value");
		 Elements random= doc.select("#random");
		 String randomvalue=random.attr("value");
		 
		 //��ʼģ���½
		 String username = "";
			String password = "";
			//mapװ�ر�����
			Map<String,String> map = new HashMap<String,String>();
			map.put("username", username);
			map.put("password", password);
			map.put(hiddename, hiddenvalue);
			map.put("random", randomvalue);
			
			
			
			//ģ��������������ӣ���������
			Connection conn = Jsoup.connect("http://class.sise.com.cn:7001/sise/login_check.jsp");
			conn.header("Host", "class.sise.com.cn:7001");
			conn.header("Referer", "http://class.sise.com.cn:7001/sise/index.jsp");
			conn.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; MALC)");
			Response response = conn.ignoreContentType(true).method(Method.POST).data(map).execute();
			
			//�ж�������ȷ��
			if(response.body().indexOf("index.jsp")<0){
				System.out.println("�˺Ų����ڣ����������");
				return "�˺Ų����ڣ����������";
			}
			
			//��ȡcookies
			cookies = response.cookies();
			
			
			//Set<String> keys = cookies.keySet();
			/*�������cookie  ����ֻ��һ��cookie
			  *		for(String key:keys){
			  *			System.out.println(key+":"+cookies.get(key));
			  *				}
			*/
			//ʹ��cookies����ĵ�¼��Ϣ����ģ���¼��ȡ��Ϣϵͳ��ҳ
			Document main_jsp = Jsoup.connect("http://class.sise.com.cn:7001/sise/module/student_states/student_select_class/main.jsp").cookies(cookies).post();
			main_jsp.charset(Charset.forName("UTF-8"));
			//System.out.println(main_jsp);
	
			//������ȡ��վ��ͼ  ��ͼput˳���ַ����ѧ������ϵͳ����
			Map<String,String> link = new HashMap<String,String>();
			link.put("infolink", getline.getinfolink(main_jsp));
			link.put("classlink", getline.getclasslink(main_jsp));
			link.put("examlink", getline.getexamlink(main_jsp));
			
			//������վ��ͼ����ȡ�������JSON��Ϣ
			//getcontent.getinfo(link.get("infolink").toString());
			//getcontent.getscore(link.get("infolink").toString());
			//getcontent.getclass(link.get("classlink").toString());
			getcontent.getexam(link.get("examlink").toString());
	
			return "OK";
	}
	

}
