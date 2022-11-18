package pkg_Frame;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

abstract class Basic_Frame extends JFrame {

    /*
	 * 기본 J프레임 크기 및 위치 세팅 
	 * 기본값은 프레임의 정중앙이 화면 정중앙에 오도록 배치
     */

    protected Dimension res = Toolkit.getDefaultToolkit().getScreenSize(); //전체 해상도 가져옴

    Basic_Frame() {
        setLayout(null);	//절대배치
        setResizable(false); //크기변경 불가
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    protected void Set_Loc_and_Size(int sizex, int sizey) {
        if (sizex == 0 || sizex < 0) //0이거나 0이하면 화면의 절반크기의 사이즈를 가진다.
            sizex = (int) (res.getWidth() / 2);
        if (sizey == 0 || sizey < 0) //0이거나 0이하면 화면의 절반크기의 사이즈를 가진다.
            sizey = (int) (res.getHeight() / 2);
        setBounds((int) (res.getWidth() / 2) - (sizex / 2), (int) (res.getHeight() / 2) - (sizey / 2), sizex, sizey); //위치x,y 크기x,y
    }

    protected void Set_Loc_and_Size(int locx, int locy, int sizex, int sizey) {
        if (sizex == 0 || sizex < 0) //0이거나 0이하면 화면의 절반크기의 사이즈를 가진다.
            sizex = (int) (res.getWidth() / 2);
        if (sizey == 0 || sizey < 0) //0이거나 0이하면 화면의 절반크기의 사이즈를 가진다.
            sizey = (int) (res.getHeight() / 2);
        if (locx < 0) //0이하면 화면의 절반크기의 사이즈를 가진다.
            locx = (int) (res.getWidth() / 2) - (sizex / 2);
        if (sizey < 0) //0이하면 화면의 절반크기의 사이즈를 가진다.
            locy = (int) (res.getHeight() / 2) - (sizey / 2);
        setBounds(locx, locy, sizex, sizey); //위치x,y 크기x,y
    }

    protected int getMoniterSizeX() {
        return res.width;
    }

    protected int getMoniterSizeY() {
        return res.height;
    }

    abstract protected void setting_gui();	// 자식 클래스가 구현할 장소

}
