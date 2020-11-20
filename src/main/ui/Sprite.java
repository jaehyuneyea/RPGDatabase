package ui;

import javax.swing.*;
import java.awt.*;

public class Sprite {
    ImageIcon imgHealth;
    ImageIcon imgISword;
    ImageIcon imgWSword;
    ImageIcon imgSlime;
    ImageIcon imgDragon;

    public Sprite() {
        imgHealth = new ImageIcon("./data/health potion.png");
        imgISword = new ImageIcon("./data/iron sword.png");
        imgWSword = new ImageIcon("./data/wooden sword.png");
        imgSlime = new ImageIcon("./data/slime.png");
        imgDragon = new ImageIcon("./data/dragon.png");

    }

    public ImageIcon resizeImage(ImageIcon i) {
        Image image = i.getImage(); // transforms it
        Image newimg = image.getScaledInstance(180, 200, Image.SCALE_SMOOTH); // scale it
        i = new ImageIcon(newimg);  // change it back
        return i;
    }

    public Icon getSprite(ImageIcon i) {
        return i;
    }
}
