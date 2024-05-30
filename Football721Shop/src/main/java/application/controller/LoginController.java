package application.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import java.io.IOException;
import javafx.event.EventHandler;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passField;

    @FXML
    private Label passLabel;

    @FXML
    private TextField textField;

    @FXML
    private Label userLabel;

    @FXML
    void initialize() {
        Platform.runLater(() -> textField.requestFocus());

        textField.getParent().addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // Chiamare il metodo clickLogin se il tasto premuto è Enter
                clickLogin(new ActionEvent());
            }
        });

        addArrowKeyNavigation(textField);
        addArrowKeyNavigation(passField);
    }

    private void addArrowKeyNavigation(TextField field) {
        field.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.RIGHT) {
                    passField.requestFocus();
                } else if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.LEFT) {
                    textField.requestFocus();
                }
            }
        });
    }

    @FXML
    void clickLogin(ActionEvent event) {
        String username = textField.getText();
        String password = passField.getText();

        if ("user".equals(username) && "user".equals(password)) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/home.fxml"));
                Parent root = loader.load();

                HomeController homeController = loader.getController();

                Scene scene = new Scene(root);

                Stage stage = new Stage();
                stage.setTitle("Home Page");
                stage.setScene(scene);

                stage.show();

                ((Stage) loginButton.getScene().getWindow()).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Accesso fallito!");
            alert.setHeaderText(null);
            alert.setContentText("Controlla le credenziali!");
            alert.showAndWait();
        }
    }
}
