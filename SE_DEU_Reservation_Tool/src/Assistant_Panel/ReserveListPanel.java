/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assistant_Panel;

import javax.swing.table.DefaultTableModel;
import src.Assistant.ReserveList;

/**
 *
 * @author heejin
 */
public class ReserveListPanel extends javax.swing.JPanel {
    ReserveList a = new ReserveList();
    public ReserveListPanel(int sizeX, int sizeY) {
        this.setLayout(null);
        this.setBounds(0,0,sizeX,sizeY);
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_reservelist = new javax.swing.JTable();
        b_delreserve = new javax.swing.JButton();
        b_okreserve = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(806, 576));
        setPreferredSize(new java.awt.Dimension(806, 576));

        tab_reservelist.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        tab_reservelist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "실습실", "좌석", "날짜", "시작", "종료", "상태", "권한"
            }
        ));
        showtable();
        tab_reservelist.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tab_reservelist);

        b_delreserve.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        b_delreserve.setText("취소");
        b_delreserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_delreserveActionPerformed(evt);
            }
        });

        b_okreserve.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        b_okreserve.setText("승인");
        b_okreserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_okreserveActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        jLabel1.setText("예약 명단");

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
                .addComponent(b_delreserve, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_okreserve, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_delreserve, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_okreserve, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>         
    
    public void showtable(){
         DefaultTableModel table = (DefaultTableModel)tab_reservelist.getModel();
            table.setNumRows(0);
            String[][] timetable = a.getDB();
            for(int i = 1;i<timetable.length;i++){
                table.insertRow(table.getRowCount(), new Object[]{
                    timetable[i][0],
                    timetable[i][1],
                    timetable[i][2],
                    timetable[i][3],
                    timetable[i][4],
                    timetable[i][5],
                    timetable[i][6],
                    timetable[i][7]
                });
            }
    }
/*예약승인*/
    private void b_okreserveActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

/*예약취소*/
    private void b_delreserveActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            


    // Variables declaration - do not modify                     
    private javax.swing.JButton b_delreserve;
    private javax.swing.JButton b_okreserve;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tab_reservelist;
    // End of variables declaration                   
}