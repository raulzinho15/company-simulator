package application;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.*;
import java.net.URL;
import java.text.*;
import java.util.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javafx.concurrent.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.*;

public class MainController implements Initializable {
	
	private Scene scene;
	
	private long[] achievement;
	
	private int lastMusic;

	private boolean newHotkey1 = false;
	private boolean newHotkey2 = false;
	private boolean newHotkey3 = false;
	private boolean newHotkey4 = false;
	private boolean newHotkey5 = false;
	private boolean newHotkey6 = false;
	private boolean newHotkey7 = false;
	private boolean newHotkey8 = false;
	private boolean newHotkey9 = false;
	private boolean newHotkey10 = false;
	private boolean newHotkey11 = false;
	private boolean newHotkey12 = false;
	private boolean newHotkey13 = false;
	private boolean newHotkey14 = false;
	private boolean newHotkey15 = false;
	private boolean newHotkey16 = false;

	private boolean music = true;
	private boolean musicPlaying = false;
	
	@FXML private ImageView imgCompetitorResource;

	@FXML private Label lblCompetitorCompany;
	@FXML private Label lblCompetitorName;
	@FXML private Label lblCompetitorPrice;
	@FXML private Label lblCompetitorAmount;
	
	@FXML private Label refreshTime;

	@FXML private ImageView imgHotkey1;
	@FXML private ImageView imgHotkey2;
	@FXML private ImageView imgHotkey3;
	@FXML private ImageView imgHotkey4;
	@FXML private ImageView imgHotkey5;
	@FXML private ImageView imgHotkey6;
	@FXML private ImageView imgHotkey7;
	@FXML private ImageView imgHotkey8;
	@FXML private ImageView imgHotkey9;
	@FXML private ImageView imgHotkey10;
	@FXML private ImageView imgHotkey11;
	@FXML private ImageView imgHotkey12;
	@FXML private ImageView imgHotkey13;
	@FXML private ImageView imgHotkey14;
	@FXML private ImageView imgHotkey15;
	@FXML private ImageView imgHotkey16;
	
	@FXML private Label hotkeyName1;
	@FXML private Label hotkeyName2;
	@FXML private Label hotkeyName3;
	@FXML private Label hotkeyName4;
	@FXML private Label hotkeyName5;
	@FXML private Label hotkeyName6;
	@FXML private Label hotkeyName7;
	@FXML private Label hotkeyName8;
	@FXML private Label hotkeyName9;
	@FXML private Label hotkeyName10;
	@FXML private Label hotkeyName11;
	@FXML private Label hotkeyName12;
	@FXML private Label hotkeyName13;
	@FXML private Label hotkeyName14;
	@FXML private Label hotkeyName15;
	@FXML private Label hotkeyName16;
	
	@FXML private Label hotkeyAction1;
	@FXML private Label hotkeyAction2;
	@FXML private Label hotkeyAction3;
	@FXML private Label hotkeyAction4;
	@FXML private Label hotkeyAction5;
	@FXML private Label hotkeyAction6;
	@FXML private Label hotkeyAction7;
	@FXML private Label hotkeyAction8;
	@FXML private Label hotkeyAction9;
	@FXML private Label hotkeyAction10;
	@FXML private Label hotkeyAction11;
	@FXML private Label hotkeyAction12;
	@FXML private Label hotkeyAction13;
	@FXML private Label hotkeyAction14;
	@FXML private Label hotkeyAction15;
	@FXML private Label hotkeyAction16;
	
	@FXML private Label lblAchievement1;
	@FXML private Label lblAchievement2;
	@FXML private Label lblAchievement3;
	
	@FXML private Label achievementDesc1;
	@FXML private Label achievementDesc2;
	@FXML private Label achievementDesc3;
	
	@FXML private ImageView medalAchievement1;
	@FXML private ImageView medalAchievement2;
	@FXML private ImageView medalAchievement3;
	
	private BufferedReader br;
	
	private PrintWriter pw;
	
	private StringBuilder sb;

	private String username;
	private String resolution;
	private String currentDate;
	private String lastVersion;
	private String currentVersion = "1.3";

	private String moneyRate;
	
	private KeyCode buyKey1;
	private KeyCode buyKey2;
	private KeyCode sellKey1;
	private KeyCode sellKey2;
	private KeyCode goToNext;
	private KeyCode goToPrev;
	private KeyCode goToFirst;
	private KeyCode goToLast;
	private KeyCode openStorage;
	private KeyCode openAchievement;
	private KeyCode openCompetitor;
	private KeyCode openOptions;
	private KeyCode increasePrice;
	private KeyCode decreasePrice;
	private KeyCode increaseMultiplier;
	private KeyCode decreaseMultiplier;

	private boolean inOptions = false;
	private boolean inStorage = false;
	private boolean inAchievement = false;
	private boolean inAchievementSelect = false;
	private boolean inCompetitor = false;
	
	private static long a = 1;
	private long currentPage = 1;
	private long currentResource = 1;
	private long storagePage = 1;
	private long optionsPage = 1;
	private long achievementPage = 1;

	private long competitorTime;
	private long competitorWhole;
	private double competitorDecimal;
	private double competitorPrice;
	private String competitorResource;
	private String competitorCompany;
	
	private long rank;
	private long moneyWhole;
	private double moneyDecimal;

	private long foodWhole;
	private double foodDecimal;
	private long rancher;

	private long fishWhole;
	private double fishDecimal;
	private long fisher;
	private long fishMerchant;
	private double fishPrice;

	private long steakWhole;
	private double steakDecimal;
	private long cowRancher;
	private long steakMerchant;
	private double steakPrice;

	private long porkWhole;
	private double porkDecimal;
	private long pigRancher;
	private long porkMerchant;
	private double porkPrice;

	private long chickenWhole;
	private double chickenDecimal;
	private long chickenRancher;
	private long chickenMerchant;
	private double chickenPrice;

	private long muttonWhole;
	private double muttonDecimal;
	private long sheepRancher;
	private long muttonMerchant;
	private double muttonPrice;

	private long stoneWhole;
	private double stoneDecimal;
	private long miner;

	private long coalWhole;
	private double coalDecimal;
	private long coalMiner;
	private long coalMerchant;
	private double coalPrice;

	private long woodWhole;
	private double woodDecimal;
	private long lumberjack;

	private long plankWhole;
	private double plankDecimal;
	private long woodCutter;
	private long plankMerchant;
	private double plankPrice;

	private long cropWhole;
	private double cropDecimal;
	private long farmer;

	private long cottonWhole;
	private double cottonDecimal;
	private long cottonFarmer;
	private long cottonMerchant;
	private double cottonPrice;

	private long timeElapsed;
	private long startingTime;
	
	private int multi = 1;
	
	private double longestRefresh;
	
	@FXML private AnchorPane anchor;
	@FXML private ImageView companyBackground;
	
	@FXML private Label keyName1;
	@FXML private Label keyName2;
	@FXML private Label keyName3;
	@FXML private Label keyName4;
	
	@FXML private ImageView key1;
	@FXML private ImageView key2;
	@FXML private ImageView key3;
	@FXML private ImageView key4;
	
	@FXML private Label workerName1;
	@FXML private Label workerName2;
	@FXML private Label workerName3;
	@FXML private Label workerName4;
	
	@FXML private Label lblAmountChange1;
	@FXML private Label lblAmountChange2;
	@FXML private Label lblAmountChange3;
	@FXML private Label lblAmountChange4;
	
	@FXML private ImageView keyImage1;
	@FXML private ImageView keyImage2;
	@FXML private ImageView keyImage3;
	@FXML private ImageView keyImage4;
	
	@FXML private Label itemAmount;
	@FXML private Label itemName;

	@FXML private Label lblRank;
	@FXML private Label lblMoney;
	@FXML private Label lblMultiplier;
	@FXML private Label lblPrice;
	@FXML private Label lblVersion;
	
	@FXML private ImageView imgRank;
	
	@FXML private Label lblCost1;
	@FXML private Label lblCost2;
	@FXML private Label lblCost3;

	@FXML private ImageView costImage1;
	@FXML private ImageView costImage2;
	@FXML private ImageView costImage3;
	
	@FXML private Label lblItem1;
	@FXML private Label lblItem2;
	@FXML private Label lblItem3;

	@FXML private ImageView itemImage;
	
	@FXML private ImageView bTop;
	@FXML private ImageView bMiddle;
	@FXML private ImageView bBottom;
	
	@FXML private ImageView imgPopUp;
	@FXML private ImageView closePopUp;
	@FXML private ImageView goBackButton;
	@FXML private ImageView goBackIcon;
	@FXML private ImageView logoutButton;
	@FXML private ImageView storageButton;
	@FXML private ImageView storageIcon;
	@FXML private ImageView optionsButton;
	@FXML private ImageView optionsIcon;
	@FXML private ImageView achievementButton;
	@FXML private ImageView achievementIcon;
	@FXML private ImageView changelogButton;
	@FXML private ImageView changelogIcon;
	@FXML private ImageView consoleButton;
	@FXML private ImageView consoleIcon;
	@FXML private ImageView tutorialButton;
	@FXML private ImageView tutorialIcon;
	@FXML private ImageView musicButton;
	@FXML private ImageView keyButton;
	@FXML private ImageView keyIcon;
	@FXML private ImageView creditButton;
	@FXML private ImageView creditIcon;
	@FXML private ImageView competitorButton;
	@FXML private ImageView competitorIcon;

	@FXML private Label lblLogout;
	@FXML private Label lblPopUpTitle;
	@FXML private Label lblChangelog;
	@FXML private Label lblCredits;
	@FXML private Label storageTitle1;
	@FXML private Label storageTitle2;
	@FXML private Label storageResource1;
	@FXML private Label storageResource2;
	@FXML private Label storageResource3;
	@FXML private Label storageResource4;
	@FXML private Label storageResource5;
	@FXML private Label storageResource6;
	@FXML private Label storageResource7;
	@FXML private Label storageResource8;
	@FXML private Label storageWorker1;
	@FXML private Label storageWorker2;
	@FXML private Label storageWorker3;
	@FXML private Label storageWorker4;
	@FXML private Label storageWorker5;
	@FXML private Label storageWorker6;
	@FXML private Label storageWorker7;
	@FXML private Label storageWorker8;

	@FXML private ImageView imgResource1;
	@FXML private ImageView imgResource2;
	@FXML private ImageView imgResource3;
	@FXML private ImageView imgResource4;
	@FXML private ImageView imgResource5;
	@FXML private ImageView imgResource6;
	@FXML private ImageView imgResource7;
	@FXML private ImageView imgResource8;
	@FXML private ImageView imgWorker1;
	@FXML private ImageView imgWorker2;
	@FXML private ImageView imgWorker3;
	@FXML private ImageView imgWorker4;
	@FXML private ImageView imgWorker5;
	@FXML private ImageView imgWorker6;
	@FXML private ImageView imgWorker7;
	@FXML private ImageView imgWorker8;
    
    private AudioInputStream audioInputStream;
    private Clip clip;
	
	private NumberFormat formatter;
	
	private Random rand = new Random();
	
	private Service<Void> backgroundThread;

	private long whole;
	private double decimal;

	private long longvar;

	private boolean log = false;
	private boolean firstTime = true;
	
	public void log(String line) {
		try {
		pw = new PrintWriter(new FileWriter("stats/log.stat",true));
		pw.println(new TextEncryptor(line).encrypt());
		pw.close();
		} catch (Exception e) {}
	}
	
	public void hoverWorker(MouseEvent event) {
		if (inAchievementSelect) {
			scene.setCursor(Cursor.HAND);
			log("Hovered over an Achievement Resource Icon.");
		}
	}
	
	public void hoverResource(MouseEvent event) {
		scene.setCursor(Cursor.HAND);
		if (inAchievementSelect) {
			log("Hovered over an Achievement Resource Icon.");
		} else log("Hovered over a Storage Resource Icon.");
	}
	
	public void releasedResource(MouseEvent event) {
		try {
			if (inStorage) {
				if (imgResource1.isHover()) {
					if (storagePage == 1) {
						currentPage = 1;
						changePage();
						closePopUp();
						log("Pressed the Storage Food Icon.");
					} else if (storagePage == 2 && rank >= 2) {
						if (rank == 2) currentPage = 3;
						changePage();
						closePopUp();
						log("Pressed the Storage Steak Icon.");
					}
				} else if (imgResource2.isHover()) {
					if (storagePage == 1) {
						currentPage = 2;
						changePage();
						closePopUp();
						log("Pressed the Storage Fish Icon.");
					} else if (storagePage == 2 && rank >= 2) {
						if (rank == 2) currentPage = 4;
						changePage();
						closePopUp();
						log("Pressed the Storage Pork Icon.");
					}
				} else if (imgResource3.isHover()) {
					if (storagePage == 1) {
						if (rank == 1) currentPage = 3;
						else if (rank == 2) currentPage = 7;
						changePage();
						closePopUp();
						log("Pressed the Storage Stone Icon.");
					} else if (storagePage == 2 && rank >= 2) {
						if (rank == 2) currentPage = 5;
						changePage();
						closePopUp();
						log("Pressed the Storage Chicken Icon.");
					}
				} else if (imgResource4.isHover()) {
					if (storagePage == 1) {
						if (rank == 1) currentPage = 4;
						else if (rank == 2) currentPage = 8;
						changePage();
						closePopUp();
						log("Pressed the Storage Coal Icon.");
					} else if (storagePage == 2 && rank >= 2) {
						if (rank == 2) currentPage = 6;
						changePage();
						closePopUp();
						log("Pressed the Storage Mutton Icon.");
					}
				} else if (imgResource5.isHover()) {
					if (storagePage == 1) {
						if (rank == 1) currentPage = 5;
						else if (rank == 2) currentPage = 9;
						changePage();
						closePopUp();
						log("Pressed the Storage Wood Icon.");
					}
				} else if (imgResource6.isHover()) {
					if (storagePage == 1) {
						if (rank == 1) currentPage = 6;
						else if (rank == 2) currentPage = 10;
						changePage();
						closePopUp();
						log("Pressed the Storage Planks Icon.");
					}
				} else if (imgResource7.isHover()) {
					if (storagePage == 1) {
						if (rank == 1) currentPage = 7;
						else if (rank == 2) currentPage = 11;
						changePage();
						closePopUp();
						log("Pressed the Storage Crops Icon.");
					}
				} else if (imgResource8.isHover()) {
					if (storagePage == 1) {
						if (rank == 1) currentPage = 8;
						else if (rank == 2) currentPage = 12;
						changePage();
						closePopUp();
						log("Pressed the Storage Cotton Icon.");
					}
				}
			} else if (inAchievementSelect) {
				if (imgResource1.isHover()) {
					if (achievementPage == 1) {
						currentResource = 1;
						log("Pressed the Achievements Food Icon.");
						achievementPage = 1;
						inAchievementSelect = false;
						inAchievement = true;
						changeAchievementPage();
					}
				} else if (imgResource2.isHover()) {
					if (achievementPage == 1) {
						currentResource = 2;
						log("Pressed the Achievements Fish Icon.");
						achievementPage = 1;
						inAchievementSelect = false;
						inAchievement = true;
						changeAchievementPage();
					}
				} else if (imgResource3.isHover()) {
					if (achievementPage == 1) {
						currentResource = 3;
						log("Pressed the Achievements Stone Icon.");
						achievementPage = 1;
						inAchievementSelect = false;
						inAchievement = true;
						changeAchievementPage();
					}
				} else if (imgResource4.isHover()) {
					if (achievementPage == 1) {
						currentResource = 4;
						log("Pressed the Achievements Coal Icon.");
						achievementPage = 1;
						inAchievementSelect = false;
						inAchievement = true;
						changeAchievementPage();
					}
				} else if (imgResource5.isHover()) {
					if (achievementPage == 1) {
						currentResource = 5;
						log("Pressed the Achievements Wood Icon.");
						achievementPage = 1;
						inAchievementSelect = false;
						inAchievement = true;
						changeAchievementPage();
					}
				} else if (imgResource6.isHover()) {
					if (achievementPage == 1) {
						currentResource = 6;
						log("Pressed the Achievements Planks Icon.");
						achievementPage = 1;
						inAchievementSelect = false;
						inAchievement = true;
						changeAchievementPage();
					}
				} else if (imgResource7.isHover()) {
					if (achievementPage == 1) {
						currentResource = 7;
						log("Pressed the Achievements Crops Icon.");
						achievementPage = 1;
						inAchievementSelect = false;
						inAchievement = true;
						changeAchievementPage();
					}
				} else if (imgResource8.isHover()) {
					if (achievementPage == 1) {
						currentResource = 8;
						log("Pressed the Achievements Cotton Icon.");
						achievementPage = 1;
						inAchievementSelect = false;
						inAchievement = true;
						changeAchievementPage();
					}
				} else if (imgWorker1.isHover()) {
					if (achievementPage == 1) {
						if (rank == 1) {
							currentResource = 0;
							log("Pressed the Achievements Rank Up Icon.");
							achievementPage = 1;
							inAchievementSelect = false;
							inAchievement = true;
							changeAchievementPage();
						} else {
							currentResource = 9;
							log("Pressed the Achievements Steak Icon.");
							achievementPage = 1;
							inAchievementSelect = false;
							inAchievement = true;
							changeAchievementPage();
						}
					}
				} else if (imgWorker2.isHover()) {
					if (achievementPage == 1) {
						if (rank != 1) {
							currentResource = 10;
							log("Pressed the Achievements Pork Icon.");
							achievementPage = 1;
							inAchievementSelect = false;
							inAchievement = true;
							changeAchievementPage();
						}
					}
				} else if (imgWorker3.isHover()) {
					if (achievementPage == 1) {
						if (rank != 1) {
							currentResource = 11;
							log("Pressed the Achievements Chicken Icon.");
							achievementPage = 1;
							inAchievementSelect = false;
							inAchievement = true;
							changeAchievementPage();
						}
					}
				} else if (imgWorker4.isHover()) {
					if (achievementPage == 1) {
						if (rank != 1) {
							currentResource = 12;
							log("Pressed the Achievements Mutton Icon.");
							achievementPage = 1;
							inAchievementSelect = false;
							inAchievement = true;
							changeAchievementPage();
						}
					}
				} else if (imgWorker5.isHover()) {
					if (achievementPage == 1) {
						if (rank == 2) {
							currentResource = 0;
							log("Pressed the Achievements Rank Up Icon.");
							achievementPage = 1;
							inAchievementSelect = false;
							inAchievement = true;
							changeAchievementPage();
						} else {
							log("Pressed the Achievements  Icon.");
						}
					}
				} else if (imgWorker6.isHover()) {
					if (achievementPage == 1) {
						currentResource = 14;
						log("Pressed the Achievements  Icon.");
					}
				} else if (imgWorker7.isHover()) {
					if (achievementPage == 1) {
						currentResource = 15;
						log("Pressed the Achievements  Icon.");
					}
				} else if (imgWorker8.isHover()) {
					if (achievementPage == 1) {
						currentResource = 16;
						log("Pressed the Achievements  Icon.");
					}
				}
			}
		} catch (Exception e) {}
	}
	
	public void exitResource(MouseEvent event) {
		scene.setCursor(Cursor.DEFAULT);
		if (inAchievementSelect) {
			log("Exited an Achievement Resource Icon.");
		} else log("Exited a Storage Resource Icon.");
	}
	
	public void exitWorker(MouseEvent event) {
		scene.setCursor(Cursor.DEFAULT);
		if (inAchievementSelect) {
			log("Exited an Achievement Worker Icon.");
		}
	}
	
	public KeyCode keyCode(String key) {
		if (key.equals("PAGE_UP")) {
			return KeyCode.PAGE_UP;
		} else if (key.equals("PAGE_DOWN")) {
			return KeyCode.PAGE_DOWN;
		} else if (key.equals("HOME")) {
			return KeyCode.HOME;
		} else if (key.equals("END")) {
			return KeyCode.END;
		} else if (key.equals("ESCAPE")) {
			return KeyCode.ESCAPE;
		} else if (key.equals("DIGIT1")) {
			return KeyCode.DIGIT1;
		} else if (key.equals("DIGIT2")) {
			return KeyCode.DIGIT2;
		} else if (key.equals("DIGIT3")) {
			return KeyCode.DIGIT3;
		} else if (key.equals("DIGIT4")) {
			return KeyCode.DIGIT4;
		} else if (key.equals("DIGIT5")) {
			return KeyCode.DIGIT5;
		} else if (key.equals("DIGIT6")) {
			return KeyCode.DIGIT6;
		} else if (key.equals("DIGIT7")) {
			return KeyCode.DIGIT7;
		} else if (key.equals("DIGIT8")) {
			return KeyCode.DIGIT8;
		} else if (key.equals("DIGIT9")) {
			return KeyCode.DIGIT9;
		} else if (key.equals("DIGIT0")) {
			return KeyCode.DIGIT0;
		} else if (key.equals("NUMPAD1")) {
			return KeyCode.NUMPAD1;
		} else if (key.equals("NUMPAD2")) {
			return KeyCode.NUMPAD2;
		} else if (key.equals("NUMPAD3")) {
			return KeyCode.NUMPAD3;
		} else if (key.equals("NUMPAD4")) {
			return KeyCode.NUMPAD4;
		} else if (key.equals("NUMPAD5")) {
			return KeyCode.NUMPAD5;
		} else if (key.equals("NUMPAD6")) {
			return KeyCode.NUMPAD6;
		} else if (key.equals("NUMPAD7")) {
			return KeyCode.NUMPAD7;
		} else if (key.equals("NUMPAD8")) {
			return KeyCode.NUMPAD8;
		} else if (key.equals("NUMPAD9")) {
			return KeyCode.NUMPAD9;
		} else if (key.equals("NUMPAD0")) {
			return KeyCode.NUMPAD0;
		} else if (key.equals("ALT")) {
			return KeyCode.ALT;
		} else if (key.equals("SEMICOLON")) {
			return KeyCode.SEMICOLON;
		} else if (key.equals("QUOTE")) {
			return KeyCode.QUOTE;
		} else if (key.equals("OPEN_BRACKET")) {
			return KeyCode.OPEN_BRACKET;
		} else if (key.equals("CLOSE_BRACKET")) {
			return KeyCode.CLOSE_BRACKET;
		} else if (key.equals("COMMA")) {
			return KeyCode.COMMA;
		} else if (key.equals("PERIOD")) {
			return KeyCode.PERIOD;
		} else if (key.equals("SLASH")) {
			return KeyCode.SLASH;
		} else if (key.equals("BACK_SLASH")) {
			return KeyCode.BACK_SLASH;
		} else if (key.equals("MINUS")) {
			return KeyCode.MINUS;
		} else if (key.equals("EQUALS")) {
			return KeyCode.EQUALS;
		} else {
			return KeyCode.getKeyCode(key);
		}
	}
	
	public String hotkey(KeyCode code) {
		if (code == KeyCode.PAGE_UP) {
			return "PG UP";
		} else if (code == KeyCode.PAGE_DOWN) {
			return "PG DN";
		} else if (code == KeyCode.ESCAPE) {
			return "ESC";
		} else if (code == KeyCode.DIGIT1) {
			return "1";
		} else if (code == KeyCode.DIGIT2) {
			return "2";
		} else if (code == KeyCode.DIGIT3) {
			return "3";
		} else if (code == KeyCode.DIGIT4) {
			return "4";
		} else if (code == KeyCode.DIGIT5) {
			return "5";
		} else if (code == KeyCode.DIGIT6) {
			return "6";
		} else if (code == KeyCode.DIGIT7) {
			return "7";
		} else if (code == KeyCode.DIGIT8) {
			return "8";
		} else if (code == KeyCode.DIGIT9) {
			return "9";
		} else if (code == KeyCode.DIGIT0) {
			return "0";
		} else if (code == KeyCode.NUMPAD1) {
			return "PAD 1";
		} else if (code == KeyCode.NUMPAD2) {
			return "PAD 2";
		} else if (code == KeyCode.NUMPAD3) {
			return "PAD 3";
		} else if (code == KeyCode.NUMPAD4) {
			return "PAD 4";
		} else if (code == KeyCode.NUMPAD5) {
			return "PAD 5";
		} else if (code == KeyCode.NUMPAD6) {
			return "PAD 6";
		} else if (code == KeyCode.NUMPAD7) {
			return "PAD 7";
		} else if (code == KeyCode.NUMPAD8) {
			return "PAD 8";
		} else if (code == KeyCode.NUMPAD9) {
			return "PAD 9";
		} else if (code == KeyCode.NUMPAD0) {
			return "PAD 0";
		} else if (code == KeyCode.SEMICOLON) {
			return ";";
		} else if (code == KeyCode.QUOTE) {
			return "'";
		} else if (code == KeyCode.OPEN_BRACKET) {
			return "[";
		} else if (code == KeyCode.CLOSE_BRACKET) {
			return "]";
		} else if (code == KeyCode.COMMA) {
			return ",";
		} else if (code == KeyCode.PERIOD) {
			return ".";
		} else if (code == KeyCode.SLASH) {
			return "/";
		} else if (code == KeyCode.BACK_SLASH) {
			return "\\";
		} else if (code == KeyCode.MINUS) {
			return "-";
		} else if (code == KeyCode.EQUALS) {
			return "=";
		} else {
			return code.toString();
		}
	}
	
	public void hoverHotkey(MouseEvent event) {
		scene.setCursor(Cursor.HAND);
		log("Hovered over a Hotkey Icon.");
	}
	
	public void pressedHotkey(MouseEvent event) {
		try {
		if (hotkeyName1.isHover() && !newHotkey2 && !newHotkey3 && !newHotkey4 && !newHotkey5 && !newHotkey6 && !newHotkey7 && !newHotkey8 && !newHotkey9 && !newHotkey10 && !newHotkey11 && !newHotkey12 && !newHotkey13 && !newHotkey14 && !newHotkey15 && !newHotkey16) {
			hotkeyName1.setText("?");
			newHotkey1 = true;
			log("Pressed the Buy Worker Key 1 Hotkey Icon.");
		} else if (hotkeyName2.isHover() && !newHotkey1 && !newHotkey3 && !newHotkey4 && !newHotkey5 && !newHotkey6 && !newHotkey7 && !newHotkey8 && !newHotkey9 && !newHotkey10 && !newHotkey11 && !newHotkey12 && !newHotkey13 && !newHotkey14 && !newHotkey15 && !newHotkey16) {
			hotkeyName2.setText("?");
			newHotkey2 = true;
			log("Pressed the Buy Worker Key 2 Hotkey Icon.");
		} else if (hotkeyName3.isHover() && !newHotkey1 && !newHotkey2 && !newHotkey4 && !newHotkey5 && !newHotkey6 && !newHotkey7 && !newHotkey8 && !newHotkey9 && !newHotkey10 && !newHotkey11 && !newHotkey12 && !newHotkey13 && !newHotkey14 && !newHotkey15 && !newHotkey16) {
			hotkeyName3.setText("?");
			newHotkey3 = true;
			log("Pressed the Sell Worker Key 1 Hotkey Icon.");
		} else if (hotkeyName4.isHover() && !newHotkey1 && !newHotkey2 && !newHotkey3 && !newHotkey5 && !newHotkey6 && !newHotkey7 && !newHotkey8 && !newHotkey9 && !newHotkey10 && !newHotkey11 && !newHotkey12 && !newHotkey13 && !newHotkey14 && !newHotkey15 && !newHotkey16) {
			hotkeyName4.setText("?");
			newHotkey4 = true;
			log("Pressed the Sell Worker Key 2 Hotkey Icon.");
		} else if (hotkeyName5.isHover() && !newHotkey1 && !newHotkey2 && !newHotkey3 && !newHotkey4 && !newHotkey6 && !newHotkey7 && !newHotkey8 && !newHotkey9 && !newHotkey10 && !newHotkey11 && !newHotkey12 && !newHotkey13 && !newHotkey14 && !newHotkey15 && !newHotkey16) {
			hotkeyName5.setText("?");
			newHotkey5 = true;
			log("Pressed the Go To Next Hotkey Icon.");
		} else if (hotkeyName6.isHover() && !newHotkey1 && !newHotkey2 && !newHotkey3 && !newHotkey4 && !newHotkey5 && !newHotkey7 && !newHotkey8 && !newHotkey9 && !newHotkey10 && !newHotkey11 && !newHotkey12 && !newHotkey13 && !newHotkey14 && !newHotkey15 && !newHotkey16) {
			hotkeyName6.setText("?");
			newHotkey6 = true;
			log("Pressed the Go To Previous Hotkey Icon.");
		} else if (hotkeyName7.isHover() && !newHotkey1 && !newHotkey2 && !newHotkey3 && !newHotkey4 && !newHotkey5 && !newHotkey6 && !newHotkey8 && !newHotkey9 && !newHotkey10 && !newHotkey11 && !newHotkey12 && !newHotkey13 && !newHotkey14 && !newHotkey15 && !newHotkey16) {
			hotkeyName7.setText("?");
			newHotkey7 = true;
			log("Pressed the Go To First Page Hotkey Icon.");
		} else if (hotkeyName8.isHover() && !newHotkey1 && !newHotkey2 && !newHotkey3 && !newHotkey4 && !newHotkey5 && !newHotkey6 && !newHotkey7 && !newHotkey9 && !newHotkey10 && !newHotkey11 && !newHotkey12 && !newHotkey13 && !newHotkey14 && !newHotkey15 && !newHotkey16) {
			hotkeyName8.setText("?");
			newHotkey8 = true;
			log("Pressed the Go To Last Page Hotkey Icon.");
		} else if (hotkeyName9.isHover() && !newHotkey1 && !newHotkey2 && !newHotkey3 && !newHotkey4 && !newHotkey5 && !newHotkey6 && !newHotkey7 && !newHotkey8 && !newHotkey10 && !newHotkey11 && !newHotkey12 && !newHotkey13 && !newHotkey14 && !newHotkey15 && !newHotkey16) {
			hotkeyName9.setText("?");
			newHotkey9 = true;
			log("Pressed the Open Storage Hotkey Icon.");
		} else if (hotkeyName10.isHover() && !newHotkey1 && !newHotkey2 && !newHotkey3 && !newHotkey4 && !newHotkey5 && !newHotkey6 && !newHotkey7 && !newHotkey8 && !newHotkey9 && !newHotkey11 && !newHotkey12 && !newHotkey13 && !newHotkey14 && !newHotkey15 && !newHotkey16) {
			hotkeyName10.setText("?");
			newHotkey10 = true;
			log("Pressed the Open Achievements Hotkey Icon.");
		} else if (hotkeyName11.isHover() && !newHotkey1 && !newHotkey2 && !newHotkey3 && !newHotkey4 && !newHotkey5 && !newHotkey6 && !newHotkey7 && !newHotkey8 && !newHotkey9 && !newHotkey10 && !newHotkey12 && !newHotkey13 && !newHotkey14 && !newHotkey15 && !newHotkey16) {
			hotkeyName11.setText("?");
			newHotkey11 = true;
			log("Pressed the Open Competitor Hotkey Icon.");
		} else if (hotkeyName12.isHover() && !newHotkey1 && !newHotkey2 && !newHotkey3 && !newHotkey4 && !newHotkey5 && !newHotkey6 && !newHotkey7 && !newHotkey8 && !newHotkey9 && !newHotkey10 && !newHotkey11 && !newHotkey13 && !newHotkey14 && !newHotkey15 && !newHotkey16) {
			hotkeyName12.setText("?");
			newHotkey12 = true;
			log("Pressed the Open Options Hotkey Icon.");
		} else if (hotkeyName13.isHover() && !newHotkey1 && !newHotkey2 && !newHotkey3 && !newHotkey4 && !newHotkey5 && !newHotkey6 && !newHotkey7 && !newHotkey8 && !newHotkey9 && !newHotkey10 && !newHotkey11 && !newHotkey12 && !newHotkey14 && !newHotkey15 && !newHotkey16) {
			hotkeyName13.setText("?");
			newHotkey13 = true;
			log("Pressed the Increase Price Hotkey Icon.");
		} else if (hotkeyName14.isHover() && !newHotkey1 && !newHotkey2 && !newHotkey3 && !newHotkey4 && !newHotkey5 && !newHotkey6 && !newHotkey7 && !newHotkey8 && !newHotkey9 && !newHotkey10 && !newHotkey11 && !newHotkey12 && !newHotkey13 && !newHotkey15 && !newHotkey16) {
			hotkeyName14.setText("?");
			newHotkey14 = true;
			log("Pressed the Decrease Price Hotkey Icon.");
		} else if (hotkeyName15.isHover() && !newHotkey1 && !newHotkey2 && !newHotkey3 && !newHotkey4 && !newHotkey5 && !newHotkey6 && !newHotkey7 && !newHotkey8 && !newHotkey9 && !newHotkey10 && !newHotkey11 && !newHotkey12 && !newHotkey13 && !newHotkey14 && !newHotkey16) {
			hotkeyName15.setText("?");
			newHotkey15 = true;
			log("Pressed the Increase Multiplier Hotkey Icon.");
		} else if (hotkeyName16.isHover() && !newHotkey1 && !newHotkey2 && !newHotkey3 && !newHotkey4 && !newHotkey5 && !newHotkey6 && !newHotkey7 && !newHotkey8 && !newHotkey9 && !newHotkey10 && !newHotkey11 && !newHotkey12 && !newHotkey13 && !newHotkey14 && !newHotkey15) {
			hotkeyName16.setText("?");
			newHotkey16 = true;
			log("Pressed the Decrease Multiplier Hotkey Icon.");
		}
		} catch (Exception e) {}
	}
	
	public void exitHotkey(MouseEvent event) {
		try {
			scene.setCursor(Cursor.DEFAULT);
			log("Exited a Hotkey Icon.");
		} catch (Exception e) {}
	}
	
	public void changePage() {
		try {
			checkPage();
			if (currentPage == 1) {
				keyName1.setVisible(true);
				keyName2.setVisible(true);
				keyName3.setVisible(false);
				keyName4.setVisible(false);
				keyImage1.setVisible(true);
				keyImage2.setVisible(true);
				keyImage3.setVisible(false);
				keyImage4.setVisible(false);
				key1.setVisible(true);
				key2.setVisible(true);
				key3.setVisible(false);
				key4.setVisible(false);
				workerName1.setVisible(true);
				workerName2.setVisible(true);
				workerName3.setVisible(false);
				workerName4.setVisible(false);
				lblAmountChange1.setVisible(true);
				lblAmountChange2.setVisible(true);
				lblAmountChange3.setVisible(false);
				lblAmountChange4.setVisible(false);
				lblItem1.setVisible(true);
				lblItem2.setVisible(false);
				lblItem3.setVisible(false);
				lblCost1.setVisible(true);
				lblCost2.setVisible(false);
				lblCost3.setVisible(false);
				lblPrice.setVisible(false);
				costImage1.setVisible(true);
				costImage2.setVisible(false);
				costImage3.setVisible(false);
				
				itemName.setText("FOOD");
				itemImage.setImage(new Image("img/resources/food/food.png"));
				
				keyImage1.setImage(new Image("img/workers/farmer.png"));
				keyImage2.setImage(new Image("img/workers/farmer.png"));
				
				workerName1.setText("Rancher");
				workerName2.setText("Rancher");
				
				costImage1.setImage(new Image("img/workers/farmer.png"));
				log("Went to Page 1 (Food).");
			} else if (currentPage == 2) {
				keyName1.setVisible(true);
				keyName2.setVisible(true);
				keyName3.setVisible(true);
				keyName4.setVisible(true);
				keyImage1.setVisible(true);
				keyImage2.setVisible(true);
				keyImage3.setVisible(true);
				keyImage4.setVisible(true);
				key1.setVisible(true);
				key2.setVisible(true);
				key3.setVisible(true);
				key4.setVisible(true);
				workerName1.setVisible(true);
				workerName2.setVisible(true);
				workerName3.setVisible(true);
				workerName4.setVisible(true);
				lblAmountChange1.setVisible(true);
				lblAmountChange2.setVisible(true);
				lblAmountChange3.setVisible(true);
				lblAmountChange4.setVisible(true);
				lblItem1.setVisible(true);
				lblItem2.setVisible(true);
				lblItem3.setVisible(true);
				lblCost1.setVisible(true);
				lblCost2.setVisible(true);
				lblCost3.setVisible(true);
				lblPrice.setVisible(true);
				costImage1.setVisible(true);
				costImage2.setVisible(true);
				costImage3.setVisible(true);
				
				itemName.setText("FISH");
				itemImage.setImage(new Image("img/resources/food/fish.png"));
				
				keyImage1.setImage(new Image("img/workers/fisher.png"));
				keyImage2.setImage(new Image("img/workers/fisher.png"));
				keyImage3.setImage(new Image("img/workers/merchant.png"));
				keyImage4.setImage(new Image("img/workers/merchant.png"));
	
				workerName1.setText("Fisher");
				workerName2.setText("Fisher");
				workerName3.setText("Fish Merchant");
				workerName4.setText("Fish Merchant");
				
				lblCost1.setText("(1) Cost: 2 Food");
	
				costImage1.setImage(new Image("img/resources/food/fish.png"));
				costImage2.setImage(new Image("img/workers/fisher.png"));
				costImage3.setImage(new Image("img/workers/merchant.png"));
				log("Went to Page 2 (Fish).");
			} else if (currentPage == 3) {
				if (rank == 1) {
					keyName1.setVisible(true);
					keyName2.setVisible(true);
					keyName3.setVisible(false);
					keyName4.setVisible(false);
					keyImage1.setVisible(true);
					keyImage2.setVisible(true);
					keyImage3.setVisible(false);
					keyImage4.setVisible(false);
					key1.setVisible(true);
					key2.setVisible(true);
					key3.setVisible(false);
					key4.setVisible(false);
					workerName1.setVisible(true);
					workerName2.setVisible(true);
					workerName3.setVisible(false);
					workerName4.setVisible(false);
					lblAmountChange1.setVisible(true);
					lblAmountChange2.setVisible(true);
					lblAmountChange3.setVisible(false);
					lblAmountChange4.setVisible(false);
					lblItem1.setVisible(true);
					lblItem2.setVisible(false);
					lblItem3.setVisible(false);
					lblCost1.setVisible(true);
					lblCost2.setVisible(false);
					lblCost3.setVisible(false);
					lblPrice.setVisible(false);
					costImage1.setVisible(true);
					costImage2.setVisible(false);
					costImage3.setVisible(false);
					
					itemName.setText("STONE");
					itemImage.setImage(new Image("img/resources/stone/stone.png"));
					
					keyImage1.setImage(new Image("img/workers/miner.png"));
					keyImage2.setImage(new Image("img/workers/miner.png"));
					
					workerName1.setText("Miner");
					workerName2.setText("Miner");
					
					costImage1.setImage(new Image("img/workers/miner.png"));
					log("Went to Page 3 (Stone).");
				} else {
					keyName1.setVisible(true);
					keyName2.setVisible(true);
					keyName3.setVisible(true);
					keyName4.setVisible(true);
					keyImage1.setVisible(true);
					keyImage2.setVisible(true);
					keyImage3.setVisible(true);
					keyImage4.setVisible(true);
					key1.setVisible(true);
					key2.setVisible(true);
					key3.setVisible(true);
					key4.setVisible(true);
					workerName1.setVisible(true);
					workerName2.setVisible(true);
					workerName3.setVisible(true);
					workerName4.setVisible(true);
					lblAmountChange1.setVisible(true);
					lblAmountChange2.setVisible(true);
					lblAmountChange3.setVisible(true);
					lblAmountChange4.setVisible(true);
					lblItem1.setVisible(true);
					lblItem2.setVisible(true);
					lblItem3.setVisible(true);
					lblCost1.setVisible(true);
					lblCost2.setVisible(true);
					lblCost3.setVisible(true);
					lblPrice.setVisible(true);
					costImage1.setVisible(true);
					costImage2.setVisible(true);
					costImage3.setVisible(true);
					
					itemName.setText("STEAK");
					itemImage.setImage(new Image("img/resources/food/steak.png"));
					
					keyImage1.setImage(new Image("img/workers/farmer.png"));
					keyImage2.setImage(new Image("img/workers/farmer.png"));
					keyImage3.setImage(new Image("img/workers/merchant.png"));
					keyImage4.setImage(new Image("img/workers/merchant.png"));
					
					workerName1.setText("Cow Rancher");
					workerName2.setText("Cow Rancher");
					workerName3.setText("Steak Merchant");
					workerName4.setText("Steak Merchant");
					
					lblCost1.setText("(1) Cost: 2 Food");
		
					costImage1.setImage(new Image("img/resources/food/steak.png"));
					costImage2.setImage(new Image("img/workers/farmer.png"));
					costImage3.setImage(new Image("img/workers/merchant.png"));
					log("Went to Page 3 (Steak).");
				}
			} else if (currentPage == 4) {
				if (rank == 1) {
					keyName1.setVisible(true);
					keyName2.setVisible(true);
					keyName3.setVisible(true);
					keyName4.setVisible(true);
					keyImage1.setVisible(true);
					keyImage2.setVisible(true);
					keyImage3.setVisible(true);
					keyImage4.setVisible(true);
					key1.setVisible(true);
					key2.setVisible(true);
					key3.setVisible(true);
					key4.setVisible(true);
					workerName1.setVisible(true);
					workerName2.setVisible(true);
					workerName3.setVisible(true);
					workerName4.setVisible(true);
					lblAmountChange1.setVisible(true);
					lblAmountChange2.setVisible(true);
					lblAmountChange3.setVisible(true);
					lblAmountChange4.setVisible(true);
					lblItem1.setVisible(true);
					lblItem2.setVisible(true);
					lblItem3.setVisible(true);
					lblCost1.setVisible(true);
					lblCost2.setVisible(true);
					lblCost3.setVisible(true);
					lblPrice.setVisible(true);
					costImage1.setVisible(true);
					costImage2.setVisible(true);
					costImage3.setVisible(true);
					
					itemName.setText("COAL");
					itemImage.setImage(new Image("img/resources/stone/coal.png"));
					
					keyImage1.setImage(new Image("img/workers/miner.png"));
					keyImage2.setImage(new Image("img/workers/miner.png"));
					keyImage3.setImage(new Image("img/workers/merchant.png"));
					keyImage4.setImage(new Image("img/workers/merchant.png"));
					
					workerName1.setText("Coal Miner");
					workerName2.setText("Coal Miner");
					workerName3.setText("Coal Merchant");
					workerName4.setText("Coal Merchant");
					
					lblCost1.setText("(1) Cost: 2 Stone");
		
					costImage1.setImage(new Image("img/resources/stone/coal.png"));
					costImage2.setImage(new Image("img/workers/miner.png"));
					costImage3.setImage(new Image("img/workers/merchant.png"));
					log("Went to Page 4 (Coal).");
				} else {
					keyName1.setVisible(true);
					keyName2.setVisible(true);
					keyName3.setVisible(true);
					keyName4.setVisible(true);
					keyImage1.setVisible(true);
					keyImage2.setVisible(true);
					keyImage3.setVisible(true);
					keyImage4.setVisible(true);
					key1.setVisible(true);
					key2.setVisible(true);
					key3.setVisible(true);
					key4.setVisible(true);
					workerName1.setVisible(true);
					workerName2.setVisible(true);
					workerName3.setVisible(true);
					workerName4.setVisible(true);
					lblAmountChange1.setVisible(true);
					lblAmountChange2.setVisible(true);
					lblAmountChange3.setVisible(true);
					lblAmountChange4.setVisible(true);
					lblItem1.setVisible(true);
					lblItem2.setVisible(true);
					lblItem3.setVisible(true);
					lblCost1.setVisible(true);
					lblCost2.setVisible(true);
					lblCost3.setVisible(true);
					lblPrice.setVisible(true);
					costImage1.setVisible(true);
					costImage2.setVisible(true);
					costImage3.setVisible(true);
					
					itemName.setText("PORK");
					itemImage.setImage(new Image("img/resources/food/pork.png"));
					
					keyImage1.setImage(new Image("img/workers/farmer.png"));
					keyImage2.setImage(new Image("img/workers/farmer.png"));
					keyImage3.setImage(new Image("img/workers/merchant.png"));
					keyImage4.setImage(new Image("img/workers/merchant.png"));
					
					workerName1.setText("Pig Rancher");
					workerName2.setText("Pig Rancher");
					workerName3.setText("Pork Merchant");
					workerName4.setText("Pork Merchant");
					
					lblCost1.setText("(1) Cost: 2 Food");
		
					costImage1.setImage(new Image("img/resources/food/pork.png"));
					costImage2.setImage(new Image("img/workers/farmer.png"));
					costImage3.setImage(new Image("img/workers/merchant.png"));
					log("Went to Page 4 (Pork).");
				}
			} else if (currentPage == 5) {
				if (rank == 1) {
					keyName1.setVisible(true);
					keyName2.setVisible(true);
					keyName3.setVisible(false);
					keyName4.setVisible(false);
					keyImage1.setVisible(true);
					keyImage2.setVisible(true);
					keyImage3.setVisible(false);
					keyImage4.setVisible(false);
					key1.setVisible(true);
					key2.setVisible(true);
					key3.setVisible(false);
					key4.setVisible(false);
					workerName1.setVisible(true);
					workerName2.setVisible(true);
					workerName3.setVisible(false);
					workerName4.setVisible(false);
					lblAmountChange1.setVisible(true);
					lblAmountChange2.setVisible(true);
					lblAmountChange3.setVisible(false);
					lblAmountChange4.setVisible(false);
					lblItem1.setVisible(true);
					lblItem2.setVisible(false);
					lblItem3.setVisible(false);
					lblCost1.setVisible(true);
					lblCost2.setVisible(false);
					lblCost3.setVisible(false);
					lblPrice.setVisible(false);
					costImage1.setVisible(true);
					costImage2.setVisible(false);
					costImage3.setVisible(false);
					
					itemName.setText("WOOD");
					itemImage.setImage(new Image("img/resources/wood/wood.png"));
					
					keyImage1.setImage(new Image("img/workers/lumberjack.png"));
					keyImage2.setImage(new Image("img/workers/lumberjack.png"));
					
					workerName1.setText("Lumberjack");
					workerName2.setText("Lumberjack");
					
					costImage1.setImage(new Image("img/workers/lumberjack.png"));
					log("Went to Page 5 (Wood).");
				} else {
					keyName1.setVisible(true);
					keyName2.setVisible(true);
					keyName3.setVisible(true);
					keyName4.setVisible(true);
					keyImage1.setVisible(true);
					keyImage2.setVisible(true);
					keyImage3.setVisible(true);
					keyImage4.setVisible(true);
					key1.setVisible(true);
					key2.setVisible(true);
					key3.setVisible(true);
					key4.setVisible(true);
					workerName1.setVisible(true);
					workerName2.setVisible(true);
					workerName3.setVisible(true);
					workerName4.setVisible(true);
					lblAmountChange1.setVisible(true);
					lblAmountChange2.setVisible(true);
					lblAmountChange3.setVisible(true);
					lblAmountChange4.setVisible(true);
					lblItem1.setVisible(true);
					lblItem2.setVisible(true);
					lblItem3.setVisible(true);
					lblCost1.setVisible(true);
					lblCost2.setVisible(true);
					lblCost3.setVisible(true);
					lblPrice.setVisible(true);
					costImage1.setVisible(true);
					costImage2.setVisible(true);
					costImage3.setVisible(true);
					
					itemName.setText("CHICKEN");
					itemImage.setImage(new Image("img/resources/food/chicken.png"));
					
					keyImage1.setImage(new Image("img/workers/farmer.png"));
					keyImage2.setImage(new Image("img/workers/farmer.png"));
					keyImage3.setImage(new Image("img/workers/merchant.png"));
					keyImage4.setImage(new Image("img/workers/merchant.png"));
					
					workerName1.setText("Chicken Rancher");
					workerName2.setText("Chicken Rancher");
					workerName3.setText("Chicken Merchant");
					workerName4.setText("Chicken Merchant");
					
					lblCost1.setText("(1) Cost: 2 Food");
		
					costImage1.setImage(new Image("img/resources/food/chicken.png"));
					costImage2.setImage(new Image("img/workers/farmer.png"));
					costImage3.setImage(new Image("img/workers/merchant.png"));
					log("Went to Page 5 (Chicken).");
				}
			} else if (currentPage == 6) {
				if (rank == 1) {
					keyName1.setVisible(true);
					keyName2.setVisible(true);
					keyName3.setVisible(true);
					keyName4.setVisible(true);
					keyImage1.setVisible(true);
					keyImage2.setVisible(true);
					keyImage3.setVisible(true);
					keyImage4.setVisible(true);
					key1.setVisible(true);
					key2.setVisible(true);
					key3.setVisible(true);
					key4.setVisible(true);
					workerName1.setVisible(true);
					workerName2.setVisible(true);
					workerName3.setVisible(true);
					workerName4.setVisible(true);
					lblAmountChange1.setVisible(true);
					lblAmountChange2.setVisible(true);
					lblAmountChange3.setVisible(true);
					lblAmountChange4.setVisible(true);
					lblItem1.setVisible(true);
					lblItem2.setVisible(true);
					lblItem3.setVisible(true);
					lblCost1.setVisible(true);
					lblCost2.setVisible(true);
					lblCost3.setVisible(true);
					lblPrice.setVisible(true);
					costImage1.setVisible(true);
					costImage2.setVisible(true);
					costImage3.setVisible(true);
					
					itemName.setText("PLANKS");
					itemImage.setImage(new Image("img/resources/wood/plank.png"));
					
					keyImage1.setImage(new Image("img/workers/woodCutter.png"));
					keyImage2.setImage(new Image("img/workers/woodCutter.png"));
					keyImage3.setImage(new Image("img/workers/merchant.png"));
					keyImage4.setImage(new Image("img/workers/merchant.png"));
					
					workerName1.setText("Wood Cutter");
					workerName2.setText("Wood Cutter");
					workerName3.setText("Planks Merchant");
					workerName4.setText("Planks Merchant");
					
					lblCost1.setText("(1) Cost: 2 Wood");
		
					costImage1.setImage(new Image("img/resources/wood/plank.png"));
					costImage2.setImage(new Image("img/workers/woodCutter.png"));
					costImage3.setImage(new Image("img/workers/merchant.png"));
					log("Went to Page 6 (Planks).");
				} else {
					keyName1.setVisible(true);
					keyName2.setVisible(true);
					keyName3.setVisible(true);
					keyName4.setVisible(true);
					keyImage1.setVisible(true);
					keyImage2.setVisible(true);
					keyImage3.setVisible(true);
					keyImage4.setVisible(true);
					key1.setVisible(true);
					key2.setVisible(true);
					key3.setVisible(true);
					key4.setVisible(true);
					workerName1.setVisible(true);
					workerName2.setVisible(true);
					workerName3.setVisible(true);
					workerName4.setVisible(true);
					lblAmountChange1.setVisible(true);
					lblAmountChange2.setVisible(true);
					lblAmountChange3.setVisible(true);
					lblAmountChange4.setVisible(true);
					lblItem1.setVisible(true);
					lblItem2.setVisible(true);
					lblItem3.setVisible(true);
					lblCost1.setVisible(true);
					lblCost2.setVisible(true);
					lblCost3.setVisible(true);
					lblPrice.setVisible(true);
					costImage1.setVisible(true);
					costImage2.setVisible(true);
					costImage3.setVisible(true);
					
					itemName.setText("MUTTON");
					itemImage.setImage(new Image("img/resources/food/mutton.png"));
					
					keyImage1.setImage(new Image("img/workers/farmer.png"));
					keyImage2.setImage(new Image("img/workers/farmer.png"));
					keyImage3.setImage(new Image("img/workers/merchant.png"));
					keyImage4.setImage(new Image("img/workers/merchant.png"));
					
					workerName1.setText("Sheep Rancher");
					workerName2.setText("Sheep Rancher");
					workerName3.setText("Mutton Merchant");
					workerName4.setText("Mutton Merchant");
					
					lblCost1.setText("(1) Cost: 2 Food");
		
					costImage1.setImage(new Image("img/resources/food/mutton.png"));
					costImage2.setImage(new Image("img/workers/farmer.png"));
					costImage3.setImage(new Image("img/workers/merchant.png"));
					log("Went to Page 6 (Mutton).");
				}
			} else if (currentPage == 7) {
				if (rank == 1) {
					keyName1.setVisible(true);
					keyName2.setVisible(true);
					keyName3.setVisible(false);
					keyName4.setVisible(false);
					keyImage1.setVisible(true);
					keyImage2.setVisible(true);
					keyImage3.setVisible(false);
					keyImage4.setVisible(false);
					key1.setVisible(true);
					key2.setVisible(true);
					key3.setVisible(false);
					key4.setVisible(false);
					workerName1.setVisible(true);
					workerName2.setVisible(true);
					workerName3.setVisible(false);
					workerName4.setVisible(false);
					lblAmountChange1.setVisible(true);
					lblAmountChange2.setVisible(true);
					lblAmountChange3.setVisible(false);
					lblAmountChange4.setVisible(false);
					lblItem1.setVisible(true);
					lblItem2.setVisible(false);
					lblItem3.setVisible(false);
					lblCost1.setVisible(true);
					lblCost2.setVisible(false);
					lblCost3.setVisible(false);
					lblPrice.setVisible(false);
					costImage1.setVisible(true);
					costImage2.setVisible(false);
					costImage3.setVisible(false);
					
					itemName.setText("CROPS");
					itemImage.setImage(new Image("img/resources/crop/crop.png"));
					
					keyImage1.setImage(new Image("img/workers/farmer.png"));
					keyImage2.setImage(new Image("img/workers/farmer.png"));
					
					workerName1.setText("Farmer");
					workerName2.setText("Farmer");
					
					costImage1.setImage(new Image("img/workers/farmer.png"));
					log("Went to Page 7 (Crops).");
				} else {
					keyName1.setVisible(true);
					keyName2.setVisible(true);
					keyName3.setVisible(false);
					keyName4.setVisible(false);
					keyImage1.setVisible(true);
					keyImage2.setVisible(true);
					keyImage3.setVisible(false);
					keyImage4.setVisible(false);
					key1.setVisible(true);
					key2.setVisible(true);
					key3.setVisible(false);
					key4.setVisible(false);
					workerName1.setVisible(true);
					workerName2.setVisible(true);
					workerName3.setVisible(false);
					workerName4.setVisible(false);
					lblAmountChange1.setVisible(true);
					lblAmountChange2.setVisible(true);
					lblAmountChange3.setVisible(false);
					lblAmountChange4.setVisible(false);
					lblItem1.setVisible(true);
					lblItem2.setVisible(false);
					lblItem3.setVisible(false);
					lblCost1.setVisible(true);
					lblCost2.setVisible(false);
					lblCost3.setVisible(false);
					lblPrice.setVisible(false);
					costImage1.setVisible(true);
					costImage2.setVisible(false);
					costImage3.setVisible(false);
					
					itemName.setText("STONE");
					itemImage.setImage(new Image("img/resources/stone/stone.png"));
					
					keyImage1.setImage(new Image("img/workers/miner.png"));
					keyImage2.setImage(new Image("img/workers/miner.png"));
					
					workerName1.setText("Miner");
					workerName2.setText("Miner");
					
					costImage1.setImage(new Image("img/workers/miner.png"));
					log("Went to Page 7 (Stone).");
				}
			} else if (currentPage == 8) {
				if (rank == 1) {
					keyName1.setVisible(true);
					keyName2.setVisible(true);
					keyName3.setVisible(true);
					keyName4.setVisible(true);
					keyImage1.setVisible(true);
					keyImage2.setVisible(true);
					keyImage3.setVisible(true);
					keyImage4.setVisible(true);
					key1.setVisible(true);
					key2.setVisible(true);
					key3.setVisible(true);
					key4.setVisible(true);
					workerName1.setVisible(true);
					workerName2.setVisible(true);
					workerName3.setVisible(true);
					workerName4.setVisible(true);
					lblAmountChange1.setVisible(true);
					lblAmountChange2.setVisible(true);
					lblAmountChange3.setVisible(true);
					lblAmountChange4.setVisible(true);
					lblItem1.setVisible(true);
					lblItem2.setVisible(true);
					lblItem3.setVisible(true);
					lblCost1.setVisible(true);
					lblCost2.setVisible(true);
					lblCost3.setVisible(true);
					lblPrice.setVisible(true);
					costImage1.setVisible(true);
					costImage2.setVisible(true);
					costImage3.setVisible(true);
					
					itemName.setText("COTTON");
					itemImage.setImage(new Image("img/resources/crop/cotton.png"));
					
					keyImage1.setImage(new Image("img/workers/farmer.png"));
					keyImage2.setImage(new Image("img/workers/farmer.png"));
					keyImage3.setImage(new Image("img/workers/merchant.png"));
					keyImage4.setImage(new Image("img/workers/merchant.png"));
					
					workerName1.setText("Cotton Farmer");
					workerName2.setText("Cotton Farmer");
					workerName3.setText("Cotton Merchant");
					workerName4.setText("Cotton Merchant");
					
					lblCost1.setText("(1) Cost: 2 Crops");
		
					costImage1.setImage(new Image("img/resources/crop/cotton.png"));
					costImage2.setImage(new Image("img/workers/farmer.png"));
					costImage3.setImage(new Image("img/workers/merchant.png"));
					log("Went to Page 8 (Cotton).");
				} else {
					keyName1.setVisible(true);
					keyName2.setVisible(true);
					keyName3.setVisible(true);
					keyName4.setVisible(true);
					keyImage1.setVisible(true);
					keyImage2.setVisible(true);
					keyImage3.setVisible(true);
					keyImage4.setVisible(true);
					key1.setVisible(true);
					key2.setVisible(true);
					key3.setVisible(true);
					key4.setVisible(true);
					workerName1.setVisible(true);
					workerName2.setVisible(true);
					workerName3.setVisible(true);
					workerName4.setVisible(true);
					lblAmountChange1.setVisible(true);
					lblAmountChange2.setVisible(true);
					lblAmountChange3.setVisible(true);
					lblAmountChange4.setVisible(true);
					lblItem1.setVisible(true);
					lblItem2.setVisible(true);
					lblItem3.setVisible(true);
					lblCost1.setVisible(true);
					lblCost2.setVisible(true);
					lblCost3.setVisible(true);
					lblPrice.setVisible(true);
					costImage1.setVisible(true);
					costImage2.setVisible(true);
					costImage3.setVisible(true);
					
					itemName.setText("COAL");
					itemImage.setImage(new Image("img/resources/stone/coal.png"));
					
					keyImage1.setImage(new Image("img/workers/miner.png"));
					keyImage2.setImage(new Image("img/workers/miner.png"));
					keyImage3.setImage(new Image("img/workers/merchant.png"));
					keyImage4.setImage(new Image("img/workers/merchant.png"));
					
					workerName1.setText("Coal Miner");
					workerName2.setText("Coal Miner");
					workerName3.setText("Coal Merchant");
					workerName4.setText("Coal Merchant");
					
					lblCost1.setText("(1) Cost: 2 Stone");
		
					costImage1.setImage(new Image("img/resources/stone/coal.png"));
					costImage2.setImage(new Image("img/workers/miner.png"));
					costImage3.setImage(new Image("img/workers/merchant.png"));
					log("Went to Page 8 (Coal).");
				}
			} else if (currentPage == 9) {
				keyName1.setVisible(true);
				keyName2.setVisible(true);
				keyName3.setVisible(false);
				keyName4.setVisible(false);
				keyImage1.setVisible(true);
				keyImage2.setVisible(true);
				keyImage3.setVisible(false);
				keyImage4.setVisible(false);
				key1.setVisible(true);
				key2.setVisible(true);
				key3.setVisible(false);
				key4.setVisible(false);
				workerName1.setVisible(true);
				workerName2.setVisible(true);
				workerName3.setVisible(false);
				workerName4.setVisible(false);
				lblAmountChange1.setVisible(true);
				lblAmountChange2.setVisible(true);
				lblAmountChange3.setVisible(false);
				lblAmountChange4.setVisible(false);
				lblItem1.setVisible(true);
				lblItem2.setVisible(false);
				lblItem3.setVisible(false);
				lblCost1.setVisible(true);
				lblCost2.setVisible(false);
				lblCost3.setVisible(false);
				lblPrice.setVisible(false);
				costImage1.setVisible(true);
				costImage2.setVisible(false);
				costImage3.setVisible(false);
				
				itemName.setText("WOOD");
				itemImage.setImage(new Image("img/resources/wood/wood.png"));
				
				keyImage1.setImage(new Image("img/workers/lumberjack.png"));
				keyImage2.setImage(new Image("img/workers/lumberjack.png"));
				
				workerName1.setText("Lumberjack");
				workerName2.setText("Lumberjack");
				
				costImage1.setImage(new Image("img/workers/lumberjack.png"));
				log("Went to Page 9 (Wood).");
			} else if (currentPage == 10) {
				keyName1.setVisible(true);
				keyName2.setVisible(true);
				keyName3.setVisible(true);
				keyName4.setVisible(true);
				keyImage1.setVisible(true);
				keyImage2.setVisible(true);
				keyImage3.setVisible(true);
				keyImage4.setVisible(true);
				key1.setVisible(true);
				key2.setVisible(true);
				key3.setVisible(true);
				key4.setVisible(true);
				workerName1.setVisible(true);
				workerName2.setVisible(true);
				workerName3.setVisible(true);
				workerName4.setVisible(true);
				lblAmountChange1.setVisible(true);
				lblAmountChange2.setVisible(true);
				lblAmountChange3.setVisible(true);
				lblAmountChange4.setVisible(true);
				lblItem1.setVisible(true);
				lblItem2.setVisible(true);
				lblItem3.setVisible(true);
				lblCost1.setVisible(true);
				lblCost2.setVisible(true);
				lblCost3.setVisible(true);
				lblPrice.setVisible(true);
				costImage1.setVisible(true);
				costImage2.setVisible(true);
				costImage3.setVisible(true);
				
				itemName.setText("PLANKS");
				itemImage.setImage(new Image("img/resources/wood/plank.png"));
				
				keyImage1.setImage(new Image("img/workers/woodCutter.png"));
				keyImage2.setImage(new Image("img/workers/woodCutter.png"));
				keyImage3.setImage(new Image("img/workers/merchant.png"));
				keyImage4.setImage(new Image("img/workers/merchant.png"));
				
				workerName1.setText("Wood Cutter");
				workerName2.setText("Wood Cutter");
				workerName3.setText("Planks Merchant");
				workerName4.setText("Planks Merchant");
				
				lblCost1.setText("(1) Cost: 2 Wood");
	
				costImage1.setImage(new Image("img/resources/wood/plank.png"));
				costImage2.setImage(new Image("img/workers/woodCutter.png"));
				costImage3.setImage(new Image("img/workers/merchant.png"));
				log("Went to Page 10 (Planks).");
			} else if (currentPage == 11) {
				keyName1.setVisible(true);
				keyName2.setVisible(true);
				keyName3.setVisible(false);
				keyName4.setVisible(false);
				keyImage1.setVisible(true);
				keyImage2.setVisible(true);
				keyImage3.setVisible(false);
				keyImage4.setVisible(false);
				key1.setVisible(true);
				key2.setVisible(true);
				key3.setVisible(false);
				key4.setVisible(false);
				workerName1.setVisible(true);
				workerName2.setVisible(true);
				workerName3.setVisible(false);
				workerName4.setVisible(false);
				lblAmountChange1.setVisible(true);
				lblAmountChange2.setVisible(true);
				lblAmountChange3.setVisible(false);
				lblAmountChange4.setVisible(false);
				lblItem1.setVisible(true);
				lblItem2.setVisible(false);
				lblItem3.setVisible(false);
				lblCost1.setVisible(true);
				lblCost2.setVisible(false);
				lblCost3.setVisible(false);
				lblPrice.setVisible(false);
				costImage1.setVisible(true);
				costImage2.setVisible(false);
				costImage3.setVisible(false);
				
				itemName.setText("CROPS");
				itemImage.setImage(new Image("img/resources/crop/crop.png"));
				
				keyImage1.setImage(new Image("img/workers/farmer.png"));
				keyImage2.setImage(new Image("img/workers/farmer.png"));
				
				workerName1.setText("Farmer");
				workerName2.setText("Farmer");
				
				costImage1.setImage(new Image("img/workers/farmer.png"));
				log("Went to Page 11 (Crops).");
			} else if (currentPage == 12) {
				keyName1.setVisible(true);
				keyName2.setVisible(true);
				keyName3.setVisible(true);
				keyName4.setVisible(true);
				keyImage1.setVisible(true);
				keyImage2.setVisible(true);
				keyImage3.setVisible(true);
				keyImage4.setVisible(true);
				key1.setVisible(true);
				key2.setVisible(true);
				key3.setVisible(true);
				key4.setVisible(true);
				workerName1.setVisible(true);
				workerName2.setVisible(true);
				workerName3.setVisible(true);
				workerName4.setVisible(true);
				lblAmountChange1.setVisible(true);
				lblAmountChange2.setVisible(true);
				lblAmountChange3.setVisible(true);
				lblAmountChange4.setVisible(true);
				lblItem1.setVisible(true);
				lblItem2.setVisible(true);
				lblItem3.setVisible(true);
				lblCost1.setVisible(true);
				lblCost2.setVisible(true);
				lblCost3.setVisible(true);
				lblPrice.setVisible(true);
				costImage1.setVisible(true);
				costImage2.setVisible(true);
				costImage3.setVisible(true);
				
				itemName.setText("COTTON");
				itemImage.setImage(new Image("img/resources/crop/cotton.png"));
				
				keyImage1.setImage(new Image("img/workers/farmer.png"));
				keyImage2.setImage(new Image("img/workers/farmer.png"));
				keyImage3.setImage(new Image("img/workers/merchant.png"));
				keyImage4.setImage(new Image("img/workers/merchant.png"));
				
				workerName1.setText("Cotton Farmer");
				workerName2.setText("Cotton Farmer");
				workerName3.setText("Cotton Merchant");
				workerName4.setText("Cotton Merchant");
				
				lblCost1.setText("(1) Cost: 2 Crops");
	
				costImage1.setImage(new Image("img/resources/crop/cotton.png"));
				costImage2.setImage(new Image("img/workers/farmer.png"));
				costImage3.setImage(new Image("img/workers/merchant.png"));
				log("Went to Page 12 (Cotton).");
			}
		} catch (Exception e) {}
	}
	
	public void updateAchievements() {
		int index = (int)currentResource;
		
		if (rank == 1) {
			if (currentResource == 9) {
				index = 0;
			}
		} else if (rank == 2) {
			if (currentResource == 13) {
				index = 0;
			}
		}
		if (achievement[index] >= achievementPage*3-2) {
			medalAchievement1.setImage(new Image("img/techincal/medal.png"));
		} else {
			medalAchievement1.setImage(new Image("img/techincal/locked.png"));
		}
		if (achievement[index] >= achievementPage*3-1) {
			medalAchievement2.setImage(new Image("img/techincal/medal.png"));
		} else {
			medalAchievement2.setImage(new Image("img/techincal/locked.png"));
		}
		if (achievement[index] >= achievementPage*3) {
			medalAchievement3.setImage(new Image("img/techincal/medal.png"));
		} else {
			medalAchievement3.setImage(new Image("img/techincal/locked.png"));
		}
	}
	
	public void changeOptionsPage() {
		if (optionsPage == 1) {
			activateOptions();
		} else if (optionsPage == 2) {
			activateCredits();
		}
	}
	
	public void changeAchievementPage() {
		if (inAchievementSelect) {
			imgResource1.setVisible(true);
			imgResource2.setVisible(true);
			imgResource3.setVisible(true);
			imgResource4.setVisible(true);
			imgResource5.setVisible(true);
			imgResource6.setVisible(true);
			imgResource7.setVisible(true);
			imgResource8.setVisible(true);
			imgWorker1.setVisible(true);
			imgWorker2.setVisible(true);
			imgWorker3.setVisible(true);
			imgWorker4.setVisible(true);
			imgWorker5.setVisible(true);
			imgWorker6.setVisible(true);
			imgWorker7.setVisible(true);
			imgWorker8.setVisible(true);
			storageResource1.setVisible(true);
			storageResource2.setVisible(true);
			storageResource3.setVisible(true);
			storageResource4.setVisible(true);
			storageResource5.setVisible(true);
			storageResource6.setVisible(true);
			storageResource7.setVisible(true);
			storageResource8.setVisible(true);
			storageWorker1.setVisible(true);
			storageWorker2.setVisible(true);
			storageWorker3.setVisible(true);
			storageWorker4.setVisible(true);
			storageWorker5.setVisible(true);
			storageWorker6.setVisible(true);
			storageWorker7.setVisible(true);
			storageWorker8.setVisible(true);
			lblAchievement1.setVisible(false);
			lblAchievement2.setVisible(false);
			lblAchievement3.setVisible(false);
			achievementDesc1.setVisible(false);
			achievementDesc2.setVisible(false);
			achievementDesc3.setVisible(false);
			medalAchievement1.setVisible(false);
			medalAchievement2.setVisible(false);
			medalAchievement3.setVisible(false);
			if (achievementPage == 1) {
				imgResource1.setImage(new Image("img/resources/food/food.png"));
				imgResource2.setImage(new Image("img/resources/food/fish.png"));
				imgResource3.setImage(new Image("img/resources/stone/stone.png"));
				imgResource4.setImage(new Image("img/resources/stone/coal.png"));
				imgResource5.setImage(new Image("img/resources/wood/wood.png"));
				imgResource6.setImage(new Image("img/resources/wood/plank.png"));
				imgResource7.setImage(new Image("img/resources/crop/crop.png"));
				imgResource8.setImage(new Image("img/resources/crop/cotton.png"));
				if (rank == 1) {
					imgWorker1.setImage(new Image("img/technical/rankup.png"));
					imgWorker2.setImage(null);
					imgWorker2.setVisible(false);
					imgWorker3.setImage(null);
					imgWorker3.setVisible(false);
					imgWorker4.setImage(null);
					imgWorker4.setVisible(false);
					imgWorker5.setImage(null);
					imgWorker5.setVisible(false);
					imgWorker6.setImage(null);
					imgWorker6.setVisible(false);
					imgWorker7.setImage(null);
					imgWorker7.setVisible(false);
					imgWorker8.setImage(null);
					imgWorker8.setVisible(false);
				} else if (rank == 2) {
					imgWorker1.setImage(new Image("img/resources/food/steak.png"));
					imgWorker2.setImage(new Image("img/resources/food/pork.png"));
					imgWorker3.setImage(new Image("img/resources/food/chicken.png"));
					imgWorker4.setImage(new Image("img/resources/food/mutton.png"));
					imgWorker5.setImage(new Image("img/technical/rankup.png"));
					imgWorker6.setImage(null);
					imgWorker6.setVisible(false);
					imgWorker7.setImage(null);
					imgWorker7.setVisible(false);
					imgWorker8.setImage(null);
					imgWorker8.setVisible(false);
				}
				storageResource1.setText("Food");
				storageResource2.setText("Fish");
				storageResource3.setText("Stone");
				storageResource4.setText("Coal");
				storageResource5.setText("Wood");
				storageResource6.setText("Planks");
				storageResource7.setText("Crops");
				storageResource8.setText("Cotton");
				if (rank == 1) {
					storageWorker1.setText("Rank Up");
					storageWorker2.setText("");
					storageWorker3.setText("");
					storageWorker4.setText("");
					storageWorker5.setText("");
					storageWorker6.setText("");
					storageWorker7.setText("");
					storageWorker8.setText("");
				} else if (rank == 2) {
					storageWorker1.setText("Steak");
					storageWorker2.setText("Pork");
					storageWorker3.setText("Chicken");
					storageWorker4.setText("Mutton");
					storageWorker5.setText("Rank Up");
					storageWorker6.setText("");
					storageWorker7.setText("");
					storageWorker8.setText("");
				}
			}
		} else if (inAchievement) {
			goBackButton.setVisible(true);
			goBackIcon.setVisible(true);
			imgResource1.setVisible(false);
			imgResource2.setVisible(false);
			imgResource3.setVisible(false);
			imgResource4.setVisible(false);
			imgResource5.setVisible(false);
			imgResource6.setVisible(false);
			imgResource7.setVisible(false);
			imgResource8.setVisible(false);
			imgWorker1.setVisible(false);
			imgWorker2.setVisible(false);
			imgWorker3.setVisible(false);
			imgWorker4.setVisible(false);
			imgWorker5.setVisible(false);
			imgWorker6.setVisible(false);
			imgWorker7.setVisible(false);
			imgWorker8.setVisible(false);
			storageResource1.setVisible(false);
			storageResource2.setVisible(false);
			storageResource3.setVisible(false);
			storageResource4.setVisible(false);
			storageResource5.setVisible(false);
			storageResource6.setVisible(false);
			storageResource7.setVisible(false);
			storageResource8.setVisible(false);
			storageWorker1.setVisible(false);
			storageWorker2.setVisible(false);
			storageWorker3.setVisible(false);
			storageWorker4.setVisible(false);
			storageWorker5.setVisible(false);
			storageWorker6.setVisible(false);
			storageWorker7.setVisible(false);
			storageWorker8.setVisible(false);
			lblAchievement1.setVisible(true);
			lblAchievement2.setVisible(true);
			lblAchievement3.setVisible(true);
			achievementDesc1.setVisible(true);
			achievementDesc2.setVisible(true);
			achievementDesc3.setVisible(true);
			medalAchievement1.setVisible(true);
			medalAchievement2.setVisible(true);
			medalAchievement3.setVisible(true);
			
			String amount;
			String name = "";
			int index = (int)currentResource;
			
			if (currentResource == 0) name = "Rank Up";
			else if (currentResource == 1) name = "Food";
			else if (currentResource == 2) name = "Fish";
			else if (currentResource == 3) name = "Stone";
			else if (currentResource == 4) name = "Coal";
			else if (currentResource == 5) name = "Wood";
			else if (currentResource == 6) name = "Planks";
			else if (currentResource == 7) name = "Crops";
			else if (currentResource == 8) name = "Cotton";
			else if (currentResource == 9) name = "Steak";
			else if (currentResource == 10) name = "Pork";
			else if (currentResource == 11) name = "Chicken";
			else if (currentResource == 12) name = "Mutton";
			
			if (!name.equals("Rank Up")) {
				lblAchievement1.setText(name+" Hoarder #"+((achievementPage-1)*3+1)+":");
				lblAchievement2.setText(name+" Hoarder #"+((achievementPage-1)*3+2)+":");
				lblAchievement3.setText(name+" Hoarder #"+(achievementPage*3)+":");
				
				if (1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3) >= 1000000000) {
					formatter = new DecimalFormat("0.00E0");
					amount = formatter.format(1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3));
				} else if (1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3) >= 1000000) {
					amount = (double)(1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3)-(1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3))%100000)/1000000+"M";
				} else if (1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3) >= 1000) {
					amount = (double)(1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3)-(1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3))%100)/1000+"K";
				} else {
					amount = Double.toString(1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3));
				}
				achievementDesc1.setText("Acquire "+amount+" "+name+".");
	
				if (1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3+1) >= 1000000000) {
					formatter = new DecimalFormat("0.00E0");
					amount = formatter.format(1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3+1));
				} else if (1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3+1) >= 1000000) {
					amount = (double)(1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3+1)-(1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3+1))%100000)/1000000+"M";
				} else if (1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3+1) >= 1000) {
					amount = (double)(1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3+1)-(1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3+1))%100)/1000+"K";
				} else {
					amount = Double.toString(1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3+1));
				}
				achievementDesc2.setText("Acquire "+amount+" "+name+".");
	
				if (1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3+2) >= 1000000000) {
					formatter = new DecimalFormat("0.00E0");
					amount = formatter.format(1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3+2));
				} else if (1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3+2) >= 1000000) {
					amount = (double)(1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3+2)-(1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3+2))%100000)/1000000+"M";
				} else if (1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3+2) >= 1000) {
					amount = (double)(1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3+2)-(1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3+2))%100)/1000+"K";
				} else {
					amount = Double.toString(1000*Math.pow(Math.sqrt(10),(achievementPage-1)*3+2));
				}
				achievementDesc3.setText("Acquire "+amount+" "+name+".");
			} else {
				if (achievementPage == 1) {
					lblAchievement1.setText("Starter");
					achievementDesc1.setText("Acquire 10K of each Resource.\nAcquire 100 of each Worker.\nReward: Rank 2");
					lblAchievement2.setText("Novice");
					achievementDesc2.setText("???");
					lblAchievement3.setText("Rookie");
					achievementDesc3.setText("???");
				} else {
					lblAchievement1.setText("???");
					achievementDesc1.setText("???");
					lblAchievement2.setText("???");
					achievementDesc2.setText("???");
					lblAchievement3.setText("???");
					achievementDesc3.setText("???");
				}
			}
			if (achievement[index] >= achievementPage*3-2) {
				medalAchievement1.setImage(new Image("img/technical/medal.png"));
			} else {
				medalAchievement1.setImage(new Image("img/technical/locked.png"));
			}
			if (achievement[index] >= achievementPage*3-1) {
				medalAchievement2.setImage(new Image("img/technical/medal.png"));
			} else {
				medalAchievement2.setImage(new Image("img/technical/locked.png"));
			}
			if (achievement[index] >= achievementPage*3) {
				medalAchievement3.setImage(new Image("img/technical/medal.png"));
			} else {
				medalAchievement3.setImage(new Image("img/technical/locked.png"));
			}
		}
	}
	
	public void updateStorageLabels() {
		try {
			if (storagePage == 1) {
				updateLabel(storageResource1,"Food: ",foodWhole,rancher,fisher*4+cowRancher*4+pigRancher*4+chickenRancher*4+sheepRancher*4);
				updateLabel(storageResource2,"Fish: ",fishWhole,fisher,fishMerchant*2);
				updateLabel(storageResource3,"Stone: ",stoneWhole,miner,coalMiner*4);
				updateLabel(storageResource4,"Coal: ",coalWhole,coalMiner,coalMerchant*2);
				updateLabel(storageResource5,"Wood: ",woodWhole,lumberjack,woodCutter*4);
				updateLabel(storageResource6,"Planks: ",plankWhole,woodCutter,plankMerchant*2);
				updateLabel(storageResource7,"Crops: ",cropWhole,farmer,cottonFarmer*4);
				updateLabel(storageResource8,"Cotton: ",cottonWhole,cottonFarmer,cottonMerchant*2);
				
				updateLabel(storageWorker1,"Ranchers: ",rancher);
				updateLabel(storageWorker2,"Fishers: ",fisher);
				updateLabel(storageWorker3,"Miners: ",miner);
				updateLabel(storageWorker4,"Coal Miners: ",coalMiner);
				updateLabel(storageWorker5,"Lumberjacks: ",lumberjack);
				updateLabel(storageWorker6,"Wood Cutter: ",woodCutter);
				updateLabel(storageWorker7,"Farmers: ",farmer);
				updateLabel(storageWorker8,"Cotton Farmers: ",cottonFarmer);
			} else if (storagePage == 2) {
				if (rank == 1) {
					storageResource1.setText("");
					storageResource2.setText("");
					storageResource3.setText("");
					storageResource4.setText("");
					storageResource5.setText("");
					storageResource6.setText("");
					storageResource7.setText("");
					storageResource8.setText("");
				} else if (rank == 2) {
					updateLabel(storageResource1,"Steak: ",steakWhole,cowRancher,steakMerchant*2);
					updateLabel(storageResource2,"Pork: ",porkWhole,pigRancher,porkMerchant*2);
					updateLabel(storageResource3,"Chicken: ",chickenWhole,chickenRancher,chickenMerchant*2);
					updateLabel(storageResource4,"Mutton: ",muttonWhole,sheepRancher,muttonMerchant*2);
					storageResource5.setText("");
					storageResource6.setText("");
					storageResource7.setText("");
					storageResource8.setText("");
				}
				
				updateLabel(storageWorker1,"Fish Merchants: ",fishMerchant);
				updateLabel(storageWorker2,"Coal Merchants: ",coalMerchant);
				updateLabel(storageWorker3,"Plank Merchants: ",plankMerchant);
				updateLabel(storageWorker4,"Cotton Merchants: ",cottonMerchant);
				
				if (rank == 1) {
					storageWorker5.setText("");
					storageWorker6.setText("");
					storageWorker7.setText("");
					storageWorker8.setText("");
					
				} else if (rank >= 2) {
					updateLabel(storageWorker5,"Cow Ranchers: ",cowRancher);
					updateLabel(storageWorker6,"Pig Ranchers: ",pigRancher);
					updateLabel(storageWorker7,"Chicken Ranchers: ",chickenRancher);
					updateLabel(storageWorker8,"Sheep Ranchers: ",sheepRancher);
				}
			} else if (storagePage == 3) {
				if (rank == 2) {
					storageResource1.setText("");
					storageResource2.setText("");
					storageResource3.setText("");
					storageResource4.setText("");
					storageResource5.setText("");
					storageResource6.setText("");
					storageResource7.setText("");
					storageResource8.setText("");
				}
				
				updateLabel(storageWorker1,"Steak Merchants: ",steakMerchant);
				updateLabel(storageWorker2,"Pork Merchants: ",porkMerchant);
				updateLabel(storageWorker3,"Chicken Merchants: ",chickenMerchant);
				updateLabel(storageWorker4,"Mutton Merchants: ",muttonMerchant);
				
				if (rank == 2) {
					storageWorker5.setText("");
					storageWorker6.setText("");
					storageWorker7.setText("");
					storageWorker8.setText("");
				}
			}
		} catch (Exception e) {}
	}
	
	public void changeStoragePage() {
		try {
			if (storagePage == 1) {
				updateLabel(storageResource1,"Food: ",foodWhole,rancher,(fisher*4-fishMerchant*4)+(cowRancher*4-steakMerchant*4)+(pigRancher*4-porkMerchant*4)+(chickenRancher*4-chickenMerchant*4)+(sheepRancher*4-muttonMerchant*4));
				updateLabel(storageResource2,"Fish: ",fishWhole,fisher,fishMerchant*2);
				updateLabel(storageResource3,"Stone: ",stoneWhole,miner,(coalMiner*4-coalMerchant*4));
				updateLabel(storageResource4,"Coal: ",coalWhole,coalMiner,coalMerchant*2);
				updateLabel(storageResource5,"Wood: ",woodWhole,lumberjack,(woodCutter*4-plankMerchant*4));
				updateLabel(storageResource6,"Planks: ",plankWhole,woodCutter,plankMerchant*2);
				updateLabel(storageResource7,"Crops: ",cropWhole,farmer,(cottonFarmer*4-cottonMerchant*4));
				updateLabel(storageResource8,"Cotton: ",cottonWhole,cottonFarmer,cottonMerchant*2);
				
				updateLabel(storageWorker1,"Ranchers: ",rancher);
				updateLabel(storageWorker2,"Fishers: ",fisher);
				updateLabel(storageWorker3,"Miners: ",miner);
				updateLabel(storageWorker4,"Coal Miners: ",coalMiner);
				updateLabel(storageWorker5,"Lumberjacks: ",lumberjack);
				updateLabel(storageWorker6,"Wood Cutter: ",woodCutter);
				updateLabel(storageWorker7,"Farmers: ",farmer);
				updateLabel(storageWorker8,"Cotton Farmers: ",cottonFarmer);
	
				imgResource1.setImage(new Image("img/resources/food/food.png"));
				imgResource2.setImage(new Image("img/resources/food/fish.png"));
				imgResource3.setImage(new Image("img/resources/stone/stone.png"));
				imgResource4.setImage(new Image("img/resources/stone/coal.png"));
				imgResource5.setImage(new Image("img/resources/wood/wood.png"));
				imgResource6.setImage(new Image("img/resources/wood/plank.png"));
				imgResource7.setImage(new Image("img/resources/crop/crop.png"));
				imgResource8.setImage(new Image("img/resources/crop/cotton.png"));
				imgResource1.setVisible(true);
				imgResource2.setVisible(true);
				imgResource3.setVisible(true);
				imgResource4.setVisible(true);
				imgResource5.setVisible(true);
				imgResource6.setVisible(true);
				imgResource7.setVisible(true);
				imgResource8.setVisible(true);
	
				imgWorker1.setImage(new Image("img/workers/farmer.png"));
				imgWorker2.setImage(new Image("img/workers/fisher.png"));
				imgWorker3.setImage(new Image("img/workers/miner.png"));
				imgWorker4.setImage(new Image("img/workers/miner.png"));
				imgWorker5.setImage(new Image("img/workers/lumberjack.png"));
				imgWorker6.setImage(new Image("img/workers/woodCutter.png"));
				imgWorker7.setImage(new Image("img/workers/farmer.png"));
				imgWorker8.setImage(new Image("img/workers/farmer.png"));
			} else if (storagePage == 2) {
				if (rank == 1) {
					storageResource1.setText("");
					storageResource2.setText("");
					storageResource3.setText("");
					storageResource4.setText("");
					storageResource5.setText("");
					storageResource6.setText("");
					storageResource7.setText("");
					storageResource8.setText("");
				} else if (rank == 2) {
					updateLabel(storageResource1,"Steak: ",steakWhole,cowRancher,steakMerchant*2);
					updateLabel(storageResource2,"Pork: ",porkWhole,pigRancher,porkMerchant*2);
					updateLabel(storageResource3,"Chicken: ",chickenWhole,chickenRancher,chickenMerchant*2);
					updateLabel(storageResource4,"Mutton: ",muttonWhole,sheepRancher,muttonMerchant*2);
					storageResource5.setText("");
					storageResource6.setText("");
					storageResource7.setText("");
					storageResource8.setText("");
				}
				
				updateLabel(storageWorker1,"Fish Merchants: ",fishMerchant);
				updateLabel(storageWorker2,"Coal Merchants: ",coalMerchant);
				updateLabel(storageWorker3,"Plank Merchants: ",plankMerchant);
				updateLabel(storageWorker4,"Cotton Merchants: ",cottonMerchant);
				if (rank == 1) {
					storageWorker5.setText("");
					storageWorker6.setText("");
					storageWorker7.setText("");
					storageWorker8.setText("");
				} else if (rank >= 2) {
					updateLabel(storageWorker5,"Cow Ranchers: ",cowRancher);
					updateLabel(storageWorker6,"Pig Ranchers: ",pigRancher);
					updateLabel(storageWorker7,"Chicken Ranchers: ",chickenRancher);
					updateLabel(storageWorker8,"Sheep Ranchers: ",sheepRancher);
				}
	
				if (rank == 1) {
					imgResource1.setImage(null);
					imgResource2.setImage(null);
					imgResource3.setImage(null);
					imgResource4.setImage(null);
					imgResource5.setImage(null);
					imgResource6.setImage(null);
					imgResource7.setImage(null);
					imgResource8.setImage(null);
					imgResource1.setVisible(false);
					imgResource2.setVisible(false);
					imgResource3.setVisible(false);
					imgResource4.setVisible(false);
					imgResource5.setVisible(false);
					imgResource6.setVisible(false);
					imgResource7.setVisible(false);
					imgResource8.setVisible(false);
				} else if (rank == 2) {
					imgResource1.setImage(new Image("img/resources/food/steak.png"));
					imgResource2.setImage(new Image("img/resources/food/pork.png"));
					imgResource3.setImage(new Image("img/resources/food/chicken.png"));
					imgResource4.setImage(new Image("img/resources/food/mutton.png"));
					imgResource5.setImage(null);
					imgResource6.setImage(null);
					imgResource7.setImage(null);
					imgResource8.setImage(null);
					imgResource1.setVisible(true);
					imgResource2.setVisible(true);
					imgResource3.setVisible(true);
					imgResource4.setVisible(true);
					imgResource5.setVisible(false);
					imgResource6.setVisible(false);
					imgResource7.setVisible(false);
					imgResource8.setVisible(false);
				}
	
				imgWorker1.setImage(new Image("img/workers/merchant.png"));
				imgWorker2.setImage(new Image("img/workers/merchant.png"));
				imgWorker3.setImage(new Image("img/workers/merchant.png"));
				imgWorker4.setImage(new Image("img/workers/merchant.png"));
				if (rank == 1) {
					imgWorker5.setImage(null);
					imgWorker6.setImage(null);
					imgWorker7.setImage(null);
					imgWorker8.setImage(null);
				}
				else if (rank >= 2) {
					imgWorker5.setImage(new Image("img/workers/farmer.png"));
					imgWorker6.setImage(new Image("img/workers/farmer.png"));
					imgWorker7.setImage(new Image("img/workers/farmer.png"));
					imgWorker8.setImage(new Image("img/workers/farmer.png"));
				}
			} else if (storagePage == 3) {
				if (rank == 2) {
					storageResource1.setText("");
					storageResource2.setText("");
					storageResource3.setText("");
					storageResource4.setText("");
					storageResource5.setText("");
					storageResource6.setText("");
					storageResource7.setText("");
					storageResource8.setText("");
				}
				updateLabel(storageWorker1,"Steak Merchants: ",steakMerchant);
				updateLabel(storageWorker2,"Pork Merchants: ",porkMerchant);
				updateLabel(storageWorker3,"Chicken Merchants: ",chickenMerchant);
				updateLabel(storageWorker4,"Mutton Merchants: ",muttonMerchant);
				if (rank == 2) {
					storageWorker5.setText("");
					storageWorker6.setText("");
					storageWorker7.setText("");
					storageWorker8.setText("");
				}
				if (rank == 2) {
					imgResource1.setImage(null);
					imgResource2.setImage(null);
					imgResource3.setImage(null);
					imgResource4.setImage(null);
					imgResource5.setImage(null);
					imgResource6.setImage(null);
					imgResource7.setImage(null);
					imgResource8.setImage(null);
					imgResource1.setVisible(false);
					imgResource2.setVisible(false);
					imgResource3.setVisible(false);
					imgResource4.setVisible(false);
					imgResource5.setVisible(false);
					imgResource6.setVisible(false);
					imgResource7.setVisible(false);
					imgResource8.setVisible(false);
				}
				
				imgWorker1.setImage(new Image("img/workers/merchant.png"));
				imgWorker2.setImage(new Image("img/workers/merchant.png"));
				imgWorker3.setImage(new Image("img/workers/merchant.png"));
				imgWorker4.setImage(new Image("img/workers/merchant.png"));
				if (rank == 2) {
					imgWorker5.setImage(null);
					imgWorker6.setImage(null);
					imgWorker7.setImage(null);
					imgWorker8.setImage(null);
				}
			}
		} catch (Exception e) {}
	}
	
	public void purchaseError(Label lbl) {
		lbl.setTextFill(Color.web("#ff0000"));
	}
	
	public void buyWorker1() {
		long resource = 0;
		long money = 0;
		long worker = 0;
		if (rank == 1) {
			if (currentPage == 1) {
				if (foodWhole >= 10 && moneyWhole >= 5) {
					resource = 10;
					money = 5;
					worker = 1;
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(foodWhole/10)) {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5);
							worker = ((long)Math.floor(moneyWhole/5))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5);
							worker = ((long)Math.floor(moneyWhole/5))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5);
							worker = (long)Math.floor(moneyWhole/5);
						}
					} else {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(foodWhole/10))/2)-((long)Math.floor(((long)Math.floor(foodWhole/10))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(foodWhole/10))/2)-((long)Math.floor(((long)Math.floor(foodWhole/10))/2)%5);
							worker = ((long)Math.floor(foodWhole/10))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(foodWhole/10))-((long)Math.floor(2.5*(long)Math.floor(foodWhole/10))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(foodWhole/10))-((long)Math.floor(2.5*(long)Math.floor(foodWhole/10))%5);
							worker = ((long)Math.floor(foodWhole/10))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(foodWhole/10))-((long)Math.floor(5*(long)Math.floor(foodWhole/10))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(foodWhole/10))-((long)Math.floor(5*(long)Math.floor(foodWhole/10))%5);
							worker = (long)Math.floor(foodWhole/10);
						}
					}
					if (multi == 2 && (foodWhole < 100 || moneyWhole < 50)) {
						resource = 10;
						money = 5;
						worker = 1;
					} else if (multi == 3 && (foodWhole < 20 || moneyWhole < 10)) {
						resource = 10;
						money = 5;
						worker = 1;
					}
					foodWhole -= resource;
					moneyWhole -= money;
					rancher += worker;
				} else {
					purchaseError(lblCost1);
					
					if (moneyWhole < 5) purchaseError(lblMoney);
					if (foodWhole < 10) purchaseError(itemAmount);
				}
			} else if (currentPage == 2) {
				if (fishWhole >= 10 && moneyWhole >= 5) {
					resource = 10;
					money = 5;
					worker = 1;
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(fishWhole/10)) {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5);
							worker = ((long)Math.floor(moneyWhole/5))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5);
							worker = ((long)Math.floor(moneyWhole/5))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5);
							worker = (long)Math.floor(moneyWhole/5);
						}
					} else {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(fishWhole/10))/2)-((long)Math.floor(((long)Math.floor(fishWhole/10))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(fishWhole/10))/2)-((long)Math.floor(((long)Math.floor(fishWhole/10))/2)%5);
							worker = ((long)Math.floor(fishWhole/10))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(fishWhole/10))-((long)Math.floor(2.5*(long)Math.floor(fishWhole/10))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(fishWhole/10))-((long)Math.floor(2.5*(long)Math.floor(fishWhole/10))%5);
							worker = ((long)Math.floor(fishWhole/10))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(fishWhole/10))-((long)Math.floor(5*(long)Math.floor(fishWhole/10))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(fishWhole/10))-((long)Math.floor(5*(long)Math.floor(fishWhole/10))%5);
							worker = (long)Math.floor(fishWhole/10);
						}
					}
					if (multi == 2 && (fishWhole < 100 || moneyWhole < 50)) {
						resource = 10;
						money = 5;
						worker = 1;
					} else if (multi == 3 && (fishWhole < 20 || moneyWhole < 10)) {
						resource = 10;
						money = 5;
						worker = 1;
					}
					fishWhole -= resource;
					moneyWhole -= money;
					fisher += worker;
				} else {
					purchaseError(lblCost2);
					
					if (moneyWhole < 5) purchaseError(lblMoney);
					if (fishWhole < 10) purchaseError(itemAmount);
				}
			} else if (currentPage == 3) {
				if (stoneWhole >= 10 && moneyWhole >= 5) {
					resource = 10;
					money = 5;
					worker = 1;
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(stoneWhole/10)) {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5);
							worker = ((long)Math.floor(moneyWhole/5))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5);
							worker = ((long)Math.floor(moneyWhole/5))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5);
							worker = (long)Math.floor(moneyWhole/5);
						}
					} else {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(stoneWhole/10))/2)-((long)Math.floor(((long)Math.floor(stoneWhole/10))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(stoneWhole/10))/2)-((long)Math.floor(((long)Math.floor(stoneWhole/10))/2)%5);
							worker = ((long)Math.floor(stoneWhole/10))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(stoneWhole/10))-((long)Math.floor(2.5*(long)Math.floor(stoneWhole/10))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(stoneWhole/10))-((long)Math.floor(2.5*(long)Math.floor(stoneWhole/10))%5);
							worker = ((long)Math.floor(stoneWhole/10))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(stoneWhole/10))-((long)Math.floor(5*(long)Math.floor(stoneWhole/10))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(stoneWhole/10))-((long)Math.floor(5*(long)Math.floor(stoneWhole/10))%5);
							worker = (long)Math.floor(stoneWhole/10);
						}
					}
					if (multi == 2 && (stoneWhole < 100 || moneyWhole < 50)) {
						resource = 10;
						money = 5;
						worker = 1;
					} else if (multi == 3 && (stoneWhole < 20 || moneyWhole < 10)) {
						resource = 10;
						money = 5;
						worker = 1;
					}
					stoneWhole -= resource;
					moneyWhole -= money;
					miner += worker;
				} else {
					purchaseError(lblCost1);
					
					if (moneyWhole < 5) purchaseError(lblMoney);
					if (stoneWhole < 10) purchaseError(itemAmount);
				}
			} else if (currentPage == 4) {
				if (coalWhole >= 10 && moneyWhole >= 5) {
					resource = 10;
					money = 5;
					worker = 1;
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(coalWhole/10)) {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5);
							worker = ((long)Math.floor(moneyWhole/5))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5);
							worker = ((long)Math.floor(moneyWhole/5))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5);
							worker = (long)Math.floor(moneyWhole/5);
						}
					} else {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(coalWhole/10))/2)-((long)Math.floor(((long)Math.floor(coalWhole/10))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(coalWhole/10))/2)-((long)Math.floor(((long)Math.floor(coalWhole/10))/2)%5);
							worker = ((long)Math.floor(coalWhole/10))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(coalWhole/10))-((long)Math.floor(2.5*(long)Math.floor(coalWhole/10))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(coalWhole/10))-((long)Math.floor(2.5*(long)Math.floor(coalWhole/10))%5);
							worker = ((long)Math.floor(coalWhole/10))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(coalWhole/10))-((long)Math.floor(5*(long)Math.floor(coalWhole/10))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(coalWhole/10))-((long)Math.floor(5*(long)Math.floor(coalWhole/10))%5);
							worker = (long)Math.floor(coalWhole/10);
						}
					}
					if (multi == 2 && (coalWhole < 100 || moneyWhole < 50)) {
						resource = 10;
						money = 5;
						worker = 1;
					} else if (multi == 3 && (coalWhole < 20 || moneyWhole < 10)) {
						resource = 10;
						money = 5;
						worker = 1;
					}
					coalWhole -= resource;
					moneyWhole -= money;
					coalMiner += worker;
				} else {
					purchaseError(lblCost2);
					
					if (moneyWhole < 5) purchaseError(lblMoney);
					if (coalWhole < 10) purchaseError(itemAmount);
				}
			} else if (currentPage == 5) {
				if (woodWhole >= 10 && moneyWhole >= 5) {
					resource = 10;
					money = 5;
					worker = 1;
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(woodWhole/10)) {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5);
							worker = ((long)Math.floor(moneyWhole/5))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5);
							worker = ((long)Math.floor(moneyWhole/5))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5);
							worker = (long)Math.floor(moneyWhole/5);
						}
					} else {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(woodWhole/10))/2)-((long)Math.floor(((long)Math.floor(woodWhole/10))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(woodWhole/10))/2)-((long)Math.floor(((long)Math.floor(woodWhole/10))/2)%5);
							worker = ((long)Math.floor(woodWhole/10))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(woodWhole/10))-((long)Math.floor(2.5*(long)Math.floor(woodWhole/10))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(woodWhole/10))-((long)Math.floor(2.5*(long)Math.floor(woodWhole/10))%5);
							worker = ((long)Math.floor(woodWhole/10))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(woodWhole/10))-((long)Math.floor(5*(long)Math.floor(woodWhole/10))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(woodWhole/10))-((long)Math.floor(5*(long)Math.floor(woodWhole/10))%5);
							worker = (long)Math.floor(woodWhole/10);
						}
					}
					if (multi == 2 && (woodWhole < 100 || moneyWhole < 50)) {
						resource = 10;
						money = 5;
						worker = 1;
					} else if (multi == 3 && (woodWhole < 20 || moneyWhole < 10)) {
						resource = 10;
						money = 5;
						worker = 1;
					}
					woodWhole -= resource;
					moneyWhole -= money;
					lumberjack += worker;
				} else {
					purchaseError(lblCost1);
					
					if (moneyWhole < 5) purchaseError(lblMoney);
					if (woodWhole < 10) purchaseError(itemAmount);
				}
			} else if (currentPage == 6) {
				if (plankWhole >= 10 && moneyWhole >= 5) {
					resource = 10;
					money = 5;
					worker = 1;
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(plankWhole/10)) {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5);
							worker = ((long)Math.floor(moneyWhole/5))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5);
							worker = ((long)Math.floor(moneyWhole/5))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5);
							worker = (long)Math.floor(moneyWhole/5);
						}
					} else {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(plankWhole/10))/2)-((long)Math.floor(((long)Math.floor(plankWhole/10))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(plankWhole/10))/2)-((long)Math.floor(((long)Math.floor(plankWhole/10))/2)%5);
							worker = ((long)Math.floor(plankWhole/10))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(plankWhole/10))-((long)Math.floor(2.5*(long)Math.floor(plankWhole/10))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(plankWhole/10))-((long)Math.floor(2.5*(long)Math.floor(plankWhole/10))%5);
							worker = ((long)Math.floor(plankWhole/10))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(plankWhole/10))-((long)Math.floor(5*(long)Math.floor(plankWhole/10))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(plankWhole/10))-((long)Math.floor(5*(long)Math.floor(plankWhole/10))%5);
							worker = (long)Math.floor(plankWhole/10);
						}
					}
					if (multi == 2 && (plankWhole < 100 || moneyWhole < 50)) {
						resource = 10;
						money = 5;
						worker = 1;
					} else if (multi == 3 && (plankWhole < 20 || moneyWhole < 10)) {
						resource = 10;
						money = 5;
						worker = 1;
					}
					plankWhole -= resource;
					moneyWhole -= money;
					woodCutter += worker;
				} else {
					purchaseError(lblCost2);
					
					if (moneyWhole < 5) purchaseError(lblMoney);
					if (plankWhole < 10) purchaseError(itemAmount);
				}
			} else if (currentPage == 7) {
				if (cropWhole >= 10 && moneyWhole >= 5) {
					resource = 10;
					money = 5;
					worker = 1;
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(cropWhole/10)) {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5);
							worker = ((long)Math.floor(moneyWhole/5))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5);
							worker = ((long)Math.floor(moneyWhole/5))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5);
							worker = (long)Math.floor(moneyWhole/5);
						}
					} else {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(cropWhole/10))/2)-((long)Math.floor(((long)Math.floor(cropWhole/10))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(cropWhole/10))/2)-((long)Math.floor(((long)Math.floor(cropWhole/10))/2)%5);
							worker = ((long)Math.floor(cropWhole/10))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(cropWhole/10))-((long)Math.floor(2.5*(long)Math.floor(cropWhole/10))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(cropWhole/10))-((long)Math.floor(2.5*(long)Math.floor(cropWhole/10))%5);
							worker = ((long)Math.floor(cropWhole/10))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(cropWhole/10))-((long)Math.floor(5*(long)Math.floor(cropWhole/10))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(cropWhole/10))-((long)Math.floor(5*(long)Math.floor(cropWhole/10))%5);
							worker = (long)Math.floor(cropWhole/10);
						}
					}
					if (multi == 2 && (cropWhole < 100 || moneyWhole < 50)) {
						resource = 10;
						money = 5;
						worker = 1;
					} else if (multi == 3 && (cropWhole < 20 || moneyWhole < 10)) {
						resource = 10;
						money = 5;
						worker = 1;
					}
					cropWhole -= resource;
					moneyWhole -= money;
					farmer += worker;
				} else {
					purchaseError(lblCost1);
					
					if (moneyWhole < 5) purchaseError(lblMoney);
					if (cropWhole < 10) purchaseError(itemAmount);
				}
			} else if (currentPage == 8) {
				if (cottonWhole >= 10 && moneyWhole >= 5) {
					resource = 10;
					money = 5;
					worker = 1;
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(cottonWhole/10)) {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5);
							worker = ((long)Math.floor(moneyWhole/5))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5);
							worker = ((long)Math.floor(moneyWhole/5))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5);
							worker = (long)Math.floor(moneyWhole/5);
						}
					} else {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(cottonWhole/10))/2)-((long)Math.floor(((long)Math.floor(cottonWhole/10))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(cottonWhole/10))/2)-((long)Math.floor(((long)Math.floor(cottonWhole/10))/2)%5);
							worker = ((long)Math.floor(cottonWhole/10))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(cottonWhole/10))-((long)Math.floor(2.5*(long)Math.floor(cottonWhole/10))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(cottonWhole/10))-((long)Math.floor(2.5*(long)Math.floor(cottonWhole/10))%5);
							worker = ((long)Math.floor(cottonWhole/10))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(cottonWhole/10))-((long)Math.floor(5*(long)Math.floor(cottonWhole/10))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(cottonWhole/10))-((long)Math.floor(5*(long)Math.floor(cottonWhole/10))%5);
							worker = (long)Math.floor(cottonWhole/10);
						}
					}
					if (multi == 2 && (cottonWhole < 100 || moneyWhole < 50)) {
						resource = 10;
						money = 5;
						worker = 1;
					} else if (multi == 3 && (cottonWhole < 20 || moneyWhole < 10)) {
						resource = 10;
						money = 5;
						worker = 1;
					}
					cottonWhole -= resource;
					moneyWhole -= money;
					cottonFarmer += worker;
				} else {
					purchaseError(lblCost2);
					
					if (moneyWhole < 5) purchaseError(lblMoney);
					if (cottonWhole < 10) purchaseError(itemAmount);
				}
			}
		} else if (rank == 2) {
			if (currentPage == 1) {
				if (foodWhole >= 10 && moneyWhole >= 5) {
					resource = 10;
					money = 5;
					worker = 1;
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(foodWhole/10)) {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5);
							worker = ((long)Math.floor(moneyWhole/5))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5);
							worker = ((long)Math.floor(moneyWhole/5))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5);
							worker = (long)Math.floor(moneyWhole/5);
						}
					} else {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(foodWhole/10))/2)-((long)Math.floor(((long)Math.floor(foodWhole/10))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(foodWhole/10))/2)-((long)Math.floor(((long)Math.floor(foodWhole/10))/2)%5);
							worker = ((long)Math.floor(foodWhole/10))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(foodWhole/10))-((long)Math.floor(2.5*(long)Math.floor(foodWhole/10))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(foodWhole/10))-((long)Math.floor(2.5*(long)Math.floor(foodWhole/10))%5);
							worker = ((long)Math.floor(foodWhole/10))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(foodWhole/10))-((long)Math.floor(5*(long)Math.floor(foodWhole/10))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(foodWhole/10))-((long)Math.floor(5*(long)Math.floor(foodWhole/10))%5);
							worker = (long)Math.floor(foodWhole/10);
						}
					}
					if (multi == 2 && (foodWhole < 100 || moneyWhole < 50)) {
						resource = 10;
						money = 5;
						worker = 1;
					} else if (multi == 3 && (foodWhole < 20 || moneyWhole < 10)) {
						resource = 10;
						money = 5;
						worker = 1;
					}
					foodWhole -= resource;
					moneyWhole -= money;
					rancher += worker;
				} else {
					purchaseError(lblCost1);
					
					if (moneyWhole < 5) purchaseError(lblMoney);
					if (foodWhole < 10) purchaseError(itemAmount);
				}
			} else if (currentPage == 2) {
				if (fishWhole >= 10 && moneyWhole >= 5) {
					resource = 10;
					money = 5;
					worker = 1;
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(fishWhole/10)) {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5);
							worker = ((long)Math.floor(moneyWhole/5))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5);
							worker = ((long)Math.floor(moneyWhole/5))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5);
							worker = (long)Math.floor(moneyWhole/5);
						}
					} else {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(fishWhole/10))/2)-((long)Math.floor(((long)Math.floor(fishWhole/10))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(fishWhole/10))/2)-((long)Math.floor(((long)Math.floor(fishWhole/10))/2)%5);
							worker = ((long)Math.floor(fishWhole/10))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(fishWhole/10))-((long)Math.floor(2.5*(long)Math.floor(fishWhole/10))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(fishWhole/10))-((long)Math.floor(2.5*(long)Math.floor(fishWhole/10))%5);
							worker = ((long)Math.floor(fishWhole/10))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(fishWhole/10))-((long)Math.floor(5*(long)Math.floor(fishWhole/10))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(fishWhole/10))-((long)Math.floor(5*(long)Math.floor(fishWhole/10))%5);
							worker = (long)Math.floor(fishWhole/10);
						}
					}
					if (multi == 2 && (fishWhole < 100 || moneyWhole < 50)) {
						resource = 10;
						money = 5;
						worker = 1;
					} else if (multi == 3 && (fishWhole < 20 || moneyWhole < 10)) {
						resource = 10;
						money = 5;
						worker = 1;
					}
					fishWhole -= resource;
					moneyWhole -= money;
					fisher += worker;
				} else {
					purchaseError(lblCost2);
					
					if (moneyWhole < 5) purchaseError(lblMoney);
					if (fishWhole < 10) purchaseError(itemAmount);
				}
			} else if (currentPage == 3) {
				if (steakWhole >= 10 && moneyWhole >= 5) {
					resource = 10;
					money = 5;
					worker = 1;
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(steakWhole/10)) {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5);
							worker = ((long)Math.floor(moneyWhole/5))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5);
							worker = ((long)Math.floor(moneyWhole/5))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5);
							worker = (long)Math.floor(moneyWhole/5);
						}
					} else {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(steakWhole/10))/2)-((long)Math.floor(((long)Math.floor(steakWhole/10))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(steakWhole/10))/2)-((long)Math.floor(((long)Math.floor(steakWhole/10))/2)%5);
							worker = ((long)Math.floor(steakWhole/10))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(steakWhole/10))-((long)Math.floor(2.5*(long)Math.floor(steakWhole/10))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(steakWhole/10))-((long)Math.floor(2.5*(long)Math.floor(steakWhole/10))%5);
							worker = ((long)Math.floor(steakWhole/10))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(steakWhole/10))-((long)Math.floor(5*(long)Math.floor(steakWhole/10))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(steakWhole/10))-((long)Math.floor(5*(long)Math.floor(steakWhole/10))%5);
							worker = (long)Math.floor(steakWhole/10);
						}
					}
					if (multi == 2 && (steakWhole < 100 || moneyWhole < 50)) {
						resource = 10;
						money = 5;
						worker = 1;
					} else if (multi == 3 && (steakWhole < 20 || moneyWhole < 10)) {
						resource = 10;
						money = 5;
						worker = 1;
					}
					steakWhole -= resource;
					moneyWhole -= money;
					cowRancher += worker;
				} else {
					purchaseError(lblCost2);
					
					if (moneyWhole < 5) purchaseError(lblMoney);
					if (steakWhole < 10) purchaseError(itemAmount);
				}
			} else if (currentPage == 4) {
				if (porkWhole >= 10 && moneyWhole >= 5) {
					resource = 10;
					money = 5;
					worker = 1;
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(porkWhole/10)) {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5);
							worker = ((long)Math.floor(moneyWhole/5))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5);
							worker = ((long)Math.floor(moneyWhole/5))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5);
							worker = (long)Math.floor(moneyWhole/5);
						}
					} else {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(porkWhole/10))/2)-((long)Math.floor(((long)Math.floor(porkWhole/10))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(porkWhole/10))/2)-((long)Math.floor(((long)Math.floor(porkWhole/10))/2)%5);
							worker = ((long)Math.floor(porkWhole/10))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(porkWhole/10))-((long)Math.floor(2.5*(long)Math.floor(porkWhole/10))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(porkWhole/10))-((long)Math.floor(2.5*(long)Math.floor(porkWhole/10))%5);
							worker = ((long)Math.floor(porkWhole/10))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(porkWhole/10))-((long)Math.floor(5*(long)Math.floor(porkWhole/10))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(porkWhole/10))-((long)Math.floor(5*(long)Math.floor(porkWhole/10))%5);
							worker = (long)Math.floor(porkWhole/10);
						}
					}
					if (multi == 2 && (porkWhole < 100 || moneyWhole < 50)) {
						resource = 10;
						money = 5;
						worker = 1;
					} else if (multi == 3 && (porkWhole < 20 || moneyWhole < 10)) {
						resource = 10;
						money = 5;
						worker = 1;
					}
					porkWhole -= resource;
					moneyWhole -= money;
					pigRancher += worker;
				} else {
					purchaseError(lblCost2);
					
					if (moneyWhole < 5) purchaseError(lblMoney);
					if (porkWhole < 10) purchaseError(itemAmount);
				}
			} else if (currentPage == 5) {
				if (chickenWhole >= 10 && moneyWhole >= 5) {
					resource = 10;
					money = 5;
					worker = 1;
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(chickenWhole/10)) {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5);
							worker = ((long)Math.floor(moneyWhole/5))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5);
							worker = ((long)Math.floor(moneyWhole/5))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5);
							worker = (long)Math.floor(moneyWhole/5);
						}
					} else {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(chickenWhole/10))/2)-((long)Math.floor(((long)Math.floor(chickenWhole/10))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(chickenWhole/10))/2)-((long)Math.floor(((long)Math.floor(chickenWhole/10))/2)%5);
							worker = ((long)Math.floor(chickenWhole/10))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(chickenWhole/10))-((long)Math.floor(2.5*(long)Math.floor(chickenWhole/10))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(chickenWhole/10))-((long)Math.floor(2.5*(long)Math.floor(chickenWhole/10))%5);
							worker = ((long)Math.floor(chickenWhole/10))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(chickenWhole/10))-((long)Math.floor(5*(long)Math.floor(chickenWhole/10))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(chickenWhole/10))-((long)Math.floor(5*(long)Math.floor(chickenWhole/10))%5);
							worker = (long)Math.floor(chickenWhole/10);
						}
					}
					if (multi == 2 && (chickenWhole < 100 || moneyWhole < 50)) {
						resource = 10;
						money = 5;
						worker = 1;
					} else if (multi == 3 && (chickenWhole < 20 || moneyWhole < 10)) {
						resource = 10;
						money = 5;
						worker = 1;
					}
					chickenWhole -= resource;
					moneyWhole -= money;
					chickenRancher += worker;
				} else {
					purchaseError(lblCost2);
					
					if (moneyWhole < 5) purchaseError(lblMoney);
					if (chickenWhole < 10) purchaseError(itemAmount);
				}
			} else if (currentPage == 6) {
				if (muttonWhole >= 10 && moneyWhole >= 5) {
					resource = 10;
					money = 5;
					worker = 1;
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(muttonWhole/10)) {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5);
							worker = ((long)Math.floor(moneyWhole/5))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5);
							worker = ((long)Math.floor(moneyWhole/5))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5);
							worker = (long)Math.floor(moneyWhole/5);
						}
					} else {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(muttonWhole/10))/2)-((long)Math.floor(((long)Math.floor(muttonWhole/10))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(muttonWhole/10))/2)-((long)Math.floor(((long)Math.floor(muttonWhole/10))/2)%5);
							worker = ((long)Math.floor(muttonWhole/10))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(muttonWhole/10))-((long)Math.floor(2.5*(long)Math.floor(muttonWhole/10))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(muttonWhole/10))-((long)Math.floor(2.5*(long)Math.floor(muttonWhole/10))%5);
							worker = ((long)Math.floor(muttonWhole/10))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(muttonWhole/10))-((long)Math.floor(5*(long)Math.floor(muttonWhole/10))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(muttonWhole/10))-((long)Math.floor(5*(long)Math.floor(muttonWhole/10))%5);
							worker = (long)Math.floor(muttonWhole/10);
						}
					}
					if (multi == 2 && (muttonWhole < 100 || moneyWhole < 50)) {
						resource = 10;
						money = 5;
						worker = 1;
					} else if (multi == 3 && (muttonWhole < 20 || moneyWhole < 10)) {
						resource = 10;
						money = 5;
						worker = 1;
					}
					muttonWhole -= resource;
					moneyWhole -= money;
					sheepRancher += worker;
				} else {
					purchaseError(lblCost2);
					
					if (moneyWhole < 5) purchaseError(lblMoney);
					if (muttonWhole < 10) purchaseError(itemAmount);
				}
			} else if (currentPage == 7) {
				if (stoneWhole >= 10 && moneyWhole >= 5) {
					resource = 10;
					money = 5;
					worker = 1;
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(stoneWhole/10)) {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5);
							worker = ((long)Math.floor(moneyWhole/5))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5);
							worker = ((long)Math.floor(moneyWhole/5))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5);
							worker = (long)Math.floor(moneyWhole/5);
						}
					} else {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(stoneWhole/10))/2)-((long)Math.floor(((long)Math.floor(stoneWhole/10))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(stoneWhole/10))/2)-((long)Math.floor(((long)Math.floor(stoneWhole/10))/2)%5);
							worker = ((long)Math.floor(stoneWhole/10))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(stoneWhole/10))-((long)Math.floor(2.5*(long)Math.floor(stoneWhole/10))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(stoneWhole/10))-((long)Math.floor(2.5*(long)Math.floor(stoneWhole/10))%5);
							worker = ((long)Math.floor(stoneWhole/10))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(stoneWhole/10))-((long)Math.floor(5*(long)Math.floor(stoneWhole/10))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(stoneWhole/10))-((long)Math.floor(5*(long)Math.floor(stoneWhole/10))%5);
							worker = (long)Math.floor(stoneWhole/10);
						}
					}
					if (multi == 2 && (stoneWhole < 100 || moneyWhole < 50)) {
						resource = 10;
						money = 5;
						worker = 1;
					} else if (multi == 3 && (stoneWhole < 20 || moneyWhole < 10)) {
						resource = 10;
						money = 5;
						worker = 1;
					}
					stoneWhole -= resource;
					moneyWhole -= money;
					miner += worker;
				} else {
					purchaseError(lblCost1);
					
					if (moneyWhole < 5) purchaseError(lblMoney);
					if (stoneWhole < 10) purchaseError(itemAmount);
				}
			} else if (currentPage == 8) {
				if (coalWhole >= 10 && moneyWhole >= 5) {
					resource = 10;
					money = 5;
					worker = 1;
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(coalWhole/10)) {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5);
							worker = ((long)Math.floor(moneyWhole/5))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5);
							worker = ((long)Math.floor(moneyWhole/5))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5);
							worker = (long)Math.floor(moneyWhole/5);
						}
					} else {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(coalWhole/10))/2)-((long)Math.floor(((long)Math.floor(coalWhole/10))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(coalWhole/10))/2)-((long)Math.floor(((long)Math.floor(coalWhole/10))/2)%5);
							worker = ((long)Math.floor(coalWhole/10))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(coalWhole/10))-((long)Math.floor(2.5*(long)Math.floor(coalWhole/10))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(coalWhole/10))-((long)Math.floor(2.5*(long)Math.floor(coalWhole/10))%5);
							worker = ((long)Math.floor(coalWhole/10))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(coalWhole/10))-((long)Math.floor(5*(long)Math.floor(coalWhole/10))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(coalWhole/10))-((long)Math.floor(5*(long)Math.floor(coalWhole/10))%5);
							worker = (long)Math.floor(coalWhole/10);
						}
					}
					if (multi == 2 && (coalWhole < 100 || moneyWhole < 50)) {
						resource = 10;
						money = 5;
						worker = 1;
					} else if (multi == 3 && (coalWhole < 20 || moneyWhole < 10)) {
						resource = 10;
						money = 5;
						worker = 1;
					}
					coalWhole -= resource;
					moneyWhole -= money;
					coalMiner += worker;
				} else {
					purchaseError(lblCost2);
					
					if (moneyWhole < 5) purchaseError(lblMoney);
					if (coalWhole < 10) purchaseError(itemAmount);
				}
			} else if (currentPage == 9) {
				if (woodWhole >= 10 && moneyWhole >= 5) {
					resource = 10;
					money = 5;
					worker = 1;
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(woodWhole/10)) {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5);
							worker = ((long)Math.floor(moneyWhole/5))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5);
							worker = ((long)Math.floor(moneyWhole/5))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5);
							worker = (long)Math.floor(moneyWhole/5);
						}
					} else {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(woodWhole/10))/2)-((long)Math.floor(((long)Math.floor(woodWhole/10))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(woodWhole/10))/2)-((long)Math.floor(((long)Math.floor(woodWhole/10))/2)%5);
							worker = ((long)Math.floor(woodWhole/10))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(woodWhole/10))-((long)Math.floor(2.5*(long)Math.floor(woodWhole/10))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(woodWhole/10))-((long)Math.floor(2.5*(long)Math.floor(woodWhole/10))%5);
							worker = ((long)Math.floor(woodWhole/10))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(woodWhole/10))-((long)Math.floor(5*(long)Math.floor(woodWhole/10))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(woodWhole/10))-((long)Math.floor(5*(long)Math.floor(woodWhole/10))%5);
							worker = (long)Math.floor(woodWhole/10);
						}
					}
					if (multi == 2 && (woodWhole < 100 || moneyWhole < 50)) {
						resource = 10;
						money = 5;
						worker = 1;
					} else if (multi == 3 && (woodWhole < 20 || moneyWhole < 10)) {
						resource = 10;
						money = 5;
						worker = 1;
					}
					woodWhole -= resource;
					moneyWhole -= money;
					lumberjack += worker;
				} else {
					purchaseError(lblCost1);
					
					if (moneyWhole < 5) purchaseError(lblMoney);
					if (woodWhole < 10) purchaseError(itemAmount);
				}
			} else if (currentPage == 10) {
				if (plankWhole >= 10 && moneyWhole >= 5) {
					resource = 10;
					money = 5;
					worker = 1;
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(plankWhole/10)) {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5);
							worker = ((long)Math.floor(moneyWhole/5))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5);
							worker = ((long)Math.floor(moneyWhole/5))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5);
							worker = (long)Math.floor(moneyWhole/5);
						}
					} else {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(plankWhole/10))/2)-((long)Math.floor(((long)Math.floor(plankWhole/10))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(plankWhole/10))/2)-((long)Math.floor(((long)Math.floor(plankWhole/10))/2)%5);
							worker = ((long)Math.floor(plankWhole/10))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(plankWhole/10))-((long)Math.floor(2.5*(long)Math.floor(plankWhole/10))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(plankWhole/10))-((long)Math.floor(2.5*(long)Math.floor(plankWhole/10))%5);
							worker = ((long)Math.floor(plankWhole/10))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(plankWhole/10))-((long)Math.floor(5*(long)Math.floor(plankWhole/10))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(plankWhole/10))-((long)Math.floor(5*(long)Math.floor(plankWhole/10))%5);
							worker = (long)Math.floor(plankWhole/10);
						}
					}
					if (multi == 2 && (plankWhole < 100 || moneyWhole < 50)) {
						resource = 10;
						money = 5;
						worker = 1;
					} else if (multi == 3 && (plankWhole < 20 || moneyWhole < 10)) {
						resource = 10;
						money = 5;
						worker = 1;
					}
					plankWhole -= resource;
					moneyWhole -= money;
					woodCutter += worker;
				} else {
					purchaseError(lblCost2);
					
					if (moneyWhole < 5) purchaseError(lblMoney);
					if (plankWhole < 10) purchaseError(itemAmount);
				}
			} else if (currentPage == 11) {
				if (cropWhole >= 10 && moneyWhole >= 5) {
					resource = 10;
					money = 5;
					worker = 1;
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(cropWhole/10)) {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5);
							worker = ((long)Math.floor(moneyWhole/5))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5);
							worker = ((long)Math.floor(moneyWhole/5))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5);
							worker = (long)Math.floor(moneyWhole/5);
						}
					} else {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(cropWhole/10))/2)-((long)Math.floor(((long)Math.floor(cropWhole/10))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(cropWhole/10))/2)-((long)Math.floor(((long)Math.floor(cropWhole/10))/2)%5);
							worker = ((long)Math.floor(cropWhole/10))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(cropWhole/10))-((long)Math.floor(2.5*(long)Math.floor(cropWhole/10))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(cropWhole/10))-((long)Math.floor(2.5*(long)Math.floor(cropWhole/10))%5);
							worker = ((long)Math.floor(cropWhole/10))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(cropWhole/10))-((long)Math.floor(5*(long)Math.floor(cropWhole/10))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(cropWhole/10))-((long)Math.floor(5*(long)Math.floor(cropWhole/10))%5);
							worker = (long)Math.floor(cropWhole/10);
						}
					}
					if (multi == 2 && (cropWhole < 100 || moneyWhole < 50)) {
						resource = 10;
						money = 5;
						worker = 1;
					} else if (multi == 3 && (cropWhole < 20 || moneyWhole < 10)) {
						resource = 10;
						money = 5;
						worker = 1;
					}
					cropWhole -= resource;
					moneyWhole -= money;
					farmer += worker;
				} else {
					purchaseError(lblCost1);
					
					if (moneyWhole < 5) purchaseError(lblMoney);
					if (cropWhole < 10) purchaseError(itemAmount);
				}
			} else if (currentPage == 12) {
				if (cottonWhole >= 10 && moneyWhole >= 5) {
					resource = 10;
					money = 5;
					worker = 1;
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(cottonWhole/10)) {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5);
							worker = ((long)Math.floor(moneyWhole/5))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5);
							worker = ((long)Math.floor(moneyWhole/5))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5);
							worker = (long)Math.floor(moneyWhole/5);
						}
					} else {
						if (multi == 1) {
							resource = 10;
							money = 5;
							worker = 1;
						} else if (multi == 2) {
							resource = ((long)Math.floor(((long)Math.floor(cottonWhole/10))/2)-((long)Math.floor(((long)Math.floor(cottonWhole/10))/2)%5))*2;
							money = (long)Math.floor(((long)Math.floor(cottonWhole/10))/2)-((long)Math.floor(((long)Math.floor(cottonWhole/10))/2)%5);
							worker = ((long)Math.floor(cottonWhole/10))/10;
						} else if (multi == 3) {
							resource = ((long)Math.floor(2.5*(long)Math.floor(cottonWhole/10))-((long)Math.floor(2.5*(long)Math.floor(cottonWhole/10))%5))*2;
							money = (long)Math.floor(2.5*(long)Math.floor(cottonWhole/10))-((long)Math.floor(2.5*(long)Math.floor(cottonWhole/10))%5);
							worker = ((long)Math.floor(cottonWhole/10))/2;
						} else {
							resource = ((long)Math.floor(5*(long)Math.floor(cottonWhole/10))-((long)Math.floor(5*(long)Math.floor(cottonWhole/10))%5))*2;
							money = (long)Math.floor(5*(long)Math.floor(cottonWhole/10))-((long)Math.floor(5*(long)Math.floor(cottonWhole/10))%5);
							worker = (long)Math.floor(cottonWhole/10);
						}
					}
					if (multi == 2 && (cottonWhole < 100 || moneyWhole < 50)) {
						resource = 10;
						money = 5;
						worker = 1;
					} else if (multi == 3 && (cottonWhole < 20 || moneyWhole < 10)) {
						resource = 10;
						money = 5;
						worker = 1;
					}
					cottonWhole -= resource;
					moneyWhole -= money;
					cottonFarmer += worker;
				} else {
					purchaseError(lblCost2);
					
					if (moneyWhole < 5) purchaseError(lblMoney);
					if (cottonWhole < 10) purchaseError(itemAmount);
				}
			}
		}
	}
	
	public void buyWorker2() {
		long resource = 0;
		long money = 0;
		long worker = 0;
		if (rank == 1) {
			if (currentPage == 2) {
				if (fishWhole >= 5 && moneyWhole >= 10) {
					resource = 5;
					money = 10;
					worker = 1;
					if ((long)Math.floor(moneyWhole/10) < (long)Math.floor(fishWhole/5)) {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = (long)Math.floor(moneyWhole/10);
						}
					} else {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(fishWhole/5))/2)-((long)Math.floor(((long)Math.floor(fishWhole/5))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(fishWhole/5))/2)-((long)Math.floor(((long)Math.floor(fishWhole/5))/2)%5))*2;
							worker = ((long)Math.floor(fishWhole/5))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(fishWhole/5))-((long)Math.floor(2.5*(long)Math.floor(fishWhole/5))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(fishWhole/5))-((long)Math.floor(2.5*(long)Math.floor(fishWhole/5))%5))*2;
							worker = ((long)Math.floor(fishWhole/5))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(fishWhole/5))-((long)Math.floor(5*(long)Math.floor(fishWhole/5))%5);
							money = ((long)Math.floor(5*(long)Math.floor(fishWhole/5))-((long)Math.floor(5*(long)Math.floor(fishWhole/5))%5))*2;
							worker = (long)Math.floor(fishWhole/5);
						}
					}
					if (multi == 2 && (fishWhole < 50 || moneyWhole < 100)) {
						resource = 5;
						money = 10;
						worker = 1;
					} else if (multi == 3 && (fishWhole < 10 || moneyWhole < 20)) {
						resource = 5;
						money = 10;
						worker = 1;
					}
					fishWhole -= resource;
					moneyWhole -= money;
					fishMerchant += worker;
				} else {
					purchaseError(lblCost3);
					
					if (moneyWhole < 10) purchaseError(lblMoney);
					if (fishWhole < 5) purchaseError(itemAmount);
				}
			} else if (currentPage == 4) {
				if (coalWhole >= 5 && moneyWhole >= 10) {
					resource = 5;
					money = 10;
					worker = 1;
					if ((long)Math.floor(moneyWhole/10) < (long)Math.floor(coalWhole/5)) {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = (long)Math.floor(moneyWhole/10);
						}
					} else {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(coalWhole/5))/2)-((long)Math.floor(((long)Math.floor(coalWhole/5))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(coalWhole/5))/2)-((long)Math.floor(((long)Math.floor(coalWhole/5))/2)%5))*2;
							worker = ((long)Math.floor(coalWhole/5))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(coalWhole/5))-((long)Math.floor(2.5*(long)Math.floor(coalWhole/5))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(coalWhole/5))-((long)Math.floor(2.5*(long)Math.floor(coalWhole/5))%5))*2;
							worker = ((long)Math.floor(coalWhole/5))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(coalWhole/5))-((long)Math.floor(5*(long)Math.floor(coalWhole/5))%5);
							money = ((long)Math.floor(5*(long)Math.floor(coalWhole/5))-((long)Math.floor(5*(long)Math.floor(coalWhole/5))%5))*2;
							worker = (long)Math.floor(coalWhole/5);
						}
					}
					if (multi == 2 && (coalWhole < 50 || moneyWhole < 100)) {
						resource = 5;
						money = 10;
						worker = 1;
					} else if (multi == 3 && (coalWhole < 10 || moneyWhole < 20)) {
						resource = 5;
						money = 10;
						worker = 1;
					}
					coalWhole -= resource;
					moneyWhole -= money;
					coalMerchant += worker;
				} else {
					purchaseError(lblCost3);
					
					if (moneyWhole < 10) purchaseError(lblMoney);
					if (coalWhole < 5) purchaseError(itemAmount);
				}
			} else if (currentPage == 6) {
				if (plankWhole >= 5 && moneyWhole >= 10) {
					resource = 5;
					money = 10;
					worker = 1;
					if ((long)Math.floor(moneyWhole/10) < (long)Math.floor(plankWhole/5)) {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = (long)Math.floor(moneyWhole/10);
						}
					} else {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(plankWhole/5))/2)-((long)Math.floor(((long)Math.floor(plankWhole/5))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(plankWhole/5))/2)-((long)Math.floor(((long)Math.floor(plankWhole/5))/2)%5))*2;
							worker = ((long)Math.floor(plankWhole/5))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(plankWhole/5))-((long)Math.floor(2.5*(long)Math.floor(plankWhole/5))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(plankWhole/5))-((long)Math.floor(2.5*(long)Math.floor(plankWhole/5))%5))*2;
							worker = ((long)Math.floor(plankWhole/5))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(plankWhole/5))-((long)Math.floor(5*(long)Math.floor(plankWhole/5))%5);
							money = ((long)Math.floor(5*(long)Math.floor(plankWhole/5))-((long)Math.floor(5*(long)Math.floor(plankWhole/5))%5))*2;
							worker = (long)Math.floor(plankWhole/5);
						}
					}
					if (multi == 2 && (plankWhole < 50 || moneyWhole < 100)) {
						resource = 5;
						money = 10;
						worker = 1;
					} else if (multi == 3 && (plankWhole < 10 || moneyWhole < 20)) {
						resource = 5;
						money = 10;
						worker = 1;
					}
					plankWhole -= resource;
					moneyWhole -= money;
					plankMerchant += worker;
				} else {
					purchaseError(lblCost3);
					
					if (moneyWhole < 10) purchaseError(lblMoney);
					if (plankWhole < 5) purchaseError(itemAmount);
				}
			} else if (currentPage == 8) {
				if (cottonWhole >= 5 && moneyWhole >= 10) {
					resource = 5;
					money = 10;
					worker = 1;
					if ((long)Math.floor(moneyWhole/10) < (long)Math.floor(cottonWhole/5)) {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = (long)Math.floor(moneyWhole/10);
						}
					} else {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(cottonWhole/5))/2)-((long)Math.floor(((long)Math.floor(cottonWhole/5))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(cottonWhole/5))/2)-((long)Math.floor(((long)Math.floor(cottonWhole/5))/2)%5))*2;
							worker = ((long)Math.floor(cottonWhole/5))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(cottonWhole/5))-((long)Math.floor(2.5*(long)Math.floor(cottonWhole/5))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(cottonWhole/5))-((long)Math.floor(2.5*(long)Math.floor(cottonWhole/5))%5))*2;
							worker = ((long)Math.floor(cottonWhole/5))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(cottonWhole/5))-((long)Math.floor(5*(long)Math.floor(cottonWhole/5))%5);
							money = ((long)Math.floor(5*(long)Math.floor(cottonWhole/5))-((long)Math.floor(5*(long)Math.floor(cottonWhole/5))%5))*2;
							worker = (long)Math.floor(cottonWhole/5);
						}
					}
					if (multi == 2 && (cottonWhole < 50 || moneyWhole < 100)) {
						resource = 5;
						money = 10;
						worker = 1;
					} else if (multi == 3 && (cottonWhole < 10 || moneyWhole < 20)) {
						resource = 5;
						money = 10;
						worker = 1;
					}
					cottonWhole -= resource;
					moneyWhole -= money;
					cottonMerchant += worker;
				} else {
					purchaseError(lblCost3);
					
					if (moneyWhole < 10) purchaseError(lblMoney);
					if (cottonWhole < 5) purchaseError(itemAmount);
				}
			}
		} else if (rank == 2) {
			if (currentPage == 2) {
				if (fishWhole >= 5 && moneyWhole >= 10) {
					resource = 5;
					money = 10;
					worker = 1;
					if ((long)Math.floor(moneyWhole/10) < (long)Math.floor(fishWhole/5)) {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = (long)Math.floor(moneyWhole/10);
						}
					} else {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(fishWhole/5))/2)-((long)Math.floor(((long)Math.floor(fishWhole/5))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(fishWhole/5))/2)-((long)Math.floor(((long)Math.floor(fishWhole/5))/2)%5))*2;
							worker = ((long)Math.floor(fishWhole/5))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(fishWhole/5))-((long)Math.floor(2.5*(long)Math.floor(fishWhole/5))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(fishWhole/5))-((long)Math.floor(2.5*(long)Math.floor(fishWhole/5))%5))*2;
							worker = ((long)Math.floor(fishWhole/5))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(fishWhole/5))-((long)Math.floor(5*(long)Math.floor(fishWhole/5))%5);
							money = ((long)Math.floor(5*(long)Math.floor(fishWhole/5))-((long)Math.floor(5*(long)Math.floor(fishWhole/5))%5))*2;
							worker = (long)Math.floor(fishWhole/5);
						}
					}
					if (multi == 2 && (fishWhole < 50 || moneyWhole < 100)) {
						resource = 5;
						money = 10;
						worker = 1;
					} else if (multi == 3 && (fishWhole < 10 || moneyWhole < 20)) {
						resource = 5;
						money = 10;
						worker = 1;
					}
					fishWhole -= resource;
					moneyWhole -= money;
					fishMerchant += worker;
				} else {
					purchaseError(lblCost3);
					
					if (moneyWhole < 10) purchaseError(lblMoney);
					if (fishWhole < 5) purchaseError(itemAmount);
				}
			} else if (currentPage == 3) {
				if (steakWhole >= 5 && moneyWhole >= 10) {
					resource = 5;
					money = 10;
					worker = 1;
					if ((long)Math.floor(moneyWhole/10) < (long)Math.floor(steakWhole/5)) {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = (long)Math.floor(moneyWhole/10);
						}
					} else {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(steakWhole/5))/2)-((long)Math.floor(((long)Math.floor(steakWhole/5))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(steakWhole/5))/2)-((long)Math.floor(((long)Math.floor(steakWhole/5))/2)%5))*2;
							worker = ((long)Math.floor(steakWhole/5))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(steakWhole/5))-((long)Math.floor(2.5*(long)Math.floor(steakWhole/5))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(steakWhole/5))-((long)Math.floor(2.5*(long)Math.floor(steakWhole/5))%5))*2;
							worker = ((long)Math.floor(steakWhole/5))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(steakWhole/5))-((long)Math.floor(5*(long)Math.floor(steakWhole/5))%5);
							money = ((long)Math.floor(5*(long)Math.floor(steakWhole/5))-((long)Math.floor(5*(long)Math.floor(steakWhole/5))%5))*2;
							worker = (long)Math.floor(steakWhole/5);
						}
					}
					if (multi == 2 && (steakWhole < 50 || moneyWhole < 100)) {
						resource = 5;
						money = 10;
						worker = 1;
					} else if (multi == 3 && (steakWhole < 10 || moneyWhole < 20)) {
						resource = 5;
						money = 10;
						worker = 1;
					}
					steakWhole -= resource;
					moneyWhole -= money;
					steakMerchant += worker;
				} else {
					purchaseError(lblCost3);
					
					if (moneyWhole < 10) purchaseError(lblMoney);
					if (steakWhole < 5) purchaseError(itemAmount);
				}
			} else if (currentPage == 4) {
				if (porkWhole >= 5 && moneyWhole >= 10) {
					resource = 5;
					money = 10;
					worker = 1;
					if ((long)Math.floor(moneyWhole/10) < (long)Math.floor(porkWhole/5)) {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = (long)Math.floor(moneyWhole/10);
						}
					} else {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(porkWhole/5))/2)-((long)Math.floor(((long)Math.floor(porkWhole/5))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(porkWhole/5))/2)-((long)Math.floor(((long)Math.floor(porkWhole/5))/2)%5))*2;
							worker = ((long)Math.floor(porkWhole/5))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(porkWhole/5))-((long)Math.floor(2.5*(long)Math.floor(porkWhole/5))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(porkWhole/5))-((long)Math.floor(2.5*(long)Math.floor(porkWhole/5))%5))*2;
							worker = ((long)Math.floor(porkWhole/5))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(porkWhole/5))-((long)Math.floor(5*(long)Math.floor(porkWhole/5))%5);
							money = ((long)Math.floor(5*(long)Math.floor(porkWhole/5))-((long)Math.floor(5*(long)Math.floor(porkWhole/5))%5))*2;
							worker = (long)Math.floor(porkWhole/5);
						}
					}
					if (multi == 2 && (porkWhole < 50 || moneyWhole < 100)) {
						resource = 5;
						money = 10;
						worker = 1;
					} else if (multi == 3 && (porkWhole < 10 || moneyWhole < 20)) {
						resource = 5;
						money = 10;
						worker = 1;
					}
					porkWhole -= resource;
					moneyWhole -= money;
					porkMerchant += worker;
				} else {
					purchaseError(lblCost3);
					
					if (moneyWhole < 10) purchaseError(lblMoney);
					if (porkWhole < 5) purchaseError(itemAmount);
				}
			} else if (currentPage == 5) {
				if (chickenWhole >= 5 && moneyWhole >= 10) {
					resource = 5;
					money = 10;
					worker = 1;
					if ((long)Math.floor(moneyWhole/10) < (long)Math.floor(chickenWhole/5)) {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = (long)Math.floor(moneyWhole/10);
						}
					} else {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(chickenWhole/5))/2)-((long)Math.floor(((long)Math.floor(chickenWhole/5))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(chickenWhole/5))/2)-((long)Math.floor(((long)Math.floor(chickenWhole/5))/2)%5))*2;
							worker = ((long)Math.floor(chickenWhole/5))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(chickenWhole/5))-((long)Math.floor(2.5*(long)Math.floor(chickenWhole/5))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(chickenWhole/5))-((long)Math.floor(2.5*(long)Math.floor(chickenWhole/5))%5))*2;
							worker = ((long)Math.floor(chickenWhole/5))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(chickenWhole/5))-((long)Math.floor(5*(long)Math.floor(chickenWhole/5))%5);
							money = ((long)Math.floor(5*(long)Math.floor(chickenWhole/5))-((long)Math.floor(5*(long)Math.floor(chickenWhole/5))%5))*2;
							worker = (long)Math.floor(chickenWhole/5);
						}
					}
					if (multi == 2 && (chickenWhole < 50 || moneyWhole < 100)) {
						resource = 5;
						money = 10;
						worker = 1;
					} else if (multi == 3 && (chickenWhole < 10 || moneyWhole < 20)) {
						resource = 5;
						money = 10;
						worker = 1;
					}
					chickenWhole -= resource;
					moneyWhole -= money;
					chickenMerchant += worker;
				} else {
					purchaseError(lblCost3);
					
					if (moneyWhole < 10) purchaseError(lblMoney);
					if (chickenWhole < 5) purchaseError(itemAmount);
				}
			} else if (currentPage == 6) {
				if (muttonWhole >= 5 && moneyWhole >= 10) {
					resource = 5;
					money = 10;
					worker = 1;
					if ((long)Math.floor(moneyWhole/10) < (long)Math.floor(muttonWhole/5)) {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = (long)Math.floor(moneyWhole/10);
						}
					} else {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(muttonWhole/5))/2)-((long)Math.floor(((long)Math.floor(muttonWhole/5))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(muttonWhole/5))/2)-((long)Math.floor(((long)Math.floor(muttonWhole/5))/2)%5))*2;
							worker = ((long)Math.floor(muttonWhole/5))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(muttonWhole/5))-((long)Math.floor(2.5*(long)Math.floor(muttonWhole/5))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(muttonWhole/5))-((long)Math.floor(2.5*(long)Math.floor(muttonWhole/5))%5))*2;
							worker = ((long)Math.floor(muttonWhole/5))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(muttonWhole/5))-((long)Math.floor(5*(long)Math.floor(muttonWhole/5))%5);
							money = ((long)Math.floor(5*(long)Math.floor(muttonWhole/5))-((long)Math.floor(5*(long)Math.floor(muttonWhole/5))%5))*2;
							worker = (long)Math.floor(muttonWhole/5);
						}
					}
					if (multi == 2 && (muttonWhole < 50 || moneyWhole < 100)) {
						resource = 5;
						money = 10;
						worker = 1;
					} else if (multi == 3 && (muttonWhole < 10 || moneyWhole < 20)) {
						resource = 5;
						money = 10;
						worker = 1;
					}
					muttonWhole -= resource;
					moneyWhole -= money;
					muttonMerchant += worker;
				} else {
					purchaseError(lblCost3);
					
					if (moneyWhole < 10) purchaseError(lblMoney);
					if (muttonWhole < 5) purchaseError(itemAmount);
				}
			} else if (currentPage == 8) {
				if (coalWhole >= 5 && moneyWhole >= 10) {
					resource = 5;
					money = 10;
					worker = 1;
					if ((long)Math.floor(moneyWhole/10) < (long)Math.floor(coalWhole/5)) {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = (long)Math.floor(moneyWhole/10);
						}
					} else {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(coalWhole/5))/2)-((long)Math.floor(((long)Math.floor(coalWhole/5))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(coalWhole/5))/2)-((long)Math.floor(((long)Math.floor(coalWhole/5))/2)%5))*2;
							worker = ((long)Math.floor(coalWhole/5))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(coalWhole/5))-((long)Math.floor(2.5*(long)Math.floor(coalWhole/5))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(coalWhole/5))-((long)Math.floor(2.5*(long)Math.floor(coalWhole/5))%5))*2;
							worker = ((long)Math.floor(coalWhole/5))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(coalWhole/5))-((long)Math.floor(5*(long)Math.floor(coalWhole/5))%5);
							money = ((long)Math.floor(5*(long)Math.floor(coalWhole/5))-((long)Math.floor(5*(long)Math.floor(coalWhole/5))%5))*2;
							worker = (long)Math.floor(coalWhole/5);
						}
					}
					if (multi == 2 && (coalWhole < 50 || moneyWhole < 100)) {
						resource = 5;
						money = 10;
						worker = 1;
					} else if (multi == 3 && (coalWhole < 10 || moneyWhole < 20)) {
						resource = 5;
						money = 10;
						worker = 1;
					}
					coalWhole -= resource;
					moneyWhole -= money;
					coalMerchant += worker;
				} else {
					purchaseError(lblCost3);
					
					if (moneyWhole < 10) purchaseError(lblMoney);
					if (coalWhole < 5) purchaseError(itemAmount);
				}
			} else if (currentPage == 10) {
				if (plankWhole >= 5 && moneyWhole >= 10) {
					resource = 5;
					money = 10;
					worker = 1;
					if ((long)Math.floor(moneyWhole/10) < (long)Math.floor(plankWhole/5)) {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = (long)Math.floor(moneyWhole/10);
						}
					} else {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(plankWhole/5))/2)-((long)Math.floor(((long)Math.floor(plankWhole/5))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(plankWhole/5))/2)-((long)Math.floor(((long)Math.floor(plankWhole/5))/2)%5))*2;
							worker = ((long)Math.floor(plankWhole/5))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(plankWhole/5))-((long)Math.floor(2.5*(long)Math.floor(plankWhole/5))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(plankWhole/5))-((long)Math.floor(2.5*(long)Math.floor(plankWhole/5))%5))*2;
							worker = ((long)Math.floor(plankWhole/5))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(plankWhole/5))-((long)Math.floor(5*(long)Math.floor(plankWhole/5))%5);
							money = ((long)Math.floor(5*(long)Math.floor(plankWhole/5))-((long)Math.floor(5*(long)Math.floor(plankWhole/5))%5))*2;
							worker = (long)Math.floor(plankWhole/5);
						}
					}
					if (multi == 2 && (plankWhole < 50 || moneyWhole < 100)) {
						resource = 5;
						money = 10;
						worker = 1;
					} else if (multi == 3 && (plankWhole < 10 || moneyWhole < 20)) {
						resource = 5;
						money = 10;
						worker = 1;
					}
					plankWhole -= resource;
					moneyWhole -= money;
					plankMerchant += worker;
				} else {
					purchaseError(lblCost3);
					
					if (moneyWhole < 10) purchaseError(lblMoney);
					if (plankWhole < 5) purchaseError(itemAmount);
				}
			} else if (currentPage == 12) {
				if (cottonWhole >= 5 && moneyWhole >= 10) {
					resource = 5;
					money = 10;
					worker = 1;
					if ((long)Math.floor(moneyWhole/10) < (long)Math.floor(cottonWhole/5)) {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = ((long)Math.floor(moneyWhole/10))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5);
							money = ((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))*2;
							worker = (long)Math.floor(moneyWhole/10);
						}
					} else {
						if (multi == 1) {
							resource = 5;
							money = 10;
							worker = 1;
						} else if (multi == 2) {
							resource = (long)Math.floor(((long)Math.floor(cottonWhole/5))/2)-((long)Math.floor(((long)Math.floor(cottonWhole/5))/2)%5);
							money = ((long)Math.floor(((long)Math.floor(cottonWhole/5))/2)-((long)Math.floor(((long)Math.floor(cottonWhole/5))/2)%5))*2;
							worker = ((long)Math.floor(cottonWhole/5))/10;
						} else if (multi == 3) {
							resource = (long)Math.floor(2.5*(long)Math.floor(cottonWhole/5))-((long)Math.floor(2.5*(long)Math.floor(cottonWhole/5))%5);
							money = ((long)Math.floor(2.5*(long)Math.floor(cottonWhole/5))-((long)Math.floor(2.5*(long)Math.floor(cottonWhole/5))%5))*2;
							worker = ((long)Math.floor(cottonWhole/5))/2;
						} else {
							resource = (long)Math.floor(5*(long)Math.floor(cottonWhole/5))-((long)Math.floor(5*(long)Math.floor(cottonWhole/5))%5);
							money = ((long)Math.floor(5*(long)Math.floor(cottonWhole/5))-((long)Math.floor(5*(long)Math.floor(cottonWhole/5))%5))*2;
							worker = (long)Math.floor(cottonWhole/5);
						}
					}
					if (multi == 2 && (cottonWhole < 50 || moneyWhole < 100)) {
						resource = 5;
						money = 10;
						worker = 1;
					} else if (multi == 3 && (cottonWhole < 10 || moneyWhole < 20)) {
						resource = 5;
						money = 10;
						worker = 1;
					}
					cottonWhole -= resource;
					moneyWhole -= money;
					cottonMerchant += worker;
				} else {
					purchaseError(lblCost3);
					
					if (moneyWhole < 10) purchaseError(lblMoney);
					if (cottonWhole < 5) purchaseError(itemAmount);
				}
			}
		}
	}
	
	public void sellWorker1() {
		long worker = 0;
		if (rank == 1) {
			if (currentPage == 1) {
				if (rancher > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(rancher))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(rancher))/2;
					} else {
						worker = (long)Math.floor(rancher);
					}
					if (multi == 2 && rancher < 10) {
						worker = 1;
					} else if (multi == 3 && rancher < 2) {
						worker = 1;
					}
					rancher -= worker;
				} else {
					purchaseError(lblItem1);
				}
			} else if (currentPage == 2) {
				if (fisher > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(fisher))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(fisher))/2;
					} else {
						worker = (long)Math.floor(fisher);
					}
					if (multi == 2 && fisher < 10) {
						worker = 1;
					} else if (multi == 3 && fisher < 2) {
						worker = 1;
					}
					fisher -= worker;
				} else {
					purchaseError(lblItem2);
				}
			} else if (currentPage == 3) {
				if (miner > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(miner))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(miner))/2;
					} else {
						worker = (long)Math.floor(miner);
					}
					if (multi == 2 && miner < 10) {
						worker = 1;
					} else if (multi == 3 && miner < 2) {
						worker = 1;
					}
					miner -= worker;
				} else {
					purchaseError(lblItem1);
				}
			} else if (currentPage == 4) {
				if (coalMiner > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(coalMiner))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(coalMiner))/2;
					} else {
						worker = (long)Math.floor(coalMiner);
					}
					if (multi == 2 && coalMiner < 10) {
						worker = 1;
					} else if (multi == 3 && coalMiner < 2) {
						worker = 1;
					}
					coalMiner -= worker;
				} else {
					purchaseError(lblItem2);
				}
			} else if (currentPage == 5) {
				if (lumberjack > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(lumberjack))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(lumberjack))/2;
					} else {
						worker = (long)Math.floor(lumberjack);
					}
					if (multi == 2 && lumberjack < 10) {
						worker = 1;
					} else if (multi == 3 && lumberjack < 2) {
						worker = 1;
					}
					lumberjack -= worker;
				} else {
					purchaseError(lblItem1);
				}
			} else if (currentPage == 6) {
				if (woodCutter > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(woodCutter))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(woodCutter))/2;
					} else {
						worker = (long)Math.floor(woodCutter);
					}
					if (multi == 2 && woodCutter < 10) {
						worker = 1;
					} else if (multi == 3 && woodCutter < 2) {
						worker = 1;
					}
					woodCutter -= worker;
				} else {
					purchaseError(lblItem2);
				}
			} else if (currentPage == 7) {
				if (farmer > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(farmer))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(farmer))/2;
					} else {
						worker = (long)Math.floor(farmer);
					}
					if (multi == 2 && farmer < 10) {
						worker = 1;
					} else if (multi == 3 && farmer < 2) {
						worker = 1;
					}
					farmer -= worker;
				} else {
					purchaseError(lblItem1);
				}
			} else if (currentPage == 8) {
				if (cottonFarmer > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(cottonFarmer))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(cottonFarmer))/2;
					} else {
						worker = (long)Math.floor(cottonFarmer);
					}
					if (multi == 2 && cottonFarmer < 10) {
						worker = 1;
					} else if (multi == 3 && cottonFarmer < 2) {
						worker = 1;
					}
					cottonFarmer -= worker;
				} else {
					purchaseError(lblItem2);
				}
			}
		} else if (rank == 2) {
			if (currentPage == 1) {
				if (rancher > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(rancher))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(rancher))/2;
					} else {
						worker = (long)Math.floor(rancher);
					}
					if (multi == 2 && rancher < 10) {
						worker = 1;
					} else if (multi == 3 && rancher < 2) {
						worker = 1;
					}
					rancher -= worker;
				} else {
					purchaseError(lblItem1);
				}
			} else if (currentPage == 2) {
				if (fisher > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(fisher))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(fisher))/2;
					} else {
						worker = (long)Math.floor(fisher);
					}
					if (multi == 2 && fisher < 10) {
						worker = 1;
					} else if (multi == 3 && fisher < 2) {
						worker = 1;
					}
					fisher -= worker;
				} else {
					purchaseError(lblItem2);
				}
			} else if (currentPage == 3) {
				if (cowRancher > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(cowRancher))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(cowRancher))/2;
					} else {
						worker = (long)Math.floor(cowRancher);
					}
					if (multi == 2 && cowRancher < 10) {
						worker = 1;
					} else if (multi == 3 && cowRancher < 2) {
						worker = 1;
					}
					cowRancher -= worker;
				} else {
					purchaseError(lblItem2);
				}
			} else if (currentPage == 4) {
				if (pigRancher > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(pigRancher))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(pigRancher))/2;
					} else {
						worker = (long)Math.floor(pigRancher);
					}
					if (multi == 2 && pigRancher < 10) {
						worker = 1;
					} else if (multi == 3 && pigRancher < 2) {
						worker = 1;
					}
					pigRancher -= worker;
				} else {
					purchaseError(lblItem2);
				}
			} else if (currentPage == 5) {
				if (chickenRancher > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(chickenRancher))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(chickenRancher))/2;
					} else {
						worker = (long)Math.floor(chickenRancher);
					}
					if (multi == 2 && chickenRancher < 10) {
						worker = 1;
					} else if (multi == 3 && chickenRancher < 2) {
						worker = 1;
					}
					chickenRancher -= worker;
				} else {
					purchaseError(lblItem2);
				}
			} else if (currentPage == 6) {
				if (sheepRancher > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(sheepRancher))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(sheepRancher))/2;
					} else {
						worker = (long)Math.floor(sheepRancher);
					}
					if (multi == 2 && sheepRancher < 10) {
						worker = 1;
					} else if (multi == 3 && sheepRancher < 2) {
						worker = 1;
					}
					sheepRancher -= worker;
				} else {
					purchaseError(lblItem2);
				}
			} else if (currentPage == 7) {
				if (miner > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(miner))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(miner))/2;
					} else {
						worker = (long)Math.floor(miner);
					}
					if (multi == 2 && miner < 10) {
						worker = 1;
					} else if (multi == 3 && miner < 2) {
						worker = 1;
					}
					miner -= worker;
				} else {
					purchaseError(lblItem1);
				}
			} else if (currentPage == 8) {
				if (coalMiner > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(coalMiner))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(coalMiner))/2;
					} else {
						worker = (long)Math.floor(coalMiner);
					}
					if (multi == 2 && coalMiner < 10) {
						worker = 1;
					} else if (multi == 3 && coalMiner < 2) {
						worker = 1;
					}
					coalMiner -= worker;
				} else {
					purchaseError(lblItem2);
				}
			} else if (currentPage == 9) {
				if (lumberjack > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(lumberjack))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(lumberjack))/2;
					} else {
						worker = (long)Math.floor(lumberjack);
					}
					if (multi == 2 && lumberjack < 10) {
						worker = 1;
					} else if (multi == 3 && lumberjack < 2) {
						worker = 1;
					}
					lumberjack -= worker;
				} else {
					purchaseError(lblItem1);
				}
			} else if (currentPage == 10) {
				if (woodCutter > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(woodCutter))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(woodCutter))/2;
					} else {
						worker = (long)Math.floor(woodCutter);
					}
					if (multi == 2 && woodCutter < 10) {
						worker = 1;
					} else if (multi == 3 && woodCutter < 2) {
						worker = 1;
					}
					woodCutter -= worker;
				} else {
					purchaseError(lblItem2);
				}
			} else if (currentPage == 11) {
				if (farmer > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(farmer))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(farmer))/2;
					} else {
						worker = (long)Math.floor(farmer);
					}
					if (multi == 2 && farmer < 10) {
						worker = 1;
					} else if (multi == 3 && farmer < 2) {
						worker = 1;
					}
					farmer -= worker;
				} else {
					purchaseError(lblItem1);
				}
			} else if (currentPage == 12) {
				if (cottonFarmer > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(cottonFarmer))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(cottonFarmer))/2;
					} else {
						worker = (long)Math.floor(cottonFarmer);
					}
					if (multi == 2 && cottonFarmer < 10) {
						worker = 1;
					} else if (multi == 3 && cottonFarmer < 2) {
						worker = 1;
					}
					cottonFarmer -= worker;
				} else {
					purchaseError(lblItem2);
				}
			}
		}
	}
	
	public void sellWorker2() {
		long worker = 0;
		if (rank == 1) {
			if (currentPage == 2) {
				if (fishMerchant > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(fishMerchant))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(fishMerchant))/2;
					} else {
						worker = (long)Math.floor(fishMerchant);
					}
					if (multi == 2 && fishMerchant < 10) {
						worker = 1;
					} else if (multi == 3 && fishMerchant < 2) {
						worker = 1;
					}
					fishMerchant -= worker;
				} else {
					purchaseError(lblItem3);
				}
			} else if (currentPage == 4) {
				if (coalMerchant > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(coalMerchant))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(coalMerchant))/2;
					} else {
						worker = (long)Math.floor(coalMerchant);
					}
					if (multi == 2 && coalMerchant < 10) {
						worker = 1;
					} else if (multi == 3 && coalMerchant < 2) {
						worker = 1;
					}
					coalMerchant -= worker;
				} else {
					purchaseError(lblItem3);
				}
			} else if (currentPage == 6) {
				if (plankMerchant > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(plankMerchant))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(plankMerchant))/2;
					} else {
						worker = (long)Math.floor(plankMerchant);
					}
					if (multi == 2 && plankMerchant < 10) {
						worker = 1;
					} else if (multi == 3 && plankMerchant < 2) {
						worker = 1;
					}
					plankMerchant -= worker;
				} else {
					purchaseError(lblItem3);
				}
			} else if (currentPage == 8) {
				if (cottonMerchant > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(cottonMerchant))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(cottonMerchant))/2;
					} else {
						worker = (long)Math.floor(cottonMerchant);
					}
					if (multi == 2 && cottonMerchant < 10) {
						worker = 1;
					} else if (multi == 3 && cottonMerchant < 2) {
						worker = 1;
					}
					cottonMerchant -= worker;
				} else {
					purchaseError(lblItem3);
				}
			}
		} else if (rank == 2) {
			if (currentPage == 2) {
				if (fishMerchant > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(fishMerchant))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(fishMerchant))/2;
					} else {
						worker = (long)Math.floor(fishMerchant);
					}
					if (multi == 2 && fishMerchant < 10) {
						worker = 1;
					} else if (multi == 3 && fishMerchant < 2) {
						worker = 1;
					}
					fishMerchant -= worker;
				} else {
					purchaseError(lblItem3);
				}
			} else if (currentPage == 3) {
				if (steakMerchant > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(steakMerchant))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(steakMerchant))/2;
					} else {
						worker = (long)Math.floor(steakMerchant);
					}
					if (multi == 2 && steakMerchant < 10) {
						worker = 1;
					} else if (multi == 3 && steakMerchant < 2) {
						worker = 1;
					}
					steakMerchant -= worker;
				} else {
					purchaseError(lblItem3);
				}
			} else if (currentPage == 4) {
				if (porkMerchant > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(porkMerchant))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(porkMerchant))/2;
					} else {
						worker = (long)Math.floor(porkMerchant);
					}
					if (multi == 2 && porkMerchant < 10) {
						worker = 1;
					} else if (multi == 3 && porkMerchant < 2) {
						worker = 1;
					}
					porkMerchant -= worker;
				} else {
					purchaseError(lblItem3);
				}
			} else if (currentPage == 5) {
				if (chickenMerchant > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(chickenMerchant))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(chickenMerchant))/2;
					} else {
						worker = (long)Math.floor(chickenMerchant);
					}
					if (multi == 2 && chickenMerchant < 10) {
						worker = 1;
					} else if (multi == 3 && chickenMerchant < 2) {
						worker = 1;
					}
					chickenMerchant -= worker;
				} else {
					purchaseError(lblItem3);
				}
			} else if (currentPage == 6) {
				if (muttonMerchant > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(muttonMerchant))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(muttonMerchant))/2;
					} else {
						worker = (long)Math.floor(muttonMerchant);
					}
					if (multi == 2 && muttonMerchant < 10) {
						worker = 1;
					} else if (multi == 3 && muttonMerchant < 2) {
						worker = 1;
					}
					muttonMerchant -= worker;
				} else {
					purchaseError(lblItem3);
				}
			} else if (currentPage == 8) {
				if (coalMerchant > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(coalMerchant))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(coalMerchant))/2;
					} else {
						worker = (long)Math.floor(coalMerchant);
					}
					if (multi == 2 && coalMerchant < 10) {
						worker = 1;
					} else if (multi == 3 && coalMerchant < 2) {
						worker = 1;
					}
					coalMerchant -= worker;
				} else {
					purchaseError(lblItem3);
				}
			} else if (currentPage == 10) {
				if (plankMerchant > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(plankMerchant))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(plankMerchant))/2;
					} else {
						worker = (long)Math.floor(plankMerchant);
					}
					if (multi == 2 && plankMerchant < 10) {
						worker = 1;
					} else if (multi == 3 && plankMerchant < 2) {
						worker = 1;
					}
					plankMerchant -= worker;
				} else {
					purchaseError(lblItem3);
				}
			} else if (currentPage == 12) {
				if (cottonMerchant > 0) {
					worker = 1;
					if (multi == 1) {
						worker = 1;
					} else if (multi == 2) {
						worker = ((long)Math.floor(cottonMerchant))/10;
					} else if (multi == 3) {
						worker = ((long)Math.floor(cottonMerchant))/2;
					} else {
						worker = (long)Math.floor(cottonMerchant);
					}
					if (multi == 2 && cottonMerchant < 10) {
						worker = 1;
					} else if (multi == 3 && cottonMerchant < 2) {
						worker = 1;
					}
					cottonMerchant -= worker;
				} else {
					purchaseError(lblItem3);
				}
			}
		}
	}
	
	public void keyPressed(KeyEvent key) {
		try {
			if (imgPopUp.isVisible()) {
				if (!newHotkey1 && !newHotkey2 && !newHotkey3 && !newHotkey4 && !newHotkey5 && !newHotkey6 && !newHotkey7 && !newHotkey8 && !newHotkey9 && !newHotkey10 && !newHotkey11 && !newHotkey12 && !newHotkey13 && !newHotkey14 && !newHotkey15 && !newHotkey16) {
					if (key.getCode() == KeyCode.ESCAPE) closePopUp();
				} else {
					KeyCode code = key.getCode();
					if (newHotkey1 && code != buyKey2 && code != sellKey1 && code != sellKey2 && code != goToNext && code != goToPrev && code != goToFirst && code != goToLast && code != openStorage && code != openOptions && code != openAchievement && code != openCompetitor && code != increasePrice && code != decreasePrice && code != increaseMultiplier && code != decreaseMultiplier) {
						buyKey1 = key.getCode();
						hotkeyName1.setText(hotkey(buyKey1));
						newHotkey1 = false;
					} else if (newHotkey2 && code != buyKey1 && code != sellKey1 && code != sellKey2 && code != goToNext && code != goToPrev && code != goToFirst && code != goToLast && code != openStorage && code != openOptions && code != openAchievement && code != openCompetitor && code != increasePrice && code != decreasePrice && code != increaseMultiplier && code != decreaseMultiplier) {
						buyKey2 = key.getCode();
						hotkeyName2.setText(hotkey(buyKey2));
						newHotkey2 = false;						
					} else if (newHotkey3 && code != buyKey1 && code != buyKey2 && code != sellKey2 && code != goToNext && code != goToPrev && code != goToFirst && code != goToLast && code != openStorage && code != openOptions && code != openAchievement && code != openCompetitor && code != increasePrice && code != decreasePrice && code != increaseMultiplier && code != decreaseMultiplier) {
						sellKey1 = key.getCode();
						hotkeyName3.setText(hotkey(sellKey1));
						newHotkey3 = false;
					} else if (newHotkey4 && code != buyKey1 && code != buyKey2 && code != sellKey1 && code != goToNext && code != goToPrev && code != goToFirst && code != goToLast && code != openStorage && code != openOptions && code != openAchievement && code != openCompetitor && code != increasePrice && code != decreasePrice && code != increaseMultiplier && code != decreaseMultiplier) {
						sellKey2 = key.getCode();
						hotkeyName4.setText(hotkey(sellKey2));
						newHotkey4 = false;
					} else if (newHotkey5 && code != buyKey1 && code != buyKey2 && code != sellKey1 && code != sellKey2 && code != goToPrev && code != goToFirst && code != goToLast && code != openStorage && code != openOptions && code != openAchievement && code != openCompetitor && code != increasePrice && code != decreasePrice && code != increaseMultiplier && code != decreaseMultiplier) {
						goToNext = key.getCode();
						hotkeyName5.setText(hotkey(goToNext));
						newHotkey5 = false;
					} else if (newHotkey6 && code != buyKey1 && code != buyKey2 && code != sellKey1 && code != sellKey2 && code != goToNext && code != goToFirst && code != goToLast && code != openStorage && code != openOptions && code != openAchievement && code != openCompetitor && code != increasePrice && code != decreasePrice && code != increaseMultiplier && code != decreaseMultiplier) {
						goToPrev = key.getCode();
						hotkeyName6.setText(hotkey(goToPrev));
						newHotkey6 = false;
					} else if (newHotkey7 && code != buyKey1 && code != buyKey2 && code != sellKey1 && code != sellKey2 && code != goToNext && code != goToPrev && code != goToLast && code != openStorage && code != openOptions && code != openAchievement && code != openCompetitor && code != increasePrice && code != decreasePrice && code != increaseMultiplier && code != decreaseMultiplier) {
						goToFirst = key.getCode();
						hotkeyName7.setText(hotkey(goToFirst));
						newHotkey7 = false;
					} else if (newHotkey8 && code != buyKey1 && code != buyKey2 && code != sellKey1 && code != sellKey2 && code != goToNext && code != goToPrev && code != goToFirst && code != openStorage && code != openOptions && code != openAchievement && code != openCompetitor && code != increasePrice && code != decreasePrice && code != increaseMultiplier && code != decreaseMultiplier) {
						goToLast = key.getCode();
						hotkeyName8.setText(hotkey(goToLast));
						newHotkey8 = false;
					} else if (newHotkey9 && code != buyKey1 && code != buyKey2 && code != sellKey1 && code != sellKey2 && code != goToNext && code != goToPrev && code != goToFirst && code != goToLast && code != openOptions && code != openAchievement && code != openCompetitor && code != increasePrice && code != decreasePrice && code != increaseMultiplier && code != decreaseMultiplier) {
						openStorage = key.getCode();
						hotkeyName9.setText(hotkey(openStorage));
						newHotkey9 = false;
					} else if (newHotkey10 && code != buyKey1 && code != buyKey2 && code != sellKey1 && code != sellKey2 && code != goToNext && code != goToPrev && code != goToFirst && code != goToLast && code != openStorage && code != openOptions && code != openCompetitor && code != increasePrice && code != decreasePrice && code != increaseMultiplier && code != decreaseMultiplier) {
						openAchievement = key.getCode();
						hotkeyName10.setText(hotkey(openAchievement));
						newHotkey10 = false;
					} else if (newHotkey11 && code != buyKey1 && code != buyKey2 && code != sellKey1 && code != sellKey2 && code != goToNext && code != goToPrev && code != goToFirst && code != goToLast && code != openStorage && code != openOptions && code != openAchievement && code != increasePrice && code != decreasePrice && code != increaseMultiplier && code != decreaseMultiplier) {
						openCompetitor = key.getCode();
						hotkeyName11.setText(hotkey(openCompetitor));
						newHotkey11 = false;
					} else if (newHotkey12 && code != buyKey1 && code != buyKey2 && code != sellKey1 && code != sellKey2 && code != goToNext && code != goToPrev && code != goToFirst && code != goToLast && code != openStorage && code != openAchievement && code != openCompetitor && code != increasePrice && code != decreasePrice && code != increaseMultiplier && code != decreaseMultiplier) {
						openOptions = key.getCode();
						hotkeyName12.setText(hotkey(openOptions));
						newHotkey12 = false;
					} else if (newHotkey13 && code != buyKey1 && code != buyKey2 && code != sellKey1 && code != sellKey2 && code != goToNext && code != goToPrev && code != goToFirst && code != goToLast && code != openStorage && code != openOptions && code != openAchievement && code != openCompetitor && code != decreasePrice && code != increaseMultiplier && code != decreaseMultiplier) {
						increasePrice = key.getCode();
						hotkeyName13.setText(hotkey(increasePrice));
						newHotkey13 = false;
					} else if (newHotkey14 && code != buyKey1 && code != buyKey2 && code != sellKey1 && code != sellKey2 && code != goToNext && code != goToPrev && code != goToFirst && code != goToLast && code != openStorage && code != openOptions && code != openAchievement && code != openCompetitor && code != increasePrice && code != increaseMultiplier && code != decreaseMultiplier) {
						decreasePrice = key.getCode();
						hotkeyName14.setText(hotkey(decreasePrice));
						newHotkey14 = false;
					} else if (newHotkey15 && code != buyKey1 && code != buyKey2 && code != sellKey1 && code != sellKey2 && code != goToNext && code != goToPrev && code != goToFirst && code != goToLast && code != openStorage && code != openOptions && code != openAchievement && code != openCompetitor && code != increasePrice && code != decreasePrice && code != decreaseMultiplier) {
						increaseMultiplier = key.getCode();
						hotkeyName15.setText(hotkey(increaseMultiplier));
						newHotkey15 = false;
					} else if (newHotkey16 && code != buyKey1 && code != buyKey2 && code != sellKey1 && code != sellKey2 && code != goToNext && code != goToPrev && code != goToFirst && code != goToLast && code != openStorage && code != openOptions && code != openAchievement && code != openCompetitor && code != increasePrice && code != decreasePrice && code != increaseMultiplier) {
						decreaseMultiplier = key.getCode();
						hotkeyName16.setText(hotkey(decreaseMultiplier));
						newHotkey16 = false;
					}
					pw = new PrintWriter("stats/"+username+"/Keys.stat");
					pw.println(new TextEncryptor(buyKey1.toString()).encrypt());
					pw.println(new TextEncryptor(buyKey2.toString()).encrypt());
					pw.println(new TextEncryptor(sellKey1.toString()).encrypt());
					pw.println(new TextEncryptor(sellKey2.toString()).encrypt());
					pw.println(new TextEncryptor(goToNext.toString()).encrypt());
					pw.println(new TextEncryptor(goToPrev.toString()).encrypt());
					pw.println(new TextEncryptor(goToFirst.toString()).encrypt());
					pw.println(new TextEncryptor(goToLast.toString()).encrypt());
					pw.println(new TextEncryptor(openStorage.toString()).encrypt());
					pw.println(new TextEncryptor(openAchievement.toString()).encrypt());
					pw.println(new TextEncryptor(openCompetitor.toString()).encrypt());
					pw.println(new TextEncryptor(openOptions.toString()).encrypt());
					pw.println(new TextEncryptor(increasePrice.toString()).encrypt());
					pw.println(new TextEncryptor(decreasePrice.toString()).encrypt());
					pw.println(new TextEncryptor(increaseMultiplier.toString()).encrypt());
					pw.println(new TextEncryptor(decreaseMultiplier.toString()).encrypt());
					pw.close();
				}
				if (key.getCode() == goToNext) {
					if (inAchievement && achievementPage < 203) {
						achievementPage++;
						changeAchievementPage();
						log("Went to Achievements Page "+achievementPage+".");
					} else if (inAchievementSelect) {
						if (rank > 2 && achievementPage < 2) {
							achievementPage++;
							changeAchievementPage();
							log("Went to Achievement Selection Page "+achievementPage+".");
						}
					} else if (inStorage) {
						if (rank >= 1 && storagePage < 2) {
							storagePage++;
							changeStoragePage();
							log("Went to Storage Page "+storagePage+".");
						} else if (rank >= 2 && storagePage < 3) {
							storagePage++;
							changeStoragePage();
							log("Went to Storage Page "+storagePage+".");
						}
					} else if (inOptions && optionsPage < 2) {
						optionsPage++;
						changeOptionsPage();
					}
				} else if (key.getCode() == goToPrev) {
					if (inAchievement && achievementPage > 1) {
						achievementPage--;
						changeAchievementPage();
						log("Went to Achievements Page "+achievementPage+".");
					} else if (inAchievementSelect && achievementPage > 1) {
						achievementPage--;
						changeAchievementPage();
						log("Went to Achievement Selection Page "+achievementPage+".");
					} else if (inStorage) {
						if (storagePage > 1) {
							storagePage--;
							changeStoragePage();
							log("Went to Storage Page "+storagePage+".");
						}
					} else if (inOptions && optionsPage > 1) {
						optionsPage--;
						changeOptionsPage();
					}
				} else if (key.getCode() == goToFirst) {
					if (inAchievement) {
						achievementPage = 1;
						changeAchievementPage();
						log("Went to Achievements Page 1.");
					} else if (inAchievementSelect) {
						achievementPage = 1;
						changeAchievementPage();
						log("Went to Achievement Selection Page 1.");
					} else if (inStorage) {
						storagePage = 1;
						changeStoragePage();
						log("Went to Storage Page 1.");
					}
				} else if (key.getCode() == goToLast) {
					if (inAchievement) {
						achievementPage = 203;
						changeAchievementPage();
						log("Went to Achievements Page 203.");
					} else if (inAchievementSelect) {
						achievementPage = 1;
						changeAchievementPage();
						log("Went to Achievement Selection Page 1.");
					} else if (inStorage) {
						if (rank == 1) {
							storagePage = 2;
							changeStoragePage();
							log("Went to Storage Page 2."); 
						} else if (rank == 2) {
							storagePage = 3;
							changeStoragePage();
							log("Went to Storage Page 3.");
						}
					}
				}
				if (key.getCode() == openStorage && key.getCode() != KeyCode.ESCAPE && !inOptions) activateStorage();
				else if (key.getCode() == openOptions && key.getCode() != KeyCode.ESCAPE && !inOptions) activateOptions();
				else if (key.getCode() == openAchievement && key.getCode() != KeyCode.ESCAPE && !inOptions) activateAchievement();
				else if (key.getCode() == openCompetitor && key.getCode() != KeyCode.ESCAPE && !inOptions) activateCompetitor();
			} else {
				if (key.getCode() == buyKey1) buyWorker1();
				else if (key.getCode() == sellKey1) sellWorker1();
				else if (key.getCode() == buyKey2) buyWorker2();
				else if (key.getCode() == sellKey2) sellWorker2();
				
				else if (key.getCode() == goToNext) {
					if (rank == 1 && currentPage < 8) {
						currentPage++;
						changePage();
					} else if (rank == 2 && currentPage < 12) {
						currentPage++;
						changePage();
					}
				} else if (key.getCode() == goToPrev && currentPage > 1) {
					currentPage--;
					changePage();
				} else if (key.getCode() == goToFirst) {
					currentPage = 1;
					changePage();
				} else if (key.getCode() == goToLast) {
					if (rank == 1) {
						currentPage = 8;
					} else if (rank == 2) {
						currentPage = 12;
					}
					changePage();
				} else if (key.getCode() == openStorage) {
					activateStorage();
					storageButton.setImage(new Image("img/technical/button.png"));
				} else if (key.getCode() == openOptions) {
					activateOptions();
					optionsButton.setImage(new Image("img/technical/button.png"));
				} else if (key.getCode() == openAchievement) {
					activateAchievement();
					achievementButton.setImage(new Image("img/technical/button.png"));
				} else if (key.getCode() == openCompetitor) {
					activateCompetitor();
					competitorButton.setImage(new Image("img/technical/button.png"));
				} else if (key.getCode() == increasePrice) {
					if (rank == 1) {
						if (currentPage == 2) {
							if (fishPrice < 2) fishPrice += 0.1;
							fishPrice = (double)Math.round(fishPrice*10)/10;
						} else if (currentPage == 4) {
							if (coalPrice < 2) coalPrice += 0.1;
							coalPrice = (double)Math.round(coalPrice*10)/10;
						} else if (currentPage == 6) {
							if (plankPrice < 2) plankPrice += 0.1;
							plankPrice = (double)Math.round(plankPrice*10)/10;
						} else if (currentPage == 8) {
							if (cottonPrice < 2) cottonPrice += 0.1;
							cottonPrice = (double)Math.round(cottonPrice*10)/10;
						}
					} else if (rank == 2) {
						if (currentPage == 2) {
							if (fishPrice < 2) fishPrice += 0.1;
							fishPrice = (double)Math.round(fishPrice*10)/10;
						} else if (currentPage == 3) {
							if (steakPrice < 2) steakPrice += 0.1;
							steakPrice = (double)Math.round(steakPrice*10)/10;
						} else if (currentPage == 4) {
							if (porkPrice < 2) porkPrice += 0.1;
							porkPrice = (double)Math.round(porkPrice*10)/10;
						} else if (currentPage == 5) {
							if (chickenPrice < 2) chickenPrice += 0.1;
							chickenPrice = (double)Math.round(chickenPrice*10)/10;
						} else if (currentPage == 6) {
							if (muttonPrice < 2) muttonPrice += 0.1;
							muttonPrice = (double)Math.round(muttonPrice*10)/10;
						} else if (currentPage == 8) {
							if (coalPrice < 2) coalPrice += 0.1;
							coalPrice = (double)Math.round(coalPrice*10)/10;
						} else if (currentPage == 10) {
							if (plankPrice < 2) plankPrice += 0.1;
							plankPrice = (double)Math.round(plankPrice*10)/10;
						} else if (currentPage == 12) {
							if (cottonPrice < 2) cottonPrice += 0.1;
							cottonPrice = (double)Math.round(cottonPrice*10)/10;
						}
					}
				} else if (key.getCode() == decreasePrice) {
					if (rank == 1) {
						if (currentPage == 2) {
							if (fishPrice > 0.1) fishPrice -= 0.1;
							fishPrice = (double)Math.round(fishPrice*10)/10;
						} else if (currentPage == 4) {
							if (coalPrice > 0.1) coalPrice -= 0.1;
							coalPrice = (double)Math.round(coalPrice*10)/10;
						} else if (currentPage == 6) {
							if (plankPrice > 0.1) plankPrice -= 0.1;
							plankPrice = (double)Math.round(plankPrice*10)/10;
						} else if (currentPage == 8) {
							if (cottonPrice > 0.1) cottonPrice -= 0.1;
							cottonPrice = (double)Math.round(cottonPrice*10)/10;
						}
					} else if (rank == 2) {
						if (currentPage == 2) {
							if (fishPrice > 0.1) fishPrice -= 0.1;
							fishPrice = (double)Math.round(fishPrice*10)/10;
						} else if (currentPage == 3) {
							if (steakPrice > 0.1) steakPrice -= 0.1;
							steakPrice = (double)Math.round(steakPrice*10)/10;
						} else if (currentPage == 4) {
							if (porkPrice > 0.1) porkPrice -= 0.1;
							porkPrice = (double)Math.round(porkPrice*10)/10;
						} else if (currentPage == 5) {
							if (chickenPrice > 0.1) chickenPrice -= 0.1;
							chickenPrice = (double)Math.round(chickenPrice*10)/10;
						} else if (currentPage == 6) {
							if (muttonPrice > 0.1) muttonPrice -= 0.1;
							muttonPrice = (double)Math.round(muttonPrice*10)/10;
						} else if (currentPage == 8) {
							if (coalPrice > 0.1) coalPrice -= 0.1;
							coalPrice = (double)Math.round(coalPrice*10)/10;
						} else if (currentPage == 10) {
							if (plankPrice > 0.1) plankPrice -= 0.1;
							plankPrice = (double)Math.round(plankPrice*10)/10;
						} else if (currentPage == 12) {
							if (cottonPrice > 0.1) cottonPrice -= 0.1;
							cottonPrice = (double)Math.round(cottonPrice*10)/10;
						}
					}
				} else if (key.getCode() == increaseMultiplier) {
					multi++;
					if (multi == 2) {
						lblMultiplier.setText("Multiplier: 10%");
					} else if (multi == 3) {
						lblMultiplier.setText("Multiplier: 50%");
					} else if (multi == 4) {
						lblMultiplier.setText("Multiplier: 100%");
					} else if (multi == 5) {
						multi = 1;
						lblMultiplier.setText("Multiplier: x1");
					}
				} else if (key.getCode() == decreaseMultiplier) {
					multi--;
					if (multi == 0) {
						multi = 4;
						lblMultiplier.setText("Multiplier: 100%");
					} else if (multi == 1) {
						lblMultiplier.setText("Multiplier: x1");
					} else if (multi == 2) {
						lblMultiplier.setText("Multiplier: 10%");
					} else if (multi == 3) {
						lblMultiplier.setText("Multiplier: 50%");
					}
				} else if (key.getCode() == KeyCode.ALT) {
					if (refreshTime.isVisible()) {
						refreshTime.setVisible(false);
					} else {
						refreshTime.setVisible(true);
					}
				}
			}
		} catch (Exception e) {}
	}
	
	public void keyReleased(KeyEvent key) {
		itemAmount.setTextFill(Color.web("#000000"));
		lblItem1.setTextFill(Color.web("#000000"));
		lblItem2.setTextFill(Color.web("#000000"));
		lblItem3.setTextFill(Color.web("#000000"));
		lblCost1.setTextFill(Color.web("#000000"));
		lblCost2.setTextFill(Color.web("#000000"));
		lblCost3.setTextFill(Color.web("#000000"));
		lblRank.setTextFill(Color.web("#000000"));
		lblMoney.setTextFill(Color.web("#000000"));
	}
	
	public void mouseScroll(ScrollEvent s) {
		if (s.getDeltaY() > 0) {
			for (int i = 1;i <= s.getDeltaY()/40.0;i++) {
				if (imgPopUp.isVisible()) {
					if (inAchievement && achievementPage < 203) {
						achievementPage++;
						changeAchievementPage();
						log("Went to Achievements Page "+achievementPage+".");
					} else if (inAchievementSelect) {
						if (rank > 2 && achievementPage < 2) {
							achievementPage++;
							changeAchievementPage();
							log("Went to Achievement Selection Page "+achievementPage+".");
						}
					} else if (inStorage) {
						if (rank >= 1 && storagePage < 2) {
							storagePage++;
							changeStoragePage();
							log("Went to Storage Page "+storagePage+".");
						} else if (rank >= 2 && storagePage < 3) {
							storagePage++;
							changeStoragePage();
							log("Went to Storage Page "+storagePage+".");
						}
					} else if (inOptions) {
						if (optionsPage < 2) {
							optionsPage++;
							changeOptionsPage();
						}
					}
				} else {
					if (rank == 1 && currentPage < 8) {
						currentPage++;
						changePage();
					} else if (rank == 2 && currentPage < 12) {
						currentPage++;
						changePage();
					}
				}
			}
		} else {
			for (int i = 1;i <= -s.getDeltaY()/40.0;i++) {
				if (imgPopUp.isVisible()) {
					if (inAchievement && achievementPage > 1) {
						achievementPage--;
						changeAchievementPage();
						log("Went to Achievements Page "+achievementPage+".");
					} else if (inAchievementSelect && achievementPage > 1) {
						achievementPage--;
						changeAchievementPage();
						log("Went to Achievement Selection Page "+achievementPage+".");
					} else if (inStorage) {
						if (storagePage > 1) {
							storagePage--;
							changeStoragePage();
							log("Went to Storage Page "+storagePage+".");
						}
					} else if (inOptions && optionsPage > 1) {
						optionsPage--;
						changeOptionsPage();
					}
				} else if (currentPage > 1) {
					currentPage--;
					changePage();
				}
			}
		}
	}
	
	public void mousePressed(MouseEvent m) {
		if (m.getButton() == MouseButton.PRIMARY) {
			if (rank == 1) {
				if (currentPage == 1 && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover()) {
					foodWhole += rank;
				} else if (currentPage == 3 && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover()) {
					stoneWhole += rank;
				} else if (currentPage == 5 && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover()) {
					woodWhole += rank;
				} else if (currentPage == 7 && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover()) {
					cropWhole += rank;
				}
				
				if (currentPage == 2 && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover() && foodWhole >= 2) {
					foodWhole -= 2;
					fishWhole += rank;
				} else if (currentPage == 4 && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover() && stoneWhole >= 2) {
					stoneWhole -= 2;
					coalWhole += rank;
				} else if (currentPage == 6 && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover() && woodWhole >= 2) {
					woodWhole -= 2;
					plankWhole += rank;
				} else if (currentPage == 8 && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover() && cropWhole >= 2) {
					cropWhole -= 2;
					cottonWhole += rank;
				} else if (!(currentPage == 1 || currentPage == 3 || currentPage == 5 || currentPage == 7) && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover()) {
					purchaseError(lblCost1);
					purchaseError(lblItem1);
				}
			} else if (rank == 2) {
				if (currentPage == 1 && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover()) {
					foodWhole += rank;
				} else if (currentPage == 7 && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover()) {
					stoneWhole += rank;
				} else if (currentPage == 9 && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover()) {
					woodWhole += rank;
				} else if (currentPage == 11 && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover()) {
					cropWhole += rank;
				}
				
				if (currentPage == 2 && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover() && foodWhole >= 2) {
					foodWhole -= 2;
					fishWhole += rank;
				} else if (currentPage == 3 && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover() && foodWhole >= 2) {
					foodWhole -= 2;
					steakWhole += rank;
				} else if (currentPage == 4 && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover() && foodWhole >= 2) {
					foodWhole -= 2;
					porkWhole += rank;
				} else if (currentPage == 5 && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover() && foodWhole >= 2) {
					foodWhole -= 2;
					chickenWhole += rank;
				} else if (currentPage == 6 && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover() && foodWhole >= 2) {
					foodWhole -= 2;
					muttonWhole += rank;
				} else if (currentPage == 8 && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover() && stoneWhole >= 2) {
					stoneWhole -= 2;
					coalWhole += rank;
				} else if (currentPage == 10 && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover() && woodWhole >= 2) {
					woodWhole -= 2;
					plankWhole += rank;
				} else if (currentPage == 12 && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover() && cropWhole >= 2) {
					cropWhole -= 2;
					cottonWhole += rank;
				} else if (!(currentPage == 1 || currentPage == 7 || currentPage == 9 || currentPage == 11) && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover()) {
					purchaseError(lblCost1);
					purchaseError(lblItem1);
				}
			}
		} else if (m.getButton() == MouseButton.SECONDARY) {
			if (rank == 1) {
				if (fishWhole >= 1 && currentPage == 2) {
					fishWhole--;
					moneyDecimal += rank*fishPrice;
					moneyWhole += moneyDecimal-(moneyDecimal%1);
					moneyDecimal -= moneyDecimal-(moneyDecimal%1);
				} else if (coalWhole >= 1 && currentPage == 4) {
					coalWhole--;
					moneyDecimal += rank*coalPrice;
					moneyWhole += moneyDecimal-(moneyDecimal%1);
					moneyDecimal -= moneyDecimal-(moneyDecimal%1);
				} else if (plankWhole >= 1 && currentPage == 6) {
					plankWhole--;
					moneyDecimal += rank*plankPrice;
					moneyWhole += moneyDecimal-(moneyDecimal%1);
					moneyDecimal -= moneyDecimal-(moneyDecimal%1);
				} else if (cottonWhole >= 1 && currentPage == 8) {
					cottonWhole--;
					moneyDecimal += rank*cottonPrice;
					moneyWhole += moneyDecimal-(moneyDecimal%1);
					moneyDecimal -= moneyDecimal-(moneyDecimal%1);
				} else if (!(currentPage == 1 || currentPage == 3 || currentPage == 5 || currentPage == 7) && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover()) purchaseError(itemAmount);
			} else if (rank == 2) {
				if (fishWhole >= 1 && currentPage == 2) {
					fishWhole--;
					moneyDecimal += rank*fishPrice;
					moneyWhole += moneyDecimal-(moneyDecimal%1);
					moneyDecimal -= moneyDecimal-(moneyDecimal%1);
				} else if (steakWhole >= 1 && currentPage == 3) {
					steakWhole--;
					moneyDecimal += rank*steakPrice;
					moneyWhole += moneyDecimal-(moneyDecimal%1);
					moneyDecimal -= moneyDecimal-(moneyDecimal%1);
				} else if (porkWhole >= 1 && currentPage == 4) {
					porkWhole--;
					moneyDecimal += rank*porkPrice;
					moneyWhole += moneyDecimal-(moneyDecimal%1);
					moneyDecimal -= moneyDecimal-(moneyDecimal%1);
				} else if (chickenWhole >= 1 && currentPage == 5) {
					chickenWhole--;
					moneyDecimal += rank*chickenPrice;
					moneyWhole += moneyDecimal-(moneyDecimal%1);
					moneyDecimal -= moneyDecimal-(moneyDecimal%1);
				} else if (muttonWhole >= 1 && currentPage == 6) {
					muttonWhole--;
					moneyDecimal += rank*muttonPrice;
					moneyWhole += moneyDecimal-(moneyDecimal%1);
					moneyDecimal -= moneyDecimal-(moneyDecimal%1);
				} else if (coalWhole >= 1 && currentPage == 8) {
					coalWhole--;
					moneyDecimal += rank*coalPrice;
					moneyWhole += moneyDecimal-(moneyDecimal%1);
					moneyDecimal -= moneyDecimal-(moneyDecimal%1);
				} else if (plankWhole >= 1 && currentPage == 10) {
					plankWhole--;
					moneyDecimal += rank*plankPrice;
					moneyWhole += moneyDecimal-(moneyDecimal%1);
					moneyDecimal -= moneyDecimal-(moneyDecimal%1);
				} else if (cottonWhole >= 1 && currentPage == 12) {
					cottonWhole--;
					moneyDecimal += rank*cottonPrice;
					moneyWhole += moneyDecimal-(moneyDecimal%1);
					moneyDecimal -= moneyDecimal-(moneyDecimal%1);
				} else if (!(currentPage == 1 || currentPage == 7 || currentPage == 9 || currentPage == 11) && !storageIcon.isHover() && !optionsIcon.isHover() && !achievementIcon.isHover() && !competitorIcon.isHover()) purchaseError(itemAmount);
			}
		}
	}
	
	public void mouseReleased(MouseEvent m) {
		itemAmount.setTextFill(Color.web("#000000"));
		lblItem1.setTextFill(Color.web("#000000"));
		lblItem2.setTextFill(Color.web("#000000"));
		lblItem3.setTextFill(Color.web("#000000"));
		lblCost1.setTextFill(Color.web("#000000"));
		lblCost2.setTextFill(Color.web("#000000"));
		lblCost3.setTextFill(Color.web("#000000"));
		lblRank.setTextFill(Color.web("#000000"));
		lblMoney.setTextFill(Color.web("#000000"));
	}
	
	public static long milliTime() {
		return System.currentTimeMillis();
	}
	
	public static void test() {
		System.out.println(a);
		a++;
	}
	
	public void cancelMouseExited(MouseEvent event) {
		scene.setCursor(Cursor.DEFAULT);
		closePopUp.setImage(new Image("img/technical/cancelButton.png"));
	}
	
	public void cancelMouseEntered(MouseEvent event) {
		scene.setCursor(Cursor.HAND);
		closePopUp.setImage(new Image("img/technical/cancelButtonMouse.png"));
	}
	
	public void cancelMousePressed(MouseEvent event) {
		closePopUp.setImage(new Image("img/technical/cancelButtonPressed.png"));
	}
	
	public void cancelMouseReleased(MouseEvent event) {
		if (closePopUp.isHover()) {
			closePopUp.setImage(new Image("img/technical/cancelButtonMouse.png"));
			closePopUp();
		}
	}
	
	public void closePopUp() {
		if (!inCompetitor && imgCompetitorResource.isVisible() && !lastVersion.equals(currentVersion)) {
			activateChangelog();
			goBackButton.setVisible(false);
			goBackIcon.setVisible(false);
			lastVersion = currentVersion;
			save();
		} else {
			inOptions = false;
			inStorage = false;
			inAchievement = false;
			inAchievementSelect = false;
			inCompetitor = false;
			anchor.setOnMousePressed(this::mousePressed);
			anchor.setOnMouseReleased(this::mouseReleased);
			anchor.setOnKeyReleased(this::keyReleased);
			lblCompetitorCompany.setVisible(false);
			imgCompetitorResource.setVisible(false);
			lblCompetitorName.setVisible(false);
			lblCompetitorPrice.setVisible(false);
			lblCompetitorAmount.setVisible(false);
			lblChangelog.setVisible(false);
			lblCredits.setVisible(false);
			changelogButton.setVisible(false);
			changelogIcon.setVisible(false);
			consoleButton.setVisible(false);
			consoleIcon.setVisible(false);
			tutorialButton.setVisible(false);
			tutorialIcon.setVisible(false);
			musicButton.setVisible(false);
			keyButton.setVisible(false);
			keyIcon.setVisible(false);
			creditButton.setVisible(false);
			creditIcon.setVisible(false);
			storageTitle1.setVisible(false);
			storageTitle2.setVisible(false);
			storageResource1.setVisible(false);
			storageResource2.setVisible(false);
			storageResource3.setVisible(false);
			storageResource4.setVisible(false);
			storageResource5.setVisible(false);
			storageResource6.setVisible(false);
			storageResource7.setVisible(false);
			storageResource8.setVisible(false);
			storageWorker1.setVisible(false);
			storageWorker2.setVisible(false);
			storageWorker3.setVisible(false);
			storageWorker4.setVisible(false);
			storageWorker5.setVisible(false);
			storageWorker6.setVisible(false);
			storageWorker7.setVisible(false);
			storageWorker8.setVisible(false);
			imgPopUp.setVisible(false);
			closePopUp.setVisible(false);
			goBackButton.setVisible(false);
			goBackIcon.setVisible(false);
			lblPopUpTitle.setVisible(false);
			logoutButton.setVisible(false);
			lblLogout.setVisible(false);
			imgHotkey1.setVisible(false);
			imgHotkey2.setVisible(false);
			imgHotkey3.setVisible(false);
			imgHotkey4.setVisible(false);
			imgHotkey5.setVisible(false);
			imgHotkey6.setVisible(false);
			imgHotkey7.setVisible(false);
			imgHotkey8.setVisible(false);
			imgHotkey9.setVisible(false);
			imgHotkey10.setVisible(false);
			imgHotkey11.setVisible(false);
			imgHotkey12.setVisible(false);
			imgHotkey13.setVisible(false);
			imgHotkey14.setVisible(false);
			imgHotkey15.setVisible(false);
			imgHotkey16.setVisible(false);
			hotkeyName1.setVisible(false);
			hotkeyName2.setVisible(false);
			hotkeyName3.setVisible(false);
			hotkeyName4.setVisible(false);
			hotkeyName5.setVisible(false);
			hotkeyName6.setVisible(false);
			hotkeyName7.setVisible(false);
			hotkeyName8.setVisible(false);
			hotkeyName9.setVisible(false);
			hotkeyName10.setVisible(false);
			hotkeyName11.setVisible(false);
			hotkeyName12.setVisible(false);
			hotkeyName13.setVisible(false);
			hotkeyName14.setVisible(false);
			hotkeyName15.setVisible(false);
			hotkeyName16.setVisible(false);
			hotkeyAction1.setVisible(false);
			hotkeyAction2.setVisible(false);
			hotkeyAction3.setVisible(false);
			hotkeyAction4.setVisible(false);
			hotkeyAction5.setVisible(false);
			hotkeyAction6.setVisible(false);
			hotkeyAction7.setVisible(false);
			hotkeyAction8.setVisible(false);
			hotkeyAction9.setVisible(false);
			hotkeyAction10.setVisible(false);
			hotkeyAction11.setVisible(false);
			hotkeyAction12.setVisible(false);
			hotkeyAction13.setVisible(false);
			hotkeyAction14.setVisible(false);
			hotkeyAction15.setVisible(false);
			hotkeyAction16.setVisible(false);
			imgResource1.setVisible(false);
			imgResource2.setVisible(false);
			imgResource3.setVisible(false);
			imgResource4.setVisible(false);
			imgResource5.setVisible(false);
			imgResource6.setVisible(false);
			imgResource7.setVisible(false);
			imgResource8.setVisible(false);
			imgWorker1.setVisible(false);
			imgWorker2.setVisible(false);
			imgWorker3.setVisible(false);
			imgWorker4.setVisible(false);
			imgWorker5.setVisible(false);
			imgWorker6.setVisible(false);
			imgWorker7.setVisible(false);
			imgWorker8.setVisible(false);
			lblAchievement1.setVisible(false);
			lblAchievement2.setVisible(false);
			lblAchievement3.setVisible(false);
			medalAchievement1.setVisible(false);
			medalAchievement2.setVisible(false);
			medalAchievement3.setVisible(false);
			achievementDesc1.setVisible(false);
			achievementDesc2.setVisible(false);
			achievementDesc3.setVisible(false);
		}
	}
	
	public void backMouseExited(MouseEvent event) {
		scene.setCursor(Cursor.DEFAULT);
		goBackButton.setImage(new Image("img/technical/button.png"));
	}
	
	public void backMouseEntered(MouseEvent event) {
		scene.setCursor(Cursor.HAND);
		goBackButton.setImage(new Image("img/technical/buttonMouse.png"));
	}
	
	public void backMousePressed(MouseEvent event) {
		goBackButton.setImage(new Image("img/technical/buttonPressed.png"));
	}
	
	public void backMouseReleased(MouseEvent event) {
		if (goBackIcon.isHover()) {
			goBackButton.setImage(new Image("img/technical/buttonMouse.png"));
			goBack();
		}
	}
	
	public void goBack() {
		if (inAchievement) {
			inAchievement = false;
			inAchievementSelect = true;
			activateAchievement();
		} else if (lblChangelog.isVisible()) {
			inOptions = true;
			activateOptions();
		}
	}
	
	public void logoutMouseExited(MouseEvent event) {
		scene.setCursor(Cursor.DEFAULT);
		logoutButton.setImage(new Image("img/technical/bigButton.png"));
	}
	
	public void logoutMouseEntered(MouseEvent event) {
		scene.setCursor(Cursor.HAND);
		logoutButton.setImage(new Image("img/technical/bigButtonMouse.png"));
	}
	
	public void logoutMousePressed(MouseEvent event) {
		logoutButton.setImage(new Image("img/technical/bigButtonPressed.png"));
	}
	
	public void logoutMouseReleased(MouseEvent event) {
		if (lblLogout.isHover()) {
			logoutButton.setImage(new Image("img/technical/bigButtonMouse.png"));
			logout();
		}
	}
	
	public void logout() {
		try {
			save();
			log = true;
			if (musicPlaying) clip.close();
			Stage primaryStage = new Stage();
	        Parent root = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
	        Scene scene = new Scene(root);
	        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Company Simulator");
			primaryStage.getIcons().add(new Image("img/technical/companyIcon.png"));
	        primaryStage.show();
	        Stage stage = (Stage) anchor.getScene().getWindow();
	        stage.close();
		} catch (Exception e) {}
	}
	
	public void competitorMouseExited(MouseEvent event) {
		scene.setCursor(Cursor.DEFAULT);
		competitorButton.setImage(new Image("img/technical/button.png"));
	}
	
	public void competitorMouseEntered(MouseEvent event) {
		scene.setCursor(Cursor.HAND);
		competitorButton.setImage(new Image("img/technical/buttonMouse.png"));
	}
	
	public void competitorMousePressed(MouseEvent event) {
		competitorButton.setImage(new Image("img/technical/buttonPressed.png"));
	}
	
	public void competitorMouseReleased(MouseEvent event) {
		if (competitorIcon.isHover()) {
			competitorButton.setImage(new Image("img/technical/buttonMouse.png"));
			activateCompetitor();
		}
	}
	
	public void activateCompetitor() {
		inOptions = false;
		inStorage = false;
		inAchievement = false;
		inAchievementSelect = false;
		inCompetitor = true;
		anchor.setOnMousePressed(null);
		anchor.setOnMouseReleased(null);
		anchor.setOnKeyReleased(null);
		lblCompetitorCompany.setVisible(true);
		imgCompetitorResource.setVisible(true);
		lblCompetitorName.setVisible(true);
		lblCompetitorPrice.setVisible(true);
		lblCompetitorPrice.setTextFill(Color.web("#000000"));
		lblCompetitorAmount.setVisible(true);
		lblChangelog.setVisible(false);
		lblCredits.setVisible(false);
		changelogButton.setVisible(false);
		changelogIcon.setVisible(false);
		consoleButton.setVisible(false);
		consoleIcon.setVisible(false);
		tutorialButton.setVisible(false);
		tutorialIcon.setVisible(false);
		musicButton.setVisible(false);
		keyButton.setVisible(false);
		keyIcon.setVisible(false);
		creditButton.setVisible(false);
		creditIcon.setVisible(false);
		storageTitle1.setVisible(false);
		storageTitle2.setVisible(false);
		storageResource1.setVisible(false);
		storageResource2.setVisible(false);
		storageResource3.setVisible(false);
		storageResource4.setVisible(false);
		storageResource5.setVisible(false);
		storageResource6.setVisible(false);
		storageResource7.setVisible(false);
		storageResource8.setVisible(false);
		storageWorker1.setVisible(false);
		storageWorker2.setVisible(false);
		storageWorker3.setVisible(false);
		storageWorker4.setVisible(false);
		storageWorker5.setVisible(false);
		storageWorker6.setVisible(false);
		storageWorker7.setVisible(false);
		storageWorker8.setVisible(false);
		lblPopUpTitle.setVisible(true);
		lblPopUpTitle.setText("Competitors");
		logoutButton.setVisible(false);
		lblLogout.setVisible(false);
		imgResource1.setVisible(false);
		imgResource2.setVisible(false);
		imgResource3.setVisible(false);
		imgResource4.setVisible(false);
		imgResource5.setVisible(false);
		imgResource6.setVisible(false);
		imgResource7.setVisible(false);
		imgResource8.setVisible(false);
		imgWorker1.setVisible(false);
		imgWorker2.setVisible(false);
		imgWorker3.setVisible(false);
		imgWorker4.setVisible(false);
		imgWorker5.setVisible(false);
		imgWorker6.setVisible(false);
		imgWorker7.setVisible(false);
		imgWorker8.setVisible(false);
		imgHotkey1.setVisible(false);
		imgHotkey2.setVisible(false);
		imgHotkey3.setVisible(false);
		imgHotkey4.setVisible(false);
		imgHotkey5.setVisible(false);
		imgHotkey6.setVisible(false);
		imgHotkey7.setVisible(false);
		imgHotkey8.setVisible(false);
		imgHotkey9.setVisible(false);
		imgHotkey10.setVisible(false);
		imgHotkey11.setVisible(false);
		imgHotkey12.setVisible(false);
		imgHotkey13.setVisible(false);
		imgHotkey14.setVisible(false);
		imgHotkey15.setVisible(false);
		imgHotkey16.setVisible(false);
		hotkeyName1.setVisible(false);
		hotkeyName2.setVisible(false);
		hotkeyName3.setVisible(false);
		hotkeyName4.setVisible(false);
		hotkeyName5.setVisible(false);
		hotkeyName6.setVisible(false);
		hotkeyName7.setVisible(false);
		hotkeyName8.setVisible(false);
		hotkeyName9.setVisible(false);
		hotkeyName10.setVisible(false);
		hotkeyName11.setVisible(false);
		hotkeyName12.setVisible(false);
		hotkeyName13.setVisible(false);
		hotkeyName14.setVisible(false);
		hotkeyName15.setVisible(false);
		hotkeyName16.setVisible(false);
		hotkeyAction1.setVisible(false);
		hotkeyAction2.setVisible(false);
		hotkeyAction3.setVisible(false);
		hotkeyAction4.setVisible(false);
		hotkeyAction5.setVisible(false);
		hotkeyAction6.setVisible(false);
		hotkeyAction7.setVisible(false);
		hotkeyAction8.setVisible(false);
		hotkeyAction9.setVisible(false);
		hotkeyAction10.setVisible(false);
		hotkeyAction11.setVisible(false);
		hotkeyAction12.setVisible(false);
		hotkeyAction13.setVisible(false);
		hotkeyAction14.setVisible(false);
		hotkeyAction15.setVisible(false);
		hotkeyAction16.setVisible(false);
		lblAchievement1.setVisible(false);
		lblAchievement2.setVisible(false);
		lblAchievement3.setVisible(false);
		medalAchievement1.setVisible(false);
		medalAchievement2.setVisible(false);
		medalAchievement3.setVisible(false);
		achievementDesc1.setVisible(false);
		achievementDesc2.setVisible(false);
		achievementDesc3.setVisible(false);
		if (competitorResource.equals("Fish")) imgCompetitorResource.setImage(new Image("img/resources/food/fish.png"));
		else if (competitorResource.equals("Steak")) imgCompetitorResource.setImage(new Image("img/resources/food/steak.png"));
		else if (competitorResource.equals("Pork")) imgCompetitorResource.setImage(new Image("img/resources/food/pork.png"));
		else if (competitorResource.equals("Chicken")) imgCompetitorResource.setImage(new Image("img/resources/food/chicken.png"));
		else if (competitorResource.equals("Mutton")) imgCompetitorResource.setImage(new Image("img/resources/food/mutton.png"));
		else if (competitorResource.equals("Coal")) imgCompetitorResource.setImage(new Image("img/resources/stone/coal.png"));
		else if (competitorResource.equals("Planks")) imgCompetitorResource.setImage(new Image("img/resources/wood/plank.png"));
		else if (competitorResource.equals("Cotton")) imgCompetitorResource.setImage(new Image("img/resources/crop/cotton.png"));
		lblCompetitorCompany.setText(competitorCompany);
		lblCompetitorName.setText(competitorResource);
		lblCompetitorPrice.setText("M$"+Double.toString(competitorPrice)+"0");
		if (competitorResource.equals("Fish")) {
			if (fishWhole > 0 && fishMerchant > 0) lblCompetitorAmount.setText(Long.toString(competitorWhole)+" ("+(double)Math.round(2*fishPrice/(competitorPrice+fishPrice)*10)/100+"/sec)");
			else lblCompetitorAmount.setText(Long.toString(competitorWhole)+" (0.2/sec)");
		} else if (competitorResource.equals("Steak")) {
			if (steakWhole > 0 && steakMerchant > 0) lblCompetitorAmount.setText(Long.toString(competitorWhole)+" ("+(double)Math.round(2*steakPrice/(competitorPrice+steakPrice)*10)/100+"/sec)");
			else lblCompetitorAmount.setText(Long.toString(competitorWhole)+" (0.2/sec)");
		} else if (competitorResource.equals("Pork")) {
			if (porkWhole > 0 && porkMerchant > 0) lblCompetitorAmount.setText(Long.toString(competitorWhole)+" ("+(double)Math.round(2*porkPrice/(competitorPrice+porkPrice)*10)/100+"/sec)");
			else lblCompetitorAmount.setText(Long.toString(competitorWhole)+" (0.2/sec)");
		} else if (competitorResource.equals("Chicken")) {
			if (chickenWhole > 0 && chickenMerchant > 0) lblCompetitorAmount.setText(Long.toString(competitorWhole)+" ("+(double)Math.round(2*chickenPrice/(competitorPrice+chickenPrice)*10)/100+"/sec)");
			else lblCompetitorAmount.setText(Long.toString(competitorWhole)+" (0.2/sec)");
		} else if (competitorResource.equals("Mutton")) {
			if (muttonWhole > 0 && muttonMerchant > 0) lblCompetitorAmount.setText(Long.toString(competitorWhole)+" ("+(double)Math.round(2*muttonPrice/(competitorPrice+muttonPrice)*10)/100+"/sec)");
			else lblCompetitorAmount.setText(Long.toString(competitorWhole)+" (0.2/sec)");
		} else if (competitorResource.equals("Coal")) {
			if (coalWhole > 0 && coalMerchant > 0) lblCompetitorAmount.setText(Long.toString(competitorWhole)+" ("+(double)Math.round(2*coalPrice/(competitorPrice+coalPrice)*10)/100+"/sec)");
			else lblCompetitorAmount.setText(Long.toString(competitorWhole)+" (0.2/sec)");
		} else if (competitorResource.equals("Planks")) {
			if (plankWhole > 0 && plankMerchant > 0) lblCompetitorAmount.setText(Long.toString(competitorWhole)+" ("+(double)Math.round(2*plankPrice/(competitorPrice+plankPrice)*10)/100+"/sec)");
			else lblCompetitorAmount.setText(Long.toString(competitorWhole)+" (0.2/sec)");
		} else if (competitorResource.equals("Cotton")) {
			if (cottonWhole > 0 && cottonMerchant > 0) lblCompetitorAmount.setText(Long.toString(competitorWhole)+" ("+(double)Math.round(2*cottonPrice/(competitorPrice+cottonPrice)*10)/100+"/sec)");
			else lblCompetitorAmount.setText(Long.toString(competitorWhole)+" (0.2/sec)");
		}
		imgPopUp.setVisible(true);
		closePopUp.setVisible(true);
		goBackButton.setVisible(false);
		goBackIcon.setVisible(false);
	}
	
	public void storageMouseEntered(MouseEvent event) {
		scene.setCursor(Cursor.HAND);
		storageButton.setImage(new Image("img/technical/buttonMouse.png"));
	}
	
	public void storageMouseExited(MouseEvent event) {
		scene.setCursor(Cursor.DEFAULT);
		storageButton.setImage(new Image("img/technical/button.png"));
	}
	
	public void storageMousePressed(MouseEvent event) {
		storageButton.setImage(new Image("img/technical/buttonPressed.png"));
	}
	
	public void storageMouseReleased(MouseEvent event) {
		if (storageIcon.isHover()) {
			storageButton.setImage(new Image("img/technical/buttonMouse.png"));
			activateStorage();
		}
	}
	
	public void activateStorage() {
		inOptions = false;
		inStorage = true;
		inAchievement = false;
		inAchievementSelect = false;
		inCompetitor = false;
		anchor.setOnMousePressed(null);
		anchor.setOnMouseReleased(null);
		anchor.setOnKeyReleased(null);
		lblCompetitorCompany.setVisible(false);
		imgCompetitorResource.setVisible(false);
		lblCompetitorName.setVisible(false);
		lblCompetitorPrice.setVisible(false);
		lblCompetitorAmount.setVisible(false);
		lblChangelog.setVisible(false);
		lblCredits.setVisible(false);
		changelogButton.setVisible(false);
		changelogIcon.setVisible(false);
		consoleButton.setVisible(false);
		consoleIcon.setVisible(false);
		tutorialButton.setVisible(false);
		tutorialIcon.setVisible(false);
		musicButton.setVisible(false);
		keyButton.setVisible(false);
		keyIcon.setVisible(false);
		creditButton.setVisible(false);
		creditIcon.setVisible(false);
		storageTitle1.setVisible(true);
		storageTitle2.setVisible(true);
		storageResource1.setVisible(true);
		storageResource2.setVisible(true);
		storageResource3.setVisible(true);
		storageResource4.setVisible(true);
		storageResource5.setVisible(true);
		storageResource6.setVisible(true);
		storageResource7.setVisible(true);
		storageResource8.setVisible(true);
		storageWorker1.setVisible(true);
		storageWorker2.setVisible(true);
		storageWorker3.setVisible(true);
		storageWorker4.setVisible(true);
		storageWorker5.setVisible(true);
		storageWorker6.setVisible(true);
		storageWorker7.setVisible(true);
		storageWorker8.setVisible(true);
		lblPopUpTitle.setVisible(true);
		lblPopUpTitle.setText("Storage");
		logoutButton.setVisible(false);
		lblLogout.setVisible(false);
		imgResource1.setVisible(true);
		imgResource2.setVisible(true);
		imgResource3.setVisible(true);
		imgResource4.setVisible(true);
		imgResource5.setVisible(true);
		imgResource6.setVisible(true);
		imgResource7.setVisible(true);
		imgResource8.setVisible(true);
		imgWorker1.setVisible(true);
		imgWorker2.setVisible(true);
		imgWorker3.setVisible(true);
		imgWorker4.setVisible(true);
		imgWorker5.setVisible(true);
		imgWorker6.setVisible(true);
		imgWorker7.setVisible(true);
		imgWorker8.setVisible(true);
		imgHotkey1.setVisible(false);
		imgHotkey2.setVisible(false);
		imgHotkey3.setVisible(false);
		imgHotkey4.setVisible(false);
		imgHotkey5.setVisible(false);
		imgHotkey6.setVisible(false);
		imgHotkey7.setVisible(false);
		imgHotkey8.setVisible(false);
		imgHotkey9.setVisible(false);
		imgHotkey10.setVisible(false);
		imgHotkey11.setVisible(false);
		imgHotkey12.setVisible(false);
		imgHotkey13.setVisible(false);
		imgHotkey14.setVisible(false);
		imgHotkey15.setVisible(false);
		imgHotkey16.setVisible(false);
		hotkeyName1.setVisible(false);
		hotkeyName2.setVisible(false);
		hotkeyName3.setVisible(false);
		hotkeyName4.setVisible(false);
		hotkeyName5.setVisible(false);
		hotkeyName6.setVisible(false);
		hotkeyName7.setVisible(false);
		hotkeyName8.setVisible(false);
		hotkeyName9.setVisible(false);
		hotkeyName10.setVisible(false);
		hotkeyName11.setVisible(false);
		hotkeyName12.setVisible(false);
		hotkeyName13.setVisible(false);
		hotkeyName14.setVisible(false);
		hotkeyName15.setVisible(false);
		hotkeyName16.setVisible(false);
		hotkeyAction1.setVisible(false);
		hotkeyAction2.setVisible(false);
		hotkeyAction3.setVisible(false);
		hotkeyAction4.setVisible(false);
		hotkeyAction5.setVisible(false);
		hotkeyAction6.setVisible(false);
		hotkeyAction7.setVisible(false);
		hotkeyAction8.setVisible(false);
		hotkeyAction9.setVisible(false);
		hotkeyAction10.setVisible(false);
		hotkeyAction11.setVisible(false);
		hotkeyAction12.setVisible(false);
		hotkeyAction13.setVisible(false);
		hotkeyAction14.setVisible(false);
		hotkeyAction15.setVisible(false);
		hotkeyAction16.setVisible(false);
		lblAchievement1.setVisible(false);
		lblAchievement2.setVisible(false);
		lblAchievement3.setVisible(false);
		medalAchievement1.setVisible(false);
		medalAchievement2.setVisible(false);
		medalAchievement3.setVisible(false);
		achievementDesc1.setVisible(false);
		achievementDesc2.setVisible(false);
		achievementDesc3.setVisible(false);
		imgPopUp.setVisible(true);
		closePopUp.setVisible(true);
		goBackButton.setVisible(false);
		goBackIcon.setVisible(false);
		storagePage = 1;
		changeStoragePage();
	}
	
	public void consoleMouseEntered(MouseEvent event) {
		scene.setCursor(Cursor.HAND);
		consoleButton.setImage(new Image("img/technical/buttonMouse.png"));
	}
	
	public void consoleMouseExited(MouseEvent event) {
		scene.setCursor(Cursor.DEFAULT);
		consoleButton.setImage(new Image("img/technical/button.png"));
	}
	
	public void consoleMousePressed(MouseEvent event) {
		consoleButton.setImage(new Image("img/technical/buttonPressed.png"));
	}
	
	public void consoleMouseReleased(MouseEvent event) {
		if (consoleIcon.isHover()) {
			consoleButton.setImage(new Image("img/technical/buttonMouse.png"));
			activateConsole();
		}
	}
	
	public void activateConsole() {
		try {
	        Stage primaryStage = new Stage();
	        Parent root = FXMLLoader.load(getClass().getResource("/application/Console.fxml"));
	        Scene scene = new Scene(root);
	        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Console");
			primaryStage.getIcons().add(new Image("img/technical/companyIcon.png"));
	        primaryStage.show();
		} catch (Exception e) {}
	}
	
	public void tutorialMouseEntered(MouseEvent event) {
		scene.setCursor(Cursor.HAND);
		tutorialButton.setImage(new Image("img/technical/buttonMouse.png"));
	}
	
	public void tutorialMouseExited(MouseEvent event) {
		scene.setCursor(Cursor.DEFAULT);
		tutorialButton.setImage(new Image("img/technical/button.png"));
	}
	
	public void tutorialMousePressed(MouseEvent event) {
		tutorialButton.setImage(new Image("img/technical/buttonPressed.png"));
	}
	
	public void tutorialMouseReleased(MouseEvent event) {
		if (tutorialIcon.isHover()) {
			tutorialButton.setImage(new Image("img/technical/buttonMouse.png"));
			activateTutorial();
		}
	}
	
	public void activateTutorial() {
		try {
	        Stage primaryStage = new Stage();
	        Parent root = FXMLLoader.load(getClass().getResource("/application/Tutorial"+resolution+".fxml"));
	        Scene scene = new Scene(root);
	        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Company Simulator");
			primaryStage.getIcons().add(new Image("img/technical/companyIcon.png"));
//			primaryStage.setFullScreen(true);
//			primaryStage.setFullScreenExitHint("");
//			primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
	        primaryStage.show();
	        Stage stage = (Stage) tutorialButton.getScene().getWindow();
	        stage.close();
		} catch (Exception e) {}
	}
	
	public void changelogMouseEntered(MouseEvent event) {
		scene.setCursor(Cursor.HAND);
		changelogButton.setImage(new Image("img/technical/buttonMouse.png"));
	}
	
	public void changelogMouseExited(MouseEvent event) {
		scene.setCursor(Cursor.DEFAULT);
		changelogButton.setImage(new Image("img/technical/button.png"));
	}
	
	public void changelogMousePressed(MouseEvent event) {
		changelogButton.setImage(new Image("img/technical/buttonPressed.png"));
	}
	
	public void changelogMouseReleased(MouseEvent event) {
		if (changelogIcon.isHover()) {
			changelogButton.setImage(new Image("img/technical/buttonMouse.png"));
			activateChangelog();
		}
	}
	
	public void activateChangelog() {
		try {
			inOptions = false;
			inStorage = false;
			inAchievement = false;
			inAchievementSelect = false;
			inCompetitor = false;
			anchor.setOnMousePressed(null);
			anchor.setOnMouseReleased(null);
			anchor.setOnKeyReleased(null);
			lblCompetitorCompany.setVisible(false);
			imgCompetitorResource.setVisible(false);
			lblCompetitorName.setVisible(false);
			lblCompetitorPrice.setVisible(false);
			lblCompetitorAmount.setVisible(false);
			lblChangelog.setVisible(true);
			lblCredits.setVisible(false);
			changelogButton.setVisible(false);
			changelogIcon.setVisible(false);
			consoleButton.setVisible(false);
			consoleIcon.setVisible(false);
			tutorialButton.setVisible(false);
			tutorialIcon.setVisible(false);
			musicButton.setVisible(false);
			keyButton.setVisible(false);
			keyIcon.setVisible(false);
			creditButton.setVisible(false);
			creditIcon.setVisible(false);
			storageTitle1.setVisible(false);
			storageTitle2.setVisible(false);
			storageResource1.setVisible(false);
			storageResource2.setVisible(false);
			storageResource3.setVisible(false);
			storageResource4.setVisible(false);
			storageResource5.setVisible(false);
			storageResource6.setVisible(false);
			storageResource7.setVisible(false);
			storageResource8.setVisible(false);
			storageWorker1.setVisible(false);
			storageWorker2.setVisible(false);
			storageWorker3.setVisible(false);
			storageWorker4.setVisible(false);
			storageWorker5.setVisible(false);
			storageWorker6.setVisible(false);
			storageWorker7.setVisible(false);
			storageWorker8.setVisible(false);
			imgPopUp.setVisible(true);
			closePopUp.setVisible(true);
			goBackButton.setVisible(true);
			goBackIcon.setVisible(true);
			lblPopUpTitle.setVisible(true);
			br = new BufferedReader(new FileReader("stats/changelog.stat"));
			lblPopUpTitle.setText(br.readLine());
			br.close();
			logoutButton.setVisible(false);
			lblLogout.setVisible(false);
			imgHotkey1.setVisible(false);
			imgHotkey2.setVisible(false);
			imgHotkey3.setVisible(false);
			imgHotkey4.setVisible(false);
			imgHotkey5.setVisible(false);
			imgHotkey6.setVisible(false);
			imgHotkey7.setVisible(false);
			imgHotkey8.setVisible(false);
			imgHotkey9.setVisible(false);
			imgHotkey10.setVisible(false);
			imgHotkey11.setVisible(false);
			imgHotkey12.setVisible(false);
			imgHotkey13.setVisible(false);
			imgHotkey14.setVisible(false);
			imgHotkey15.setVisible(false);
			imgHotkey16.setVisible(false);
			hotkeyName1.setVisible(false);
			hotkeyName2.setVisible(false);
			hotkeyName3.setVisible(false);
			hotkeyName4.setVisible(false);
			hotkeyName5.setVisible(false);
			hotkeyName6.setVisible(false);
			hotkeyName7.setVisible(false);
			hotkeyName8.setVisible(false);
			hotkeyName9.setVisible(false);
			hotkeyName10.setVisible(false);
			hotkeyName11.setVisible(false);
			hotkeyName12.setVisible(false);
			hotkeyName13.setVisible(false);
			hotkeyName14.setVisible(false);
			hotkeyName15.setVisible(false);
			hotkeyName16.setVisible(false);
			hotkeyAction1.setVisible(false);
			hotkeyAction2.setVisible(false);
			hotkeyAction3.setVisible(false);
			hotkeyAction4.setVisible(false);
			hotkeyAction5.setVisible(false);
			hotkeyAction6.setVisible(false);
			hotkeyAction7.setVisible(false);
			hotkeyAction8.setVisible(false);
			hotkeyAction9.setVisible(false);
			hotkeyAction10.setVisible(false);
			hotkeyAction11.setVisible(false);
			hotkeyAction12.setVisible(false);
			hotkeyAction13.setVisible(false);
			hotkeyAction14.setVisible(false);
			hotkeyAction15.setVisible(false);
			hotkeyAction16.setVisible(false);
			imgResource1.setVisible(false);
			imgResource2.setVisible(false);
			imgResource3.setVisible(false);
			imgResource4.setVisible(false);
			imgResource5.setVisible(false);
			imgResource6.setVisible(false);
			imgResource7.setVisible(false);
			imgResource8.setVisible(false);
			imgWorker1.setVisible(false);
			imgWorker2.setVisible(false);
			imgWorker3.setVisible(false);
			imgWorker4.setVisible(false);
			imgWorker5.setVisible(false);
			imgWorker6.setVisible(false);
			imgWorker7.setVisible(false);
			imgWorker8.setVisible(false);
			lblAchievement1.setVisible(false);
			lblAchievement2.setVisible(false);
			lblAchievement3.setVisible(false);
			medalAchievement1.setVisible(false);
			medalAchievement2.setVisible(false);
			medalAchievement3.setVisible(false);
			achievementDesc1.setVisible(false);
			achievementDesc2.setVisible(false);
			achievementDesc3.setVisible(false);
		} catch (Exception e) {}
	}
	
	public void achievementMouseEntered(MouseEvent event) {
		scene.setCursor(Cursor.HAND);
		achievementButton.setImage(new Image("img/technical/buttonMouse.png"));
	}
	
	public void achievementMouseExited(MouseEvent event) {
		scene.setCursor(Cursor.DEFAULT);
		achievementButton.setImage(new Image("img/technical/button.png"));
	}
	
	public void achievementMousePressed(MouseEvent event) {
		achievementButton.setImage(new Image("img/technical/buttonPressed.png"));
	}
	
	public void achievementMouseReleased(MouseEvent event) {
		if (achievementIcon.isHover()) {
			achievementButton.setImage(new Image("img/technical/buttonMouse.png"));
			activateAchievement();
		}
	}
	
	public void activateAchievement() {
		inOptions = false;
		inStorage = false;
		inAchievement = false;
		inAchievementSelect = true;
		inCompetitor = false;
		anchor.setOnMousePressed(null);
		anchor.setOnMouseReleased(null);
		anchor.setOnKeyReleased(null);
		lblCompetitorCompany.setVisible(false);
		imgCompetitorResource.setVisible(false);
		lblCompetitorName.setVisible(false);
		lblCompetitorPrice.setVisible(false);
		lblCompetitorAmount.setVisible(false);
		lblChangelog.setVisible(false);
		lblCredits.setVisible(false);
		changelogButton.setVisible(false);
		changelogIcon.setVisible(false);
		consoleButton.setVisible(false);
		consoleIcon.setVisible(false);
		tutorialButton.setVisible(false);
		tutorialIcon.setVisible(false);
		musicButton.setVisible(false);
		keyButton.setVisible(false);
		keyIcon.setVisible(false);
		creditButton.setVisible(false);
		creditIcon.setVisible(false);
		storageTitle1.setVisible(false);
		storageTitle2.setVisible(false);
		storageResource1.setVisible(true);
		storageResource2.setVisible(true);
		storageResource3.setVisible(true);
		storageResource4.setVisible(true);
		storageResource5.setVisible(true);
		storageResource6.setVisible(true);
		storageResource7.setVisible(true);
		storageResource8.setVisible(true);
		storageWorker1.setVisible(true);
		storageWorker2.setVisible(true);
		storageWorker3.setVisible(true);
		storageWorker4.setVisible(true);
		storageWorker5.setVisible(true);
		storageWorker6.setVisible(true);
		storageWorker7.setVisible(true);
		storageWorker8.setVisible(true);
		imgPopUp.setVisible(true);
		closePopUp.setVisible(true);
		goBackButton.setVisible(false);
		goBackIcon.setVisible(false);
		lblPopUpTitle.setVisible(true);
		lblPopUpTitle.setText("Achievements");
		logoutButton.setVisible(false);
		lblLogout.setVisible(false);
		imgHotkey1.setVisible(false);
		imgHotkey2.setVisible(false);
		imgHotkey3.setVisible(false);
		imgHotkey4.setVisible(false);
		imgHotkey5.setVisible(false);
		imgHotkey6.setVisible(false);
		imgHotkey7.setVisible(false);
		imgHotkey8.setVisible(false);
		imgHotkey9.setVisible(false);
		imgHotkey10.setVisible(false);
		imgHotkey11.setVisible(false);
		imgHotkey12.setVisible(false);
		imgHotkey13.setVisible(false);
		imgHotkey14.setVisible(false);
		imgHotkey15.setVisible(false);
		imgHotkey16.setVisible(false);
		hotkeyName1.setVisible(false);
		hotkeyName2.setVisible(false);
		hotkeyName3.setVisible(false);
		hotkeyName4.setVisible(false);
		hotkeyName5.setVisible(false);
		hotkeyName6.setVisible(false);
		hotkeyName7.setVisible(false);
		hotkeyName8.setVisible(false);
		hotkeyName9.setVisible(false);
		hotkeyName10.setVisible(false);
		hotkeyName11.setVisible(false);
		hotkeyName12.setVisible(false);
		hotkeyName13.setVisible(false);
		hotkeyName14.setVisible(false);
		hotkeyName15.setVisible(false);
		hotkeyName16.setVisible(false);
		hotkeyAction1.setVisible(false);
		hotkeyAction2.setVisible(false);
		hotkeyAction3.setVisible(false);
		hotkeyAction4.setVisible(false);
		hotkeyAction5.setVisible(false);
		hotkeyAction6.setVisible(false);
		hotkeyAction7.setVisible(false);
		hotkeyAction8.setVisible(false);
		hotkeyAction9.setVisible(false);
		hotkeyAction10.setVisible(false);
		hotkeyAction11.setVisible(false);
		hotkeyAction12.setVisible(false);
		hotkeyAction13.setVisible(false);
		hotkeyAction14.setVisible(false);
		hotkeyAction15.setVisible(false);
		hotkeyAction16.setVisible(false);
		imgResource1.setVisible(true);
		imgResource2.setVisible(true);
		imgResource3.setVisible(true);
		imgResource4.setVisible(true);
		imgResource5.setVisible(true);
		imgResource6.setVisible(true);
		imgResource7.setVisible(true);
		imgResource8.setVisible(true);
		imgWorker1.setVisible(true);
		imgWorker2.setVisible(true);
		imgWorker3.setVisible(true);
		imgWorker4.setVisible(true);
		imgWorker5.setVisible(true);
		imgWorker6.setVisible(true);
		imgWorker7.setVisible(true);
		imgWorker8.setVisible(true);
		lblAchievement1.setVisible(false);
		lblAchievement2.setVisible(false);
		lblAchievement3.setVisible(false);
		medalAchievement1.setVisible(false);
		medalAchievement2.setVisible(false);
		medalAchievement3.setVisible(false);
		achievementDesc1.setVisible(false);
		achievementDesc2.setVisible(false);
		achievementDesc3.setVisible(false);
		imgResource1.setImage(new Image("img/resources/food/food.png"));
		imgResource2.setImage(new Image("img/resources/food/fish.png"));
		imgResource3.setImage(new Image("img/resources/stone/stone.png"));
		imgResource4.setImage(new Image("img/resources/stone/coal.png"));
		imgResource5.setImage(new Image("img/resources/wood/wood.png"));
		imgResource6.setImage(new Image("img/resources/wood/plank.png"));
		imgResource7.setImage(new Image("img/resources/crop/crop.png"));
		imgResource8.setImage(new Image("img/resources/crop/cotton.png"));
		if (rank == 1) {
			imgWorker1.setImage(new Image("img/technical/rankup.png"));
			imgWorker2.setImage(null);
			imgWorker2.setVisible(false);
			imgWorker3.setImage(null);
			imgWorker3.setVisible(false);
			imgWorker4.setImage(null);
			imgWorker4.setVisible(false);
			imgWorker5.setImage(null);
			imgWorker5.setVisible(false);
			imgWorker6.setImage(null);
			imgWorker6.setVisible(false);
			imgWorker7.setImage(null);
			imgWorker7.setVisible(false);
			imgWorker8.setImage(null);
			imgWorker8.setVisible(false);
		} else if (rank == 2) {
			imgWorker1.setImage(new Image("img/resources/food/steak.png"));
			imgWorker2.setImage(new Image("img/resources/food/pork.png"));
			imgWorker3.setImage(new Image("img/resources/food/chicken.png"));
			imgWorker4.setImage(new Image("img/resources/food/mutton.png"));
			imgWorker5.setImage(new Image("img/technical/rankup.png"));
			imgWorker6.setImage(null);
			imgWorker6.setVisible(false);
			imgWorker7.setImage(null);
			imgWorker7.setVisible(false);
			imgWorker8.setImage(null);
			imgWorker8.setVisible(false);
		}
		storageResource1.setText("Food");
		storageResource2.setText("Fish");
		storageResource3.setText("Stone");
		storageResource4.setText("Coal");
		storageResource5.setText("Wood");
		storageResource6.setText("Planks");
		storageResource7.setText("Crops");
		storageResource8.setText("Cotton");
		if (rank == 1) {
			storageWorker1.setText("Rank Up");
			storageWorker2.setText("");
			storageWorker3.setText("");
			storageWorker4.setText("");
			storageWorker5.setText("");
			storageWorker6.setText("");
			storageWorker7.setText("");
			storageWorker8.setText("");
		} else if (rank == 2) {
			storageWorker1.setText("Steak");
			storageWorker2.setText("Pork");
			storageWorker3.setText("Chicken");
			storageWorker4.setText("Mutton");
			storageWorker5.setText("Rank Up");
			storageWorker6.setText("");
			storageWorker7.setText("");
			storageWorker8.setText("");
		}
		achievementPage = 1;
	}
	
	public void optionsMouseEntered(MouseEvent event) {
		scene.setCursor(Cursor.HAND);
		optionsButton.setImage(new Image("img/technical/buttonMouse.png"));
	}
	
	public void optionsMouseExited(MouseEvent event) {
		scene.setCursor(Cursor.DEFAULT);
		optionsButton.setImage(new Image("img/technical/button.png"));
	}
	
	public void optionsMousePressed(MouseEvent event) {
		optionsButton.setImage(new Image("img/technical/buttonPressed.png"));
	}
	
	public void optionsMouseReleased(MouseEvent event) {
		if (optionsIcon.isHover()) {
			optionsButton.setImage(new Image("img/technical/buttonMouse.png"));
			activateOptions();
		}
	}
	
	public void activateOptions() {
		inOptions = true;
		inStorage = false;
		inAchievement = false;
		inAchievementSelect = false;
		inCompetitor = false;
		anchor.setOnMousePressed(null);
		anchor.setOnMouseReleased(null);
		anchor.setOnKeyReleased(null);
		lblCompetitorCompany.setVisible(false);
		imgCompetitorResource.setVisible(false);
		lblCompetitorName.setVisible(false);
		lblCompetitorPrice.setVisible(false);
		lblCompetitorAmount.setVisible(false);
		lblChangelog.setVisible(false);
		lblCredits.setVisible(false);
		changelogButton.setVisible(true);
		changelogIcon.setVisible(true);
		consoleButton.setVisible(true);
		consoleIcon.setVisible(true);
		tutorialButton.setVisible(true);
		tutorialIcon.setVisible(true);
		musicButton.setVisible(true);
		keyButton.setVisible(true);
		keyIcon.setVisible(true);
		creditButton.setVisible(true);
		creditIcon.setVisible(true);
		storageTitle1.setVisible(false);
		storageTitle2.setVisible(false);
		storageResource1.setVisible(false);
		storageResource2.setVisible(false);
		storageResource3.setVisible(false);
		storageResource4.setVisible(false);
		storageResource5.setVisible(false);
		storageResource6.setVisible(false);
		storageResource7.setVisible(false);
		storageResource8.setVisible(false);
		storageWorker1.setVisible(false);
		storageWorker2.setVisible(false);
		storageWorker3.setVisible(false);
		storageWorker4.setVisible(false);
		storageWorker5.setVisible(false);
		storageWorker6.setVisible(false);
		storageWorker7.setVisible(false);
		storageWorker8.setVisible(false);
		imgPopUp.setVisible(true);
		closePopUp.setVisible(true);
		goBackButton.setVisible(false);
		goBackIcon.setVisible(false);
		lblPopUpTitle.setVisible(true);
		lblPopUpTitle.setText("Key Binds");
		logoutButton.setVisible(true);
		lblLogout.setVisible(true);
		imgHotkey1.setVisible(true);
		imgHotkey2.setVisible(true);
		imgHotkey3.setVisible(true);
		imgHotkey4.setVisible(true);
		imgHotkey5.setVisible(true);
		imgHotkey6.setVisible(true);
		imgHotkey7.setVisible(true);
		imgHotkey8.setVisible(true);
		imgHotkey9.setVisible(true);
		imgHotkey10.setVisible(true);
		imgHotkey11.setVisible(true);
		imgHotkey12.setVisible(true);
		imgHotkey13.setVisible(true);
		imgHotkey14.setVisible(true);
		imgHotkey15.setVisible(true);
		imgHotkey16.setVisible(true);
		hotkeyName1.setVisible(true);
		hotkeyName2.setVisible(true);
		hotkeyName3.setVisible(true);
		hotkeyName4.setVisible(true);
		hotkeyName5.setVisible(true);
		hotkeyName6.setVisible(true);
		hotkeyName7.setVisible(true);
		hotkeyName8.setVisible(true);
		hotkeyName9.setVisible(true);
		hotkeyName10.setVisible(true);
		hotkeyName11.setVisible(true);
		hotkeyName12.setVisible(true);
		hotkeyName13.setVisible(true);
		hotkeyName14.setVisible(true);
		hotkeyName15.setVisible(true);
		hotkeyName16.setVisible(true);
		hotkeyAction1.setVisible(true);
		hotkeyAction2.setVisible(true);
		hotkeyAction3.setVisible(true);
		hotkeyAction4.setVisible(true);
		hotkeyAction5.setVisible(true);
		hotkeyAction6.setVisible(true);
		hotkeyAction7.setVisible(true);
		hotkeyAction8.setVisible(true);
		hotkeyAction9.setVisible(true);
		hotkeyAction10.setVisible(true);
		hotkeyAction11.setVisible(true);
		hotkeyAction12.setVisible(true);
		hotkeyAction13.setVisible(true);
		hotkeyAction14.setVisible(true);
		hotkeyAction15.setVisible(true);
		hotkeyAction16.setVisible(true);
		imgResource1.setVisible(false);
		imgResource2.setVisible(false);
		imgResource3.setVisible(false);
		imgResource4.setVisible(false);
		imgResource5.setVisible(false);
		imgResource6.setVisible(false);
		imgResource7.setVisible(false);
		imgResource8.setVisible(false);
		imgWorker1.setVisible(false);
		imgWorker2.setVisible(false);
		imgWorker3.setVisible(false);
		imgWorker4.setVisible(false);
		imgWorker5.setVisible(false);
		imgWorker6.setVisible(false);
		imgWorker7.setVisible(false);
		imgWorker8.setVisible(false);
		lblAchievement1.setVisible(false);
		lblAchievement2.setVisible(false);
		lblAchievement3.setVisible(false);
		medalAchievement1.setVisible(false);
		medalAchievement2.setVisible(false);
		medalAchievement3.setVisible(false);
		achievementDesc1.setVisible(false);
		achievementDesc2.setVisible(false);
		achievementDesc3.setVisible(false);
		hotkeyName1.setText(hotkey(buyKey1));
		hotkeyName2.setText(hotkey(buyKey2));
		hotkeyName3.setText(hotkey(sellKey1));
		hotkeyName4.setText(hotkey(sellKey2));
		hotkeyName5.setText(hotkey(goToNext));
		hotkeyName6.setText(hotkey(goToPrev));
		hotkeyName7.setText(hotkey(goToFirst));
		hotkeyName8.setText(hotkey(goToLast));
		hotkeyName9.setText(hotkey(openStorage));
		hotkeyName10.setText(hotkey(openAchievement));
		hotkeyName11.setText(hotkey(openCompetitor));
		hotkeyName12.setText(hotkey(openOptions));
		hotkeyName13.setText(hotkey(increasePrice));
		hotkeyName14.setText(hotkey(decreasePrice));
		hotkeyName15.setText(hotkey(increaseMultiplier));
		hotkeyName16.setText(hotkey(decreaseMultiplier));
		optionsPage = 1;
	}
	
	public void keyMouseEntered(MouseEvent event) {
		scene.setCursor(Cursor.HAND);
		keyButton.setImage(new Image("img/technical/buttonMouse.png"));
	}
	
	public void keyMouseExited(MouseEvent event) {
		scene.setCursor(Cursor.DEFAULT);
		keyButton.setImage(new Image("img/technical/button.png"));
	}
	
	public void keyMousePressed(MouseEvent event) {
		keyButton.setImage(new Image("img/technical/buttonPressed.png"));
	}
	
	public void keyMouseReleased(MouseEvent event) {
		if (keyIcon.isHover()) {
			keyButton.setImage(new Image("img/technical/buttonMouse.png"));
			optionsPage = 1;
			changeOptionsPage();
		}
	}
	
	public void creditMouseEntered(MouseEvent event) {
		scene.setCursor(Cursor.HAND);
		creditButton.setImage(new Image("img/technical/buttonMouse.png"));
	}
	
	public void creditMouseExited(MouseEvent event) {
		scene.setCursor(Cursor.DEFAULT);
		creditButton.setImage(new Image("img/technical/button.png"));
	}
	
	public void creditMousePressed(MouseEvent event) {
		creditButton.setImage(new Image("img/technical/buttonPressed.png"));
	}
	
	public void creditMouseReleased(MouseEvent event) {
		if (creditIcon.isHover()) {
			creditButton.setImage(new Image("img/technical/buttonMouse.png"));
			optionsPage = 2;
			changeOptionsPage();
		}
	}
	
	public void activateCredits() {
		inOptions = true;
		inStorage = false;
		inAchievement = false;
		inAchievementSelect = false;
		inCompetitor = false;
		anchor.setOnMousePressed(null);
		anchor.setOnMouseReleased(null);
		anchor.setOnKeyReleased(null);
		lblCompetitorCompany.setVisible(false);
		imgCompetitorResource.setVisible(false);
		lblCompetitorName.setVisible(false);
		lblCompetitorPrice.setVisible(false);
		lblCompetitorAmount.setVisible(false);
		lblChangelog.setVisible(false);
		lblCredits.setVisible(true);
		lblCredits.setText("Background Music:\nhttp://www.bensound.com\n\nProgramming Engineer:\nRaul E. Hernandez\n\nGraphic Designer:\nRaul E. Hernandez");
		changelogButton.setVisible(true);
		changelogIcon.setVisible(true);
		consoleButton.setVisible(true);
		consoleIcon.setVisible(true);
		tutorialButton.setVisible(true);
		tutorialIcon.setVisible(true);
		musicButton.setVisible(true);
		keyButton.setVisible(true);
		keyIcon.setVisible(true);
		creditButton.setVisible(true);
		creditIcon.setVisible(true);
		storageTitle1.setVisible(false);
		storageTitle2.setVisible(false);
		storageResource1.setVisible(false);
		storageResource2.setVisible(false);
		storageResource3.setVisible(false);
		storageResource4.setVisible(false);
		storageResource5.setVisible(false);
		storageResource6.setVisible(false);
		storageResource7.setVisible(false);
		storageResource8.setVisible(false);
		storageWorker1.setVisible(false);
		storageWorker2.setVisible(false);
		storageWorker3.setVisible(false);
		storageWorker4.setVisible(false);
		storageWorker5.setVisible(false);
		storageWorker6.setVisible(false);
		storageWorker7.setVisible(false);
		storageWorker8.setVisible(false);
		imgPopUp.setVisible(true);
		closePopUp.setVisible(true);
		goBackButton.setVisible(false);
		goBackIcon.setVisible(false);
		lblPopUpTitle.setVisible(true);
		lblPopUpTitle.setText("Credits");
		logoutButton.setVisible(true);
		lblLogout.setVisible(true);
		imgHotkey1.setVisible(false);
		imgHotkey2.setVisible(false);
		imgHotkey3.setVisible(false);
		imgHotkey4.setVisible(false);
		imgHotkey5.setVisible(false);
		imgHotkey6.setVisible(false);
		imgHotkey7.setVisible(false);
		imgHotkey8.setVisible(false);
		imgHotkey9.setVisible(false);
		imgHotkey10.setVisible(false);
		imgHotkey11.setVisible(false);
		imgHotkey12.setVisible(false);
		imgHotkey13.setVisible(false);
		imgHotkey14.setVisible(false);
		imgHotkey15.setVisible(false);
		imgHotkey16.setVisible(false);
		hotkeyName1.setVisible(false);
		hotkeyName2.setVisible(false);
		hotkeyName3.setVisible(false);
		hotkeyName4.setVisible(false);
		hotkeyName5.setVisible(false);
		hotkeyName6.setVisible(false);
		hotkeyName7.setVisible(false);
		hotkeyName8.setVisible(false);
		hotkeyName9.setVisible(false);
		hotkeyName10.setVisible(false);
		hotkeyName11.setVisible(false);
		hotkeyName12.setVisible(false);
		hotkeyName13.setVisible(false);
		hotkeyName14.setVisible(false);
		hotkeyName15.setVisible(false);
		hotkeyName16.setVisible(false);
		hotkeyAction1.setVisible(false);
		hotkeyAction2.setVisible(false);
		hotkeyAction3.setVisible(false);
		hotkeyAction4.setVisible(false);
		hotkeyAction5.setVisible(false);
		hotkeyAction6.setVisible(false);
		hotkeyAction7.setVisible(false);
		hotkeyAction8.setVisible(false);
		hotkeyAction9.setVisible(false);
		hotkeyAction10.setVisible(false);
		hotkeyAction11.setVisible(false);
		hotkeyAction12.setVisible(false);
		hotkeyAction13.setVisible(false);
		hotkeyAction14.setVisible(false);
		hotkeyAction15.setVisible(false);
		hotkeyAction16.setVisible(false);
		imgResource1.setVisible(false);
		imgResource2.setVisible(false);
		imgResource3.setVisible(false);
		imgResource4.setVisible(false);
		imgResource5.setVisible(false);
		imgResource6.setVisible(false);
		imgResource7.setVisible(false);
		imgResource8.setVisible(false);
		imgWorker1.setVisible(false);
		imgWorker2.setVisible(false);
		imgWorker3.setVisible(false);
		imgWorker4.setVisible(false);
		imgWorker5.setVisible(false);
		imgWorker6.setVisible(false);
		imgWorker7.setVisible(false);
		imgWorker8.setVisible(false);
		lblAchievement1.setVisible(false);
		lblAchievement2.setVisible(false);
		lblAchievement3.setVisible(false);
		medalAchievement1.setVisible(false);
		medalAchievement2.setVisible(false);
		medalAchievement3.setVisible(false);
		achievementDesc1.setVisible(false);
		achievementDesc2.setVisible(false);
		achievementDesc3.setVisible(false);
	}
	
	public void musicMouseEntered(MouseEvent event) {
		scene.setCursor(Cursor.HAND);
		if (music) musicButton.setImage(new Image("img/technical/musicOnButtonMouse.png"));
		else musicButton.setImage(new Image("img/technical/musicOffButtonMouse.png"));
	}
	
	public void musicMouseExited(MouseEvent event) {
		scene.setCursor(Cursor.DEFAULT);
		if (music) musicButton.setImage(new Image("img/technical/musicOnButton.png"));
		else musicButton.setImage(new Image("img/technical/musicOffButton.png"));
	}
	
	public void musicMousePressed(MouseEvent event) {
		if (musicButton.isHover()) {
			if (music) musicButton.setImage(new Image("img/technical/musicOnButtonPressed.png"));
			else musicButton.setImage(new Image("img/technical/musicOffButtonPressed.png"));
		}
	}
	
	public void musicMouseReleased(MouseEvent event) {
		if (musicButton.isHover()) {
			toggleMusic();
			if (music) musicButton.setImage(new Image("img/technical/musicOnButtonMouse.png"));
			else musicButton.setImage(new Image("img/technical/musicOffButtonMouse.png"));
		} else {
			if (music) musicButton.setImage(new Image("img/technical/musicOnButton.png"));
			else musicButton.setImage(new Image("img/technical/musicOffButton.png"));
		}
	}
	
	public void toggleMusic() {
		if (music) {
			music = false;
			if (musicPlaying) clip.stop();
		} else music = true;
	}
	
	public void updateBuilding(long amount) {
		if (amount >= 2147483646) {
			bTop.setImage(new Image("img/buildings/top/tTier5.png"));
			bMiddle.setImage(new Image("img/buildings/middle/mTier5.png"));
			bBottom.setImage(new Image("img/buildings/bottom/bTier5.png"));
			bMiddle.setFitHeight(100+(amount/2147483646));
		} else if (amount >= 9938375) {
			bTop.setImage(new Image("img/buildings/top/tTier4.png"));
			bMiddle.setImage(new Image("img/buildings/middle/mTier4.png"));
			bBottom.setImage(new Image("img/buildings/bottom/bTier4.png"));
			bMiddle.setFitHeight(100+(amount/9938375));
		} else if (amount >= 46225) {
			bTop.setImage(new Image("img/buildings/top/tTier3.png"));
			bMiddle.setImage(new Image("img/buildings/middle/mTier3.png"));
			bBottom.setImage(new Image("img/buildings/bottom/bTier3.png"));
			bMiddle.setFitHeight(100+(amount/46225));
		} else if (amount >= 215) {
			bTop.setImage(new Image("img/buildings/top/tTier2.png"));
			bMiddle.setImage(new Image("img/buildings/middle/mTier2.png"));
			bBottom.setImage(new Image("img/buildings/bottom/bTier2.png"));
			bMiddle.setFitHeight(100+(amount/215));
		} else {
			bTop.setImage(new Image("img/buildings/top/tTier1.png"));
			bMiddle.setImage(new Image("img/buildings/middle/mTier1.png"));
			bBottom.setImage(new Image("img/buildings/bottom/bTier1.png"));
			bMiddle.setFitHeight(100+(amount));
		}
		bMiddle.setLayoutY(bBottom.getLayoutY()-bMiddle.getFitHeight());
		bTop.setLayoutY(bMiddle.getLayoutY()-25);
	}
	
	public void updateLabel(Label lbl, String start, long amount) {
		if (amount >= 1000000000) {
			formatter = new DecimalFormat("0.00E0");
			lbl.setText(start+formatter.format(amount));
		} else if (amount >= 1000000) {
			lbl.setText(start+(double)(amount-(amount%100000))/1000000+"M");
		} else if (amount >= 1000) {
			lbl.setText(start+(double)(amount-(amount%100))/1000+"K");
		} else {
			lbl.setText(start+amount);
		}
	}
	
	public void updateLabel(Label lbl, String start, long amount, long worker, double product) {
		String rate;
		if (worker*0.2-product >= 1000000000) {
			formatter = new DecimalFormat("0.00E0");
			rate = " ("+formatter.format(((double)(worker*rank*2-product))/10)+"/sec)";
		} else if (worker*0.2-product >= 1000000) {
			rate = " ("+((((double)(worker*rank*2-product))/10)-((((double)(worker*rank*2-product))/10)%100000))/1000000+"M/sec)";
		} else if (worker*0.2-product >= 1000) {
			rate = " ("+((((double)(worker*rank*2-product))/10)-((((double)(worker*rank*2-product))/10)%100))/1000+"K/sec)";
		} else rate = " ("+((double)(worker*rank*2-product))/10+"/sec)";
		
		if (amount >= 1000000000) {
			formatter = new DecimalFormat("0.00E0");
			lbl.setText(start+formatter.format(amount)+rate);
		} else if (amount >= 1000000) {
			lbl.setText(start+(double)(amount-(amount%100000))/1000000+"M"+rate);
		} else if (amount >= 1000) {
			lbl.setText(start+(double)(amount-(amount%100))/1000+"K"+rate);
		} else {
			lbl.setText(start+amount+rate);
		}
	}
	
	public void updateResource(long mWhole, double mDecimal, double income, double expense) {
		mDecimal += (((income*rank-expense)*timeElapsed)%1);
		if (mDecimal < 0 && mWhole >= 1) {
			mDecimal += 1;
			mWhole--;
		}
		mWhole += ((income*rank-expense)*timeElapsed-((income*rank-expense)*timeElapsed)%1);
		if (mDecimal >= 1) {
			mWhole += mDecimal-(mDecimal%1);
			mDecimal -= mDecimal-(mDecimal%1);
		}
		whole = mWhole;
		decimal = mDecimal;
	}
	
	public String formatNumber(long number) {
		if (number >= 1000000000) {
			formatter = new DecimalFormat("0.00E0");
			return formatter.format(number);
		} else if (number >= 1000000) {
			return (double)(number-(number%100000))/1000000+"M";
		} else if (number >= 1000) {
			return (double)(number-(number%100))/1000+"K";
		} else {
			return Long.toString(number);
		}
	}
	
	public double checkCompetitor(String resource, double price) {
		if (resource.equals(competitorResource)) return competitorPrice/(competitorPrice+price);
		else return 1;
	}
	
	public void save() {
		try {
			pw = new PrintWriter("stats/"+username+"/Stats.stat");
			pw.println(new TextEncryptor(Long.toString(rank)).encrypt());
			pw.println(new TextEncryptor(Long.toString(moneyWhole)).encrypt());
			pw.println(new TextEncryptor(Double.toString(moneyDecimal)).encrypt());
			pw.println(new TextEncryptor(Long.toString(startingTime)).encrypt());
			pw.println(new TextEncryptor(currentDate).encrypt());
			pw.println(new TextEncryptor(lastVersion).encrypt());
			pw.close();

			pw = new PrintWriter("stats/"+username+"/Food.stat");
			pw.println(new TextEncryptor(Long.toString(foodWhole)).encrypt());
			pw.println(new TextEncryptor(Double.toString(foodDecimal)).encrypt());
			pw.println(new TextEncryptor(Long.toString(rancher)).encrypt());
			pw.println(new TextEncryptor(Long.toString(fishWhole)).encrypt());
			pw.println(new TextEncryptor(Double.toString(fishDecimal)).encrypt());
			pw.println(new TextEncryptor(Long.toString(fisher)).encrypt());
			pw.println(new TextEncryptor(Long.toString(fishMerchant)).encrypt());
			pw.println(new TextEncryptor(Long.toString(steakWhole)).encrypt());
			pw.println(new TextEncryptor(Double.toString(steakDecimal)).encrypt());
			pw.println(new TextEncryptor(Long.toString(cowRancher)).encrypt());
			pw.println(new TextEncryptor(Long.toString(steakMerchant)).encrypt());
			pw.println(new TextEncryptor(Long.toString(porkWhole)).encrypt());
			pw.println(new TextEncryptor(Double.toString(porkDecimal)).encrypt());
			pw.println(new TextEncryptor(Long.toString(pigRancher)).encrypt());
			pw.println(new TextEncryptor(Long.toString(porkMerchant)).encrypt());
			pw.println(new TextEncryptor(Long.toString(chickenWhole)).encrypt());
			pw.println(new TextEncryptor(Double.toString(chickenDecimal)).encrypt());
			pw.println(new TextEncryptor(Long.toString(chickenRancher)).encrypt());
			pw.println(new TextEncryptor(Long.toString(chickenMerchant)).encrypt());
			pw.println(new TextEncryptor(Long.toString(muttonWhole)).encrypt());
			pw.println(new TextEncryptor(Double.toString(muttonDecimal)).encrypt());
			pw.println(new TextEncryptor(Long.toString(sheepRancher)).encrypt());
			pw.println(new TextEncryptor(Long.toString(muttonMerchant)).encrypt());
			pw.close();

			pw = new PrintWriter("stats/"+username+"/Stone.stat");
			pw.println(new TextEncryptor(Long.toString(stoneWhole)).encrypt());
			pw.println(new TextEncryptor(Double.toString(stoneDecimal)).encrypt());
			pw.println(new TextEncryptor(Long.toString(miner)).encrypt());
			pw.println(new TextEncryptor(Long.toString(coalWhole)).encrypt());
			pw.println(new TextEncryptor(Double.toString(coalDecimal)).encrypt());
			pw.println(new TextEncryptor(Long.toString(coalMiner)).encrypt());
			pw.println(new TextEncryptor(Long.toString(coalMerchant)).encrypt());
			pw.close();

			pw = new PrintWriter("stats/"+username+"/Wood.stat");
			pw.println(new TextEncryptor(Long.toString(woodWhole)).encrypt());
			pw.println(new TextEncryptor(Double.toString(woodDecimal)).encrypt());
			pw.println(new TextEncryptor(Long.toString(lumberjack)).encrypt());
			pw.println(new TextEncryptor(Long.toString(plankWhole)).encrypt());
			pw.println(new TextEncryptor(Double.toString(plankDecimal)).encrypt());
			pw.println(new TextEncryptor(Long.toString(woodCutter)).encrypt());
			pw.println(new TextEncryptor(Long.toString(plankMerchant)).encrypt());
			pw.close();

			pw = new PrintWriter("stats/"+username+"/Crop.stat");
			pw.println(new TextEncryptor(Long.toString(cropWhole)).encrypt());
			pw.println(new TextEncryptor(Double.toString(cropDecimal)).encrypt());
			pw.println(new TextEncryptor(Long.toString(farmer)).encrypt());
			pw.println(new TextEncryptor(Long.toString(cottonWhole)).encrypt());
			pw.println(new TextEncryptor(Double.toString(cottonDecimal)).encrypt());
			pw.println(new TextEncryptor(Long.toString(cottonFarmer)).encrypt());
			pw.println(new TextEncryptor(Long.toString(cottonMerchant)).encrypt());
			pw.close();

			pw = new PrintWriter("stats/"+username+"/Prices.stat");
			pw.println(new TextEncryptor(Double.toString(fishPrice)).encrypt());
			pw.println(new TextEncryptor(Double.toString(coalPrice)).encrypt());
			pw.println(new TextEncryptor(Double.toString(plankPrice)).encrypt());
			pw.println(new TextEncryptor(Double.toString(cottonPrice)).encrypt());
			pw.close();
			
			pw = new PrintWriter("stats/"+username+"/Competitor.stat");
			pw.println(new TextEncryptor(Long.toString(competitorTime)).encrypt());
			pw.println(new TextEncryptor(Long.toString(competitorWhole)).encrypt());
			pw.println(new TextEncryptor(Double.toString(competitorDecimal)).encrypt());
			pw.println(new TextEncryptor(Double.toString(competitorPrice)).encrypt());
			pw.println(new TextEncryptor(competitorResource).encrypt());
			pw.println(new TextEncryptor(competitorCompany).encrypt());
			pw.close();
		} catch (Exception e) {}
	}
	
	public void checkConsole() {
		try {
			br = new BufferedReader(new FileReader("stats/console.stat"));
			longvar = Long.parseLong(br.readLine());
			if (longvar == 1) {
				rank = 1;
	            moneyWhole = 0;
	            moneyDecimal = 0;
	            startingTime = milliTime();
	            currentDate = "";
	            lastVersion = "";
	
	            foodWhole = 0;
	            foodDecimal = 0;
	            rancher = 0;
	            fishWhole = 0;
	            fishDecimal = 0;
	            fisher = 0;
	            fishMerchant = 0;
	            
	            steakWhole = 0;
	            steakDecimal = 0;
	            cowRancher = 0;
	            steakMerchant = 0;
	            
	            porkWhole = 0;
	            porkDecimal = 0;
	            pigRancher = 0;
	            porkMerchant = 0;
	            
	            chickenWhole = 0;
	            chickenDecimal = 0;
	            chickenRancher = 0;
	            chickenMerchant = 0;
	            
	            muttonWhole = 0;
	            muttonDecimal = 0;
	            sheepRancher = 0;
	            muttonMerchant = 0;
	
	            stoneWhole = 0;
	            stoneDecimal = 0;
	            miner = 0;
	            coalWhole = 0;
	            coalDecimal = 0;
	            coalMiner = 0;
	            coalMerchant = 0;
	
	            woodWhole = 0;
	            woodDecimal = 0;
	            lumberjack = 0;
	            plankWhole = 0;
	            plankDecimal = 0;
	            woodCutter = 0;
	            plankMerchant = 0;
	
	            cropWhole = 0;
	            cropDecimal = 0;
	            farmer = 0;
	            cottonWhole = 0;
	            cottonDecimal = 0;
	            cottonFarmer = 0;
	            cottonMerchant = 0;
	
				fishPrice = 1.0;
				coalPrice = 1.0;
				plankPrice = 1.0;
				cottonPrice = 1.0;
				steakPrice = 1.0;
				porkPrice = 1.0;
				chickenPrice = 1.0;
				muttonPrice = 1.0;
				
				pw = new PrintWriter("stats/"+username+"/Prices.stat");
				pw.println(new TextEncryptor("1.0").encrypt());
				pw.println(new TextEncryptor("1.0").encrypt());
				pw.println(new TextEncryptor("1.0").encrypt());
				pw.println(new TextEncryptor("1.0").encrypt());
				pw.println(new TextEncryptor("1.0").encrypt());
				pw.println(new TextEncryptor("1.0").encrypt());
				pw.println(new TextEncryptor("1.0").encrypt());
				pw.println(new TextEncryptor("1.0").encrypt());
				pw.close();
	            
	            buyKey1 = KeyCode.W;
	            buyKey2 = KeyCode.R;
	            sellKey1 = KeyCode.S;
	            sellKey2 = KeyCode.F;
	            goToNext = KeyCode.D;
	            goToPrev = KeyCode.A;
	            goToFirst = KeyCode.HOME;
	            goToLast = KeyCode.END;
	            openStorage = KeyCode.B;
	            openAchievement = KeyCode.N;
	            openCompetitor = KeyCode.M;
	            openOptions = KeyCode.ESCAPE;
	            increasePrice = KeyCode.E;
	            decreasePrice = KeyCode.Q;
	            increaseMultiplier = KeyCode.V;
	            decreaseMultiplier = KeyCode.C;
	
				pw = new PrintWriter("stats/"+username+"/Keys.stat");
				pw.println(new TextEncryptor(buyKey1.toString()).encrypt());
				pw.println(new TextEncryptor(buyKey2.toString()).encrypt());
				pw.println(new TextEncryptor(sellKey1.toString()).encrypt());
				pw.println(new TextEncryptor(sellKey2.toString()).encrypt());
				pw.println(new TextEncryptor(goToNext.toString()).encrypt());
				pw.println(new TextEncryptor(goToPrev.toString()).encrypt());
				pw.println(new TextEncryptor(goToFirst.toString()).encrypt());
				pw.println(new TextEncryptor(goToLast.toString()).encrypt());
				pw.println(new TextEncryptor(openStorage.toString()).encrypt());
				pw.println(new TextEncryptor(openAchievement.toString()).encrypt());
				pw.println(new TextEncryptor(openCompetitor.toString()).encrypt());
				pw.println(new TextEncryptor(openOptions.toString()).encrypt());
				pw.println(new TextEncryptor(increasePrice.toString()).encrypt());
				pw.println(new TextEncryptor(decreasePrice.toString()).encrypt());
				pw.println(new TextEncryptor(increaseMultiplier.toString()).encrypt());
				pw.println(new TextEncryptor(decreaseMultiplier.toString()).encrypt());
				pw.close();
	            
	            pw = new PrintWriter("stats/"+username+"/Achievements.stat");
	            for (int i = 0;i < 13;i++) pw.println(new TextEncryptor("0").encrypt());
	            pw.close();
	            for (int i=0;i<13;i++) {
	            	achievement[i] = 0;
	            }
	            
	            pw = new PrintWriter("stats/"+username+"/Competitor.stat");
				pw.println(new TextEncryptor(Long.toString(milliTime())).encrypt());
				pw.println(new TextEncryptor(Long.toString(100*(long)Math.pow(rank, 2))).encrypt());
				pw.println(new TextEncryptor("0.0").encrypt());
				pw.println(new TextEncryptor(Double.toString((double)(rand.nextInt(20)+1)/10)).encrypt());
				double number = rand.nextInt(8);
				if (rank == 1) number = rand.nextInt(4);
				else if (rank == 2) number = rand.nextInt(8);
				if (number == 0) pw.println(new TextEncryptor("Fish").encrypt());
				else if (number == 1) pw.println(new TextEncryptor("Coal").encrypt());
				else if (number == 2) pw.println(new TextEncryptor("Planks").encrypt());
				else if (number == 3) pw.println(new TextEncryptor("Cotton").encrypt());
				else if (number == 4) pw.println(new TextEncryptor("Steak").encrypt());
				else if (number == 5) pw.println(new TextEncryptor("Pork").encrypt());
				else if (number == 6) pw.println(new TextEncryptor("Chicken").encrypt());
				else if (number == 7) pw.println(new TextEncryptor("Mutton").encrypt());
				number = rand.nextInt(3);
				if (number == 0) pw.println(new TextEncryptor("Moneyz Inc.").encrypt());
				else if (number == 1) pw.println(new TextEncryptor("Ge Co.").encrypt());
				else if (number == 2) pw.println(new TextEncryptor("Simulator Creator").encrypt());
				pw.close();
				br = new BufferedReader(new FileReader("stats/"+username+"/Competitor.stat"));
				competitorTime = Long.parseLong(new TextEncryptor(br.readLine()).decrypt());
				competitorWhole = Long.parseLong(new TextEncryptor(br.readLine()).decrypt());
				competitorDecimal = Double.parseDouble(new TextEncryptor(br.readLine()).decrypt());
				competitorPrice = Double.parseDouble(new TextEncryptor(br.readLine()).decrypt());
				competitorResource = new TextEncryptor(br.readLine()).decrypt();
				competitorCompany = new TextEncryptor(br.readLine()).decrypt();
				br.close();
				
				achievementButton.setImage(new Image("img/technical/button.png"));
	            save();
			} else if (longvar == 2) {
				long amount = Long.parseLong(br.readLine());
				moneyWhole += amount;
				foodWhole += amount;
				fishWhole += amount;
				steakWhole += amount;
				porkWhole += amount;
				chickenWhole += amount;
				muttonWhole += amount;
				stoneWhole += amount;
				coalWhole += amount;
				woodWhole += amount;
				plankWhole += amount;
				cropWhole += amount;
				cottonWhole += amount;
				rancher += amount;
				fisher += amount;
				cowRancher += amount;
				pigRancher += amount;
				chickenRancher += amount;
				sheepRancher += amount;
				miner += amount;
				coalMiner += amount;
				lumberjack += amount;
				woodCutter += amount;
				farmer += amount;
				cottonFarmer += amount;
				fishMerchant += amount;
				steakMerchant += amount;
				porkMerchant += amount;
				chickenMerchant += amount;
				muttonMerchant += amount;
				coalMerchant += amount;
				plankMerchant += amount;
				cottonMerchant += amount;
				save();
			} else if (longvar == 3) {
				long amount = Long.parseLong(br.readLine());
				foodWhole += amount;
				save();
			} else if (longvar == 4) {
				long amount = Long.parseLong(br.readLine());
				fishWhole += amount;
				save();
			} else if (longvar == 5) {
				long amount = Long.parseLong(br.readLine());
				stoneWhole += amount;
				save();
			} else if (longvar == 6) {
				long amount = Long.parseLong(br.readLine());
				coalWhole += amount;
				save();
			} else if (longvar == 7) {
				long amount = Long.parseLong(br.readLine());
				woodWhole += amount;
				save();
			} else if (longvar == 8) {
				long amount = Long.parseLong(br.readLine());
				plankWhole += amount;
				save();
			} else if (longvar == 9) {
				long amount = Long.parseLong(br.readLine());
				cropWhole += amount;
				save();
			} else if (longvar == 10) {
				long amount = Long.parseLong(br.readLine());
				cottonWhole += amount;
				save();
			} else if (longvar == 11) {
				long amount = Long.parseLong(br.readLine());
				rancher += amount;
				save();
			} else if (longvar == 12) {
				long amount = Long.parseLong(br.readLine());
				fisher += amount;
				save();
			} else if (longvar == 13) {
				long amount = Long.parseLong(br.readLine());
				miner += amount;
				save();
			} else if (longvar == 14) {
				long amount = Long.parseLong(br.readLine());
				coalMiner += amount;
				save();
			} else if (longvar == 15) {
				long amount = Long.parseLong(br.readLine());
				lumberjack += amount;
				save();
			} else if (longvar == 16) {
				long amount = Long.parseLong(br.readLine());
				woodCutter += amount;
				save();
			} else if (longvar == 17) {
				long amount = Long.parseLong(br.readLine());
				farmer += amount;
				save();
			} else if (longvar == 18) {
				long amount = Long.parseLong(br.readLine());
				cottonFarmer += amount;
				save();
			} else if (longvar == 19) {
				long amount = Long.parseLong(br.readLine());
				fishMerchant += amount;
				save();
			} else if (longvar == 20) {
				long amount = Long.parseLong(br.readLine());
				coalMerchant += amount;
				save();
			} else if (longvar == 21) {
				long amount = Long.parseLong(br.readLine());
				plankMerchant += amount;
				save();
			} else if (longvar == 22) {
				long amount = Long.parseLong(br.readLine());
				cottonMerchant += amount;
				save();
			} else if (longvar == 23) {
				long amount = Long.parseLong(br.readLine());
				moneyWhole += amount;
				save();
			} else if (longvar == 24) {
				long amount = Long.parseLong(br.readLine());
				steakWhole += amount;
				save();
			} else if (longvar == 25) {
				long amount = Long.parseLong(br.readLine());
				porkWhole += amount;
				save();
			} else if (longvar == 26) {
				long amount = Long.parseLong(br.readLine());
				chickenWhole += amount;
				save();
			} else if (longvar == 27) {
				long amount = Long.parseLong(br.readLine());
				muttonWhole += amount;
				save();
			} else if (longvar == 28) {
				long amount = Long.parseLong(br.readLine());
				cowRancher += amount;
				save();
			} else if (longvar == 29) {
				long amount = Long.parseLong(br.readLine());
				pigRancher += amount;
				save();
			} else if (longvar == 30) {
				long amount = Long.parseLong(br.readLine());
				chickenRancher += amount;
				save();
			} else if (longvar == 31) {
				long amount = Long.parseLong(br.readLine());
				sheepRancher += amount;
				save();
			} else if (longvar == 32) {
				long amount = Long.parseLong(br.readLine());
				steakMerchant += amount;
				save();
			} else if (longvar == 33) {
				long amount = Long.parseLong(br.readLine());
				porkMerchant += amount;
				save();
			} else if (longvar == 34) {
				long amount = Long.parseLong(br.readLine());
				chickenMerchant += amount;
				save();
			} else if (longvar == 35) {
				long amount = Long.parseLong(br.readLine());
				muttonMerchant += amount;
				save();
			} else if (longvar == 36) {
				long amount = Long.parseLong(br.readLine());
				rank = amount;
				imgRank.setImage(new Image("img/ranks/rank"+rank+".png"));
				save();
			} else if (longvar == 37) {
				String song = br.readLine();
				if (clip.isRunning()) {
					clip.stop();
					clip.close();
				}
				audioInputStream = AudioSystem.getAudioInputStream(new File("sound/"+song+".wav").getAbsoluteFile());
	            clip = AudioSystem.getClip();
	            clip.open(audioInputStream);
	            clip.start();
	            musicPlaying = true;
				save();
			} else if (longvar == 1000) {
				save();
				pw = new PrintWriter("stats/console.stat");
				pw.println("0");
				pw.close();
				System.exit(0);
			}
			br.close();
			
			pw = new PrintWriter("stats/console.stat");
			pw.println("0");
			pw.close();
		} catch (Exception e) {}
	}
	
	public void checkAchievements() {
		try {
			long[] resourceWhole = new long[12];
			resourceWhole[0] = foodWhole;
			resourceWhole[1] = fishWhole;
			resourceWhole[2] = stoneWhole;
			resourceWhole[3] = coalWhole;
			resourceWhole[4] = woodWhole;
			resourceWhole[5] = plankWhole;
			resourceWhole[6] = cropWhole;
			resourceWhole[7] = cottonWhole;
			resourceWhole[8] = steakWhole;
			resourceWhole[9] = porkWhole;
			resourceWhole[10] = chickenWhole;
			resourceWhole[11] = muttonWhole;
			
			for (int i = 1;i <= resourceWhole.length;i++) {
				if (resourceWhole[i-1] >= 1000*((long)Math.pow(Math.sqrt(10),achievement[i]))) {
					achievement[i]++;
					if (!inAchievement) achievementButton.setImage(new Image("img/technical/buttonMouse.png"));
				}
			}
			
			if (foodWhole >= 10000 && fishWhole >= 10000 && stoneWhole >= 10000 && coalWhole >= 10000 && woodWhole >= 10000 && plankWhole >= 10000 && cropWhole >= 10000 && cottonWhole >= 10000 && rancher >= 100 && fisher >= 100 && miner >= 100 && coalMiner >= 100 && lumberjack >= 100 && woodCutter >= 100 && farmer >= 100 && cottonFarmer >= 100 && fishMerchant >= 100 && coalMerchant >= 100 && plankMerchant >= 100 && cottonMerchant >= 100 && rank == 1) {
				achievement[0] = 1;
				rank = 2;
				imgRank.setImage(new Image("img/ranks/rank"+rank+".png"));
				if (!inAchievement) {
					achievementButton.setImage(new Image("img/technical/buttonMouse.png"));
				}
			}
			
			pw = new PrintWriter("stats/"+username+"/Achievements.stat");
			for (int i=0;i<achievement.length;i++) {
				pw.println(new TextEncryptor(Long.toString(achievement[i])).encrypt());
			}
			pw.close();
		} catch (Exception e) {}
		
	}
	
	public void checkFood() {
		if (rancher*rank >= fisher*2+cowRancher*2+pigRancher*2+chickenRancher*2+sheepRancher*2 || foodWhole > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed-((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1) || foodDecimal > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1 || foodWhole > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed-((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1)) {
			updateResource(foodWhole, foodDecimal, rancher*0.0002, fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004);
			foodWhole = whole;
			foodDecimal = decimal;
		}
		
		if ((rancher*rank >= fisher*2+cowRancher*2+pigRancher*2+chickenRancher*2+sheepRancher*2 || foodWhole > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed-((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1) || foodDecimal > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1 || foodWhole > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed-((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1)) && (fisher*rank >= fishMerchant*checkCompetitor("Fish",fishPrice) || fishWhole > -((fisher*0.0002*rank-fishMerchant*0.0002*checkCompetitor("Fish",fishPrice))*timeElapsed-((fisher*0.0002*rank-fishMerchant*0.0002*checkCompetitor("Fish",fishPrice))*timeElapsed)%1) || fishDecimal > -((fisher*0.0002*rank-fishMerchant*0.0002*checkCompetitor("Fish",fishPrice))*timeElapsed)%1)) {
			updateResource(fishWhole, fishDecimal, fisher*0.0002, 0);
			fishWhole = whole;
			fishDecimal = decimal;
		}
		
		if ((rancher*rank >= fisher*2+cowRancher*2+pigRancher*2+chickenRancher*2+sheepRancher*2 || foodWhole > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed-((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1) || foodDecimal > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1 || foodWhole > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed-((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1)) && (cowRancher*rank >= steakMerchant*checkCompetitor("Steak",steakPrice) || steakWhole > -((cowRancher*0.0002*rank-steakMerchant*0.0002*checkCompetitor("Steak",steakPrice))*timeElapsed-((cowRancher*0.0002*rank-steakMerchant*0.0002*checkCompetitor("Steak",steakPrice))*timeElapsed)%1) || steakDecimal > -((cowRancher*0.0002*rank-steakMerchant*0.0002*checkCompetitor("Steak",steakPrice))*timeElapsed)%1)) {
			updateResource(steakWhole, steakDecimal, cowRancher*0.0002, 0);
			steakWhole = whole;
			steakDecimal = decimal;
		}
		
		if ((rancher*rank >= fisher*2+cowRancher*2+pigRancher*2+chickenRancher*2+sheepRancher*2 || foodWhole > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed-((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1) || foodDecimal > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1 || foodWhole > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed-((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1)) && (pigRancher*rank >= porkMerchant*checkCompetitor("Pork",porkPrice) || porkWhole > -((pigRancher*0.0002*rank-porkMerchant*0.0002*checkCompetitor("Pork",porkPrice))*timeElapsed-((pigRancher*0.0002*rank-porkMerchant*0.0002*checkCompetitor("Pork",porkPrice))*timeElapsed)%1) || porkDecimal > -((pigRancher*0.0002*rank-porkMerchant*0.0002*checkCompetitor("Pork",porkPrice))*timeElapsed)%1)) {
			updateResource(porkWhole, porkDecimal, pigRancher*0.0002, 0);
			porkWhole = whole;
			porkDecimal = decimal;
		}
		
		if ((rancher*rank >= fisher*2+cowRancher*2+pigRancher*2+chickenRancher*2+sheepRancher*2 || foodWhole > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed-((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1) || foodDecimal > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1 || foodWhole > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed-((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1)) && (chickenRancher*rank >= chickenMerchant*checkCompetitor("Chicken",chickenPrice) || chickenWhole > -((chickenRancher*0.0002*rank-chickenMerchant*0.0002*checkCompetitor("Chicken",chickenPrice))*timeElapsed-((chickenRancher*0.0002*rank-chickenMerchant*0.0002*checkCompetitor("Chicken",chickenPrice))*timeElapsed)%1) || chickenDecimal > -((chickenRancher*0.0002*rank-chickenMerchant*0.0002*checkCompetitor("Chicken",chickenPrice))*timeElapsed)%1)) {
			updateResource(chickenWhole, chickenDecimal, chickenRancher*0.0002, 0);
			chickenWhole = whole;
			chickenDecimal = decimal;
		}
		
		if ((rancher*rank >= fisher*2+cowRancher*2+pigRancher*2+chickenRancher*2+sheepRancher*2 || foodWhole > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed-((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1) || foodDecimal > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1 || foodWhole > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed-((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1)) && (sheepRancher*rank >= muttonMerchant*checkCompetitor("Mutton",muttonPrice) || muttonWhole > -((sheepRancher*0.0002*rank-muttonMerchant*0.0002*checkCompetitor("Mutton",muttonPrice))*timeElapsed-((sheepRancher*0.0002*rank-muttonMerchant*0.0002*checkCompetitor("Mutton",muttonPrice))*timeElapsed)%1) || muttonDecimal > -((sheepRancher*0.0002*rank-muttonMerchant*0.0002*checkCompetitor("Mutton",muttonPrice))*timeElapsed)%1)) {
			updateResource(muttonWhole, muttonDecimal, sheepRancher*0.0002, 0);
			muttonWhole = whole;
			muttonDecimal = decimal;
		}
		
		if ((rancher*rank >= fisher*2+cowRancher*2+pigRancher*2+chickenRancher*2+sheepRancher*2 || foodWhole > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed-((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1) || foodDecimal > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1 || foodWhole > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed-((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1)) && fisher*rank >= fishMerchant*checkCompetitor("Fish",fishPrice) || fishWhole > -((fisher*0.0002*rank-fishMerchant*0.0002*checkCompetitor("Fish",fishPrice))*timeElapsed-((fisher*0.0002*rank-fishMerchant*0.0002*checkCompetitor("Fish",fishPrice))*timeElapsed)%1) || fishDecimal > -((fisher*0.0002*rank-fishMerchant*0.0002*checkCompetitor("Fish",fishPrice))*timeElapsed)%1) {
			updateResource(moneyWhole, moneyDecimal, fishMerchant*0.0002*checkCompetitor("Fish",fishPrice), 0);
			moneyWhole = whole;
			moneyDecimal = decimal;
			updateResource(fishWhole, fishDecimal, 0, fishMerchant*0.0002*checkCompetitor("Fish",fishPrice));
			fishWhole = whole;
			fishDecimal = decimal;
		}
		
		if ((rancher*rank >= fisher*2+cowRancher*2+pigRancher*2+chickenRancher*2+sheepRancher*2 || foodWhole > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed-((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1) || foodDecimal > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1 || foodWhole > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed-((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1)) && cowRancher*rank >= steakMerchant*checkCompetitor("Steak",steakPrice) || steakWhole > -((cowRancher*0.0002*rank-steakMerchant*0.0002*checkCompetitor("Steak",steakPrice))*timeElapsed-((cowRancher*0.0002*rank-steakMerchant*0.0002*checkCompetitor("Steak",steakPrice))*timeElapsed)%1) || steakDecimal > -((cowRancher*0.0002*rank-steakMerchant*0.0002*checkCompetitor("Steak",steakPrice))*timeElapsed)%1) {
			updateResource(moneyWhole, moneyDecimal, steakMerchant*0.0002*checkCompetitor("Steak",steakPrice), 0);
			moneyWhole = whole;
			moneyDecimal = decimal;
			updateResource(steakWhole, steakDecimal, 0, steakMerchant*0.0002*checkCompetitor("Steak",steakPrice));
			steakWhole = whole;
			steakDecimal = decimal;
		}
		
		if ((rancher*rank >= fisher*2+cowRancher*2+pigRancher*2+chickenRancher*2+sheepRancher*2 || foodWhole > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed-((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1) || foodDecimal > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1 || foodWhole > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed-((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1)) && pigRancher*rank >= porkMerchant*checkCompetitor("Pork",porkPrice) || porkWhole > -((pigRancher*0.0002*rank-porkMerchant*0.0002*checkCompetitor("Pork",porkPrice))*timeElapsed-((pigRancher*0.0002*rank-porkMerchant*0.0002*checkCompetitor("Pork",porkPrice))*timeElapsed)%1) || porkDecimal > -((pigRancher*0.0002*rank-porkMerchant*0.0002*checkCompetitor("Pork",porkPrice))*timeElapsed)%1) {
			updateResource(moneyWhole, moneyDecimal, porkMerchant*0.0002*checkCompetitor("Pork",porkPrice), 0);
			moneyWhole = whole;
			moneyDecimal = decimal;
			updateResource(porkWhole, porkDecimal, 0, porkMerchant*0.0002*checkCompetitor("Pork",porkPrice));
			porkWhole = whole;
			porkDecimal = decimal;
		}
		
		if ((rancher*rank >= fisher*2+cowRancher*2+pigRancher*2+chickenRancher*2+sheepRancher*2 || foodWhole > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed-((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1) || foodDecimal > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1 || foodWhole > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed-((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1)) && chickenRancher*rank >= chickenMerchant*checkCompetitor("Chicken",chickenPrice) || chickenWhole > -((chickenRancher*0.0002*rank-chickenMerchant*0.0002*checkCompetitor("Chicken",chickenPrice))*timeElapsed-((chickenRancher*0.0002*rank-chickenMerchant*0.0002*checkCompetitor("Chicken",chickenPrice))*timeElapsed)%1) || chickenDecimal > -((chickenRancher*0.0002*rank-chickenMerchant*0.0002*checkCompetitor("Chicken",chickenPrice))*timeElapsed)%1) {
			updateResource(moneyWhole, moneyDecimal, chickenMerchant*0.0002*checkCompetitor("Chicken",chickenPrice), 0);
			moneyWhole = whole;
			moneyDecimal = decimal;
			updateResource(chickenWhole, chickenDecimal, 0, chickenMerchant*0.0002*checkCompetitor("Chicken",chickenPrice));
			chickenWhole = whole;
			chickenDecimal = decimal;
		}
		
		if ((rancher*rank >= fisher*2+cowRancher*2+pigRancher*2+chickenRancher*2+sheepRancher*2 || foodWhole > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed-((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1) || foodDecimal > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1 || foodWhole > -((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed-((rancher*0.0002*rank-(fisher*0.0004+cowRancher*0.0004+pigRancher*0.0004+chickenRancher*0.0004+sheepRancher*0.0004))*timeElapsed)%1)) && sheepRancher*rank >= muttonMerchant*checkCompetitor("Mutton",muttonPrice) || muttonWhole > -((sheepRancher*0.0002*rank-muttonMerchant*0.0002*checkCompetitor("Mutton",muttonPrice))*timeElapsed-((sheepRancher*0.0002*rank-muttonMerchant*0.0002*checkCompetitor("Mutton",muttonPrice))*timeElapsed)%1) || muttonDecimal > -((sheepRancher*0.0002*rank-muttonMerchant*0.0002*checkCompetitor("Mutton",muttonPrice))*timeElapsed)%1) {
			updateResource(moneyWhole, moneyDecimal, muttonMerchant*0.0002*checkCompetitor("Mutton",muttonPrice), 0);
			moneyWhole = whole;
			moneyDecimal = decimal;
			updateResource(muttonWhole, muttonDecimal, 0, muttonMerchant*0.0002*checkCompetitor("Mutton",muttonPrice));
			muttonWhole = whole;
			muttonDecimal = decimal;
		}
	}
	
	public void checkStone() {
		if (miner*rank >= coalMiner*2 || stoneWhole > -((miner*0.0002*rank-coalMiner*0.0004)*timeElapsed-((miner*0.0002*rank-coalMiner*0.0004)*timeElapsed)%1) || stoneDecimal > -((miner*0.0002*rank-coalMiner*0.0004)*timeElapsed)%1 || stoneWhole > -((miner*0.0002*rank-coalMiner*0.0004)*timeElapsed-((miner*0.0002*rank-coalMiner*0.0004)*timeElapsed)%1)) {
			updateResource(stoneWhole, stoneDecimal, miner*0.0002, coalMiner*0.0004);
			stoneWhole = whole;
			stoneDecimal = decimal;
		}
		if ((miner*rank >= coalMiner*2 || stoneWhole > -((miner*0.0002*rank-coalMiner*0.0004)*timeElapsed-((miner*0.0002*rank-coalMiner*0.0004)*timeElapsed)%1) || stoneDecimal > -((miner*0.0002*rank-coalMiner*0.0004)*timeElapsed)%1 || stoneWhole > -((miner*0.0002*rank-coalMiner*0.0004)*timeElapsed-((miner*0.0002*rank-coalMiner*0.0004)*timeElapsed)%1)) && (coalMiner*rank >= coalMerchant*checkCompetitor("Coal",coalPrice) || coalWhole > -((coalMiner*0.0002*rank-coalMerchant*0.0002*checkCompetitor("Coal",coalPrice))*timeElapsed-((coalMiner*0.0002*rank-coalMerchant*0.0002*checkCompetitor("Coal",coalPrice))*timeElapsed)%1) || coalDecimal > -((coalMiner*0.0002*rank-coalMerchant*0.0002*checkCompetitor("Coal",coalPrice))*timeElapsed)%1)) {
			updateResource(coalWhole, coalDecimal, coalMiner*0.0002, 0);
			coalWhole = whole;
			coalDecimal = decimal;
		}
		if ((miner*rank >= coalMiner*2 || stoneWhole > -((miner*0.0002*rank-coalMiner*0.0004)*timeElapsed-((miner*0.0002*rank-coalMiner*0.0004)*timeElapsed)%1) || stoneDecimal > -((miner*0.0002*rank-coalMiner*0.0004)*timeElapsed)%1 || stoneWhole > -((miner*0.0002*rank-coalMiner*0.0004)*timeElapsed-((miner*0.0002*rank-coalMiner*0.0004)*timeElapsed)%1)) && coalMiner*rank >= coalMerchant*checkCompetitor("Coal",coalPrice) || coalWhole > -((coalMiner*0.0002*rank-coalMerchant*0.0002*checkCompetitor("Coal",coalPrice))*timeElapsed-((coalMiner*0.0002*rank-coalMerchant*0.0002*checkCompetitor("Coal",coalPrice))*timeElapsed)%1) || coalDecimal > -((coalMiner*0.0002*rank-coalMerchant*0.0002*checkCompetitor("Coal",coalPrice))*timeElapsed)%1) {
			updateResource(moneyWhole, moneyDecimal, coalMerchant*0.0002*checkCompetitor("Coal",coalPrice), 0);
			moneyWhole = whole;
			moneyDecimal = decimal;
			updateResource(coalWhole, coalDecimal, 0, coalMerchant*0.0002*checkCompetitor("Coal",coalPrice));
			coalWhole = whole;
			coalDecimal = decimal;
		}
	}
	
	public void checkWood() {
		if (lumberjack*rank >= woodCutter*2 || woodWhole > -((lumberjack*0.0002*rank-woodCutter*0.0004)*timeElapsed-((lumberjack*0.0002*rank-woodCutter*0.0004)*timeElapsed)%1) || woodDecimal > -((lumberjack*0.0002*rank-woodCutter*0.0004)*timeElapsed)%1 || woodWhole > -((lumberjack*0.0002*rank-woodCutter*0.0004)*timeElapsed-((lumberjack*0.0002*rank-woodCutter*0.0004)*timeElapsed)%1)) {
			updateResource(woodWhole, woodDecimal, lumberjack*0.0002, woodCutter*0.0004);
			woodWhole = whole;
			woodDecimal = decimal;
		}
		if ((lumberjack*rank >= woodCutter*2 || woodWhole > -((lumberjack*0.0002*rank-woodCutter*0.0004)*timeElapsed-((lumberjack*0.0002*rank-woodCutter*0.0004)*timeElapsed)%1) || woodDecimal > -((lumberjack*0.0002*rank-woodCutter*0.0004)*timeElapsed)%1 || woodWhole > -((lumberjack*0.0002*rank-woodCutter*0.0004)*timeElapsed-((lumberjack*0.0002*rank-woodCutter*0.0004)*timeElapsed)%1)) && (woodCutter*rank >= plankMerchant*checkCompetitor("Planks",plankPrice) || plankWhole > -((woodCutter*0.0002*rank-plankMerchant*0.0002*checkCompetitor("Planks",plankPrice))*timeElapsed-((woodCutter*0.0002*rank-plankMerchant*0.0002*checkCompetitor("Planks",plankPrice))*timeElapsed)%1) || plankDecimal > -((woodCutter*0.0002*rank-plankMerchant*0.0002*checkCompetitor("Planks",plankPrice))*timeElapsed)%1)) {
			updateResource(plankWhole, plankDecimal, woodCutter*0.0002, 0);
			plankWhole = whole;
			plankDecimal = decimal;
		}
		if ((lumberjack*rank >= woodCutter*2 || woodWhole > -((lumberjack*0.0002*rank-woodCutter*0.0004)*timeElapsed-((lumberjack*0.0002*rank-woodCutter*0.0004)*timeElapsed)%1) || woodDecimal > -((lumberjack*0.0002*rank-woodCutter*0.0004)*timeElapsed)%1 || woodWhole > -((lumberjack*0.0002*rank-woodCutter*0.0004)*timeElapsed-((lumberjack*0.0002*rank-woodCutter*0.0004)*timeElapsed)%1)) && woodCutter*rank >= plankMerchant*checkCompetitor("Planks",plankPrice) || plankWhole > -((woodCutter*0.0002*rank-plankMerchant*0.0002*checkCompetitor("Planks",plankPrice))*timeElapsed-((woodCutter*0.0002*rank-plankMerchant*0.0002*checkCompetitor("Planks",plankPrice))*timeElapsed)%1) || plankDecimal > -((woodCutter*0.0002*rank-plankMerchant*0.0002*checkCompetitor("Planks",plankPrice))*timeElapsed)%1) {
			updateResource(moneyWhole, moneyDecimal, plankMerchant*0.0002*checkCompetitor("Planks",plankPrice), 0);
			moneyWhole = whole;
			moneyDecimal = decimal;
			updateResource(plankWhole, plankDecimal, 0, plankMerchant*0.0002*checkCompetitor("Planks",plankPrice));
			plankWhole = whole;
			plankDecimal = decimal;
		}
	}
	
	public void checkCrops() {
		if (farmer*rank >= cottonFarmer*2 || cropWhole > -((farmer*0.0002*rank-cottonFarmer*0.0004)*timeElapsed-((farmer*0.0002*rank-cottonFarmer*0.0004)*timeElapsed)%1) || cropDecimal > -((farmer*0.0002*rank-cottonFarmer*0.0004)*timeElapsed)%1 || cropWhole > -((farmer*0.0002*rank-cottonFarmer*0.0004)*timeElapsed-((farmer*0.0002*rank-cottonFarmer*0.0004)*timeElapsed)%1)) {
			updateResource(cropWhole, cropDecimal, farmer*0.0002, cottonFarmer*0.0004);
			cropWhole = whole;
			cropDecimal = decimal;
		}
		if ((farmer*rank >= cottonFarmer*2 || cropWhole > -((farmer*0.0002*rank-cottonFarmer*0.0004)*timeElapsed-((farmer*0.0002*rank-cottonFarmer*0.0004)*timeElapsed)%1) || cropDecimal > -((farmer*0.0002*rank-cottonFarmer*0.0004)*timeElapsed)%1 || cropWhole > -((farmer*0.0002*rank-cottonFarmer*0.0004)*timeElapsed-((farmer*0.0002*rank-cottonFarmer*0.0004)*timeElapsed)%1)) && (cottonFarmer*rank >= cottonMerchant*checkCompetitor("Cotton",cottonPrice) || cottonWhole > -((cottonFarmer*0.0002*rank-cottonMerchant*0.0002*checkCompetitor("Cotton",cottonPrice))*timeElapsed-((cottonFarmer*0.0002*rank-cottonMerchant*0.0002*checkCompetitor("Cotton",cottonPrice))*timeElapsed)%1) || cottonDecimal > -((cottonFarmer*0.0002*rank-cottonMerchant*0.0002*checkCompetitor("Cotton",cottonPrice))*timeElapsed)%1)) {
			updateResource(cottonWhole, cottonDecimal, cottonFarmer*0.0002, 0);
			cottonWhole = whole;
			cottonDecimal = decimal;
		}
		if ((farmer*rank >= cottonFarmer*2 || cropWhole > -((farmer*0.0002*rank-cottonFarmer*0.0004)*timeElapsed-((farmer*0.0002*rank-cottonFarmer*0.0004)*timeElapsed)%1) || cropDecimal > -((farmer*0.0002*rank-cottonFarmer*0.0004)*timeElapsed)%1 || cropWhole > -((farmer*0.0002*rank-cottonFarmer*0.0004)*timeElapsed-((farmer*0.0002*rank-cottonFarmer*0.0004)*timeElapsed)%1)) && cottonFarmer*rank >= cottonMerchant*checkCompetitor("Cotton",cottonPrice) || cottonWhole > -((cottonFarmer*0.0002*rank-cottonMerchant*0.0002*checkCompetitor("Cotton",cottonPrice))*timeElapsed-((cottonFarmer*0.0002*rank-cottonMerchant*0.0002*checkCompetitor("Cotton",cottonPrice))*timeElapsed)%1) || cottonDecimal > -((cottonFarmer*0.0002*rank-cottonMerchant*0.0002*checkCompetitor("Cotton",cottonPrice))*timeElapsed)%1) {
			updateResource(moneyWhole, moneyDecimal, cottonMerchant*0.0002*checkCompetitor("Cotton",cottonPrice), 0);
			moneyWhole = whole;
			moneyDecimal = decimal;
			updateResource(cottonWhole, cottonDecimal, 0, cottonMerchant*0.0002*checkCompetitor("Cotton",cottonPrice));
			cottonWhole = whole;
			cottonDecimal = decimal;
		}
	}
	
	public void checkCompetitor() {
		try {
			if (competitorResource.equals("Fish")) {
				if (fishWhole > 0 && fishMerchant > 0) {
					competitorDecimal -= (timeElapsed*0.0002*fishPrice/(competitorPrice+fishPrice))%1;
					if (competitorDecimal < 0 && competitorWhole >= 1) {
						competitorDecimal += 1;
						competitorWhole--;
					}
					competitorWhole -= (timeElapsed*0.0002*fishPrice/(competitorPrice+fishPrice)-(timeElapsed*0.0002*fishPrice/(competitorPrice+fishPrice))%1);
					if (competitorDecimal >= 1) {
						competitorWhole += competitorDecimal-(competitorDecimal%1);
						competitorDecimal -= competitorDecimal-(competitorDecimal%1);
					}
					lblCompetitorAmount.setText(Long.toString(competitorWhole)+" ("+-(double)Math.round(2*fishPrice/(competitorPrice+fishPrice)*10)/100+"/sec)");
				} else {
					competitorDecimal -= (timeElapsed*0.0002)%1;
					if (competitorDecimal < 0 && competitorWhole >= 1) {
						competitorDecimal += 1;
						competitorWhole--;
					}
					competitorWhole -= (timeElapsed*0.0002-(timeElapsed*0.0002)%1);
					if (competitorDecimal >= 1) {
						competitorWhole += competitorDecimal-(competitorDecimal%1);
						competitorDecimal -= competitorDecimal-(competitorDecimal%1);
					}
					lblCompetitorAmount.setText(Long.toString(competitorWhole)+" (-0.2/sec)");
				}
			} else if (competitorResource.equals("Steak")) {
				if (steakWhole > 0 && steakMerchant > 0) {
					competitorDecimal -= (timeElapsed*0.0002*steakPrice/(competitorPrice+steakPrice))%1;
					if (competitorDecimal < 0 && competitorWhole >= 1) {
						competitorDecimal += 1;
						competitorWhole--;
					}
					competitorWhole -= (timeElapsed*0.0002*steakPrice/(competitorPrice+steakPrice)-(timeElapsed*0.0002*steakPrice/(competitorPrice+steakPrice))%1);
					if (competitorDecimal >= 1) {
						competitorWhole += competitorDecimal-(competitorDecimal%1);
						competitorDecimal -= competitorDecimal-(competitorDecimal%1);
					}
					lblCompetitorAmount.setText(Long.toString(competitorWhole)+" ("+-(double)Math.round(2*steakPrice/(competitorPrice+steakPrice)*10)/100+"/sec)");
				} else {
					competitorDecimal -= (timeElapsed*0.0002)%1;
					if (competitorDecimal < 0 && competitorWhole >= 1) {
						competitorDecimal += 1;
						competitorWhole--;
					}
					competitorWhole -= (timeElapsed*0.0002-(timeElapsed*0.0002)%1);
					if (competitorDecimal >= 1) {
						competitorWhole += competitorDecimal-(competitorDecimal%1);
						competitorDecimal -= competitorDecimal-(competitorDecimal%1);
					}
					lblCompetitorAmount.setText(Long.toString(competitorWhole)+" (-0.2/sec)");
				}
			} else if (competitorResource.equals("Pork")) {
				if (porkWhole > 0 && porkMerchant > 0) {
					competitorDecimal -= (timeElapsed*0.0002*porkPrice/(competitorPrice+porkPrice))%1;
					if (competitorDecimal < 0 && competitorWhole >= 1) {
						competitorDecimal += 1;
						competitorWhole--;
					}
					competitorWhole -= (timeElapsed*0.0002*porkPrice/(competitorPrice+porkPrice)-(timeElapsed*0.0002*porkPrice/(competitorPrice+porkPrice))%1);
					if (competitorDecimal >= 1) {
						competitorWhole += competitorDecimal-(competitorDecimal%1);
						competitorDecimal -= competitorDecimal-(competitorDecimal%1);
					}
					lblCompetitorAmount.setText(Long.toString(competitorWhole)+" ("+-(double)Math.round(2*porkPrice/(competitorPrice+porkPrice)*10)/100+"/sec)");
				} else {
					competitorDecimal -= (timeElapsed*0.0002)%1;
					if (competitorDecimal < 0 && competitorWhole >= 1) {
						competitorDecimal += 1;
						competitorWhole--;
					}
					competitorWhole -= (timeElapsed*0.0002-(timeElapsed*0.0002)%1);
					if (competitorDecimal >= 1) {
						competitorWhole += competitorDecimal-(competitorDecimal%1);
						competitorDecimal -= competitorDecimal-(competitorDecimal%1);
					}
					lblCompetitorAmount.setText(Long.toString(competitorWhole)+" (-0.2/sec)");
				}
			} else if (competitorResource.equals("Chicken")) {
				if (chickenWhole > 0 && chickenMerchant > 0) {
					competitorDecimal -= (timeElapsed*0.0002*chickenPrice/(competitorPrice+chickenPrice))%1;
					if (competitorDecimal < 0 && competitorWhole >= 1) {
						competitorDecimal += 1;
						competitorWhole--;
					}
					competitorWhole -= (timeElapsed*0.0002*chickenPrice/(competitorPrice+chickenPrice)-(timeElapsed*0.0002*chickenPrice/(competitorPrice+chickenPrice))%1);
					if (competitorDecimal >= 1) {
						competitorWhole += competitorDecimal-(competitorDecimal%1);
						competitorDecimal -= competitorDecimal-(competitorDecimal%1);
					}
					lblCompetitorAmount.setText(Long.toString(competitorWhole)+" ("+-(double)Math.round(2*chickenPrice/(competitorPrice+chickenPrice)*10)/100+"/sec)");
				} else {
					competitorDecimal -= (timeElapsed*0.0002)%1;
					if (competitorDecimal < 0 && competitorWhole >= 1) {
						competitorDecimal += 1;
						competitorWhole--;
					}
					competitorWhole -= (timeElapsed*0.0002-(timeElapsed*0.0002)%1);
					if (competitorDecimal >= 1) {
						competitorWhole += competitorDecimal-(competitorDecimal%1);
						competitorDecimal -= competitorDecimal-(competitorDecimal%1);
					}
					lblCompetitorAmount.setText(Long.toString(competitorWhole)+" (-0.2/sec)");
				}
			} else if (competitorResource.equals("Mutton")) {
				if (muttonWhole > 0 && muttonMerchant > 0) {
					competitorDecimal -= (timeElapsed*0.0002*muttonPrice/(competitorPrice+muttonPrice))%1;
					if (competitorDecimal < 0 && competitorWhole >= 1) {
						competitorDecimal += 1;
						competitorWhole--;
					}
					competitorWhole -= (timeElapsed*0.0002*muttonPrice/(competitorPrice+muttonPrice)-(timeElapsed*0.0002*muttonPrice/(competitorPrice+muttonPrice))%1);
					if (competitorDecimal >= 1) {
						competitorWhole += competitorDecimal-(competitorDecimal%1);
						competitorDecimal -= competitorDecimal-(competitorDecimal%1);
					}
					lblCompetitorAmount.setText(Long.toString(competitorWhole)+" ("+-(double)Math.round(2*muttonPrice/(competitorPrice+muttonPrice)*10)/100+"/sec)");
				} else {
					competitorDecimal -= (timeElapsed*0.0002)%1;
					if (competitorDecimal < 0 && competitorWhole >= 1) {
						competitorDecimal += 1;
						competitorWhole--;
					}
					competitorWhole -= (timeElapsed*0.0002-(timeElapsed*0.0002)%1);
					if (competitorDecimal >= 1) {
						competitorWhole += competitorDecimal-(competitorDecimal%1);
						competitorDecimal -= competitorDecimal-(competitorDecimal%1);
					}
					lblCompetitorAmount.setText(Long.toString(competitorWhole)+" (-0.2/sec)");
				}
			} else if (competitorResource.equals("Coal")) {
				if (coalWhole > 0 && coalMerchant > 0) {
					competitorDecimal -= (timeElapsed*0.0002*coalPrice/(competitorPrice+coalPrice))%1;
					if (competitorDecimal < 0 && competitorWhole >= 1) {
						competitorDecimal += 1;
						competitorWhole--;
					}
					competitorWhole -= (timeElapsed*0.0002*coalPrice/(competitorPrice+coalPrice)-(timeElapsed*0.0002*coalPrice/(competitorPrice+coalPrice))%1);
					if (competitorDecimal >= 1) {
						competitorWhole += competitorDecimal-(competitorDecimal%1);
						competitorDecimal -= competitorDecimal-(competitorDecimal%1);
					}
					lblCompetitorAmount.setText(Long.toString(competitorWhole)+" ("+-(double)Math.round(2*coalPrice/(competitorPrice+coalPrice)*10)/100+"/sec)");
				} else {
					competitorDecimal -= (timeElapsed*0.0002)%1;
					if (competitorDecimal < 0 && competitorWhole >= 1) {
						competitorDecimal += 1;
						competitorWhole--;
					}
					competitorWhole -= (timeElapsed*0.0002-(timeElapsed*0.0002)%1);
					if (competitorDecimal >= 1) {
						competitorWhole += competitorDecimal-(competitorDecimal%1);
						competitorDecimal -= competitorDecimal-(competitorDecimal%1);
					}
					lblCompetitorAmount.setText(Long.toString(competitorWhole)+" (-0.2/sec)");
				}
			} else if (competitorResource.equals("Planks")) {
				if (plankWhole > 0 && plankMerchant > 0) {
					competitorDecimal -= (timeElapsed*0.0002*plankPrice/(competitorPrice+plankPrice))%1;
					if (competitorDecimal < 0 && competitorWhole >= 1) {
						competitorDecimal += 1;
						competitorWhole--;
					}
					competitorWhole -= (timeElapsed*0.0002*plankPrice/(competitorPrice+plankPrice)-(timeElapsed*0.0002*plankPrice/(competitorPrice+plankPrice))%1);
					if (competitorDecimal >= 1) {
						competitorWhole += competitorDecimal-(competitorDecimal%1);
						competitorDecimal -= competitorDecimal-(competitorDecimal%1);
					}
					lblCompetitorAmount.setText(Long.toString(competitorWhole)+" ("+-(double)Math.round(2*plankPrice/(competitorPrice+plankPrice)*10)/100+"/sec)");
				} else {
					competitorDecimal -= (timeElapsed*0.0002)%1;
					if (competitorDecimal < 0 && competitorWhole >= 1) {
						competitorDecimal += 1;
						competitorWhole--;
					}
					competitorWhole -= (timeElapsed*0.0002-(timeElapsed*0.0002)%1);
					if (competitorDecimal >= 1) {
						competitorWhole += competitorDecimal-(competitorDecimal%1);
						competitorDecimal -= competitorDecimal-(competitorDecimal%1);
					}
					lblCompetitorAmount.setText(Long.toString(competitorWhole)+" (-0.2/sec)");
				}
			} else if (competitorResource.equals("Cotton")) {
				if (cottonWhole > 0 && cottonMerchant > 0) {
					competitorDecimal -= (timeElapsed*0.0002*cottonPrice/(competitorPrice+cottonPrice))%1;
					if (competitorDecimal < 0 && competitorWhole >= 1) {
						competitorDecimal += 1;
						competitorWhole--;
					}
					competitorWhole -= (timeElapsed*0.0002*cottonPrice/(competitorPrice+cottonPrice)-(timeElapsed*0.0002*cottonPrice/(competitorPrice+cottonPrice))%1);
					if (competitorDecimal >= 1) {
						competitorWhole += competitorDecimal-(competitorDecimal%1);
						competitorDecimal -= competitorDecimal-(competitorDecimal%1);
					}
					lblCompetitorAmount.setText(Long.toString(competitorWhole)+" ("+-(double)Math.round(2*cottonPrice/(competitorPrice+cottonPrice)*10)/100+"/sec)");
				} else {
					competitorDecimal -= (timeElapsed*0.0002)%1;
					if (competitorDecimal < 0 && competitorWhole >= 1) {
						competitorDecimal += 1;
						competitorWhole--;
					}
					competitorWhole -= (timeElapsed*0.0002-(timeElapsed*0.0002)%1);
					if (competitorDecimal >= 1) {
						competitorWhole += competitorDecimal-(competitorDecimal%1);
						competitorDecimal -= competitorDecimal-(competitorDecimal%1);
					}
					lblCompetitorAmount.setText(Long.toString(competitorWhole)+" (-0.2/sec)");
				}
			}
			
			if (competitorWhole < 1 && competitorDecimal < 1) {
	            pw = new PrintWriter("stats/"+username+"/Competitor.stat");
				pw.println(new TextEncryptor(Long.toString(milliTime())).encrypt());
				pw.println(new TextEncryptor(Long.toString(100*(long)Math.pow(rank, 2))).encrypt());
				pw.println(new TextEncryptor("0.0").encrypt());
				pw.println(new TextEncryptor(Double.toString((double)(rand.nextInt(20)+1)/10)).encrypt());
				double number = rand.nextInt(8);
				if (rank == 1) number = rand.nextInt(4);
				else if (rank == 2) number = rand.nextInt(8);
				if (number == 0) pw.println(new TextEncryptor("Fish").encrypt());
				else if (number == 1) pw.println(new TextEncryptor("Coal").encrypt());
				else if (number == 2) pw.println(new TextEncryptor("Planks").encrypt());
				else if (number == 3) pw.println(new TextEncryptor("Cotton").encrypt());
				else if (number == 4) pw.println(new TextEncryptor("Steak").encrypt());
				else if (number == 5) pw.println(new TextEncryptor("Pork").encrypt());
				else if (number == 6) pw.println(new TextEncryptor("Chicken").encrypt());
				else if (number == 7) pw.println(new TextEncryptor("Mutton").encrypt());
				number = rand.nextInt(3);
				if (number == 0) pw.println(new TextEncryptor("Moneyz Inc.").encrypt());
				else if (number == 1) pw.println(new TextEncryptor("Ge Co.").encrypt());
				else if (number == 2) pw.println(new TextEncryptor("Simulator Creator").encrypt());
				pw.close();
				br = new BufferedReader(new FileReader("stats/"+username+"/Competitor.stat"));
				competitorTime = Long.parseLong(new TextEncryptor(br.readLine()).decrypt());
				competitorWhole = Long.parseLong(new TextEncryptor(br.readLine()).decrypt());
				competitorDecimal = Double.parseDouble(new TextEncryptor(br.readLine()).decrypt());
				competitorPrice = Double.parseDouble(new TextEncryptor(br.readLine()).decrypt());
				competitorResource = new TextEncryptor(br.readLine()).decrypt();
				competitorCompany = new TextEncryptor(br.readLine()).decrypt();
				br.close();
			}
		} catch (Exception e) {}
	}
	
	public void checkPage() {
		a = 0;
		if (currentPage == 1) {
			updateBuilding(foodWhole+rancher);
			updateLabel(itemAmount,"",foodWhole,rancher,fisher*4+cowRancher*4+pigRancher*4+chickenRancher*4+sheepRancher*4);
			updateLabel(lblItem1,"Ranchers: ",rancher);
			lblCost1.setText("(1) Cost: 10 Food | M$5.00");
			if (foodWhole >= 10 && moneyWhole >= 5) {
				String end = "";
				if ((foodWhole < 20000 || moneyWhole < 10000) && multi == 2) end = ".00";
				else if ((foodWhole < 4000 || moneyWhole < 2000) && multi == 3) end = ".00";
				else if ((foodWhole < 2000 || moneyWhole < 1000) && multi == 4) end = ".00";
				if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(foodWhole/10)) {
					
					if (multi == 1) lblCost1.setText("(1) Cost: 10 Food | M$5.00");
					
					else if (multi == 2) lblCost1.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2)+" Food | M$"+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))+end);
					
					else if (multi == 3) lblCost1.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2)+" Food | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))+end);
					
					else lblCost1.setText("("+formatNumber((long)Math.floor(moneyWhole/5))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2)+" Food | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))+end);
				
				} else {
					
					if (multi == 1) lblCost1.setText("(1) Cost: 10 Food | M$5.00");
					
					else if (multi == 2) lblCost1.setText("("+formatNumber(((long)Math.floor(foodWhole/10))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(foodWhole/10))/2)-((long)Math.floor(((long)Math.floor(foodWhole/10))/2)%5))*2)+" Food | M$"+formatNumber((long)Math.floor(((long)Math.floor(foodWhole/10))/2)-((long)Math.floor(((long)Math.floor(foodWhole/10))/2)%5))+end);
					
					else if (multi == 3) lblCost1.setText("("+formatNumber(((long)Math.floor(foodWhole/10))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(foodWhole/10))-((long)Math.floor(2.5*(long)Math.floor(foodWhole/10))%5))*2)+" Food | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(foodWhole/10))-((long)Math.floor(2.5*(long)Math.floor(foodWhole/10))%5))+end);
					
					else lblCost1.setText("("+formatNumber((long)Math.floor(foodWhole/10))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(foodWhole/10))-((long)Math.floor(5*(long)Math.floor(foodWhole/10))%5))*2)+" Food | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(foodWhole/10))-((long)Math.floor(5*(long)Math.floor(foodWhole/10))%5))+end);
					
				}
				if (multi == 2 && (foodWhole < 100 || moneyWhole < 50)) lblCost1.setText("(1) Cost: 10 Food | M$5.00");
				else if (multi == 3 && (foodWhole < 20 || moneyWhole < 10)) lblCost1.setText("(1) Cost: 10 Food | M$5.00");
			}
		} else if (currentPage == 2) {
			lblPrice.setText("Price: M$"+fishPrice+"0");
			updateBuilding(fishWhole+fisher+fishMerchant);
			updateLabel(itemAmount,"",fishWhole,fisher,fishMerchant*2);
			updateLabel(lblItem1,"Food: ",foodWhole,rancher,fisher*4+cowRancher*4+pigRancher*4+chickenRancher*4+sheepRancher*4);
			updateLabel(lblItem2,"Fishers: ",fisher);
			updateLabel(lblItem3,"Fish Merchants: ",fishMerchant);
			lblCost2.setText("(1) Cost: 10 Fish | M$5.00");
			if (fishWhole >= 10 && moneyWhole >= 5) {
				String end = "";
				if ((fishWhole < 20000 || moneyWhole < 10000) && multi == 2) end = ".00";
				else if ((fishWhole < 4000 || moneyWhole < 2000) && multi == 3) end = ".00";
				else if ((fishWhole < 2000 || moneyWhole < 1000) && multi == 4) end = ".00";
				if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(fishWhole/10)) {
					
					if (multi == 1) lblCost2.setText("(1) Cost: 10 Fish | M$5.00");
					
					else if (multi == 2) lblCost2.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2)+" Fish | M$"+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))+end);
					
					else if (multi == 3) lblCost2.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2)+" Fish | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))+end);
					
					else lblCost2.setText("("+formatNumber((long)Math.floor(moneyWhole/5))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2)+" Fish | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))+end);
				
				} else {
					
					if (multi == 1) lblCost2.setText("(1) Cost: 10 Fish | M$5.00");
					
					else if (multi == 2) lblCost2.setText("("+formatNumber(((long)Math.floor(fishWhole/10))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(fishWhole/10))/2)-((long)Math.floor(((long)Math.floor(fishWhole/10))/2)%5))*2)+" Fish | M$"+formatNumber((long)Math.floor(((long)Math.floor(fishWhole/10))/2)-((long)Math.floor(((long)Math.floor(fishWhole/10))/2)%5))+end);
					
					else if (multi == 3) lblCost2.setText("("+formatNumber(((long)Math.floor(fishWhole/10))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(fishWhole/10))-((long)Math.floor(2.5*(long)Math.floor(fishWhole/10))%5))*2)+" Fish | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(fishWhole/10))-((long)Math.floor(2.5*(long)Math.floor(fishWhole/10))%5))+end);
					
					else lblCost2.setText("("+formatNumber((long)Math.floor(fishWhole/10))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(fishWhole/10))-((long)Math.floor(5*(long)Math.floor(fishWhole/10))%5))*2)+" Fish | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(fishWhole/10))-((long)Math.floor(5*(long)Math.floor(fishWhole/10))%5))+end);
					
				}
				if (multi == 2 && (fishWhole < 100 || moneyWhole < 50)) lblCost2.setText("(1) Cost: 10 Fish | M$5.00");
				else if (multi == 3 && (fishWhole < 20 || moneyWhole < 10)) lblCost2.setText("(1) Cost: 10 Fish | M$5.00");
			}
			lblCost3.setText("(1) Cost: 5 Fish | M$10.00");
			if (fishWhole >= 5 && moneyWhole >= 10) {
				String end = "";
				if ((fishWhole < 5000 || moneyWhole < 10000) && multi == 2) end = ".00";
				else if ((fishWhole < 1000 || moneyWhole < 2000) && multi == 3) end = ".00";
				else if ((fishWhole < 500 || moneyWhole < 1000) && multi == 4) end = ".00";
				if ((long)Math.floor(moneyWhole/10) < (long)Math.floor(fishWhole/5)) {
					
					if (multi == 1) lblCost3.setText("(1) Cost: 5 Fish | M$10.00");
					
					else if (multi == 2) lblCost3.setText("("+formatNumber(((long)Math.floor(moneyWhole/10))/10)+") Cost: "+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))+" Fish | M$"+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))*2)+end);
					
					else if (multi == 3) lblCost3.setText("("+formatNumber(((long)Math.floor(moneyWhole/10))/2)+") Cost: "+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))+" Fish | M$"+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))*2)+end);
					
					else lblCost3.setText("("+formatNumber((long)Math.floor(moneyWhole/10))+") Cost: "+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))+" Fish | M$"+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))*2)+end);
				
				} else {
					
					if (multi == 1) lblCost3.setText("(1) Cost: 5 Fish | M$10.00");
					
					else if (multi == 2) lblCost3.setText("("+formatNumber(((long)Math.floor(fishWhole/5))/10)+") Cost: "+formatNumber((long)Math.floor(((long)Math.floor(fishWhole/5))/2)-((long)Math.floor(((long)Math.floor(fishWhole/5))/2)%5))+" Fish | M$"+formatNumber(((long)Math.floor(((long)Math.floor(fishWhole/5))/2)-((long)Math.floor(((long)Math.floor(fishWhole/5))/2)%5))*2)+end);
					
					else if (multi == 3) lblCost3.setText("("+formatNumber(((long)Math.floor(fishWhole/5))/2)+") Cost: "+formatNumber((long)Math.floor(2.5*(long)Math.floor(fishWhole/5))-((long)Math.floor(2.5*(long)Math.floor(fishWhole/5))%5))+" Fish | M$"+formatNumber(((long)Math.floor(2.5*(long)Math.floor(fishWhole/5))-((long)Math.floor(2.5*(long)Math.floor(fishWhole/5))%5))*2)+end);
					
					else lblCost3.setText("("+formatNumber((long)Math.floor(fishWhole/5))+") Cost: "+formatNumber((long)Math.floor(5*(long)Math.floor(fishWhole/5))-((long)Math.floor(5*(long)Math.floor(fishWhole/5))%5))+" Fish | M$"+formatNumber(((long)Math.floor(5*(long)Math.floor(fishWhole/5))-((long)Math.floor(5*(long)Math.floor(fishWhole/5))%5))*2)+end);
					
				}
				if (multi == 2 && (fishWhole < 50 || moneyWhole < 100)) lblCost3.setText("(1) Cost: 5 Fish | M$10.00");
				else if (multi == 3 && (fishWhole < 10 || moneyWhole < 20)) lblCost3.setText("(1) Cost: 5 Fish | M$10.00");
			}
		} else if (currentPage == 3) {
			if (rank == 1) {
				updateBuilding(stoneWhole+miner);
				updateLabel(itemAmount,"",stoneWhole,miner,coalMiner*4);
				updateLabel(lblItem1,"Miners: ",miner);
				lblCost1.setText("(1) Cost: 10 Stone | M$5.00");
				if (stoneWhole >= 10 && moneyWhole >= 5) {
					String end = "";
					if ((stoneWhole < 20000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((stoneWhole < 4000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((stoneWhole < 2000 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(stoneWhole/10)) {
						
						if (multi == 1) lblCost1.setText("(1) Cost: 10 Stone | M$5.00");
						
						else if (multi == 2) lblCost1.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2)+" Stone | M$"+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))+end);
						
						else if (multi == 3) lblCost1.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2)+" Stone | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))+end);
						
						else lblCost1.setText("("+formatNumber((long)Math.floor(moneyWhole/5))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2)+" Stone | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))+end);
					
					} else {
						
						if (multi == 1) lblCost1.setText("(1) Cost: 10 Stone | M$5.00");
						
						else if (multi == 2) lblCost1.setText("("+formatNumber(((long)Math.floor(stoneWhole/10))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(stoneWhole/10))/2)-((long)Math.floor(((long)Math.floor(stoneWhole/10))/2)%5))*2)+" Stone | M$"+formatNumber((long)Math.floor(((long)Math.floor(stoneWhole/10))/2)-((long)Math.floor(((long)Math.floor(stoneWhole/10))/2)%5))+end);
						
						else if (multi == 3) lblCost1.setText("("+formatNumber(((long)Math.floor(stoneWhole/10))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(stoneWhole/10))-((long)Math.floor(2.5*(long)Math.floor(stoneWhole/10))%5))*2)+" Stone | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(stoneWhole/10))-((long)Math.floor(2.5*(long)Math.floor(stoneWhole/10))%5))+end);
						
						else lblCost1.setText("("+formatNumber((long)Math.floor(stoneWhole/10))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(stoneWhole/10))-((long)Math.floor(5*(long)Math.floor(stoneWhole/10))%5))*2)+" Stone | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(stoneWhole/10))-((long)Math.floor(5*(long)Math.floor(stoneWhole/10))%5))+end);
						
					}
					if (multi == 2 && (stoneWhole < 100 || moneyWhole < 50)) lblCost1.setText("(1) Cost: 10 Stone | M$5.00");
					else if (multi == 3 && (stoneWhole < 20 || moneyWhole < 10)) lblCost1.setText("(1) Cost: 10 Stone | M$5.00");
				}
			} else {
				lblPrice.setText("Price: M$"+steakPrice+"0");
				updateBuilding(steakWhole+cowRancher+steakMerchant);
				updateLabel(itemAmount,"",steakWhole,cowRancher,steakMerchant*2);
				updateLabel(lblItem2,"Cow Ranchers: ",cowRancher);
				updateLabel(lblItem3,"Steak Merchants: ",steakMerchant);
				lblCost2.setText("(1) Cost: 10 Steak | M$5.00");
				if (steakWhole >= 10 && moneyWhole >= 5) {
					String end = "";
					if ((steakWhole < 20000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((steakWhole < 4000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((steakWhole < 2000 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(steakWhole/10)) {
						
						if (multi == 1) lblCost2.setText("(1) Cost: 10 Steak | M$5.00");
						
						else if (multi == 2) lblCost2.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2)+" Steak | M$"+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))+end);
						
						else if (multi == 3) lblCost2.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2)+" Steak | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))+end);
						
						else lblCost2.setText("("+formatNumber((long)Math.floor(moneyWhole/5))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2)+" Steak | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))+end);
					
					} else {
						
						if (multi == 1) lblCost2.setText("(1) Cost: 10 Steak | M$5.00");
						
						else if (multi == 2) lblCost2.setText("("+formatNumber(((long)Math.floor(steakWhole/10))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(steakWhole/10))/2)-((long)Math.floor(((long)Math.floor(steakWhole/10))/2)%5))*2)+" Steak | M$"+formatNumber((long)Math.floor(((long)Math.floor(steakWhole/10))/2)-((long)Math.floor(((long)Math.floor(steakWhole/10))/2)%5))+end);
						
						else if (multi == 3) lblCost2.setText("("+formatNumber(((long)Math.floor(steakWhole/10))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(steakWhole/10))-((long)Math.floor(2.5*(long)Math.floor(steakWhole/10))%5))*2)+" Steak | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(steakWhole/10))-((long)Math.floor(2.5*(long)Math.floor(steakWhole/10))%5))+end);
						
						else lblCost2.setText("("+formatNumber((long)Math.floor(steakWhole/10))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(steakWhole/10))-((long)Math.floor(5*(long)Math.floor(steakWhole/10))%5))*2)+" Steak | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(steakWhole/10))-((long)Math.floor(5*(long)Math.floor(steakWhole/10))%5))+end);
						
					}
					if (multi == 2 && (steakWhole < 100 || moneyWhole < 50)) lblCost2.setText("(1) Cost: 10 Steak | M$5.00");
					else if (multi == 3 && (steakWhole < 20 || moneyWhole < 10)) lblCost2.setText("(1) Cost: 10 Steak | M$5.00");
				}
				lblCost3.setText("(1) Cost: 5 Steak | M$10.00");
				if (steakWhole >= 5 && moneyWhole >= 10) {
					String end = "";
					if ((steakWhole < 5000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((steakWhole < 1000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((steakWhole < 500 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/10) < (long)Math.floor(steakWhole/5)) {
						
						if (multi == 1) lblCost3.setText("(1) Cost: 5 Steak | M$10.00");
						
						else if (multi == 2) lblCost3.setText("("+formatNumber(((long)Math.floor(moneyWhole/10))/10)+") Cost: "+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))+" Steak | M$"+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))*2)+end);
						
						else if (multi == 3) lblCost3.setText("("+formatNumber(((long)Math.floor(moneyWhole/10))/2)+") Cost: "+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))+" Steak | M$"+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))*2)+end);
						
						else lblCost3.setText("("+formatNumber((long)Math.floor(moneyWhole/10))+") Cost: "+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))+" Steak | M$"+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))*2)+end);
					
					} else {
						
						if (multi == 1) lblCost3.setText("(1) Cost: 5 Steak | M$10.00");
						
						else if (multi == 2) lblCost3.setText("("+formatNumber(((long)Math.floor(steakWhole/5))/10)+") Cost: "+formatNumber((long)Math.floor(((long)Math.floor(steakWhole/5))/2)-((long)Math.floor(((long)Math.floor(steakWhole/5))/2)%5))+" Steak | M$"+formatNumber(((long)Math.floor(((long)Math.floor(steakWhole/5))/2)-((long)Math.floor(((long)Math.floor(steakWhole/5))/2)%5))*2)+end);
						
						else if (multi == 3) lblCost3.setText("("+formatNumber(((long)Math.floor(steakWhole/5))/2)+") Cost: "+formatNumber((long)Math.floor(2.5*(long)Math.floor(steakWhole/5))-((long)Math.floor(2.5*(long)Math.floor(steakWhole/5))%5))+" Steak | M$"+formatNumber(((long)Math.floor(2.5*(long)Math.floor(steakWhole/5))-((long)Math.floor(2.5*(long)Math.floor(steakWhole/5))%5))*2)+end);
						
						else lblCost3.setText("("+formatNumber((long)Math.floor(steakWhole/5))+") Cost: "+formatNumber((long)Math.floor(5*(long)Math.floor(steakWhole/5))-((long)Math.floor(5*(long)Math.floor(steakWhole/5))%5))+" Steak | M$"+formatNumber(((long)Math.floor(5*(long)Math.floor(steakWhole/5))-((long)Math.floor(5*(long)Math.floor(steakWhole/5))%5))*2)+end);
						
					}
					if (multi == 2 && (steakWhole < 50 || moneyWhole < 100)) lblCost3.setText("(1) Cost: 5 Steak | M$10.00");
					else if (multi == 3 && (steakWhole < 10 || moneyWhole < 20)) lblCost3.setText("(1) Cost: 5 Steak | M$10.00");
				}
			}
		} else if (currentPage == 4) {
			if (rank == 1) {
				lblPrice.setText("Price: M$"+coalPrice+"0");
				updateBuilding(coalWhole+coalMiner+coalMerchant);
				updateLabel(itemAmount,"",coalWhole,coalMiner,coalMerchant*2);
				updateLabel(lblItem1,"Stone: ",stoneWhole,miner,coalMiner*4);
				updateLabel(lblItem2,"Coal Miners: ",coalMiner);
				updateLabel(lblItem3,"Coal Merchants: ",coalMerchant);
				lblCost2.setText("(1) Cost: 10 Coal | M$5.00");
				if (coalWhole >= 10 && moneyWhole >= 5) {
					String end = "";
					if ((coalWhole < 20000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((coalWhole < 4000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((coalWhole < 2000 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(coalWhole/10)) {
						
						if (multi == 1) lblCost2.setText("(1) Cost: 10 Coal | M$5.00");
						
						else if (multi == 2) lblCost2.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2)+" Coal | M$"+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))+end);
						
						else if (multi == 3) lblCost2.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2)+" Coal | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))+end);
						
						else lblCost2.setText("("+formatNumber((long)Math.floor(moneyWhole/5))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2)+" Coal | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))+end);
					
					} else {
						
						if (multi == 1) lblCost2.setText("(1) Cost: 10 Coal | M$5.00");
						
						else if (multi == 2) lblCost2.setText("("+formatNumber(((long)Math.floor(coalWhole/10))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(coalWhole/10))/2)-((long)Math.floor(((long)Math.floor(coalWhole/10))/2)%5))*2)+" Coal | M$"+formatNumber((long)Math.floor(((long)Math.floor(coalWhole/10))/2)-((long)Math.floor(((long)Math.floor(coalWhole/10))/2)%5))+end);
						
						else if (multi == 3) lblCost2.setText("("+formatNumber(((long)Math.floor(coalWhole/10))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(coalWhole/10))-((long)Math.floor(2.5*(long)Math.floor(coalWhole/10))%5))*2)+" Coal | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(coalWhole/10))-((long)Math.floor(2.5*(long)Math.floor(coalWhole/10))%5))+end);
						
						else lblCost2.setText("("+formatNumber((long)Math.floor(coalWhole/10))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(coalWhole/10))-((long)Math.floor(5*(long)Math.floor(coalWhole/10))%5))*2)+" Coal | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(coalWhole/10))-((long)Math.floor(5*(long)Math.floor(coalWhole/10))%5))+end);
						
					}
					if (multi == 2 && (coalWhole < 100 || moneyWhole < 50)) lblCost2.setText("(1) Cost: 10 Coal | M$5.00");
					else if (multi == 3 && (coalWhole < 20 || moneyWhole < 10)) lblCost2.setText("(1) Cost: 10 Coal | M$5.00");
				}
				lblCost3.setText("(1) Cost: 5 Coal | M$10.00");
				if (coalWhole >= 5 && moneyWhole >= 10) {
					String end = "";
					if ((coalWhole < 5000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((coalWhole < 1000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((coalWhole < 500 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/10) < (long)Math.floor(coalWhole/5)) {
						
						if (multi == 1) lblCost3.setText("(1) Cost: 5 Coal | M$10.00");
						
						else if (multi == 2) lblCost3.setText("("+formatNumber(((long)Math.floor(moneyWhole/10))/10)+") Cost: "+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))+" Coal | M$"+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))*2)+end);
						
						else if (multi == 3) lblCost3.setText("("+formatNumber(((long)Math.floor(moneyWhole/10))/2)+") Cost: "+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))+" Coal | M$"+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))*2)+end);
						
						else lblCost3.setText("("+formatNumber((long)Math.floor(moneyWhole/10))+") Cost: "+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))+" Coal | M$"+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))*2)+end);
					
					} else {
						
						if (multi == 1) lblCost3.setText("(1) Cost: 5 Coal | M$10.00");
						
						else if (multi == 2) lblCost3.setText("("+formatNumber(((long)Math.floor(coalWhole/5))/10)+") Cost: "+formatNumber((long)Math.floor(((long)Math.floor(coalWhole/5))/2)-((long)Math.floor(((long)Math.floor(coalWhole/5))/2)%5))+" Coal | M$"+formatNumber(((long)Math.floor(((long)Math.floor(coalWhole/5))/2)-((long)Math.floor(((long)Math.floor(coalWhole/5))/2)%5))*2)+end);
						
						else if (multi == 3) lblCost3.setText("("+formatNumber(((long)Math.floor(coalWhole/5))/2)+") Cost: "+formatNumber((long)Math.floor(2.5*(long)Math.floor(coalWhole/5))-((long)Math.floor(2.5*(long)Math.floor(coalWhole/5))%5))+" Coal | M$"+formatNumber(((long)Math.floor(2.5*(long)Math.floor(coalWhole/5))-((long)Math.floor(2.5*(long)Math.floor(coalWhole/5))%5))*2)+end);
						
						else lblCost3.setText("("+formatNumber((long)Math.floor(coalWhole/5))+") Cost: "+formatNumber((long)Math.floor(5*(long)Math.floor(coalWhole/5))-((long)Math.floor(5*(long)Math.floor(coalWhole/5))%5))+" Coal | M$"+formatNumber(((long)Math.floor(5*(long)Math.floor(coalWhole/5))-((long)Math.floor(5*(long)Math.floor(coalWhole/5))%5))*2)+end);
						
					}
					if (multi == 2 && (coalWhole < 50 || moneyWhole < 100)) lblCost3.setText("(1) Cost: 5 Coal | M$10.00");
					else if (multi == 3 && (coalWhole < 10 || moneyWhole < 20)) lblCost3.setText("(1) Cost: 5 Coal | M$10.00");
				}
			} else {
				lblPrice.setText("Price: M$"+porkPrice+"0");
				updateBuilding(porkWhole+pigRancher+porkMerchant);
				updateLabel(itemAmount,"",porkWhole,pigRancher,porkMerchant*2);
				updateLabel(lblItem1,"Food: ",foodWhole,rancher,fisher*4+cowRancher*4+pigRancher*4+chickenRancher*4+sheepRancher*4);
				updateLabel(lblItem2,"Pig Ranchers: ",pigRancher);
				updateLabel(lblItem3,"Pork Merchants: ",porkMerchant);
				lblCost2.setText("(1) Cost: 10 Pork | M$5.00");
				if (porkWhole >= 10 && moneyWhole >= 5) {
					String end = "";
					if ((porkWhole < 20000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((porkWhole < 4000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((porkWhole < 2000 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(porkWhole/10)) {
						
						if (multi == 1) lblCost2.setText("(1) Cost: 10 Pork | M$5.00");
						
						else if (multi == 2) lblCost2.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2)+" Pork | M$"+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))+end);
						
						else if (multi == 3) lblCost2.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2)+" Pork | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))+end);
						
						else lblCost2.setText("("+formatNumber((long)Math.floor(moneyWhole/5))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2)+" Pork | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))+end);
					
					} else {
						
						if (multi == 1) lblCost2.setText("(1) Cost: 10 Pork | M$5.00");
						
						else if (multi == 2) lblCost2.setText("("+formatNumber(((long)Math.floor(porkWhole/10))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(porkWhole/10))/2)-((long)Math.floor(((long)Math.floor(porkWhole/10))/2)%5))*2)+" Pork | M$"+formatNumber((long)Math.floor(((long)Math.floor(porkWhole/10))/2)-((long)Math.floor(((long)Math.floor(porkWhole/10))/2)%5))+end);
						
						else if (multi == 3) lblCost2.setText("("+formatNumber(((long)Math.floor(porkWhole/10))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(porkWhole/10))-((long)Math.floor(2.5*(long)Math.floor(porkWhole/10))%5))*2)+" Pork | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(porkWhole/10))-((long)Math.floor(2.5*(long)Math.floor(porkWhole/10))%5))+end);
						
						else lblCost2.setText("("+formatNumber((long)Math.floor(porkWhole/10))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(porkWhole/10))-((long)Math.floor(5*(long)Math.floor(porkWhole/10))%5))*2)+" Pork | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(porkWhole/10))-((long)Math.floor(5*(long)Math.floor(porkWhole/10))%5))+end);
						
					}
					if (multi == 2 && (porkWhole < 100 || moneyWhole < 50)) lblCost2.setText("(1) Cost: 10 Pork | M$5.00");
					else if (multi == 3 && (porkWhole < 20 || moneyWhole < 10)) lblCost2.setText("(1) Cost: 10 Pork | M$5.00");
				}
				lblCost3.setText("(1) Cost: 5 Pork | M$10.00");
				if (porkWhole >= 5 && moneyWhole >= 10) {
					String end = "";
					if ((porkWhole < 5000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((porkWhole < 1000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((porkWhole < 500 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/10) < (long)Math.floor(porkWhole/5)) {
						
						if (multi == 1) lblCost3.setText("(1) Cost: 5 Pork | M$10.00");
						
						else if (multi == 2) lblCost3.setText("("+formatNumber(((long)Math.floor(moneyWhole/10))/10)+") Cost: "+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))+" Pork | M$"+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))*2)+end);
						
						else if (multi == 3) lblCost3.setText("("+formatNumber(((long)Math.floor(moneyWhole/10))/2)+") Cost: "+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))+" Pork | M$"+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))*2)+end);
						
						else lblCost3.setText("("+formatNumber((long)Math.floor(moneyWhole/10))+") Cost: "+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))+" Pork | M$"+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))*2)+end);
					
					} else {
						
						if (multi == 1) lblCost3.setText("(1) Cost: 5 Pork | M$10.00");
						
						else if (multi == 2) lblCost3.setText("("+formatNumber(((long)Math.floor(porkWhole/5))/10)+") Cost: "+formatNumber((long)Math.floor(((long)Math.floor(porkWhole/5))/2)-((long)Math.floor(((long)Math.floor(porkWhole/5))/2)%5))+" Pork | M$"+formatNumber(((long)Math.floor(((long)Math.floor(porkWhole/5))/2)-((long)Math.floor(((long)Math.floor(porkWhole/5))/2)%5))*2)+end);
						
						else if (multi == 3) lblCost3.setText("("+formatNumber(((long)Math.floor(porkWhole/5))/2)+") Cost: "+formatNumber((long)Math.floor(2.5*(long)Math.floor(porkWhole/5))-((long)Math.floor(2.5*(long)Math.floor(porkWhole/5))%5))+" Pork | M$"+formatNumber(((long)Math.floor(2.5*(long)Math.floor(porkWhole/5))-((long)Math.floor(2.5*(long)Math.floor(porkWhole/5))%5))*2)+end);
						
						else lblCost3.setText("("+formatNumber((long)Math.floor(porkWhole/5))+") Cost: "+formatNumber((long)Math.floor(5*(long)Math.floor(porkWhole/5))-((long)Math.floor(5*(long)Math.floor(porkWhole/5))%5))+" Pork | M$"+formatNumber(((long)Math.floor(5*(long)Math.floor(porkWhole/5))-((long)Math.floor(5*(long)Math.floor(porkWhole/5))%5))*2)+end);
						
					}
					if (multi == 2 && (porkWhole < 50 || moneyWhole < 100)) lblCost3.setText("(1) Cost: 5 Pork | M$10.00");
					else if (multi == 3 && (porkWhole < 10 || moneyWhole < 20)) lblCost3.setText("(1) Cost: 5 Pork | M$10.00");
				}
			}
		} else if (currentPage == 5) {
			if (rank == 1) {
				updateBuilding(woodWhole+lumberjack);
				updateLabel(itemAmount,"",woodWhole,lumberjack,woodCutter*4);
				updateLabel(lblItem1,"Lumberjacks: ",lumberjack);
				lblCost1.setText("(1) Cost: 10 Wood | M$5.00");
				if (woodWhole >= 10 && moneyWhole >= 5) {
					String end = "";
					if ((woodWhole < 20000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((woodWhole < 4000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((woodWhole < 2000 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(woodWhole/10)) {
						
						if (multi == 1) lblCost1.setText("(1) Cost: 10 Wood | M$5.00");
						
						else if (multi == 2) lblCost1.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2)+" Wood | M$"+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))+end);
						
						else if (multi == 3) lblCost1.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2)+" Wood | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))+end);
						
						else lblCost1.setText("("+formatNumber((long)Math.floor(moneyWhole/5))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2)+" Wood | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))+end);
					
					} else {
						
						if (multi == 1) lblCost1.setText("(1) Cost: 10 Wood | M$5.00");
						
						else if (multi == 2) lblCost1.setText("("+formatNumber(((long)Math.floor(woodWhole/10))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(woodWhole/10))/2)-((long)Math.floor(((long)Math.floor(woodWhole/10))/2)%5))*2)+" Wood | M$"+formatNumber((long)Math.floor(((long)Math.floor(woodWhole/10))/2)-((long)Math.floor(((long)Math.floor(woodWhole/10))/2)%5))+end);
						
						else if (multi == 3) lblCost1.setText("("+formatNumber(((long)Math.floor(woodWhole/10))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(woodWhole/10))-((long)Math.floor(2.5*(long)Math.floor(woodWhole/10))%5))*2)+" Wood | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(woodWhole/10))-((long)Math.floor(2.5*(long)Math.floor(woodWhole/10))%5))+end);
						
						else lblCost1.setText("("+formatNumber((long)Math.floor(woodWhole/10))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(woodWhole/10))-((long)Math.floor(5*(long)Math.floor(woodWhole/10))%5))*2)+" Wood | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(woodWhole/10))-((long)Math.floor(5*(long)Math.floor(woodWhole/10))%5))+end);
						
					}
					if (multi == 2 && (woodWhole < 100 || moneyWhole < 50)) lblCost1.setText("(1) Cost: 10 Wood | M$5.00");
					else if (multi == 3 && (woodWhole < 20 || moneyWhole < 10)) lblCost1.setText("(1) Cost: 10 Wood | M$5.00");
				}
			} else {
				lblPrice.setText("Price: M$"+chickenPrice+"0");
				updateBuilding(chickenWhole+chickenRancher+chickenMerchant);
				updateLabel(itemAmount,"",chickenWhole,chickenRancher,chickenMerchant*2);
				updateLabel(lblItem1,"Food: ",foodWhole,rancher,fisher*4+cowRancher*4+pigRancher*4+chickenRancher*4+sheepRancher*4);
				updateLabel(lblItem2,"Chicken Ranchers: ",chickenRancher);
				updateLabel(lblItem3,"Chicken Merchants: ",chickenMerchant);
				lblCost2.setText("(1) Cost: 10 Chicken | M$5.00");
				if (chickenWhole >= 10 && moneyWhole >= 5) {
					String end = "";
					if ((chickenWhole < 20000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((chickenWhole < 4000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((chickenWhole < 2000 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(chickenWhole/10)) {
						
						if (multi == 1) lblCost2.setText("(1) Cost: 10 Chicken | M$5.00");
						
						else if (multi == 2) lblCost2.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2)+" Chicken | M$"+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))+end);
						
						else if (multi == 3) lblCost2.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2)+" Chicken | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))+end);
						
						else lblCost2.setText("("+formatNumber((long)Math.floor(moneyWhole/5))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2)+" Chicken | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))+end);
					
					} else {
						
						if (multi == 1) lblCost2.setText("(1) Cost: 10 Chicken | M$5.00");
						
						else if (multi == 2) lblCost2.setText("("+formatNumber(((long)Math.floor(chickenWhole/10))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(chickenWhole/10))/2)-((long)Math.floor(((long)Math.floor(chickenWhole/10))/2)%5))*2)+" Chicken | M$"+formatNumber((long)Math.floor(((long)Math.floor(chickenWhole/10))/2)-((long)Math.floor(((long)Math.floor(chickenWhole/10))/2)%5))+end);
						
						else if (multi == 3) lblCost2.setText("("+formatNumber(((long)Math.floor(chickenWhole/10))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(chickenWhole/10))-((long)Math.floor(2.5*(long)Math.floor(chickenWhole/10))%5))*2)+" Chicken | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(chickenWhole/10))-((long)Math.floor(2.5*(long)Math.floor(chickenWhole/10))%5))+end);
						
						else lblCost2.setText("("+formatNumber((long)Math.floor(chickenWhole/10))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(chickenWhole/10))-((long)Math.floor(5*(long)Math.floor(chickenWhole/10))%5))*2)+" Chicken | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(chickenWhole/10))-((long)Math.floor(5*(long)Math.floor(chickenWhole/10))%5))+end);
						
					}
					if (multi == 2 && (chickenWhole < 100 || moneyWhole < 50)) lblCost2.setText("(1) Cost: 10 Chicken | M$5.00");
					else if (multi == 3 && (chickenWhole < 20 || moneyWhole < 10)) lblCost2.setText("(1) Cost: 10 Chicken | M$5.00");
				}
				lblCost3.setText("(1) Cost: 5 Chicken | M$10.00");
				if (chickenWhole >= 5 && moneyWhole >= 10) {
					String end = "";
					if ((chickenWhole < 5000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((chickenWhole < 1000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((chickenWhole < 500 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/10) < (long)Math.floor(chickenWhole/5)) {
						
						if (multi == 1) lblCost3.setText("(1) Cost: 5 Chicken | M$10.00");
						
						else if (multi == 2) lblCost3.setText("("+formatNumber(((long)Math.floor(moneyWhole/10))/10)+") Cost: "+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))+" Chicken | M$"+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))*2)+end);
						
						else if (multi == 3) lblCost3.setText("("+formatNumber(((long)Math.floor(moneyWhole/10))/2)+") Cost: "+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))+" Chicken | M$"+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))*2)+end);
						
						else lblCost3.setText("("+formatNumber((long)Math.floor(moneyWhole/10))+") Cost: "+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))+" Chicken | M$"+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))*2)+end);
					
					} else {
						
						if (multi == 1) lblCost3.setText("(1) Cost: 5 Chicken | M$10.00");
						
						else if (multi == 2) lblCost3.setText("("+formatNumber(((long)Math.floor(chickenWhole/5))/10)+") Cost: "+formatNumber((long)Math.floor(((long)Math.floor(chickenWhole/5))/2)-((long)Math.floor(((long)Math.floor(chickenWhole/5))/2)%5))+" Chicken | M$"+formatNumber(((long)Math.floor(((long)Math.floor(chickenWhole/5))/2)-((long)Math.floor(((long)Math.floor(chickenWhole/5))/2)%5))*2)+end);
						
						else if (multi == 3) lblCost3.setText("("+formatNumber(((long)Math.floor(chickenWhole/5))/2)+") Cost: "+formatNumber((long)Math.floor(2.5*(long)Math.floor(chickenWhole/5))-((long)Math.floor(2.5*(long)Math.floor(chickenWhole/5))%5))+" Chicken | M$"+formatNumber(((long)Math.floor(2.5*(long)Math.floor(chickenWhole/5))-((long)Math.floor(2.5*(long)Math.floor(chickenWhole/5))%5))*2)+end);
						
						else lblCost3.setText("("+formatNumber((long)Math.floor(chickenWhole/5))+") Cost: "+formatNumber((long)Math.floor(5*(long)Math.floor(chickenWhole/5))-((long)Math.floor(5*(long)Math.floor(chickenWhole/5))%5))+" Chicken | M$"+formatNumber(((long)Math.floor(5*(long)Math.floor(chickenWhole/5))-((long)Math.floor(5*(long)Math.floor(chickenWhole/5))%5))*2)+end);
						
					}
					if (multi == 2 && (chickenWhole < 50 || moneyWhole < 100)) lblCost3.setText("(1) Cost: 5 Chicken | M$10.00");
					else if (multi == 3 && (chickenWhole < 10 || moneyWhole < 20)) lblCost3.setText("(1) Cost: 5 Chicken | M$10.00");
				}
			}
		} else if (currentPage == 6) {
			if (rank == 1) {
				lblPrice.setText("Price: M$"+plankPrice+"0");
				updateBuilding(plankWhole+woodCutter+plankMerchant);
				updateLabel(itemAmount,"",plankWhole,woodCutter,plankMerchant*2);
				updateLabel(lblItem1,"Wood: ",woodWhole,lumberjack,woodCutter*4);
				updateLabel(lblItem2,"Wood Cutters: ",woodCutter);
				updateLabel(lblItem3,"Plank Merchants: ",plankMerchant);
				lblCost2.setText("(1) Cost: 10 Planks | M$5.00");
				if (plankWhole >= 10 && moneyWhole >= 5) {
					String end = "";
					if ((plankWhole < 20000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((plankWhole < 4000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((plankWhole < 2000 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(plankWhole/10)) {
						
						if (multi == 1) lblCost2.setText("(1) Cost: 10 Planks | M$5.00");
						
						else if (multi == 2) lblCost2.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2)+" Planks | M$"+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))+end);
						
						else if (multi == 3) lblCost2.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2)+" Planks | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))+end);
						
						else lblCost2.setText("("+formatNumber((long)Math.floor(moneyWhole/5))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2)+" Planks | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))+end);
					
					} else {
						
						if (multi == 1) lblCost2.setText("(1) Cost: 10 Planks | M$5.00");
						
						else if (multi == 2) lblCost2.setText("("+formatNumber(((long)Math.floor(plankWhole/10))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(plankWhole/10))/2)-((long)Math.floor(((long)Math.floor(plankWhole/10))/2)%5))*2)+" Planks | M$"+formatNumber((long)Math.floor(((long)Math.floor(plankWhole/10))/2)-((long)Math.floor(((long)Math.floor(plankWhole/10))/2)%5))+end);
						
						else if (multi == 3) lblCost2.setText("("+formatNumber(((long)Math.floor(plankWhole/10))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(plankWhole/10))-((long)Math.floor(2.5*(long)Math.floor(plankWhole/10))%5))*2)+" Planks | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(plankWhole/10))-((long)Math.floor(2.5*(long)Math.floor(plankWhole/10))%5))+end);
						
						else lblCost2.setText("("+formatNumber((long)Math.floor(plankWhole/10))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(plankWhole/10))-((long)Math.floor(5*(long)Math.floor(plankWhole/10))%5))*2)+" Planks | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(plankWhole/10))-((long)Math.floor(5*(long)Math.floor(plankWhole/10))%5))+end);
						
					}
					if (multi == 2 && (plankWhole < 100 || moneyWhole < 50)) lblCost2.setText("(1) Cost: 10 Planks | M$5.00");
					else if (multi == 3 && (plankWhole < 20 || moneyWhole < 10)) lblCost2.setText("(1) Cost: 10 Planks | M$5.00");
				}
				lblCost3.setText("(1) Cost: 5 Planks | M$10.00");
				if (plankWhole >= 5 && moneyWhole >= 10) {
					String end = "";
					if ((plankWhole < 5000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((plankWhole < 1000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((plankWhole < 500 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/10) < (long)Math.floor(plankWhole/5)) {
						
						if (multi == 1) lblCost3.setText("(1) Cost: 5 Planks | M$10.00");
						
						else if (multi == 2) lblCost3.setText("("+formatNumber(((long)Math.floor(moneyWhole/10))/10)+") Cost: "+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))+" Planks | M$"+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))*2)+end);
						
						else if (multi == 3) lblCost3.setText("("+formatNumber(((long)Math.floor(moneyWhole/10))/2)+") Cost: "+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))+" Planks | M$"+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))*2)+end);
						
						else lblCost3.setText("("+formatNumber((long)Math.floor(moneyWhole/10))+") Cost: "+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))+" Planks | M$"+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))*2)+end);
					
					} else {
						
						if (multi == 1) lblCost3.setText("(1) Cost: 5 Planks | M$10.00");
						
						else if (multi == 2) lblCost3.setText("("+formatNumber(((long)Math.floor(plankWhole/5))/10)+") Cost: "+formatNumber((long)Math.floor(((long)Math.floor(plankWhole/5))/2)-((long)Math.floor(((long)Math.floor(plankWhole/5))/2)%5))+" Planks | M$"+formatNumber(((long)Math.floor(((long)Math.floor(plankWhole/5))/2)-((long)Math.floor(((long)Math.floor(plankWhole/5))/2)%5))*2)+end);
						
						else if (multi == 3) lblCost3.setText("("+formatNumber(((long)Math.floor(plankWhole/5))/2)+") Cost: "+formatNumber((long)Math.floor(2.5*(long)Math.floor(plankWhole/5))-((long)Math.floor(2.5*(long)Math.floor(plankWhole/5))%5))+" Planks | M$"+formatNumber(((long)Math.floor(2.5*(long)Math.floor(plankWhole/5))-((long)Math.floor(2.5*(long)Math.floor(plankWhole/5))%5))*2)+end);
						
						else lblCost3.setText("("+formatNumber((long)Math.floor(plankWhole/5))+") Cost: "+formatNumber((long)Math.floor(5*(long)Math.floor(plankWhole/5))-((long)Math.floor(5*(long)Math.floor(plankWhole/5))%5))+" Planks | M$"+formatNumber(((long)Math.floor(5*(long)Math.floor(plankWhole/5))-((long)Math.floor(5*(long)Math.floor(plankWhole/5))%5))*2)+end);
						
					}
					if (multi == 2 && (plankWhole < 50 || moneyWhole < 100)) lblCost3.setText("(1) Cost: 5 Planks | M$10.00");
					else if (multi == 3 && (plankWhole < 10 || moneyWhole < 20)) lblCost3.setText("(1) Cost: 5 Planks | M$10.00");
				}
			} else {
				lblPrice.setText("Price: M$"+muttonPrice+"0");
				updateBuilding(muttonWhole+sheepRancher+muttonMerchant);
				updateLabel(itemAmount,"",muttonWhole,sheepRancher,muttonMerchant*2);
				updateLabel(lblItem1,"Food: ",foodWhole,rancher,fisher*4+cowRancher*4+pigRancher*4+chickenRancher*4+sheepRancher*4);
				updateLabel(lblItem2,"Sheep Ranchers: ",sheepRancher);
				updateLabel(lblItem3,"Mutton Merchants: ",muttonMerchant);
				lblCost2.setText("(1) Cost: 10 Mutton | M$5.00");
				if (muttonWhole >= 10 && moneyWhole >= 5) {
					String end = "";
					if ((muttonWhole < 20000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((muttonWhole < 4000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((muttonWhole < 2000 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(muttonWhole/10)) {
						
						if (multi == 1) lblCost2.setText("(1) Cost: 10 Mutton | M$5.00");
						
						else if (multi == 2) lblCost2.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2)+" Mutton | M$"+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))+end);
						
						else if (multi == 3) lblCost2.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2)+" Mutton | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))+end);
						
						else lblCost2.setText("("+formatNumber((long)Math.floor(moneyWhole/5))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2)+" Mutton | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))+end);
					
					} else {
						
						if (multi == 1) lblCost2.setText("(1) Cost: 10 Mutton | M$5.00");
						
						else if (multi == 2) lblCost2.setText("("+formatNumber(((long)Math.floor(muttonWhole/10))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(muttonWhole/10))/2)-((long)Math.floor(((long)Math.floor(muttonWhole/10))/2)%5))*2)+" Mutton | M$"+formatNumber((long)Math.floor(((long)Math.floor(muttonWhole/10))/2)-((long)Math.floor(((long)Math.floor(muttonWhole/10))/2)%5))+end);
						
						else if (multi == 3) lblCost2.setText("("+formatNumber(((long)Math.floor(muttonWhole/10))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(muttonWhole/10))-((long)Math.floor(2.5*(long)Math.floor(muttonWhole/10))%5))*2)+" Mutton | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(muttonWhole/10))-((long)Math.floor(2.5*(long)Math.floor(muttonWhole/10))%5))+end);
						
						else lblCost2.setText("("+formatNumber((long)Math.floor(muttonWhole/10))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(muttonWhole/10))-((long)Math.floor(5*(long)Math.floor(muttonWhole/10))%5))*2)+" Mutton | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(muttonWhole/10))-((long)Math.floor(5*(long)Math.floor(muttonWhole/10))%5))+end);
						
					}
					if (multi == 2 && (muttonWhole < 100 || moneyWhole < 50)) lblCost2.setText("(1) Cost: 10 Mutton | M$5.00");
					else if (multi == 3 && (muttonWhole < 20 || moneyWhole < 10)) lblCost2.setText("(1) Cost: 10 Mutton | M$5.00");
				}
				lblCost3.setText("(1) Cost: 5 Mutton | M$10.00");
				if (muttonWhole >= 5 && moneyWhole >= 10) {
					String end = "";
					if ((muttonWhole < 5000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((muttonWhole < 1000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((muttonWhole < 500 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/10) < (long)Math.floor(muttonWhole/5)) {
						
						if (multi == 1) lblCost3.setText("(1) Cost: 5 Mutton | M$10.00");
						
						else if (multi == 2) lblCost3.setText("("+formatNumber(((long)Math.floor(moneyWhole/10))/10)+") Cost: "+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))+" Mutton | M$"+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))*2)+end);
						
						else if (multi == 3) lblCost3.setText("("+formatNumber(((long)Math.floor(moneyWhole/10))/2)+") Cost: "+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))+" Mutton | M$"+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))*2)+end);
						
						else lblCost3.setText("("+formatNumber((long)Math.floor(moneyWhole/10))+") Cost: "+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))+" Mutton | M$"+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))*2)+end);
					
					} else {
						
						if (multi == 1) lblCost3.setText("(1) Cost: 5 Mutton | M$10.00");
						
						else if (multi == 2) lblCost3.setText("("+formatNumber(((long)Math.floor(muttonWhole/5))/10)+") Cost: "+formatNumber((long)Math.floor(((long)Math.floor(muttonWhole/5))/2)-((long)Math.floor(((long)Math.floor(muttonWhole/5))/2)%5))+" Mutton | M$"+formatNumber(((long)Math.floor(((long)Math.floor(muttonWhole/5))/2)-((long)Math.floor(((long)Math.floor(muttonWhole/5))/2)%5))*2)+end);
						
						else if (multi == 3) lblCost3.setText("("+formatNumber(((long)Math.floor(muttonWhole/5))/2)+") Cost: "+formatNumber((long)Math.floor(2.5*(long)Math.floor(muttonWhole/5))-((long)Math.floor(2.5*(long)Math.floor(muttonWhole/5))%5))+" Mutton | M$"+formatNumber(((long)Math.floor(2.5*(long)Math.floor(muttonWhole/5))-((long)Math.floor(2.5*(long)Math.floor(muttonWhole/5))%5))*2)+end);
						
						else lblCost3.setText("("+formatNumber((long)Math.floor(muttonWhole/5))+") Cost: "+formatNumber((long)Math.floor(5*(long)Math.floor(muttonWhole/5))-((long)Math.floor(5*(long)Math.floor(muttonWhole/5))%5))+" Mutton | M$"+formatNumber(((long)Math.floor(5*(long)Math.floor(muttonWhole/5))-((long)Math.floor(5*(long)Math.floor(muttonWhole/5))%5))*2)+end);
						
					}
					if (multi == 2 && (muttonWhole < 50 || moneyWhole < 100)) lblCost3.setText("(1) Cost: 5 Mutton | M$10.00");
					else if (multi == 3 && (muttonWhole < 10 || moneyWhole < 20)) lblCost3.setText("(1) Cost: 5 Mutton | M$10.00");
				}
			}
		} else if (currentPage == 7) {
			if (rank == 1) {
				updateBuilding(cropWhole+farmer);
				updateLabel(itemAmount,"",cropWhole,farmer,cottonFarmer*4);
				updateLabel(lblItem1,"Farmers: ",farmer);
				lblCost1.setText("(1) Cost: 10 Crops | M$5.00");
				if (cropWhole >= 10 && moneyWhole >= 5) {
					String end = "";
					if ((cropWhole < 20000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((cropWhole < 4000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((cropWhole < 2000 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(cropWhole/10)) {
						
						if (multi == 1) lblCost1.setText("(1) Cost: 10 Crops | M$5.00");
						
						else if (multi == 2) lblCost1.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2)+" Crops | M$"+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))+end);
						
						else if (multi == 3) lblCost1.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2)+" Crops | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))+end);
						
						else lblCost1.setText("("+formatNumber((long)Math.floor(moneyWhole/5))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2)+" Crops | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))+end);
					
					} else {
						
						if (multi == 1) lblCost1.setText("(1) Cost: 10 Crops | M$5.00");
						
						else if (multi == 2) lblCost1.setText("("+formatNumber(((long)Math.floor(cropWhole/10))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(cropWhole/10))/2)-((long)Math.floor(((long)Math.floor(cropWhole/10))/2)%5))*2)+" Crops | M$"+formatNumber((long)Math.floor(((long)Math.floor(cropWhole/10))/2)-((long)Math.floor(((long)Math.floor(cropWhole/10))/2)%5))+end);
						
						else if (multi == 3) lblCost1.setText("("+formatNumber(((long)Math.floor(cropWhole/10))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(cropWhole/10))-((long)Math.floor(2.5*(long)Math.floor(cropWhole/10))%5))*2)+" Crops | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(cropWhole/10))-((long)Math.floor(2.5*(long)Math.floor(cropWhole/10))%5))+end);
						
						else lblCost1.setText("("+formatNumber((long)Math.floor(cropWhole/10))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(cropWhole/10))-((long)Math.floor(5*(long)Math.floor(cropWhole/10))%5))*2)+" Crops | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(cropWhole/10))-((long)Math.floor(5*(long)Math.floor(cropWhole/10))%5))+end);
						
					}
					if (multi == 2 && (cropWhole < 100 || moneyWhole < 50)) lblCost1.setText("(1) Cost: 10 Crops | M$5.00");
					else if (multi == 3 && (cropWhole < 20 || moneyWhole < 10)) lblCost1.setText("(1) Cost: 10 Crops | M$5.00");
				}
			} else {
				updateBuilding(stoneWhole+miner);
				updateLabel(itemAmount,"",stoneWhole,miner,coalMiner*4);
				updateLabel(lblItem1,"Miners: ",miner);
				lblCost1.setText("(1) Cost: 10 Stone | M$5.00");
				if (stoneWhole >= 10 && moneyWhole >= 5) {
					String end = "";
					if ((stoneWhole < 20000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((stoneWhole < 4000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((stoneWhole < 2000 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(stoneWhole/10)) {
						
						if (multi == 1) lblCost1.setText("(1) Cost: 10 Stone | M$5.00");
						
						else if (multi == 2) lblCost1.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2)+" Stone | M$"+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))+end);
						
						else if (multi == 3) lblCost1.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2)+" Stone | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))+end);
						
						else lblCost1.setText("("+formatNumber((long)Math.floor(moneyWhole/5))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2)+" Stone | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))+end);
					
					} else {
						
						if (multi == 1) lblCost1.setText("(1) Cost: 10 Stone | M$5.00");
						
						else if (multi == 2) lblCost1.setText("("+formatNumber(((long)Math.floor(stoneWhole/10))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(stoneWhole/10))/2)-((long)Math.floor(((long)Math.floor(stoneWhole/10))/2)%5))*2)+" Stone | M$"+formatNumber((long)Math.floor(((long)Math.floor(stoneWhole/10))/2)-((long)Math.floor(((long)Math.floor(stoneWhole/10))/2)%5))+end);
						
						else if (multi == 3) lblCost1.setText("("+formatNumber(((long)Math.floor(stoneWhole/10))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(stoneWhole/10))-((long)Math.floor(2.5*(long)Math.floor(stoneWhole/10))%5))*2)+" Stone | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(stoneWhole/10))-((long)Math.floor(2.5*(long)Math.floor(stoneWhole/10))%5))+end);
						
						else lblCost1.setText("("+formatNumber((long)Math.floor(stoneWhole/10))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(stoneWhole/10))-((long)Math.floor(5*(long)Math.floor(stoneWhole/10))%5))*2)+" Stone | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(stoneWhole/10))-((long)Math.floor(5*(long)Math.floor(stoneWhole/10))%5))+end);
						
					}
					if (multi == 2 && (stoneWhole < 100 || moneyWhole < 50)) lblCost1.setText("(1) Cost: 10 Stone | M$5.00");
					else if (multi == 3 && (stoneWhole < 20 || moneyWhole < 10)) lblCost1.setText("(1) Cost: 10 Stone | M$5.00");
				}
			}
		} else if (currentPage == 8) {
			if (rank == 1) {
				lblPrice.setText("Price: M$"+cottonPrice+"0");
				updateBuilding(cottonWhole+cottonFarmer+cottonMerchant);
				updateLabel(itemAmount,"",cottonWhole,cottonFarmer,cottonMerchant*2);
				updateLabel(lblItem1,"Crops: ",cropWhole,farmer,cottonFarmer*4);
				updateLabel(lblItem2,"Cotton Farmers: ",cottonFarmer);
				updateLabel(lblItem3,"Cotton Merchants: ",cottonMerchant);
				lblCost2.setText("(1) Cost: 10 Cotton | M$5.00");
				if (cottonWhole >= 10 && moneyWhole >= 5) {
					String end = "";
					if ((cottonWhole < 20000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((cottonWhole < 4000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((cottonWhole < 2000 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(cottonWhole/10)) {
						
						if (multi == 1) lblCost2.setText("(1) Cost: 10 Cotton | M$5.00");
						
						else if (multi == 2) lblCost2.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2)+" Cotton | M$"+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))+end);
						
						else if (multi == 3) lblCost2.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2)+" Cotton | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))+end);
						
						else lblCost2.setText("("+formatNumber((long)Math.floor(moneyWhole/5))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2)+" Cotton | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))+end);
					
					} else {
						
						if (multi == 1) lblCost2.setText("(1) Cost: 10 Cotton | M$5.00");
						
						else if (multi == 2) lblCost2.setText("("+formatNumber(((long)Math.floor(cottonWhole/10))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(cottonWhole/10))/2)-((long)Math.floor(((long)Math.floor(cottonWhole/10))/2)%5))*2)+" Cotton | M$"+formatNumber((long)Math.floor(((long)Math.floor(cottonWhole/10))/2)-((long)Math.floor(((long)Math.floor(cottonWhole/10))/2)%5))+end);
						
						else if (multi == 3) lblCost2.setText("("+formatNumber(((long)Math.floor(cottonWhole/10))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(cottonWhole/10))-((long)Math.floor(2.5*(long)Math.floor(cottonWhole/10))%5))*2)+" Cotton | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(cottonWhole/10))-((long)Math.floor(2.5*(long)Math.floor(cottonWhole/10))%5))+end);
						
						else lblCost2.setText("("+formatNumber((long)Math.floor(cottonWhole/10))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(cottonWhole/10))-((long)Math.floor(5*(long)Math.floor(cottonWhole/10))%5))*2)+" Cotton | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(cottonWhole/10))-((long)Math.floor(5*(long)Math.floor(cottonWhole/10))%5))+end);
						
					}
					if (multi == 2 && (cottonWhole < 100 || moneyWhole < 50)) lblCost2.setText("(1) Cost: 10 Cotton | M$5.00");
					else if (multi == 3 && (cottonWhole < 20 || moneyWhole < 10)) lblCost2.setText("(1) Cost: 10 Cotton | M$5.00");
				}
				lblCost3.setText("(1) Cost: 5 Cotton | M$10.00");
				if (cottonWhole >= 5 && moneyWhole >= 10) {
					String end = "";
					if ((cottonWhole < 5000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((cottonWhole < 1000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((cottonWhole < 500 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/10) < (long)Math.floor(cottonWhole/5)) {
						
						if (multi == 1) lblCost3.setText("(1) Cost: 5 Cotton | M$10.00");
						
						else if (multi == 2) lblCost3.setText("("+formatNumber(((long)Math.floor(moneyWhole/10))/10)+") Cost: "+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))+" Cotton | M$"+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))*2)+end);
						
						else if (multi == 3) lblCost3.setText("("+formatNumber(((long)Math.floor(moneyWhole/10))/2)+") Cost: "+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))+" Cotton | M$"+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))*2)+end);
						
						else lblCost3.setText("("+formatNumber((long)Math.floor(moneyWhole/10))+") Cost: "+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))+" Cotton | M$"+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))*2)+end);
					
					} else {
						
						if (multi == 1) lblCost3.setText("(1) Cost: 5 Cotton | M$10.00");
						
						else if (multi == 2) lblCost3.setText("("+formatNumber(((long)Math.floor(cottonWhole/5))/10)+") Cost: "+formatNumber((long)Math.floor(((long)Math.floor(cottonWhole/5))/2)-((long)Math.floor(((long)Math.floor(cottonWhole/5))/2)%5))+" Cotton | M$"+formatNumber(((long)Math.floor(((long)Math.floor(cottonWhole/5))/2)-((long)Math.floor(((long)Math.floor(cottonWhole/5))/2)%5))*2)+end);
						
						else if (multi == 3) lblCost3.setText("("+formatNumber(((long)Math.floor(cottonWhole/5))/2)+") Cost: "+formatNumber((long)Math.floor(2.5*(long)Math.floor(cottonWhole/5))-((long)Math.floor(2.5*(long)Math.floor(cottonWhole/5))%5))+" Cotton | M$"+formatNumber(((long)Math.floor(2.5*(long)Math.floor(cottonWhole/5))-((long)Math.floor(2.5*(long)Math.floor(cottonWhole/5))%5))*2)+end);
						
						else lblCost3.setText("("+formatNumber((long)Math.floor(cottonWhole/5))+") Cost: "+formatNumber((long)Math.floor(5*(long)Math.floor(cottonWhole/5))-((long)Math.floor(5*(long)Math.floor(cottonWhole/5))%5))+" Cotton | M$"+formatNumber(((long)Math.floor(5*(long)Math.floor(cottonWhole/5))-((long)Math.floor(5*(long)Math.floor(cottonWhole/5))%5))*2)+end);
						
					}
					if (multi == 2 && (cottonWhole < 50 || moneyWhole < 100)) lblCost3.setText("(1) Cost: 5 Cotton | M$10.00");
					else if (multi == 3 && (cottonWhole < 10 || moneyWhole < 20)) lblCost3.setText("(1) Cost: 5 Cotton | M$10.00");
				}
			} else {
				lblPrice.setText("Price: M$"+coalPrice+"0");
				updateBuilding(coalWhole+coalMiner+coalMerchant);
				updateLabel(itemAmount,"",coalWhole,coalMiner,coalMerchant*2);
				updateLabel(lblItem1,"Stone: ",stoneWhole,miner,coalMiner*4);
				updateLabel(lblItem2,"Coal Miners: ",coalMiner);
				updateLabel(lblItem3,"Coal Merchants: ",coalMerchant);
				lblCost2.setText("(1) Cost: 10 Coal | M$5.00");
				if (coalWhole >= 10 && moneyWhole >= 5) {
					String end = "";
					if ((coalWhole < 20000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((coalWhole < 4000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((coalWhole < 2000 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(coalWhole/10)) {
						
						if (multi == 1) lblCost2.setText("(1) Cost: 10 Coal | M$5.00");
						
						else if (multi == 2) lblCost2.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2)+" Coal | M$"+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))+end);
						
						else if (multi == 3) lblCost2.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2)+" Coal | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))+end);
						
						else lblCost2.setText("("+formatNumber((long)Math.floor(moneyWhole/5))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2)+" Coal | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))+end);
					
					} else {
						
						if (multi == 1) lblCost2.setText("(1) Cost: 10 Coal | M$5.00");
						
						else if (multi == 2) lblCost2.setText("("+formatNumber(((long)Math.floor(coalWhole/10))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(coalWhole/10))/2)-((long)Math.floor(((long)Math.floor(coalWhole/10))/2)%5))*2)+" Coal | M$"+formatNumber((long)Math.floor(((long)Math.floor(coalWhole/10))/2)-((long)Math.floor(((long)Math.floor(coalWhole/10))/2)%5))+end);
						
						else if (multi == 3) lblCost2.setText("("+formatNumber(((long)Math.floor(coalWhole/10))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(coalWhole/10))-((long)Math.floor(2.5*(long)Math.floor(coalWhole/10))%5))*2)+" Coal | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(coalWhole/10))-((long)Math.floor(2.5*(long)Math.floor(coalWhole/10))%5))+end);
						
						else lblCost2.setText("("+formatNumber((long)Math.floor(coalWhole/10))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(coalWhole/10))-((long)Math.floor(5*(long)Math.floor(coalWhole/10))%5))*2)+" Coal | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(coalWhole/10))-((long)Math.floor(5*(long)Math.floor(coalWhole/10))%5))+end);
						
					}
					if (multi == 2 && (coalWhole < 100 || moneyWhole < 50)) lblCost2.setText("(1) Cost: 10 Coal | M$5.00");
					else if (multi == 3 && (coalWhole < 20 || moneyWhole < 10)) lblCost2.setText("(1) Cost: 10 Coal | M$5.00");
				}
				lblCost3.setText("(1) Cost: 5 Coal | M$10.00");
				if (coalWhole >= 5 && moneyWhole >= 10) {
					String end = "";
					if ((coalWhole < 5000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((coalWhole < 1000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((coalWhole < 500 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/10) < (long)Math.floor(coalWhole/5)) {
						
						if (multi == 1) lblCost3.setText("(1) Cost: 5 Coal | M$10.00");
						
						else if (multi == 2) lblCost3.setText("("+formatNumber(((long)Math.floor(moneyWhole/10))/10)+") Cost: "+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))+" Coal | M$"+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))*2)+end);
						
						else if (multi == 3) lblCost3.setText("("+formatNumber(((long)Math.floor(moneyWhole/10))/2)+") Cost: "+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))+" Coal | M$"+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))*2)+end);
						
						else lblCost3.setText("("+formatNumber((long)Math.floor(moneyWhole/10))+") Cost: "+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))+" Coal | M$"+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))*2)+end);
					
					} else {
						
						if (multi == 1) lblCost3.setText("(1) Cost: 5 Coal | M$10.00");
						
						else if (multi == 2) lblCost3.setText("("+formatNumber(((long)Math.floor(coalWhole/5))/10)+") Cost: "+formatNumber((long)Math.floor(((long)Math.floor(coalWhole/5))/2)-((long)Math.floor(((long)Math.floor(coalWhole/5))/2)%5))+" Coal | M$"+formatNumber(((long)Math.floor(((long)Math.floor(coalWhole/5))/2)-((long)Math.floor(((long)Math.floor(coalWhole/5))/2)%5))*2)+end);
						
						else if (multi == 3) lblCost3.setText("("+formatNumber(((long)Math.floor(coalWhole/5))/2)+") Cost: "+formatNumber((long)Math.floor(2.5*(long)Math.floor(coalWhole/5))-((long)Math.floor(2.5*(long)Math.floor(coalWhole/5))%5))+" Coal | M$"+formatNumber(((long)Math.floor(2.5*(long)Math.floor(coalWhole/5))-((long)Math.floor(2.5*(long)Math.floor(coalWhole/5))%5))*2)+end);
						
						else lblCost3.setText("("+formatNumber((long)Math.floor(coalWhole/5))+") Cost: "+formatNumber((long)Math.floor(5*(long)Math.floor(coalWhole/5))-((long)Math.floor(5*(long)Math.floor(coalWhole/5))%5))+" Coal | M$"+formatNumber(((long)Math.floor(5*(long)Math.floor(coalWhole/5))-((long)Math.floor(5*(long)Math.floor(coalWhole/5))%5))*2)+end);
						
					}
					if (multi == 2 && (coalWhole < 50 || moneyWhole < 100)) lblCost3.setText("(1) Cost: 5 Coal | M$10.00");
					else if (multi == 3 && (coalWhole < 10 || moneyWhole < 20)) lblCost3.setText("(1) Cost: 5 Coal | M$10.00");
				}
			}
		} else if (currentPage == 9) {
			if (rank == 2) {
				updateBuilding(woodWhole+lumberjack);
				updateLabel(itemAmount,"",woodWhole,lumberjack,woodCutter*4);
				updateLabel(lblItem1,"Lumberjacks: ",lumberjack);
				lblCost1.setText("(1) Cost: 10 Wood | M$5.00");
				if (woodWhole >= 10 && moneyWhole >= 5) {
					String end = "";
					if ((woodWhole < 20000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((woodWhole < 4000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((woodWhole < 2000 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(woodWhole/10)) {
						
						if (multi == 1) lblCost1.setText("(1) Cost: 10 Wood | M$5.00");
						
						else if (multi == 2) lblCost1.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2)+" Wood | M$"+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))+end);
						
						else if (multi == 3) lblCost1.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2)+" Wood | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))+end);
						
						else lblCost1.setText("("+formatNumber((long)Math.floor(moneyWhole/5))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2)+" Wood | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))+end);
					
					} else {
						
						if (multi == 1) lblCost1.setText("(1) Cost: 10 Wood | M$5.00");
						
						else if (multi == 2) lblCost1.setText("("+formatNumber(((long)Math.floor(woodWhole/10))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(woodWhole/10))/2)-((long)Math.floor(((long)Math.floor(woodWhole/10))/2)%5))*2)+" Wood | M$"+formatNumber((long)Math.floor(((long)Math.floor(woodWhole/10))/2)-((long)Math.floor(((long)Math.floor(woodWhole/10))/2)%5))+end);
						
						else if (multi == 3) lblCost1.setText("("+formatNumber(((long)Math.floor(woodWhole/10))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(woodWhole/10))-((long)Math.floor(2.5*(long)Math.floor(woodWhole/10))%5))*2)+" Wood | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(woodWhole/10))-((long)Math.floor(2.5*(long)Math.floor(woodWhole/10))%5))+end);
						
						else lblCost1.setText("("+formatNumber((long)Math.floor(woodWhole/10))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(woodWhole/10))-((long)Math.floor(5*(long)Math.floor(woodWhole/10))%5))*2)+" Wood | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(woodWhole/10))-((long)Math.floor(5*(long)Math.floor(woodWhole/10))%5))+end);
						
					}
					if (multi == 2 && (woodWhole < 100 || moneyWhole < 50)) lblCost1.setText("(1) Cost: 10 Wood | M$5.00");
					else if (multi == 3 && (woodWhole < 20 || moneyWhole < 10)) lblCost1.setText("(1) Cost: 10 Wood | M$5.00");
				}
			}
		} else if (currentPage == 10) {
			if (rank == 2) {
				lblPrice.setText("Price: M$"+plankPrice+"0");
				updateBuilding(plankWhole+woodCutter+plankMerchant);
				updateLabel(itemAmount,"",plankWhole,woodCutter,plankMerchant*2);
				updateLabel(lblItem1,"Wood: ",woodWhole,lumberjack,woodCutter*4);
				updateLabel(lblItem2,"Wood Cutters: ",woodCutter);
				updateLabel(lblItem3,"Plank Merchants: ",plankMerchant);
				lblCost2.setText("(1) Cost: 10 Planks | M$5.00");
				if (plankWhole >= 10 && moneyWhole >= 5) {
					String end = "";
					if ((plankWhole < 20000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((plankWhole < 4000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((plankWhole < 2000 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(plankWhole/10)) {
						
						if (multi == 1) lblCost2.setText("(1) Cost: 10 Planks | M$5.00");
						
						else if (multi == 2) lblCost2.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2)+" Planks | M$"+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))+end);
						
						else if (multi == 3) lblCost2.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2)+" Planks | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))+end);
						
						else lblCost2.setText("("+formatNumber((long)Math.floor(moneyWhole/5))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2)+" Planks | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))+end);
					
					} else {
						
						if (multi == 1) lblCost2.setText("(1) Cost: 10 Planks | M$5.00");
						
						else if (multi == 2) lblCost2.setText("("+formatNumber(((long)Math.floor(plankWhole/10))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(plankWhole/10))/2)-((long)Math.floor(((long)Math.floor(plankWhole/10))/2)%5))*2)+" Planks | M$"+formatNumber((long)Math.floor(((long)Math.floor(plankWhole/10))/2)-((long)Math.floor(((long)Math.floor(plankWhole/10))/2)%5))+end);
						
						else if (multi == 3) lblCost2.setText("("+formatNumber(((long)Math.floor(plankWhole/10))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(plankWhole/10))-((long)Math.floor(2.5*(long)Math.floor(plankWhole/10))%5))*2)+" Planks | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(plankWhole/10))-((long)Math.floor(2.5*(long)Math.floor(plankWhole/10))%5))+end);
						
						else lblCost2.setText("("+formatNumber((long)Math.floor(plankWhole/10))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(plankWhole/10))-((long)Math.floor(5*(long)Math.floor(plankWhole/10))%5))*2)+" Planks | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(plankWhole/10))-((long)Math.floor(5*(long)Math.floor(plankWhole/10))%5))+end);
						
					}
					if (multi == 2 && (plankWhole < 100 || moneyWhole < 50)) lblCost2.setText("(1) Cost: 10 Planks | M$5.00");
					else if (multi == 3 && (plankWhole < 20 || moneyWhole < 10)) lblCost2.setText("(1) Cost: 10 Planks | M$5.00");
				}
				lblCost3.setText("(1) Cost: 5 Planks | M$10.00");
				if (plankWhole >= 5 && moneyWhole >= 10) {
					String end = "";
					if ((plankWhole < 5000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((plankWhole < 1000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((plankWhole < 500 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/10) < (long)Math.floor(plankWhole/5)) {
						
						if (multi == 1) lblCost3.setText("(1) Cost: 5 Planks | M$10.00");
						
						else if (multi == 2) lblCost3.setText("("+formatNumber(((long)Math.floor(moneyWhole/10))/10)+") Cost: "+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))+" Planks | M$"+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))*2)+end);
						
						else if (multi == 3) lblCost3.setText("("+formatNumber(((long)Math.floor(moneyWhole/10))/2)+") Cost: "+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))+" Planks | M$"+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))*2)+end);
						
						else lblCost3.setText("("+formatNumber((long)Math.floor(moneyWhole/10))+") Cost: "+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))+" Planks | M$"+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))*2)+end);
					
					} else {
						
						if (multi == 1) lblCost3.setText("(1) Cost: 5 Planks | M$10.00");
						
						else if (multi == 2) lblCost3.setText("("+formatNumber(((long)Math.floor(plankWhole/5))/10)+") Cost: "+formatNumber((long)Math.floor(((long)Math.floor(plankWhole/5))/2)-((long)Math.floor(((long)Math.floor(plankWhole/5))/2)%5))+" Planks | M$"+formatNumber(((long)Math.floor(((long)Math.floor(plankWhole/5))/2)-((long)Math.floor(((long)Math.floor(plankWhole/5))/2)%5))*2)+end);
						
						else if (multi == 3) lblCost3.setText("("+formatNumber(((long)Math.floor(plankWhole/5))/2)+") Cost: "+formatNumber((long)Math.floor(2.5*(long)Math.floor(plankWhole/5))-((long)Math.floor(2.5*(long)Math.floor(plankWhole/5))%5))+" Planks | M$"+formatNumber(((long)Math.floor(2.5*(long)Math.floor(plankWhole/5))-((long)Math.floor(2.5*(long)Math.floor(plankWhole/5))%5))*2)+end);
						
						else lblCost3.setText("("+formatNumber((long)Math.floor(plankWhole/5))+") Cost: "+formatNumber((long)Math.floor(5*(long)Math.floor(plankWhole/5))-((long)Math.floor(5*(long)Math.floor(plankWhole/5))%5))+" Planks | M$"+formatNumber(((long)Math.floor(5*(long)Math.floor(plankWhole/5))-((long)Math.floor(5*(long)Math.floor(plankWhole/5))%5))*2)+end);
						
					}
					if (multi == 2 && (plankWhole < 50 || moneyWhole < 100)) lblCost3.setText("(1) Cost: 5 Planks | M$10.00");
					else if (multi == 3 && (plankWhole < 10 || moneyWhole < 20)) lblCost3.setText("(1) Cost: 5 Planks | M$10.00");
				}
			}
		} else if (currentPage == 11) {
			if (rank == 2) {
				updateBuilding(cropWhole+farmer);
				updateLabel(itemAmount,"",cropWhole,farmer,cottonFarmer*4);
				updateLabel(lblItem1,"Farmers: ",farmer);
				lblCost1.setText("(1) Cost: 10 Crops | M$5.00");
				if (cropWhole >= 10 && moneyWhole >= 5) {
					String end = "";
					if ((cropWhole < 20000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((cropWhole < 4000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((cropWhole < 2000 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(cropWhole/10)) {
						
						if (multi == 1) lblCost1.setText("(1) Cost: 10 Crops | M$5.00");
						
						else if (multi == 2) lblCost1.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2)+" Crops | M$"+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))+end);
						
						else if (multi == 3) lblCost1.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2)+" Crops | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))+end);
						
						else lblCost1.setText("("+formatNumber((long)Math.floor(moneyWhole/5))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2)+" Crops | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))+end);
					
					} else {
						
						if (multi == 1) lblCost1.setText("(1) Cost: 10 Crops | M$5.00");
						
						else if (multi == 2) lblCost1.setText("("+formatNumber(((long)Math.floor(cropWhole/10))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(cropWhole/10))/2)-((long)Math.floor(((long)Math.floor(cropWhole/10))/2)%5))*2)+" Crops | M$"+formatNumber((long)Math.floor(((long)Math.floor(cropWhole/10))/2)-((long)Math.floor(((long)Math.floor(cropWhole/10))/2)%5))+end);
						
						else if (multi == 3) lblCost1.setText("("+formatNumber(((long)Math.floor(cropWhole/10))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(cropWhole/10))-((long)Math.floor(2.5*(long)Math.floor(cropWhole/10))%5))*2)+" Crops | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(cropWhole/10))-((long)Math.floor(2.5*(long)Math.floor(cropWhole/10))%5))+end);
						
						else lblCost1.setText("("+formatNumber((long)Math.floor(cropWhole/10))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(cropWhole/10))-((long)Math.floor(5*(long)Math.floor(cropWhole/10))%5))*2)+" Crops | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(cropWhole/10))-((long)Math.floor(5*(long)Math.floor(cropWhole/10))%5))+end);
						
					}
					if (multi == 2 && (cropWhole < 100 || moneyWhole < 50)) lblCost1.setText("(1) Cost: 10 Crops | M$5.00");
					else if (multi == 3 && (cropWhole < 20 || moneyWhole < 10)) lblCost1.setText("(1) Cost: 10 Crops | M$5.00");
				}
			}
		} else if (currentPage == 12) {
			if (rank == 2) {
				lblPrice.setText("Price: M$"+cottonPrice+"0");
				updateBuilding(cottonWhole+cottonFarmer+cottonMerchant);
				updateLabel(itemAmount,"",cottonWhole,cottonFarmer,cottonMerchant*2);
				updateLabel(lblItem1,"Crops: ",cropWhole,farmer,cottonFarmer*4);
				updateLabel(lblItem2,"Cotton Farmers: ",cottonFarmer);
				updateLabel(lblItem3,"Cotton Merchants: ",cottonMerchant);
				lblCost2.setText("(1) Cost: 10 Cotton | M$5.00");
				if (cottonWhole >= 10 && moneyWhole >= 5) {
					String end = "";
					if ((cottonWhole < 20000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((cottonWhole < 4000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((cottonWhole < 2000 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/5) < (long)Math.floor(cottonWhole/10)) {
						
						if (multi == 1) lblCost2.setText("(1) Cost: 10 Cotton | M$5.00");
						
						else if (multi == 2) lblCost2.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))*2)+" Cotton | M$"+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/5))/2)%5))+end);
						
						else if (multi == 3) lblCost2.setText("("+formatNumber(((long)Math.floor(moneyWhole/5))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))*2)+" Cotton | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/5))%5))+end);
						
						else lblCost2.setText("("+formatNumber((long)Math.floor(moneyWhole/5))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))*2)+" Cotton | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/5))-((long)Math.floor(5*(long)Math.floor(moneyWhole/5))%5))+end);
					
					} else {
						
						if (multi == 1) lblCost2.setText("(1) Cost: 10 Cotton | M$5.00");
						
						else if (multi == 2) lblCost2.setText("("+formatNumber(((long)Math.floor(cottonWhole/10))/10)+") Cost: "+formatNumber(((long)Math.floor(((long)Math.floor(cottonWhole/10))/2)-((long)Math.floor(((long)Math.floor(cottonWhole/10))/2)%5))*2)+" Cotton | M$"+formatNumber((long)Math.floor(((long)Math.floor(cottonWhole/10))/2)-((long)Math.floor(((long)Math.floor(cottonWhole/10))/2)%5))+end);
						
						else if (multi == 3) lblCost2.setText("("+formatNumber(((long)Math.floor(cottonWhole/10))/2)+") Cost: "+formatNumber(((long)Math.floor(2.5*(long)Math.floor(cottonWhole/10))-((long)Math.floor(2.5*(long)Math.floor(cottonWhole/10))%5))*2)+" Cotton | M$"+formatNumber((long)Math.floor(2.5*(long)Math.floor(cottonWhole/10))-((long)Math.floor(2.5*(long)Math.floor(cottonWhole/10))%5))+end);
						
						else lblCost2.setText("("+formatNumber((long)Math.floor(cottonWhole/10))+") Cost: "+formatNumber(((long)Math.floor(5*(long)Math.floor(cottonWhole/10))-((long)Math.floor(5*(long)Math.floor(cottonWhole/10))%5))*2)+" Cotton | M$"+formatNumber((long)Math.floor(5*(long)Math.floor(cottonWhole/10))-((long)Math.floor(5*(long)Math.floor(cottonWhole/10))%5))+end);
						
					}
					if (multi == 2 && (cottonWhole < 100 || moneyWhole < 50)) lblCost2.setText("(1) Cost: 10 Cotton | M$5.00");
					else if (multi == 3 && (cottonWhole < 20 || moneyWhole < 10)) lblCost2.setText("(1) Cost: 10 Cotton | M$5.00");
				}
				lblCost3.setText("(1) Cost: 5 Cotton | M$10.00");
				if (cottonWhole >= 5 && moneyWhole >= 10) {
					String end = "";
					if ((cottonWhole < 5000 || moneyWhole < 10000) && multi == 2) end = ".00";
					else if ((cottonWhole < 1000 || moneyWhole < 2000) && multi == 3) end = ".00";
					else if ((cottonWhole < 500 || moneyWhole < 1000) && multi == 4) end = ".00";
					if ((long)Math.floor(moneyWhole/10) < (long)Math.floor(cottonWhole/5)) {
						
						if (multi == 1) lblCost3.setText("(1) Cost: 5 Cotton | M$10.00");
						
						else if (multi == 2) lblCost3.setText("("+formatNumber(((long)Math.floor(moneyWhole/10))/10)+") Cost: "+formatNumber((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))+" Cotton | M$"+formatNumber(((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)-((long)Math.floor(((long)Math.floor(moneyWhole/10))/2)%5))*2)+end);
						
						else if (multi == 3) lblCost3.setText("("+formatNumber(((long)Math.floor(moneyWhole/10))/2)+") Cost: "+formatNumber((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))+" Cotton | M$"+formatNumber(((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(2.5*(long)Math.floor(moneyWhole/10))%5))*2)+end);
						
						else lblCost3.setText("("+formatNumber((long)Math.floor(moneyWhole/10))+") Cost: "+formatNumber((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))+" Cotton | M$"+formatNumber(((long)Math.floor(5*(long)Math.floor(moneyWhole/10))-((long)Math.floor(5*(long)Math.floor(moneyWhole/10))%5))*2)+end);
					
					} else {
						
						if (multi == 1) lblCost3.setText("(1) Cost: 5 Cotton | M$10.00");
						
						else if (multi == 2) lblCost3.setText("("+formatNumber(((long)Math.floor(cottonWhole/5))/10)+") Cost: "+formatNumber((long)Math.floor(((long)Math.floor(cottonWhole/5))/2)-((long)Math.floor(((long)Math.floor(cottonWhole/5))/2)%5))+" Cotton | M$"+formatNumber(((long)Math.floor(((long)Math.floor(cottonWhole/5))/2)-((long)Math.floor(((long)Math.floor(cottonWhole/5))/2)%5))*2)+end);
						
						else if (multi == 3) lblCost3.setText("("+formatNumber(((long)Math.floor(cottonWhole/5))/2)+") Cost: "+formatNumber((long)Math.floor(2.5*(long)Math.floor(cottonWhole/5))-((long)Math.floor(2.5*(long)Math.floor(cottonWhole/5))%5))+" Cotton | M$"+formatNumber(((long)Math.floor(2.5*(long)Math.floor(cottonWhole/5))-((long)Math.floor(2.5*(long)Math.floor(cottonWhole/5))%5))*2)+end);
						
						else lblCost3.setText("("+formatNumber((long)Math.floor(cottonWhole/5))+") Cost: "+formatNumber((long)Math.floor(5*(long)Math.floor(cottonWhole/5))-((long)Math.floor(5*(long)Math.floor(cottonWhole/5))%5))+" Cotton | M$"+formatNumber(((long)Math.floor(5*(long)Math.floor(cottonWhole/5))-((long)Math.floor(5*(long)Math.floor(cottonWhole/5))%5))*2)+end);
						
					}
					if (multi == 2 && (cottonWhole < 50 || moneyWhole < 100)) lblCost3.setText("(1) Cost: 5 Cotton | M$10.00");
					else if (multi == 3 && (cottonWhole < 10 || moneyWhole < 20)) lblCost3.setText("(1) Cost: 5 Cotton | M$10.00");
				}
			}
		}
	}
	
	public void dailyReward() {
		imgPopUp.setVisible(true);
		closePopUp.setVisible(true);
		lblPopUpTitle.setVisible(true);
		imgCompetitorResource.setVisible(true);
		lblCompetitorName.setVisible(true);
		lblCompetitorPrice.setVisible(true);
		lblCompetitorPrice.setTextFill(Color.web("#00ff00"));
		currentDate = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		lblPopUpTitle.setText(currentDate+" - Daily Reward");
		boolean finished = false;
		int num;
		if (foodWhole <= 0 && fishWhole <= 0 && stoneWhole <= 0 && coalWhole <= 0 && woodWhole <= 0 && plankWhole <= 0 && cropWhole <= 0 && cottonWhole <= 0 && steakWhole <= 0 && porkWhole <= 0 && chickenWhole <= 0 && muttonWhole <= 0) {
			currentDate = "";
			imgPopUp.setVisible(false);
			closePopUp.setVisible(false);
			lblPopUpTitle.setVisible(false);
			imgCompetitorResource.setVisible(false);
			lblCompetitorName.setVisible(false);
			lblCompetitorPrice.setVisible(false);
			lblCompetitorPrice.setTextFill(Color.web("#000000"));
			if (!lastVersion.equals(currentVersion)) {
				activateChangelog();
				goBackButton.setVisible(false);
				goBackIcon.setVisible(false);
				lastVersion = currentVersion;
			}
		} else while (!finished) {
			if (rank == 1) {
				num = rand.nextInt(8);
				if (num == 0) {
					if (foodWhole > 0) {
						imgCompetitorResource.setImage(new Image("img/resources/food/food.png"));
						lblCompetitorName.setText("Food");
						updateLabel(lblCompetitorPrice,"+",foodWhole);
						foodWhole *= 2;
						finished = true;
					}
				} else if (num == 1) {
					if (fishWhole > 0) {
						imgCompetitorResource.setImage(new Image("img/resources/food/fish.png"));
						lblCompetitorName.setText("Fish");
						updateLabel(lblCompetitorPrice,"+",fishWhole);
						fishWhole *= 2;
						finished = true;
					}
				} else if (num == 2) {
					if (stoneWhole > 0) {
						imgCompetitorResource.setImage(new Image("img/resources/stone/stone.png"));
						lblCompetitorName.setText("Stone");
						updateLabel(lblCompetitorPrice,"+",stoneWhole);
						stoneWhole *= 2;
						finished = true;
					}
				} else if (num == 3) {
					if (coalWhole > 0) {
						imgCompetitorResource.setImage(new Image("img/resources/stone/coal.png"));
						lblCompetitorName.setText("Coal");
						updateLabel(lblCompetitorPrice,"+",coalWhole);
						coalWhole *= 2;
						finished = true;
					}
				} else if (num == 4) {
					if (woodWhole > 0) {
						imgCompetitorResource.setImage(new Image("img/resources/wood/wood.png"));
						lblCompetitorName.setText("Wood");
						updateLabel(lblCompetitorPrice,"+",woodWhole);
						woodWhole *= 2;
						finished = true;
					}
				} else if (num == 5) {
					if (plankWhole > 0) {
						imgCompetitorResource.setImage(new Image("img/resources/wood/plank.png"));
						lblCompetitorName.setText("Planks");
						updateLabel(lblCompetitorPrice,"+",plankWhole);
						plankWhole *= 2;
						finished = true;
					}
				} else if (num == 6) {
					if (cropWhole > 0) {
						imgCompetitorResource.setImage(new Image("img/resources/crop/crop.png"));
						lblCompetitorName.setText("crop");
						updateLabel(lblCompetitorPrice,"+",cropWhole);
						cropWhole *= 2;
						finished = true;
					}
				} else if (num == 7) {
					if (cottonWhole > 0) {
						imgCompetitorResource.setImage(new Image("img/resources/crop/cotton.png"));
						lblCompetitorName.setText("Cotton");
						updateLabel(lblCompetitorPrice,"+",cottonWhole);
						cottonWhole *= 2;
						finished = true;
					}
				}
			} else if (rank == 2) {
				num = rand.nextInt(12);
				if (num == 0) {
					if (foodWhole > 0) {
						imgCompetitorResource.setImage(new Image("img/resources/food/food.png"));
						lblCompetitorName.setText("Food");
						updateLabel(lblCompetitorPrice,"+",foodWhole);
						foodWhole *= 2;
						finished = true;
					}
				} else if (num == 1) {
					if (fishWhole > 0) {
						imgCompetitorResource.setImage(new Image("img/resources/food/fish.png"));
						lblCompetitorName.setText("Fish");
						updateLabel(lblCompetitorPrice,"+",fishWhole);
						fishWhole *= 2;
						finished = true;
					}
				} else if (num == 2) {
					if (steakWhole > 0) {
						imgCompetitorResource.setImage(new Image("img/resources/food/steak.png"));
						lblCompetitorName.setText("Steak");
						updateLabel(lblCompetitorPrice,"+",steakWhole);
						steakWhole *= 2;
						finished = true;
					}
				} else if (num == 3) {
					if (porkWhole > 0) {
						imgCompetitorResource.setImage(new Image("img/resources/food/pork.png"));
						lblCompetitorName.setText("Pork");
						updateLabel(lblCompetitorPrice,"+",porkWhole);
						porkWhole *= 2;
						finished = true;
					}
				} else if (num == 4) {
					if (chickenWhole > 0) {
						imgCompetitorResource.setImage(new Image("img/resources/food/chicken.png"));
						lblCompetitorName.setText("Chicken");
						updateLabel(lblCompetitorPrice,"+",chickenWhole);
						chickenWhole *= 2;
						finished = true;
					}
				} else if (num == 5) {
					if (muttonWhole > 0) {
						imgCompetitorResource.setImage(new Image("img/resources/food/mutton.png"));
						lblCompetitorName.setText("Mutton");
						updateLabel(lblCompetitorPrice,"+",muttonWhole);
						muttonWhole *= 2;
						finished = true;
					}
				} else if (num == 6) {
					if (stoneWhole > 0) {
						imgCompetitorResource.setImage(new Image("img/resources/stone/stone.png"));
						lblCompetitorName.setText("Stone");
						updateLabel(lblCompetitorPrice,"+",stoneWhole);
						stoneWhole *= 2;
						finished = true;
					}
				} else if (num == 7) {
					if (coalWhole > 0) {
						imgCompetitorResource.setImage(new Image("img/resources/stone/coal.png"));
						lblCompetitorName.setText("Coal");
						updateLabel(lblCompetitorPrice,"+",coalWhole);
						coalWhole *= 2;
						finished = true;
					}
				} else if (num == 8) {
					if (woodWhole > 0) {
						imgCompetitorResource.setImage(new Image("img/resources/wood/wood.png"));
						lblCompetitorName.setText("Wood");
						updateLabel(lblCompetitorPrice,"+",woodWhole);
						woodWhole *= 2;
						finished = true;
					}
				} else if (num == 9) {
					if (plankWhole > 0) {
						imgCompetitorResource.setImage(new Image("img/resources/wood/plank.png"));
						lblCompetitorName.setText("Planks");
						updateLabel(lblCompetitorPrice,"+",plankWhole);
						plankWhole *= 2;
						finished = true;
					}
				} else if (num == 10) {
					if (cropWhole > 0) {
						imgCompetitorResource.setImage(new Image("img/resources/crop/crop.png"));
						lblCompetitorName.setText("crop");
						updateLabel(lblCompetitorPrice,"+",cropWhole);
						cropWhole *= 2;
						finished = true;
					}
				} else if (num == 11) {
					if (cottonWhole > 0) {
						imgCompetitorResource.setImage(new Image("img/resources/crop/cotton.png"));
						lblCompetitorName.setText("Cotton");
						updateLabel(lblCompetitorPrice,"+",cottonWhole);
						cottonWhole *= 2;
						finished = true;
					}
				}
			}
		}
		save();
	}
	
	public void resourceCheck() {
		try {
			long time = milliTime();
			
			if (firstTime) {
				scene = itemImage.getScene();
				firstTime = false;
			}
			
			checkConsole();
			checkAchievements();
			
			lblRank.setText("Rank: "+rank);

			if (music) {
				if (!musicPlaying) {
					if (rand.nextInt(2500) == rand.nextInt(2500)) {
						int i = lastMusic;
						while (i == lastMusic) i = rand.nextInt(3)+1;
						audioInputStream = AudioSystem.getAudioInputStream(new File("sound/idle"+i+".wav").getAbsoluteFile());
						lastMusic = i;
						
			            clip = AudioSystem.getClip();
			            clip.open(audioInputStream);
			            clip.start();
			            musicPlaying = true;
					}
				} else if (!clip.isRunning()) musicPlaying = false;
			}

			moneyRate = " (M$"+new DecimalFormat("0.00").format((double)Math.round(fishMerchant*2*rank*10*checkCompetitor("Fish",fishPrice))/100+(double)Math.round(coalMerchant*2*rank*10*checkCompetitor("Coal",coalPrice))/100+(double)Math.round(plankMerchant*2*rank*10*checkCompetitor("Planks",plankPrice))/100+(double)Math.round(cottonMerchant*2*rank*10*checkCompetitor("Cotton",cottonPrice))/100)+"/sec)";
			
			timeElapsed = milliTime()-startingTime;

			checkFood();
			checkStone();
			checkWood();
			checkCrops();

			timeElapsed = milliTime()-competitorTime;

			checkCompetitor();
			
			if (inCompetitor) activateCompetitor();
			
			keyName1.setText(hotkey(buyKey1));
			keyName2.setText(hotkey(sellKey1));
			keyName3.setText(hotkey(buyKey2));
			keyName4.setText(hotkey(sellKey2));
			
			checkPage();
			
			startingTime = milliTime();
			competitorTime = startingTime;
			
			if (inStorage) updateStorageLabels();
			if (inAchievement) updateAchievements();

			sb = new StringBuilder(Double.toString((double)Math.floor(moneyDecimal*100)/100));
			sb.deleteCharAt(0);
			
			if (moneyWhole >= 1000000) {
				lblMoney.setText("Moneyz: M$"+(double)(moneyWhole-(moneyWhole%100000))/1000000+"M"+moneyRate);
			} else if (moneyWhole >= 1000) {
				lblMoney.setText("Moneyz: M$"+(double)(moneyWhole-(moneyWhole%100))/1000+"K"+moneyRate);
			} else {
				if (((double)Math.floor(moneyDecimal*100)%10) != 0) {
					lblMoney.setText("Moneyz: M$"+moneyWhole+sb.toString()+moneyRate);
				} else lblMoney.setText("Moneyz: M$"+moneyWhole+sb.toString()+"0"+moneyRate);
			}
			
			if (refreshTime.isVisible()) {
				timeElapsed = milliTime()-time;
				if (timeElapsed == 0) {
					refreshTime.setText("Refresh Time: 0.001 seconds (x1000/sec)");
				} else {
					refreshTime.setText("Refresh Time: "+((double)timeElapsed)/1000+" seconds (x"+1000/timeElapsed+"/sec)");
				}
				if (timeElapsed > longestRefresh) {
					longestRefresh = timeElapsed;
					System.out.println("Longest Refresh Time: "+longestRefresh/1000+" seconds");
				}
			}
		} catch (Exception e) {}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			scene = itemImage.getScene();
			
			String line;
			
			br = new BufferedReader(new FileReader("stats/currentUser.stat"));
			if ((line = br.readLine()) == null) username = "";
			else username = new TextEncryptor(line).encrypt(2);
			if ((line = br.readLine()) == null) resolution = "800x600";
			else resolution = new TextEncryptor(line).decrypt();
			br.close();
			
			File file = new File("stats/"+username+"/Stats.stat");
			if (!file.exists()) file.createNewFile();
			br = new BufferedReader(new FileReader("stats/"+username+"/Stats.stat"));
			if ((line = br.readLine()) == null) rank = 1;
			else rank = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) moneyWhole = 0;
			else moneyWhole = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) moneyDecimal = 0;
			else moneyDecimal = Double.parseDouble(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) startingTime = milliTime();
			else startingTime = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) currentDate = "";
			else currentDate = new TextEncryptor(line).decrypt();
			if ((line = br.readLine()) == null) lastVersion = "";
			else lastVersion = new TextEncryptor(line).decrypt();
			br.close();

			file = new File("stats/"+username+"/Prices.stat");
			if (!file.exists()) file.createNewFile();
			br = new BufferedReader(new FileReader("stats/"+username+"/Prices.stat"));
			if ((line = br.readLine()) == null) fishPrice = 1.0;
			else fishPrice = Double.parseDouble(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) coalPrice = 1.0;
			else coalPrice = Double.parseDouble(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) plankPrice = 1.0;
			else plankPrice = Double.parseDouble(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) cottonPrice = 1.0;
			else cottonPrice = Double.parseDouble(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) steakPrice = 1.0;
			else steakPrice = Double.parseDouble(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) porkPrice = 1.0;
			else porkPrice = Double.parseDouble(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) chickenPrice = 1.0;
			else chickenPrice = Double.parseDouble(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) muttonPrice = 1.0;
			else muttonPrice = Double.parseDouble(new TextEncryptor(line).decrypt());
			br.close();

			file = new File("stats/"+username+"/Food.stat");
			if (!file.exists()) file.createNewFile();
			br = new BufferedReader(new FileReader("stats/"+username+"/Food.stat"));
			if ((line = br.readLine()) == null) foodWhole = 0;
			else foodWhole = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) foodDecimal = 0.0;
			else foodDecimal = Double.parseDouble(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) rancher = 0;
			else rancher = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) fishWhole = 0;
			else fishWhole = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) fishDecimal = 0.0;
			else fishDecimal = Double.parseDouble(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) fisher = 0;
			else fisher = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) fishMerchant = 0;
			else fishMerchant = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) steakWhole = 0;
			else steakWhole = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) steakDecimal = 0.0;
			else steakDecimal = Double.parseDouble(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) cowRancher = 0;
			else cowRancher = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) steakMerchant = 0;
			else steakMerchant = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) porkWhole = 0;
			else porkWhole = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) porkDecimal = 0.0;
			else porkDecimal = Double.parseDouble(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) pigRancher = 0;
			else pigRancher = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) porkMerchant = 0;
			else porkMerchant = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) chickenWhole = 0;
			else chickenWhole = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) chickenDecimal = 0.0;
			else chickenDecimal = Double.parseDouble(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) chickenRancher = 0;
			else chickenRancher = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) chickenMerchant = 0;
			else chickenMerchant = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) muttonWhole = 0;
			else muttonWhole = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) muttonDecimal = 0.0;
			else muttonDecimal = Double.parseDouble(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) sheepRancher = 0;
			else sheepRancher = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) muttonMerchant = 0;
			else muttonMerchant = Long.parseLong(new TextEncryptor(line).decrypt());
			br.close();

			file = new File("stats/"+username+"/Stone.stat");
			if (!file.exists()) file.createNewFile();
			br = new BufferedReader(new FileReader("stats/"+username+"/Stone.stat"));
			if ((line = br.readLine()) == null) stoneWhole = 0;
			else stoneWhole = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) stoneDecimal = 0.0;
			else stoneDecimal = Double.parseDouble(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) miner = 0;
			else miner = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) coalWhole = 0;
			else coalWhole = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) coalDecimal = 0.0;
			else coalDecimal = Double.parseDouble(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) coalMiner = 0;
			else coalMiner = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) coalMerchant = 0;
			else coalMerchant = Long.parseLong(new TextEncryptor(line).decrypt());
			br.close();

			file = new File("stats/"+username+"/Wood.stat");
			if (!file.exists()) file.createNewFile();
			br = new BufferedReader(new FileReader("stats/"+username+"/Wood.stat"));
			if ((line = br.readLine()) == null) woodWhole = 0;
			else woodWhole = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) woodDecimal = 0.0;
			else woodDecimal = Double.parseDouble(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) lumberjack = 0;
			else lumberjack = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) plankWhole = 0;
			else plankWhole = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) plankDecimal = 0.0;
			else plankDecimal = Double.parseDouble(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) woodCutter = 0;
			else woodCutter = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) plankMerchant = 0;
			else plankMerchant = Long.parseLong(new TextEncryptor(line).decrypt());
			br.close();

			file = new File("stats/"+username+"/Crop.stat");
			if (!file.exists()) file.createNewFile();
			br = new BufferedReader(new FileReader("stats/"+username+"/Crop.stat"));
			if ((line = br.readLine()) == null) cropWhole = 0;
			else cropWhole = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) cropDecimal = 0.0;
			else cropDecimal = Double.parseDouble(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) farmer = 0;
			else farmer = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) cottonWhole = 0;
			else cottonWhole = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) cottonDecimal = 0.0;
			else cottonDecimal = Double.parseDouble(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) cottonFarmer = 0;
			else cottonFarmer = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) cottonMerchant = 0;
			else cottonMerchant = Long.parseLong(new TextEncryptor(line).decrypt());
			br.close();

			file = new File("stats/"+username+"/Competitor.stat");
			if (!file.exists()) file.createNewFile();
			br = new BufferedReader(new FileReader("stats/"+username+"/Competitor.stat"));
			if ((line = br.readLine()) == null) competitorTime = milliTime();
			else competitorTime = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) competitorWhole = 0;
			else competitorWhole = Long.parseLong(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) competitorDecimal = 0.0;
			else competitorDecimal = Double.parseDouble(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) competitorPrice = 0.0;
			else competitorPrice = Double.parseDouble(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) competitorResource = "";
			else competitorResource = new TextEncryptor(line).decrypt();
			if ((line = br.readLine()) == null) competitorCompany = "";
			else competitorCompany = new TextEncryptor(line).decrypt();
			br.close();

			file = new File("stats/"+username+"/Keys.stat");
			if (!file.exists()) file.createNewFile();
			br = new BufferedReader(new FileReader("stats/"+username+"/Keys.stat"));
			if ((line = br.readLine()) == null) buyKey1 = KeyCode.W;
			else buyKey1 = keyCode(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) buyKey2 = KeyCode.R;
			else buyKey2 = keyCode(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) sellKey1 = KeyCode.S;
			else sellKey1 = keyCode(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) sellKey2 = KeyCode.F;
			else sellKey2 = keyCode(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) goToNext = KeyCode.D;
			else goToNext = keyCode(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) goToPrev = KeyCode.A;
			else goToPrev = keyCode(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) goToFirst = KeyCode.HOME;
			else goToFirst = keyCode(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) goToLast = KeyCode.END;
			else goToLast = keyCode(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) openStorage = KeyCode.B;
			else openStorage = keyCode(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) openAchievement = KeyCode.N;
			else openAchievement = keyCode(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) openCompetitor = KeyCode.M;
			else openCompetitor = keyCode(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) openOptions = KeyCode.ESCAPE;
			else openOptions = keyCode(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) increasePrice = KeyCode.E;
			else increasePrice = keyCode(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) decreasePrice = KeyCode.Q;
			else decreasePrice = keyCode(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) increaseMultiplier = KeyCode.C;
			else increaseMultiplier = keyCode(new TextEncryptor(line).decrypt());
			if ((line = br.readLine()) == null) decreaseMultiplier = KeyCode.X;
			else decreaseMultiplier = keyCode(new TextEncryptor(line).decrypt());
			br.close();

			keyName1.setText(hotkey(buyKey1));
			keyName2.setText(hotkey(sellKey1));
			keyName3.setText(hotkey(buyKey2));
			keyName4.setText(hotkey(sellKey2));
			
			achievement = new long[13];

			file = new File("stats/"+username+"/Achievements.stat");
			if (!file.exists()) file.createNewFile();
			br = new BufferedReader(new FileReader("stats/"+username+"/Achievements.stat"));
			for (int i=0;i<achievement.length;i++) {
				if ((line = br.readLine()) == null) achievement[i] = 0;
				else achievement[i] = Long.parseLong(new TextEncryptor(line).decrypt());
			}
			br.close();
			
			br = new BufferedReader(new FileReader("stats/changelog.stat"));
			lblPopUpTitle.setText(br.readLine());
			br.readLine();
			
			lblChangelog.setText("");
			while ((line = br.readLine()) != null) {
				lblChangelog.setText(lblChangelog.getText()+line+" \n");
			}
			br.close();
			
			lblVersion.setText("Company Simulator v"+currentVersion);
			
			logoutButton.setVisible(false);
			lblLogout.setVisible(false);
			
			closePopUp.setOnMouseReleased(this::cancelMouseReleased);
			
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			double width = screenSize.getWidth();
			double height = screenSize.getHeight();
			bBottom.setLayoutY((long)((height*685)/1080));
			if (new SimpleDateFormat("MM").format(new Date()).equals("12")) {
				companyBackground.setImage(new Image("img/backgrounds/companySnowBackground1920x1080.png"));
			} else companyBackground.setImage(new Image("img/backgrounds/companyBackground1920x1080.png"));
			
			anchor.setMinWidth(width);
			anchor.setMinHeight(height);
			anchor.setPrefWidth(width);
			anchor.setPrefHeight(height);
			anchor.setMaxWidth(width);
			anchor.setMaxHeight(height);

			companyBackground.setFitWidth(width);
			companyBackground.setFitHeight(height);
			
			imgPopUp.setLayoutX(width/2-350);
			imgPopUp.setLayoutY(height/2-250);
			
			lblPopUpTitle.setLayoutX(imgPopUp.getLayoutX());
			lblPopUpTitle.setLayoutY(imgPopUp.getLayoutY()+10);

			closePopUp.setLayoutX(imgPopUp.getLayoutX()+653);
			closePopUp.setLayoutY(imgPopUp.getLayoutY()+15);

			goBackButton.setLayoutX(imgPopUp.getLayoutX()+15);
			goBackButton.setLayoutY(imgPopUp.getLayoutY()+15);

			goBackIcon.setLayoutX(goBackButton.getLayoutX());
			goBackIcon.setLayoutY(goBackButton.getLayoutY());

			lblChangelog.setLayoutX(imgPopUp.getLayoutX()+35);
			lblChangelog.setLayoutY(closePopUp.getLayoutY()+32);

			lblCredits.setLayoutX(lblChangelog.getLayoutX());
			lblCredits.setLayoutY(lblChangelog.getLayoutY()-20);

			imgHotkey1.setLayoutX(imgPopUp.getLayoutX()+30);
			imgHotkey1.setLayoutY(imgPopUp.getLayoutY()+60);

			imgHotkey2.setLayoutX(imgHotkey1.getLayoutX());
			imgHotkey2.setLayoutY(imgHotkey1.getLayoutY()+35);

			imgHotkey3.setLayoutX(imgHotkey2.getLayoutX());
			imgHotkey3.setLayoutY(imgHotkey2.getLayoutY()+35);

			imgHotkey4.setLayoutX(imgHotkey3.getLayoutX());
			imgHotkey4.setLayoutY(imgHotkey3.getLayoutY()+35);

			imgHotkey5.setLayoutX(imgHotkey4.getLayoutX());
			imgHotkey5.setLayoutY(imgHotkey4.getLayoutY()+35);

			imgHotkey6.setLayoutX(imgHotkey5.getLayoutX());
			imgHotkey6.setLayoutY(imgHotkey5.getLayoutY()+35);

			imgHotkey7.setLayoutX(imgHotkey6.getLayoutX());
			imgHotkey7.setLayoutY(imgHotkey6.getLayoutY()+35);

			imgHotkey8.setLayoutX(imgHotkey7.getLayoutX());
			imgHotkey8.setLayoutY(imgHotkey7.getLayoutY()+35);

			imgHotkey9.setLayoutX(imgHotkey8.getLayoutX());
			imgHotkey9.setLayoutY(imgHotkey8.getLayoutY()+35);

			imgHotkey10.setLayoutX(imgHotkey9.getLayoutX());
			imgHotkey10.setLayoutY(imgHotkey9.getLayoutY()+35);

			imgHotkey11.setLayoutX(imgHotkey10.getLayoutX());
			imgHotkey11.setLayoutY(imgHotkey10.getLayoutY()+35);

			imgHotkey12.setLayoutX(imgPopUp.getLayoutX()+357);
			imgHotkey12.setLayoutY(imgHotkey1.getLayoutY());

			imgHotkey13.setLayoutX(imgPopUp.getLayoutX()+357);
			imgHotkey13.setLayoutY(imgHotkey2.getLayoutY());

			imgHotkey14.setLayoutX(imgPopUp.getLayoutX()+357);
			imgHotkey14.setLayoutY(imgHotkey3.getLayoutY());

			imgHotkey15.setLayoutX(imgPopUp.getLayoutX()+357);
			imgHotkey15.setLayoutY(imgHotkey4.getLayoutY());

			imgHotkey16.setLayoutX(imgPopUp.getLayoutX()+357);
			imgHotkey16.setLayoutY(imgHotkey5.getLayoutY());

			hotkeyName1.setLayoutX(imgHotkey1.getLayoutX());
			hotkeyName1.setLayoutY(imgHotkey1.getLayoutY());

			hotkeyName2.setLayoutX(imgHotkey2.getLayoutX());
			hotkeyName2.setLayoutY(imgHotkey2.getLayoutY());

			hotkeyName3.setLayoutX(imgHotkey3.getLayoutX());
			hotkeyName3.setLayoutY(imgHotkey3.getLayoutY());

			hotkeyName4.setLayoutX(imgHotkey4.getLayoutX());
			hotkeyName4.setLayoutY(imgHotkey4.getLayoutY());

			hotkeyName5.setLayoutX(imgHotkey5.getLayoutX());
			hotkeyName5.setLayoutY(imgHotkey5.getLayoutY());

			hotkeyName6.setLayoutX(imgHotkey6.getLayoutX());
			hotkeyName6.setLayoutY(imgHotkey6.getLayoutY());

			hotkeyName7.setLayoutX(imgHotkey7.getLayoutX());
			hotkeyName7.setLayoutY(imgHotkey7.getLayoutY());

			hotkeyName8.setLayoutX(imgHotkey8.getLayoutX());
			hotkeyName8.setLayoutY(imgHotkey8.getLayoutY());

			hotkeyName9.setLayoutX(imgHotkey9.getLayoutX());
			hotkeyName9.setLayoutY(imgHotkey9.getLayoutY());

			hotkeyName10.setLayoutX(imgHotkey10.getLayoutX());
			hotkeyName10.setLayoutY(imgHotkey10.getLayoutY());

			hotkeyName11.setLayoutX(imgHotkey11.getLayoutX());
			hotkeyName11.setLayoutY(imgHotkey11.getLayoutY());

			hotkeyName12.setLayoutX(imgHotkey12.getLayoutX());
			hotkeyName12.setLayoutY(imgHotkey12.getLayoutY());

			hotkeyName13.setLayoutX(imgHotkey13.getLayoutX());
			hotkeyName13.setLayoutY(imgHotkey13.getLayoutY());

			hotkeyName14.setLayoutX(imgHotkey14.getLayoutX());
			hotkeyName14.setLayoutY(imgHotkey14.getLayoutY());

			hotkeyName15.setLayoutX(imgHotkey15.getLayoutX());
			hotkeyName15.setLayoutY(imgHotkey15.getLayoutY());

			hotkeyName16.setLayoutX(imgHotkey16.getLayoutX());
			hotkeyName16.setLayoutY(imgHotkey16.getLayoutY());

			hotkeyAction1.setLayoutX(hotkeyName1.getLayoutX()+72);
			hotkeyAction1.setLayoutY(hotkeyName1.getLayoutY());

			hotkeyAction2.setLayoutX(hotkeyName2.getLayoutX()+72);
			hotkeyAction2.setLayoutY(hotkeyName2.getLayoutY());

			hotkeyAction3.setLayoutX(hotkeyName3.getLayoutX()+72);
			hotkeyAction3.setLayoutY(hotkeyName3.getLayoutY());

			hotkeyAction4.setLayoutX(hotkeyName4.getLayoutX()+72);
			hotkeyAction4.setLayoutY(hotkeyName4.getLayoutY());

			hotkeyAction5.setLayoutX(hotkeyName5.getLayoutX()+72);
			hotkeyAction5.setLayoutY(hotkeyName5.getLayoutY());

			hotkeyAction6.setLayoutX(hotkeyName6.getLayoutX()+72);
			hotkeyAction6.setLayoutY(hotkeyName6.getLayoutY());

			hotkeyAction7.setLayoutX(hotkeyName7.getLayoutX()+72);
			hotkeyAction7.setLayoutY(hotkeyName7.getLayoutY());

			hotkeyAction8.setLayoutX(hotkeyName8.getLayoutX()+72);
			hotkeyAction8.setLayoutY(hotkeyName8.getLayoutY());

			hotkeyAction9.setLayoutX(hotkeyName9.getLayoutX()+72);
			hotkeyAction9.setLayoutY(hotkeyName9.getLayoutY());

			hotkeyAction10.setLayoutX(hotkeyName10.getLayoutX()+72);
			hotkeyAction10.setLayoutY(hotkeyName10.getLayoutY());

			hotkeyAction11.setLayoutX(hotkeyName11.getLayoutX()+72);
			hotkeyAction11.setLayoutY(hotkeyName11.getLayoutY());

			hotkeyAction12.setLayoutX(hotkeyName12.getLayoutX()+72);
			hotkeyAction12.setLayoutY(hotkeyName12.getLayoutY());

			hotkeyAction13.setLayoutX(hotkeyName13.getLayoutX()+72);
			hotkeyAction13.setLayoutY(hotkeyName13.getLayoutY());

			hotkeyAction14.setLayoutX(hotkeyName14.getLayoutX()+72);
			hotkeyAction14.setLayoutY(hotkeyName14.getLayoutY());

			hotkeyAction15.setLayoutX(hotkeyName15.getLayoutX()+72);
			hotkeyAction15.setLayoutY(hotkeyName15.getLayoutY());

			hotkeyAction16.setLayoutX(hotkeyName16.getLayoutX()+72);
			hotkeyAction16.setLayoutY(hotkeyName16.getLayoutY());

			storageTitle1.setLayoutX(imgPopUp.getLayoutX()+15);
			storageTitle1.setLayoutY(imgPopUp.getLayoutY()+82);

			storageTitle2.setLayoutX(storageTitle1.getLayoutX()+335);
			storageTitle2.setLayoutY(storageTitle1.getLayoutY());

			imgResource1.setLayoutX(storageTitle1.getLayoutX());
			imgResource1.setLayoutY(storageTitle1.getLayoutY()+51);

			imgResource2.setLayoutX(imgResource1.getLayoutX());
			imgResource2.setLayoutY(imgResource1.getLayoutY()+42);

			imgResource3.setLayoutX(imgResource2.getLayoutX());
			imgResource3.setLayoutY(imgResource2.getLayoutY()+42);

			imgResource4.setLayoutX(imgResource3.getLayoutX());
			imgResource4.setLayoutY(imgResource3.getLayoutY()+42);

			imgResource5.setLayoutX(imgResource4.getLayoutX());
			imgResource5.setLayoutY(imgResource4.getLayoutY()+42);

			imgResource6.setLayoutX(imgResource5.getLayoutX());
			imgResource6.setLayoutY(imgResource5.getLayoutY()+42);

			imgResource7.setLayoutX(imgResource6.getLayoutX());
			imgResource7.setLayoutY(imgResource6.getLayoutY()+42);

			imgResource8.setLayoutX(imgResource7.getLayoutX());
			imgResource8.setLayoutY(imgResource7.getLayoutY()+42);

			storageResource1.setLayoutX(imgResource1.getLayoutX()+40);
			storageResource1.setLayoutY(imgResource1.getLayoutY());

			storageResource2.setLayoutX(imgResource2.getLayoutX()+40);
			storageResource2.setLayoutY(imgResource2.getLayoutY());

			storageResource3.setLayoutX(imgResource3.getLayoutX()+40);
			storageResource3.setLayoutY(imgResource3.getLayoutY());

			storageResource4.setLayoutX(imgResource4.getLayoutX()+40);
			storageResource4.setLayoutY(imgResource4.getLayoutY());

			storageResource5.setLayoutX(imgResource5.getLayoutX()+40);
			storageResource5.setLayoutY(imgResource5.getLayoutY());

			storageResource6.setLayoutX(imgResource6.getLayoutX()+40);
			storageResource6.setLayoutY(imgResource6.getLayoutY());

			storageResource7.setLayoutX(imgResource7.getLayoutX()+40);
			storageResource7.setLayoutY(imgResource7.getLayoutY());

			storageResource8.setLayoutX(imgResource8.getLayoutX()+40);
			storageResource8.setLayoutY(imgResource8.getLayoutY());

			storageWorker1.setLayoutX(storageResource1.getLayoutX()+295);
			storageWorker1.setLayoutY(storageResource1.getLayoutY());

			storageWorker2.setLayoutX(storageResource2.getLayoutX()+295);
			storageWorker2.setLayoutY(storageResource2.getLayoutY());

			storageWorker3.setLayoutX(storageResource3.getLayoutX()+295);
			storageWorker3.setLayoutY(storageResource3.getLayoutY());

			storageWorker4.setLayoutX(storageResource4.getLayoutX()+295);
			storageWorker4.setLayoutY(storageResource4.getLayoutY());

			storageWorker5.setLayoutX(storageResource5.getLayoutX()+295);
			storageWorker5.setLayoutY(storageResource5.getLayoutY());

			storageWorker6.setLayoutX(storageResource6.getLayoutX()+295);
			storageWorker6.setLayoutY(storageResource6.getLayoutY());

			storageWorker7.setLayoutX(storageResource7.getLayoutX()+295);
			storageWorker7.setLayoutY(storageResource7.getLayoutY());

			storageWorker8.setLayoutX(storageResource8.getLayoutX()+295);
			storageWorker8.setLayoutY(storageResource8.getLayoutY());
			
			imgWorker1.setLayoutX(storageWorker1.getLayoutX()+303);
			imgWorker1.setLayoutY(storageWorker1.getLayoutY());
			
			imgWorker2.setLayoutX(storageWorker2.getLayoutX()+303);
			imgWorker2.setLayoutY(storageWorker2.getLayoutY());
			
			imgWorker3.setLayoutX(storageWorker3.getLayoutX()+303);
			imgWorker3.setLayoutY(storageWorker3.getLayoutY());
			
			imgWorker4.setLayoutX(storageWorker4.getLayoutX()+303);
			imgWorker4.setLayoutY(storageWorker4.getLayoutY());
			
			imgWorker5.setLayoutX(storageWorker5.getLayoutX()+303);
			imgWorker5.setLayoutY(storageWorker5.getLayoutY());
			
			imgWorker6.setLayoutX(storageWorker6.getLayoutX()+303);
			imgWorker6.setLayoutY(storageWorker6.getLayoutY());
			
			imgWorker7.setLayoutX(storageWorker7.getLayoutX()+303);
			imgWorker7.setLayoutY(storageWorker7.getLayoutY());
			
			imgWorker8.setLayoutX(storageWorker8.getLayoutX()+303);
			imgWorker8.setLayoutY(storageWorker8.getLayoutY());

			medalAchievement1.setLayoutX(imgPopUp.getLayoutX()+335);
			medalAchievement1.setLayoutY(imgPopUp.getLayoutY()+44);

			lblAchievement1.setLayoutX(imgPopUp.getLayoutX());
			lblAchievement1.setLayoutY(medalAchievement1.getLayoutY()+33);

			achievementDesc1.setLayoutX(imgPopUp.getLayoutX());
			achievementDesc1.setLayoutY(lblAchievement1.getLayoutY()+35);

			medalAchievement2.setLayoutX(medalAchievement1.getLayoutX());
			medalAchievement2.setLayoutY(achievementDesc1.getLayoutY()+80);

			lblAchievement2.setLayoutX(imgPopUp.getLayoutX());
			lblAchievement2.setLayoutY(medalAchievement2.getLayoutY()+33);
			
			achievementDesc2.setLayoutX(imgPopUp.getLayoutX());
			achievementDesc2.setLayoutY(lblAchievement2.getLayoutY()+35);

			medalAchievement3.setLayoutX(medalAchievement2.getLayoutX());
			medalAchievement3.setLayoutY(achievementDesc2.getLayoutY()+80);

			lblAchievement3.setLayoutX(imgPopUp.getLayoutX());
			lblAchievement3.setLayoutY(medalAchievement3.getLayoutY()+33);
			
			achievementDesc3.setLayoutX(imgPopUp.getLayoutX());
			achievementDesc3.setLayoutY(lblAchievement3.getLayoutY()+35);

			lblCompetitorCompany.setLayoutX(imgPopUp.getLayoutX());
			lblCompetitorCompany.setLayoutY(imgPopUp.getLayoutY()+105);

			imgCompetitorResource.setLayoutX(imgPopUp.getLayoutX()+318);
			imgCompetitorResource.setLayoutY(lblCompetitorCompany.getLayoutY()+115);

			lblCompetitorName.setLayoutX(imgPopUp.getLayoutX());
			lblCompetitorName.setLayoutY(imgCompetitorResource.getLayoutY()+75);

			lblCompetitorPrice.setLayoutX(imgPopUp.getLayoutX());
			lblCompetitorPrice.setLayoutY(lblCompetitorName.getLayoutY()+35);

			lblCompetitorAmount.setLayoutX(imgPopUp.getLayoutX());
			lblCompetitorAmount.setLayoutY(lblCompetitorPrice.getLayoutY()+75);

			logoutButton.setLayoutX(imgPopUp.getLayoutX()+607);
			logoutButton.setLayoutY(imgPopUp.getLayoutY()+454);

			lblLogout.setLayoutX(logoutButton.getLayoutX());
			lblLogout.setLayoutY(logoutButton.getLayoutY());

			tutorialButton.setLayoutX(imgPopUp.getLayoutX()+13);
			tutorialButton.setLayoutY(imgPopUp.getLayoutY()+455);

			tutorialIcon.setLayoutX(tutorialButton.getLayoutX());
			tutorialIcon.setLayoutY(tutorialButton.getLayoutY());

			changelogButton.setLayoutX(tutorialIcon.getLayoutX()+37);
			changelogButton.setLayoutY(tutorialIcon.getLayoutY());

			changelogIcon.setLayoutX(changelogButton.getLayoutX());
			changelogIcon.setLayoutY(changelogButton.getLayoutY());

			consoleButton.setLayoutX(changelogIcon.getLayoutX()+37);
			consoleButton.setLayoutY(changelogIcon.getLayoutY());

			consoleIcon.setLayoutX(consoleButton.getLayoutX());
			consoleIcon.setLayoutY(consoleButton.getLayoutY());

			musicButton.setLayoutX(consoleIcon.getLayoutX()+37);
			musicButton.setLayoutY(consoleIcon.getLayoutY());

			keyButton.setLayoutX(imgPopUp.getLayoutX()+318);
			keyButton.setLayoutY(tutorialIcon.getLayoutY());

			keyIcon.setLayoutX(keyButton.getLayoutX());
			keyIcon.setLayoutY(keyButton.getLayoutY());

			creditButton.setLayoutX(keyIcon.getLayoutX()+37);
			creditButton.setLayoutY(keyIcon.getLayoutY());

			creditIcon.setLayoutX(creditButton.getLayoutX());
			creditIcon.setLayoutY(creditButton.getLayoutY());

			lblVersion.setLayoutX(width/2-150);
			lblVersion.setLayoutY(height-27);

			itemAmount.setLayoutX(width/2-225);
			itemAmount.setLayoutY(lblVersion.getLayoutY()-35);

			itemImage.setLayoutX(width/2-16);
			itemImage.setLayoutY(itemAmount.getLayoutY()-42);
			
			bBottom.setLayoutX(width/2-32);
			
			bMiddle.setLayoutX(width/2-32);
			bMiddle.setLayoutY(bBottom.getLayoutY()-bMiddle.getFitHeight());
			
			bTop.setLayoutX(width/2-32);
			bTop.setLayoutY(bMiddle.getLayoutY()-25);
			
			itemName.setLayoutX(width/2-400);
			itemName.setLayoutY(bBottom.getLayoutY()+20);
			
			key1.setLayoutX(8);
			key1.setLayoutY(itemName.getLayoutY());
			
			key2.setLayoutX(8);
			key2.setLayoutY(key1.getLayoutY()+34);
			
			key3.setLayoutX(8);
			key3.setLayoutY(key2.getLayoutY()+34);
			
			key4.setLayoutX(8);
			key4.setLayoutY(key3.getLayoutY()+34);
			
			keyName1.setLayoutX(8);
			keyName1.setLayoutY(key1.getLayoutY());
			
			keyName2.setLayoutX(8);
			keyName2.setLayoutY(key2.getLayoutY());
			
			keyName3.setLayoutX(8);
			keyName3.setLayoutY(key3.getLayoutY());
			
			keyName4.setLayoutX(8);
			keyName4.setLayoutY(key4.getLayoutY());

			lblAmountChange1.setLayoutX(73);
			lblAmountChange1.setLayoutY(keyName1.getLayoutY()+1);

			lblAmountChange2.setLayoutX(73);
			lblAmountChange2.setLayoutY(keyName2.getLayoutY()+1);

			lblAmountChange3.setLayoutX(73);
			lblAmountChange3.setLayoutY(keyName3.getLayoutY()+1);

			lblAmountChange4.setLayoutX(73);
			lblAmountChange4.setLayoutY(keyName4.getLayoutY()+1);
			
			keyImage1.setLayoutX(83);
			keyImage1.setLayoutY(lblAmountChange1.getLayoutY()-3);
			
			keyImage2.setLayoutX(83);
			keyImage2.setLayoutY(lblAmountChange2.getLayoutY()-3);
			
			keyImage3.setLayoutX(83);
			keyImage3.setLayoutY(lblAmountChange3.getLayoutY()-3);
			
			keyImage4.setLayoutX(83);
			keyImage4.setLayoutY(lblAmountChange4.getLayoutY()-3);

			workerName1.setLayoutX(123);
			workerName1.setLayoutY(keyImage1.getLayoutY()+5);

			workerName2.setLayoutX(123);
			workerName2.setLayoutY(keyImage2.getLayoutY()+5);

			workerName3.setLayoutX(123);
			workerName3.setLayoutY(keyImage3.getLayoutY()+5);

			workerName4.setLayoutX(123);
			workerName4.setLayoutY(keyImage4.getLayoutY()+5);

			costImage1.setLayoutX(width-37);
			costImage1.setLayoutY(itemName.getLayoutY()-5);

			costImage2.setLayoutX(width-37);
			costImage2.setLayoutY(costImage1.getLayoutY()+33);

			costImage3.setLayoutX(width-37);
			costImage3.setLayoutY(costImage2.getLayoutY()+33);
			
			lblCost1.setLayoutX(width-300);
			lblCost1.setLayoutY(costImage1.getLayoutY()+8);
			
			lblCost2.setLayoutX(width-300);
			lblCost2.setLayoutY(costImage2.getLayoutY()+8);
			
			lblCost3.setLayoutX(width-300);
			lblCost3.setLayoutY(costImage3.getLayoutY()+8);

			lblRank.setLayoutX(5);
			lblRank.setLayoutY(5);

			imgRank.setLayoutX(80);
			imgRank.setLayoutY(4);
			
			imgRank.setImage(new Image("img/ranks/rank"+rank+".png"));

			lblMoney.setLayoutX(5);
			lblMoney.setLayoutY(lblRank.getLayoutY()+45);

			lblMultiplier.setLayoutX(5);
			lblMultiplier.setLayoutY(lblMoney.getLayoutY()+45);

			lblItem1.setLayoutX(width-368);
			lblItem1.setLayoutY(5);

			lblItem2.setLayoutX(width-368);
			lblItem2.setLayoutY(lblItem1.getLayoutY()+45);

			lblItem3.setLayoutX(width-368);
			lblItem3.setLayoutY(lblItem2.getLayoutY()+45);

			lblPrice.setLayoutX(width-368);
			lblPrice.setLayoutY(bBottom.getLayoutY()-34);

			refreshTime.setLayoutX(5);
			refreshTime.setLayoutY(lblPrice.getLayoutY()+15);

			optionsButton.setLayoutX(width-37);
			optionsButton.setLayoutY(height-37);
			
			optionsIcon.setLayoutX(width-37);
			optionsIcon.setLayoutY(height-37);

			storageButton.setLayoutX(optionsButton.getLayoutX()-37);
			storageButton.setLayoutY(optionsButton.getLayoutY());
			
			storageIcon.setLayoutX(optionsIcon.getLayoutX()-37);
			storageIcon.setLayoutY(optionsIcon.getLayoutY());

			achievementButton.setLayoutX(storageButton.getLayoutX()-37);
			achievementButton.setLayoutY(storageButton.getLayoutY());
			
			achievementIcon.setLayoutX(storageIcon.getLayoutX()-37);
			achievementIcon.setLayoutY(storageIcon.getLayoutY());

			competitorButton.setLayoutX(achievementButton.getLayoutX()-37);
			competitorButton.setLayoutY(achievementButton.getLayoutY());
			
			competitorIcon.setLayoutX(achievementIcon.getLayoutX()-37);
			competitorIcon.setLayoutY(achievementIcon.getLayoutY());

			if (!new SimpleDateFormat("MM/dd/yyyy").format(new Date()).equals(currentDate)) {
				lblChangelog.setVisible(false);
				dailyReward();
			}
				
			backgroundThread = new Service<Void>() {
				
				@Override
				protected Task<Void> createTask() {
					return new Task<Void>() {
						
						@Override
						protected Void call() throws Exception {
							return null;
						}
					};
				}
			};
			
			backgroundThread.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
				
				@Override
				public void handle(WorkerStateEvent event) {
					save();
					resourceCheck();
					if (!log) backgroundThread.restart();
				}
			});
			backgroundThread.restart();
		} catch (Exception e) {}
	}
}