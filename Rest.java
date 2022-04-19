public class Rest extends State {
    private int counter;
    public Rest(Corporation corporation) {
        super(corporation);
        this.counter = 400;
        this.setName("Rest");
    }

    @Override
    public void update() {
        if (this.counter-- == 0) {
            this.setStateComplete(true);
        }
    }
}