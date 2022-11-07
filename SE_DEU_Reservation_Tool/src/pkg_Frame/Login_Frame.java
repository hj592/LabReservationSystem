package pkg_Frame;

import DB.DB_CONNETER;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import UICreator.UI_Factory;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Login_Frame extends Basic_Frame {
	int who ; // 1=Student, 2=Assistant, 3=Professor

	//Image SE_Logo=new ImageIcon(Login_Frame.class.getResource("../source/logo.png")).getImage();
	//JPanel Main_Panel2 = new JPanel();	
	private UI_Factory frame;
	Login_Frame() {
		// TODO Auto-generated constructor stub
		super();
		final String title = "로그인";
		// 기본 크기는 화면의 4/1 크기. 즉 width, height가 가로/2, 세로/2 의 크기를 각각 가짐 기본값 0
		final int sizex = 400;
		final int sizey = 200;
		
		setTitle(title);
		Set_Loc_and_Size(sizex, sizey);
		
		// 기본 위치 값도 변경할시 주석해제 할 것.
		// 기본 위치는 프레임의 정중앙이 화면의 정중앙에 오도록 배치함.
		 //final int locx = 0;
		 //final int locy = 0; 
		 //Set_Loc_and_Size(locx,locy,sizex,sizey);
		frame = new UI_Factory();
		setting_gui();
                
		//setVisible(true);
	}
	public void INFORMATION() throws ClassNotFoundException, SQLException {
         //
         //int i = who; //임시
        // DB_CONNETER.Exe_Qurey("select * from ");
         who = 1; // 1=Student, 2=Assistant, 3=Professor
         String My_data[][] = {{},{"2",Integer.toString(who)}};  //임시. 0인덱스 = 학생일시 상태패턴분류용 | 1인덱스=사용자 분류 1이 학생 
    	 frame.createUI(who,new MainUI_Frame()).Set_Data(My_data);//.setVisible(true);
	}

	@Override
	protected void setting_gui() {
		// TODO Auto-generated method stub
		// 여기서 부터 세팅 프레임의 기본배치는 절대배치 setLayout(null);
		JPanel Main_Panel = new JPanel();			//기본 패널 사용시 주석 해제
		Main_Panel.setBounds(0,0,this.getSize().width,this.getSize().height); //프레임 크기만큼을 할당함
		add(Main_Panel); 	//프레임 크기만큼을 할당함
		Main_Panel.setLayout(null);	// 절대배치
		
		JLabel ID = new JLabel("ID");
		ID.setBounds(25,25,50 ,25); //프레임 크기만큼을 할당함
		Main_Panel.add(ID);
		
		JTextField ID_Text = new JTextField("");
		ID_Text.setBounds(25+50,25,Main_Panel.getWidth()/2-50 ,25); //프레임 크기만큼을 할당함
		Main_Panel.add(ID_Text);
				
		JLabel PW = new JLabel("PW");
		PW.setBounds(25,25+35,50 ,25); //프레임 크기만큼을 할당함
		Main_Panel.add(PW);
		
		JPasswordField PW_Text = new JPasswordField("");
		PW_Text.setBounds(25+50,25+35,Main_Panel.getWidth()/2-50 ,25); //프레임 크기만큼을 할당함
		Main_Panel.add(PW_Text);
		
		JButton Login_Button = new JButton("로그인");
		Login_Button.setBounds(50+Main_Panel.getWidth()/2,25+35,Main_Panel.getWidth()/3-25 ,25); //프레임 크기만큼을 할당함
		Login_Frame me = this;
		Login_Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            INFORMATION();
                            me.dispose();
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Login_Frame.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(Login_Frame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
		Main_Panel.add(Login_Button);
		
		JButton Member_Button = new JButton("회원가입");
		Member_Button.setBounds(50+Main_Panel.getWidth()/2,25,Main_Panel.getWidth()/3-25 ,25); //프레임 크기만큼을 할당함
		Main_Panel.add(Member_Button);
		
		JPanel ColorP = new JPanel();			
		ColorP.setBounds(0,0,this.getSize().width,this.getSize().height/2); // 프레임의 크기를 계산하여 툴바까지 계산 영역에 넣음. 황금비율
		ColorP.setBackground(new Color(255,255,255));
		Main_Panel.add(ColorP);
		/*
		int a= this.getWidth();
		int b= this.getHeight();
		JPanel ColorP2=new JPanel() {
			Image background=new ImageIcon(Login_Frame.class.getResource("../source/logo2.png")).getImage();
			public void paint(Graphics g) {//그리는 함수
				//g.setClip(0, 0, background.getWidth(ColorP), background.getHeight(ColorP)+200);
				g.drawImage(background, 0, 0, a/3,b/4+10, null);//background를 그려줌	
				
			}
		};
		*/
		JPanel ColorP2 = new JPanel();			
		ColorP2.setBounds(0,this.getSize().height/2,this.getSize().width,this.getSize().height/2); //프레임 크기만큼을 할당함
		ColorP2.setBackground(new Color(0,0,255));
		Main_Panel.add(ColorP2);
		 
		//setUndecorated(true);
		//setBackground(new Color(0,0,0,122));
		//Main_Panel.setBackground(new Color(0,0,0,122));
		//ColorP.setBackground(new Color(0,0,0,122));
		//ColorP2.setBackground(new Color(0,0,0,122));
	}

}