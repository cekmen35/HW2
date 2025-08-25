package ceng201.hw2.treasure;


public final class Treasure {
    private final int id;
    private final String name;
    private final int points;

    public Treasure(int id, String name, int points) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name boş olamaz");
        }
        if (points < 0) {
            throw new IllegalArgumentException("points negatif olamaz");
        }
        this.id = id;
        this.name = name;
        this.points = points;
    }

    public int getId()      { return id; }
    public String getName() { return name; }
    public int getPoints()  { return points; }

    @Override
    public String toString() {
        return "Treasure{id=" + id + ", name='" + name + "', points=" + points + "}";
    }
}

