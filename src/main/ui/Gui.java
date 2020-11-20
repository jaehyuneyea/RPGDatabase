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
        frame.add(hud.panel2, BorderLayout.SOUTH);
        frame.add(hud.panel1, BorderLayout.WEST);
    }

    //MODIFIES: this
    // EFFECTS: initializes the JSON file
    public void initializeJSon() {
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
    }

    //MODIFIES: this
    // EFFECTS: sets the main JFrame
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

    //MODIFIES: this
    // EFFECTS: initializes the file menu and the icons
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


    //MODIFIES: this
    // EFFECTS: sets transition panel to the JFrame
    public void setTransitionPanels() {
        hud.setTransitionPanel();
        frame.add(hud.initPanel);

    }

    //MODIFIES: this
    // EFFECTS: adds a menu bar at the top
    //          if saveItem saves the game to JSON
    //          if loadItem loads the game from JSON
    //          if exitItem quits the game
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
            hud.model.addElement(hud.inv.getInventoryName());
            hud.inventoryList.setModel(hud.model);
            JOptionPane.showMessageDialog(
                    null, "Successfully loaded!", "Loaded!", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Unable to read from file: " + JSON_STORE);
        }
    }
}
