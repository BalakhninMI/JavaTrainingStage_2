import java.util.*;

public class PhoneBook {
    List<String> list = new ArrayList<>();

    public void setList(List<String> list) {
        this.list = list;
    }

    public void add(String surname, String numberPhone) {
        this.list.add(surname + ";" + numberPhone);
    }

    public List<String> getFindSurname(String surname) {
        List<String> ls = new ArrayList<>();
        boolean i;
        for (String lsStr: list) {
            String[] str= lsStr.split(";");
            if (str[0].equals(surname)) {
                ls.add(str[1]);
            }
        }
        if (ls.size()<=0) ls.add("Данных не найдено");
        return ls;
    }
}
