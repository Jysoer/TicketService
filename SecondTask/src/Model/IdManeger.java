package Model;

import java.util.ArrayList;
import java.util.List;

public class IdManeger {
    private static List<Long> idList = new ArrayList<>();
    private static Long currentId = 1L;

    public static Long generateId() {
        while (idList.contains(currentId)) {
            currentId++;
        }
        idList.add(currentId);
        return currentId;
    }

    public static Long generateOrValidateId(Long id) {
        if (id == null) {
            return IdManeger.generateId();
        } else if (IdManeger.addId(id)) {
            return id;
        } else {
            throw new IllegalArgumentException("ID already exists");
        }
    }

    public static boolean addId(Long id) {
        if (idList.contains(id)) {
            return false;
        }
        return true;
    }
}
