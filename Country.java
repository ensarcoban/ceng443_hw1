import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Country extends Entity {
    private final String name;
    private final Font font = new Font("Verdana", Font.PLAIN, 25);
    private final String path;
    private double worth;
    private double cash;
    private double gold;
    private double happiness;

    public Country(double x, double y, String name, String path) {
        super(x, y);
        this.name = name;
        this.path = path;
        this.worth = 8750;
        this.cash = 5000;
        this.gold = 50;
        this.happiness = 50;

    }

    @Override
    public void draw(Graphics2D g2d) {
        Image image = new ImageIcon(path).getImage();
        g2d.drawImage(image, position.getIntX(), position.getIntY(), 150, 150, null);
        g2d.setFont(font);
        g2d.drawString(this.name, position.getIntX()+35, position.getIntY()+180);
        g2d.drawString("Worth: %s".formatted((int) this.worth), position.getIntX(), position.getIntY()+205);
        g2d.drawString("Cash: %s".formatted((int) this.cash), position.getIntX(), position.getIntY()+230);
        g2d.drawString("Gold: %s".formatted((int) this.gold), position.getIntX(), position.getIntY()+255);
        g2d.drawString("Happiness: %s".formatted((int) this.happiness), position.getIntX(), position.getIntY()+280);
    }

    @Override
    public void step() {

    }
    // TODO
    // Country image is 150 x 150
    // Name RGB --> Black
    // Worth RGB --> Blue
    // Cash RGB --> (0, 100, 0)
    // Gold RGB --> Yellow
    // Happiness RGB --> (180, 0, 0)
}