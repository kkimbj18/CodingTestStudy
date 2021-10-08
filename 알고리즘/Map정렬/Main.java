package 알고리즘.Map정렬;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
    Map<String, Integer> tempMap = new HashMap<>();

    Comparator<Entry<String, Integer>> comparator = new Comparator<Entry<String, Integer>>() {
        @Override
        public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
            return e1.getValue().compareTo(e2.getValue());
        }
    };

    Entry<String, Integer> maxEntry = Collections.max(tempMap.entrySet(), comparator);
}
