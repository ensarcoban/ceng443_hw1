import java.awt.*;

public class ElectronicsOrder extends Order {
    public ElectronicsOrder(double x, double y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(new Color(0, 182, 204));
        super.draw(g2d);

    }

    @Override
    public void step() {
        super.step();
    }
    // TODO
    // RGB --> (0, 182, 204)
}