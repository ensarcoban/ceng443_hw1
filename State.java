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

    /**
     * This static function returns a random state and set corporation reference in the state objects.
     * @param corporation is the object that state belongs to.
     * @return returns a random state.
     */
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

    /**
     * Applies the logic of the state for all types. Updates the position of the state, chase the object etc.
     * Ends state if the state is complete.
     */
    public void update() {
    }
}