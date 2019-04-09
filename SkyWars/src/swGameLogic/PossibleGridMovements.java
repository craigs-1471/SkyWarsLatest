package swGameLogic;

import java.util.ArrayList;

public class PossibleGridMovements {
	
	private static ArrayList<Integer> btn0Moves = new ArrayList<Integer>() {
		{
			add(1);
			add(4);
			add(5);
		}
	};
	private static ArrayList<Integer> btn1Moves = new ArrayList<Integer>() {
		{
			add(0);
			add(2);
			add(4);
			add(5);
			add(6);
		}
	};
	private static ArrayList<Integer> btn2Moves = new ArrayList<Integer>() {
		{
			add(1);
			add(3);
			add(5);
			add(6);
			add(7);
		}
	};
	private static ArrayList<Integer> btn3Moves = new ArrayList<Integer>() {
		{
			add(2);
			add(6);
			add(7);
		}
	};
	private static ArrayList<Integer> btn4Moves = new ArrayList<Integer>() {
		{
			add(0);
			add(1);
			add(5);
			add(8);
			add(9);
		}
	};
	private static ArrayList<Integer> btn5Moves = new ArrayList<Integer>() {
		{
			add(0);
			add(1);
			add(2);
			add(4);
			add(6);
			add(8);
			add(9);
			add(10);
		}
	};
	private static ArrayList<Integer> btn6Moves = new ArrayList<Integer>() {
		{
			add(1);
			add(2);
			add(3);
			add(5);
			add(7);
			add(9);
			add(10);
			add(11);
		}
	};
	private static ArrayList<Integer> btn7Moves = new ArrayList<Integer>() {
		{
			add(2);
			add(3);
			add(6);
			add(10);
			add(11);
		}
	};
	private static ArrayList<Integer> btn8Moves = new ArrayList<Integer>() {
		{
			add(4);
			add(5);
			add(9);
			add(12);
			add(13);
		}
	};
	private static ArrayList<Integer> btn9Moves = new ArrayList<Integer>() {
		{
			add(4);
			add(5);
			add(6);
			add(8);
			add(10);
			add(12);
			add(13);
			add(14);
		}
	};
	private static ArrayList<Integer> btn10Moves = new ArrayList<Integer>() {
		{
			add(5);
			add(6);
			add(7);
			add(9);
			add(11);
			add(13);
			add(14);
			add(15);
		}
	};
	private static ArrayList<Integer> btn11Moves = new ArrayList<Integer>() {
		{
			add(6);
			add(7);
			add(10);
			add(14);
			add(15);
		}
	};
	private static ArrayList<Integer> btn12Moves = new ArrayList<Integer>() {
		{
			add(8);
			add(9);
			add(13);
		}
	};
	private static ArrayList<Integer> btn13Moves = new ArrayList<Integer>() {
		{
			add(8);
			add(9);
			add(10);
			add(12);
			add(14);
		}
	};
	private static ArrayList<Integer> btn14Moves = new ArrayList<Integer>() {
		{
			add(9);
			add(10);
			add(11);
			add(13);
			add(15);
		}
	};
	private static ArrayList<Integer> btn15Moves = new ArrayList<Integer>() {
		{
			add(10);
			add(11);
			add(14);
		}
	};
	
	public static boolean isMovePossible(int currentLocation, ArrayList<Integer> moves) {
		
		for(int i = 0; i < moves.size(); i++) {
			if(currentLocation == moves.get(i)) {
				return true;
			}
		}
		return false;
	}
	
	public static ArrayList<Integer> getPossibleMoves(int currentLocation) {
		ArrayList<Integer> possibleMoves = null;
		switch(currentLocation) {
			case 0:
				possibleMoves = getBtn0Moves();
				break;
			case 1:
				possibleMoves = getBtn1Moves();
				break;	
			case 2:
				possibleMoves = getBtn2Moves();
				break;	
			case 3:
				possibleMoves = getBtn3Moves();
				break;	
			case 4:
				possibleMoves = getBtn4Moves();
				break;	
			case 5:
				possibleMoves = getBtn5Moves();
				break;	
			case 6:
				possibleMoves = getBtn6Moves();
				break;	
			case 7:
				possibleMoves = getBtn7Moves();
				break;	
			case 8:
				possibleMoves = getBtn8Moves();
				break;	
			case 9:
				possibleMoves = getBtn9Moves();
				break;	
			case 10:
				possibleMoves = getBtn10Moves();
				break;	
			case 11:
				possibleMoves = getBtn11Moves();
				break;	
			case 12:
				possibleMoves = getBtn12Moves();
				break;	
			case 13:
				possibleMoves = getBtn13Moves();
				break;	
			case 14:
				possibleMoves = getBtn14Moves();
				break;	
			case 15:
				possibleMoves = getBtn15Moves();
				break;	
		}
		return possibleMoves;
	}

	public static ArrayList<Integer> getBtn0Moves() {
		return btn0Moves;
	}

	public static void setBtn0Moves(ArrayList<Integer> btn0Moves) {
		PossibleGridMovements.btn0Moves = btn0Moves;
	}

	public static ArrayList<Integer> getBtn1Moves() {
		return btn1Moves;
	}

	public static void setBtn1Moves(ArrayList<Integer> btn1Moves) {
		PossibleGridMovements.btn1Moves = btn1Moves;
	}

	public static ArrayList<Integer> getBtn2Moves() {
		return btn2Moves;
	}

	public static void setBtn2Moves(ArrayList<Integer> btn2Moves) {
		PossibleGridMovements.btn2Moves = btn2Moves;
	}

	public static ArrayList<Integer> getBtn3Moves() {
		return btn3Moves;
	}

	public static void setBtn3Moves(ArrayList<Integer> btn3Moves) {
		PossibleGridMovements.btn3Moves = btn3Moves;
	}

	public static ArrayList<Integer> getBtn4Moves() {
		return btn4Moves;
	}

	public static void setBtn4Moves(ArrayList<Integer> btn4Moves) {
		PossibleGridMovements.btn4Moves = btn4Moves;
	}

	public static ArrayList<Integer> getBtn5Moves() {
		return btn5Moves;
	}

	public static void setBtn5Moves(ArrayList<Integer> btn5Moves) {
		PossibleGridMovements.btn5Moves = btn5Moves;
	}

	public static ArrayList<Integer> getBtn6Moves() {
		return btn6Moves;
	}

	public static void setBtn6Moves(ArrayList<Integer> btn6Moves) {
		PossibleGridMovements.btn6Moves = btn6Moves;
	}

	public static ArrayList<Integer> getBtn7Moves() {
		return btn7Moves;
	}

	public static void setBtn7Moves(ArrayList<Integer> btn7Moves) {
		PossibleGridMovements.btn7Moves = btn7Moves;
	}

	public static ArrayList<Integer> getBtn8Moves() {
		return btn8Moves;
	}

	public static void setBtn8Moves(ArrayList<Integer> btn8Moves) {
		PossibleGridMovements.btn8Moves = btn8Moves;
	}

	public static ArrayList<Integer> getBtn9Moves() {
		return btn9Moves;
	}

	public static void setBtn9Moves(ArrayList<Integer> btn9Moves) {
		PossibleGridMovements.btn9Moves = btn9Moves;
	}

	public static ArrayList<Integer> getBtn10Moves() {
		return btn10Moves;
	}

	public static void setBtn10Moves(ArrayList<Integer> btn10Moves) {
		PossibleGridMovements.btn10Moves = btn10Moves;
	}

	public static ArrayList<Integer> getBtn11Moves() {
		return btn11Moves;
	}

	public static void setBtn11Moves(ArrayList<Integer> btn11Moves) {
		PossibleGridMovements.btn11Moves = btn11Moves;
	}

	public static ArrayList<Integer> getBtn12Moves() {
		return btn12Moves;
	}

	public static void setBtn12Moves(ArrayList<Integer> btn12Moves) {
		PossibleGridMovements.btn12Moves = btn12Moves;
	}

	public static ArrayList<Integer> getBtn13Moves() {
		return btn13Moves;
	}

	public static void setBtn13Moves(ArrayList<Integer> btn13Moves) {
		PossibleGridMovements.btn13Moves = btn13Moves;
	}

	public static ArrayList<Integer> getBtn14Moves() {
		return btn14Moves;
	}

	public static void setBtn14Moves(ArrayList<Integer> btn14Moves) {
		PossibleGridMovements.btn14Moves = btn14Moves;
	}

	public static ArrayList<Integer> getBtn15Moves() {
		return btn15Moves;
	}

	public static void setBtn15Moves(ArrayList<Integer> btn15Moves) {
		PossibleGridMovements.btn15Moves = btn15Moves;
	}
	
}
