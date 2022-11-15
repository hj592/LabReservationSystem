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
            DB_CONNECTER.Update_Qurey("UPDATE Lab_Seat SET seat_status = 1 WHERE lab_id = "+lab+" AND seat_num = "+seat);
        } catch (SQLException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delReserve(String id, String seat){        //예약 삭제 함수
        try {
            DB_CONNECTER.Update_Qurey("DELETE FROM Lab_Seat WHERE lab_id = "+id+" AND seat_num = "+seat);
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
