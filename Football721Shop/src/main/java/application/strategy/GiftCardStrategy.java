package application.strategy;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GiftCardStrategy implements PaymentStrategy {
    private VBox contenitoreMetodi;
    private Pane paneGC;

    public GiftCardStrategy(VBox contenitoreMetodi, Pane paneGC) {
        this.contenitoreMetodi = contenitoreMetodi;
        this.paneGC = paneGC;
    }
    @Override
    public void processPayment() {
        contenitoreMetodi.setVisible(false);
        paneGC.setVisible(true);
    }
}