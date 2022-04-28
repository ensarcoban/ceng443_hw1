import javax.swing.*;
import java.awt.*;

public class Corporation extends Entity {
    private final String path;
    private final String name;
    private State state;
    private final Font font = new Font("Verdana", Font.PLAIN, 25);

    public Corporation(double x, double y, String name, String path) {
        super(x, y);
        this.name = name;
        this.path = path;
        this.state = State.stateFactory(this);
    }

    @Override
    public void draw(Graphics2D g2d) {
        Image image = new ImageIcon(path).getImage();
        g2d.drawImage(image, position.getIntX(), position.getIntY(), 100, 100, null);
        g2d.setFont(font);
        g2d.setColor(Color.BLACK);
        g2d.drawString(this.name, position.getIntX()+25, position.getIntY());
        g2d.setColor(Color.BLUE);
        g2d.drawString(this.state.getName(), position.getIntX()+20, position.getIntY()+120);
        g2d.setColor(new Color(180, 0, 0));
        g2d.drawString("0", position.getIntX()+35, position.getIntY()+140);
    }

    @Override
    public void step() {
        this.state.update();
        if (this.state.isStateComplete()) {
            this.state = State.stateFactory(this);
        }
    }
    // TODO
    // Corporation image is 100 x 100
    // Cash RGB --> (180, 0, 0)
    // Badge is 20 x 20
}