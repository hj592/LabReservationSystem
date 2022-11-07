package UICreator;

import javax.swing.JFrame;

import pkg_Frame.MainUI_Frame;

public class UI_Factory {
	All_Main_UI ui=null;
	public MainUI_Frame createUI(int who,MainUI_Frame mainframe) {
		switch(who) {
			case 1:
				ui = new Studnet_UI(mainframe);
				break;
			case 2:
				ui = new Assistant_UI(mainframe);
				break;
			case 3:
				ui = new Professor_UI(mainframe);
				break;
		}
		ui.setPanels();
		return ui.getFrame();
	}
}
