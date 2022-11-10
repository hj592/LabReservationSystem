package UICreator;

import java.awt.Color;
import javax.swing.JLabel;

import javax.swing.JPanel;

public abstract class Screen_Panel extends JPanel {
    private String id;
	Screen_Panel(String id) {
            this.id=id;
            this.setLayout(null);
            this.setBackground(new Color(0, 0, 255));
	}
        public String getID(){
            return id;
        }
	abstract void Set_Screen();
}

class Student_Screen_Panel extends Screen_Panel {
	Student_Screen_Panel(String id){
            super(id);
		this.setBackground(new Color(0, 0, 255));
	}

	@Override
	void Set_Screen() {
		// TODO Auto-generated method stub
	}

}

class Assistant_Screen_Panel extends Screen_Panel {
	Assistant_Screen_Panel(String id){
                super(id);
		this.setBackground(new Color(0, 0, 0));
	}

	@Override
	void Set_Screen() {
		// TODO Auto-generated method stub
		
	}

}

class Professor_Screen_Panel extends Screen_Panel {
	 Professor_Screen_Panel(String id){
                 super(id);
		 this.setBackground(new Color(125, 125, 125));
	 }

	@Override
	void Set_Screen() {
		// TODO Auto-generated method stub
		
	}

}
