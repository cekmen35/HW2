package TASK2;

public class Player {
    // Bunları şimdilik gizli tutuyorum, daha sonra doğrulamak istersem diye
    private int id;
    private String playerName;
    private int currentScore;

    // Constructor (Parametrelerin sırasını her zaman unutuyorum...)
    public Player(int id, String playerName, int startingScore) {
        this.id = id;
        this.playerName = playerName;
        // bence puanın < 0 olup olmadığını kontrol etmeli, ancak şimdilik görmezden geliyorum
        this.currentScore = startingScore;
    }

    // skor için getter (daha sonra kafa karıştırıcı olursa yeniden adlandırılabilir)
    public int getScore() {
        return currentScore;
    }

    // sadece basit bir getter, gösterişli bir şey değil
    public String getName() {
        return playerName;
    }

    // buna getId mi yoksa getPlayerId mi demeliyim?
    public int getPlayerId() {
        return id;
    }

    @Override
    public String toString() {

        return playerName + " - " + currentScore;

    }
}
