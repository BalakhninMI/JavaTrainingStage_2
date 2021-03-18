package GB.Java.TrainingStage2;

public class Wall implements Passage {
    int height;
    String name;

    public Wall(String name, int height) {
        this.height = height;
        this.name = name;
    }

    @Override
    public boolean moving(RunAndJump player) {
        return height <= player.getJump();
    }

    @Override
    public String getName() {
        return this.name;
    }

}
