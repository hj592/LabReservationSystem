/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assistant_Panel;

import javax.swing.table.DefaultTableModel;
import src.Assistant.QnA;

/**
 *
 * @author heejin
 */
public class QnAListPanel extends javax.swing.JPanel {

    public QnAListPanel(int sizeX, int sizeY) {
        this.setLayout(null);
        this.setBounds(0,0,sizeX,sizeY);
        d_qnadetail = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        b_detailok = new javax.swing.JButton();
        b_detaildel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_qna = new javax.swing.JTable();
        b_qnaopen = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        b_qnadel = new javax.swing.JButton();

        d_qnadetail.setMinimumSize(new java.awt.Dimension(700, 360));

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jLabel2.setText("작성자 아이디");

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jLabel3.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jLabel4.setText("작성일");

        jLabel5.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jLabel5.setText("jLabel5");

        jLabel6.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jLabel6.setText("수정일");

        jLabel7.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jLabel7.setText("jLabel5");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jTextArea1.setEnabled(false);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        b_detailok.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        b_detailok.setText("확인");
        b_detailok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_detailokActionPerformed(evt);
            }
        });

        b_detaildel.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        b_detaildel.setText("삭제");
        b_detaildel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_detaildelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout d_qnadetailLayout = new javax.swing.GroupLayout(d_qnadetail.getContentPane());
        d_qnadetail.getContentPane().setLayout(d_qnadetailLayout);
        d_qnadetailLayout.setHorizontalGroup(
            d_qnadetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(d_qnadetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(d_qnadetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                    .addGroup(d_qnadetailLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d_qnadetailLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(b_detaildel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_detailok, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addContainerGap())
        );
        d_qnadetailLayout.setVerticalGroup(
            d_qnadetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_qnadetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(d_qnadetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(d_qnadetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_detailok)
                    .addComponent(b_detaildel))
                .addGap(18, 18, 18))
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(806, 576));
        setPreferredSize(new java.awt.Dimension(806, 576));

        tab_qna.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        tab_qna.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "No.", "내용", "작성자", "작성일"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tab_qna.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tab_qna);
        if (tab_qna.getColumnModel().getColumnCount() > 0) {
            tab_qna.getColumnModel().getColumn(0).setMinWidth(30);
            tab_qna.getColumnModel().getColumn(0).setPreferredWidth(30);
            tab_qna.getColumnModel().getColumn(0).setMaxWidth(30);
            tab_qna.getColumnModel().getColumn(2).setMinWidth(110);
            tab_qna.getColumnModel().getColumn(2).setPreferredWidth(110);
            tab_qna.getColumnModel().getColumn(2).setMaxWidth(110);
            tab_qna.getColumnModel().getColumn(3).setMinWidth(180);
            tab_qna.getColumnModel().getColumn(3).setPreferredWidth(180);
            tab_qna.getColumnModel().getColumn(3).setMaxWidth(180);
        }
        showtable();
        b_qnaopen.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        b_qnaopen.setText("조회");
        b_qnaopen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_qnaopenActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        jLabel1.setText("문의사항");

        b_qnadel.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        b_qnadel.setText("삭제");
        b_qnadel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_qnadelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(b_qnadel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_qnaopen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_qnaopen)
                    .addComponent(b_qnadel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>       
    QnA s = new QnA(); 
        int nRow =-1;
    public void showtable(){
         DefaultTableModel table = (DefaultTableModel)tab_qna.getModel();
            table.setNumRows(0);
            String[][] qnatlist = s.getDB();
            for(int i = 1;i<qnatlist.length;i++){
                table.insertRow(table.getRowCount(), new Object[]{
                    qnatlist[i][0],
                    qnatlist[i][2],
                    qnatlist[i][1],
                    qnatlist[i][3]
                });
            }
    }
/*QnA삭제버튼*/
    private void b_qnadelActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        nRow=-1;
        nRow = tab_qna.getSelectedRow();        
        if(nRow!=-1){
            s.delete((String) tab_qna.getValueAt(nRow,0));
            showtable();
        }
        else{
            //"학생을 선택하세요"
        }
        d_qnadetail.setVisible(false);
        showtable();
    }                                        
/*QnA조회버튼*/
    private void b_qnaopenActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here: 테이블에서 누른 목록의 내용이 다이얼로그에 열리도록
        int nRow =-1;
        nRow = tab_qna.getSelectedRow();        
        if(nRow!=-1){
            // tab_slist.getValueAt(nRow,0)
            //tf_sid.setText(tab_qna.getValueAt(nRow,0));
            jTextArea1.setText((String) tab_qna.getValueAt(nRow,1));
            jLabel3.setText((String) tab_qna.getValueAt(nRow,2));
            jLabel5.setText((String) tab_qna.getValueAt(nRow,3));
            jLabel7.setText(s.view((String) tab_qna.getValueAt(nRow,0)));
            //f_editframe.setTitle("수정");
            d_qnadetail.setLocationRelativeTo(null);//가운데
            d_qnadetail.setVisible(true);
        }
        else{
            //"학생을 선택하세요"
        }
    }                                         
/*디테일창 확인버튼*/
    private void b_detailokActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        d_qnadetail.setVisible(false);
    }                                          
/*디테일창 삭제버튼*/
    private void b_detaildelActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here: 
         s.delete((String) tab_qna.getValueAt(nRow,0));
        d_qnadetail.setVisible(false);
        showtable();
    }                                           


    // Variables declaration - do not modify                     
    private javax.swing.JButton b_detaildel;
    private javax.swing.JButton b_detailok;
    private javax.swing.JButton b_qnadel;
    private javax.swing.JButton b_qnaopen;
    private javax.swing.JDialog d_qnadetail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tab_qna;
    // End of variables declaration                   
}