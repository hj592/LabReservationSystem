package Reservation_Panel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public abstract class Basic_Reservation_Panel extends JPanel {

    private String Name; // 강의실 이름
    private int sizex;
    private int sizey;
    private int Nx = 10;
    private int Ny = 10;
    private int Max = 1;
    private boolean reserve_cheking = false;
    protected int cubes[];
    public ArrayList<JButton> buttons = new ArrayList<JButton>();
    public LinkedList<JButton> buttons2 = new LinkedList<JButton>();
    protected ArrayList<String[]> data = new ArrayList<String[]>();

    public Basic_Reservation_Panel(String Name, int sizex, int sizey) {

        this.Name = Name;
        this.sizex = sizex;
        this.sizey = sizey;
        this.setBounds(0, 0, sizex, sizey);
        this.setLayout(null);
    }

    public void reserve_true() {
        reserve_cheking = true;
    }

    public void SetMax(int Max) {
        if (Max < this.Max) {
            for (int i = 0; i < this.Max - Max && buttons2.size() != 0; i++) {
                buttons2.getFirst().setBackground(null);
                buttons2.getFirst().setEnabled(true);
                buttons2.remove(); //FIFO. 가장 먼저 빼옴
                buttons2.getFirst().setBackground(new Color(75, 125, 255));
            }
        }
        this.Max = Max;
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
        if (this.getSize().width == 0 || this.getSize().height == 0) {
            this.setBounds(0, 0, sizex, sizey);
        }
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

                        if (reserve_cheking != true) {
                            button.setBackground(new Color(125, 225, 255));
                            if (buttons2.size() == 0) 
                                button.setBackground(new Color(75, 125, 255));

                            button.setEnabled(false);
                            buttons2.add(button);
                            if (buttons2.size() > Max) {
                                buttons2.getFirst().setBackground(null);
                                buttons2.getFirst().setEnabled(true);
                                buttons2.remove();
                                buttons2.getFirst().setBackground(new Color(75, 125, 255));
                            }
                            System.out.println("Hi");
                        } else {
                            JOptionPane.showMessageDialog(null, "이미 예약하신 상태 입니다.\n예약취소 후 시도하세요.");
                        }
                    }
                });
                buttons.add(button);
                add(button);
               // System.out.println(i + 1 + "번째 버튼생성 완료");
                tableNum++;
            }
        }

    }
}
