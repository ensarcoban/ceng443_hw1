import java.util.Random;

import static java.lang.Math.abs;

public class GotoXY extends State {
    private double speedY;
    private double speedX;
    private final Position destination;

    /**
     * Sets random position on the map. Goes to that position at a random speed.
     * @param corporation
     */
    public GotoXY(Corporation corporation) {
        super(corporation);
        Random random = new Random();
        int randomX = random.nextInt(1920);
        int randomY = random.nextInt(400)+200;

        this.destination = new Position(randomX, randomY);
        if (destination.getY() < getCorporation().position.getY()) {
            this.speedY = random.nextInt(3) + 1;
        }
        else {
            this.speedY = -(random.nextInt(3) + 1);
        }
        this.speedX = this.speedY * ((getCorporation().position.getX() - destination.getX()) / (getCorporation().position.getY() - destination.getY()));

        if (abs(getCorporation().position.getY() - randomY) < 50) {
            this.speedX = this.speedX / 10;
            this.speedY = this.speedY / 10;
        }
        if (abs(getCorporation().position.getX() - randomX) < 50) {
            this.speedX = this.speedX / 10;
            this.speedY = this.speedY / 10;
        }
        this.setName("GotoXY");
    }

    @Override
    public void update() {

        // Goes to random position on the map, then set state complete when corporation reach random position.
        if (getCorporation().position.distanceTo(destination.getX(), destination.getY()) < 50) {
            this.setStateComplete(true);
        }
        getCorporation().position.setY(getCorporation().position.getY() - speedY/5);
        getCorporation().position.setX(getCorporation().position.getX() - speedX/5);

    }

}