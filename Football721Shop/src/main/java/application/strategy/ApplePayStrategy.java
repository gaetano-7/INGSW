package application.strategy;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ApplePayStrategy implements PaymentStrategy {
    private VBox contenitoreMetodi;
    private Pane paneAP;

    public ApplePayStrategy(VBox contenitoreMetodi, Pane paneAP) {
        this.contenitoreMetodi = contenitoreMetodi;
        this.paneAP = paneAP;
    }
    @Override
    public void processPayment() {
        contenitoreMetodi.setVisible(false);
        paneAP.setVisible(true);

    }
}

