package swSpaceships;

import java.io.Serializable;

import javax.swing.ImageIcon;

import swInterfaces.NewShip;

public class BattleShooter extends Spaceship implements NewShip, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BattleShooter() {
		addNewShipType();
		setEnemy(true);
	}
	
	@Override
	public void addNewShipType() {
		setShipType("Battle Shooter");
		setImg(new ImageIcon(this.getClass().getResource("/swResources/BattleShooter100.png")));
	}

}
