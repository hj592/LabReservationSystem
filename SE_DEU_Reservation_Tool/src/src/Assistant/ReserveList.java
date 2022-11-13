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
                else if(data[i][6].equals("-1")){///팀원예약대기상태
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
            accept=DB_CONNECTER.Exe_Qurey("SELECT lab_id,seat_num FROM Lab_Seat WHERE seat_status = 0");
            for(int i=1 ; i<accept.length ;i++){
                updateStatus(accept[i][0],accept[i][1]);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateStatus(String id, String seat){        //승인업데이트 함수
        try {
            DB_CONNECTER.Update_Qurey("UPDATE Lab_Seat SET seat_status = 1 WHERE lab_id = "+id+" AND seat_num = "+seat);
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
    
}
