import java.util.*;
import java.io.*;

// https://leetcode.com/discuss/interview-question/857876/Google-Interview-Question-Onsite

class StringPlaceholders {
    static PrintWriter out = new PrintWriter(System.out, true);

    static String go(Map<String, String> map, String input) {
        String[] split = input.split(" ");

        StringBuilder str = new StringBuilder();
        for (String s : split) {
            // If we see a key, dfs further. Otherwise, just append current stirng
            if (s.charAt(0) == '$') {
                String substr = s.substring(1);
                str.append(map.containsKey(substr) ? go(map, map.get(substr)) : s);
            } else
                str.append(s);

            if (split.length > 1)
                str.append(" ");
        }
        // Remove last string
        if (split.length > 1)
            str.deleteCharAt(str.length() - 1);
        return str.toString();
    }

    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("V1", "Hello");
        map.put("V2", "$V1");
        map.put("V3", "Hola $V2");

        String input = "SKY $V1 $V2 $V3";
        out.println(go(map, input)); // Sky Hello hello Hola Hello
    }
}