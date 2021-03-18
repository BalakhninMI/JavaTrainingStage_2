package GB.Java.TrainingStage2;

public class Main {

    public static void main(String[] args) {
        Person people1 = new Person("Человек_1", 6, 3);
        people1.run();
        people1.jump();

        Cat cat1 = new Cat("Кот_2", 4, 2);
        cat1.run();
        cat1.jump();

        Robot robot1 = new Robot("Робот_2", 2, 1);
        robot1.run();
        robot1.jump();

        Treadmill treadmill1 = new Treadmill("Беговая дорожка_1",2);
        Treadmill treadmill2 = new Treadmill("Беговая дорожка_2",4);
        Treadmill treadmill3 = new Treadmill("Беговая дорожка_3",6);

        Wall wall1 = new Wall("Стена_1",1);
        Wall wall2 = new Wall("Стена_2",3);
        Wall wall3 = new Wall("Стена_3",5);

        System.out.println();
        System.out.println("Прохождение препядствий");
        System.out.println();

        RunAndJump[]  player = new RunAndJump[3];
        player[0] = new Person("Человек_1", 6, 3);
        player[1] = new Cat("Кот_2", 4, 2);
        player[2] = new Robot("Робот_2", 2, 1);

        Passage[] obstacle = new Passage[6];
        obstacle[0] = new Treadmill("Беговая дорожка_1",2);
        obstacle[2] = new Treadmill("Беговая дорожка_2",4);
        obstacle[4] = new Treadmill("Беговая дорожка_3",6);
        obstacle[1] = new Wall("Стена_1",1);
        obstacle[3] = new Wall("Стена_2",3);
        obstacle[5] = new Wall("Стена_3",5);

        for (int i = 0; i <player.length ; i++) {
            for (int j = 0; j <obstacle.length ; j++) {
                if (obstacle[j].moving(player[i])){
                    System.out.println("Препядствие " + obstacle[j].getName() + " пройдено участником № " + (i+1) + ".");
                }
                else {
                    System.out.println("Препядствие " + obstacle[j].getName() + " не пройдено участником № " + (i+1) + ".");
                    break;
                }
            }
        }


    }
}
