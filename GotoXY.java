import java.util.Random;

public class GotoXY extends State {
    private double speedY;
    private double speedX;
    private Position destination;

    public GotoXY(Corporation corporation) {
        super(corporation);
        Random random = new Random();
        this.destination = new Position(random.nextInt(1920), 500);
        if (destination.getY() < getCorporation().position.getY()) {
            this.speedY = random.nextInt(5) + 1;
        }
        else {
            this.speedY = -(random.nextInt(5) + 1);
        }
        this.speedX = this.speedY * ((getCorporation().position.getX() - destination.getX()) / (getCorporation().position.getY() - destination.getY()));
        this.setName("GotoXY");
    }

    @Override
    public void update() {

        if (getCorporation().position.distanceTo(destination.getX(), destination.getY()) < 50) {
            this.setStateComplete(true);
        }
        getCorporation().position.setY(getCorporation().position.getY() - speedY/5);
        getCorporation().position.setX(getCorporation().position.getX() - speedX/5);

    }

}