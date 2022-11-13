package UICreator;

import Assistant_Panel.*;
import DB.DB_CONNECTER;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Buttons extends JButton {
	Screen_Panel S;
        
        
	//Content_Panel C;
	int sizeX;
	int sizeY;
	
	public void Set_Content_Panel(Screen_Panel S) {
		this.S = S;
                this.setBackground(Color.WHITE);
                
	}

	protected void remover() {
		sizeX =	S.getComponent(0).getSize().width;
		sizeY = S.getComponent(0).getSize().height;
		//C = (Content_Panel) S.getComponent(0);
                ((Content_Panel) S.getComponent(0)).removeAll();
		((Content_Panel) S.getComponent(0)).revalidate();     // 컨테이너 c의 재배치
		((Content_Panel) S.getComponent(0)).repaint();
		//C2.setBounds(C.getBounds());
	}
	protected void adder(Component C2) {
		//C = (Content_Panel) S.getComponent(0);
              //  C2.setSize(sizeX,sizeY);
		((Content_Panel) S.getComponent(0)).add(C2);
                
		//C2.setBounds(C.getBounds());
	}
}

class Student_Reservation_Button extends Buttons {
	Student_Reservation_Button(){
		this.setText("실습실 조회");
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remover();
                                Reservation_Panel T = new Reservation_Panel(S.getID(),sizeX,sizeY,false);
                                T.setBackground(new Color(255,255,255));
                                System.out.println(sizeX+" x y "+sizeY);
				//new User_modify_panel();
				adder(T);
				//C.add(T);
				//C.revalidate();     // 컨테이너 c의 재배치
				//C.repaint();
			}
		});
	}
}
class Student_Reservation_Management extends Buttons {
    	Student_Reservation_Management(){
		this.setText("예약관리");
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remover();
				reservation_list_panel T;
                            try {
                                T = new reservation_list_panel(sizeX,sizeY,S.getID());
                                adder(T);
                            } catch (SQLException ex) {
                                Logger.getLogger(Student_Reservation_Management.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(Student_Reservation_Management.class.getName()).log(Level.SEVERE, null, ex);
                            }
				//C.add(T);
				//C.revalidate();     // 컨테이너 c의 재배치
				//C.repaint();
			}
		});
	}
}

class Student_Profile extends Buttons {
    Student_Profile(){
		this.setText("회원정보수정");
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remover();
				User_modify_panel T;
                            try {
                                T = new User_modify_panel(sizeX,sizeY,S.getID());
                                adder(T);
                            } catch (SQLException ex) {
                                Logger.getLogger(Student_Profile.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(Student_Profile.class.getName()).log(Level.SEVERE, null, ex);
                            }
				//C.add(T);
				//C.revalidate();     // 컨테이너 c의 재배치
				//C.repaint();
			}
		});
	}

}
class QandA extends Buttons {
    QandA(){
		this.setText("문의사항");
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remover();
				inquiry_panel T = new inquiry_panel(sizeX,sizeY,S.getID());
				adder(T);
				//C.add(T);
				//C.revalidate();     // 컨테이너 c의 재배치
				//C.repaint();
			}
		});
	}
}

class Insert_token extends Buttons {

    Insert_token(Student_States status,ArrayList<Buttons> buttons) throws SQLException, ClassNotFoundException{
               // this.status = status;
		this.setText("토큰입력");
		this.addActionListener(new MyListener(status,buttons));
	}
    class MyListener implements ActionListener{
    Student_States status ;
    ArrayList<Buttons> buttons;
    
    MyListener(Student_States status, ArrayList<Buttons> buttons) throws SQLException, ClassNotFoundException{
        //int number=Integer.parseInt(token);
           // status = new Basic();
            this.status = status;
            this.buttons = buttons;
      
        //토큰 틀림
        //JOptionPane.showMessageDialog(null, "다시 확인하세요.");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JOptionPane b=new JOptionPane();
            String token =b.showInputDialog("토큰을 입력하세요.");
            String[][] str = DB_CONNECTER.Exe_Qurey("Select authority from Token where token ='"+ token +"';");
           // System.out.println(str[]);
            if (str.length>1){
                String[][] user_auth_check = DB_CONNECTER.Exe_Qurey("Select authority from User where user_id ='"+ S.getID() +"';");
                //if(str[1][0].equals(user_auth_check[1][0])){
                      DB_CONNECTER.Update_Qurey(" UPDATE Student Set status='1' WHERE stu_id='"+S.getID()+"';");
                     JOptionPane.showMessageDialog(null, "인증되었습니다.");

                status = new Basic();
                //buttons.get(0);
                status.Exe_State(buttons);
            }
            else
                JOptionPane.showMessageDialog(null, "다시 확인하세요.");
        } catch (SQLException ex) {
            Logger.getLogger(Insert_token.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Insert_token.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

}
/*Assistant 관련 버튼*/
class A_LabViewButt extends Buttons {
	A_LabViewButt(){
		this.setText("실습실 조회");
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remover();
				Reservation_Panel T = new Reservation_Panel(S.getID(),sizeX,sizeY,true);
				adder(T);
				//C.add(T);
				//C.revalidate();     // 컨테이너 c의 재배치
				//C.repaint();
			}
		});
	}
}
class A_ReservationButt extends Buttons {
	A_ReservationButt(){
		this.setText("예약 관리");
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remover();
				ReserveListPanel T = new ReserveListPanel(sizeX,sizeY);
				adder(T);
				//C.add(T);
				//C.revalidate();     // 컨테이너 c의 재배치
				//C.repaint();
			}
		});
	}
}
class A_UserControlButt extends Buttons {
	A_UserControlButt(){
		this.setText("사용자 관리");
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remover();
				UserListPanel T = new UserListPanel(sizeX,sizeY);
				adder(T);
				//C.add(T);
				//C.revalidate();     // 컨테이너 c의 재배치
				//C.repaint();
			}
		});
	}
}

class A_QnAButt extends Buttons {
	A_QnAButt(){
		this.setText("문의사항");
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remover();
				QnAListPanel T = new QnAListPanel(sizeX,sizeY);
				adder(T);
				//C.add(T);
				//C.revalidate();     // 컨테이너 c의 재배치
				//C.repaint();
			}
		});
	}
}

class A_TokenButt extends Buttons {
	A_TokenButt(){
		this.setText("토큰 생성");
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remover();
				MakeTokenPanel T = new MakeTokenPanel(sizeX,sizeY);
				adder(T);
				//C.add(T);
				//C.revalidate();     // 컨테이너 c의 재배치
				//C.repaint();
			}
		});
	}
}

class A_TimeTableButt extends Buttons {
	A_TimeTableButt(){
		this.setText("시간표 입력");
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remover();
				MakeTimetablePanel T = new MakeTimetablePanel(sizeX,sizeY);
				adder(T);
				//C.add(T);
				//C.revalidate();     // 컨테이너 c의 재배치
				//C.repaint();
			}
		});
	}
}

class A_ProfCreateButt extends Buttons {
	A_ProfCreateButt(){
		this.setText("교수 계정 생성");
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remover();
				ProfCreatePanel T = new ProfCreatePanel(sizeX,sizeY);
				adder(T);
				//C.add(T);
				//C.revalidate();     // 컨테이너 c의 재배치
				//C.repaint();
			}
		});
	}
}

/*교수 관련 버튼*/
class P2_Button extends Buttons {

}