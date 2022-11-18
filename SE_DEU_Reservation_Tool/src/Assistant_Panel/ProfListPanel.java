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
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import src.Assistant.ReserveList;
import src.Assistant.StuList;

/**
 *
 * @author heejin
 */
public class ProfListPanel extends javax.swing.JPanel {

    public ProfListPanel(int sizeX, int sizeY) {
        this.setLayout(null);
        this.setBounds(0,0,sizeX,sizeY);
        try {
             MaskFormatter fomat = new MaskFormatter("###-####-####");
            ftf_sphone = new javax.swing.JFormattedTextField(fomat);
         } catch (ParseException ex) {
             Logger.getLogger(ProfCreatePanel.class.getName()).log(Level.SEVERE, null, ex);
         }
        f_editframe = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        tf_sid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_sname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        b_back = new javax.swing.JButton();
        b_editcomplete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_slist = new javax.swing.JTable();
        b_delstu = new javax.swing.JButton();
        b_editstu = new javax.swing.JButton();

        f_editframe.setBackground(new java.awt.Color(255, 255, 255));
        f_editframe.setMinimumSize(new java.awt.Dimension(420, 360));
        f_editframe.setPreferredSize(new java.awt.Dimension(420, 360));

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jLabel2.setText("아이디");

        tf_sid.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        tf_sid.setEnabled(false);
        tf_sid.setText("");

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jLabel3.setText("이름");

        tf_sname.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        tf_sname.setText("");

        jLabel4.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jLabel4.setText("전화번호");

        b_back.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        b_back.setText("취소");
        b_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_backActionPerformed(evt);
            }
        });

        b_editcomplete.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        b_editcomplete.setText("수정");
        b_editcomplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_editcompleteActionPerformed(evt);
            }
        });

        ftf_sphone.setText("");

        javax.swing.GroupLayout f_editframeLayout = new javax.swing.GroupLayout(f_editframe.getContentPane());
        f_editframe.getContentPane().setLayout(f_editframeLayout);
        f_editframeLayout.setHorizontalGroup(
            f_editframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f_editframeLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(f_editframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f_editframeLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(tf_sname, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f_editframeLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(tf_sid, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f_editframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(f_editframeLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(ftf_sphone, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f_editframeLayout.createSequentialGroup()
                        .addComponent(b_back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b_editcomplete)
                        .addGap(65, 65, 65)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        f_editframeLayout.setVerticalGroup(
            f_editframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f_editframeLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(f_editframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_sid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(f_editframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_sname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(f_editframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(ftf_sphone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(f_editframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(f_editframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE))
                .addGap(33, 33, 33)
                .addGroup(f_editframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_back)
                    .addComponent(b_editcomplete))
                .addGap(36, 36, 36))
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(806, 576));

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        jLabel1.setText("교수명단");

        tab_slist.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        tab_slist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "아이디", "이름", "전화번호"
            }
        ));
        showtable();
        tab_slist.setRowHeight(20);
        jScrollPane1.setViewportView(tab_slist);

        b_delstu.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        b_delstu.setText("삭제");
        b_delstu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_delstuActionPerformed(evt);
            }
        });

        b_editstu.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        b_editstu.setText("수정");
        b_editstu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_editstuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_delstu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(b_editstu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_delstu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_editstu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>     
    StuList s = new StuList();
    public void showtable(){
         DefaultTableModel table = (DefaultTableModel)tab_slist.getModel();
            table.setNumRows(0);
            String[][] proflist = s.getPDB();
            for(int i = 1;i<proflist.length;i++){
                table.insertRow(table.getRowCount(), new Object[]{
                    proflist[i][0],
                    proflist[i][1],
                    proflist[i][2]
                });
            }
    }
/*수정창닫기*/
    private void b_backActionPerformed(java.awt.event.ActionEvent evt) {   
        f_editframe.setVisible(false);
    }                                      
/*진짜 수정*/
    private void b_editcompleteActionPerformed(java.awt.event.ActionEvent evt) {   
     try {
            DB_CONNECTER.Update_Qurey("UPDATE Manager SET mgr_name = '"+tf_sname.getText()+"', phone = '"+ftf_sphone.getText()+"' WHERE mgr_id = '"+tf_sid.getText()+"'");
        } catch (SQLException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
        }    
        f_editframe.setVisible(false);
        showtable();
    }                                              
/*수정창 열기*/
    private void b_editstuActionPerformed(java.awt.event.ActionEvent evt) {  
        int nRow =-1;
        nRow = tab_slist.getSelectedRow();        
        if(nRow!=-1){
            // tab_slist.getValueAt(nRow,0)
            tf_sid.setText((String) tab_slist.getValueAt(nRow,0));
            tf_sname.setText((String)tab_slist.getValueAt(nRow,1));
            ftf_sphone.setText((String)tab_slist.getValueAt(nRow,2));
            f_editframe.setTitle("수정");
            f_editframe.setLocationRelativeTo(null);//가운데
            f_editframe.setVisible(true);
        }
        else{
            //"학생을 선택하세요"
        }
        
        
    }                                         
/*계정삭제*/
    private void b_delstuActionPerformed(java.awt.event.ActionEvent evt) {                                         
        int nRow =-1;
        nRow = tab_slist.getSelectedRow();        
        if(nRow!=-1){
            try {
            DB_CONNECTER.Update_Qurey("DELETE FROM Manager WHERE mgr_id = '"+(String) tab_slist.getValueAt(nRow,0)+"'");
            DB_CONNECTER.Update_Qurey("DELETE FROM User WHERE user_id = '"+(String) tab_slist.getValueAt(nRow,0)+"'");
            } catch (SQLException ex) {
                Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ReserveList.class.getName()).log(Level.SEVERE, null, ex);
            }
            showtable();
        }
        else{
            //"학생을 선택하세요"
        }
    }                                  


    // Variables declaration - do not modify                     
    private javax.swing.JButton b_back;
    private javax.swing.JButton b_delstu;
    private javax.swing.JButton b_editcomplete;
    private javax.swing.JButton b_editstu;
    private javax.swing.JFrame f_editframe;
    private javax.swing.JFormattedTextField ftf_sphone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tab_slist;
    private javax.swing.JTextField tf_sid;
    private javax.swing.JTextField tf_sname;
    // End of variables declaration                   
}