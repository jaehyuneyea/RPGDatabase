package ui;


import model.interactables.*;
import model.items.*;

import java.util.Scanner;

public class GameApp {
    private Slime slime;
    private Dragon dragon;
    private Inventory inventory;
    private HealthPotion healthPotion;
    private WoodenSword woodenSword;
    private IronSword ironSword;
    private MainCharacter mainCharacter;
    private Scanner input;


    // EFFECTS: runs the game application
    public GameApp() {      // structure used from TellerApp
        runGame();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runGame() {
        boolean keepGoing = true;
        String command = null;

        init();
        welcome();

        while (keepGoing) {
            displayMenu();
            command = input.nextLine();
            if (command.equals("5")) {
                System.out.println("Goodbye!");
                keepGoing = false;
            }
            processCommand(command);


        }
    }

    // EFFECTS: displays an initial welcome message
    public void welcome() {
        System.out.println("Welcome! \nI'm hoping this can turn out to be a small RPG game, but as of now");
        System.out.println("I've created a database of all the available entities within the game.");
    }

    // EFFECTS: displays the options the user can choose
    public void displayMenu() {
        System.out.println("Select a number to choose from: ");
        System.out.println("\n 1. Items \n 2. Monsters \n 3. Inventory \n 4. Stats \n 5. Quit");
    }

    // EFFECTS: initializes the objects within the game
    public void init() {
        slime = new Slime();
        dragon = new Dragon();
        inventory = new Inventory();
        healthPotion = new HealthPotion();
        woodenSword = new WoodenSword();
        ironSword = new IronSword();
        mainCharacter = new MainCharacter("Player", 10, 5);
        input = new Scanner(System.in);
        // input structure used from https://www.youtube.com/watch?v=EpB9u4ItOYU&feature=emb_title
    }

    // EFFECTS: displays all the items available within the game
    public void displayItems() {
        System.out.println("1." + healthPotion.getName());
        System.out.println("2." + woodenSword.getName());
        System.out.println("3." + ironSword.getName());
    }

    // MODIFIES: this
    // EFFECTS: processes the user command
    public void processCommand(String command) {
        if (command.equals("1")) {
            itemMenu();
        } else if (command.equals("2")) {
            monsterMenu();
        } else if (command.equals("3")) {
            inventoryMenu();
        } else if (command.equals("4")) {
            statMenu();
        } else {
            System.out.println("invalid command!");
        }
    }

    // EFFECTS: displays the items and further commands
    public void itemMenu() {
        System.out.println("This is the list of items we have so far:");
        displayItems();
        System.out.println("\nSelect the number to get detailed info about them.");
        String command = input.nextLine();

        if (command.equals("1")) {
            displayHealthPotion();     // methods within the GameApp class
        } else if (command.equals("2")) {
            displayWoodenSword();
        } else if (command.equals("3")) {
            displayIronSword();
        }

    }

    // MODIFIES: this
    // EFFECTS: takes the item and inserts into the inventory
    public void itemTake(Item i) {
        inventory.addItem(i);
        System.out.println("You put a " + i.getName() + " into your inventory.");
    }

    // EFFECTS: displays the monsters available within the game
    public void displayMonsters() {
        System.out.println("1. " + slime.getName());
        System.out.println("2. " + dragon.getName());
    }

    // EFFECTS: displays the menu of monsters and further commands
    public void monsterMenu() {
        String command = null;
        System.out.println("These are the monsters available in the game so far:");
        displayMonsters();
        System.out.println("\nSelect the number to get detailed info about them.");
        command = input.nextLine();

        if (command.equals("1")) {
            System.out.println(slime.getName() + "\n" + slime.getDetail());
            System.out.println("Health: " + slime.getMaxHealth() + "\nAttack: " + slime.getAttack());
        } else if (command.equals("2")) {
            System.out.println(dragon.getName() + "\n" + dragon.getDetail());
            System.out.println("Health: " + dragon.getMaxHealth() + "\nAttack: " + dragon.getAttack());
        }

    }

    // EFFECTS: displays the health potion's detail and further commands with them
    public void displayHealthPotion() {
        String command = null;
        System.out.println(healthPotion.getName() + "\n" + healthPotion.getDetail());
        System.out.println("\nType 'take' to insert into your inventory, or 'quit' to exit");
        command = input.nextLine();

        if (command.equals("take")) {
            itemTake(healthPotion);
        } else {
            System.out.println("invalid command!");
        }
    }

    // EFFECTS: displays the wooden sword's detail and further commands with them
    public void displayWoodenSword() {
        String command = null;
        displayWeaponDetail(woodenSword);
        command = input.nextLine();

        if (command.equals("take")) {
            itemTake(woodenSword);
        } else if (command.equals("equip")) {
            equipWeapon(woodenSword);

        } else {
            System.out.println("invalid command!");
        }
    }

    // EFFECTS: displays the iron sword's detail and further commands with them
    public void displayIronSword() {
        String command = null;
        displayWeaponDetail(ironSword);
        command = input.nextLine();

        if (command.equals("take")) {
            itemTake(ironSword);
        } else if (command.equals("equip")) {
            equipWeapon(ironSword);

        } else {
            System.out.println("invalid command!");
        }
    }

    // EFFECTS: displays all the items you have in your inventory
    public void inventoryMenu() {
        String command = null;
        System.out.println("These are the items in your inventory: ");
        System.out.println(inventory.getInventoryName());
        System.out.println("Type 'clear' to clear the inventory.");
        command = input.nextLine();
        if (command.equals("clear")) {
            inventory.clearInv();
            System.out.println("Inventory cleared!");
        } else {
            System.out.println("invalid command!");
        }
    }

    // EFFECTS: displays the player's stat
    public void statMenu() {
        System.out.println("These are your stats:");
        System.out.println("HP: " + mainCharacter.getMaxHealth());
        System.out.println("Attack: " + mainCharacter.getAttack());
        if (mainCharacter.isEquippedWeapon()) {
            System.out.println("You have currently equipped: " + mainCharacter.getCurrentlyEquipped());
        } else {
            System.out.println("You have currently equipped nothing.");
        }

    }

    // MODIFIES: this
    // EFFECTS: equips the weapon onto the user, doesn't if already equipped
    public void equipWeapon(Weapon w) {
        if (mainCharacter.isEquippedWeapon()) {
            System.out.println("You've already equipped a weapon!");
        } else {
            mainCharacter.equip(w);
            System.out.println("You equipped " + w.getName());
        }
    }

    // EFFECTS: displays the weapon's details and further commands
    public void displayWeaponDetail(Weapon w) {
        System.out.println(w.getName() + "\n" + w.getDetail());
        System.out.println("Attack: " + w.getAttackItem());
        System.out.println("\nType 'take' to insert into your inventory, 'equip' to equip or 'quit' to exit");
    }
}
