package Week9.Learn;

import java.util.Collection;
import java.util.TreeMap;

public class Demo12 {
    static void main() {
        String str = "aababcabcdabcde";
        TreeMap<Character, Integer> tm = new TreeMap<>();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(tm.containsKey(c)){
                tm.put(c, tm.get(c)+1);
            }else{
                tm.put(c, 1);
            }
        }
        for(var ele:tm.entrySet())
            System.out.print(ele.getKey()+"("+ele.getValue()+") ");
        System.out.println();
    }
}
