package pkg_Frame;

import DB.Dap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/* 프레임 추가를 위한 예제 프레임 */
/* 1. 해당 파일 복사 후 붙여넣기 (패캐지 제외)
 * 2. workspace에서 해당 클래스 파일 우클릭 후 Refactor->Rename 로 클래스명 변경 하거나 직접 변경할 것
 * /
/*	여기서부터 복사	 */

public class DAP_Frame extends Basic_Frame {
         DAP_Frame Me = this;
	DAP_Frame() {
		// TODO Auto-generated constructor stub
		super();
		final String title = "DAP인증";
		// 기본 크기는 화면의 4/1 크기. 즉 width, height가 가로/2, 세로/2 의 크기를 각각 가짐 기본값 0
		final int sizex = 400;
		final int sizey = 150;
		
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
                
                JButton Login_Button = new JButton("인증");
		Login_Button.setBounds(50+Main_Panel.getWidth()/2,25,Main_Panel.getWidth()/3-25 ,60); //프레임 크기만큼을 할당함
		Login_Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                             String pw = new String(PW_Text.getPassword());
                             String[] dapinfo = new Dap().DAPCONNET(ID_Text.getText(),pw);
                             if (dapinfo == null){
                                  JOptionPane.showMessageDialog(null, "Dap로그인에 실패했습니다.\n아이디 혹은 비밀번호를 확인해주세요.\n※Dap사이트의 로그인시스템과 연결되어있어\n 5회 이상 실패 시 같은 패널티가 부여되니 주의하세요.※.");
                                  return;
                             }
                             System.out.println(dapinfo[1]);
                             if(!dapinfo[1].equals("컴퓨터소프트웨어공학")){
                                  JOptionPane.showMessageDialog(null, "\"컴퓨터소프트웨어공학\" 전공 학생이 아닙니다.\n 학과사무실을 통해 문의해보세요.");
                                  return;
                             }
                             /*학번 전공 학년 이름 전화번호 학적상태*/
                             new Member_Frame(dapinfo).setVisible(true);
                             Me.dispose();
                        } catch (NoSuchAlgorithmException ex) {
                            Logger.getLogger(DAP_Frame.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (KeyManagementException ex) {
                            Logger.getLogger(DAP_Frame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                Main_Panel.add(Login_Button);
                add(Main_Panel);
	}

}