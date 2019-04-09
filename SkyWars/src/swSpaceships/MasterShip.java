package swSpaceships;

import java.io.Serializable;

import javax.swing.ImageIcon;

import swInterfaces.NewShip;;

public class MasterShip extends Spaceship implements NewShip, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MasterShip() {
		addNewShipType();
		setEnemy(false);
	}
	
	@Override
	public void addNewShipType() {
		setShipType("Master Ship");
		setImg(new ImageIcon(this.getClass().getResource("/swResources/masterShip100.png")));
	}
	
}
