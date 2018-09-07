
public class Robot {

    private int x;
    private int y;
    private Direction direction;

    Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {

      if (direction.ordinal() == 0) {
          direction = Direction.values()[Direction.values().length-1];
      } else {
          int nowDirOrder = direction.ordinal();
          direction = Direction.values()[nowDirOrder-1];
      }

    }

    public void turnRight() {
        if (direction.ordinal() == 3) {
            direction = Direction.values()[0];
        } else {
            int nowDirOrder = direction.ordinal();
            direction = Direction.values()[nowDirOrder+1];
        }

    }


    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу

        switch (direction) {

            case UP:
                this.y++;
                break;

            case DOWN:
                this.y--;
                break;

            case LEFT:
                this.x--;
                break;
            case RIGHT:
                this.x++;
                break;
        }
    }


}
