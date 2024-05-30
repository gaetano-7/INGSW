package application.controller;

import application.strategy.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PaymentController {

    @FXML
    private Pane confirmOrder;

    @FXML
    private Button chiudiButt;

    @FXML
    private Button continuaButt;

    @FXML
    private Label nomePag;

    @FXML
    private CheckBox applePay;

    @FXML
    private Button buttonEffettua;

    @FXML
    private Button buttonHome;

    @FXML
    private CheckBox cartaCredito;

    @FXML
    private Button confirmButton;

    @FXML
    private Button changeButton;

    @FXML
    private VBox contenitoreMetodi;

    @FXML
    private CheckBox giftCard;

    @FXML
    private CheckBox googlePay;

    @FXML
    private Label pane;

    @FXML
    private Label pane1;

    @FXML
    private Label pane11;

    @FXML
    private Pane paneAP;

    @FXML
    private Pane paneCC;

    @FXML
    private Pane paneGC;

    @FXML
    private Pane paneGP;

    @FXML
    private Pane panePP;

    @FXML
    private CheckBox payPal;

    private PaymentStrategy paymentStrategy;

    @FXML
    private void initialize() {
        paymentStrategy = new CartaCreditoStrategy(contenitoreMetodi, paneCC);
    }

    @FXML
    void chiudiClick(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void continuaClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/home.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stage = (Stage) buttonHome.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void confirmClick(ActionEvent event) {
        paymentStrategy.processPayment();
        confirmButton.setVisible(false);
        changeButton.setVisible(true);
        buttonEffettua.setVisible(true);
    }

    @FXML
    void clickEffettua(ActionEvent event) {
        panePP.setVisible(false);
        paneCC.setVisible(false);
        paneGP.setVisible(false);
        paneGC.setVisible(false);
        paneAP.setVisible(false);
        nomePag.setVisible(false);
        contenitoreMetodi.setVisible(false);
        changeButton.setVisible(false);
        buttonEffettua.setVisible(false);
        confirmButton.setVisible(false);
        confirmOrder.setVisible(true);
        continuaButt.setVisible(true);
        chiudiButt.setVisible(true);
    }

    @FXML
    void clickChange(ActionEvent event) {
        panePP.setVisible(false);
        paneCC.setVisible(false);
        paneGP.setVisible(false);
        paneGC.setVisible(false);
        paneAP.setVisible(false);
        contenitoreMetodi.setVisible(true);
        confirmButton.setVisible(true);
        changeButton.setVisible(false);
        buttonEffettua.setVisible(false);
    }

    @FXML
    void clickHome(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/home.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stage = (Stage) buttonHome.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCheckBoxChange(ActionEvent event) {
        CheckBox selectedCheckbox = (CheckBox) event.getSource();

        for (CheckBox checkbox : getAllCheckBoxes()) {
            if (checkbox != selectedCheckbox) {
                checkbox.setSelected(false);
            }
        }

        if (applePay.isSelected()) {
            paymentStrategy = new ApplePayStrategy(contenitoreMetodi, paneAP);
        } else if (cartaCredito.isSelected()) {
            paymentStrategy = new CartaCreditoStrategy(contenitoreMetodi, paneCC);
        } else if (googlePay.isSelected()) {
            paymentStrategy = new GooglePayStrategy(contenitoreMetodi, paneGP);
        } else if (payPal.isSelected()) {
            paymentStrategy = new PayPalStrategy(contenitoreMetodi, panePP);
        } else if (giftCard.isSelected()) {
            paymentStrategy = new GiftCardStrategy(contenitoreMetodi, paneGC);
        }
    }

    private List<CheckBox> getAllCheckBoxes() {
        return Arrays.asList(applePay, cartaCredito, googlePay, payPal, giftCard);
    }

}
