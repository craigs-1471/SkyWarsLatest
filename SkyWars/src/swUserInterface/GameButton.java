package swUserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import swGameLogic.PossibleGridMovements;

public class GameButton extends JButton implements ActionListener{
	
	private static int numberOfGameButtons = 0;
	private int btnIndex;
	private ImageIcon masterShip, battleStar, battleCruiser, battleShooter;
	private ArrayList<Integer> possibleMoves;
	private boolean movePossible;
	
	public GameButton() {
		btnIndex = numberOfGameButtons++;
		this.possibleMoves = PossibleGridMovements.getPossibleMoves(btnIndex);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}
	
	
	
}
