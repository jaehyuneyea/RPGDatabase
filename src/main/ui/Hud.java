package ui;

import model.interactables.Dragon;
import model.interactables.MainCharacter;
import model.interactables.Slime;
import model.items.HealthPotion;
import model.items.Inventory;
import model.items.IronSword;
import model.items.WoodenSword;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hud {
    private static final int BUTTON_WIDTH = 135;
    private static final int BUTTON_HEIGHT = 30;
    //    https://stackoverflow.com/questions/1842223/java-linebreaks-in-jlabels
    private static final String HTML_LINE_BREAK_1 = "<html><p style=\"width:350px\">";
    private static final String HTML_LINE_BREAK_2 = "</p></html>";
    JPanel panel1;
    JPanel panel2;
    JButton toInv;
    JButton toItems;
    JButton toMonsters;
    Border grayline = BorderFactory.createLineBorder(Color.GRAY, 3);
    JPanel inventoryPanel;
    JPanel startMenu;
    JPanel initPanel;
    JPanel itemsPanel;
    JPanel monstersPanel;
    JButton startButton;
    JButton twoToOne;
    JButton addInvWS;
    JButton addInvIS;
    JButton addInvHP;
    JButton equipIS;
    JButton equipWS;
    CardLayout cl;
    Slime slime;
    Dragon dragon;
    WoodenSword woodenSword;
    IronSword ironSword;
    HealthPotion healthPotion;
    MainCharacter mc = new MainCharacter("You", 10, 10);
    Inventory inv = new Inventory();
    JLabel panelDetail;
    JLabel panelImage;
    JLabel inventorySideText;
    JLabel inventorySideText2;
    String[] items = inv.getInventoryName().toArray(new String[inv.length()]);
    JList inventoryList = new JList(items);
    ImageIcon icon = new ImageIcon("./data/connor.png");
    Sprite sprite = new Sprite();


    public void initializeEntity() {
        slime = new Slime();
        dragon = new Dragon();
    }

    public void initializeItems() {
        woodenSword = new WoodenSword();
        ironSword = new IronSword();
        healthPotion = new HealthPotion();
    }


    public void initializeButtons() {
        toItems = new JButton();
        toInv = new JButton();
        toMonsters = new JButton();
        addInvHP = new JButton();
        addInvIS = new JButton();
        addInvWS = new JButton();
        equipIS = new JButton();
        equipWS = new JButton();
    }

    public void initializeHud() {
        panel1 = new JPanel();
        panel2 = new JPanel();
    }

    public void initializeLabels() {
        panelDetail = new JLabel();
        panelImage = new JLabel();
        inventorySideText = new JLabel();
        inventorySideText2 = new JLabel();

    }

    public void setDetailPanel() {
        panelDetail.setText(HTML_LINE_BREAK_1 + "Welcome! Have a look around." + HTML_LINE_BREAK_2);
        panelAlignment();
    }

    private void panelAlignment() {
        panelDetail.setFont(new Font("Arial", Font.BOLD, 15));
        panelDetail.setBorder(new EmptyBorder(25, 0, 0, 0));
        panelDetail.setHorizontalAlignment(SwingConstants.LEFT);
        panel2.add(panelDetail);
    }

    public void setImageText() {
        panelImage.setFont(new Font("Calibri", Font.BOLD, 20));
        panelImage.setVerticalTextPosition(JLabel.TOP);
        panelImage.setHorizontalTextPosition(JLabel.CENTER);
    }

    public void setPanel() {
        initializeLabels();
        initializeHud();
        setPanelColors();

        setPanelDimensions();

        setSidePanelButtons();
        setDetailPanel();
        setImageText();

        panel1.setVisible(false);
        panel2.setVisible(false);
    }

    private void setSidePanelButtons() {
        setInvButton();
        setItemsButton();
        setMonstersButton();
    }

    private void setPanelColors() {
        panel1.setBackground(Color.WHITE);
        panel2.setBackground(Color.WHITE);
        panel1.setBorder(grayline);
        panel2.setBorder(grayline);
    }

    private void setPanelDimensions() {
        panel1.setPreferredSize(new Dimension(150, 100));
        panel2.setPreferredSize(new Dimension(100, 220));
    }


    public void initializeTransitionPanels() {
        initPanel = new JPanel();
        startMenu = new JPanel();
        inventoryPanel = new JPanel(new BorderLayout());
        monstersPanel = new JPanel(new BorderLayout());
        itemsPanel = new JPanel(new BorderLayout());

        startButton = new JButton();
        twoToOne = new JButton();

        cl = new CardLayout();
    }

    public void addStartButton() {
        initPanel.setLayout(cl);
        startMenu.add(startButton);
        startButton.setText("Start!");
        startButton.setVerticalAlignment(JButton.CENTER);
        startButton.setFont(new Font("Arial", Font.BOLD, 30));
        startButton.setBounds(100, 200, 100, 50);
    }

    public void setTransitionPanel() {
        initializeTransitionPanels();
        initializeButtons();

        addStartButton();

        startMenu.setBackground(Color.GREEN);
        inventoryPanel.setBackground(Color.BLUE);
        itemsPanel.setBackground(Color.RED);
        setMonsterPanel();
        setItemPanel();
        setInventoryPanel();

        initPanel.add(startMenu, "1");
        initPanel.add(inventoryPanel, "2");
        initPanel.add(itemsPanel, "3");
        initPanel.add(monstersPanel, "4");
        cl.show(initPanel, "1");

        buttonActionListeners();
    }

    private void setInventoryPanel() {

        JPanel inventorySidePanel = new JPanel();
        inventoryPanel.add(inventoryList);
        inventorySideText.setText("Health: " + mc.getMaxHealth() + " Atk: " + mc.getAttack());
        inventorySideText2.setText("Currently Equipped: " + mc.getCurrentlyEquipped());
        inventoryList.setVisible(true);

        inventorySidePanel.setPreferredSize(new Dimension(250, 100));
        inventorySidePanel.setBorder(grayline);
        inventoryPanel.setBorder(grayline);
        inventorySidePanel.add(inventorySideText);
        inventorySidePanel.add(inventorySideText2);
        inventoryPanel.add(inventorySidePanel, BorderLayout.WEST);
        inventoryPanel.setBackground(Color.LIGHT_GRAY);

    }


    private void setItemPanel() {
        JPanel itemSidePanel = new JPanel();
        JButton buttonWoodenSword = new JButton();
        JButton buttonIronSword = new JButton();
        JButton buttonHealthPotion = new JButton();

        initializeLabels();
        initializeItems();

        setHealthPotionButton(itemSidePanel, buttonHealthPotion);

        setWoodenSwordButton(itemSidePanel, buttonWoodenSword);

        setIronSwordButton(itemSidePanel, buttonIronSword);

        itemSidePanel.setPreferredSize(new Dimension(150, 100));
        itemSidePanel.setBorder(grayline);
        itemsPanel.setBorder(grayline);
        itemsPanel.add(itemSidePanel, BorderLayout.WEST);
        itemsPanel.setBackground(Color.LIGHT_GRAY);
    }

    private void setIronSwordButton(JPanel itemSidePanel, JButton buttonIronSword) {
        itemSidePanel.add(buttonIronSword);
        buttonIronSword.setText(ironSword.getName());
        buttonIronSword.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        ironSwordActionListener(buttonIronSword);
    }

    private void setWoodenSwordButton(JPanel itemSidePanel, JButton buttonWoodenSword) {
        itemSidePanel.add(buttonWoodenSword);
        buttonWoodenSword.setText(woodenSword.getName());
        buttonWoodenSword.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        woodenSwordActionListener(buttonWoodenSword);
    }

    private void setHealthPotionButton(JPanel itemSidePanel, JButton buttonHealthPotion) {
        itemSidePanel.add(buttonHealthPotion);
        buttonHealthPotion.setText(healthPotion.getName());
        buttonHealthPotion.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        healthPotionActionListener(buttonHealthPotion);
    }

    private void setMonsterPanel() {
        JPanel monsterSidePanel = new JPanel();
        JButton buttonSlime = new JButton();
        JButton buttonDragon = new JButton();
        initializeEntity();

        monsterSidePanel.setPreferredSize(new Dimension(150, 100));
        monsterSidePanel.setBorder(grayline);

        setSlimeButton(monsterSidePanel, buttonSlime);

        setDragonButton(monsterSidePanel, buttonDragon);
        monstersPanel.setBorder(grayline);
        monstersPanel.add(monsterSidePanel, BorderLayout.WEST);
        monstersPanel.setBackground(Color.LIGHT_GRAY);

    }

    private void setSlimeButton(JPanel monsterSidePanel, JButton buttonSlime) {
        monsterSidePanel.add(buttonSlime);
        buttonSlime.setText(slime.getName());
        buttonSlime.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        slimeActionListener(buttonSlime);
    }

    private void setDragonButton(JPanel monsterSidePanel, JButton buttonDragon) {
        monsterSidePanel.add(buttonDragon);
        buttonDragon.setText(dragon.getName());
        buttonDragon.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        dragonActionListener(buttonDragon);

    }

    private void buttonActionListeners() {
        startButtonActionListener();

        toItemsActionListener();

        toInvActionListener();

        toMonstersActionListener();
    }

    private void setInvButton() {
        panel1.add(toInv);
        toInv.setText("Inventory");
        toInv.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));

    }

    private void setItemsButton() {
        panel1.add(toItems);
        toItems.setText("Items");
        toItems.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));

    }

    private void setMonstersButton() {
        panel1.add(toMonsters);
        toMonsters.setText("Monsters");
        toMonsters.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
    }

    private void ironSwordActionListener(JButton buttonIronSword) {
        buttonIronSword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipIS.setVisible(true);
                addInvHP.setVisible(false);
                addInvWS.setVisible(false);
                equipWS.setVisible(false);
                addInvIS.setVisible(true);
                panelImage.setIcon(sprite.resizeImage(sprite.imgISword));
                panelImage.setText("Atk: " + ironSword.getAttackItem());
                panelDetail.setText(HTML_LINE_BREAK_1 + ironSword.getDetail() + HTML_LINE_BREAK_2);
                setEquipIS();
                setAddInvIS();

                panelAlignment();

                itemsPanel.add(panelImage);
            }
        });
    }

    private void setEquipIS() {
        panel2.add(equipIS);
        equipIS.setText("Equip");
        equipIS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!mc.isEquippedWeapon()) {
                    mc.equip(ironSword);
                    mc.setCurrentlyEquipped(ironSword);
                    JOptionPane.showMessageDialog(null, "Sucessfully equipped!");
                } else {
                    JOptionPane.showMessageDialog(null, "Already equipped weapon!"
                    );
                }
            }
        });
    }

    private void setAddInvIS() {
        panel2.add(addInvIS);
        addInvIS.setText("Add to Inventory");
        addInvIS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inv.addItem(ironSword);
                JOptionPane.showMessageDialog(
                        null, "added to inventory!");
            }
        });
    }

    private void woodenSwordActionListener(JButton buttonWoodenSword) {
        buttonWoodenSword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipIS.setVisible(false);
                addInvHP.setVisible(false);
                addInvIS.setVisible(false);
                equipWS.setVisible(true);
                addInvWS.setVisible(true);
                panelImage.setIcon(sprite.resizeImage(sprite.imgWSword));
                panelImage.setText("Atk: " + woodenSword.getAttackItem());
                panelDetail.setText(HTML_LINE_BREAK_1 + woodenSword.getDetail() + HTML_LINE_BREAK_2);
                setEquipWS();
                setAddInvWS();
                panelAlignment();

                itemsPanel.add(panelImage);

            }
        });
    }

    private void setEquipWS() {
        panel2.add(equipWS);
        equipWS.setText("Equip");
        equipWS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!mc.isEquippedWeapon()) {
                    mc.setCurrentlyEquipped(woodenSword);
                    mc.equip(woodenSword);
                    JOptionPane.showMessageDialog(
                            null, "Successfully equiped!"
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            null, "Already equipped weapon!"

                    );
                }
            }
        });

    }

    private void setAddInvWS() {
        addInvWS.setText("Add to Inventory");
        panel2.add(addInvWS);
        addInvWS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inv.addItem(woodenSword);
                JOptionPane.showMessageDialog(
                        null, "added to inventory!");
            }
        });
    }

    private void healthPotionActionListener(JButton buttonHealthPotion) {
        buttonHealthPotion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipIS.setVisible(false);
                equipWS.setVisible(false);
                addInvHP.setVisible(true);
                addInvWS.setVisible(false);
                addInvIS.setVisible(false);
                panelImage.setIcon(sprite.resizeImage(sprite.imgHealth));
                panelImage.setText("Heal Amount: " + healthPotion.HEAL_VALUE);
                panelDetail.setText(HTML_LINE_BREAK_1 + healthPotion.getDetail() + HTML_LINE_BREAK_2);
                setAddInvHP();
                panelAlignment();


                itemsPanel.add(panelImage);
            }
        });
    }

    private void setAddInvHP() {
        panel2.add(addInvHP);
        addInvHP.setText("Add to Inventory");
        addInvHP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inv.addItem(healthPotion);
                JOptionPane.showMessageDialog(
                        null, "added to inventory!");
            }
        });
    }

    private void slimeActionListener(JButton buttonSlime) {
        buttonSlime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelImage.setIcon(sprite.resizeImage(sprite.imgSlime));
                panelImage.setText("<html>HP: " + slime.getMaxHealth() + "<br/>Atk: " + slime.getAttack() + "<html>");
                panelDetail.setText(HTML_LINE_BREAK_1 + slime.getDetail() + HTML_LINE_BREAK_2);
                panelAlignment();

                monstersPanel.add(panelImage);
            }
        });
    }

    private void dragonActionListener(JButton buttonDragon) {
        buttonDragon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelDetail.setText(HTML_LINE_BREAK_1 + dragon.getDetail() + HTML_LINE_BREAK_2);
                panelImage.setIcon(sprite.resizeImage(sprite.imgDragon));
                panelImage.setText("<html>HP: " + dragon.getMaxHealth() + "<br/>Atk: " + dragon.getAttack() + "<html>");
                panelAlignment();

                monstersPanel.add(panelImage);
            }
        });
    }

    private void toMonstersActionListener() {
        toMonsters.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addInvHP.setVisible(false);
                addInvIS.setVisible(false);
                addInvWS.setVisible(false);
                cl.show(initPanel, "4");
                panelDetail.setText("");
            }
        });
    }

    private void toInvActionListener() {
        toInv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addInvHP.setVisible(false);
                addInvIS.setVisible(false);
                addInvWS.setVisible(false);
                cl.show(initPanel, "2");
                panelDetail.setText("");
            }
        });
    }

    private void toItemsActionListener() {
        toItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addInvHP.setVisible(false);
                addInvIS.setVisible(false);
                addInvWS.setVisible(false);
                cl.show(initPanel, "3");
                panelDetail.setText("");
            }
        });
    }

    private void startButtonActionListener() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(initPanel, "2");
                panel1.setVisible(true);
                panel2.setVisible(true);
            }
        });
    }
}
