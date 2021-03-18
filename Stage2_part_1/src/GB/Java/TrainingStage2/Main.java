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


        Treadmill treadmill1 = new Treadmill(2);
        Treadmill treadmill2 = new Treadmill(4);
        Treadmill treadmill3 = new Treadmill(6);

        Wall wall1 = new Wall(1);
        Wall wall2 = new Wall(3);
        Wall wall3 = new Wall(5);

        System.out.println();
        if (treadmill1.moving(people1)) { System.out.println(people1.name + " пробежал " + treadmill1.length); }
        if (treadmill2.moving(people1)) { System.out.println(people1.name + " пробежал " + treadmill2.length); }
        if (treadmill2.moving(people1)) { System.out.println(people1.name + " пробежал " + treadmill3.length); }



    }
}
