package TASK2;

public class Main {
    public static void main(String[] args) {
        // Skor tablosu nesnesi oluşturuyorum
        Scoreboard scoreboard = new Scoreboard();

        // Oyuncuları tabloya ekliyorum
        // Not: Normalde bunları dosyadan okumak daha mantıklı olurdu ama şimdilik manuel ekliyorum :)
        scoreboard.addPlayer(new Player(1, "Ali", 50));
        scoreboard.addPlayer(new Player(2, "Ayşe", 90));
        scoreboard.addPlayer(new Player(3, "Mehmet", 70));
        scoreboard.addPlayer(new Player(4, "Zeynep", 85));
        scoreboard.addPlayer(new Player(5, "Burak", 40));
        scoreboard.addPlayer(new Player(6, "Can", 95));
        scoreboard.addPlayer(new Player(7, "Deniz", 60));
        scoreboard.addPlayer(new Player(8, "Ece", 75));
        scoreboard.addPlayer(new Player(9, "Fatih", 20));
        scoreboard.addPlayer(new Player(10, "Gizem", 65));

        // Sıralamadan önceki hali ekrana basıyorum
        System.out.println("Sıralama öncesi:");
        scoreboard.printScoreboard();

        // Skorları sıralıyorum (küçükten büyüğe değil, büyükten küçüğe!)
        scoreboard.sortScoreboard();

        // Sıralamadan sonraki hali yazdırıyorum
        System.out.println("\nSıralama sonrası (DESC):");
        scoreboard.printScoreboard();


    }
}
