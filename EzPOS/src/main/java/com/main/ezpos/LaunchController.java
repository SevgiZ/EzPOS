package com.main.ezpos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;

public class LaunchController {
    private Stage stage;
    private Scene scene;
    private Parent parent;
    @FXML
    private Label logInText;
    @FXML
    private Label errorLabel;


    @FXML
    protected void onLogInButton() {
        System.out.println(logInText.getText());
        errorLabel.setText("Incorrect username or password!");
    }

    @FXML
    protected void SwitchToDashboardScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard-view.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        DashboardController controller = loader.getController();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() != KeyCode.ENTER) {
                    controller.EnterBarcode();
                }
                else {
                    System.out.println("Searching or entering!");
                }
            }
        });

        stage.setTitle("Hello!");

        stage.setScene(scene);
        stage.show();
    }
}

//test