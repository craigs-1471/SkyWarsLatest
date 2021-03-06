package swSpaceships;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;

public abstract class Spaceship implements Observer, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String shipType;
	private ImageIcon img;
	private int currentLocation;
	private boolean isDestroyed;
	private boolean isEnemy;
	
	public Spaceship() {
		setDestroyed(false);
	}

	public void updateLocation(int currentLocation) {
		setCurrentLocation(currentLocation);
	}
	
	/////////////GETTERS AND SETTERS///////////////////////
	public String getShipType() {
		return shipType;
	}

	public void setShipType(String shipType) {
		this.shipType = shipType;
	}

	public int getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(int currentLocation) {
		this.currentLocation = currentLocation;
	}

	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}

	public boolean isDestroyed() {
		return isDestroyed;
	}

	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}
	
	public boolean isEnemy() {
		return isEnemy;
	}

	public void setEnemy(boolean isEnemy) {
		this.isEnemy = isEnemy;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
