package swSpaceships;

import java.io.Serializable;

import javax.swing.ImageIcon;

import swInterfaces.NewShip;

public class BattleCruiser extends Spaceship implements NewShip, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BattleCruiser() {
		addNewShipType();
		setEnemy(true);
	}
	
	@Override
	public void addNewShipType() {
		setShipType("Battle Cruiser");
		setImg(new ImageIcon(this.getClass().getResource("/swResources/BattleCruiser100.png")));
	}
	
}
