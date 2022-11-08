package UICreator;

import java.util.ArrayList;

/*
학생의 상태
토큰 비등록 상태
일부기능사용불가 상태
방장 상태
*/
interface Student_States {
	void Exe_State(ArrayList<Buttons> buttons);
}
class Basic implements Student_States{

    @Override
    public void Exe_State(ArrayList<Buttons> buttons) {
        //JButton
        System.out.println("State Basic");
    }
}
class Token_Un_regi implements Student_States{

    @Override
    public void Exe_State(ArrayList<Buttons> buttons) {
        System.out.println("State Token_Un_regi");
        ArrayList<Buttons> buttons2 = new ArrayList<Buttons>();
        
        //buttons2.add(new S1_Button());
        
         System.out.println(buttons.size());
        for(int i =0;i<buttons2.size();i++){
            for(int j =0;j<buttons.size();j++){
                if(buttons.get(j).getClass() == buttons2.get(i).getClass()){
                    System.out.println(buttons.get(i).getText());
                    buttons.get(i).setEnabled(false);
                }
            }
        }
    }
}

class function_limitation implements Student_States{

    @Override
    public void Exe_State(ArrayList<Buttons> buttons) {
        System.out.println("State function_limitation");
    }
}

class Room_Manger implements Student_States{
    
    @Override
    public void Exe_State(ArrayList<Buttons> buttons) {
        System.out.println("State Room_Manger");

    }
}