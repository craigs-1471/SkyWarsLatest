package swSpaceships;

import javax.swing.ImageIcon;

import swInterfaces.NewShip;

public class BattleCruiser extends Spaceship implements NewShip {
	
	public BattleCruiser() {
		addNewShipType();
	}
	
	@Override
	public void addNewShipType() {
		setShipType("Battle Cruiser");
		setImg(new ImageIcon(this.getClass().getResource("/swResources/BattleCruiser100.png")));
	}
	
}
