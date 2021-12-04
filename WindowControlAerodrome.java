import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Objects;

public class WindowControlAerodrome extends JPanel{
    private Aerodrome<ITransport, OvalFloat> aerodrome;
    JButton btnParkingPlane = new JButton("<html>Поставить<br>самолет");
    JButton btnParkingSeaplane = new JButton("<html>Поставить<br>гидросамолет");
    JButton btnTake = new JButton("Забрать");
    JLabel labelTake = new JLabel("Забрать самолет:");
    JLabel labelPlace = new JLabel("Место: ");
    JFormattedTextField txtIndexPlace;
    private ITransport plane;
    CanvasPlane canvasPlane = new CanvasPlane();

    private void Draw(Graphics g){
        aerodrome.Draw(g);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Draw(g);
    }

    public void addButton(JComponent btn, int btnX, int btnY, int btnWidth, int btnHeigth){
        btn.setBounds(btnX, btnY, btnWidth, btnHeigth);
        add(btn);
    }

    public WindowControlAerodrome(){
        aerodrome = new Aerodrome<ITransport, OvalFloat>(1100, 664);
        canvasPlane.setModal(true);
        setBackground(Color.white);
        setLayout(null);
        addButton(labelTake, 1040, 170, 189, 17);
        addButton(labelPlace, 1050, 200, 57, 18);
        addButton(btnParkingPlane, 1041, 12, 149, 62);
        addButton(btnParkingSeaplane, 1041, 95, 149, 62);
        addButton(btnTake, 1070, 240, 95, 31);
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setAllowsInvalid(false);
        txtIndexPlace = new JFormattedTextField(formatter);
        addButton(txtIndexPlace, 1110, 200, 42, 22);

        btnParkingPlane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color mainColor = JColorChooser.showDialog( WindowControlAerodrome.this, "Выберите цвет самолета", Color.BLUE );
                if (mainColor != null) {
                    plane = new Plane(100, 1000, mainColor);
                    if (aerodrome.addPlane(plane) >-1) {
                        repaint();
                    } else {
                        JOptionPane.showMessageDialog(WindowControlAerodrome.this, "Аэродром переполнен", "Сообщение", JOptionPane.INFORMATION_MESSAGE );
                    }
                }
            }
        });
        btnParkingSeaplane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color mainColor = JColorChooser.showDialog( WindowControlAerodrome.this, "Выберите цвет гидросамолета", Color.BLUE );
                if(mainColor!=null){
                    Color dopColor = JColorChooser.showDialog( WindowControlAerodrome.this, "Выберите цвет гидросамолета", Color.BLUE );
                    if(dopColor!=null){
                        plane = new SeaPlane(100, 1000, mainColor, dopColor,
                                true, true);
                        if ((aerodrome.addPlane(plane)>-1))
                        {
                            repaint();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(WindowControlAerodrome.this, "Аэродром переполнен", "Сообщение", JOptionPane.INFORMATION_MESSAGE );
                        }
                    }
                }
            }
        });
        btnTake.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Objects.equals(txtIndexPlace.getText(),""))
                {
                    plane = aerodrome.remove(Integer.parseInt(txtIndexPlace.getText()));
                    if (plane != null)
                    {
                        canvasPlane.SetPlane(plane);
                        canvasPlane.setVisible(true);

                    }
                    else
                        JOptionPane.showMessageDialog(WindowControlAerodrome.this , "Парковочное место пусто", "Сообщение", JOptionPane.INFORMATION_MESSAGE );
                    repaint();
                }
            }
        });
    }
}