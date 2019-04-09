package swSpaceships;

import javax.swing.ImageIcon;

import swInterfaces.NewShip;;

public class MasterShip extends Spaceship implements NewShip {
	
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
