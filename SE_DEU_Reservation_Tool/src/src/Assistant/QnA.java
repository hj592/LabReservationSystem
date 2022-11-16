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
public class QnA {
    String[][] data;
    public String[][] getDB(){
        try {
            data=DB_CONNECTER.Exe_Qurey("SELECT board_id,writer,content,add_borad FROM Board");
        } catch (SQLException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    public void delete(String id){
        try {
            DB_CONNECTER.Update_Qurey("DELETE FROM Board WHERE board_id = '"+id+"'");
        } catch (SQLException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String view(String id){
        String ud = "  -" ;
        try {
            data = DB_CONNECTER.Exe_Qurey("SELECT update_board FROM Board WHERE board_id = '"+id+"'");
            if(data[1][0].length()!=0)
                ud=data[1][0];
        } catch (SQLException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ud;
    }
}
