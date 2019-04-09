package swInterfaces;

import swSpaceships.Spaceship;

public interface Observable {
	
	public void moveSpaceship(Spaceship ship);
	public void addSpaceship();
	public void moveAllSpaceships();
	public void addPlayer(Spaceship player);
	public void movePlayer(Spaceship player, int btnIndex);
	
}
