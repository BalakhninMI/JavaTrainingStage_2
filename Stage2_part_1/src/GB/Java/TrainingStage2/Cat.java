package GB.Java.TrainingStage2;

public class Cat extends RunAndJump{
    String name;
    int length;
    int height;

    public Cat(String name, int length, int height) {
        this.name = name;
        this.length = length;
        this.height = height;
    }

    @Override
    public void run() {
        System.out.println(name + " пробежал(а) " + getRun());
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
