import java.awt.*;

public class LineFloat extends OvalFloat {

    public LineFloat(int planeHeight){
        super(planeHeight);
    }

    @Override
    public void drawFloats(Color dopColor, Graphics2D g2d, int startX, int startY){
        for(int i = 0; i < numbFloats.ordinal() * 2; i++){
            g2d.setColor(dopColor);
            g2d.drawLine(startX, startY + 80 + i * planeHeight / 15, startX + 160, startY + 80 + i * planeHeight / 15);
        }
    }
}
