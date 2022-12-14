/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Assistant;

import DB.DB_CONNECTER;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author heejin
 */
public class ReserveList {
    //SELECT stu_id,lab_id,seat_num,start_date,start_time,end_time,seat_status,status FROM Lab_Seat l JOIN Student s USING (stu_id);
    String[][] data;
    public String[][] getDB(){
        try {
          //  data=DB_CONNECTER.Exe_Qurey("SELECT stu_id,lab_id,seat_num,start_date,start_time,end_time,seat_status,status FROM (SELECT * FROM Lab_Seat ORDER BY end_time DESC, start_date ASC LIMIT 200) as A JOIN Student USING (stu_id)");
            data=DB_CONNECTER.Exe_Qurey("SELECT stu_id,lab_id,seat_num,start_date,start_time,end_time,seat_status,status FROM Lab_Seat JOIN Student USING (stu_id) WHERE date(start_date) >= CURDATE()");
            for(int i = 1; i<data.length;i++){
                if(data[i][6].equals("1"))
                    data[i][6]="승인";
                else if(data[i][6].equals("")){///팀원예약대기상태
                    data[i][6]="예약대기";
                }
                else
                    data[i][6]="미승인";
                if(data[i][7].equals("4"))
                    data[i][7]="관리자";
                else
                    data[i][7]=" - ";
                if(data[i][5].equals("00:00:00"))
                    data[i][5]="24:00:00";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    public void allAccept(){
        String[][] accept;
        try {
            accept=DB_CONNECTER.Exe_Qurey("SELECT lab_id, seat_num, stu_id, end_time FROM Lab_Seat JOIN Student USING (stu_id) WHERE seat_status = 0");
            for(int i=1 ; i<accept.length ;i++){
                if(accept[i][3].equals("00:00:00"))
                    accept[i][3]="24:00:00";
                updateStatus(accept[i][0],accept[i][1],accept[i][2],accept[i][3]);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateStatus(String lab, String seat, String id, String end){        //승인업데이트 함수
        labManager(lab,id,end);
        try {
            DB_CONNECTER.Update_Qurey("UPDATE Lab_Seat SET seat_status = 1 WHERE lab_id = "+lab+" AND seat_num = "+seat+" AND end_time = '"+end+"'");
        } catch (SQLException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delReserve(String lab, String seat,String id){        //예약 삭제 함수
        String[][] manager;
        try {
            DB_CONNECTER.Update_Qurey("DELETE FROM Lab_Seat WHERE lab_id = "+lab+" AND seat_num = "+seat+" AND stu_id = '"+id+"'");
            DB_CONNECTER.Update_Qurey("UPDATE Student SET status = '1' WHERE stu_id = '"+id+"'");
            manager=DB_CONNECTER.Exe_Qurey("SELECT stu_id, MAX(end_time) FROM Lab_Seat WHERE lab_id = "+lab);
            DB_CONNECTER.Update_Qurey("UPDATE Student SET status = '4' WHERE stu_id = '"+manager[1][0]+"'");
        } catch (SQLException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void labManager(String lab, String id, String end){//
        String[][] manager;
        try {
            //해당랩실 현재 관리자조회
            manager=DB_CONNECTER.Exe_Qurey("SELECT stu_id, end_time FROM Lab_Seat JOIN Student USING (stu_id) WHERE STATUS = '4' AND lab_id = "+lab);
            if(manager.length==1)
            {//해당랩실 관리자 없으면 바로 관리자 등록
                DB_CONNECTER.Update_Qurey("UPDATE Student SET status = '4' WHERE stu_id = '"+id+"'");
            }
            else{
                for(int i=1 ; i<manager.length ;i++){
                    if(manager[i][1].equals("00:00:00"))
                        manager[i][1]="24:00:00";
                }
                int ori = Integer.parseInt(manager[1][1].substring(0, 2));
                int up = Integer.parseInt(end.substring(0, 2));
                if(up>ori){
                    DB_CONNECTER.Update_Qurey("UPDATE Student SET status = '1' WHERE stu_id = '"+manager[1][0]+"'");
                    DB_CONNECTER.Update_Qurey("UPDATE Student SET status = '4' WHERE stu_id = '"+id+"'");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
