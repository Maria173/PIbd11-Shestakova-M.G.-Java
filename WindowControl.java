import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class WindowControl extends JPanel{
    private ITransport plane;
    JButton btnCreatePlane = new JButton("Создать самолет");
    JButton btnCreateSeaPlane=new JButton("Создать гидросамолет");
    JButton btnUp = new JButton(new ImageIcon("src/up.png"));
    JButton btnDown = new JButton(new ImageIcon("src/down.png"));
    JButton btnLeft = new JButton(new ImageIcon("src/left.png"));
    JButton btnRight = new JButton(new ImageIcon("src/right.png"));

    private void drawAll(){
        plane.DrawTransport(getGraphics());
        paintComponents(getGraphics());
    }

    public class Click implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            String actionStr = event.getActionCommand();
            switch(actionStr){
                case "Up":
                    plane.MoveTransport(Direction.Up);
                    break;
                case "Down":
                    plane.MoveTransport(Direction.Down);
                    break;
                case "Left":
                    plane.MoveTransport(Direction.Left);
                    break;
                case "Right":
                    plane.MoveTransport(Direction.Right);
                    break;
            }
            drawAll();
        }
    }

    public void addButton(JButton btn, int btnX, int btnY, int btnWidth, int btnHeigth){
        btn.setBounds(btnX, btnY, btnWidth, btnHeigth);
        add(btn);
    }
    
    public WindowControl(){
        setBackground(Color.white);
        setLayout(null);

        btnDown.setActionCommand("Down");
        btnUp.setActionCommand("Up");
        btnLeft.setActionCommand("Left");
        btnRight.setActionCommand("Right");

        addButton(btnCreatePlane, 8, 8, 144, 43);
        addButton(btnCreateSeaPlane, 160, 8, 174, 43);
        addButton(btnUp, 709, 372, 30, 30);
        addButton(btnDown, 709, 408, 30, 30);
        addButton(btnLeft, 673, 408, 30, 30);
        addButton(btnRight, 745, 408, 30, 30);

        btnCreatePlane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                plane = new Plane(rand.nextInt(100) + 300, rand.nextInt(1000) + 2000, Color.cyan);
                plane.SetPosition(rand.nextInt(10) + 100, rand.nextInt(50) + 100, getWidth(), getHeight());
                drawAll();
            }
        });

        btnCreateSeaPlane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                plane = new SeaPlane(rand.nextInt(100)+300, rand.nextInt(1000)+2000, Color.cyan, Color.red, true, true);
                plane.SetPosition(rand.nextInt(50)+100, rand.nextInt(50)+100, getWidth(), getHeight());
                drawAll();
            }
        });

        btnDown.addActionListener(new Click());
        btnUp.addActionListener(new Click());
        btnLeft.addActionListener(new Click());
        btnRight.addActionListener(new Click());
    }
}
