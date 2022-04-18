import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {
    public Display() { this.setBackground(new Color(180, 180, 180)); }

    @Override
    public Dimension getPreferredSize() { return super.getPreferredSize(); }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Common.getFoodPrice().draw((Graphics2D) g);
        Common.getElectronicsPrice().draw((Graphics2D) g);
        Common.getGoldPrice().draw((Graphics2D) g);

        g.drawLine(Common.getFirstVerticalLineX(), 0, Common.getFirstVerticalLineX(), Common.getHorizontalLineY());
        g.drawLine(Common.getSecondVerticalLineX(), 0, Common.getSecondVerticalLineX(), Common.getHorizontalLineY());
        g.drawLine(0, Common.getHorizontalLineY(), Common.getWindowWidth(), Common.getHorizontalLineY());

        // TODO: draw other entities
        Common.getMexico().draw((Graphics2D) g);
        Common.getChile().draw((Graphics2D) g);
        Common.getPoland().draw((Graphics2D) g);
        Common.getNigeria().draw((Graphics2D) g);
        Common.getMalaysia().draw((Graphics2D) g);

        Common.getBoeing().draw((Graphics2D) g);
        Common.getGeneralDynamics().draw((Graphics2D) g);
        Common.getLockheedMartin().draw((Graphics2D) g);
        Common.getNorthropGrumman().draw((Graphics2D) g);
        Common.getRaytheon().draw((Graphics2D) g);

        Common.getOrders().forEach(order -> order.draw((Graphics2D) g));

    }
}