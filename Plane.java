import java.awt.*;

public class Plane extends Vehicle {
    protected static  int planeWidth = 215;
    protected static  int planeHeight = 100;

    public Plane(int maxSpeed, float weight, Color mainColor){
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
    }

    protected Plane(int maxSpeed, float weight, Color mainColor, int skiffWidth, int skiffHeight){
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        this.planeWidth = planeWidth;
        this.planeWidth = planeWidth;
    }

    @Override
    public void MoveTransport(Direction direction){
        float step = MaxSpeed * 100 / Weight;
        switch (direction){
            case Right:
                if (startX + step < picWidth - planeWidth){
                    startX += step;
                }
                break;
            case Left:
                if(startX - step > 0){
                    startX -= step;
                }
                break;
            case Up:
                if(startY - step > 0){
                    startY -= step;
                }
                break;
            case Down:
                if (startY + step < picHeight - planeHeight){
                    startY += step;
                }
                break;
        }
    }
    
    @Override
    public void DrawTransport(Graphics g){
        g.clearRect(0, 0, 818, 497);
        Graphics2D g2d=(Graphics2D)g;

        g2d.setPaint(Color.black);
        g2d.drawRect(startX + 5, startY + 30, 150, 40);
        g2d.drawOval(startX, startY + 25, 40, 10);
        g2d.drawOval(startX + 40, startY + 45, 80, 10);

        g2d.drawLine(startX + 40, startY + 70, startX + 30, startY+ 80);
        g2d.drawLine(startX + 40, startY + 70, startX + 50, startY + 80);
        g2d.drawOval(startX + 25, startY + 80, 10, 10);
        g2d.drawOval(startX + 45, startY + 80, 10, 10);

        g2d.drawLine(startX + 150, startY + 70, startX + 150, startY + 80);
        g2d.drawOval(startX + 145, startY + 80, 10, 10);

        g2d.drawLine(startX + 155, startY + 70, startX + 200, startY + 50);
        g2d.drawLine(startX + 155, startY + 30, startX + 200, startY + 50);
        g2d.drawLine(startX + 155, startY + 50, startX + 200, startY + 50);

        g2d.drawLine(startX + 5, startY, startX + 5, startY + 30);
        g2d.drawLine(startX + 5, startY, startX + 50, startY + 30);

        g2d.setColor(MainColor);

        g2d.fillOval(startX, startY + 25, 40, 10);
        g2d.fillOval(startX + 40, startY + 45, 80, 10);
    }
}
