package UICreator;

import Assistant_Panel.ProfCreatePanel;
import DB.DB_CONNECTER;
import Reservation_Panel.Basic_Reservation_Panel;
import Reservation_Panel.Lecture_Room_Select;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;


public abstract class Content_Panel extends JPanel {
	//ArrayList<JPanel> Panels = new ArrayList<JPanel>();
	//ArrayList<Basic_Reservation_Panel> r = new ArrayList<Basic_Reservation_Panel>();
	//Lecture_Room_Select Selecter = new Lecture_Room_Select();
	Content_Panel() {
		this.setLayout(null);
                initComponents();
		// this.setBackground(new Color(255,0,0));
	}

	abstract void Set_Multi_Layout();
        
         @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
     // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
   public void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(806, 576));

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 0, 36)); // NOI18N
        jLabel3.setText("실습실 예약 프로그램");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/2004580.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(236, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration    
    // End of variables declaration      
}

class Student_Content_Panel extends Content_Panel {
	Student_Content_Panel() {

	}

	@Override
	void Set_Multi_Layout() {
		// TODO Auto-generated method stub
	}

}

class Assistant_Content_Panel extends Content_Panel{

	@Override
	void Set_Multi_Layout() {
		// TODO Auto-generated method stub
	
	}
}



class Professor_Content_Panel extends Content_Panel{

	@Override
	void Set_Multi_Layout() {
		// TODO Auto-generated method stub
		
	}
}

class Admin_Content_Panel extends Content_Panel{

	@Override
	void Set_Multi_Layout() {
		// TODO Auto-generated method stub
		
	}
}

 class reservation_list_panel extends javax.swing.JPanel {

    /**
     * Creates new form reservation_list_Panel
     */
     String id;
     int SizeX;
     int SizeY;
     reservation_list_panel Me = this;
      final String[] LectNums = {"915", "916", "918", "911"};
    reservation_list_panel(int sizeX,int sizeY,String id) throws SQLException, ClassNotFoundException {
        this.SizeX = SizeX;
        this.SizeY = SizeY;
        this.id = id;
        this.setLayout(null);
        this.setBounds(0,0,sizeX,sizeY);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
            private boolean TimeCheker(){
         return (StartTime.getSelectedIndex() > EndTime.getSelectedIndex());
     }

     public void SettingTime() {
         if (TimeCheker()) {
             StartTime.setSelectedIndex(EndTime.getSelectedIndex());
         }
         try {
             String[][] MY_Reserve = DB_CONNECTER.Exe_Qurey("Select *" + " From Lab_Seat WHERE stu_id='" + id + "';");
             String Date[][] = DB_CONNECTER.Exe_Qurey("select curTime();");
             int nowTIME = Integer.valueOf(Date[1][0].split(":")[0]);
             //int SelectTime = Integer.valueOf(C.getSelectedItem().toString().split(":")[0]);

             int starttime = nowTIME;
             if (Integer.valueOf(MY_Reserve[1][5].split(":")[0]) > starttime) {
                 starttime = Integer.valueOf(MY_Reserve[1][5].split(":")[0]);
             }

             int endtime = 17;
             if (Integer.valueOf(MY_Reserve[1][6].split(":")[0]) > 17) {
                 endtime = 24;
             }
             System.out.println("시간: " + starttime);
             String[] TimeStart = new String[endtime - starttime];
             for (int i = starttime; i < endtime; i++) {
                 TimeStart[i - starttime] = Integer.toString(i) + ":00";
             }
             StartTime = new JComboBox(TimeStart);

             String[] TimeEnd = new String[endtime - starttime];
             for (int i = starttime + 1; i <= endtime; i++) {
                 TimeEnd[i - starttime - 1] = Integer.toString(i) + ":00";
             }
             EndTime = new JComboBox(TimeEnd);
           
         } catch (SQLException ex) {
             Logger.getLogger(Reservation_Panel.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Reservation_Panel.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() throws SQLException, ClassNotFoundException {
        String[][] MY_Reserve = DB_CONNECTER.Exe_Qurey("Select *" + " From Lab_Seat WHERE stu_id='"+id+"';");
        String[][] nowTIME = DB_CONNECTER.Exe_Qurey("select CURTIME();");
        
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
      //  LectNum = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
      //  SeatNum = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        
        
      if( MY_Reserve.length <2 ){
          JOptionPane.showMessageDialog(null, "예약정보가 없습니다.");
          return;
       //   LectNum.setEnabled(false);
         // SeatNum.setEnabled(false);
      //    jButton6.setEnabled(false);
         // jButton7.setEnabled(false);
        //  jButton8.setEnabled(false);
         // StartTime.setEnabled(false);
         // EndTime.setEnabled(false);
        } 
      else {
          int starttime = Integer.valueOf(nowTIME[1][0].split(":")[0]);
          if (Integer.valueOf(MY_Reserve[1][5].split(":")[0]) < starttime) 
              starttime = Integer.valueOf(MY_Reserve[1][5].split(":")[0]);
          
            int endtime = 17;
            if (Integer.valueOf(MY_Reserve[1][6].split(":")[0]) > 17 || Integer.valueOf(MY_Reserve[1][6].split(":")[0]) == 0) 
              endtime = 24;
          System.out.println("시간: " + starttime +", " +endtime);
          String[] TimeStart = new String[endtime - starttime];
          for (int i = starttime; i < endtime; i++) 
              TimeStart[i - starttime] = Integer.toString(i) + ":00";
          StartTime = new JComboBox(TimeStart);

          String[] TimeEnd = new String[endtime - starttime];
          for (int i = starttime + 1; i <= endtime; i++) 
              TimeEnd[i - starttime - 1] = Integer.toString(i) + ":00";
          EndTime = new JComboBox(TimeEnd);

          String[] SeatNums = new String[40];
          for (int i = 1; i <= 40; i++)  
              SeatNums[i - 1] = Integer.toString(i);

          SeatNum = new JComboBox(SeatNums);
          
          LectNum = new JComboBox(LectNums);

          LectNum.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  // jTextField1ActionPerformed(evt);
              }
          });

          LectNum.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
              }
          });

          jButton6.setText("변경");
          jButton6.addActionListener(new ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                   LectNum.getSelectedItem().toString();
                   ArrayList<String> pass =new ArrayList<>();
                  try {
                      String arr[][] = DB_CONNECTER.Exe_Qurey("SELECT lab_id,COUNT(*) FROM Lab_Seat WHERE  end_time>'17:00:00'  GROUP BY lab_id;");
                    //  String arr2[][] = DB_CONNECTER.Exe_Qurey("SELECT *  FROM Lab_Seat Where lab_id='"+ LectNum.getSelectedItem().toString() +"' and seat_num='"+ SeatNum.getSelectedItem().toString() +"';");
                              String[][] arr2 = DB_CONNECTER.Exe_Qurey("Select *" + " From Lab_Seat where lab_id = '" + LectNum.getSelectedItem().toString() + "'"+
                                                " and seat_num='"+ SeatNum.getSelectedItem().toString() + "'"+
                                                " AND NOT(start_time >='"+ EndTime.getSelectedItem().toString()+":00'"+
                                                " OR end_time <='"+StartTime.getSelectedItem().toString() +":00');"); //시간추가,
                     for(int i=1; i<arr.length; i++){
                       if(Integer.valueOf(arr[i][1]) >= 20)
                           pass.add(arr[i][0]);
                     }
                     int MaxLect = 0; //20명이상 순서 인덱스
                      for (int i = 0; i < LectNums.length; i++) {
                          for (int j = 0; j < pass.size(); j++) {
                              if (LectNums[i].equals(pass.get(j)))
                                   MaxLect=i+1;  
                          }
                      }
                                      String Date[][] = DB_CONNECTER.Exe_Qurey("select DAYOFWEEK(curdate());");
                String Date_Time[][] = DB_CONNECTER.Exe_Qurey("select CURTIME();");
                String arr3[][] = DB_CONNECTER.Exe_Qurey("SELECT * FROM Week_calender where lab_id='"+LectNum.getSelectedItem().toString()+"';");
                
                                 //   System.out.println( " 요일: "+Date[1][0] + " 미리예약된 강의실 개수: "+ (arr2.length-1));
                    //일요일은 1
                    int int_TodayDate = (Integer.valueOf(Date[1][0]) +2); //3 4 5 6 7 8 9 : 일 월 화 수 목 금 토 일
                    
                    int_TodayDate = 4; //3 4 5 6 7 8 9 : 일 월 화 수 목 금 토 일
                    
                    System.out.println( " 요일: "+int_TodayDate + " 미리예약된 강의실 개수: "+ (arr3.length-1));
                    int Reserve_Start_Time = Integer.valueOf(StartTime.getSelectedItem().toString().split(":")[0]);                  
                    int Reserve_End_Time = Integer.valueOf(EndTime.getSelectedItem().toString().split(":")[0]);
                    if (int_TodayDate > 3 && int_TodayDate <9 && arr3.length>1) {
                         // System.out.println( "월~금임");
                        for (int i = 1; i < arr3.length; i++) {
                            System.out.println("강의시간: "+arr3[i][int_TodayDate]);
                            if (!(arr3[i][int_TodayDate].equals(""))) {
                                 System.out.println(arr3[i][int_TodayDate]);
                                int Lect_Start_Time = Integer.valueOf(arr3[i][int_TodayDate].substring(0, 1)) + 8;
                                int Lect_End_Time = Integer.valueOf(arr3[i][int_TodayDate].substring(1, 2)) + 8+1;
                                 System.out.println( " 강의 시작시간: "+Lect_Start_Time + " 강의 종료시간: "+ Lect_End_Time);
                                 int check = 0;
                                 for(int k = Reserve_Start_Time; k < Reserve_End_Time ; k++){
                                     if(Lect_Start_Time+check == k && Lect_Start_Time+check < Lect_End_Time){
                                    JOptionPane.showMessageDialog(null, "강의실 시간표와 곂칩니다.");
                                    return;
                                     }
                                }
                                // 예약시작시간이 강의종료 시간보다 앞이면서 예약종료시간이 강의 시작시간보다 뒤일때
                                if ( Integer.valueOf(Date_Time[1][0].split(":")[0]) > Reserve_Start_Time){
                                    JOptionPane.showMessageDialog(null, "예약가능 시간이 지났습니다.\n 한시간 단위로 결정되니 주의하세요.");
                                    return;
                                }
                                /*
                                else if (Reserve_Start_Time <= Lect_End_Time && Reserve_End_Time < Lect_Start_Time) {
                                    JOptionPane.showMessageDialog(null, "강의실 시간표와 곂칩니다.");
                                    return;
                                }
                                */
                            }
                        }
                    }
                    else if(arr3.length > 1){
                        JOptionPane.showMessageDialog(null, "현재 주말예약은 승인되지 않습니다.");
                        return;
                    }
                    // JOptionPane.showMessageDialog(null, arr2[1][4]);
                      //String a = LectNums[Integer.valueOf(arr[1][0]) / 20];
                      if( LectNum.getSelectedIndex() > MaxLect){ 
                          JOptionPane.showMessageDialog(null, "이전 강의실의 예약 대기 인원수가 20명을 넘지 않습니다.확인해주세요.");
                          return ;
                      }
                      else if(arr2.length > 1 && (!arr2[1][3].equals(id))){
                          JOptionPane.showMessageDialog(null, "현재 예약 혹은 예약대기 중인 자리입니다.");
                          return ;
                      }
                      else{
                           int result = JOptionPane.showConfirmDialog(null, "※예약 정보 변경시 주의사항※\n1. 자신을 제외한 다중예약대기좌석이 취소됩니다.\n2. 오후5시 이후의 예약승인은 \n 오후5시 이전으로 예약종료 시 승인이 취소되어 \n 오후5시 이후 승인을 다시 받아야합니다.","confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                           if(result == JOptionPane.NO_OPTION){JOptionPane.showMessageDialog(null, "변경이 취소되었습니다."); return;}
                            DB_CONNECTER.Update_Qurey("DELETE FROM Lab_Seat WHERE stu_id='"+id+"' and seat_status is null;");
                            DB_CONNECTER.Update_Qurey("UPDATE Lab_Seat SET " + 
                                                     "lab_id='"+LectNum.getSelectedItem().toString()+
                                                     "',seat_num='"+SeatNum.getSelectedItem().toString()+
                                                     "',start_time='"+StartTime.getSelectedItem().toString()+
                                                     "',end_time='"+EndTime.getSelectedItem().toString()+
                                                     "' WHERE stu_id='"+id+"';");
                           JOptionPane.showMessageDialog(null, "변경이 완료되었습니다.");
                      }
                  } catch (SQLException ex) {
                      Logger.getLogger(reservation_list_panel.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (ClassNotFoundException ex) {
                      Logger.getLogger(reservation_list_panel.class.getName()).log(Level.SEVERE, null, ex);
                  }
                }
            });
            
            jButton7.setText("반납");
            jButton7.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    
                }
            });
            jButton7.setVisible(false);
            jButton8.setText("취소");
            jButton8.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    
                    try {
                        int result = JOptionPane.showConfirmDialog(null, "모든 예약정보가 사라지며 \n5시 이후의 승인 또한 재승인 받아야합니다.\n취소하시겠습니까?","confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                        if(result == JOptionPane.NO_OPTION){JOptionPane.showMessageDialog(null, "예약이 취소되었습니다."); return;}
                        DB_CONNECTER.Update_Qurey("DELETE FROM Lab_Seat WHERE stu_id='"+id+"';");
                        //Me.revalidate();
                        jButton6.setEnabled(false);
                        jButton8.setEnabled(false);
                    } catch (SQLException ex) {
                        Logger.getLogger(reservation_list_panel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(reservation_list_panel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }
        /**
         * *******************************************************
         */
        

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(806, 576));

        jLabel2.setFont(new java.awt.Font("나눔고딕", 0, 18)); // NOI18N
        jLabel2.setText("실습실");

        jLabel3.setFont(new java.awt.Font("나눔고딕", 1, 24)); // NOI18N
        jLabel3.setText("예약관리");

        jLabel4.setFont(new java.awt.Font("나눔고딕", 0, 18)); // NOI18N
        jLabel4.setText("좌석 번호");

        //jTextField2.setText("좌석번호 불러오는 곳");

        jLabel5.setFont(new java.awt.Font("나눔고딕", 0, 18)); // NOI18N
        jLabel5.setText("사용시간");

        jButton6.setText("연장");
        String[][] strs = null ;
        if (MY_Reserve.length > 1) {
             strs = new String[MY_Reserve.length-1][];
            for (int i = 1; i < MY_Reserve.length; i++) {
                    strs[i-1] = MY_Reserve[i];
            }
        }
                    
            JTable strList = new JTable(strs, MY_Reserve[0]);
            JScrollPane s = new JScrollPane(strList);
              strList.setSelectionBackground(new Color(225,225,255));
            s.setBounds(50, 300, 600, 200);
            strList.setEnabled(false);
           // strList.setBackground(new Color(225,225,255));
            this.add(s);
        //jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));
        StartTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(StartTime.getSelectedIndex() > EndTime.getSelectedIndex()){
                    EndTime.setSelectedIndex(StartTime.getSelectedIndex());
                }
            }
        });

        jLabel6.setFont(new java.awt.Font("나눔고딕", 0, 18)); // NOI18N
        jLabel6.setText("~");

        //EndTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));
        EndTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(StartTime.getSelectedIndex() > EndTime.getSelectedIndex()){
                    EndTime.setSelectedIndex(StartTime.getSelectedIndex());
                }
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SeatNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(33, 33, 33)
                                .addComponent(LectNum, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jButton6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton7)
                                        .addGap(30, 30, 30)
                                        .addComponent(jButton8))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(StartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(EndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(523, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(LectNum, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(SeatNum, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(StartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(EndTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addContainerGap(350, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>                        
                                    

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        SettingTime();
    }                                          

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
         SettingTime();
    }                                          


    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> StartTime;
    private javax.swing.JComboBox<String> EndTime;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> LectNum;
    private javax.swing.JComboBox<String> SeatNum;
    // End of variables declaration                   
}

 class User_modify_panel extends javax.swing.JPanel {

    /**
     * Creates new form user_modify_panel
     */
     String id;
    public User_modify_panel(int sizeX,int sizeY,String id) throws SQLException, ClassNotFoundException {
        this.id = id;
        this.setLayout(null);
        this.setBounds(0,0,sizeX,sizeY);
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
       private void initComponents() throws SQLException, ClassNotFoundException {
        String arr[][] = DB_CONNECTER.Exe_Qurey("SELECT * FROM Student where stu_id='"+id+"';");
        
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
       // jTextField3.setEditable(false);
        jTextField4.setEditable(false);
        jTextField5.setEditable(false);
        //jLabel8.setVisible(false);
       // jTextField6.setVisible(false);
        
        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(806, 576));

        jLabel2.setFont(new java.awt.Font("나눔고딕", 0, 18)); // NOI18N
        jLabel2.setText("이름");

        jLabel3.setFont(new java.awt.Font("나눔고딕", 1, 24)); // NOI18N
        jLabel3.setText("회원정보수정");

        jTextField1.setText(arr[1][1]);

        jLabel4.setFont(new java.awt.Font("나눔고딕", 0, 18)); // NOI18N
        jLabel4.setText("전화번호");

        jTextField2.setText(arr[1][2]);

        jLabel5.setFont(new java.awt.Font("나눔고딕", 0, 18)); // NOI18N
        jLabel5.setText("PW");

        jTextField3.setText("");
 
        jLabel6.setFont(new java.awt.Font("나눔고딕", 0, 18)); // NOI18N
        jLabel6.setText("학번");

        jTextField4.setText(arr[1][0]);

        jLabel7.setFont(new java.awt.Font("나눔고딕", 0, 18)); // NOI18N
        jLabel7.setText("ID");

        jTextField5.setText(arr[1][0]);

        jButton9.setText("완료");
        jButton9.setActionCommand("");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    // jButton9ActionPerformed(evt);
                    DB_CONNECTER.Update_Qurey("UPDATE User SET user_pw='"+new String(jTextField3.getPassword())+"' WHERE user" + "_id='"+id+"';");
                    DB_CONNECTER.Update_Qurey("UPDATE Student SET phone='"+jTextField2.getText()+"' WHERE stu_id='"+id+"';");
                    JOptionPane.showMessageDialog(null, "비밀번호가 변경되었습니다.");
                } catch (SQLException ex) {
                    Logger.getLogger(User_modify_panel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(User_modify_panel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jButton10.setText("회원 탈퇴");
        jButton10.setActionCommand("");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    // jButton9ActionPerformed(evt);
                    DB_CONNECTER.Update_Qurey("Delete From Lab_Seat WHERE stu_id='"+id+"';");
                    DB_CONNECTER.Update_Qurey("Delete From Student WHERE stu_id='"+id+"';");
                    DB_CONNECTER.Update_Qurey("Delete From User WHERE user_id='"+id+"';");
                } catch (SQLException ex) {
                    Logger.getLogger(User_modify_panel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(User_modify_panel.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "회원탈퇴가 완료되었습니다.");
                System.exit(0);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField1)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(96, 96, 96)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 511, Short.MAX_VALUE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jButton9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jButton10))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jButton9)
                .addContainerGap(300, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        
    }// </editor-fold>                        

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPasswordField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration                   
}


class inquiry_panel extends javax.swing.JPanel {

    /**
     * Creates new form inquiry_panel
     */
    String id;
    inquiry_panel(int sizeX,int sizeY,String id){
        this.id = id;
        this.setLayout(null);
        this.setBounds(0,0,sizeX,sizeY);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(806, 576));

        jLabel3.setFont(new java.awt.Font("나눔고딕", 1, 24)); // NOI18N
        jLabel3.setText("신고 및 문의");

        jLabel2.setFont(new java.awt.Font("나눔고딕", 0, 18)); // NOI18N
        jLabel2.setText("내용");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("내용 작성하는 곳");
        jScrollPane2.setViewportView(jTextArea1);
/*
        JButton my_board = new JButton("문의기록");
        my_board.setBounds(620,73 , 90, 25);
        this.add(my_board);
        */
        jButton6.setText("확인");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    DB_CONNECTER.Update_Qurey("Insert into Board(`writer`,`content`) VALUES('"+ id + "','" + jTextArea1.getText() + "');");
                    // jButton6ActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(inquiry_panel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(inquiry_panel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>                        

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
    }                                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration                   
}

class Reservation_Panel extends JPanel {
        protected JComboBox SelectLect;
        protected JComboBox SelectStu;
        protected JComboBox StartTime;
        protected JComboBox EndTime;
        protected JButton CheckBtn;
        protected JButton ResetBtn;
        Basic_Reservation_Panel T;
        JPanel ME = this;
        JLabel IdLabel;
        int sizeX;
        int sizeY;
        final String[] LectNum={"915","916","918","911"};
        private Color[] LectColor= {new Color(143,121,126),new Color(255,194,181),new Color(255,227,204),new Color(100,108,143),
                                    new Color(145,187,242),new Color(3, 90, 166),new Color(2, 48, 89),new Color(1, 21, 38 ),
                                    new Color(19, 26, 64),new Color(39, 50, 115),new Color(78, 100, 166),new Color(130, 159, 217),
                                    new Color(34, 92, 115),new Color(75, 140, 166),new Color(115, 177, 191 ),new Color(160, 206, 217)};
        String id = null;
       boolean reserve_checking=false;
       boolean Manager = false;
       boolean first_Time =true;
       boolean first =true;
        //int for_team_btn = 0;

        private void NewLect(){
            reserve_checking=false;
            ME.remove(6);
            ME.revalidate(); 
            ME.repaint();
           //   System.out.println(""+SelectLect.getSelectedItem().toString());
            String LectNnmStr = SelectLect.getSelectedItem().toString();
            
            //System.out.println(LectNnmStr);
            String MaxStuStr = SelectStu.getSelectedItem().toString();
            T = new Lecture_Room_Select().getRoom(LectNnmStr);
           // System.out.println("x:"+sizeX+" y:"+sizeY + " 1: " +  LectNnmStr + " 2:"+ MaxStuStr);
            T.setBounds(0,sizeY/20,sizeX, sizeY*19/20);
            T.setSize(sizeX, sizeY*19/20);
	    T.Set_cube();
            T.SetMax(Integer.parseInt(MaxStuStr));
            CheckBtn.setEnabled(true);
            try {
                GetData(LectNnmStr);
            } catch (SQLException ex) {
                Logger.getLogger(Reservation_Panel.class.getName()).log(Level.SEVERE, null, ex);              
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Reservation_Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
            ME.add(T);
        }

 	Reservation_Panel(String id,int sizeX, int sizeY,boolean Manager,JLabel IdLabel) {
        this.IdLabel = IdLabel;
        this.Manager = Manager;
        this.id = id;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        
        //this.setBackground(new Color(255,255,255));
       // T = new Lecture_Room_Select().getRoom("0");
        setLayout(null);
        //강의실선택
        SelectLect= new JComboBox();
        SelectLect.addItem(LectNum[0]);
        
        SelectLect.setBounds(0,0,sizeX/4,sizeY/20);
        SelectLect.setSelectedIndex(0);
        this.add(SelectLect);
        SelectLect.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        NewLect();
       }
  });
        //학생수 선택
        int MaxStu = 5;    
        String[] ComboStr = new String[MaxStu];
        for (int i =1 ;i<=MaxStu; i++)
            ComboStr[i-1] = Integer.toString(i);
        SelectStu= new JComboBox(ComboStr);
        SelectStu.setBounds(sizeX/4,0,sizeX/4,sizeY/20);
        this.add(SelectStu);
        SelectStu.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            
            String MaxStuStr = SelectStu.getSelectedItem().toString();
            T.SetMax(Integer.parseInt(MaxStuStr));

       }
  });
        
        //시간 선택 수정필요
        int MaxTime = 24;
        String[] TimeStart = new String[MaxTime];
        for (int i =0 ;i<MaxTime; i++)
            TimeStart[i] = Integer.toString(i) + ":00";
        StartTime= new JComboBox(TimeStart);
        StartTime.setBounds(sizeX*2/4,0,sizeX/8,sizeY/20);
        this.add(StartTime);
        
        String[] TimeEnd = new String[MaxTime];
        for (int i =1 ;i<=MaxTime; i++)
            TimeEnd[i-1] = Integer.toString(i) + ":00";
        EndTime= new JComboBox(TimeEnd);
        EndTime.setBounds(sizeX*5/8,0,sizeX/8,sizeY/20);
        this.add(EndTime);

            StartTime.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (first_Time) 
                        return;
                    SettingTime(StartTime);
                    NewLect();
                }
            });
        EndTime.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
                    if (first_Time) 
                        return;
                    SettingTime(EndTime);
                    NewLect();
       }
  });
          
        
        CheckBtn = new JButton("예약");
        
        CheckBtn.setBounds(sizeX*3/4,0,sizeX/8,sizeY/20);
        this.add(CheckBtn);   
        CheckBtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            String pass = null;
            String All_Values = "";
            String[] Values = 
            {
                pass,
                SelectLect.getSelectedItem().toString(),
                T.buttons2.getFirst().getText(),
                id,
                //null,
                StartTime.getSelectedItem().toString()+":00",
                EndTime.getSelectedItem().toString()+":00",
                "0"
            };


                               // String Date[][];
            try {
                String Date[][] = DB_CONNECTER.Exe_Qurey("select DAYOFWEEK(curdate());");
                String Date_Time[][] = DB_CONNECTER.Exe_Qurey("select CURTIME();");
                String arr2[][] = DB_CONNECTER.Exe_Qurey("SELECT * FROM Week_calender where lab_id='"+SelectLect.getSelectedItem()+"';");
                
                                 //   System.out.println( " 요일: "+Date[1][0] + " 미리예약된 강의실 개수: "+ (arr2.length-1));
                    //일요일은 1
                    int int_TodayDate = (Integer.valueOf(Date[1][0]) +2); //3 4 5 6 7 8 9 : 일 월 화 수 목 금 토 일
                    
                    int_TodayDate = 4; //3 4 5 6 7 8 9 : 일 월 화 수 목 금 토 일
                    /*
                    if(Integer.valueOf(Date_Time[1][0].split(":")[0])>=16){
                        if(Integer.valueOf(Date_Time[1][0].split(":")[1])>=30){
                         JOptionPane.showMessageDialog(null, "16:30분이 지나 금일 예약은 제한됩니다.");
                         NewLect();
                         return;
                        }
                    }
                    */
                    System.out.println( " 요일: "+int_TodayDate + " 미리예약된 강의실 개수: "+ (arr2.length-1));
                    int Reserve_Start_Time = Integer.valueOf(StartTime.getSelectedItem().toString().split(":")[0]);                  
                    int Reserve_End_Time = Integer.valueOf(EndTime.getSelectedItem().toString().split(":")[0]);
                    if (int_TodayDate > 3 && int_TodayDate <9 && arr2.length>1) {
                         // System.out.println( "월~금임");
                        for (int i = 1; i < arr2.length; i++) {
                            System.out.println("강의시간: "+arr2[i][int_TodayDate]);
                            if (!(arr2[i][int_TodayDate].equals(""))) {
                                 System.out.println(arr2[i][int_TodayDate]);
                                int Lect_Start_Time = Integer.valueOf(arr2[i][int_TodayDate].substring(0, 1)) + 8;
                                int Lect_End_Time = Integer.valueOf(arr2[i][int_TodayDate].substring(1, 2)) + 8+1;
                                 System.out.println( " 강의 시작시간: "+Lect_Start_Time + " 강의 종료시간: "+ Lect_End_Time);
                                // 예약시작시간이 강의종료 시간보다 앞이면서 예약종료시간이 강의 시작시간보다 뒤일때
                                if ( Integer.valueOf(Date_Time[1][0].split(":")[0]) > Reserve_Start_Time){
                                    JOptionPane.showMessageDialog(null, "예약가능 시간이 지났습니다.\n 한시간 단위로 결정되니 주의하세요.");
                                    NewLect();
                                    return;
                                }
                                else if (Reserve_Start_Time < Lect_End_Time && Reserve_End_Time >= Lect_Start_Time) {
                                    JOptionPane.showMessageDialog(null, "강의실 시간표와 곂칩니다.");
                                    NewLect();
                                    return;
                                }
                            }
                        }
                    }
                    else if(arr2.length > 1){
                        JOptionPane.showMessageDialog(null, "현재 주말예약은 승인되지 않습니다.");
                        NewLect();
                        return;
                    }
                        
            } catch (SQLException ex) {
                Logger.getLogger(Reservation_Panel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Reservation_Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(T.buttons2.size()>1){
                   JOptionPane b=new JOptionPane();
                    pass =b.showInputDialog("다중 좌석을 선택하셨습니다.\n예약은 10분간 유지되며 경과 시 \n본인의 자리를 제외한 자리의 예약은 취소 됩니다.\n팀원들이 입력할 비밀번호를 설정해주세요.");
                    //System.out.println("b :"+);
                    if(pass == null){
                        JOptionPane b2=new JOptionPane("예약이 취소 되었습니다.");
                        NewLect();
                        SettingTime(StartTime);
                        return ;
                    }
            }
            for (int i=0;i<T.buttons2.size();i++){
            String insert="INSERT INTO Lab_Seat(`passwd`,`lab_id`, `seat_num`, `stu_id`, `start_time`, `end_time`,`seat_status`) Values(";
            if(i>0){
                insert=",(";
                Values[0] = pass;
                Values[6] = null;
            }
            else if (EndTime.getSelectedIndex() <= 16 )
                Values[6] = "1";
            for (int j =0; j<Values.length; j++){
                Values[2] = T.buttons2.get(i).getText();
                if(Values[j] == null)
                    insert = insert +Values[j] +",";
                else
                    insert = insert + "'" +Values[j] +"',";
            }
            insert = insert.substring(0, insert.length() - 1)+")";
            All_Values = All_Values + insert;
           // T.buttons2.remove();
        }
         All_Values = All_Values+ ";";
          int count = 0;
                   try {
                  String arr[][] = DB_CONNECTER.Exe_Qurey("SELECT COUNT(*) FROM Lab_Seat where lab_id = '"+SelectLect.getSelectedItem().toString()+"'and end_time > '17:00:00';");
                  count = Integer.valueOf(arr[1][0]);
                // 예약등록시작시간이 17시 이후일때 탐색
                   if (count < 20) {

                    if (SelectLect.getSelectedItem().toString().equals("916")) {
                        count = Integer.valueOf(DB_CONNECTER.Exe_Qurey("SELECT COUNT(*) FROM Lab_Seat where lab_id = '915' and end_time > '17:00:00';")[1][0]);
                    } else if (SelectLect.getSelectedItem().toString().equals("918")) {
                        count = Integer.valueOf(DB_CONNECTER.Exe_Qurey("SELECT COUNT(*) FROM Lab_Seat where lab_id = '916' and end_time > '17:00:00';")[1][0]);
                    } else if (SelectLect.getSelectedItem().toString().equals("911")) {
                        count = Integer.valueOf(DB_CONNECTER.Exe_Qurey("SELECT COUNT(*) FROM Lab_Seat where lab_id = '918' and end_time > '17:00:00';")[1][0]);
                    }

                    if (count < 20 && !(SelectLect.getSelectedItem().toString().equals("915"))){
                        JOptionPane.showMessageDialog(null, "이전 강의실의 인원수가 20명을 넘지 않습니다.2");
                        NewLect();
                        return;
                    }
                }
                    DB_CONNECTER.Update_Qurey(All_Values);
                } catch (SQLException ex) {

                    Logger.getLogger(Reservation_Panel.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "이미 예약된 자리 입니다.");
                    NewLect();
                    return;
                } catch (ClassNotFoundException ex) {
                   
                    Logger.getLogger(Reservation_Panel.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "이미 예약된 자리 입니다.");
                     NewLect();
                    return;
                }
            try {
                if(count > 30){
                    DB_CONNECTER.Update_Qurey("DELETE FROM Lab_Seat WHERE stu_id='"+id+"';");
                     JOptionPane.showMessageDialog(null, "30명을 초과하였습니다.");
                     NewLect();
                     return;
                }
                } catch (SQLException ex) {
                Logger.getLogger(Reservation_Panel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Reservation_Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("try"+1+": "+ All_Values);
            
            JOptionPane.showMessageDialog(null,  SelectLect.getSelectedItem().toString() + " 입니다. 깨끗히 사용해주세요.");
             NewLect();
             //SelectLect.setSelectedIndex(SelectLect.getSelectedIndex());
             //SelectLect.ac
             /*
            try {
                String Arr[][] = DB_CONNECTER.Exe_Qurey("INSERT INTO ~");
                JOptionPane.showMessageDialog(null, "예약되었습니다.");
                SelectLect.actionPerformed(e);
                
            } catch (SQLException ex) {
                Logger.getLogger(Reservation_Panel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Reservation_Panel.class.getName()).log(Level.SEVERE, null, ex);
            }*/
}
  });
        
        ResetBtn = new JButton("갱신");
        ResetBtn.setBounds(sizeX*7/8,0,sizeX/8,sizeY/20);
        this.add(ResetBtn); 
        ResetBtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
              System.out.println( SelectLect.getSelectedItem().toString());
              NewLect();

       }
  });
            //    SettingTime(StartTime);
        T = new Lecture_Room_Select().getRoom(SelectLect.getSelectedItem().toString());
       // T.setBounds(0,sizeY/20,sizeX, sizeY*19/20);
     //   T.setSize(sizeX, sizeY*19/20);
	//T.Set_cube();
            try {
                GetData(SelectLect.getSelectedItem().toString());
                //T.setBackground(new Color(125, 255, 125));
            } catch (SQLException ex) {
                Logger.getLogger(Reservation_Panel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Reservation_Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
       // SettingTime(StartTime);
        this.add(T);                    // NewLect();
        SettingTime(StartTime);
        NewLect();
       // this.setBackground(new Color(125, 125, 125));
        this.setSize(sizeX,sizeY);
      //  NewLect();
        this.setVisible(true);
                    }
        private boolean TimeCheker(){
            return (StartTime.getSelectedIndex()>EndTime.getSelectedIndex());
        }
    public void SettingTime(JComboBox C){
                if(TimeCheker())
                StartTime.setSelectedIndex(EndTime.getSelectedIndex());
                try {
                String Date[][] = DB_CONNECTER.Exe_Qurey("select curTime();");
                int nowTime = Integer.valueOf(Date[1][0].split(":")[0]);
                int SelectTime = Integer.valueOf(C.getSelectedItem().toString().split(":")[0]);
                if(nowTime <= 17){
                    for(int i=SelectLect.getItemCount(); i<LectNum.length; i++)
                        SelectLect.addItem(LectNum[i]);
                }
                System.out.println("nowTime: "+Date[1][0]);
                if(nowTime > SelectTime){
                    EndTime.setSelectedIndex(nowTime);
                    StartTime.setSelectedIndex(nowTime);
                    if (first_Time) {
                        first_Time = false;
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "현재시각보다 느립니다.");
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reservation_Panel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Reservation_Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    private void GetData(String SelectLectNum) throws SQLException, ClassNotFoundException {

        //DB_CONNECTER.Exe_Qurey("Select *" + " From where lab_id = '"+LectNum + "';");
        //String[][] arr = DB_CONNECTER.Exe_Qurey("Select *" + " From Lab_Seat where lab_id = '" + SelectLectNum + "' ORDER BY stu_id;"); //기존 startdate로 변경 필요
        String[][] arr = DB_CONNECTER.Exe_Qurey("Select *" + " From Lab_Seat where lab_id = '" + SelectLectNum + "'"+
                                                " AND NOT(start_time >='"+ EndTime.getSelectedItem().toString()+":00'"+
                                                " OR end_time <='"+StartTime.getSelectedItem().toString() +":00')"+
                                                " ORDER BY start_date;"); //시간추가,  
        //String[][] Lect_M = DB_CONNECTER.Exe_Qurey("SELECT * FROM Lab_Seat WHERE seat_status = '1'ORDER BY end_time DESC, start_date ASC LIMIT 1;");
         String[][] Lect_M = DB_CONNECTER.Exe_Qurey("SELECT * FROM (SELECT * FROM Lab_Seat WHERE seat_status = '1' ORDER BY end_time DESC, start_date ASC LIMIT 200) as A GROUP BY lab_id ;");
       //  String[][] Lect_M = DB_CONNECTER.Exe_Qurey("SELECT group_concat(distinct name order by name) FROM (SELECT * FROM Lab_Seat WHERE seat_status = '1' ORDER BY end_time DESC, start_date ASC LIMIT 5) as A GROUP BY lab_id ;");
         for(int i=0; i<Lect_M.length; i++){
              for(int j=0; j<Lect_M[0].length; j++){
                  System.out.print(Lect_M[i][j]+"   ");
              }
              System.out.println("");
         }
 
        int nextLec = (arr.length-1) / 20;
        //SelectLect.setMaximumRowCount(nextLec);
        
        //인원수 초과 이벤트
        for(int i =1; i<= nextLec && SelectLect.getItemCount()<i+1 ; i++)
            SelectLect.addItem(LectNum[i]);
        
        //CheckBtn.setBackground(Color.red);

        String colorid = null;
        if(arr.length > 1)
            colorid =arr[1][3];
        int ColorCount = 0;
       // MyListener LISTEN = new MyListener();
        
        int Room_Manger_time = 0;
        for (int i = 1; i < arr.length; i++) {
            // System.out.print(arr[i][2]+" ");
            for (int j = 0; j < T.buttons.size(); j++) {
                if (arr[i][2].equals(T.buttons.get(j).getText())) {
                    //System.out.println(arr[i][0]);
                    if (!arr[i][0].equals("")) {
                        //for_team_btn = i;
                        if(!colorid.equals(arr[i][3])){ ColorCount++;  colorid = arr[i][3]; }
                        T.buttons.get(j).setBackground(LectColor[ColorCount%LectColor.length]);
                        T.buttons.get(j).setForeground(Color.white);
                        T.buttons.get(j).addActionListener(new MyListener(arr[i][0],arr[i][2]));
                    } else {
                        if (Lect_M.length > 1) {
                            for (int l = 1; l < Lect_M.length; l++) {
                                if (Lect_M[l][2].equals(T.buttons.get(j).getText()))
                                    T.buttons.get(j).setBackground(Color.yellow);
                            }
                          //  if (Lect_M[1][2].equals(T.buttons.get(j).getText()))
                             //   T.buttons.get(j).setBackground(Color.yellow);
                       }
                       //T.buttons.get(j).setBackground(Color.yellow);
                        T.buttons.get(j).setEnabled(false);
                    }
                    if(Manager){
                        //UIDefaults defaults = UIManager.getLookAndFeelDefaults();
                        //defaults.put("Button.focus", new ColorUIResource(new Color(0, 0, 0, 0)));
                        //T.buttons.get(j).setBorderPainted(false);
                       //  T.buttons.get(j).
                        T.buttons.get(j).setText("<HTML><body style='text-align:left;'>"+arr[i][2]+"<br>"+arr[i][3]+"<br>"+arr[i][5].substring(0,5)+"~"+arr[i][6].substring(0,5)+"</body></HTML>");
                        //T.buttons.get(j).setFont(new Font( T.buttons.get(j).getFont().getName(), T.buttons.get(j).getFont().getStyle(), 10));
                       // T.buttons.get(j).setHorizontalAlignment(SwingConstants.LEFT);
                        //T.buttons.get(j).setContentAreaFilled(false);
//                        System.out.println(T.buttons.get(j).getComponent(j).getClass().toString());
                    }
                    else
                        IdLabel.setForeground(Color.white);
                }
            }
        }
        if (Lect_M.length > 1) {
            for (int i = 1; i < Lect_M.length; i++) {
                if (Lect_M[i][3].equals(id)) {
                    IdLabel.setForeground(Color.yellow);
                }
            }
        }
        String[][] arr2 = DB_CONNECTER.Exe_Qurey("Select lab_id" + " From Lab_Seat WHERE stu_id='"+id+"';");
        for (int i = 1; i < arr2.length; i++) {
           // if (arr2[i][0].equals(id)) {
                T.reserve_true();
                reserve_checking=true;
                CheckBtn.setEnabled(false);
                for(int j =0; j< SelectLect.getItemCount(); j++){
                  //  System.out.println("리스트에 있는 값: "+SelectLect.getItemAt(j) +", 나의 lab+id: "+ arr2[i][0]);
                   if(SelectLect.getItemAt(j).equals(arr2[i][0])) 
                       return;
                //    System.out.println("없음");
                }
                SelectLect.addItem(arr2[i][0]);
                //System.out.println("추가완");
                break;
           // }
        }
        System.out.println("Manager: "+Manager);
        if (Manager){
            for (int j = 0; j < T.buttons.size(); j++) {
                ActionListener A[] = T.buttons.get(j).getActionListeners();
                for (int k = 0; k < A.length; k++)
                   T.buttons.get(j).removeActionListener(A[k]);
            }
           // SelectLect.removeAllItems();
           for (int j = SelectLect.getItemCount(); j < LectNum.length; j++) 
                SelectLect.addItem(LectNum[j]);
        }
    }
    class MyListener implements ActionListener {

        String btn_num;
        String passwd;

        MyListener(String passwd, String btn_num) throws SQLException, ClassNotFoundException {
            this.btn_num = btn_num;
            this.passwd = passwd;
        }
        public MyListener setData(String passwd, String btn_num){
            this.btn_num = btn_num;
            this.passwd = passwd;
            return this;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
             String pass =null;
             System.out.println("btn_num: "+ btn_num);
            if (T.buttons2.size() > 0)
                JOptionPane.showMessageDialog(null, "다른자리선택 중입니다. 선택을 위해 갱신 합니다.");
            
            else if(reserve_checking == false){
                JOptionPane b = new JOptionPane();
                pass = b.showInputDialog("비밀번호를 입력하세요.");
            }
            System.out.println(passwd);
            if (passwd.equals(pass)) {
                int status = 0;
                if (EndTime.getSelectedIndex() <= 17 )
                    status = 1;
                String qurey = "UPDATE Lab_Seat SET passwd=null, stu_id='" + id + "',seat_status='"+ status +"' WHERE seat_num ='" + btn_num + "';";
                try {
                    DB_CONNECTER.Update_Qurey(qurey);
                    NewLect();
                } catch (SQLException ex) {
                    Logger.getLogger(Reservation_Panel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Reservation_Panel.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "예약되었습니다.");
            } else if(pass != null){
                JOptionPane.showMessageDialog(null, "다시확인해주세요.");
               // return;
            }
         NewLect();
        }
    }
}