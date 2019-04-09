package swUserInterface;

import java.awt.Color;
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
		setBackground(Color.black);
		btnIndex = numberOfGameButtons++;
		masterShip = new ImageIcon(this.getClass().getResource("/swResources/masterShip100.png"));
		battleStar = new ImageIcon(this.getClass().getResource("/swResources/battleStar100.png"));
		battleShooter = new ImageIcon(this.getClass().getResource("/swResources/battleShooter100.png"));
		battleCruiser = new ImageIcon(this.getClass().getResource("/swResources/battleCruiser100.png"));
		this.possibleMoves = PossibleGridMovements.getPossibleMoves(btnIndex);
		addActionListener(this);
		setFocusPainted(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Spaceship player = PlayGame.getPlayer();
		int currentPlayerLocation = player.getCurrentLocation();
		boolean isMovePossible = PossibleGridMovements.isMovePossible(currentPlayerLocation, possibleMoves);
		boolean isUsersGo = PlayGame.isUsersGo();
		boolean isGameOver = PlayGame.isGameOver();
		if(isMovePossible && isUsersGo && !isGameOver) {
			PlayGame.goTaken();
			PlayGame.setUsersGo(false);
			GridList gridList = PlayGame.getGridList();
			gridList.movePlayer(player, btnIndex);
			gridList.checkForEngagement(player);
			RenderButtons.mapButtonGrid();
			PlayGame.computersGo();
		}
		
	}
	
	public void setTileBackground(ImageIcon img) {
		setIcon(img);
	}
	public void setBackgroundMasterShip() {
		setIcon(masterShip);
	}
	public void setBackgroundBattleStar() {
		setIcon(battleStar);
	}
	public void setBackgroundBattleCruiser() {
		setIcon(battleCruiser);
	}
	public void setBackgroundBattleShooter() {
		setIcon(battleShooter);
	}
	public void setBackgroundNull() {
		setIcon(null);
	}
	
}
