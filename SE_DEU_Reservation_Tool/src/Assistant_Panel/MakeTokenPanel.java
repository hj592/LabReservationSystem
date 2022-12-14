/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assistant_Panel;

import DB.DB_CONNECTER;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.Assistant.MakeToken;

/**
 *
 * @author heejin
 */
public class MakeTokenPanel extends javax.swing.JPanel {
        MakeToken token = new MakeToken();

    public MakeTokenPanel(int sizeX, int sizeY) {
        this.setLayout(null);
        this.setBounds(0,0,sizeX,sizeY);
        b_deltoken = new javax.swing.JButton();
        tf_tokennum = new javax.swing.JTextField();
        b_maketoken = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        la_tokendate = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(806, 576));
        setBackground(new java.awt.Color(255, 255, 255));

        b_deltoken.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        b_deltoken.setText("토큰 삭제");
        b_deltoken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_deltokenActionPerformed(evt);
            }
        });

        tf_tokennum.setFont(new java.awt.Font("맑은 고딕", 1, 36)); // NOI18N
        tf_tokennum.setText("  "+token.getKey());
        tf_tokennum.setEnabled(false);
        tf_tokennum.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        b_maketoken.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N        
        b_maketoken.setEnabled(token.getExist());
        b_maketoken.setText("토큰 생성");
        b_maketoken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tb_maketokenActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        jLabel1.setText("TOKEN");

        la_tokendate.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        la_tokendate.setText(token.getDate());

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel3.setText("토큰 생성일");

        jLabel4.setFont(new java.awt.Font("맑은 고딕", 1, 36)); // NOI18N
        jLabel4.setText("토큰 생성");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(la_tokendate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_tokennum)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(b_maketoken, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103)
                                .addComponent(b_deltoken, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel4)))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b_deltoken, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_maketoken, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(tf_tokennum, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(la_tokendate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(190, Short.MAX_VALUE))
        );
    }// </editor-fold>                  
/*토큰생성*/
    private void tb_maketokenActionPerformed(java.awt.event.ActionEvent evt) {   
        String key = token.getToken();
        SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");		
        String format_time = format.format (System.currentTimeMillis());
            try {
                DB_CONNECTER.Update_Qurey("INSERT INTO Token values('2','"+key+"','"+format_time+"')");
            } catch (SQLException ex) {
                Logger.getLogger(MakeTokenPanel.class.getName()).log(Level.SEVERE, null, ex);
            }catch (ClassNotFoundException ex) {
                Logger.getLogger(MakeTokenPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        token.getTokenDb();
        tf_tokennum.setText("  "+token.getKey());
        la_tokendate.setText(token.getDate());
        b_maketoken.setEnabled(token.getExist());
    }                                            
/*토큰삭제*/
    private void b_deltokenActionPerformed(java.awt.event.ActionEvent evt) {                                           
            try {
                DB_CONNECTER.Update_Qurey("DELETE FROM Token WHERE Token='"+token.getKey()+"'");
            } catch (SQLException ex) {
                Logger.getLogger(MakeTokenPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MakeTokenPanel.class.getName()).log(Level.SEVERE, null, ex);
            }        
        token.getTokenDb();
        tf_tokennum.setText("  "+token.getKey());
        la_tokendate.setText(token.getDate());
        b_maketoken.setEnabled(token.getExist());
    }                                          


    // Variables declaration - do not modify                     
    private javax.swing.JButton b_deltoken;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel la_tokendate;
    private javax.swing.JButton b_maketoken;
    private javax.swing.JTextField tf_tokennum;
    // End of variables declaration                   
}
