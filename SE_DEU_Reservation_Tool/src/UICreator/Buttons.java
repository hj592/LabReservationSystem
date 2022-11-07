package UICreator;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class Buttons extends JButton {
	Screen_Panel S;
	//Content_Panel C;
	int sizeX;
	int sizeY;
	
	public void Set_Content_Panel(Screen_Panel S) {
		this.S = S;
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

class S1_Button extends Buttons {
	S1_Button() {
		this.setText("콘텐츠변경 확인용");
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remover();
				Student_Reservation_Panel T = new Student_Reservation_Panel(sizeX,sizeY);
				adder(T);
				//C.add(T);
				//C.revalidate();     // 컨테이너 c의 재배치
				//C.repaint();
			}
		});
	}
}

class A1_Button extends Buttons {

}


class P1_Button extends Buttons {

}

class S2_Button extends Buttons {

}

class A2_Button extends Buttons {

}

class P2_Button extends Buttons {

}