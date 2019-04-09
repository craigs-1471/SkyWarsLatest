package swUserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import swGameData.GridList;
import swGameLogic.PlayGame;
import swGameLogic.PossibleGridMovements;
import swSpaceships.Spaceship;

public class GameButton extends JButton implements ActionListener{
	
	private static int numberOfGameButtons = 0;
	private int btnIndex;
	private ImageIcon masterShip, battleStar, battleCruiser, battleShooter;
	private ArrayList<Integer> possibleMoves;
	
	public GameButton() {
		btnIndex = numberOfGameButtons++;
		this.possibleMoves = PossibleGridMovements.getPossibleMoves(btnIndex);
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Button Clicked");
		Spaceship player = PlayGame.getPlayer();
		int currentPlayerLocation = player.getCurrentLocation();
		boolean isMovePossible = PossibleGridMovements.isMovePossible(currentPlayerLocation, possibleMoves);
		boolean isUsersGo = PlayGame.isUsersGo();
		boolean isGameOver = PlayGame.isGameOver();
		if(isMovePossible && isUsersGo && !isGameOver) {
			PlayGame.setUsersGo(false);
			GridList gridList = PlayGame.getGridList();
			gridList.movePlayer(player, btnIndex);
			RenderButtons.mapButtonGrid();
			PlayGame.computersGo();
		}
		
	}
	
	public void setTileBackground(ImageIcon img) {
		setIcon(img);
	}
	
}
