package UICreator;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Button_Panel extends JPanel{
    Student_States Status;
    ArrayList<Buttons> buttons = new ArrayList<Buttons>();
    
	Button_Panel(){
		this.setLayout(null);
		this.setBackground(new Color(230,223,217));

	}
	void Sorting_Button(Screen_Panel S) {
		int sizex = this.getSize().width;
		int sizey = this.getSize().height;
		for (int i =0; i<buttons.size(); i++) {
			buttons.get(i).setBounds(sizex/10, (sizey*3/20)+i*(sizey/20+sizey/20), sizex*8/10, sizey/20);
			buttons.get(i).Set_Content_Panel(S);
			this.add(buttons.get(i));
		}
	}
        public void Exe_State(String My_data){
            if(My_data.equals("1"))
                Status = new Basic();
            
            else if(My_data.equals("2"))
                Status = new Token_Un_regi();
            
            else if(My_data.equals("3"))
                Status = new function_limitation();
            
            else if(My_data.equals("4"))
                Status = new Room_Manger();
            
            Status.Exe_State(buttons);
        }
        /*
	void Sorting_Button(Content_Panel C) {
		int sizex = this.getSize().width;
		int sizey = this.getSize().height;
		for (int i =0; i<buttons.size(); i++) {
			buttons.get(i).setBounds(sizex/10, (sizey*3/20)+i*(sizey/20/2+sizey/20), sizex*8/10, sizey/20);
			buttons.get(i).Set_Content_Panel(C);
			this.add(buttons.get(i));
		}
	}
        */
        
}

class Student_Button_Panel extends Button_Panel{
	Student_Button_Panel() throws SQLException, ClassNotFoundException{
		buttons.add(new Student_Reservation_Button());
                buttons.add(new Student_Reservation_Management());
                buttons.add(new S_TimeTableButt());
                buttons.add(new Student_Profile());
                buttons.add(new QandA());
                buttons.add(new Insert_token(Status,buttons));
	}
}

class Assistant_Button_Panel extends Button_Panel{
    Assistant_Button_Panel(){
        //buttons.add(new A1_Button());
        //buttons.add(new A2_Button());
        buttons.add(new A_LabViewButt());
        buttons.add(new A_ReservationButt());
                buttons.add(new A_UserControlButt());
                buttons.add(new A_ProfControlButt());
                buttons.add(new A_QnAButt());
                buttons.add(new A_TokenButt());
                buttons.add(new A_TimeTableButt());
                buttons.add(new A_ProfCreateButt());
    }
}

class Professor_Button_Panel extends Button_Panel{
    Professor_Button_Panel(){
		//buttons.add(new P1_Button());
		//buttons.add(new P2_Button());
        buttons.add(new Prof_LabView_butt());
        buttons.add(new Prof_seminar_butt());
        buttons.add(new Prof_Schedule_butt());
    }
}

class Admin_Button_Panel extends Button_Panel{
    Admin_Button_Panel(){
        //buttons.add(new A1_Button());
        //buttons.add(new A2_Button());
        buttons.add(new Admin_create_id_butt());
        buttons.add(new Admin_delete_id_butt());
    }
}
