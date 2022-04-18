import java.awt.*;

public class FoodOrder extends Order {
    public FoodOrder(double x, double y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(new Color(245, 222, 179));
        super.draw(g2d);
    }

    @Override
    public void step() {
        super.step();
    }
    // TODO
    // RGB --> (245, 222, 179)
}