package application;

import java.io.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.stage.*;

public class LoginController {

	@FXML private ImageView login;
	
	@FXML private TextField txtPassword;
	@FXML private TextField txtUsername;
	
	@FXML private Label lblStatus;
	@FXML private Label lblVersion;
	
	@FXML private Hyperlink hypSignup;
	
	@FXML private ComboBox<String> resolutionBox;
	
	@FXML private ObservableList<String> list = FXCollections.observableArrayList("800x600","1280x1024","1366x768","1920x1080");

	private int rank;
	
	private boolean userPass;
	public String username;
	private File file;
	private String resolution = "1920x1080";
	private Parent root;
	
	public void hoverLogin(MouseEvent event) {
		login.getScene().setCursor(Cursor.HAND);
		login.setImage(new Image("img/technical/bigButtonMouse.png"));
	}
	
	public void exitLogin(MouseEvent event) {
		login.getScene().setCursor(Cursor.DEFAULT);
		login.setImage(new Image("img/technical/bigButton.png"));
	}
	
	public void pressedLogin(MouseEvent event) {
		login.getScene().setCursor(Cursor.HAND);
		login.setImage(new Image("img/technical/bigButtonPressed.png"));
	}

	public void releasedLogin(MouseEvent event) throws Exception {
		TextEncryptor te = new TextEncryptor(txtUsername.getText());
		te.encrypt();
		login.setImage(new Image("img/technical/bigButtonMouse.png"));
        BufferedReader br = null;
        try {
        	file = new File("stats/userInformation.stat");
        	if (!file.exists()) {
        		lblStatus.setText("Invalid Credentials...");
        	} else {
	       		br = new BufferedReader(new FileReader("stats/userInformation.stat"));
	        	String line;
	            
	        	while ((line = br.readLine()) != null) {
	 
	        		if (txtUsername.getText().equals(new TextEncryptor(line).decrypt(2)) && txtPassword.getText().equals(new TextEncryptor(br.readLine()).decrypt(2))) {
	                    br.close();
	                    if (resolution.equals("n")) {
	                    	lblStatus.setText("No Resolution Chosen");
	                    	userPass = false;
	                    	break;
	                    }
	                    PrintWriter pw = new PrintWriter("stats/currentUser.stat");
	                    pw.println(te.getText());
	                    pw.println(new TextEncryptor(resolution).encrypt());
	                    pw.close();
	                    userPass = true;
	                	break;
	                } else {
	                	userPass = false;
	                    lblStatus.setText("Invalid Credentials...");
	                }
	            }

	    		te.encrypt(2);
	            if (userPass) {
	            	br = new BufferedReader(new FileReader("stats/"+te.getText()+"/Stats.stat"));
	            	rank = Integer.parseInt(new TextEncryptor(br.readLine()).decrypt());
	            	br.close();
	            	lblStatus.setText("Login Successful!");
	            	if (rank == 0) {
	            		if (resolution.equals("800x600")) {
	                		root = FXMLLoader.load(getClass().getResource("/application/Tutorial800x600.fxml"));
	                	} else if (resolution.equals("1280x1024")) {
	                		root = FXMLLoader.load(getClass().getResource("/application/Tutorial1280x1024.fxml"));
	                	} else if (resolution.equals("1366x768")) {
	                		root = FXMLLoader.load(getClass().getResource("/application/Tutorial1366x768.fxml"));
	                	} else if (resolution.equals("1920x1080")) {
	                		root = FXMLLoader.load(getClass().getResource("/application/Tutorial1920x1080.fxml"));
	                	}
	                } else {
	            		root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
	                }
					new File("stats/changelog.stat").createNewFile();
					PrintWriter pw = new PrintWriter("stats/changelog.stat");
					pw.println("Company Simulator v1.3 Changelog:\n\nAdded Daily Rewards!\n\nAdded more development tools for Company Simulator developers.\n\nChanged storage location of some game files.\n\nNew Miner, Lumberjack, and Wood Cutter Textures.\n\nBug fixes.");
					pw.close();
	            	new File("stats/log.stat").createNewFile();
	            	pw = new PrintWriter("stats/log.stat");
	            	pw.println(new TextEncryptor("'"+txtUsername.getText()+"' launched Company Simulator.").encrypt());
	            	pw.close();
	            	new File("stats/console.stat").createNewFile();
					pw = new PrintWriter("stats/console.stat");
					pw.println("0");
					pw.close();
					if (!new File("stats/history.stat").exists()) {
						new File("stats/history.stat").createNewFile();
					} else {
						new File("stats/history.stat").delete();
						new File("stats/history.stat").createNewFile();
					}
	            	Stage stage = new Stage();
	            	Scene scene = new Scene(root);
	        		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        		stage.setScene(scene);
	                stage.setTitle("Company Simulator");
	    			stage.getIcons().add(new Image("img/technical/companyIcon.png"));
	    			if (rank != 0)
	    				stage.setFullScreen(true);
//	    			stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
//	    			stage.setFullScreenExitHint("");
	                stage.show();
	                stage = (Stage) hypSignup.getScene().getWindow();
	                stage.close();
	            }
        	}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void Signup(ActionEvent event) throws Exception {
        Stage primaryStage = new Stage();
        root = FXMLLoader.load(getClass().getResource("/application/Signup.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Company Simulator");
		primaryStage.getIcons().add(new Image("img/technical/companyIcon.png"));
        primaryStage.show();
        Stage stage = (Stage) hypSignup.getScene().getWindow();
        stage.close();
    }
	
	public void resolutionChanged(ActionEvent event) {
		resolution = resolutionBox.getValue();
	}
}
