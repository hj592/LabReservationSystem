package Reservation_Panel;

class Lecture_Room extends Basic_Reservation_Panel {

}
class Lecture_Room_911 extends Basic_Reservation_Panel {
	private final int cubes[] = { 11, 12, 13, 14, 17, 18, 19, 20, 
								  31, 32, 33, 34, 37, 38, 39, 40 };

	public Lecture_Room_911() {
		super.cubes = this.cubes;
	}

}

class Lecture_Room_918 extends Basic_Reservation_Panel {
	private final int cubes[] = { 11, 12, 13, 14, 17, 18, 19, 20, 
								  31, 32, 33, 34, 37, 38, 39, 40 };

	public Lecture_Room_918() {
		super.cubes = this.cubes;
	}
}

class Lecture_Room_915 extends Basic_Reservation_Panel {
	private final int cubes[] = { 11, 12, 13, 14, 17, 18, 19, 20 
																};

	public Lecture_Room_915() {
		super.cubes = this.cubes;
	}
}

class Lecture_Room_916 extends Basic_Reservation_Panel {
	private final int cubes[] = { 11, 12, 13, 14, 17, 18, 19, 20, 
								  31, 32, 33, 34, 37, 38, 39, 40 };

	public Lecture_Room_916() {
		super.cubes = this.cubes;
	}

}

// ---------------------------------------------------
/*
 * class Lecture_Room_915 extends Basic_Reservation_Panel{ private final int
 * cubes[] = {11,12,13,14,17,18,19,20, 31,32,33,34,37,38,39,40};
 * 
 * public Lecture_Room_915(String Name, int sizex, int sizey) { super(Name,
 * sizex, sizey); super.cubes = this.cubes; } public Lecture_Room_915(String
 * Name) { super(Name); super.cubes = this.cubes; }
 * 
 * public Lecture_Room_915() { super.cubes = this.cubes; } }
 */
