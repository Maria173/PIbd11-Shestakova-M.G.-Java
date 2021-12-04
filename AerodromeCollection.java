import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class AerodromeCollection {
    public Map<String, Aerodrome<ITransport, OvalFloat>> aerodromeStages = new HashMap<String, Aerodrome<ITransport, OvalFloat>>();

    public ArrayList<String> keys() {

        return new ArrayList<>(aerodromeStages.keySet());
    }

    private int pictureWidth;
    private int pictureHeight;
    ;public AerodromeCollection(int pictureWidth, int pictureHeight)
    {
        this.pictureWidth = pictureWidth;
        this.pictureHeight = pictureHeight;
    }
    public void AddAerodrome(String name)
    {
        if (!aerodromeStages.containsKey(name))
        {
            aerodromeStages.put(name, new Aerodrome<ITransport, OvalFloat>(pictureWidth, pictureHeight));
        }
    }
    public void DelAerodrome(String name)
    {
        if (aerodromeStages.containsKey(name))
        {
            aerodromeStages.remove(name);
        }
    }
    public Aerodrome<ITransport, OvalFloat> getAerodrome(String ind)
    {
        if (aerodromeStages.containsKey(ind))
        {
            return aerodromeStages.get(ind);
        }
        return null;
    }
    public ITransport getIndex(String indAerodrome, int indexPlane){
        if(aerodromeStages.containsKey(indAerodrome) && aerodromeStages.get(indAerodrome)!=null){
            return aerodromeStages.get(indAerodrome).getPlane(indexPlane);
        }
        return null;
    }
}