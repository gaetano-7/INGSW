package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;


public class CartController {

    @FXML
    void initialize() {
        List<String> nomiProdotti = HomeController.getNomiProdotti();
        List<String> prezziProdotti = HomeController.getPrezziProdotti();

        for (int i = 0; i < nomiProdotti.size(); i++) {
            String nomeProdotto = nomiProdotti.get(i);
            String prezzoProdotto = prezziProdotti.get(i);

            Label prodottoLabel = new Label(nomeProdotto+ "                                                          | " + prezzoProdotto);

            contenitoreProdotti.getChildren().add(prodottoLabel);
        }
        calcolaPrezzoTotale();
    }

    private void calcolaPrezzoTotale() {
        double totale = 0.0;

        for (int i = 0; i < HomeController.getPrezziProdotti().size(); i++) {
            String prezzoString = HomeController.getPrezziProdotti().get(i);

            prezzoString = prezzoString.replace("€", "").trim();

            try {
                double prezzo = Double.parseDouble(prezzoString);
                totale += prezzo;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        prezzoTotale.setText("€ " + String.format("%.2f", totale));
    }

    @FXML
    private Button bottoneHome;

    @FXML
    private Button bottonePagamento;

    @FXML
    private VBox contenitoreProdotti;

    @FXML
    private Label prezzoTotale;

    @FXML
    void clickHome(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/home.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stage = (Stage) bottoneHome.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void clickPagamento(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Payment.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stage = (Stage) bottonePagamento.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
