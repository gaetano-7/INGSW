package application.strategy;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CartaCreditoStrategy implements PaymentStrategy {
    private VBox contenitoreMetodi;
    private Pane paneCC;

    public CartaCreditoStrategy(VBox contenitoreMetodi, Pane paneCC) {
        this.contenitoreMetodi = contenitoreMetodi;
        this.paneCC = paneCC;
    }
    @Override
    public void processPayment() {
        contenitoreMetodi.setVisible(false);
        paneCC.setVisible(true);
    }
}
