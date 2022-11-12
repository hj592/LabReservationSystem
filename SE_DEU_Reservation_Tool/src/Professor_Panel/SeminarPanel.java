/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Professor_Panel;

import DB.DB_CONNECTER;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author admin
 */
public class SeminarPanel extends javax.swing.JPanel {

    
    public SeminarPanel(int sizeX, int sizeY) {    
        
    this.setLayout(null);
    this.setBounds(0,0,sizeX,sizeY);
            jLabel7 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_911 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab_915 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tab_916 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tab_918 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(806, 576));
        setPreferredSize(new java.awt.Dimension(806, 576));

        jLabel7.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        jLabel7.setText("특강 / 세미나 신청");

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(475, 500));
        jTabbedPane1.setOpaque(true);
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(475, 500));
        jTabbedPane1.setVerifyInputWhenFocusTarget(false);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 250));

        tab_911.setAutoCreateRowSorter(true);
        tab_911.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        tab_911.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "월", "화", "수", "목", "금"
            }
        ));
        tab_911.setColumnSelectionAllowed(true);
        tab_911.setIntercellSpacing(new java.awt.Dimension(3, 3));
        tab_911.setMinimumSize(new java.awt.Dimension(450, 440));
        tab_911.setName(""); // NOI18N
        tab_911.setPreferredSize(new java.awt.Dimension(450, 440));
        tab_911.setRowHeight(49);
        tab_911.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tab_911);
        tab_911.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tab_911.getColumnModel().getColumnCount() > 0) {
            tab_911.getColumnModel().getColumn(0).setMinWidth(20);
            tab_911.getColumnModel().getColumn(0).setPreferredWidth(20);
            tab_911.getColumnModel().getColumn(0).setMaxWidth(20);
        }

        jTabbedPane1.addTab("911", null, jScrollPane1, "");

        jScrollPane2.setPreferredSize(new java.awt.Dimension(452, 250));

        tab_915.setAutoCreateRowSorter(true);
        tab_915.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        tab_915.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "월", "화", "수", "목", "금"
            }
        ));
        tab_915.setColumnSelectionAllowed(true);
        tab_915.setIntercellSpacing(new java.awt.Dimension(3, 3));
        tab_915.setMinimumSize(new java.awt.Dimension(450, 440));
        tab_915.setName(""); // NOI18N
        tab_915.setPreferredSize(new java.awt.Dimension(450, 440));
        tab_915.setRowHeight(49);
        tab_915.setShowGrid(true);
        tab_915.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tab_915);
        tab_915.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tab_915.getColumnModel().getColumnCount() > 0) {
            tab_915.getColumnModel().getColumn(0).setMinWidth(20);
            tab_915.getColumnModel().getColumn(0).setPreferredWidth(20);
            tab_915.getColumnModel().getColumn(0).setMaxWidth(20);
        }

        jTabbedPane1.addTab("915", null, jScrollPane2, "");

        jScrollPane3.setPreferredSize(new java.awt.Dimension(452, 250));

        tab_916.setAutoCreateRowSorter(true);
        tab_916.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        tab_916.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "월", "화", "수", "목", "금"
            }
        ));
        tab_916.setColumnSelectionAllowed(true);
        tab_916.setIntercellSpacing(new java.awt.Dimension(3, 3));
        tab_916.setMinimumSize(new java.awt.Dimension(450, 440));
        tab_916.setName(""); // NOI18N
        tab_916.setPreferredSize(new java.awt.Dimension(450, 440));
        tab_916.setRowHeight(49);
        tab_916.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tab_916);
        tab_916.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tab_916.getColumnModel().getColumnCount() > 0) {
            tab_916.getColumnModel().getColumn(0).setMinWidth(20);
            tab_916.getColumnModel().getColumn(0).setPreferredWidth(20);
            tab_916.getColumnModel().getColumn(0).setMaxWidth(20);
        }

        jTabbedPane1.addTab("916", null, jScrollPane3, "");

        jScrollPane4.setPreferredSize(new java.awt.Dimension(452, 250));

        tab_918.setAutoCreateRowSorter(true);
        tab_918.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        tab_918.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "월", "화", "수", "목", "금"
            }
        ));
        tab_918.setColumnSelectionAllowed(true);
        tab_918.setIntercellSpacing(new java.awt.Dimension(3, 3));
        tab_918.setMinimumSize(new java.awt.Dimension(450, 440));
        tab_918.setName(""); // NOI18N
        tab_918.setPreferredSize(new java.awt.Dimension(450, 440));
        tab_918.setRowHeight(49);
        tab_918.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tab_918);
        tab_918.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tab_918.getColumnModel().getColumnCount() > 0) {
            tab_918.getColumnModel().getColumn(0).setMinWidth(20);
            tab_918.getColumnModel().getColumn(0).setPreferredWidth(20);
            tab_918.getColumnModel().getColumn(0).setMaxWidth(20);
        }

        jTabbedPane1.addTab("918", null, jScrollPane4, "");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 710, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");
    
    }
    
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tab_911;
    private javax.swing.JTable tab_915;
    private javax.swing.JTable tab_916;
    private javax.swing.JTable tab_918;
    
}
