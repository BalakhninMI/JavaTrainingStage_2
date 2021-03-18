package GB.Java.TrainingStage2;

public class Robot extends RunAndJump{
    String name;
    int length;
    int height;

    public Robot(String name, int length, int height) {
        this.name = name;
        this.length = length;
        this.height = height;
    }

    @Override
    public void run() {
        System.out.println(name + " пробежал(f) " + getRun());
    }

    @Override
    public void jump() {
        System.out.println(name + " сделал(а) прыжок " + getJump());
    }

    @Override
    public int getRun() {
        return length;
    }

    @Override
    public int getJump() {
        return height;
    }
}
