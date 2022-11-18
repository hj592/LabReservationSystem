package pkg_Frame;

import DB.DB_CONNECTER;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import UICreator.UI_Factory;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public final class Login_Frame extends Basic_Frame {
    //int who ; // 1=Student, 2=Assistant, 3=Professor
    Login_Frame me = this;
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
        frame = new UI_Factory();
        setting_gui();
    }

    public void INFORMATION(String ID, String PW) throws ClassNotFoundException, SQLException {
        String who = "";
        String Arr[][] = DB_CONNECTER.Exe_Qurey("select * from User WHERE " + "user_id = \"" + ID + "\" and user_pw = \"" + PW + "\";");

        if (Arr.length < 2) {
            System.out.println("Error");
            JOptionPane.showMessageDialog(null, "등록된 아이디가 없거나\n비밀번호가 일치하지 않습니다.");
            return;
        } else 
            who = Arr[1][2];

        if (Arr[1][2].equals("1")) {
            Arr = DB_CONNECTER.Exe_Qurey("select * from Student WHERE " + "stu_id = \"" + ID + "\";");
            if (Integer.valueOf(Arr[1][4]) >= 3)
                DB_CONNECTER.Update_Qurey("UPDATE Student SET status = '3'  WHERE stu_id='" + ID + "';");
            else if (Arr[1][2].equals("2"))
                Arr = DB_CONNECTER.Exe_Qurey("select * from Manager WHERE " + "mgr_id = \"" + ID + "\";");
            else if (Arr[1][2].equals("3"))
                Arr = DB_CONNECTER.Exe_Qurey("select * from Manager WHERE " + "mgr_id = \"" + ID + "\";");

        }
        int a = Integer.parseInt(who);
        frame.createUI(a, Arr[1][0], new MainUI_Frame()).Set_Data(Arr);//.setVisible(true);
        me.dispose();

    }

    @Override
    protected void setting_gui() {
        // TODO Auto-generated method stub
        // 여기서 부터 세팅 프레임의 기본배치는 절대배치 setLayout(null);
        JPanel Main_Panel = new JPanel();			//기본 패널 사용시 주석 해제
        Main_Panel.setBounds(0, 0, this.getSize().width, this.getSize().height); //프레임 크기만큼을 할당함
        add(Main_Panel); 	//프레임 크기만큼을 할당함
        Main_Panel.setLayout(null);	// 절대배치
        JLabel ID = new JLabel("ID");
        ID.setBounds(25, 25, 50, 25); //프레임 크기만큼을 할당함
        Main_Panel.add(ID);

        JTextField ID_Text = new JTextField("20220001");
        ID_Text.setBounds(25 + 50, 25, Main_Panel.getWidth() / 2 - 50, 25); //프레임 크기만큼을 할당함
        Main_Panel.add(ID_Text);

        JLabel PW = new JLabel("PW");
        PW.setBounds(25, 25 + 35, 50, 25); //프레임 크기만큼을 할당함
        Main_Panel.add(PW);

        JPasswordField PW_Text = new JPasswordField("1234");
        PW_Text.setBounds(25 + 50, 25 + 35, Main_Panel.getWidth() / 2 - 50, 25); //프레임 크기만큼을 할당함
        Main_Panel.add(PW_Text);

        JButton Login_Button = new JButton("로그인");
        Login_Button.setBounds(50 + Main_Panel.getWidth() / 2, 25 + 35, Main_Panel.getWidth() / 3 - 25, 25); //프레임 크기만큼을 할당함
        Login_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    INFORMATION(ID_Text.getText(), new String(PW_Text.getPassword()));
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Login_Frame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Login_Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        Main_Panel.add(Login_Button);

        JButton Member_Button = new JButton("회원가입");
        Member_Button.setBounds(50 + Main_Panel.getWidth() / 2, 25, Main_Panel.getWidth() / 3 - 25, 25); //프레임 크기만큼을 할당함
        Main_Panel.add(Member_Button);
        Member_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DAP_Frame();

            }
        });
    }
}
