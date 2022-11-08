package UICreator;

import javax.swing.JFrame;

import pkg_Frame.MainUI_Frame;

abstract class All_Main_UI implements MainUI_Interface{
	public Button_Panel b;
	public Screen_Panel s;
	public Content_Panel c;
	MainUI_Frame frame;
	
	int locx,locy,sizex,sizey;
	All_Main_UI(MainUI_Frame frame){
		this.frame = frame;
		this.locx = frame.getSize().width;
		this.locy = frame.getSize().height;
		this.sizex = frame.getLocation().x;
		this.sizey = frame.getLocation().y;
	}
	private void SET(){
		
		s.setBounds(0,0,locx*7/10,locy);
		s.Set_Screen();
		
		final int Ssizex = s.getSize().width;
		final int Ssizey = s.getSize().height;
		c.setBounds(Ssizex/20,Ssizey*3/20,Ssizex*18/20,Ssizey*16/20);
		c.Set_Multi_Layout();
		s.add(c);
		
		b.setBounds(locx*7/10,0,locx*3/10,locy);
		b.Sorting_Button(s);
		
	}
	public MainUI_Frame getFrame() {
		SET();
		frame.add(b);
		frame.add(s);
		//s.add(c);
		frame.Set_Panels(b, s, c);
		return frame;
	}
}

class Studnet_UI extends All_Main_UI{
	Studnet_UI(MainUI_Frame frame){
		super(frame);
	}

	@Override
	public void setPanels() {
		// TODO Auto-generated method stub
		c = new Student_Content_Panel();
		b = new Student_Button_Panel();
		s = new Student_Screen_Panel();
	}
}

class Assistant_UI extends All_Main_UI{

	Assistant_UI(MainUI_Frame frame) {
		super(frame);
	}

	@Override
	public void setPanels() {
		// TODO Auto-generated method stub
		c = new Assistant_Content_Panel();
		b = new Assistant_Button_Panel();
		s = new Assistant_Screen_Panel();
	}
}

class Professor_UI extends All_Main_UI{

	Professor_UI(MainUI_Frame frame) {
		super(frame);
	}

	@Override
	public void setPanels() {
		// TODO Auto-generated method stub
		c = new Professor_Content_Panel();
		b = new Professor_Button_Panel();
		s = new Professor_Screen_Panel();
	}
}
