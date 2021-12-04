import java.awt.*;

public class LineFloat extends OvalFloat {

    public LineFloat(int planeHeight){
        super(planeHeight);
    }

    @Override
    public void drawFloats(Color dopColor, Graphics g, int startX, int startY){
        for(int i = 0; i < numbFloats.ordinal() * 2; i++){
            g.setColor(dopColor);
            g.drawLine(startX, startY + 80 + i * planeHeight / 15, startX + 160, startY + 80 + i * planeHeight / 15);
        }
    }
}
