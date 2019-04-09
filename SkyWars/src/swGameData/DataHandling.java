package swGameData;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import swGameLogic.PlayGame;
import swSpaceships.Spaceship;

public class DataHandling {
	
	public static void saveGame() {
		Spaceship player = PlayGame.getPlayer();
		ArrayList<Spaceship> enemies = PlayGame.getGridList().getEnemies();
		int shipsDestroyed = PlayGame.getShipsDestroyed();
		int goesTaken = PlayGame.getGoesTaken();
		boolean masterShipOffensive = PlayGame.isMasterShipOffensive();
		boolean hardMode = PlayGame.isHardMode();
		String usersName = PlayGame.getUsersName();
		SaveData save = new SaveData(player, enemies, shipsDestroyed, goesTaken, masterShipOffensive, hardMode, usersName);
		writeGameToFile(save);
	}
	
	public static void writeGameToFile(SaveData save) {
		String fileName = "data.bin";
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
			os.writeObject(save);
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done writing file");
	}
	
	public static void loadGame() {
		
	}
	
}
