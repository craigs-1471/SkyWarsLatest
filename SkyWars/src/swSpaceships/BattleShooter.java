package swSpaceships;

import javax.swing.ImageIcon;

import swInterfaces.NewShip;

public class BattleShooter extends Spaceship implements NewShip {
	
	public BattleShooter() {
		addNewShipType();
	}
	
	@Override
	public void addNewShipType() {
		setShipType("Battle Shooter");
		setImg(new ImageIcon(this.getClass().getResource("/swResources/BattleShooter100.png")));
	}

}
