public abstract class State {
    private final Corporation corporation;
    private String name;
    private boolean stateComplete;
    public State(Corporation corporation) {
        this.corporation = corporation;
        stateComplete = false;
    }

    public Corporation getCorporation() {
        return corporation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStateComplete() {
        return stateComplete;
    }

    public void setStateComplete(boolean stateComplete) {
        this.stateComplete = stateComplete;
    }

    public static State stateFactory(Corporation corporation) {
        int randInt = Common.getRandomGenerator().nextInt(4);
        if (randInt == 0) {
            return new GotoXY(corporation);
        } else if (randInt == 1) {
            return new Shake(corporation);
        } else if (randInt == 2) {
            return new ChaseClosest(corporation);
        } else {
            return new Rest(corporation);
        }
    }

    public void update() {
    }
}