package GB.Java.TrainingStage2;

public class Treadmill implements Passage {
    int length;
    String name;

    public Treadmill(String name, int length) {
        this.length = length;
        this.name = name;
    }

    @Override
    public boolean moving(RunAndJump player) {
        return length <= player.getRun();
    }

    @Override
    public String getName() {
        return this.name;
    }
}
