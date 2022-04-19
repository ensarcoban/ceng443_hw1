import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public abstract class Order extends Entity {

    private int amount;
    private double speedY;
    private double speedX;
    private Position destination;

    private Country sourceCountry;

    public Order(double x, double y, Country sourceCountry) {
        super(x, y);
        Random random = new Random();
        this.destination = new Position(random.nextInt(1920), 100);
        this.amount = random.nextInt(5) + 1;
        this.speedY = random.nextInt(5) + 1;
        this.speedX = this.speedY * ((position.getX() - destination.getX()) / (position.getY() - destination.getY()));
        this.sourceCountry = sourceCountry;
    }

    @Override
    public void draw(Graphics2D g2d) {
        Ellipse2D.Double circle = new Ellipse2D.Double(position.getIntX(), position.getIntY(), 24, 24);
        g2d.fill(circle);
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Verdana", Font.PLAIN, 18));
        g2d.drawString(String.valueOf(amount), position.getIntX()+7, position.getIntY()+20);
    }

    @Override
    public void step() {
        position.setY(position.getY() - getSpeedY()/5);
        position.setX(position.getX() - getSpeedX()/5);

        if (position.getY() <= Common.getHorizontalLineY()) {
            executeOrder();
            Common.getOrdersToDelete().add(this);
        }
    }

    public int getAmount() {
        return amount;
    }

    public double getSpeedY() {
        return speedY;
    }

    public double getSpeedX() {
        return speedX;
    }

    public Position getDestination() {
        return destination;
    }

    public Country getSourceCountry() {
        return sourceCountry;
    }

    public static void orderFactory(Country sourceCountry) {
        Random random = new Random();
        Order order;
        int randInt;
        if (sourceCountry.getHappiness() <= 50) {
            randInt = random.nextInt(2);
            if (randInt == 0) {
                order = new ElectronicsOrder(sourceCountry.position.getX(), sourceCountry.position.getY(), sourceCountry);
            } else {
                order = new FoodOrder(sourceCountry.position.getX(), sourceCountry.position.getY(), sourceCountry);
            }
            Common.orders.add(order);
        }
        randInt = random.nextInt(2);
        if (randInt == 0) {
            order = new BuyGoldOrder(sourceCountry.position.getX(), sourceCountry.position.getY(), sourceCountry);
        } else {
            order = new SellGoldOrder(sourceCountry.position.getX(), sourceCountry.position.getY(), sourceCountry);
        }
        Common.orders.add(order);
    }

    public abstract void executeOrder();
}