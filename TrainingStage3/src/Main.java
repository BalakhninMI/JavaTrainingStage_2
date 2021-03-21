import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int x;
        String[][] mainArray = new String[4][4];
        for (int i = 0; i < mainArray.length; i++) {
            for (int j = 0; j < mainArray[i].length; j++) {
                mainArray[i][j] = Integer.toString(random.nextInt(10));
            }
        }

        //mainArray[3][3] = "o";

        try {
            System.out.println(myArraySize(mainArray));
        } catch (MyArraySizeException e) {
            e.printStackTrace();            
        }catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("Col: " + e.getCol() + ", Row: " + e.getRow());
        }

    }

    static int myArraySize (String[][] array) throws MyArraySizeException, MyArrayDataException{
        int sum=0;
        if (4 != array.length) throw new MyArraySizeException();
        for (int i = 0; i < array.length; i++) {
            if (4 != array[i].length) throw new MyArraySizeException();
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("format " + i + "" + j , i, j);
                }
            }
        }
        return sum;
    }
}
