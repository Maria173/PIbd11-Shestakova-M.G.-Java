import javax.swing.*;

public class CanvasAerodrome extends JFrame{
    WindowControlAerodrome windowControlAerodrome = new WindowControlAerodrome();
    public CanvasAerodrome(){
        setTitle("Аэродром");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1320, 670);
        setLocation(300, 300);
        add(windowControlAerodrome);
        setVisible(true);
    }
    public static void main(String[] args){
        CanvasAerodrome aerodrome = new CanvasAerodrome();
    }
}