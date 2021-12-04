import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class WindowPlaneConfig extends JFrame{
    JPanel panel=new JPanel();
    private Vehicle plane;
    PanelShowPlane panelShowPlane=new PanelShowPlane();
    JLabel labelCharacteristics = new JLabel("");
    JPanel panelPlaneType=new JPanel(new FlowLayout( FlowLayout.CENTER, 10, 10 ));
    JPanel panelParameters=new JPanel(new FlowLayout( FlowLayout.CENTER, 10, 10 ));
    JPanel panelColors=new JPanel(new GridLayout( 5, 2, 0, 2 ));
    JLabel labelPlane = new JLabel("Самолет");
    JLabel labelSeaplane = new JLabel("Гидросамолет");
    JLabel mainColor = new JLabel("Основной цвет");
    JLabel dopColor = new JLabel("Доп. цвет");
    JLabel labeltypesFloats = new JLabel("Виды поплавков");
    JLabel labelOvalF = new JLabel("Овальные");
    JLabel labelLineF = new JLabel("Прямые");
    JLabel labelSquareF = new JLabel("Квадратные");
    JCheckBox checkBoxScrew = new JCheckBox("Винт");
    JCheckBox checkBoxFloats = new JCheckBox("Поплавки");
    JLabel labelMaxSpeed=new JLabel("Макс. скорость");
    JSpinner spinnerMaxSpeed = new JSpinner(new SpinnerNumberModel(100, 100, 1000, 1));
    JLabel labelWeight=new JLabel("Вес самолета");
    JSpinner spinnerWeight = new JSpinner(new SpinnerNumberModel(100, 100, 1000, 1));
    JButton btnAddPlane = new JButton("Добавить");
    JButton btnCloseWindow = new JButton("Отмена");

    public void componentAdd(JComponent jComponent, int x, int y, int width, int height) {
        jComponent.setBounds(x, y, width, height);
        panel.add(jComponent);
    }
    WindowPlaneConfig(WindowControlAerodrome wControlAerodrome){
        setTitle("Выбор самолета");
        setSize(875, 490);
        setLocation(500, 200);
        add(panel);
        panel.setBackground(Color.white);
        panel.setLayout(null);

        Border border = BorderFactory.createLineBorder(new Color(0, 0, 0));
        labelPlane.setBorder(border);
        labelSeaplane.setBorder(border);
        panelShowPlane.setBorder(border);
        mainColor.setBorder(border);
        dopColor.setBorder(border);
        labeltypesFloats.setBorder(border);
        labelOvalF.setBorder(border);
        labelLineF.setBorder(border);
        labelSquareF.setBorder(border);

        componentAdd(labelPlane, 45, 55, 100, 35);
        componentAdd(labelSeaplane, 45, 115, 100, 33);
        panelPlaneType.setBorder(BorderFactory.createTitledBorder("Тип самолета"));
        panelPlaneType.setBackground(Color.white);
        componentAdd(panelPlaneType, 12, 33, 200,148);
        componentAdd(panelShowPlane, 236, 12, 265, 204);
        componentAdd(labelCharacteristics, 236, 12, 265, 204);
        componentAdd(mainColor, 528, 34, 145, 30);
        componentAdd(dopColor, 698, 34, 121, 30);
        componentAdd(checkBoxScrew, 302, 261, 92, 24);
        checkBoxScrew.setBackground(Color.white);
        checkBoxScrew.setSelected(true);
        componentAdd(checkBoxFloats, 302, 313, 99, 24);
        checkBoxFloats.setBackground(Color.white);
        checkBoxFloats.setSelected(true);
        componentAdd(labelMaxSpeed, 12, 265, 142, 20);
        componentAdd(spinnerMaxSpeed, 83, 302, 83, 27);
        componentAdd(labelWeight,17, 346, 101, 20 );
        componentAdd(spinnerWeight, 83, 381, 83, 27);
        panelParameters.setBorder(BorderFactory.createTitledBorder( "Параметры" ));
        panelParameters.setBackground(Color.white);
        componentAdd(panelParameters, 12, 222, 400, 198);
        componentAdd(labeltypesFloats, 490, 232, 100, 20);
        componentAdd(labelOvalF, 490, 272, 100, 30);
        componentAdd(labelLineF, 490, 312, 100, 30);
        componentAdd(labelSquareF, 490, 352, 100, 30);
        componentAdd(btnAddPlane, 726, 261, 93, 40);
        componentAdd(btnCloseWindow, 726, 346, 93, 40);

        JPanel panelMainCyan=new JPanel();
        panelMainCyan.setBackground(Color.cyan);
        panelMainCyan.setBorder(border);
        componentAdd(panelMainCyan, 528, 87, 50, 50);
        JPanel panelMainPink=new JPanel();
        panelMainPink.setBackground(Color.magenta);
        panelMainPink.setBorder(border);
        componentAdd(panelMainPink, 600, 87, 50, 50);
        JPanel panelMainGreen=new JPanel();
        panelMainGreen.setBackground(Color.green);
        panelMainGreen.setBorder(border);
        componentAdd(panelMainGreen, 528, 146, 50, 50);
        JPanel panelMainOrange=new JPanel();
        panelMainOrange.setBackground(Color.orange);
        panelMainOrange.setBorder(border);
        componentAdd(panelMainOrange, 600, 146, 50, 50);

        JPanel panelDopBlue=new JPanel();
        panelDopBlue.setBackground(Color.blue);
        panelDopBlue.setBorder(border);
        componentAdd(panelDopBlue, 698, 87, 50, 50);
        JPanel panelDopGray=new JPanel();
        panelDopGray.setBackground(Color.gray);
        panelDopGray.setBorder(border);
        componentAdd(panelDopGray, 769, 87, 50, 50);
        JPanel panelDopBlack=new JPanel();
        panelDopBlack.setBackground(Color.black);
        panelDopBlack.setBorder(border);
        componentAdd(panelDopBlack, 698, 146, 50, 50);
        JPanel panelDopRed=new JPanel();
        panelDopRed.setBackground(Color.red);
        panelDopRed.setBorder(border);
        componentAdd(panelDopRed, 769, 146, 50, 50);
        panelColors.setBorder(BorderFactory.createTitledBorder( "Цвета" ));
        panelColors.setBackground(Color.white);
        componentAdd(panelColors, 522, 12, 323, 200);

        var typeDragMouseAdapter = new DragMouseAdapter();
        var colorDragMouseAdapter = new DragMouseAdapter();
        var floatsDragMouseAdapter = new DragMouseAdapter();
        labelPlane.addMouseListener(typeDragMouseAdapter);
        labelPlane.setTransferHandler(new TransferHandler("text"));
        labelSeaplane.addMouseListener(typeDragMouseAdapter);
        labelSeaplane.setTransferHandler(new TransferHandler("text"));
        mainColor.addMouseListener(colorDragMouseAdapter);
        mainColor.setTransferHandler(new TransferHandler("background"));
        dopColor.addMouseListener(colorDragMouseAdapter);
        dopColor.setTransferHandler(new TransferHandler("background"));
        labelOvalF.addMouseListener(floatsDragMouseAdapter);
        labelOvalF.setTransferHandler(new TransferHandler("text"));
        labelOvalF.setDropTarget(null);
        labelLineF.addMouseListener(floatsDragMouseAdapter);
        labelLineF.setTransferHandler(new TransferHandler("text"));
        labelLineF.setDropTarget(null);
        labelSquareF.addMouseListener(floatsDragMouseAdapter);
        labelSquareF.setTransferHandler(new TransferHandler("text"));
        labelSquareF.setDropTarget(null);
        labeltypesFloats.addMouseListener(floatsDragMouseAdapter);
        labeltypesFloats.setTransferHandler(new TransferHandler("text"));
        panelMainCyan.addMouseListener(colorDragMouseAdapter);
        panelMainCyan.setTransferHandler(new TransferHandler("background"));
        panelMainCyan.setDropTarget(null);
        panelMainPink.addMouseListener(colorDragMouseAdapter);
        panelMainPink.setTransferHandler(new TransferHandler("background"));
        panelMainPink.setDropTarget(null);
        panelMainGreen.addMouseListener(colorDragMouseAdapter);
        panelMainGreen.setTransferHandler(new TransferHandler("background"));
        panelMainGreen.setDropTarget(null);
        panelMainOrange.addMouseListener(colorDragMouseAdapter);
        panelMainOrange.setTransferHandler(new TransferHandler("background"));
        panelMainOrange.setDropTarget(null);
        panelDopBlue.addMouseListener(colorDragMouseAdapter);
        panelDopBlue.setTransferHandler(new TransferHandler("background"));
        panelDopBlue.setDropTarget(null);
        panelDopBlack.addMouseListener(colorDragMouseAdapter);
        panelDopBlack.setTransferHandler(new TransferHandler("background"));
        panelDopBlack.setDropTarget(null);
        panelDopGray.addMouseListener(colorDragMouseAdapter);
        panelDopGray.setTransferHandler(new TransferHandler("background"));
        panelDopGray.setDropTarget(null);
        panelDopRed.addMouseListener(colorDragMouseAdapter);
        panelDopRed.setTransferHandler(new TransferHandler("background"));
        panelDopRed.setDropTarget(null);
        labelCharacteristics.addMouseListener(typeDragMouseAdapter);
        labelCharacteristics.setTransferHandler(new TransferHandler("text"));

        PropertyChangeListener typeListener=propertyChangeEvent ->{
            if(Objects.equals(labelCharacteristics.getText(), "Самолет")){
                setPlane();
            }
            if(Objects.equals(labelCharacteristics.getText(), "Гидросамолет")){
                setSeaPlane();
            }
            labelCharacteristics.setText("");
        };
        PropertyChangeListener mainColorListener=propertyChangeEvent ->{
            if(plane!=null){
                plane.setMainColor(mainColor.getBackground());
                panelShowPlane.setPlane(plane);
                repaint();
            }
        };
        PropertyChangeListener dopColorListener=propertyChangeEvent ->{
            if(plane!=null && plane.getClass().getSimpleName().equals("SeaPlane")){
                SeaPlane tmpPlane=(SeaPlane)plane;
                tmpPlane.setDopColor(dopColor.getBackground());
                plane=tmpPlane;
                panelShowPlane.setPlane(plane);
                repaint();
            }
        };
        PropertyChangeListener typesFloatsListener=propertyChangeEvent ->{
            if(plane!=null && plane.getClass().getSimpleName().equals("SeaPlane")){
                SeaPlane tmpPlane=(SeaPlane)plane;
                if(Objects.equals(labeltypesFloats.getText(), "Овальные")){
                    tmpPlane.setFloats(new OvalFloat());
                }
                if(Objects.equals(labeltypesFloats.getText(), "Прямые")){
                    tmpPlane.setFloats(new LineFloat());
                }
                if(Objects.equals(labeltypesFloats.getText(), "Квадратные")){
                    tmpPlane.setFloats(new SquareFloat());
                }
                plane=tmpPlane;
                panelShowPlane.setPlane(plane);
                repaint();
            }
        };
        labelCharacteristics.addPropertyChangeListener("text", typeListener);
        mainColor.addPropertyChangeListener("background", mainColorListener);
        dopColor.addPropertyChangeListener("background", dopColorListener);
        labeltypesFloats.addPropertyChangeListener("text", typesFloatsListener);
        btnCloseWindow.addActionListener(actionEvent -> dispose());
        btnAddPlane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(plane!=null){
                    wControlAerodrome.addPlane(plane);
                }
                dispose();
            }
        });
    }
    public void setPlane(){
        plane = new Plane((Integer)spinnerMaxSpeed.getValue(), (Integer)spinnerWeight.getValue(), mainColor.getBackground());
        panelShowPlane.setPlane(plane);
        panelShowPlane.getPlane().SetPosition(10, 10, 200, 200);
        repaint();
    }
    public void setSeaPlane(){
        plane = new SeaPlane((Integer)spinnerMaxSpeed.getValue(), (Integer)spinnerWeight.getValue(),
                mainColor.getBackground(), dopColor.getBackground(), checkBoxFloats.isSelected(), checkBoxScrew.isSelected());
        panelShowPlane.setPlane(plane);
        panelShowPlane.getPlane().SetPosition(10, 10, 200, 200);
        repaint();
    }
}
