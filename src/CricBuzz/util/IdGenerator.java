package CricBuzz.util;

import java.util.Map;
import java.util.Random;

public class IdGenerator {

    // If you want it to be truly generic, you can specify <T> in the method signature
    public static <T> int generateId(Map<Integer, T> entityMap){
        Random random = new Random();
        int candidateId;
        do {
            candidateId = random.nextInt(100);  // Generates a number in [0..99]
        } while (entityMap.containsKey(candidateId));

        return candidateId;
    }
}
