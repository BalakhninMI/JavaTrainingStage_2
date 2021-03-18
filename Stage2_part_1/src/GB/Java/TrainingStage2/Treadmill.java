package GB.Java.TrainingStage2;

public class Treadmill implements Passage {
    int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public boolean moving(RunAndJump player) {
        return length <= player.getRun();
    }
}
