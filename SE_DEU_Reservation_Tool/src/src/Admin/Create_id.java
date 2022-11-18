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

/**
 *
 * @author admin
 */
public class Create_id {

    public String getID(String id) {
        String name = "0";
        try {
            String[][] pname = DB_CONNECTER.Exe_Qurey("SELECT user_id FROM User WHERE user_id='" + id + "'");
            if (pname.length != 1)
                name = pname[1][0];
        } catch (SQLException ex) {
            Logger.getLogger(Create_id.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Create_id.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }

}
