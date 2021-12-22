import java.awt.*;
import java.util.ArrayList;

public class Aerodrome<T extends ITransport, U extends IFloat> {
    private ArrayList<T> places;
    private int maxCount;
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
        maxCount = width * height;
        places = new ArrayList<T>();
        PicWidth = picWidth;
        PicHeight = picHeight;
    }

    public T getPlane(int index){       // в jqvq нет возможности сделать индексатор, как в C#
        if(index>-1 && index<places.size()){
            return places.get(index);
        }
        return null;
    }

    public int addPlane(T plane){
        if(places.size()<maxCount){
            places.add(plane);
            return places.size()-1;
        }
        else {
            return -1;
        }
    }

    public T remove(int index){
        if(index>-1 && index<places.size()){
            T removePlane=places.get(index);
            places.remove(index);
            return removePlane;
        }
        else { return null; }
    }

    public boolean moreOrEqual(int count){          // >=
        int fullness = 0;
        for (int i = 0; i < places.size(); ++i){
            if (places.get(i) != null){
                fullness += 1;
            }
        }
        return fullness > count || fullness == count;
    }

    public boolean lessOrEqual(int count){         // <=
        int fullness = 0;
        for (int i = 0; i < places.size(); ++i){
            if (places.get(i) != null){
                fullness += 1;
            }
        }
        return fullness < count || fullness == count;
    }

    public void Draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        DrawMarking(g);
        for(int i=0; i<places.size(); i++)
        {
            places.get(i).SetPosition(5 + i % 5 * placeSizeWidth + 5, i /5 * placeSizeHeight + 5, PicWidth, PicHeight);
            places.get(i).DrawTransport(g);
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