import java.awt.*;
import java.awt.geom.Ellipse2D;

public class SellGoldOrder extends GoldOrder {
    public SellGoldOrder(double x, double y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(new Color(180, 0, 0));
        super.draw(g2d);
    }

    @Override
    public void step() {
        super.step();
    }
    // TODO
    // RGB --> (180, 0, 0)
}