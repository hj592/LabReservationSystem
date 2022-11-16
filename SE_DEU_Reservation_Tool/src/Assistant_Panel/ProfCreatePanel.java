/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assistant_Panel;

import DB.DB_CONNECTER;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import src.Assistant.TimeTable;

/**
 *
 * @author heejin
 */
public class ProfCreatePanel extends javax.swing.JPanel{
     public ProfCreatePanel(int sizeX, int sizeY) {
        this.setLayout(null);
        this.setBounds(0,0,sizeX,sizeY);
         try {
             MaskFormatter fomat = new MaskFormatter("###-####-####");
            ftf_phone = new javax.swing.JFormattedTextField(fomat);
         } catch (ParseException ex) {
             Logger.getLogger(ProfCreatePanel.class.getName()).log(Level.SEVERE, null, ex);
         }
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_pid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_pname = new javax.swing.JTextField();
        b_profcreate = new javax.swing.JButton();
        pf_ppw = new javax.swing.JPasswordField();
        pf_check = new javax.swing.JPasswordField();

        setMinimumSize(new java.awt.Dimension(806, 576));
        setPreferredSize(new java.awt.Dimension(806, 576));
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 36)); // NOI18N
        jLabel1.setText("교수 계정 생성");

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel2.setText("아이디");

        tf_pid.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel3.setText("비밀번호");

        jLabel4.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel4.setText("비밀번호 확인");

        jLabel5.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel5.setText("전화번호");

        jLabel6.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel6.setText("이름");

        tf_pname.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N

        b_profcreate.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        b_profcreate.setText("생성");
        b_profcreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_profcreateActionPerformed(evt);
            }
        });

        ftf_phone.setText("jFormattedTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(pf_ppw, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tf_pid, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(pf_check, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tf_pname, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(ftf_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(b_profcreate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1)))
                .addContainerGap(290, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_pid, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pf_ppw, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pf_check, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_pname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ftf_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addComponent(b_profcreate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
    }// </editor-fold>                       

    /* 교수계정생성버튼클릭 */
    private void b_profcreateActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        //비번&비번확인 일치하는지 확인
        System.out.println(pf_ppw.getPassword().equals(pf_check.getPassword()));
        String password = pf_ppw.getText();
	String pwdCheck = pf_check.getText();
        TimeTable tt = new TimeTable();
        if(pf_ppw.getPassword().length== 0){
            JOptionPane.showMessageDialog(this, "비밀번호를 입력해주세요.");
        }
        else if(!password.equals(pwdCheck)) {
            JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다");
        }
        // 아이디 있는지없는지 확인
        else if(!tt.getPro(tf_pid.getText()).equals("0")){
            System.out.println("");
            JOptionPane.showMessageDialog(this, "존재하는 아이디입니다.");
        }
        else if(tf_pname.getText().length()==0){//이름 공백인지확인
            JOptionPane.showMessageDialog(this, "이름을 입력해주세요.");
        }
        else if(!ftf_phone.getText().substring(0, 3).equals("010")){//전번 시작이 010 인지
            JOptionPane.showMessageDialog(this, "전화번호 입력을 확인해주세요");
        }
        else{
            try {
                DB_CONNECTER.Update_Qurey("INSERT INTO User values('"+tf_pid.getText()+"','"+password+"','3')");
                DB_CONNECTER.Update_Qurey("INSERT INTO Manager values('"+tf_pid.getText()+"','"+tf_pname.getText()+"','"+ftf_phone.getText()+"')");
            } catch (SQLException ex) {
                Logger.getLogger(ProfCreatePanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProfCreatePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }                                            


    // Variables declaration - do not modify                     
    private javax.swing.JButton b_profcreate;
    private javax.swing.JFormattedTextField ftf_phone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField pf_check;
    private javax.swing.JPasswordField pf_ppw;
    private javax.swing.JTextField tf_pid;
    private javax.swing.JTextField tf_pname;
    // End of variables declaration                   
}
