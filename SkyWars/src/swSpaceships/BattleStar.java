package swSpaceships;

import javax.swing.ImageIcon;

import swInterfaces.NewShip;

public class BattleStar extends Spaceship implements NewShip {

	@Override
	public void addNewShipType() {
		setShipType("MasterShip");
		setImg(new ImageIcon(this.getClass().getResource("/swResources/MasterShip100.png")));
	}

}
