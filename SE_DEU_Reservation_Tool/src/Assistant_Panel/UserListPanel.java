/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assistant_Panel;

/**
 *
 * @author heejin
 */
public class UserListPanel extends javax.swing.JPanel {

    public UserListPanel(int sizeX, int sizeY) {
        this.setLayout(null);
        this.setBounds(0,0,sizeX,sizeY);
        f_editframe = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        tf_sid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_sname = new javax.swing.JTextField();
        tf_sphone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_status = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_reportnum = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        b_back = new javax.swing.JButton();
        b_editcomplete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_slist = new javax.swing.JTable();
        b_delstu = new javax.swing.JButton();
        b_editstu = new javax.swing.JButton();

        f_editframe.setMinimumSize(new java.awt.Dimension(500, 360));
        f_editframe.setPreferredSize(new java.awt.Dimension(500, 360));

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jLabel2.setText("아이디");

        tf_sid.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        tf_sid.setText("jTextField1");

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jLabel3.setText("이름");

        tf_sname.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        tf_sname.setText("jTextField1");

        tf_sphone.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        tf_sphone.setText("jTextField1");

        jLabel4.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jLabel4.setText("전화번호");

        tf_status.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        tf_status.setText("jTextField1");

        jLabel5.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jLabel5.setText("재학상태");

        tf_reportnum.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        tf_reportnum.setText("jTextField1");

        jLabel6.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jLabel6.setText("신고누적횟수");

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

        javax.swing.GroupLayout f_editframeLayout = new javax.swing.GroupLayout(f_editframe.getContentPane());
        f_editframe.getContentPane().setLayout(f_editframeLayout);
        f_editframeLayout.setHorizontalGroup(
            f_editframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f_editframeLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(f_editframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(f_editframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(f_editframeLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(tf_sname, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(f_editframeLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(tf_sid, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(f_editframeLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(tf_reportnum, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(f_editframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(f_editframeLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(tf_status, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(f_editframeLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(tf_sphone, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, f_editframeLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b_back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b_editcomplete)
                        .addGap(60, 60, 60)))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        f_editframeLayout.setVerticalGroup(
            f_editframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(f_editframeLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(f_editframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_sid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(f_editframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_sname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(f_editframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_sphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(f_editframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(f_editframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_reportnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(f_editframeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_back)
                    .addComponent(b_editcomplete))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        setMinimumSize(new java.awt.Dimension(806, 576));

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        jLabel1.setText("학생명단");

        tab_slist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "아이디", "이름", "전화번호", "재학상태", "경고횟수"
            }
        ));
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
/*수정창닫기*/
    private void b_backActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        f_editframe.setVisible(false);
    }                                      
/*진짜 수정*/
    private void b_editcompleteActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
        //수정내용디비로
        f_editframe.setVisible(false);
    }                                              
/*수정창 열기*/
    private void b_editstuActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        //테ㅔ이블에서 학생선택후 해당학생
        
        f_editframe.setTitle("수정");
        f_editframe.setLocationRelativeTo(null);//가운데
        f_editframe.setVisible(true);
    }                                         
/*계정삭제*/
    private void b_delstuActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton b_back;
    private javax.swing.JButton b_delstu;
    private javax.swing.JButton b_editcomplete;
    private javax.swing.JButton b_editstu;
    private javax.swing.JFrame f_editframe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tab_slist;
    private javax.swing.JTextField tf_reportnum;
    private javax.swing.JTextField tf_sid;
    private javax.swing.JTextField tf_sname;
    private javax.swing.JTextField tf_sphone;
    private javax.swing.JTextField tf_status;
    // End of variables declaration                   
}
