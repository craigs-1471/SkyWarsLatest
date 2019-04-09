package swSpaceships;

import java.io.Serializable;

import javax.swing.ImageIcon;

import swInterfaces.NewShip;

public class BattleStar extends Spaceship implements NewShip, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BattleStar() {
		addNewShipType();
		setEnemy(true);
	}
	
	@Override
	public void addNewShipType() {
		setShipType("Battle Star");
		setImg(new ImageIcon(this.getClass().getResource("/swResources/BattleStar100.png")));
	}

}
