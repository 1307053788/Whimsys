import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class phone {

private static final String addr = "https://app.cloopen.com:8883/";
private static final String userId = "�û���";

/*
* ��uid�ǣ�test����¼�����ǣ�123123 
pwd=md5(123123test),��
pwd=b9887c5ebb23ebb294acab183ecf0769

*/
private static final String pwd = "MD5����"; 

private static final String encode = "utf8"; 

public static void send(String msgContent, String mobile) throws Exception {

//�齨����
String straddr = addr + 
"?ac=send&uid="+userId+
"&pwd="+pwd+
"&mobile="+mobile+
"&encode="+encode+
"&content=" + msgContent;

StringBuffer sb = new StringBuffer(straddr);
System.out.println("URL:"+sb);

//��������
URL url = new URL(sb.toString());
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setRequestMethod("POST");
BufferedReader in = new BufferedReader(new InputStreamReader(
url.openStream()));

//���ؽ��
String inputline = in.readLine();
System.out.println("Response:"+inputline);

}


public static void main(String[] args) {
try {
send("����", "�ֻ���");
} catch (Exception e) {
e.printStackTrace();
}
}
}