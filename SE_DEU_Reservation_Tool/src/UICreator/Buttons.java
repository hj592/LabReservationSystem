package UICreator;

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

        protected void ANI() {
		//C = (Content_Panel) S.getComponent(0);
              //  C2.setSize(sizeX,sizeY);
                JPanel A = new JPanel();
                A.setBounds(this.location().x, this.location().y+this.getSize().width, this.getSize().width, 500);
                
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
                                Reservation_Panel T = new Reservation_Panel(S.getID(),sizeX,sizeY);
                                
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
				reservation_list_panel T = new reservation_list_panel(sizeX,sizeY);
				adder(T);
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
				User_modify_panel T = new User_modify_panel(sizeX,sizeY);
				adder(T);
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
				inquiry_panel T = new inquiry_panel(sizeX,sizeY);
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