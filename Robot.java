package com.nunify;

public class Robot {
    public static final int N = 1;
    public static final int E = 2;
    public static final int S = 3;
    public static final int W = 4;
    int x = 0;
    int y = 0;
    int facing = N;


    public static void main(String args[]) {
        Robot robot = new Robot();
        robot.setPosition(1, 0, N);
        robot.instruction("MMRMMLMMR");
        robot.printPosition(); // prints 3 4 E (Output-1)
        robot.setPosition(3, 2, E);
        robot.instruction("MLLMMRMM");
        robot.printPosition(); // prints 2 4 N (Output-2)
    }

    public void setPosition(int x, int y, int facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }
    public void printPosition() {
        char dir = 'N';
        if (facing == 1) {
            dir = 'N';
        } else if (facing == 2) {
            dir = 'E';
        } else if (facing == 3) {
            dir = 'S';
        } else if (facing == 4) {
            dir = 'W';
        }
        System.out.println(x  + " " +  y  + " "+   dir);
    }
    public void instruction(String commands) {
        for (int index = 0; index < commands.length(); index++  ) {
            process(commands.charAt(index));
        }
    }
    private void process(Character command) {
        if (command.equals('L')) {
            turnLeft();
        } else if (command.equals('R')) {
            turnRight();
        } else if (command.equals('M')) {
            move();
        } else {
            throw new IllegalArgumentException(
                    "please! Give Valid Command");
        }
    }
    private void move() {
        if (facing == N) {
            this.y++;
        } else if (facing == E) {
            this.x++;
        } else if (facing == S) {
            this.y--;
        } else if (facing == W) {
            this.x--;
        }
    }
    private void turnLeft() {
        facing = (facing - 1) < N ? W : facing - 1;
    }
    private void turnRight() {
        facing = (facing + 1) > W ? N : facing + 1;
    }
}
