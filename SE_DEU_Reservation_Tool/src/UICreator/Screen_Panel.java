package UICreator;

import java.awt.Color;
import javax.swing.JLabel;

import javax.swing.JPanel;

public abstract class Screen_Panel extends JPanel {
	Screen_Panel() {
		this.setLayout(null);
		this.setBackground(new Color(0, 0, 255));
	}
	abstract void Set_Screen();
}

class Student_Screen_Panel extends Screen_Panel {
	Student_Screen_Panel(){
		this.setBackground(new Color(0, 0, 255));
	}

	@Override
	void Set_Screen() {
		// TODO Auto-generated method stub
	}

}

class Assistant_Screen_Panel extends Screen_Panel {
	Assistant_Screen_Panel(){
		this.setBackground(new Color(0, 0, 0));
	}

	@Override
	void Set_Screen() {
		// TODO Auto-generated method stub
		
	}

}

class Professor_Screen_Panel extends Screen_Panel {
	 Professor_Screen_Panel(){
		 this.setBackground(new Color(125, 125, 125));
	 }

	@Override
	void Set_Screen() {
		// TODO Auto-generated method stub
		
	}

}
