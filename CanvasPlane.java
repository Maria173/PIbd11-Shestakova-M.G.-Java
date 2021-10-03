import javax.swing.*;

public class CanvasPlane extends JFrame{
    public CanvasPlane(){
        setTitle("Окно с изображением");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocation(200, 200);
        add(new WindowControl());
        setVisible(true);
    }
    
    public static void main(String[] args){
        CanvasPlane plane = new CanvasPlane();
    }
}
