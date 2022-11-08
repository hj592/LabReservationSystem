/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg_Frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Genius
 */
public class Member_Frame extends Basic_Frame {


	Member_Frame(){
		// TODO Auto-generated constructor stub
		super();
		final String title = "타이틀입력";
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

		setting_gui();
		setVisible(true);
	}

	@Override
	protected void setting_gui() {
		// TODO Auto-generated method stub
		// 여기서 부터 세팅 프레임의 기본배치는 절대배치 setLayout(null);
		/*
		JPanel Main_Panel = new JPanel();			//기본 패널 사용시 주석 해제
		Main_Panel.setBounds(0,0,this.getSize().width,this.getSize().height); //프레임 크기만큼을 할당함
		add(Main_Panel); 	//프레임 크기만큼을 할당함
		*/
                
        }
}