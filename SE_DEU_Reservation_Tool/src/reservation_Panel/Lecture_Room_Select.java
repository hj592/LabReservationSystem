package Reservation_Panel;

public class Lecture_Room_Select {
	Basic_Reservation_Panel panel = null;

	public Basic_Reservation_Panel getRoom(String s) {
                if (s.equals("0"))
			panel = new Lecture_Room();
                else if (s.equals("915"))
			panel = new Lecture_Room_915();
		else if (s.equals("911"))
			panel = new Lecture_Room_911();
		else if (s.equals("916"))
			panel = new Lecture_Room_916();
		else if (s.equals("918"))
			panel = new Lecture_Room_918();
		return panel;
	}
}
