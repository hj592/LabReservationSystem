package UICreator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
학생의 상태
토큰 비등록 상태
일부기능사용불가 상태
방장 상태
*/
interface Student_States {
         //ArrayList<Buttons> buttons2 = new ArrayList<Buttons>();
         //ArrayList<Buttons> buttons3 = new ArrayList<Buttons>();
	void Exe_State(ArrayList<Buttons> buttons);
}
class Basic implements Student_States{

    @Override
    public void Exe_State(ArrayList<Buttons> buttons) {
        //JButton
        System.out.println("State Basic");
        
     ArrayList<Buttons> buttons2 = new ArrayList<Buttons>();
    // ArrayList<Buttons> buttons3 = new ArrayList<Buttons>();
     
        buttons2.add(new Student_Reservation_Button());
        buttons2.add(new Student_Reservation_Management());
        buttons2.add(new Student_Profile());
        buttons2.add(new QandA());
        
        for(int i =0;i<buttons.size();i++)
            buttons.get(i).setEnabled(false);
        
         for(int i =0;i<buttons2.size();i++){
            for(int j =0;j<buttons.size();j++){
                if(buttons.get(j).getClass() == buttons2.get(i).getClass()){
                    System.out.println(buttons.get(i).getText());
                    buttons.get(j).setEnabled(true);
                }
            }
        }
         
         
    }
}
class Token_Un_regi implements Student_States{

    @Override
    public void Exe_State(ArrayList<Buttons> buttons) {
        System.out.println("State Token_Un_regi");
        ArrayList<Buttons> buttons2 = new ArrayList<Buttons>();
        
       // buttons2.add(new Student_Reservation_Button());
       // buttons2.add(new Student_Reservation_Management());
       // buttons2.add(new Student_Profile());
        //buttons2.add(new QandA());
        //buttons2.add(new Student_Reservation_Button());
        
        try {
            buttons2.add(new Insert_token(this,buttons));
        } catch (SQLException ex) {
            Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Basic.class.getName()).log(Level.SEVERE, null, ex);
        }
         //System.out.println(buttons.size());
              for(int i =0;i<buttons.size();i++)
                  buttons.get(i).setEnabled(false);
         
        for(int i =0;i<buttons2.size();i++){
            for(int j =0;j<buttons.size();j++){
                if(buttons.get(j).getClass() == buttons2.get(i).getClass()){
                    System.out.println(buttons.get(i).getText());
                    buttons.get(j).setEnabled(true);
                }
            }
        }
    }
}

class function_limitation implements Student_States{

    @Override
    public void Exe_State(ArrayList<Buttons> buttons) {
        System.out.println("State function_limitation");
             
        ArrayList<Buttons> buttons2 = new ArrayList<Buttons>();

        //buttons2.add(new Student_Reservation_Button());
       // buttons2.add(new Student_Reservation_Management());
        buttons2.add(new Student_Profile());
        buttons2.add(new QandA());

        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).setEnabled(false);
        }

        for (int i = 0; i < buttons2.size(); i++) {
            for (int j = 0; j < buttons.size(); j++) {
                if (buttons.get(j).getClass() == buttons2.get(i).getClass()) {
                    System.out.println(buttons.get(i).getText());
                    buttons.get(j).setEnabled(true);
                }
            }
        }
        
        JOptionPane.showMessageDialog(null, "경고 3회 초과, 혹은 관리자에 의해 기능제한 상태입니다.");
    }
}

class Room_Manger implements Student_States{
    
    @Override
    public void Exe_State(ArrayList<Buttons> buttons) {
        System.out.println("State Room_Manger");
        

    }
}