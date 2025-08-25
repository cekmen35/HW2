package edu.thk.ceng201.hw2;

import ceng201.hw2.treasure.Treasure;
import ceng201.hw2.treasure.TreasureInventory;

public class Main {
    public static void main(String[] args) {
        runTask1Demo();
    }

    private static void runTask1Demo() {
        TreasureInventory inv = new TreasureInventory();

        // 5 hazine ekle
        inv.addTreasure(new Treasure(1, "Golden Amulet", 100));
        inv.addTreasure(new Treasure(2, "Silver Coin", 50));
        inv.addTreasure(new Treasure(3, "Ancient Map", 70));
        inv.addTreasure(new Treasure(4, "Emerald Ring", 90));
        inv.addTreasure(new Treasure(5, "Bronze Idol", 40));

        // Birini sil (ör. id=3)
        boolean removed = inv.removeTreasure(3);
        System.out.println("remove(3) -> " + removed);

        // Var olan ve olmayan için arama
        System.out.println("find(4) -> " + inv.findTreasure(4));
        System.out.println("find(99) -> " + inv.findTreasure(99));

        // Envanteri yazdır
        System.out.println("== INVENTORY ==");
        inv.printInventory();
    }
}


