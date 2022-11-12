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
    public void getDB(){
        try {
            data=DB_CONNECTER.Exe_Qurey("SELECT stu_id,lab_id,seat_num,start_date,start_time,end_time,seat_status,status FROM Lab_Seat JOIN Student USING (stu_id)");
        } catch (SQLException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
