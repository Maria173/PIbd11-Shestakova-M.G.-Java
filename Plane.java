import java.awt.*;
import java.util.Random;

public class Plane {
    private int startX;
    private int startY;
    private int picWidth;
    private int picHeight;
    private static final int planeWidth = 215;
    private static final int planeHeight = 100;
    public int MaxSpeed;
    public float Weight;
    public Color MainColor;
    public Color DopColor;

    // Признак наличия поплавка
    public Boolean FloatSpoiler;
    // Признак наличия винта
    public Boolean ScrewSpoiler;

    private Floats floats;

    private void setMaxSpeed(int MaxSpeed){
        this.MaxSpeed = MaxSpeed;
    }
    public int getMaxSpeed(){
        return MaxSpeed;
    }
    private void setWeight(float Weight){
        this.Weight = Weight;
    }
    public float getWeight(){
        return Weight;
    }
    private void setMainColor(Color MainColor){
        this.MainColor = MainColor;
    }
    public Color getMainColor(){
        return MainColor;
    }
    public void setDopColor(Color DopColor) {
        this.DopColor = DopColor;
    }
     public Color getDopColor(){
        return DopColor;
    }
    private void setFloatSpoiler(Boolean FloatSpoiler){
        this.FloatSpoiler = FloatSpoiler;
    }
     public Boolean getFloatSpoiler(){
        return FloatSpoiler;
    }
    private void setScrewSpoiler(Boolean ScrewSpoiler){
        this.ScrewSpoiler = ScrewSpoiler;
    }
    public Boolean getScrewSpoiler(){
        return ScrewSpoiler;
    }

    public void Init(int maxSpeed, float weight, Color mainColor, Color dopColor,
    Boolean floatSpoiler, Boolean screwSpoiler){
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        DopColor = dopColor;
        FloatSpoiler = floatSpoiler;
        ScrewSpoiler = screwSpoiler;
        floats = new Floats();
        floats.Init(planeHeight);
        if(screwSpoiler){
            Random rand = new Random();
            floats.setNumbFloats(2 + rand.nextInt((8 - 2) / 2) * 2);
        }
        else{
            floats.setNumbFloats(0);
        }
    }

    public void SetPosition(int x, int y, int width, int height){
        startX = x;
        startY = y;
        picWidth = width;
        picHeight = height;
    }

    public void MoveTransport(Direction direction){
        float step = MaxSpeed * 100 / Weight;
        switch (direction){
            case Right:
                if (startX + step < picWidth - planeWidth)
                {
                    startX += step;
                }
                break;
            case Left:
                if(startX-step>0)
                {
                    startX -= step;
                }
                break;
            case Up:
                if(startY - step > 0)
                {
                    startY -= step;
                }
                break;
            case Down:
                if (startY + step < picHeight - planeHeight)
                {
                    startY += step;
                }
                break;
        }
    }

    public void DrawTransport(Graphics g){
        g.clearRect(0, 0, 800, 500);
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

        if (ScrewSpoiler){
            g2d.drawLine(startX + 215, startY + 70, startX + 185, startY + 30);
            g2d.drawLine(startX + 185, startY + 70, startX + 215, startY + 30);
        }

        if(FloatSpoiler){
            floats.drawFloats(DopColor, g2d, startX, startY);
        }
    }
}
