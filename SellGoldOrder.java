import java.awt.*;
import java.awt.geom.Ellipse2D;

public class SellGoldOrder extends GoldOrder {
    public SellGoldOrder(double x, double y, Country sourceCountry) {
        super(x, y, sourceCountry);
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

    @Override
    public void executeOrder() {
        Country country = this.getSourceCountry();
        country.setGold(country.getGold() - this.getAmount());
        country.setCash(country.getCash() + this.getAmount() * Common.getGoldPrice().getCurrentPrice());
        country.calculateAndSetWorth();
    }

    /**
     * This Overridden function handles Corporation SellGoldOrder interaction logic.
     * @param corporation is the variable that is interacted with the gold order.
     */
    @Override
    public void interact(Corporation corporation) {
        System.out.println("interact logic sell gold order");
        Country country = this.getSourceCountry();
        country.setGold(country.getGold() - this.getAmount());
        country.setHappiness(country.getHappiness() - this.getAmount() * 0.1);
    }
}