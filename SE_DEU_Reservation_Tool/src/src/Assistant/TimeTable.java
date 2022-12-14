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

    String[][] subinfo;    
    String[][] data;
    public int getTime(int start, int end){
        return (start+1)*10+(end+1);
    }   
    
    public void getDb(String lab){
        try {
            data = DB_CONNECTER.Exe_Qurey("SELECT id,prof_id,class_name FROM Week_calender WHERE lab_id = "+lab);
            
        } catch (SQLException ex) {
            Logger.getLogger(TimeTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TimeTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return data;
    }
    
    public String[][] getTimetable(String lab){
        getDb(lab);
        String[][] timeTable = new String[9][6];
        for(int i=0;i<9;i++){
           // int a = i+1;
            timeTable[i][0]=String.valueOf(i+1);
        }
//        System.out.println(data[1][0]);
        if(data.length==1)
            return timeTable;
        for(int i=1;i<data.length;i++){
            int id = Integer.parseInt(data[i][0])%1000; //i번째의 아이디 겟
            int day = id/100; //요일
            int start = (id%100)/10-1;//시작교시
            int end = id%10;//끝교시
            String name = data[i][2]+"("+getPro(data[i][1])+")";
            for(int j=start;j<end;j++){
                timeTable[j][day] = name;
            }
        }
        return timeTable;
    }
    public String getDay(int n){
        String day="";
        switch (n) {
            case 0:
                day = "mon_class";
                break;
            case 1:
                day = "tue_class";
                break;
            case 2:
                day = "wed_class";
                break;
            case 3:
                day = "thu_class";
                break;
            default:
                day = "fri_class";
                break;
        }
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
    public String[][] getSub(String labday, String title){
        try {
            subinfo = DB_CONNECTER.Exe_Qurey("SELECT id,prof_id from Week_calender WHERE id LIKE '"+labday+"%' && class_name = '"+title+"'");
        } catch (SQLException ex) {
            Logger.getLogger(TimeTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TimeTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subinfo;
    }
    public void delSub(String id){
        try {
            DB_CONNECTER.Update_Qurey("DELETE FROM Week_calender WHERE id = "+id);
        } catch (SQLException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
