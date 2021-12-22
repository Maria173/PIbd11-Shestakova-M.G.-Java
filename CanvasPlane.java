import javax.swing.*;

public class CanvasPlane extends JDialog{
    WindowControl windowControl = new WindowControl();
    public void SetPlane(ITransport plane){
        windowControl.SetPlane(plane);
    }
    public CanvasPlane(){
        setTitle("Окно с изображением");
        setSize(800, 500);
        setLocation(200, 200);
        add(windowControl);
    }
}
