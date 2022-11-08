package pkg_Frame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Wellcom_Frame extends Basic_Frame{

	private Image background=new ImageIcon(Wellcom_Frame.class.getResource("../source/img.jpg")).getImage();
	private Login_Frame login;
	Wellcom_Frame() {
		// TODO Auto-generated constructor stub
		super();
		final String title = "1";
		// 기본 크기는 화면의 4/1 크기. 즉 width, height가 가로/2, 세로/2 의 크기를 각각 가짐 기본값 0
		final int sizex = 0;
		final int sizey = 0;
		
		setTitle(title);
		Set_Loc_and_Size(sizex, sizey);
		
		// 기본 위치 값도 변경할시 주석해제 할 것.
		// 기본 위치는 프레임의 정중앙이 화면의 정중앙에 오도록 배치함.
		// final int locx = 0;
		// final int locy = 0;
		// Set_Loc_and_Size(locx,locy,sizex,sizey);
		//setUndecorated(true);
		setting_gui();
		//setVisible(true);
		login = new Login_Frame();;
		login.setVisible(true);
		dispose();
	}

	@Override
	protected void setting_gui() {
		// TODO Auto-generated method stub
		// 여기서 부터 세팅 프레임의 기본배치는 절대배치 setLayout(null);
		
		 JPanel Main_Panel = new JPanel(); //기본 패널 사용시 주석 해제
		 Main_Panel.setBounds(0,0,this.getSize().width,this.getSize().height); //프레임
		// add(Main_Panel); //프레임 크기만큼을 할당함
		 
		 JPanel Main_Panel2 = new JPanel(); //기본 패널 사용시 주석 해제
		 Main_Panel2.setBounds(0,this.getSize().height*2/3,this.getSize().width,this.getSize().height/3); //프레임
		// add(Main_Panel2); //프레임 크기만큼을 할당함
		setBackground(new Color(255,255,255));
		setUndecorated(true);
		setVisible(true);
		//new Login_Frame();
		System.out.println("hello");
		try {
			Thread.sleep(2000);
			for (int i = 255; i >0; i--) {
				//setUndecorated(true);

				setBackground(new Color(255,255,255,i));
				//Main_Panel.setBackground(new Color(238,238,238,i));
				//Main_Panel2.setBackground(new Color(0,0,255,i));
				Thread.sleep(1);
				//setVisible(true);
			} 
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public void paint(Graphics g) {//그리는 함수
		g.drawImage(background, this.getSize().width/4, this.getSize().height/4,this.getSize().width/2,this.getSize().height/2, null);//background를 그려줌
}

}