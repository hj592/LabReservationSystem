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
}
