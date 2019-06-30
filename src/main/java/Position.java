import java.util.Objects;

public class Position {

    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position create(int x, int y) {
        return new Position(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        Position position = (Position) obj;

        return position.x == this.x && position.y == this.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
}
