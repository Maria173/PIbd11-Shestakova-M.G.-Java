import java.awt.*;

public class SquareFloat implements IFloat {
    protected NumbFloats numbFloats;
    protected static int planeHeight;

    public void Init(int planeHeight){
        this.planeHeight = planeHeight;
    }

    public void setNumbFloats(int numbFloats){
        this.numbFloats = NumbFloats.values()[numbFloats / 2];
    }

    public void drawFloats(Color dopColor, Graphics g, int startX, int startY){
        for(int i = 0; i < numbFloats.ordinal() * 2; i++){
            g.setColor(dopColor);
            g.fillRect(startX, startY + 80 + i * planeHeight / 15, 160, 4);
            g.setColor(Color.black);
            g.drawRect(startX, startY + 80 + i * planeHeight / 15, 160, 4);
        }
    }
}
