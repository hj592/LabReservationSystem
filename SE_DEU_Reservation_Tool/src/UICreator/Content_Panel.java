package UICreator;

import DB.DB_CONNETER;
import Reservation_Panel.Basic_Reservation_Panel;
import Reservation_Panel.Lecture_Room_Select;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JPanel;


public abstract class Content_Panel extends JPanel {
	//ArrayList<JPanel> Panels = new ArrayList<JPanel>();
	//ArrayList<Basic_Reservation_Panel> r = new ArrayList<Basic_Reservation_Panel>();
	//Lecture_Room_Select Selecter = new Lecture_Room_Select();
	Content_Panel() {
		this.setLayout(null);
		// this.setBackground(new Color(255,0,0));
	}

	abstract void Set_Multi_Layout();
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

class Reservation_Panel extends JPanel {
        protected JComboBox SelectLect;
        protected JComboBox SelectStu;
        protected JComboBox StartTime;
        protected JComboBox EndTime;
        protected JButton CheckBtn;
        protected JButton ResetBtn;
        Basic_Reservation_Panel T;
        JPanel ME = this;
        
        String[][] arr={{},{"1","1","1"},{"1","1","5"},{"1","1","2"},{"1","1","10"}};
        private String LectNum[] = {"915","918","916","911"};
        
	Reservation_Panel(int sizeX, int sizeY) {
        
       // T = new Lecture_Room_Select().getRoom("0");
        setLayout(null);
        //강의실선택
        SelectLect= new JComboBox(LectNum);
        SelectLect.setBounds(0,0,sizeX/4,sizeY/20);
        this.add(SelectLect);
        SelectLect.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            ME.remove(6);
            ME.revalidate(); 
            ME.repaint();
            
            String LectNnmStr = SelectLect.getSelectedItem().toString();
            //System.out.println(LectNnmStr);
            String MaxStuStr = SelectStu.getSelectedItem().toString();
            T = new Lecture_Room_Select().getRoom(LectNnmStr);
            T.setBounds(0,sizeY/20,sizeX, sizeY*19/20);
            T.setSize(sizeX, sizeY*19/20);
	    T.Set_cube();
            T.SetMax(Integer.parseInt(MaxStuStr));
            try {
                GetData(LectNnmStr);
            } catch (SQLException ex) {
                Logger.getLogger(Reservation_Panel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Reservation_Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
            ME.add(T);
           // int index = SelectLect.getSelectedIndex();// 선택된 아이템의 인덱스
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
            if(TimeCheker())
                StartTime.setSelectedIndex(EndTime.getSelectedIndex());
       }
  });
        EndTime.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(TimeCheker())
                StartTime.setSelectedIndex(EndTime.getSelectedIndex());
       }
  });
        
        
        CheckBtn = new JButton("예약");
        CheckBtn.setBounds(sizeX*3/4,0,sizeX/8,sizeY/20);
        this.add(CheckBtn);   
        CheckBtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(TimeCheker())
                StartTime.setSelectedIndex(EndTime.getSelectedIndex());
       }
  });
        
        ResetBtn = new JButton("갱신");
        ResetBtn.setBounds(sizeX*7/8,0,sizeX/8,sizeY/20);
        this.add(ResetBtn); 
        ResetBtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
                SelectLect.actionPerformed(e);
       }
  });
        
        T = new Lecture_Room_Select().getRoom(SelectLect.getSelectedItem().toString());
        T.setBounds(0,sizeY/20,sizeX, sizeY*19/20);
        T.setSize(sizeX, sizeY*19/20);
	T.Set_cube();
            try {
                GetData(SelectLect.getSelectedItem().toString());
                //T.setBackground(new Color(125, 255, 125));
            } catch (SQLException ex) {
                Logger.getLogger(Reservation_Panel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Reservation_Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        this.add(T);
       // this.setBackground(new Color(125, 125, 125));
        this.setSize(sizeX,sizeY);
        this.setVisible(true);
                    }
        private boolean TimeCheker(){
            return (StartTime.getSelectedIndex()>EndTime.getSelectedIndex());
        }
        @SuppressWarnings("empty-statement")
        private void GetData(String LectNum) throws SQLException, ClassNotFoundException{
            
            //DB_CONNETER.Exe_Qurey("Select *" + " From where lab_id = '"+LectNum + "';");
            //arr = DB_CONNETER.Exe_Qurey("Select *" + " From where lab_id = '"+LectNum + "';");
           // System.out.println(arr.length+" "+T.buttons.size());
            for(int i =1; i<arr.length; i++){
                for(int j =0; j<T.buttons.size(); j++){
                    //System.out.println(j);
                    if(arr[i][2].equals(T.buttons.get(j).getText().split("\n")[0]))
                        T.buttons.get(j).setEnabled(false);
                }
            }
        }
}