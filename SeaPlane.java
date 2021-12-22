import java.awt.*;
import java.util.Random;

public class SeaPlane extends Plane{

    public Color DopColor;
    // Признак наличия поплавка
    public Boolean FloatSpoiler;
    // Признак наличия винта
    public Boolean ScrewSpoiler;

    private IFloat floats;

    public void setDopColor(Color DopColor) {
        this.DopColor = DopColor;
    }
     public Color getDopColor(){
        return DopColor;
    }
    private void setScrewSpoiler(Boolean ScrewSpoiler){
        this.ScrewSpoiler = ScrewSpoiler;
    }
    public Boolean getScrewSpoiler(){
        return ScrewSpoiler;
    }
    private void setOvalFloat(Boolean FloatSpoiler){
        this.FloatSpoiler = FloatSpoiler;
    }
    public Boolean getOvalFloat(){
        return FloatSpoiler;
    }

    public SeaPlane(int maxSpeed, float weight, Color mainColor, Color dopColor,
    Boolean floatSpoiler, Boolean screwSpoiler){
        super(maxSpeed, weight, mainColor, 215, 100);
        DopColor = dopColor;
        ScrewSpoiler = screwSpoiler;
        this.FloatSpoiler = floatSpoiler;
        if(FloatSpoiler){
            Random rand = new Random();
            switch(rand.nextInt(3)){
                case 0:
                    floats = new OvalFloat(planeHeight);
                    break;
                case 1:
                    floats = new SquareFloat(planeHeight);
                    break;
                case 2:
                    floats = new LineFloat(planeHeight);
                    break;
            }
            floats.setNumbFloats(2 + rand.nextInt((8 - 2) / 2) * 2);
        }
    }

    @Override
    public void DrawTransport(Graphics g){
        super.DrawTransport(g);

        if (ScrewSpoiler){
            g.drawLine(startX + 215, startY + 70, startX + 185, startY + 30);
            g.drawLine(startX + 185, startY + 70, startX + 215, startY + 30);
        }

        if(FloatSpoiler){
            floats.drawFloats(DopColor, g, startX, startY);
        }
    }
}

