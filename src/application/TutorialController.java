package application;

import java.io.*;
import java.util.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.stage.*;

public class TutorialController {
	
	private BufferedReader br;
	
	private PrintWriter pw;

	private String username;
	
	private double statusY;
	
	private boolean pageUpPressed = false;
	private boolean pageDownPressed = false;
	
	private double money;
	private long rank;

	private double food;
	private long rancher;

	private double fish;
	private long fisher;
	private long fishMerchant;

	private double crop;
	private long cottonFarmer;
	private long cottonMerchant;
	
	private long tSection = 1;
	
	@FXML private ImageView imgCompetitorResource;
	
	@FXML private Label lblCompetitorCompany;
	@FXML private Label lblCompetitorName;
	@FXML private Label lblCompetitorAmount;
	@FXML private Label lblCompetitorPrice;

	@FXML private ImageView storageBackground;
	@FXML private ImageView imgResource;
	
	@FXML private Label storageLabel;

	@FXML private Label lblPrice;
	
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
	
	@FXML private Label lblStatus;
	
	private KeyCode buyKey1;
	private KeyCode buyKey2;
	private KeyCode sellKey1;
	private KeyCode sellKey2;
	private KeyCode goToNext;
	private KeyCode goToPrev;
	private KeyCode goToFirst;
	private KeyCode goToLast;
	private KeyCode openStorage;
	private KeyCode openCompetitor;
	private KeyCode increasePrice;
	private KeyCode decreasePrice;

	private boolean firstCheck = true;

	private double fishPrice;
	private double cottonPrice;

	
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
		} else {
			return KeyCode.getKeyCode(key);
		}
	}
	
	public void mouseAction(MouseEvent m) {
		if (firstCheck) {
			statusY = lblStatus.getLayoutY();
			try {
				br = new BufferedReader(new FileReader("stats/currentUser.stat"));
				username = new TextEncryptor(br.readLine()).encrypt(2);
				br.close();
				
				br = new BufferedReader(new FileReader("stats/"+username+"/Stats.stat"));
				rank = Long.parseLong(new TextEncryptor(br.readLine()).decrypt());
				br.close();
				
				br = new BufferedReader(new FileReader("stats/"+username+"/Prices.stat"));
				fishPrice = Double.parseDouble(new TextEncryptor(br.readLine()).decrypt());
				br.readLine();
				br.readLine();
				cottonPrice = Double.parseDouble(new TextEncryptor(br.readLine()).decrypt());
				br.close();
				
				br = new BufferedReader(new FileReader("stats/"+username+"/Keys.stat"));
				buyKey1 = keyCode(new TextEncryptor(br.readLine()).decrypt());
				buyKey2 = keyCode(new TextEncryptor(br.readLine()).decrypt());
				sellKey1 = keyCode(new TextEncryptor(br.readLine()).decrypt());
				sellKey2 = keyCode(new TextEncryptor(br.readLine()).decrypt());
				goToNext = keyCode(new TextEncryptor(br.readLine()).decrypt());
				goToPrev = keyCode(new TextEncryptor(br.readLine()).decrypt());
				goToFirst = keyCode(new TextEncryptor(br.readLine()).decrypt());
				goToLast = keyCode(new TextEncryptor(br.readLine()).decrypt());
				openStorage = keyCode(new TextEncryptor(br.readLine()).decrypt());
				br.readLine();
				openCompetitor = keyCode(new TextEncryptor(br.readLine()).decrypt());
				br.readLine();
				increasePrice = keyCode(new TextEncryptor(br.readLine()).decrypt());
				decreasePrice = keyCode(new TextEncryptor(br.readLine()).decrypt());
				br.close();
			} catch (Exception e) {}
			keyName1.setText(buyKey1.toString());
			keyName2.setText(sellKey1.toString());
			keyName3.setText(buyKey2.toString());
			keyName4.setText(sellKey2.toString());
			lblPrice.setText("Price: M$"+fishPrice+"0");
			keyImage3.setImage(new Image("img/workers/merchant.png"));
			keyImage4.setImage(new Image("img/workers/merchant.png"));
			lblRank.setText("Rank: "+rank);
			lblMoney.setText("Moneyz: M$0.00");
			lblItem1.setText("Ranchers: 0");
			itemAmount.setText("0");
			firstCheck = false;
		}
	}
	
	public void mousePressed(MouseEvent m) {
		if (tSection == 1 && m.getButton() == MouseButton.PRIMARY) {
			food++;
			bTop.setLayoutY(bTop.getLayoutY()-1);
			bMiddle.setLayoutY(bMiddle.getLayoutY()-1);
			bMiddle.setFitHeight(bMiddle.getFitHeight()+1);
			itemAmount.setText(Long.toString((long)food));
			if (food == 20) {
				lblStatus.setText("Good! Now press ["+goToNext.toString()+"] to go to the next page.");
				tSection = 2;
			} else {
				if (food != 19) {
					lblStatus.setText("Welcome to Company Simulator! To begin, left-click "+(20-(long)food)+" more times to get 20 Food.");
				} else lblStatus.setText("Welcome to Company Simulator! To begin, left-click 1 more time to get 20 Food.");
			}
		} else if (tSection == 3 && m.getButton() == MouseButton.PRIMARY) {
			fish++;
			food -= 2;
			bTop.setLayoutY(bTop.getLayoutY()-1);
			bMiddle.setLayoutY(bMiddle.getLayoutY()-1);
			bMiddle.setFitHeight(bMiddle.getFitHeight()+1);
			itemAmount.setText(Long.toString((long)fish));
			lblItem1.setText("Food: "+(long)food);
			if (fish == 5) {
				lblStatus.setText("Right-click 5 more times to sell the fish you have just made.");
				tSection = 4;
			} else {
				if (fish != 4) {
					lblStatus.setText("Left-click "+(5-(long)fish)+" more times to get 5 Fish.\n(1 Fish = 2 Food)");
				} else lblStatus.setText("Left-click 1 more time to get 5 Fish.\n(1 Fish = 2 Food)");
			}
		} else if (tSection == 4 && m.getButton() == MouseButton.SECONDARY) {
			money++;
			fish--;
			bTop.setLayoutY(bTop.getLayoutY()+1);
			bMiddle.setLayoutY(bMiddle.getLayoutY()+1);
			bMiddle.setFitHeight(bMiddle.getFitHeight()-1);
			itemAmount.setText(Long.toString((long)fish));
			lblMoney.setText("Moneyz: M$"+(long)money+".00");
			if (money == 5) {
				lblStatus.setText("Press ["+goToPrev.toString()+"] to go back to the Food page.");
				tSection = 5;
			} else {
				if (money != 4) {
					lblStatus.setText("Right-click "+(5-(long)money)+" more times to sell the fish you have just made.");
				} else lblStatus.setText("Right-click 1 more time to sell the fish\n you have just made.");
			}
		} else if (tSection == 7 && m.getButton() == MouseButton.PRIMARY) {
			food++;
			bTop.setLayoutY(bTop.getLayoutY()-1);
			bMiddle.setLayoutY(bMiddle.getLayoutY()-1);
			bMiddle.setFitHeight(bMiddle.getFitHeight()+1);
			itemAmount.setText(Long.toString((long)food));
			if (food == 30) {
				lblStatus.setText("Press ["+goToNext.toString()+"] to go to the Fish page.");
				tSection = 8;
			} else {
				if (food != 29) {
					lblStatus.setText("Left-click "+(30-(long)food)+" more times to get 30 Food.");
				} else lblStatus.setText("Left-click 1 more time to get 30 Food.");
			}
		} else if (tSection == 9 && m.getButton() == MouseButton.PRIMARY) {
			fish++;
			food -= 2;
			bTop.setLayoutY(bTop.getLayoutY()-1);
			bMiddle.setLayoutY(bMiddle.getLayoutY()-1);
			bMiddle.setFitHeight(bMiddle.getFitHeight()+1);
			itemAmount.setText(Long.toString((long)fish));
			lblItem1.setText("Food: "+(long)food);
			if (fish == 15) {
				lblStatus.setText("Right-click 5 more times to sell some Fish.");
				tSection = 10;
			} else {
				if (fish != 14) {
					lblStatus.setText("Left-click "+(15-(long)fish)+" more times to get 15 Fish.");
				} else lblStatus.setText("Left-click 1 more time to get 15 Fish.");
			}
		} else if (tSection == 10 && m.getButton() == MouseButton.SECONDARY) {
			money++;
			fish--;
			bTop.setLayoutY(bTop.getLayoutY()+1);
			bMiddle.setLayoutY(bMiddle.getLayoutY()+1);
			bMiddle.setFitHeight(bMiddle.getFitHeight()-1);
			itemAmount.setText(Long.toString((long)fish));
			lblMoney.setText("Moneyz: M$"+(long)money+".00");
			if (money == 5) {
				lblStatus.setText("Press ["+buyKey1.toString()+"] to buy a Fisher.\n(1 Fisher = 10 Fish | M$5.00)\n(Produces 1 Fish/5 Seconds)\n(Spends 2 Food/5 Seconds)");
				tSection = 11;
			} else {
				if (money != 4) {
					lblStatus.setText("Right-click "+(5-(long)money)+" more times to sell some Fish.");
				} else lblStatus.setText("Right-click 1 more time to sell some Fish.");
			}
		} else if (tSection == 15 && m.getButton() == MouseButton.PRIMARY && imgResource.isHover()) {
			imgResource.setVisible(false);
			storageBackground.setVisible(false);
			storageLabel.setVisible(false);
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
			lblPrice.setVisible(true);
			lblCost1.setVisible(true);
			lblCost2.setVisible(true);
			lblCost3.setVisible(true);
			costImage1.setVisible(true);
			costImage2.setVisible(true);
			costImage3.setVisible(true);
			
			itemName.setText("FISH");
			itemImage.setImage(new Image("img/resources/food/fish.png"));
			itemAmount.setText(Long.toString((long)fish));

			keyImage1.setImage(new Image("img/workers/fisher.png"));
			keyImage2.setImage(new Image("img/workers/fisher.png"));

			workerName1.setText("Fisher");
			workerName2.setText("Fisher");
			workerName3.setText("Fish Merchant");
			workerName4.setText("Fish Merchant");

			lblPrice.setText("Price: M$"+fishPrice+"0");
			lblItem1.setText("Food: "+(long)food);
			lblItem2.setText("Fishers: "+fisher);
			lblItem3.setText("Fish Merchants: "+fishMerchant);
			lblCost1.setText("Cost: 2 Food");
			lblCost2.setText("Cost: 10 Fish | M$5.00");
			lblCost3.setText("Cost: 5 Fish | M$10.00");
			costImage1.setImage(new Image("img/resources/food/fish.png"));
			costImage2.setImage(new Image("img/workers/fisher.png"));
			costImage3.setImage(new Image("img/workers/merchant.png"));
			lblStatus.setLayoutY(statusY);
			lblStatus.setText("Press ["+goToPrev.toString()+"] to go back to the Food page.");
			tSection = 16;
		} else if (tSection == 17 && m.getButton() == MouseButton.PRIMARY) {
			food++;
			bTop.setLayoutY(bTop.getLayoutY()-1);
			bMiddle.setLayoutY(bMiddle.getLayoutY()-1);
			bMiddle.setFitHeight(bMiddle.getFitHeight()+1);
			itemAmount.setText(Long.toString((long)food));
			if (food == 30) {
				lblStatus.setText("Press ["+goToNext.toString()+"] to go to the Fish page.");
				tSection = 18;
			} else {
				if (food != 29) {
					lblStatus.setText("Left-click "+(30-(long)food)+" more times to get 30 Food.");
				} else lblStatus.setText("Left-click 1 more time to get 30 Food.");
			}
		} else if (tSection == 19 && m.getButton() == MouseButton.PRIMARY) {
			fish++;
			food -= 2;
			bTop.setLayoutY(bTop.getLayoutY()-1);
			bMiddle.setLayoutY(bMiddle.getLayoutY()-1);
			bMiddle.setFitHeight(bMiddle.getFitHeight()+1);
			itemAmount.setText(Long.toString((long)fish));
			lblItem1.setText("Food: "+(long)food);
			if (fish == 15) {
				lblStatus.setText("Right-click 10 more times to sell some\nFish.");
				tSection = 20;
			} else {
				if (fish != 14) {
					lblStatus.setText("Left-click "+(15-(long)fish)+" more times to get 15\nFish.");
				} else lblStatus.setText("Left-click 1 more time to get 15\nFish.");
			}
		} else if (tSection == 20 && m.getButton() == MouseButton.SECONDARY) {
			money++;
			fish--;
			bTop.setLayoutY(bTop.getLayoutY()+1);
			bMiddle.setLayoutY(bMiddle.getLayoutY()+1);
			bMiddle.setFitHeight(bMiddle.getFitHeight()-1);
			itemAmount.setText(Long.toString((long)fish));
			lblMoney.setText("Moneyz: M$"+(long)money+".00");
			if (money == 10) {
				lblStatus.setText("Press ["+buyKey2.toString()+"] to buy a Fish Merchant.\n(1 Fish Merchant = 5 Fish | M$10.00)\n(Produces M$1.00/5 Seconds)\n(Spends 1 Fish/5 Seconds)");
				tSection = 21;
			} else {
				if (money != 9) {
					lblStatus.setText("Right-click "+(10-(long)money)+" more times to sell some Fish.");
				} else lblStatus.setText("Right-click 1 more time to sell some Fish.");
			}
		}
	}
	
	public void keyPressed(KeyEvent key) {
		if (tSection == 2 && key.getCode() == goToNext && !pageUpPressed) {
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
			lblPrice.setVisible(true);
			lblCost1.setVisible(true);
			lblCost2.setVisible(true);
			lblCost3.setVisible(true);
			costImage1.setVisible(true);
			costImage2.setVisible(true);
			costImage3.setVisible(true);
			
			itemName.setText("FISH");
			itemImage.setImage(new Image("img/resources/food/fish.png"));
			itemAmount.setText(Long.toString((long)fish));
			
			bTop.setLayoutY(bTop.getLayoutY()+20);
			bMiddle.setLayoutY(bMiddle.getLayoutY()+20);
			bMiddle.setFitHeight(bMiddle.getFitHeight()-20);
			
			keyImage1.setImage(new Image("img/workers/fisher.png"));
			keyImage2.setImage(new Image("img/workers/fisher.png"));
			
			workerName1.setText("Fisher");
			workerName2.setText("Fisher");
			workerName3.setText("Fish Merchant");
			workerName4.setText("Fish Merchant");

			lblPrice.setText("Price: M$"+fishPrice+"0");
			lblItem1.setText("Food: "+(long)food);
			lblItem2.setText("Fishers: "+fisher);
			lblItem3.setText("Fish Merchants: "+fishMerchant);
			lblCost1.setText("Cost: 2 Food");
			lblCost2.setText("Cost: 10 Fish | M$5.00");
			lblCost3.setText("Cost: 5 Fish | M$10.00");
			costImage1.setImage(new Image("img/resources/food/fish.png"));
			costImage2.setImage(new Image("img/workers/fisher.png"));
			costImage3.setImage(new Image("img/workers/merchant.png"));
			tSection = 3;
			lblStatus.setText("Left-click 5 more times to get 5 Fish.\n(1 Fish = 2 Food)");
			pageUpPressed = true;
		} else if (tSection == 5 && key.getCode() == goToPrev && !pageDownPressed) {
			keyName1.setVisible(true);
			keyName2.setVisible(true);
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
			lblPrice.setVisible(false);
			lblCost1.setVisible(true);
			lblCost2.setVisible(false);
			lblCost3.setVisible(false);
			costImage1.setVisible(true);
			costImage2.setVisible(false);
			costImage3.setVisible(false);
			
			itemName.setText("FOOD");
			itemImage.setImage(new Image("img/resources/food/food.png"));
			itemAmount.setText("10");
			
			bTop.setLayoutY(bTop.getLayoutY()-10);
			bMiddle.setLayoutY(bMiddle.getLayoutY()-10);
			bMiddle.setFitHeight(bMiddle.getFitHeight()+10);
			
			keyImage1.setImage(new Image("img/workers/farmer.png"));
			keyImage2.setImage(new Image("img/workers/farmer.png"));
			
			workerName1.setText("Rancher");
			workerName2.setText("Rancher");
			
			lblItem1.setText("Ranchers: "+rancher);
			lblCost1.setText("Cost: 10 Food | M$5.00");
			costImage1.setImage(new Image("img/workers/farmer.png"));
			tSection = 6;
			lblStatus.setText("Press ["+buyKey1.toString()+"] to buy a Rancher.\n(1 Rancher = 10 Food | M$5.00)\n(Produces 1 Food/5 Seconds)");
			pageDownPressed = true;
		} else if (tSection == 6 && key.getCode() == buyKey1) {
			rancher++;
			food -= 10;
			money -= 5;
			lblMoney.setText("Moneyz: M$0.00");
			itemAmount.setText("0");
			bTop.setLayoutY(bTop.getLayoutY()+9);
			bMiddle.setLayoutY(bMiddle.getLayoutY()+9);
			bMiddle.setFitHeight(bMiddle.getFitHeight()-9);
			lblItem1.setText("Ranchers: "+rancher);
			lblStatus.setText("Left-click 30 more times to get 30 Food.");
			tSection = 7;
		} else if (tSection == 8 && key.getCode() == goToNext) {
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
			lblPrice.setVisible(true);
			lblCost1.setVisible(true);
			lblCost2.setVisible(true);
			lblCost3.setVisible(true);
			costImage1.setVisible(true);
			costImage2.setVisible(true);
			costImage3.setVisible(true);
			
			itemName.setText("FISH");
			itemImage.setImage(new Image("img/resources/food/fish.png"));
			itemAmount.setText(Long.toString((long)fish));
			
			bTop.setLayoutY(bTop.getLayoutY()+31);
			bMiddle.setLayoutY(bMiddle.getLayoutY()+31);
			bMiddle.setFitHeight(bMiddle.getFitHeight()-31);
			
			keyImage1.setImage(new Image("img/workers/fisher.png"));
			keyImage2.setImage(new Image("img/workers/fisher.png"));
			
			workerName1.setText("Fisher");
			workerName2.setText("Fisher");
			workerName3.setText("Fish Merchant");
			workerName4.setText("Fish Merchant");

			lblPrice.setText("Price: M$"+fishPrice+"0");
			lblItem1.setText("Food: "+(long)food);
			lblItem2.setText("Fishers: "+fisher);
			lblItem3.setText("Fish Merchants: "+fishMerchant);
			lblCost1.setText("Cost: 2 Food");
			lblCost2.setText("Cost: 10 Fish | M$5.00");
			costImage1.setImage(new Image("img/resources/food/fish.png"));
			costImage2.setImage(new Image("img/workers/fisher.png"));
			tSection = 9;
			lblStatus.setText("Left-click 15 more times to get 15 Fish.");
			pageUpPressed = true;
		} else if (tSection == 11 && key.getCode() == buyKey1) {
			fisher++;
			fish -= 10;
			money -= 5;
			lblMoney.setText("Moneyz: M$0.00");
			itemAmount.setText("0");
			bTop.setLayoutY(bTop.getLayoutY()+9);
			bMiddle.setLayoutY(bMiddle.getLayoutY()+9);
			bMiddle.setFitHeight(bMiddle.getFitHeight()-9);
			lblItem2.setText("Fishers: "+fisher);
			lblStatus.setText("Press ["+goToLast.toString()+"] to go the very last page.");
			tSection = 12;
		} else if (tSection == 12 && key.getCode() == goToLast) {
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
			lblPrice.setVisible(true);
			lblCost1.setVisible(true);
			lblCost2.setVisible(true);
			lblCost3.setVisible(true);
			costImage1.setVisible(true);
			costImage2.setVisible(true);
			costImage3.setVisible(true);
			
			itemName.setText("COTTON");
			itemImage.setImage(new Image("img/resources/crop/cotton.png"));
			itemAmount.setText("0");
			
			bTop.setLayoutY(bTop.getLayoutY()+1);
			bMiddle.setLayoutY(bMiddle.getLayoutY()+1);
			bMiddle.setFitHeight(bMiddle.getFitHeight()-1);
			
			keyImage1.setImage(new Image("img/workers/farmer.png"));
			keyImage2.setImage(new Image("img/workers/farmer.png"));
			
			workerName1.setText("Cotton Farmer");
			workerName2.setText("Cotton Farmer");
			workerName3.setText("Cotton Merchant");
			workerName4.setText("Cotton Merchant");

			lblPrice.setText("Price: M$"+cottonPrice+"0");
			lblItem1.setText("Crops: "+(long)crop);
			lblItem2.setText("Cotton Farmers: "+cottonFarmer);
			lblItem3.setText("Cotton Merchants: "+cottonMerchant);
			lblCost1.setText("Cost: 2 Crops");
			lblCost2.setText("Cost: 10 Cotton | M$5.00");
			lblCost3.setText("Cost: 5 Cotton | M$10.00");
			costImage1.setImage(new Image("img/resources/crop/cotton.png"));
			costImage2.setImage(new Image("img/workers/farmer.png"));
			costImage3.setImage(new Image("img/workers/merchant.png"));
			lblStatus.setText("Press ["+goToFirst.toString()+"] to go the very first page.");
			tSection = 13;
		} else if (tSection == 13 && key.getCode() == goToFirst) {
			keyName1.setVisible(true);
			keyName2.setVisible(true);
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
			lblPrice.setVisible(false);
			lblCost1.setVisible(true);
			lblCost2.setVisible(false);
			lblCost3.setVisible(false);
			costImage1.setVisible(true);
			costImage2.setVisible(false);
			costImage3.setVisible(false);
			
			itemName.setText("FOOD");
			itemImage.setImage(new Image("img/resources/food/food.png"));
			itemAmount.setText("0");
			
			bTop.setLayoutY(bTop.getLayoutY()-1);
			bMiddle.setLayoutY(bMiddle.getLayoutY()-1);
			bMiddle.setFitHeight(bMiddle.getFitHeight()+1);
			
			keyImage1.setImage(new Image("img/workers/farmer.png"));
			keyImage2.setImage(new Image("img/workers/farmer.png"));
			
			workerName1.setText("Rancher");
			workerName2.setText("Rancher");
			
			lblItem1.setText("Ranchers: "+rancher);
			lblCost1.setText("Cost: 10 Food | M$5.00");
			costImage1.setImage(new Image("img/workers/farmer.png"));
			lblStatus.setText("Press ["+openStorage.toString()+"] to open your Storage.");
			tSection = 14;
		} else if (tSection == 14 && key.getCode() == openStorage) {
			storageBackground.setVisible(true);
			storageLabel.setVisible(true);
			imgResource.setVisible(true);
			lblStatus.setLayoutY(storageBackground.getLayoutY()+20);
			lblStatus.setText("Press the Fish icon to the left of the text to go to its page.");
			tSection = 15;
		} else if (tSection == 16 && key.getCode() == goToPrev) {
			keyName1.setVisible(true);
			keyName2.setVisible(true);
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
			lblPrice.setVisible(false);
			lblCost1.setVisible(true);
			lblCost2.setVisible(false);
			lblCost3.setVisible(false);
			costImage1.setVisible(true);
			costImage2.setVisible(false);
			costImage3.setVisible(false);
			
			itemName.setText("FOOD");
			itemImage.setImage(new Image("img/resources/food/food.png"));
			itemAmount.setText("0");
			
			keyImage1.setImage(new Image("img/workers/farmer.png"));
			keyImage2.setImage(new Image("img/workers/farmer.png"));
			
			workerName1.setText("Rancher");
			workerName2.setText("Rancher");
			
			lblItem1.setText("Ranchers: "+rancher);
			lblCost1.setText("Cost: 10 Food | M$5.00");
			costImage1.setImage(new Image("img/workers/farmer.png"));
			tSection = 17;
			lblStatus.setText("Left-click 30 more times to get 30 Food.");
			pageDownPressed = true;
		} else if (tSection == 18 && key.getCode() == goToNext) {
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
			lblPrice.setVisible(true);
			lblCost1.setVisible(true);
			lblCost2.setVisible(true);
			lblCost3.setVisible(true);
			costImage1.setVisible(true);
			costImage2.setVisible(true);
			costImage3.setVisible(true);
			
			itemName.setText("FISH");
			itemImage.setImage(new Image("img/resources/food/fish.png"));
			itemAmount.setText(Long.toString((long)fish));
			
			bTop.setLayoutY(bTop.getLayoutY()+30);
			bMiddle.setLayoutY(bMiddle.getLayoutY()+30);
			bMiddle.setFitHeight(bMiddle.getFitHeight()-30);
			
			keyImage1.setImage(new Image("img/workers/fisher.png"));
			keyImage2.setImage(new Image("img/workers/fisher.png"));
			
			workerName1.setText("Fisher");
			workerName2.setText("Fisher");
			workerName3.setText("Fish Merchant");
			workerName4.setText("Fish Merchant");

			lblPrice.setText("Price: M$"+fishPrice+"0");
			lblItem1.setText("Food: "+(long)food);
			lblItem2.setText("Fishers: "+fisher);
			lblItem3.setText("Fish Merchants: "+fishMerchant);
			lblCost1.setText("Cost: 2 Food");
			lblCost2.setText("Cost: 10 Fish | M$5.00");
			costImage1.setImage(new Image("img/resources/food/fish.png"));
			costImage2.setImage(new Image("img/workers/fisher.png"));
			lblStatus.setText("Left-click 15 more times to get 15\nFish.");
			pageUpPressed = true;
			tSection = 19;
		} else if (tSection == 21 && key.getCode() == buyKey2) {
			fishMerchant++;
			fish -= 5;
			money -= 10;
			lblMoney.setText("Moneyz: M$0.00");
			itemAmount.setText("0");
			bTop.setLayoutY(bTop.getLayoutY()+4);
			bMiddle.setLayoutY(bMiddle.getLayoutY()+4);
			bMiddle.setFitHeight(bMiddle.getFitHeight()-4);
			lblItem3.setText("Fish Merchants: "+fishMerchant);
			lblStatus.setText("Press ["+openCompetitor.toString()+"] to check how your competitor is doing.");
			tSection = 22;
		} else if (tSection == 22 && key.getCode() == openCompetitor) {
			storageBackground.setVisible(true);
			imgCompetitorResource.setVisible(true);
			imgCompetitorResource.setImage(new Image("img/resources/food/fish.png"));
			lblCompetitorCompany.setVisible(true);
			lblCompetitorCompany.setText("Simulator Creator");
			lblCompetitorName.setVisible(true);
			lblCompetitorName.setText("Fish");
			lblCompetitorAmount.setVisible(true);
			lblCompetitorAmount.setText("1.7M");
			lblCompetitorPrice.setVisible(true);
			lblCompetitorPrice.setText("M$1.40");
			lblStatus.setLayoutY(storageBackground.getLayoutY()+20);
			lblStatus.setText("Competitors compete with you for customers, and therefore drop your Merchants' sell rates. Press [ESCAPE] to close the Competitor window.");
			tSection = 23;
		} else if (tSection == 23 && key.getCode() == KeyCode.ESCAPE) {
			storageBackground.setVisible(false);
			imgCompetitorResource.setVisible(false);
			lblCompetitorCompany.setVisible(false);
			lblCompetitorName.setVisible(false);
			lblCompetitorAmount.setVisible(false);
			lblCompetitorPrice.setVisible(false);
			lblStatus.setLayoutY(statusY);
			lblStatus.setText("You can change your resource price in order to increase/decrease your sale rates! Press ["+increasePrice.toString()+"] to increase your Fish\nprice.");
			tSection = 24;
		} else if (tSection == 24 && key.getCode() == increasePrice) {
			lblPrice.setText("Price: M$1.10");
			lblStatus.setText("Press ["+decreasePrice.toString()+"] to decrease your Fish\nprice.");
			tSection = 25;
		} else if (tSection == 25 && key.getCode() == decreasePrice) {
			lblPrice.setText("Price: M$1.00");
			lblStatus.setText("Congratulations! You have completed the tutorial! Press any key to continue...");
			tSection = 26;
		} else if (tSection == 26) {
			endTutorial();
		}
	}
	
	public void keyReleased(KeyEvent key) {
		if (tSection == 2 && key.getCode() == goToNext && pageUpPressed) {
			pageUpPressed = false;
		} else if (tSection == 5 && key.getCode() == goToPrev && pageDownPressed) {
			pageDownPressed = false;
		}
	}
	
	public void endTutorial() {
		try {
			if (rank == 0) {
				Long time = System.currentTimeMillis();
				pw = new PrintWriter("stats/"+username+"/Stats.stat");
				pw.println(new TextEncryptor("1").encrypt());//Rank
	            pw.println(new TextEncryptor("0").encrypt());//Moneyz Whole
	            pw.println(new TextEncryptor("0.0").encrypt());//Moneyz Decimal
	            pw.println(new TextEncryptor(Long.toString(time)).encrypt());//Starting Time
	            pw.close();
	
				pw = new PrintWriter("stats/"+username+"/Food.stat");
	            pw.println(new TextEncryptor("0").encrypt());//Food Whole
	            pw.println(new TextEncryptor("0.0").encrypt());//Food Decimal
	            pw.println(new TextEncryptor("0").encrypt());//Rancher
	            pw.println(new TextEncryptor("0").encrypt());//Fish Whole
	            pw.println(new TextEncryptor("0.0").encrypt());//Fish Decimal
	            pw.println(new TextEncryptor("0").encrypt());//Fisher
	            pw.println(new TextEncryptor("0").encrypt());//Fish Merchant
	            pw.println(new TextEncryptor("0").encrypt());//Steak Whole
	            pw.println(new TextEncryptor("0.0").encrypt());//Steak Decimal
	            pw.println(new TextEncryptor("0").encrypt());//Cow Rancher
	            pw.println(new TextEncryptor("0").encrypt());//Steak Merchant
	            pw.println(new TextEncryptor("0").encrypt());//Pork Whole
	            pw.println(new TextEncryptor("0.0").encrypt());//Pork Decimal
	            pw.println(new TextEncryptor("0").encrypt());//Pig Rancher
	            pw.println(new TextEncryptor("0").encrypt());//Pork Merchant
	            pw.println(new TextEncryptor("0").encrypt());//Chicken Whole
	            pw.println(new TextEncryptor("0.0").encrypt());//Chicken Decimal
	            pw.println(new TextEncryptor("0").encrypt());//Chicken Rancher
	            pw.println(new TextEncryptor("0").encrypt());//Chicken Merchant
	            pw.println(new TextEncryptor("0").encrypt());//Mutton Whole
	            pw.println(new TextEncryptor("0.0").encrypt());//Mutton Decimal
	            pw.println(new TextEncryptor("0").encrypt());//Sheep Rancher
	            pw.println(new TextEncryptor("0").encrypt());//Mutton Merchant
				pw.close();
	
				pw = new PrintWriter("stats/"+username+"/Stone.stat");
	            pw.println(new TextEncryptor("0").encrypt());//Stone Whole
	            pw.println(new TextEncryptor("0.0").encrypt());//Stone Decimal
	            pw.println(new TextEncryptor("0").encrypt());//Miner
	            pw.println(new TextEncryptor("0").encrypt());//Coal Whole
	            pw.println(new TextEncryptor("0.0").encrypt());//Coal Decimal
	            pw.println(new TextEncryptor("0").encrypt());//Coal Miner
	            pw.println(new TextEncryptor("0").encrypt());//Coal Merchant
				pw.close();
	
				pw = new PrintWriter("stats/"+username+"/Wood.stat");
	            pw.println(new TextEncryptor("0").encrypt());//Wood Whole
	            pw.println(new TextEncryptor("0.0").encrypt());//Wood Decimal
	            pw.println(new TextEncryptor("0").encrypt());//Lumberjack
	            pw.println(new TextEncryptor("0").encrypt());//Planks Whole
	            pw.println(new TextEncryptor("0.0").encrypt());//Planks Decimal
	            pw.println(new TextEncryptor("0").encrypt());//Wood Cutter
	            pw.println(new TextEncryptor("0").encrypt());//Planks Merchant
				pw.close();
	
				pw = new PrintWriter("stats/"+username+"/Crop.stat");
	            pw.println(new TextEncryptor("0").encrypt());//Crop Whole
	            pw.println(new TextEncryptor("0.0").encrypt());//Crop Decimal
	            pw.println(new TextEncryptor("0").encrypt());//Rancher
	            pw.println(new TextEncryptor("0").encrypt());//Cotton Whole
	            pw.println(new TextEncryptor("0.0").encrypt());//Cotton Decimal
	            pw.println(new TextEncryptor("0").encrypt());//Cotton Farmer
	            pw.println(new TextEncryptor("0").encrypt());//Cotton Merchant
				pw.close();
				
				pw = new PrintWriter("stats/"+username+"/Competitor.stat");
				Random rand = new Random();
				pw.println(new TextEncryptor(Long.toString(time)).encrypt());
				pw.println(new TextEncryptor("100").encrypt());
				pw.println(new TextEncryptor("0.0").encrypt());
				pw.println(new TextEncryptor(Double.toString((double)(rand.nextInt(20)+1)/10)).encrypt());
				double number = rand.nextInt(4);
				if (number == 0) pw.println(new TextEncryptor("Fish").encrypt());
				else if (number == 1) pw.println(new TextEncryptor("Coal").encrypt());
				else if (number == 2) pw.println(new TextEncryptor("Planks").encrypt());
				else pw.println(new TextEncryptor("Cotton").encrypt());
				number = rand.nextInt(3);
				if (number == 0) pw.println(new TextEncryptor("Moneyz Inc.").encrypt());
				else if (number == 1) pw.println(new TextEncryptor("Ge Co.").encrypt());
				else pw.println(new TextEncryptor("Simulator Creator").encrypt());
				pw.close();
			}
            
        	Stage stage1 = new Stage();
        	Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
			Scene scene = new Scene(root);
    		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		stage1.setScene(scene);
            stage1.setTitle("Company Simulator");
			stage1.getIcons().add(new Image("img/technical/companyIcon.png"));
			stage1.setFullScreen(true);
//			stage1.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
//			stage1.setFullScreenExitHint("");
            stage1.show();
            Stage stage = (Stage) lblStatus.getScene().getWindow();
            stage.close();
		} catch (Exception e) { e.printStackTrace(); }
	}
}