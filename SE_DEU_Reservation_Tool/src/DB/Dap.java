package DB;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

public class Dap {
	
	private  String ID ;
	private  String PW ;
	
	public Dap() throws NoSuchAlgorithmException, KeyManagementException {
		//this.ID = ID;
		//this.PW = PW;
		// String htmlUrl = "https://door.deu.ac.kr/sso/login.aspx";
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		} };

		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

		//추가된 코드
		//DAPCONNET();
	}

	public String[] DAPCONNET(String ID, String PW) {
		try {
                          // System.out.println(ID + " " + PW);
			/********************************************************************************************************
			 * 			세션ID 요청  																					*
			 ********************************************************************************************************/
			Connection.Response loginPageResponse = Jsoup
					.connect("https://sso.deu.ac.kr/LoginServlet?method=idpwProcessEx&ssid=24").timeout(10000)
					.data("issacweb_data", "").data("challenge", "").data("response", "")
					.data("id", ID)	//id기입
					.data("pw", PW) //비밀번호기입
					.ignoreContentType(true) // https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=lovej804&logNo=220619290290
					.method(Connection.Method.POST).execute();

			Document trr = loginPageResponse.parse();
			String str = trr.toString();
			String str2[] = str.split("value=\"");
			ArrayList<String[]> s1 = new ArrayList<String[]>(); // 타입 지정

			for (int i = 0; i < str2.length; i++) {
				s1.add(str2[i].split("\">"));
			}
			str2= null;
			str = null;
			trr = null;
			/********************************************************************************************************
			 * 			쿠키 값 획득																					*
			 ********************************************************************************************************/
			Connection.Response loginPageResponse3 = Jsoup
					.connect("https://dap.deu.ac.kr:443/sso/checkauth.aspx").timeout(10000)
					.data("secureToken", s1.get(1)[0]).data("secureSessionId", s1.get(2)[0]).data("isToken", "Y")
					.data("reTry", "N").data("method", "checkToken").data("incorrectCount", "0")
					.method(Connection.Method.POST).execute();
			
			/********************************************************************************************************
			 * 			쿠키를 이용해 회원확인을 위한 정보 쿠키 획득															*
			 ********************************************************************************************************/
			Connection.Response loginPageResponse4 = Jsoup
					.connect("https://dap.deu.ac.kr:443/sso/agentProc.aspx/?mcd=112009&pid=Svc0301e").timeout(10000)
					.cookies(loginPageResponse3.cookies()).method(Connection.Method.POST).execute();
		
			/********************************************************************************************************
			 * 			 정보 파싱																						*
			 ********************************************************************************************************/
			Connection.Response loginPageResponse5 = Jsoup
					.connect("https://dap.deu.ac.kr/Student/SVC/SVC0301E.aspx?mcd=112009&pid=Svc0301e").timeout(10000)
					.cookies(loginPageResponse4.cookies()).method(Connection.Method.POST).execute();
                        
                        String[] TempDapResert = loginPageResponse5.parse().toString().split("<!-- /END #side-bar -->");//[1].split("<!-- /END #pagecont -->")[0];
                        if(TempDapResert.length == 1)
                            return null;
                          String DapResert = TempDapResert[1].split("<!-- /END #pagecont -->")[0];
			//System.out.println(DapResert);
                        String Arr[] = DapResert.split("\n");
                        int j =0;
                        //학번,전공,학년,이름,폰번호,학적상태
                        String[] paresinfo = {"CP1_txt_student_cd","CP1_StudentInfo1_lbl_major","CP1_StudentInfo1_lbl_student_year","CP1_StudentInfo1_lbl_nm","CP1_StudentInfo1_lbl_m_phone","CP1_StudentInfo1_lbl_school_sts"}; 
                        String[] getinfo = new String[paresinfo.length];

                        for (int i =0; i<Arr.length && j<paresinfo.length; i++){

                                if (j != 0 && Arr[i].contains("<span id=\""+paresinfo[j] +"\">")){
                                   getinfo[j] = (Arr[i].split("<span id=\""+paresinfo[j] +"\">")[1].split("</span>")[0]); j++;
                                }
                                else if(j == 0 && Arr[i].contains("id=\""+paresinfo[j]+"\"")){
                                    getinfo[j] = (Arr[i].split("value=\"")[1].split("\"")[0]); j++;
                                        }
                            }

                       for(int i=0 ;i<getinfo.length; i++)
                            System.out.println(getinfo[i]);
                        return getinfo;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                return null;
	}
}