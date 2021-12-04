import java.awt.*;

public class LineFloat implements IFloat {
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
            g.drawLine(startX, startY + 80 + i * planeHeight / 15, startX + 160, startY + 80 + i * planeHeight / 15);
        }
    }
}
