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
    public ReserveListPanel(int sizeX, int sizeY) {
        this.setLayout(null);
        this.setBounds(0,0,sizeX,sizeY);
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_reservelist = new javax.swing.JTable();
        b_delreserve = new javax.swing.JButton();
        b_okreserve = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        b_allAccept = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(806, 576));
        setPreferredSize(new java.awt.Dimension(806, 576));

        tab_reservelist.setFont(new java.awt.Font("맑은 고딕", 0, 13)); // NOI18N
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
        if (tab_reservelist.getColumnModel().getColumnCount() > 0) {
            tab_reservelist.getColumnModel().getColumn(0).setMinWidth(110);
            tab_reservelist.getColumnModel().getColumn(0).setPreferredWidth(110);
            tab_reservelist.getColumnModel().getColumn(0).setMaxWidth(110);
            tab_reservelist.getColumnModel().getColumn(1).setMinWidth(50);
            tab_reservelist.getColumnModel().getColumn(1).setPreferredWidth(50);
            tab_reservelist.getColumnModel().getColumn(1).setMaxWidth(50);
            tab_reservelist.getColumnModel().getColumn(2).setMinWidth(50);
            tab_reservelist.getColumnModel().getColumn(2).setPreferredWidth(50);
            tab_reservelist.getColumnModel().getColumn(2).setMaxWidth(50);
            tab_reservelist.getColumnModel().getColumn(4).setMinWidth(130);
            tab_reservelist.getColumnModel().getColumn(4).setPreferredWidth(130);
            tab_reservelist.getColumnModel().getColumn(4).setMaxWidth(130);
            tab_reservelist.getColumnModel().getColumn(5).setMinWidth(130);
            tab_reservelist.getColumnModel().getColumn(5).setPreferredWidth(130);
            tab_reservelist.getColumnModel().getColumn(5).setMaxWidth(130);
            tab_reservelist.getColumnModel().getColumn(6).setMinWidth(70);
            tab_reservelist.getColumnModel().getColumn(6).setPreferredWidth(70);
            tab_reservelist.getColumnModel().getColumn(6).setMaxWidth(70);
            tab_reservelist.getColumnModel().getColumn(7).setMinWidth(70);
            tab_reservelist.getColumnModel().getColumn(7).setPreferredWidth(70);
            tab_reservelist.getColumnModel().getColumn(7).setMaxWidth(70);
        }

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

        b_allAccept.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        b_allAccept.setText("일괄 승인");
        b_allAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_allAcceptActionPerformed(evt);
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
                .addComponent(b_delreserve, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_okreserve, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_allAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_delreserve, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_okreserve, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_allAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>      
    ReserveList r = new ReserveList();
    public void showtable(){
         DefaultTableModel table = (DefaultTableModel)tab_reservelist.getModel();
            table.setNumRows(0);
            String[][] timetable = r.getDB();
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
        int nRow =-1;
        nRow = tab_reservelist.getSelectedRow();        
        if(nRow!=-1&&tab_reservelist.getValueAt(nRow,6).equals("미승인")){
            r.updateStatus((String) tab_reservelist.getValueAt(nRow,1), (String) tab_reservelist.getValueAt(nRow,2));
            showtable();
        }
    }                                           

/*예약취소*/
    private void b_delreserveActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        int nRow =-1;
        nRow = tab_reservelist.getSelectedRow();        
        if(nRow!=-1){
            r.delReserve((String) tab_reservelist.getValueAt(nRow,1), (String) tab_reservelist.getValueAt(nRow,2));
            showtable();
        }
    }                                            

    /*일괄승인*/
    private void b_allAcceptActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        r.allAccept();
        showtable();
    }                                           


    // Variables declaration - do not modify                     
    private javax.swing.JButton b_allAccept;
    private javax.swing.JButton b_delreserve;
    private javax.swing.JButton b_okreserve;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tab_reservelist;               
}