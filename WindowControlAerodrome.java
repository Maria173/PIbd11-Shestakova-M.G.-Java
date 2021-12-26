import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Objects;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Queue;
import java.util.LinkedList;

public class WindowControlAerodrome extends JPanel{
    private Queue<ITransport> queueAerodromeRemovePlane = new LinkedList<ITransport>();
    private AerodromeCollection aerodromeCollection;
    private DefaultListModel<String> defListModelAerodromes = new DefaultListModel<String>();
    JList<String> jListAerodromes;
    JLabel labelAerodromes = new JLabel("Аэродромы");
    JTextField txtAerodromeName = new JTextField();
    JButton btnAddAerodrome = new JButton("Добавить аэродром");
    JButton btnRemoveAerodrome = new JButton("Удалить аэродром");
    JButton btnShowPlane = new JButton("Показать");
    JButton btnAddPlane = new JButton("<html>Добавить<br>самолет");
    JButton btnTake = new JButton("Забрать");
    JLabel labelTake = new JLabel("Забрать самолет:");
    JLabel labelPlace = new JLabel("Место: ");
    JFormattedTextField txtIndexPlace;
    private ITransport plane;
    CanvasPlane canvasPlane = new CanvasPlane();
    WindowPlaneConfig windowPlaneConfig;

    private void Draw(Graphics g){
        if(jListAerodromes.getSelectedValue()!=null){
            aerodromeCollection.getAerodrome(jListAerodromes.getSelectedValue()).Draw(g);
        }
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Draw(g);
    }

    protected void configPlane(){
        windowPlaneConfig=new WindowPlaneConfig(this);
        windowPlaneConfig.setVisible(true);
    }
    public void addPlane(ITransport pl){
        if((aerodromeCollection.getAerodrome(jListAerodromes.getSelectedValue()).addPlane(pl))>-1){
            repaint();
        }
        else{
            JOptionPane.showMessageDialog(null, "Аэродром переполнен");
        }
    }

    public void addButton(JComponent btn, int btnX, int btnY, int btnWidth, int btnHeigth){
        btn.setBounds(btnX, btnY, btnWidth, btnHeigth);
        add(btn);
    }

    public class listBoxChangeListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            repaint();
        }
    }
    public void ReloadAerodromes(){
        int index = jListAerodromes.getSelectedIndex();
        defListModelAerodromes.clear();
        for (int i = 0; i < aerodromeCollection.keys().size(); i++){
            defListModelAerodromes.addElement(aerodromeCollection.keys().get(i));
        }
        if (defListModelAerodromes.size() > 0 && (index == -1 || index >= defListModelAerodromes.size())){
            jListAerodromes.setSelectedIndex(0);
        }
        else{
            if (defListModelAerodromes.size() > 0 && index > -1 && index < defListModelAerodromes.size()){
                jListAerodromes.setSelectedIndex(index);
            }
        }
    }

    public WindowControlAerodrome(){
        aerodromeCollection = new AerodromeCollection(1100, 664);
        canvasPlane.setModal(true);
        setBackground(Color.white);
        setLayout(null);
        addButton(labelAerodromes, 1070, 9, 59, 17);
        addButton(txtAerodromeName, 1018, 35, 172, 22);
        addButton(btnAddAerodrome, 1018, 63, 172, 32);
        jListAerodromes = new JList<String>(defListModelAerodromes);
        jListAerodromes.setPrototypeCellValue("Установленный размер");
        jListAerodromes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jListAerodromes.addListSelectionListener(new listBoxChangeListener());
        addButton(new JScrollPane(jListAerodromes), 1018, 101, 172, 116);
        addButton(btnRemoveAerodrome, 1018, 223, 172, 32);
        addButton(labelTake, 1020, 427, 189, 17);
        addButton(labelPlace, 1030, 457, 57, 18);
        addButton(btnAddPlane, 1021, 272, 149, 62);
        addButton(btnTake, 1050, 507, 95, 31);
        addButton(btnShowPlane, 1050, 560, 95, 31);
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setAllowsInvalid(false);
        txtIndexPlace = new JFormattedTextField(formatter);
        addButton(txtIndexPlace, 1110, 457, 42, 22);

        btnAddPlane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                configPlane();
            }
        });
        btnTake.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Objects.equals(txtIndexPlace.getText(),""))
                {
                    plane = aerodromeCollection.getAerodrome(jListAerodromes.getSelectedValue()).remove(Integer.parseInt(txtIndexPlace.getText()));
                    if (plane != null)
                    {
                        queueAerodromeRemovePlane.add(plane);
                    }
                    repaint();
                }
            }
        });
        btnShowPlane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(queueAerodromeRemovePlane.size()>0){
                    canvasPlane.SetPlane(queueAerodromeRemovePlane.poll());
                    canvasPlane.setVisible(true);
                }
            }
        });
        btnAddAerodrome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtAerodromeName.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Введите название аэродрома", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    aerodromeCollection.AddAerodrome(txtAerodromeName.getText());
                    ReloadAerodromes();
                }
            }
        });
        btnRemoveAerodrome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jListAerodromes.getSelectedValue()!=null){
                    if(JOptionPane.showConfirmDialog(null, "Удалить аэродром " + jListAerodromes.getSelectedValue() + "?") == 0){
                        aerodromeCollection.DelAerodrome(jListAerodromes.getSelectedValue());
                        ReloadAerodromes();
                    }
                }
            }
        });

    }
}