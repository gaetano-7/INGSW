package application.strategy;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GooglePayStrategy implements PaymentStrategy {
    private VBox contenitoreMetodi;
    private Pane paneGP;

    public GooglePayStrategy(VBox contenitoreMetodi, Pane paneGP) {
        this.contenitoreMetodi = contenitoreMetodi;
        this.paneGP = paneGP;
    }
    @Override
    public void processPayment() {
        contenitoreMetodi.setVisible(false);
        paneGP.setVisible(true);
    }
}
