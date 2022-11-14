package pkg_Frame;

import DB.DB_CONNECTER;
import java.util.ArrayList;

import javax.swing.JPanel;

import UICreator.Button_Panel;
import UICreator.Screen_Panel;
import UICreator.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
/* 프레임 추가를 위한 예제 프레임 */
/* 1. 해당 파일 복사 후 붙여넣기 (패캐지 제외)
 * 2. workspace에서 해당 클래스 파일 우클릭 후 Refactor->Rename 로 클래스명 변경 하거나 직접 변경할 것
 * /
/*	여기서부터 복사	 */

public class MainUI_Frame extends Basic_Frame {
	public Button_Panel B;
	public Screen_Panel S;
	public Content_Panel C;
        private JPanel Main_Panel;
        public String My_data[][];
        MainUI_Frame Me = this;
        
        public JLabel ta = new JLabel();
         
        boolean isDragged = false;
int offX, offY;

	MainUI_Frame() {
		// TODO Auto-generated constructor stub
		super();
		final String title = "타이틀입력";
		// 기본 크기는 화면의 4/1 크기. 즉 width, height가 가로/2, 세로/2 의 크기를 각각 가짐 기본값 0
		final int sizex = 1280;
		final int sizey = 720;
		
		setTitle(title);
		Set_Loc_and_Size(sizex, sizey);
                System.out.println(this.getSize().width+", "+this.getSize().height);
		setUndecorated(true);
		// 기본 위치 값도 변경할시 주석해제 할 것.
		// 기본 위치는 프레임의 정중앙이 화면의 정중앙에 오도록 배치함.
		// final int locx = 0;
		// final int locy = 0;
		// Set_Loc_and_Size(locx,locy,sizex,sizey);
            setting_gui();
		//setVisible(true);
	}
        public void Set_Data(String[][] My_data) throws SQLException, ClassNotFoundException{
            this.My_data = My_data;
            if(this.My_data[1].length>3)
                B.Exe_State(this.My_data[1][3]);
            
          //  JTextArea ta = new JTextArea(2,1);
            ta.setBounds(300, 5, 300, 50);
            ta.setText(My_data[1][0]);
            ta.setFont(new Font(this.My_data[1][3],Font.BOLD,40));
            ta.setForeground(Color.white); 
            //ta.setEnabled(false);
            String[][] Lect_M = DB_CONNECTER.Exe_Qurey("SELECT * FROM Lab_Seat WHERE seat_status = '1' ORDER BY end_time DESC, start_date ASC LIMIT 1;");
            
            if (Lect_M.length > 1) {
                if (Lect_M[1][3].equals(ta.getText()))
                    ta.setForeground(Color.yellow);
            }
            Main_Panel.add(ta);

            this.setVisible(true);
        }
	public void Set_Panels(Button_Panel B,Screen_Panel S,Content_Panel C) {
		this.C = C;
		this.S =S;
		this.B =B;
	}
    @Override
    protected void setting_gui() {
        // TODO Auto-generated method stub
        // 여기서 부터 세팅 프레임의 기본배치는 절대배치 setLayout(null);
         ImageIcon img = new ImageIcon("./src/image/logo.png");
         ImageIcon img2 = new ImageIcon("./src/image/icons8_delete_32px.png");
         
         
        JButton CLOSE = new JButton(img2);
        CLOSE.setBackground(new Color(255, 255, 255));
        CLOSE.setFocusPainted(false);
        CLOSE.setBounds(this.getSize().width* 19 / 20, 0, this.getSize().width / 20, this.getSize().height/12); //프레임 크기만큼을 할당함
        CLOSE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JPanel T = C.initComponents();
                 System.exit(0);
            }
        });
        add(CLOSE);
        
        Main_Panel = new JPanel();			//기본 패널 사용시 주석 해제
        Main_Panel.setBounds(0, 0, this.getSize().width, this.getSize().height / 12); //프레임 크기만큼을 할당함
        Main_Panel.setBackground(new Color(6, 53, 94));	//프레임 크기만큼을 할당함
        Main_Panel.setLayout(null);


        JButton HOME = new JButton(img);
        HOME.setBorderPainted(false);
        HOME.setBounds(0, 0, Main_Panel.getSize().width / 8, Main_Panel.getSize().height); //프레임 크기만큼을 할당함
        HOME.setFocusPainted(false);
        HOME.setBackground(new Color(6, 53, 94));
        HOME.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JPanel T = C.initComponents();
                C.removeAll();
                C.revalidate();     // 컨테이너 c의 재배치
                C.repaint();
                C.initComponents();
            }
        });
        
     //   this.addMouseListener(new mv());
        add(HOME);
        add(Main_Panel); 

    }

}
/*
private class mv implements MouseListener {
    public void mousePressed(MouseEvent me) {
        if (Me.contains(new Point(me.getX(), me.getY()))) {

            isDragged = true;
            offX = me.getX() - Me.getLocation().x;

            offY = me.getY() - Me.getLocation().y;
        }
    }

    public void mouseDragged(MouseEvent me) {
        if (isDragged) {

            Me.getLocation().x = me.getX() - offX;
            Me.getLocation().y = me.getY() - offY;
        }
        repaint();
    }

    public void mouseReleased(MouseEvent me) {
        isDragged = false;

    }
    
}
*/