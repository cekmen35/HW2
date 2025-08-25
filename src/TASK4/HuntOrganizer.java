package TASK4;


import ceng201.hw2.treasure.Treasure;
import ceng201.hw2.treasure.TreasureInventory;
import TASK2.Player;
import TASK2.Scoreboard;
import TASK3.HuntRoute;
import TASK3.RoutePlanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// HuntOrganizer: tüm taskları birleştiren sınıf
public class HuntOrganizer {

    private TreasureInventory inventory;
    private Scoreboard scoreboard;
    private RoutePlanner planner;

    public HuntOrganizer() {
        inventory = new TreasureInventory();
        scoreboard = new Scoreboard();
        planner = new RoutePlanner();
    }

    public void loadSampleData() {
        // TASK1 – TreasureInventory
        inventory.add(new Treasure(101, "Golden Cup"));
        inventory.add(new Treasure(102, "Silver Sword"));
        inventory.add(new Treasure(103, "Emerald Ring"));

        // TASK2 – Scoreboard
        scoreboard.addPlayer(new Player("Alice", 95, 12.5, 3));
        scoreboard.addPlayer(new Player("Bob", 120, 10.2, 4));
        scoreboard.addPlayer(new Player("Charlie", 120, 15.0, 5));
        scoreboard.addPlayer(new Player("Diana", 85, 9.8, 2));

        // TASK3 – RoutePlanner
        planner.addRoute(new HuntRoute(101, 2.4, 30));
        planner.addRoute(new HuntRoute(102, 5.7, 20));
        planner.addRoute(new HuntRoute(103, 1.2, 50));
        planner.addRoute(new HuntRoute(104, 7.8, 40));
        planner.addRoute(new HuntRoute(105, 3.5, 25));
        planner.addRoute(new HuntRoute(106, 9.1, 10));
        planner.addRoute(new HuntRoute(107, 4.4, 35));
        planner.addRoute(new HuntRoute(108, 6.6, 15));
    }

    public void runDemos() {
        System.out.println("=== TASK1: TreasureInventory ===");
        inventory.printInventory();

        System.out.println("\n=== TASK2: Scoreboard (QuickSort desc) ===");
        scoreboard.sortScoreboard();
        scoreboard.printScoreboard();

        System.out.println("\n=== TASK3: RoutePlanner (MergeSort asc distance) ===");
        planner.sortRoutes();
        planner.printRoutes();

        System.out.println("\n=== TASK4: Smart Ranking ===");
        List<Player> players = new ArrayList<>(scoreboard.getPlayers());
        Collections.sort(players, new SmartRanker());
        for (Player p : players) {
            System.out.println(p);
        }
    }
}

