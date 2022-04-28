import java.awt.*;

public class ElectronicsOrder extends Order {
    public ElectronicsOrder(double x, double y, Country sourceCountry) {
        super(x, y, sourceCountry);
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

    @Override
    public void executeOrder() {
        Country country = this.getSourceCountry();
        country.setCash(country.getCash() - this.getAmount() * Common.getElectronicsPrice().getCurrentPrice());
        country.setHappiness(country.getHappiness() + this.getAmount() * 0.4);
    }
}