import java.awt.*;

public class SquareFloat extends LineFloat {

    public SquareFloat(int planeHeight){
        super(planeHeight);
    }

    @Override
    public void drawFloats(Color dopColor, Graphics g, int startX, int startY){
        for(int i = 0; i < numbFloats.ordinal() * 2; i++){
            g.setColor(dopColor);
            g.fillRect(startX, startY + 80 + i * planeHeight / 15, 160, 4);
            g.setColor(Color.black);
            g.drawRect(startX, startY + 80 + i * planeHeight / 15, 160, 4);
        }
    }
}
