import java.util.*;

public class Wordsheet {
    List<String> list = new ArrayList<>();

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<String> getUniqueWords() {
        List<String> ls = new ArrayList<>();
        boolean i;
        for (String lsWords: list) {
            i = true;
            for (String lsResult: ls) {
                if (lsResult.equals(lsWords)) {
                    i = false;
                    break;
                }
            }
            if (i) {
                ls.add(lsWords);
            }
        }
        return ls;
    }

    public TreeMap<String, Integer> getCountUniqueWords() {
        TreeMap<String, Integer> hm = new TreeMap<String, Integer>();
        for (String lsWords: list) {
            if (hm.containsKey(lsWords)){
                Integer k = hm.get(lsWords);
                k++;
                hm.put(lsWords, k);
            }else{
                hm.put(lsWords, 1);
            }
        }
        return hm;
    }

}
