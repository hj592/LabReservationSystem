package UICreator;

import Reservation_Panel.Basic_Reservation_Panel;
import Reservation_Panel.Lecture_Room_Select;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
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

class Student_Reservation_Panel extends JPanel {
        protected JComboBox SelectLect;
        protected JComboBox SelectStu;
        protected JComboBox SelectTime;
        protected JButton CheckBtn;
        protected JButton ResetBtn;
        
	Student_Reservation_Panel(int sizeX, int sizeY) {
        
        Basic_Reservation_Panel T = new Lecture_Room_Select().getRoom("915");
        setLayout(null);
        //강의실선택
        SelectLect= new JComboBox(T.getLects());
        SelectLect.setBounds(0,0,sizeX/4,sizeY/20);
        this.add(SelectLect);
        
        //학생수 선택
        int MaxStu = 5;    
        String[] ComboStu = new String[MaxStu];
        for (int i =1 ;i<=MaxStu; i++)
            ComboStu[i-1] = Integer.toString(i);
        SelectStu= new JComboBox(ComboStu);
        SelectStu.setBounds(sizeX/4,0,sizeX/4,sizeY/20);
        this.add(SelectStu);
        
        //시간 선택 수정필요
        String[] Time = {"1","2"};
        SelectTime= new JComboBox(Time);
        SelectTime.setBounds(sizeX*2/4,0,sizeX/4,sizeY/20);
        this.add(SelectTime);
        
        CheckBtn = new JButton("확인");
        CheckBtn.setBounds(sizeX*3/4,0,sizeX/8,sizeY/20);
        this.add(CheckBtn);   
        
        ResetBtn = new JButton("갱신");
        ResetBtn.setBounds(sizeX*7/8,0,sizeX/8,sizeY/20);
        this.add(ResetBtn);   
        
        T.setBounds(0,sizeY/20,sizeX, sizeY*19/20);
        T.setSize(sizeX, sizeY*19/20);
	T.Set_cube();
        T.setBackground(new Color(125, 255, 125));
        this.add(T);
        this.setBackground(new Color(125, 125, 125));
        this.setSize(sizeX,sizeY);
        this.setVisible(true);
                    }
        
}