import java.awt.*;

public class SquareFloat extends LineFloat {

    public SquareFloat(int planeHeight){
        super(planeHeight);
    }

    @Override
    public void drawFloats(Color dopColor, Graphics2D g2d, int startX, int startY){
        for(int i = 0; i < numbFloats.ordinal() * 2; i++){
            g2d.setColor(dopColor);
            g2d.fillRect(startX, startY + 80 + i * planeHeight / 15, 160, 4);
            g2d.setColor(Color.black);
            g2d.drawRect(startX, startY + 80 + i * planeHeight / 15, 160, 4);
        }
    }
}
