package application.strategy;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PayPalStrategy implements PaymentStrategy {
    private VBox contenitoreMetodi;
    private Pane panePP;

    public PayPalStrategy(VBox contenitoreMetodi, Pane panePP) {
        this.contenitoreMetodi = contenitoreMetodi;
        this.panePP = panePP;
    }
    @Override
    public void processPayment() {
        contenitoreMetodi.setVisible(false);
        panePP.setVisible(true);
    }
}