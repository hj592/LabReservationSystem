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
public class StuList {
    String[][] data;
    String[][] pdata;
    public String[][] getDB(){
        try {
            data=DB_CONNECTER.Exe_Qurey("SELECT * FROM Student");
            for(int i = 1; i<data.length;i++){
                if(data[i][3].equals("1") || data[i][3].equals("4"))
                    data[i][3]="승인";
                else if(data[i][3].equals("2")){
                    data[i][3]="미승인";
                }
                else
                    data[i][3]="경고";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public void update(String id, String name, String phone, String cnt, String status){
        try {
            DB_CONNECTER.Update_Qurey("UPDATE Student SET status = '"+status+"',stu_name = '"+name+"', phone='"+phone+"', report_cnt = "+cnt+" WHERE stu_id = '"+id+"'");
        } catch (SQLException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void change(String id, String name, String phone, String cnt){
        try {
            DB_CONNECTER.Update_Qurey("UPDATE Student SET status = '3', stu_name = '"+name+"', phone='"+phone+"', report_cnt = "+cnt+" WHERE stu_id = '"+id+"'");
        } catch (SQLException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void delete(String id){
        try {
            DB_CONNECTER.Update_Qurey("DELETE FROM Student WHERE stu_id = '"+id+"'");
            DB_CONNECTER.Update_Qurey("DELETE FROM User WHERE user_id = '"+id+"'");
        } catch (SQLException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String[][] getPDB(){
        try {
            pdata=DB_CONNECTER.Exe_Qurey("SELECT mgr_id,mgr_name,phone FROM User JOIN Manager ON user_id = mgr_id WHERE authority = '3'");
        } catch (SQLException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pdata;
    }
}
