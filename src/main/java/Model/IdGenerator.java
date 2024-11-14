package Model;

import java.util.ArrayList;
import java.util.List;

public class IdGenerator {
    private static List<Long> idList = new ArrayList<>();
    private static Long currentId = 0L;

    public static Long generateId() {
        while (idList.contains(currentId)) {
            currentId++;
        }
        idList.add(currentId);
        return currentId;
    }
}
