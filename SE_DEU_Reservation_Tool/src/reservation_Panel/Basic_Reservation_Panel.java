package Reservation_Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class Basic_Reservation_Panel extends JPanel {
	private String Name; // 강의실 이름
	private int sizex;
	private int sizey;
	private int Nx = 10;
	private int Ny = 10;

	protected int cubes[];

	protected ArrayList<String[]> data = new ArrayList<String[]>();
        private String LectNum[] = {"915","918","916","911"};
	public Basic_Reservation_Panel(String Name, int sizex, int sizey) {
		this.Name = Name;
		this.sizex = sizex;
		this.sizey = sizey;

		this.setBounds(0, 0, sizex, sizey);
		this.setLayout(null);
                
                //해당 Name의 db 체크해서 data에 저장. 
                // Set_cube()에서 확인하여 비활성화 하게 하기 
	}
        public String[] getLects(){
           return LectNum;
        }
	public Basic_Reservation_Panel(String Name) {
		this.Name = Name;
		this.setLayout(null);
	}

	public Basic_Reservation_Panel() {
		this.setLayout(null);
	}

	// 나눌 크기
	public void setSize(int sizex, int sizey) {
		this.sizex = sizex;
		this.sizey = sizey;
	}
	
	public String getName() {
		return this.Name;
	}

	protected void Set_cube_size(int Nx, int Ny) {
		this.Nx = Nx;
		this.Nx = Ny;
	}

	// 들어간 숫자칸에만 버튼 생성
	// 강의실 선택 이벤트
	public void Set_cube() {
		if (Nx <= 0 || Ny <= 0) {
			Nx = 10;
			Ny = 10;
		}
		System.out.println("Nx:" + Nx + "\n" + "Ny:" + Ny + "\n" + "sizex:" + sizex + "\n" + "sizey:" + sizey + "\n");
		if(this.getSize().width == 0 || this.getSize().height ==0)
			this.setBounds(0, 0, sizex, sizey);
		int tableNum = 0;
		for (int i = 0; i < Nx * Ny && tableNum < cubes.length; i++) {
			if (cubes[tableNum] == i + 1) {
				JButton button = new JButton();
				button.setText(Integer.toString(tableNum + 1));
				button.setBounds((i % Nx) * sizex / Nx, ((i / Nx) * sizey / Ny), sizex / Nx, sizey / Ny);
				// 버튼 리스너 추가
				// DB로 검색 후
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
					}
				});
				add(button);
				System.out.println(i + 1 + "번째 버튼생성 완료");
				tableNum++;
			}
		}

	}
}
