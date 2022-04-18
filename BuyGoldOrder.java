import java.awt.*;
import java.awt.geom.Ellipse2D;

public class BuyGoldOrder extends GoldOrder {
    public BuyGoldOrder(double x, double y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(new Color(0, 200, 0));
        super.draw(g2d);
    }

    @Override
    public void step() {
        super.step();
    }
    // TODO
    // RGB --> (0, 200, 0)
}