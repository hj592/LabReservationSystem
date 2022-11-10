package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;

public class DB_CONNECTER {
    private static DB_CONNECTER uniqueInstance;
    // other instance variable in here
    static private Connection con ;
    static private Statement st;
    //static private PreparedStatement st;
    private static boolean IN = false;
       // PreparedStatement pstmt = null;           
        
    public static synchronized DB_CONNECTER getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new DB_CONNECTER();
        }
        return uniqueInstance; 
    }
    public static void Connet() throws ClassNotFoundException, SQLException {
       // if (!IN){
            String url = "jdbc:mariadb://211.52.225.194:53/SE_DEU_DB";
            //String sql = "show databases";
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(url, "creator", "cre445");
            st = con.createStatement();
            st.executeQuery("use "+"SE_DEU_DB;");
            
            //st.close();
            //con.close();
            //System.out.println("hello");
            IN = !IN;
        //}
    }
     public static int Update_Qurey(String qurey) throws SQLException, ClassNotFoundException{
         Connet();
         int res = 0;
          // int rs = st.executeUpdate(qurey);
          		try {
			//3. Query 준비
			//st = con.createStatement();
			
			//4. Query 실행 및 리턴
			res = st.executeUpdate(qurey);
			if(res > 0) {
				System.out.println("입력 성공");
			}else {
				System.out.println("입력 실패");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
                            //5. DB종료
                              //st.close();
                              //con.close();
                                    //  rs.close();
                                 st.close();
                                con.close();
                              return res;
     }
                                                        //  return res;
     }
    public static String[][] Exe_Qurey(String qurey) throws SQLException, ClassNotFoundException{
        Connet();
        ResultSet rs = st.executeQuery(qurey);
        ResultSetMetaData rsmd = rs.getMetaData();
        
        int columnCnt = rsmd.getColumnCount();
        rs.last();    // moves cursor to the last row
        
        String Atrribute[][] = new String[1][columnCnt];    //속성 라인
        String Datas[][] = new String[rs.getRow()+1][columnCnt]; //데이터 라인
        rs.beforeFirst();
        // System.out.println("before row: "+rs.getRow());
        for (int i = 0; i < columnCnt; i++)
            Atrribute[0][i] = rsmd.getColumnName(i + 1);    //속성명 정리
        
        Datas[0] = Atrribute[0]; //속성명 추가
        int j=0;
        int i = 1;
        while (rs.next()) {
            //ArrayList<Object> ColumnData= new ArrayList<Object>();
            for (j = 0; j < columnCnt; j++) {
                if (rs.getObject(j+1) == null)
                    Datas[i][j] = "";
                else
                    Datas[i][j] = rs.getObject(j+1).toString();
            }
                            System.out.println("before row: "+rs.getRow());
            i++;
        }
        /*
        System.out.println("i: "+Datas.length+"j: "+j +"ddd " + Datas[0].length);
        // System.out.println(Datas[Datas.length-1][j-1].trim());
         
         for(int i=0;i<Datas.length;i++){
             for(int k=0;k<Datas[0].length;k++){
                  System.out.println(Datas[i][k].trim());
             }
         }
         */
        /*
        if (Datas.length > 1){
            if(Datas[Datas.length-1][j-1] != null)
                Datas[Datas.length-1][j-1] = Datas[Datas.length-1][j-1].trim();
        }
        */
        //System.out.println( Datas[Datas.length-1][j-1]);
        rs.close(); //닫아줘야 실행가능
        st.close();
        con.close();
        return Datas;   //받아온 데이터를 속성명 없이 사용하려려면 Datas[1] 부터 사용하면 된다.
                        //데이터가 아예 없을 수도 있으니 예외처리 할 것
    }
    // other methods.. 
}
