package swSpaceships;

import javax.swing.ImageIcon;

import swInterfaces.NewShip;

public class BattleStar extends Spaceship implements NewShip {
	
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
