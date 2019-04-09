package swUserInterface;

import java.util.ArrayList;

import swGameData.GridList;
import swGameData.TileList;
import swGameLogic.PlayGame;
import swSpaceships.BattleCruiser;
import swSpaceships.BattleShooter;
import swSpaceships.BattleStar;
import swSpaceships.MasterShip;
import swSpaceships.Spaceship;

public class RenderButtons {
	
	public static void mapButtonGrid() {
		ArrayList<GameButton> buttonList = MainGui.getButtonList();
		GridList gridList = PlayGame.getGridList();
		ArrayList<Spaceship> list;
		Spaceship player = PlayGame.getPlayer();
		
		for(int i = 0; i < buttonList.size(); i++) {
			list = gridList.getGridList().get(i).getTileList();
			if(!list.isEmpty()) {
				if(checkForInstanceOfPlayer(list)) {
					buttonList.get(i).setBackgroundMasterShip();
				}
				else if(checkForInstanceOfBattleCruiser(list)) {
					buttonList.get(i).setBackgroundBattleCruiser();
				}
				else if(checkForInstanceOfBattleStar(list)) {
					buttonList.get(i).setBackgroundBattleStar();
				}
				else if(checkForInstanceOfBattleShooter(list)) {
					buttonList.get(i).setBackgroundBattleShooter();
				}
			}
			else {
				buttonList.get(i).setTileBackground(null);
			}
		}
	}
	
	public static boolean checkForInstanceOfPlayer(ArrayList<Spaceship> list) {
		 for (Spaceship s : list) {
		        if (s instanceof MasterShip) {
		            return true;
		        }
		    }
		    return false;
	}
	
	public static boolean checkForInstanceOfBattleStar(ArrayList<Spaceship> list) {
		 for (Spaceship s : list) {
		        if (s instanceof BattleStar) {
		            return true;
		        }
		    }
		    return false;
	}
	public static boolean checkForInstanceOfBattleShooter(ArrayList<Spaceship> list) {
		 for (Spaceship s : list) {
		        if (s instanceof BattleShooter) {
		            return true;
		        }
		    }
		    return false;
	}
	public static boolean checkForInstanceOfBattleCruiser(ArrayList<Spaceship> list) {
		 for (Spaceship s : list) {
		        if (s instanceof BattleCruiser) {
		            return true;
		        }
		    }
		    return false;
	}
	
	public static void resetGrid() {
		ArrayList<GameButton> buttonList = MainGui.getButtonList();
		
		for(int i = 0; i < buttonList.size(); i++) {
			buttonList.get(i).setBackgroundNull();
		}
	}
	
}
