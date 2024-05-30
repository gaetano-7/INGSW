package application.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeController {

    private static int numeroProdottiAggiunti = 0;

    @FXML
    private Label countProd;

    private static List<String> nomiProdotti = new ArrayList<>();
    private static List<String> prezziProdotti = new ArrayList<>();

    @FXML
    private Label nomeBayern;

    @FXML
    private Label nomeCity;

    @FXML
    private Label nomeJuv;

    @FXML
    private Label nomeMil;

    @FXML
    private Label nomePSG;

    @FXML
    private Label nomeReal;

    @FXML
    private Label PrezzoBayern;

    @FXML
    private Label PrezzoReal;

    @FXML
    private Button bottoneBayern;

    @FXML
    private Button bottoneCity;

    @FXML
    private Button bottoneJuve;

    @FXML
    private Button bottoneMilan;

    @FXML
    private Button bottonePSG;

    @FXML
    private Button bottoneReal;

    @FXML
    private Button buttonCart;

    @FXML
    private Label prezzoCity;

    @FXML
    private Label prezzoJuve;

    @FXML
    private Label prezzoMilan;

    @FXML
    private Label prezzoPSG;

    @FXML
    private ChoiceBox<String> taglieBayern;

    @FXML
    private ChoiceBox<String> taglieCity;

    @FXML
    private ChoiceBox<String> taglieJuv;

    @FXML
    private ChoiceBox<String> taglieMil;

    @FXML
    private ChoiceBox<String> tagliePSG;

    @FXML
    private ChoiceBox<String> taglieReal;

    @FXML
    void clickCart(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/carrello.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stage = (Stage) buttonCart.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void clickBayern(ActionEvent event) {
        String nomeProdotto = nomeBayern.getText();
        String prezzoProdotto = PrezzoBayern.getText();
        String tagliaSelezionata = taglieBayern.getValue();
        aggiungiAlCarrello(nomeProdotto, prezzoProdotto, tagliaSelezionata);
    }

    @FXML
    void clickCity(ActionEvent event) {
        String nomeProdotto = nomeCity.getText();
        String prezzoProdotto = prezzoCity.getText();
        String tagliaSelezionata = taglieCity.getValue();
        aggiungiAlCarrello(nomeProdotto, prezzoProdotto, tagliaSelezionata);
    }

    @FXML
    void clickJuve(ActionEvent event) {
        String nomeProdotto = nomeJuv.getText();
        String prezzoProdotto = prezzoJuve.getText();
        String tagliaSelezionata = taglieJuv.getValue();
        aggiungiAlCarrello(nomeProdotto, prezzoProdotto, tagliaSelezionata);
    }

    @FXML
    void clickMilan(ActionEvent event) {
        String nomeProdotto = nomeMil.getText();
        String prezzoProdotto = prezzoMilan.getText();
        String tagliaSelezionata = taglieMil.getValue();
        aggiungiAlCarrello(nomeProdotto, prezzoProdotto, tagliaSelezionata);
    }

    @FXML
    void clickPSG(ActionEvent event) {
        String nomeProdotto = nomePSG.getText();
        String prezzoProdotto = prezzoPSG.getText();
        String tagliaSelezionata = tagliePSG.getValue();
        aggiungiAlCarrello(nomeProdotto, prezzoProdotto, tagliaSelezionata);
    }

    @FXML
    void clickReal(ActionEvent event) {
        String nomeProdotto = nomeReal.getText();
        String prezzoProdotto = PrezzoReal.getText();
        String tagliaSelezionata = taglieReal.getValue();
        aggiungiAlCarrello(nomeProdotto, prezzoProdotto, tagliaSelezionata);
    }

    private void aggiungiAlCarrello(String nomeProdotto, String prezzoProdotto, String tagliaSelezionata) {
        if (tagliaSelezionata == null || tagliaSelezionata.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attenzione");
            alert.setHeaderText(null);
            alert.setContentText("Seleziona una taglia prima di aggiungere il prodotto al carrello!");
            alert.showAndWait();
        } else {
            nomiProdotti.add(nomeProdotto + " (Taglia: " + tagliaSelezionata + ")");
            prezziProdotti.add(prezzoProdotto);
            numeroProdottiAggiunti++;
            countProd.setText("" + numeroProdottiAggiunti);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Aggiunta al Carrello");
            alert.setHeaderText(null);
            alert.setContentText("Il prodotto " + nomeProdotto + " (Taglia: " + tagliaSelezionata + ") è stato aggiunto al carrello!");
            alert.showAndWait();
        }
    }

    @FXML
    private void initialize() {
        ObservableList<String> taglieOptions = FXCollections.observableArrayList("XS", "S", "M", "L", "XL", "XXL");

        taglieBayern.setItems(taglieOptions);
        taglieCity.setItems(taglieOptions);
        taglieJuv.setItems(taglieOptions);
        taglieMil.setItems(taglieOptions);
        tagliePSG.setItems(taglieOptions);
        taglieReal.setItems(taglieOptions);
    }

    public static List<String> getNomiProdotti() {
        return nomiProdotti;
    }

    public static List<String> getPrezziProdotti() {
        return prezziProdotti;
    }

}
