import java.awt.*;
import java.awt.geom.Ellipse2D;

public class BuyGoldOrder extends GoldOrder {
    public BuyGoldOrder(double x, double y, Country sourceCountry) {
        super(x, y, sourceCountry);
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

    @Override
    public void executeOrder() {
        Country country = this.getSourceCountry();
        country.setGold(country.getGold() + this.getAmount());
        country.setCash(country.getCash() - this.getAmount() * Common.getGoldPrice().getCurrentPrice());
        country.calculateAndSetWorth();
    }
    // TODO
    // RGB --> (0, 200, 0)

    @Override
    public void interact(Corporation corporation) {
        System.out.println("interact logic buy gold order");
        Country country = this.getSourceCountry();
        country.setCash(country.getCash() - this.getAmount() * Common.getGoldPrice().getCurrentPrice());
        country.setHappiness(country.getHappiness() - this.getAmount() * 0.1);
    }
}