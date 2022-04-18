import java.util.ArrayList;
import java.util.Random;

public class Common {
    private static final String title = "Arms Race";
    private static final int windowWidth = 1920;
    private static final int windowHeight = 1080;

    private static final int firstVerticalLineX = 500;
    private static final int secondVerticalLineX = 1250;
    private static final int horizontalLineY = 100;

    private static final Random randomGenerator = new Random(1234);

    private static final LivePrice foodPrice = new LivePrice(30, 65, "Food Products", 5, 1, 1, 10);
    private static final LivePrice electronicsPrice = new LivePrice(580, 65,"Consumer Electronics", 30, 2, 10, 50);
    private static final LivePrice goldPrice = new LivePrice(1300, 65, "Gold", 75, 3, 50, 100);

    private static Country mexico;
    private static Country chile;
    private static Country poland;
    private static Country nigeria;
    private static Country malaysia;

    private static Corporation boeing;
    private static Corporation generalDynamics;
    private static Corporation lockheedMartin;
    private static Corporation northropGrumman;
    private static Corporation raytheon;

    public static ArrayList<Order> orders = new ArrayList<>();

    public static ArrayList<Order> ordersToDelete = new ArrayList<>();


    // getters
    public static String getTitle() { return title; }
    public static int getWindowWidth() { return windowWidth; }
    public static int getWindowHeight() { return windowHeight; }

    public static int getFirstVerticalLineX() { return firstVerticalLineX; }
    public static int getSecondVerticalLineX() { return secondVerticalLineX; }
    public static int getHorizontalLineY() { return horizontalLineY; }

    public static Random getRandomGenerator() { return randomGenerator; }

    public static LivePrice getFoodPrice() { return foodPrice; }
    public static LivePrice getElectronicsPrice() { return electronicsPrice; }
    public static LivePrice getGoldPrice() { return goldPrice; }

    public static Country getMexico() {
        return mexico;
    }

    public static Country getChile() {
        return chile;
    }

    public static Country getPoland() {
        return poland;
    }

    public static Country getNigeria() {
        return nigeria;
    }

    public static Country getMalaysia() {
        return malaysia;
    }

    public static Corporation getBoeing() {
        return boeing;
    }

    public static Corporation getGeneralDynamics() {
        return generalDynamics;
    }

    public static Corporation getLockheedMartin() {
        return lockheedMartin;
    }

    public static Corporation getNorthropGrumman() {
        return northropGrumman;
    }

    public static Corporation getRaytheon() {
        return raytheon;
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }

    public static ArrayList<Order> getOrdersToDelete() {
        return ordersToDelete;
    }

    static  {
        // TODO: Here you can instantiate entities/fields
        mexico = new Country(195, 700, "Mexico", "/home/enssr/Desktop/ceng4-2/ceng443/hw1/images/mexico.png");
        chile = new Country(540, 700, "Chile", "/home/enssr/Desktop/ceng4-2/ceng443/hw1/images/chile.png");
        poland = new Country(885, 700, "Poland", "/home/enssr/Desktop/ceng4-2/ceng443/hw1/images/poland.png");
        nigeria = new Country(1230, 700, "Nigeria", "/home/enssr/Desktop/ceng4-2/ceng443/hw1/images/nigeria.png");
        malaysia = new Country(1575, 700, "Malaysia", "/home/enssr/Desktop/ceng4-2/ceng443/hw1/images/malaysia.png");

        boeing = new Corporation(195, 200, "BA", "/home/enssr/Desktop/ceng4-2/ceng443/hw1/images/boeing.png");
        generalDynamics = new Corporation(540, 200, "GD", "/home/enssr/Desktop/ceng4-2/ceng443/hw1/images/general_dynamics.png");
        lockheedMartin = new Corporation(885, 200, "LMT", "/home/enssr/Desktop/ceng4-2/ceng443/hw1/images/lockheed_martin.png");
        northropGrumman = new Corporation(1230, 200, "NOC", "/home/enssr/Desktop/ceng4-2/ceng443/hw1/images/northrop_grumman.png");
        raytheon = new Corporation(1575, 200, "RTX", "/home/enssr/Desktop/ceng4-2/ceng443/hw1/images/raytheon.png");

    }


    public static void stepAllEntities() {
        if (randomGenerator.nextInt(200) == 0) foodPrice.step();
        if (randomGenerator.nextInt(300) == 0) electronicsPrice.step();
        if (randomGenerator.nextInt(400) == 0) goldPrice.step();

        mexico.step();
        chile.step();
        poland.step();
        nigeria.step();
        malaysia.step();


        orders.removeAll(ordersToDelete);
        ordersToDelete.clear();
        orders.forEach(Entity::step);
        // TODO: call other entities' step()
    }
}