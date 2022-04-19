public class Shake extends State {
    private int counter;
    public Shake(Corporation corporation) {
        super(corporation);
        this.counter = 600;
        this.setName("Shake");
    }

    @Override
    public void update() {
        if (this.counter-- == 0) {
            this.setStateComplete(true);
        }
        getCorporation().position.setY(getCorporation().position.getY() - (double) (Common.getRandomGenerator().nextInt(5)-2)/10);
        getCorporation().position.setX(getCorporation().position.getX() - (double) (Common.getRandomGenerator().nextInt(5)-2)/10);
    }
}