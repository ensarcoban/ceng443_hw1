import java.awt.*;

public class FoodOrder extends Order {
    public FoodOrder(double x, double y, Country sourceCountry) {
        super(x, y, sourceCountry);
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

    @Override
    public void executeOrder() {
        Country country = this.getSourceCountry();
        country.setCash(country.getCash() - this.getAmount() * Common.getFoodPrice().getCurrentPrice());
        country.setHappiness(country.getHappiness() + this.getAmount() * 0.2);
    }
}