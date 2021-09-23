package base.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Seven.Xu
 * @version 2021/5/9
 **/
public class ConcurrentHashMapSample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 20; i++) {
            concurrentHashMap.put("xdq" + i, "xdq" + i);
        }

    }
}
