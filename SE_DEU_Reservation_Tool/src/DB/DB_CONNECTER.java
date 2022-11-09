package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;


public class DB_CONNECTER {
    private static DB_CONNECTER uniqueInstance;
    // other instance variable in here
    static private Connection con ;
    static private Statement st;
    private static boolean IN = false;
    
    public static synchronized DB_CONNECTER getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new DB_CONNECTER();
        }
        return uniqueInstance; 
    }
    public static void Connet() throws ClassNotFoundException, SQLException {
        if (!IN){
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
        }
    }
    public static String[][] Exe_Qurey(String qurey) throws SQLException, ClassNotFoundException{
        //Connet();
        ResultSet rs = st.executeQuery(qurey);
        ResultSetMetaData rsmd = rs.getMetaData();
        
        int columnCnt = rsmd.getColumnCount();
        rs.last();    // moves cursor to the last row
        
        String Atrribute[][] = new String[1][columnCnt];    //속성 라인
        String Datas[][] = new String[rs.getRow()+1][columnCnt]; //데이터 라인
        rs.beforeFirst();
        
        for (int i = 0; i < columnCnt; i++)
            Atrribute[0][i] = rsmd.getColumnName(i + 1);    //속성명 정리
        
        Datas[0] = Atrribute[0]; //속성명 추가
        int j=0;
        while (rs.next()) {
            int i = 1;
            //ArrayList<Object> ColumnData= new ArrayList<Object>();
            for (j = 0; j < columnCnt; j++) {
                if (rs.getObject(j+1) == null)
                    Datas[i][j] = "";
                else
                    Datas[i][j] = rs.getObject(j+1).toString();
            }
            i++;
        }
        if (Datas.length > 1)
            Datas[Datas.length-1][j-1] = Datas[Datas.length-1][j-1].trim();
        //System.out.println( Datas[Datas.length-1][j-1]);
        rs.close();
        
        return Datas;   //받아온 데이터를 속성명 없이 사용하려려면 Datas[1] 부터 사용하면 된다.
                        //데이터가 아예 없을 수도 있으니 예외처리 할 것
    }
    // other methods.. 
}