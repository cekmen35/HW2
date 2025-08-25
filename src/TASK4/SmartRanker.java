package TASK4;



import TASK2.Player;
import java.util.Comparator;

public class SmartRanker implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        if (p1.getScore() != p2.getScore())
            return Integer.compare(p2.getScore(), p1.getScore()); // score desc
        if (p1.getCompletionTime() != p2.getCompletionTime())
            return Double.compare(p1.getCompletionTime(), p2.getCompletionTime()); // time asc
        return Integer.compare(p2.getTreasuresFound(), p1.getTreasuresFound()); // treasures desc
    }
}
