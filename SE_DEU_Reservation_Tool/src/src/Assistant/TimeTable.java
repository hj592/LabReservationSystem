package src.Assistant;

import DB.DB_CONNECTER;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 테이블 입력
 * @author heejin
 */
public class TimeTable {
    String[][] timeTable = new String[6][9];
    String[][] data;
    public int getTime(int start, int end){
        return (start+1)*10+(end+1);
    }
    public String getDay(int n){
        String day="";
        if (n==0) day = "mon_class";
        else if(n==1) day = "tue_class";
        else if(n==2) day = "wed_class";
        else if(n==3) day = "thu_class";
        else day = "fri_class";
        return day;
    }
    public String getPro(String id){
        String name = "0";
        try {
            String[][] pname = DB_CONNECTER.Exe_Qurey("SELECT mgr_name FROM Manager WHERE mgr_id='"+id+"'");            
            if(pname.length!=1) 
                name = pname[1][0];            
        } catch (SQLException ex) {
            Logger.getLogger(TimeTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TimeTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }
    // 시간표 겹ㅊ ㅣ는지 안겹치는지 해당 랩+ 시작+끝 +요일(시간표 아이디로 넘겨줘도 ㄱㅊ)
   public int existtime(String lab, String day, int start, int end){
        try {
            String[][] dbexist = DB_CONNECTER.Exe_Qurey("SELECT "+day+" FROM Week_calender WHERE lab_id="+lab+" AND "+day+" IS NOT NULL");
            if (dbexist.length==1)
                return 0;
            else{
                for(int i=1;i<dbexist.length;i++){
                    int s = Integer.parseInt(dbexist[i][0])/10 -1;
                    int e= Integer.parseInt(dbexist[i][0])%10;
                    System.out.println(s+" : "+e);
                    for(int j=s;j<e;j++){
                        if(j==start)//겹침
                            return 1;
                        else if(j==end)
                            return 1;                            
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimeTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TimeTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
   } 
    
    //INSERT INTO Week_calender (id,prof_id,lab_id,class_name,mon_class) VALUES (112,'10000',911,'객체','12')
}
