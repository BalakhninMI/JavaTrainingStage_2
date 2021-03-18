package GB.Java.TrainingStage2;

public class Wall implements Passage {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean moving(RunAndJump player) {
        return height <= player.getJump();
    }

}
