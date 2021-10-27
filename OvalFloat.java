import java.awt.*;

public class OvalFloat implements IFloat {
    protected NumbFloats numbFloats;
    protected static int planeHeight;

    public OvalFloat(int planeHeight){
        this.planeHeight = planeHeight;
    }

    public void setNumbFloats(int numbFloats){
        this.numbFloats = NumbFloats.values()[numbFloats / 2];
    }

    public void drawFloats(Color dopColor, Graphics2D g2d, int startX, int startY){
        for(int i = 0; i < numbFloats.ordinal() * 2; i++){
            g2d.setColor(dopColor);
            g2d.fillOval(startX, startY + 80 + i * planeHeight / 15, 160, 4);
            g2d.setColor(Color.black);
            g2d.drawOval(startX, startY + 80 + i * planeHeight / 15, 160, 4);
        }
    }
}
