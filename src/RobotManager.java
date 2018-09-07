public class RobotManager {

    //Метод автоматического перемещения робота в заданную позицию
    public static void moveRobot(Robot robot, int toX, int toY) {
        int nowX = robot.getX();
        int nowY = robot.getY();
        boolean needXplus = (nowX < toX);
        boolean needXminus = (nowX > toX);
        boolean needYplus = (nowY < toY);
        boolean needYminus = (nowY > toY);

        //Сначала ведется движение вдоль оси Х
        //Поворот в нужную сторону вдоль оси Х
        if (needXplus || needXminus) {
            turnX(robot, needXplus, needXminus);
        }
        //Движение вдоль оси Х
        while (robot.getX() != toX ) {
            robot.stepForward();
        }
        //Поворот в нужную сторону вдоль оси Y
        if (needYplus || needYminus) {
            turnY(robot, needYplus, needYminus);
        }
        //Движение вдоль оси Y
        while (robot.getY() != toY ) {
            robot.stepForward();
        }

    }


    //Метод поворачивает робота вдоль оси X в нужном направлении
    public static void turnX(Robot robot, boolean needXplus, boolean needXminus) {
        //Если нужно двигаться вправо
        if (needXplus) {
            if (robot.getDirection() == Direction.UP) {
                robot.turnRight();
            }
            if (robot.getDirection() == Direction.DOWN) {
                robot.turnLeft();
            }
            if(robot.getDirection() == Direction.LEFT) {
                robot.turnRight();
                robot.turnRight();
            }
        }
        //Если нужно двигаться влево
        if (needXminus) {
            if (robot.getDirection() == Direction.UP) {
                robot.turnLeft();
            }
            if (robot.getDirection() == Direction.DOWN) {
                robot.turnRight();
            }
            if (robot.getDirection() == Direction.RIGHT) {
                robot.turnLeft();
                robot.turnLeft();
            }
        }

    }

    //Метод поворачивает робота вдоль оси Y в нужном направлении
    public static void turnY(Robot robot, boolean needYplus, boolean needYminus) {
        //Если нужно двигаться вверх
        if (needYplus) {
            if (robot.getDirection() == Direction.LEFT) {
                robot.turnRight();
            }
            if (robot.getDirection() == Direction.RIGHT ) {
                robot.turnLeft();
            }
            if (robot.getDirection() == Direction.DOWN) {
                robot.turnRight();
                robot.turnRight();
            }
        }
        //Если нужно двигаться вниз
        if (needYminus) {
            if (robot.getDirection() == Direction.LEFT) {
                robot.turnLeft();
            }
            if (robot.getDirection() == Direction.RIGHT) {
                robot.turnRight();
            }
            if (robot.getDirection() == Direction.UP) {
                robot.turnRight();
                robot.turnRight();
            }
        }
    }

    //Метод печати статуса робота
    public static void printStatus(Robot robot) {
        System.out.println("Координата х: "+robot.getX()+ ", координата y: " + robot.getY()+ "; взгляд: " + robot.getDirection());
    }


    public static void main(String[] args) {
       //Начальное состояние робота
        Direction dir = Direction.DOWN;
        int startX = 0;
        int startY = 0;

        Robot robot = new Robot(startX, startY, dir);
        printStatus(robot);
        moveRobot(robot,-5,2);
        printStatus(robot);

    }

}
