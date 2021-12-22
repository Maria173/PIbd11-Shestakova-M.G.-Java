import java.awt.*;

public class Aerodrome<T extends ITransport, U extends IFloat> {
    private Object[] places;
    private int PicWidth;
    private int PicHeight;
    private int placeSizeWidth = 230;
    private int placeSizeHeight = 130;
    private int width;
    private int height;

    public Aerodrome(int picWidth, int picHeight)
    {
        width = picWidth / placeSizeWidth;
        height = picHeight / placeSizeHeight;
        places = new Object[width * height];
        PicWidth = picWidth;
        PicHeight = picHeight;
    }

    public int addPlane(T plane){
        int i = 0;
        while(i<places.length && places[i]!=null){
            i++;
        }
        if(i<places.length && places[i]==null){
            plane.SetPosition(5 + i%width * placeSizeWidth, 5 + i /width* placeSizeHeight,
                    PicWidth, PicHeight);
            places[i] = plane;
            return i;
        }
        else {
            return -1;
        }
    }

    public T remove(int index){
        if(index>=places.length || index < 0) { return null; }
        if (places[index] != null)
        {
            T return_T = (T)places[index];
            places[index] = null;
            return return_T;
        }
        else { return null; }
    }

    public boolean moreOrEqual(int count){          // >=
        int fullness = 0;
        for (int i = 0; i < places.length; ++i){
            if (places[i] != null){
                fullness += 1;
            }
        }
        return fullness > count || fullness == count;
    }

    public boolean lessOrEqual(int count){         // <=
        int fullness = 0;
        for (int i = 0; i < places.length; ++i){
            if (places[i] != null){
                fullness += 1;
            }
        }
        return fullness < count || fullness == count;
    }

    public void Draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        DrawMarking(g);
        for(int i=0; i<places.length; i++)
        {
            if (places[i] != null) {
                T place = (T) places[i];
                place.DrawTransport(g);
            }
        }
    }
    private void DrawMarking(Graphics g)
    {
        g.setColor(Color.BLACK);
        for(int i=0; i<PicWidth/placeSizeWidth; i++)
        {
            for(int j=0; j<PicHeight/placeSizeHeight; j++)
            {
                g.drawLine( i * placeSizeWidth+3, j * placeSizeHeight,
                        i * placeSizeWidth + placeSizeWidth / 2+3, j * placeSizeHeight);
            }
            g.drawLine( i * placeSizeWidth+3, 0, i * placeSizeWidth+3,
                    (PicHeight / placeSizeHeight) * placeSizeHeight);
        }
    }
}