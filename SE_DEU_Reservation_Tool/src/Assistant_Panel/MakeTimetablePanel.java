/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assistant_Panel;

import DB.DB_CONNECTER;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import src.Assistant.TimeTable;

/**
 *
 * @author heejin
 */
public class MakeTimetablePanel extends javax.swing.JPanel {
    TimeTable a = new TimeTable();
    public void set_for_Student(){
       // jLabel7.setVisible(false);
        jPanel1.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        
        b_createsub.setVisible(false);
        b_delsub.setVisible(false);
        b_editsub.setVisible(false);
        
        jLabel7.setText("시간표");
    }

    public MakeTimetablePanel(int sizeX, int sizeY) {
        this.setLayout(null);
        this.setBounds(0,0,sizeX,sizeY);
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tf_title = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_profid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cb_labnum = new javax.swing.JComboBox<>();
        cb_day = new javax.swing.JComboBox<>();
        cb_start = new javax.swing.JComboBox<>();
        cb_end = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_911 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab_915 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tab_916 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tab_918 = new javax.swing.JTable();
        b_createsub = new javax.swing.JButton();
        b_delsub = new javax.swing.JButton();
        b_editsub = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(806, 576));
        setPreferredSize(new java.awt.Dimension(806, 576));

        jLabel7.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        jLabel7.setText("시간표 입력");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel4.setText("요일");

        jLabel5.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel5.setText("시작");

        jLabel6.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel6.setText("종료");

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel1.setText("과목");

        tf_title.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        tf_title.setText("");

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel2.setText("교수 ID");

        tf_profid.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        tf_profid.setText("");

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel3.setText("실습실");

        cb_labnum.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        cb_labnum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "911", "915", "916", "918" }));

        cb_day.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        cb_day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "월요일", "화요일", "수요일", "목요일", "금요일" }));

        cb_start.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        cb_start.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1교시 (09:00 - 09:50)", "2교시 (10:00 - 10:50)", "3교시 (11:00 - 11:50)", "4교시 (12:00 - 12:50)", "5교시 (13:00 - 13:50)", "6교시 (14:00 - 14:50)", "7교시 (15:00 - 15:50)", "8교시 (16:00 - 16:50)", "9교시 (17:00 - 17:50)" }));

        cb_end.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        cb_end.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1교시 (09:00 - 09:50)", "2교시 (10:00 - 10:50)", "3교시 (11:00 - 11:50)", "4교시 (12:00 - 12:50)", "5교시 (13:00 - 13:50)", "6교시 (14:00 - 14:50)", "7교시 (15:00 - 15:50)", "8교시 (16:00 - 16:50)", "9교시 (17:00 - 17:50)" }));

        jLabel8.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        jLabel8.setText("교과목 정보");

        jLabel9.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        jLabel9.setText("장소");

        jLabel10.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        jLabel10.setText("시간");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 8, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(cb_start, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(cb_day, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(cb_labnum, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(tf_profid, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(tf_title, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(cb_end, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_title, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_profid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cb_labnum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb_day, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cb_start, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_end, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("맑은 고딕", 1, 11)); // NOI18N
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(475, 500));
        jTabbedPane1.setOpaque(true);
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(475, 500));
        jTabbedPane1.setVerifyInputWhenFocusTarget(false);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 250));

        tab_911.setAutoCreateRowSorter(true);
        tab_911.setFont(new java.awt.Font("맑은 고딕", 0, 11)); // NOI18N
        tab_911.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "", "월", "화", "수", "목", "금"
            }
        ));
        showtable("911");
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
        tab_915.setFont(new java.awt.Font("맑은 고딕", 0, 11)); // NOI18N
        tab_915.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "", "월", "화", "수", "목", "금"
            }
        ));
        showtable("915");
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
        tab_916.setFont(new java.awt.Font("맑은 고딕", 0, 11)); // NOI18N
        tab_916.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
               
            },
            new String [] {
                "", "월", "화", "수", "목", "금"
            }
        ));
        showtable("916");
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
        tab_918.setFont(new java.awt.Font("맑은 고딕", 0, 11)); // NOI18N
        tab_918.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "", "월", "화", "수", "목", "금"
            }
        ));
        showtable("918");
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

        b_createsub.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        b_createsub.setText("입력");
        b_createsub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_createsubActionPerformed(evt);
            }
        });

        b_delsub.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        b_delsub.setText("삭제");
        b_delsub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_delsubActionPerformed(evt);
            }
        });

        b_editsub.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        b_editsub.setText("수정");
        b_editsub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_editsubActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(b_delsub, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b_editsub, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b_createsub, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(b_createsub)
                            .addComponent(b_delsub)
                            .addComponent(b_editsub)))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>       
    /*
    (String)cb_start.getSelectedItem() -> 선택된 아이템 값
    cb_start.getItemCount() -> 총개수 9
    cb_start.getSelectedIndex() -> 선택된 아이템 인덱스 0~8
    */
/*시간표 입력*/
public void showtable(String lab){
         DefaultTableModel tablelab = (DefaultTableModel)tab_911.getModel();
         if(lab=="915"){
            tablelab = (DefaultTableModel)tab_915.getModel();
         }
         else if(lab=="918"){
            tablelab = (DefaultTableModel)tab_918.getModel();
         }
         else if(lab=="916"){
             tablelab = (DefaultTableModel)tab_916.getModel();
         }
         
            tablelab.setNumRows(0);
            String[][] timetable = a.getTimetable(lab);
            for(int i = 0;i<timetable.length;i++){
                tablelab.insertRow(tablelab.getRowCount(), new Object[]{
                    timetable[i][0],
                    timetable[i][1],
                    timetable[i][2],
                    timetable[i][3],
                    timetable[i][4],
                    timetable[i][5]
                });
            }
    }
    private void b_createsubActionPerformed(java.awt.event.ActionEvent evt) {   
        String name = a.getPro(tf_profid.getText());
        //int ee = a.existtime((String) cb_labnum.getSelectedItem(), a.getDay(cb_day.getSelectedIndex()),cb_start.getSelectedIndex(), cb_end.getSelectedIndex());
        //System.out.println(ee);
        if(cb_start.getSelectedIndex() > cb_end.getSelectedIndex()){
            System.out.println("시간다시선택하세용 메박");
        }
        else if(tf_title.getText().length()== 0
                ){
            System.out.println("타이틀 입력해");
        }
        else if(name=="0"){
          //교수 아이디 다시입력하세용mgr데이터에 있으면 ㄱ 없으면 ㄴ 글고 입력된값없으면
            System.out.println("교수 아이디 다시입력하세용");
        }
        else if(a.existtime((String) cb_labnum.getSelectedItem(), a.getDay(cb_day.getSelectedIndex()),cb_start.getSelectedIndex(), cb_end.getSelectedIndex())==1){
            System.out.println("시간표겹쳐용 다시 시간표확인하고 선택해");
            showtable((String) cb_labnum.getSelectedItem());
        }
        //시간 겹치는 경우
        else{
            //int a = Integer.toString(Integer.parseInt((String) cb_labnum.getSelectedItem())%10);
            String time = Integer.toString(a.getTime(cb_start.getSelectedIndex(), cb_end.getSelectedIndex()));
            String id = Integer.toString(Integer.parseInt((String) cb_labnum.getSelectedItem())%10)+Integer.toString(cb_day.getSelectedIndex()+1) + time;
            String day =a.getDay(cb_day.getSelectedIndex());
            System.out.println(id);
            System.out.println(a.getDay(cb_day.getSelectedIndex()));
            System.out.println(cb_start.getSelectedIndex()+","+ cb_end.getSelectedIndex()+":"+time);
            
            try {
                DB_CONNECTER.Update_Qurey("INSERT INTO Week_calender (id,prof_id,lab_id,class_name,"+day+") VALUES ("+id+",'"+tf_profid.getText()+"',"+cb_labnum.getSelectedItem()+",'"+tf_title.getText()+"','"+time+"')");
                showtable((String) cb_labnum.getSelectedItem());
            } catch (SQLException ex) {
                Logger.getLogger(MakeTimetablePanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MakeTimetablePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(name);
    }                                           
/*시간표 수정*/
    private void b_editsubActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        
    }                                         
/*시간표 삭제*/
    private void b_delsubActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        int nRow = -1;
         int nCol = -1;
         nRow = tab_915.getSelectedRow();
         nCol = tab_915.getSelectedColumn();
         System.out.println(nRow+":"+nCol);
    }                                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton b_createsub;
    private javax.swing.JButton b_delsub;
    private javax.swing.JButton b_editsub;
    private javax.swing.JComboBox<String> cb_day;
    private javax.swing.JComboBox<String> cb_end;
    private javax.swing.JComboBox<String> cb_labnum;
    private javax.swing.JComboBox<String> cb_start;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tab_911;
    private javax.swing.JTable tab_915;
    private javax.swing.JTable tab_916;
    private javax.swing.JTable tab_918;
    private javax.swing.JTextField tf_profid;
    private javax.swing.JTextField tf_title;
    // End of variables declaration                   
}