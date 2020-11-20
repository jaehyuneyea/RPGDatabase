package ui;

import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

// https://www.youtube.com/watch?v=5o3fMLPY7qY
// https://www.youtube.com/watch?v=Kmgo00avvEw
public class Gui extends JFrame implements ActionListener {

    private static final String JSON_STORE = "./data/inventory.json";

    Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JButton button = new JButton();
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu;
    JMenuItem saveItem;
    JMenuItem loadItem;
    JMenuItem exitItem;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    Hud hud = new Hud();


    public Gui() {
        initializeJSon();
        setJFrame();
        setTransitionPanels();
        setFileMenu();
        hud.setPanel();
        frame.add(hud.panel2,BorderLayout.SOUTH);
        frame.add(hud.panel1,BorderLayout.WEST);



    }

    public void initializeJSon() {
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
    }

    public void setJFrame() {
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
//        frame.setLayout(new FlowLayout());
        frame.setTitle("Test GUI");
        frame.add(button);
        frame.add(label);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);

    }

    public void setJLabel() {
        // image resize from https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
        ImageIcon imageIcon = new ImageIcon("./data/connor.png"); // loads image to a imageIcon
        Image image = imageIcon.getImage(); // transforms it
        Image newimg = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH); // scale it
        imageIcon = new ImageIcon(newimg);  // change it back
        label.setIcon(imageIcon);
        label.setText("Only Pain");
        label.setForeground(Color.GREEN);

        label.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        label.setBackground(Color.black);
        label.setOpaque(true);
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(0, 0, 400, 250);

    }


    public void setFileMenu() {
        fileMenu = new JMenu("File");

        menuBar.add(fileMenu);

        saveItem = new JMenuItem("Save");
        loadItem = new JMenuItem("Load");
        exitItem = new JMenuItem("Exit");

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        saveItem.addActionListener(this);
        loadItem.addActionListener(this);
        exitItem.addActionListener(this);

        ImageIcon saveIcon = new ImageIcon("./data/icons/save.png");
        ImageIcon loadIcon = new ImageIcon("./data/icons/load.png");
        ImageIcon exitIcon = new ImageIcon("./data/icons/exit.png");

        saveItem.setIcon(saveIcon);
        loadItem.setIcon(loadIcon);
        exitItem.setIcon(exitIcon);

    }



    public void setTransitionPanels() {
        hud.setTransitionPanel();
        frame.add(hud.initPanel);

    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveItem) {
            saveInventory();
        }
        if (e.getSource() == loadItem) {
            loadInventory();
        }
        if (e.getSource() == exitItem) {
            System.exit(0);
        }
    }

    // EFFECTS: saves the inventory to file
    private void saveInventory() {
        try {
            jsonWriter.open();
            jsonWriter.write(hud.inv);
            jsonWriter.close();
            JOptionPane.showMessageDialog(
                    null, "Successfully saved!", "Saved!", JOptionPane.PLAIN_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(
                    null, "Unable to read from file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads inventory to file
    private void loadInventory() {
        try {
            hud.inv = jsonReader.read();
            JOptionPane.showMessageDialog(
                    null, "Successfully loaded!", "Loaded!", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Unable to read from file: " + JSON_STORE);
        }
    }
}
