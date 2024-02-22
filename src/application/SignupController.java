package application;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.*;

public class SignupController {

	@FXML private Label lblStatus;
	@FXML private TextField txtUsername;
	@FXML private TextField txtPassword;
	@FXML private TextField txtConfirmPassword;
	@FXML private Button signup;
	@FXML private Hyperlink hypLogin;
	
	private PrintWriter pw;
	
	public void Signup(ActionEvent event) throws Exception {
		TextEncryptor te = new TextEncryptor(txtUsername.getText());
        if (txtPassword.getText().equals(txtConfirmPassword.getText())) {
            Files.createDirectories(Paths.get("stats/"+te.encrypt(3)));
            pw = new PrintWriter(new FileWriter("stats/userInformation.stat", true));
            pw.println(te.decrypt());//Username
            pw.println(new TextEncryptor(txtPassword.getText()).encrypt(2));//Password
            pw.close();
            
            te.encrypt();
            pw = new PrintWriter("stats/"+te.getText()+"/Stats.stat");
            pw.println(new TextEncryptor("0").encrypt());//Rank
            pw.close();
            
            pw = new PrintWriter("stats/"+te.getText()+"/Keys.stat");
            pw.println(new TextEncryptor("W").encrypt());//Buy 1 Key
            pw.println(new TextEncryptor("R").encrypt());//Buy 2 Key
            pw.println(new TextEncryptor("S").encrypt());//Sell 1 Key
            pw.println(new TextEncryptor("F").encrypt());//Sell 2 Key
            pw.println(new TextEncryptor("D").encrypt());//Go To Next Page
            pw.println(new TextEncryptor("A").encrypt());//Go To Previous Page
            pw.println(new TextEncryptor("HOME").encrypt());//Go To First Page
            pw.println(new TextEncryptor("END").encrypt());//Go To Last Page
            pw.println(new TextEncryptor("B").encrypt());//Open Storage
            pw.println(new TextEncryptor("N").encrypt());//Open Achievements
            pw.println(new TextEncryptor("M").encrypt());//Open Competitors
            pw.println(new TextEncryptor("ESCAPE").encrypt());//Open Options
            pw.println(new TextEncryptor("E").encrypt());//Increase Price
            pw.println(new TextEncryptor("Q").encrypt());//Decrease Price
            pw.println(new TextEncryptor("V").encrypt());//Increase Multiplier
            pw.println(new TextEncryptor("C").encrypt());//Decrease Multiplier
            pw.close();
            
            pw = new PrintWriter("stats/"+te.getText()+"/Achievements.stat");
            for (int i = 0;i < 13;i++) pw.println(new TextEncryptor("0").encrypt());
            pw.close();

			pw = new PrintWriter("stats/"+te.getText()+"/Prices.stat");
            pw.println(new TextEncryptor("1.0").encrypt());//Fish Price
            pw.println(new TextEncryptor("1.0").encrypt());//Coal Price
            pw.println(new TextEncryptor("1.0").encrypt());//Planks Price
            pw.println(new TextEncryptor("1.0").encrypt());//Cotton Price
            pw.println(new TextEncryptor("1.0").encrypt());//Steak Price
            pw.println(new TextEncryptor("1.0").encrypt());//Pork Price
            pw.println(new TextEncryptor("1.0").encrypt());//Chicken Price
            pw.println(new TextEncryptor("1.0").encrypt());//Mutton Price
			pw.close();
    
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Company Simulator");
			primaryStage.getIcons().add(new Image("img/technical/companyIcon.png"));
            primaryStage.show();
            Stage stage = (Stage) signup.getScene().getWindow();
            stage.close();
        } else {
            lblStatus.setText("Passwords Don't Match");
        }     
    }
	
	public void Login(ActionEvent event) throws Exception {
    	Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Company Simulator");
		primaryStage.getIcons().add(new Image("img/technical/companyIcon.png"));
        primaryStage.show();
        Stage stage = (Stage) hypLogin.getScene().getWindow();
        stage.close();
    }
}
