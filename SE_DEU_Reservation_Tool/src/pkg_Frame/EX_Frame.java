package pkg_Frame;


/* 프레임 추가를 위한 예제 프레임 */
 /* 1. 해당 파일 복사 후 붙여넣기 (패캐지 제외)
 * 2. workspace에서 해당 클래스 파일 우클릭 후 Refactor->Rename 로 클래스명 변경 하거나 직접 변경할 것
 * /
/*	여기서부터 복사	 */
public class EX_Frame extends Basic_Frame {

    EX_Frame() {
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
        //setting_gui();
        //setVisible(true);
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
