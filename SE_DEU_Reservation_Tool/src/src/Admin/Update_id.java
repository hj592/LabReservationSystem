/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Admin;

import DB.DB_CONNECTER;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.Assistant.ReserveList;

/**
 *
 * @author admin
 */
public class Update_id {

    String[][] data;

    public String[][] getDB() {
        try {
            data = DB_CONNECTER.Exe_Qurey("select u.user_id, u.user_pw, u.authority, m.mgr_name, m.phone from User u join Manager m on u.user_id=m.mgr_id where u.authority='" + 2 + "'");
            for (int i = 1; i < data.length; i++)
                data[i][2] = "조교";
        } catch (SQLException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public void delete(String id) {
        try {
            DB_CONNECTER.Update_Qurey("DELETE FROM Manager WHERE mgr_id = '" + id + "'");
            DB_CONNECTER.Update_Qurey("DELETE FROM User WHERE user_id = '" + id + "'");
        } catch (SQLException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(String id, String pw, String phone, String name, String authority) {
        try {
            //DB_CONNECTER.Update_Qurey("UPDATE Student SET status = '"+status+"',stu_name = '"+name+"', phone='"+phone+"', report_cnt = "+cnt+" WHERE stu_id = '"+id+"'");
            DB_CONNECTER.Update_Qurey("UPDATE Manager m left join User u on m.mgr_id=u.user_id SET u.user_pw='" + pw + "', m.mgr_name='" + name + "', m.phone='" + phone + "', u.authority='" + authority + "' WHERE m.mgr_id='" + id + "'");
            /*=======
    public void change(String id, String name, String phone, String cnt){
        try {
            DB_CONNECTER.Update_Qurey("UPDATE Student SET status = '3', stu_name = '"+name+"', phone='"+phone+"', report_cnt = "+cnt+" WHERE stu_id = '"+id+"'");
        } catch (SQLException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void update(String id, String name, String phone, String cnt, String status){
        try {
            DB_CONNECTER.Update_Qurey("UPDATE Student SET status = '"+status+"',stu_name = '"+name+"', phone='"+phone+"', report_cnt = "+cnt+" WHERE stu_id = '"+id+"'");
>>>>>>> Y*/
        } catch (SQLException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
