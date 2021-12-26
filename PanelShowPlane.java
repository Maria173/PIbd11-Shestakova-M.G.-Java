import javax.swing.*;
import java.awt.*;

public class PanelShowPlane extends JPanel{
    private ITransport plane;
    public void paintComponent(Graphics g){
        if(plane!=null){
            plane.DrawTransport(g);
        }
    }
    public ITransport getPlane(){
        return plane;
    }
    public void setPlane(ITransport plane){
        this.plane = plane;
    }
}