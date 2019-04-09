package swUserInterface;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import swGameData.DataHandling;
import swGameData.GridList;
import swGameLogic.PlayGame;

public class MainGui {

	private JFrame frmSkyWars;
	private static ArrayList<GameButton> buttonList;
	/*
	private static GameButton btnGameButton0;
	private static GameButton btnGameButton1;
	private static GameButton btnGameButton2;
	private static GameButton btnGameButton3;
	private static GameButton btnGameButton4;
	private static GameButton btnGameButton5;
	private static GameButton btnGameButton6;
	private static GameButton btnGameButton7;
	private static GameButton btnGameButton8;
	private static GameButton btnGameButton9;
	private static GameButton btnGameButton10;
	private static GameButton btnGameButton11;
	private static GameButton btnGameButton12;
	private static GameButton btnGameButton13;
	private static GameButton btnGameButton14;
	private static GameButton btnGameButton15;
	*/
	private static JButton btnNewGame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblDifficulty;
	private static JRadioButton rdbtnHardMode;
	private static JRadioButton rdbtnEasyMode;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private static JRadioButton rdbtnOffensive;
	private static JRadioButton rdbtnDefensive;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui window = new MainGui();
					window.frmSkyWars.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSkyWars = new JFrame();
		frmSkyWars.setTitle("Sky Wars");
		frmSkyWars.setBounds(100, 100, 689, 552);
		frmSkyWars.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSkyWars.getContentPane().setLayout(null);
		
		JPanel pnlButtonPanel = new JPanel();
		pnlButtonPanel.setBounds(12, 13, 647, 375);
		frmSkyWars.getContentPane().add(pnlButtonPanel);
		pnlButtonPanel.setLayout(new GridLayout(4, 4, 0, 0));

		int gridLength = GridList.getGridLength();
		buttonList = new ArrayList<GameButton>(gridLength);
		for(int i = 0; i < gridLength; i++) {
			buttonList.add(new GameButton());
		}
		for(int i = 0; i < gridLength; i++) {
			pnlButtonPanel.add(buttonList.get(i));
		}
		
		JPanel pnlOptionsPanel = new JPanel();
		pnlOptionsPanel.setBounds(12, 401, 647, 91);
		frmSkyWars.getContentPane().add(pnlOptionsPanel);
		pnlOptionsPanel.setLayout(null);
		
		btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayGame.playGame();
			}
		});
		btnNewGame.setBounds(12, 13, 97, 25);
		pnlOptionsPanel.add(btnNewGame);
		
		JLabel lblMasterShipMode = new JLabel("Master Ship Mode:");
		lblMasterShipMode.setBounds(456, 13, 112, 16);
		pnlOptionsPanel.add(lblMasterShipMode);
		
		JButton btnSaveGame = new JButton("Save Game");
		btnSaveGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataHandling.saveGame();
			}
		});
		btnSaveGame.setBounds(12, 53, 97, 25);
		pnlOptionsPanel.add(btnSaveGame);
		
		JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataHandling.loadGame();
			}
		});
		btnLoadGame.setBounds(122, 13, 97, 25);
		pnlOptionsPanel.add(btnLoadGame);
		
		rdbtnOffensive = new JRadioButton("Offensive");
		rdbtnOffensive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayGame.setMasterShipOffensive(true);
			}
		});
		buttonGroup.add(rdbtnOffensive);
		rdbtnOffensive.setBounds(456, 31, 127, 25);
		pnlOptionsPanel.add(rdbtnOffensive);
		
		rdbtnDefensive = new JRadioButton("Defensive");
		rdbtnDefensive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayGame.setMasterShipOffensive(false);
			}
		});
		rdbtnDefensive.setSelected(true);
		buttonGroup.add(rdbtnDefensive);
		rdbtnDefensive.setBounds(456, 53, 127, 25);
		pnlOptionsPanel.add(rdbtnDefensive);
		
		lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setBounds(304, 13, 77, 16);
		pnlOptionsPanel.add(lblDifficulty);
		
		rdbtnHardMode = new JRadioButton("Hard Mode");
		buttonGroup_1.add(rdbtnHardMode);
		rdbtnHardMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayGame.setHardMode(true);
			}
		});
		rdbtnHardMode.setBounds(304, 31, 127, 25);
		pnlOptionsPanel.add(rdbtnHardMode);
		
		rdbtnEasyMode = new JRadioButton("Easy Mode");
		buttonGroup_1.add(rdbtnEasyMode);
		rdbtnEasyMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayGame.setHardMode(false);
			}
		});
		rdbtnEasyMode.setSelected(true);
		rdbtnEasyMode.setBounds(304, 53, 127, 25);
		pnlOptionsPanel.add(rdbtnEasyMode);
	}

	public JFrame getFrmSkyWars() {
		return frmSkyWars;
	}

	public void setFrmSkyWars(JFrame frmSkyWars) {
		this.frmSkyWars = frmSkyWars;
	}

	public static ArrayList<GameButton> getButtonList() {
		return buttonList;
	}

	public static void setButtonList(ArrayList<GameButton> buttonList) {
		MainGui.buttonList = buttonList;
	}

	public static JButton getBtnNewGame() {
		return btnNewGame;
	}

	public static void setBtnNewGame(JButton btnNewGame) {
		MainGui.btnNewGame = btnNewGame;
	}

	public JLabel getLblDifficulty() {
		return lblDifficulty;
	}

	public void setLblDifficulty(JLabel lblDifficulty) {
		this.lblDifficulty = lblDifficulty;
	}

	public static JRadioButton getRdbtnHardMode() {
		return rdbtnHardMode;
	}

	public static void setRdbtnHardMode(JRadioButton rdbtnHardMode) {
		MainGui.rdbtnHardMode = rdbtnHardMode;
	}

	public static JRadioButton getRdbtnEasyMode() {
		return rdbtnEasyMode;
	}

	public static void setRdbtnEasyMode(JRadioButton rdbtnEasyMode) {
		MainGui.rdbtnEasyMode = rdbtnEasyMode;
	}

	public static JRadioButton getRdbtnOffensive() {
		return rdbtnOffensive;
	}

	public static void setRdbtnOffensive(JRadioButton rdbtnOffensive) {
		MainGui.rdbtnOffensive = rdbtnOffensive;
	}

	public static JRadioButton getRdbtnDefensive() {
		return rdbtnDefensive;
	}

	public static void setRdbtnDefensive(JRadioButton rdbtnDefensive) {
		MainGui.rdbtnDefensive = rdbtnDefensive;
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public ButtonGroup getButtonGroup_1() {
		return buttonGroup_1;
	}
}
