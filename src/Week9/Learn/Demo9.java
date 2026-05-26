package Week9.Learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Demo9 {
    static void main() {
        String[] arr = {"A","B","C","D"};
        Random random = new Random();
        ArrayList<String> list = new ArrayList<>();
        //模拟80个同学投票
        for(int i=0;i<80;++i){
            int index = random.nextInt(arr.length);
            list.add(arr[index]);
        }
        HashMap<String, Integer> map = new HashMap<>();
        for(String name:list){
            if(map.containsKey(name)){
                map.put(name, map.get(name)+1);
            }else{
                map.put(name, 1);
            }
        }
        int maxVote = 0;
        ArrayList<String> winners = new ArrayList<>();
        for(Map.Entry<String, Integer> entry:map.entrySet()){
            int votes = entry.getValue();
            if(votes > maxVote){
                maxVote = votes;
                winners.clear();
                winners.add(entry.getKey());
            } else if(votes == maxVote){
                winners.add(entry.getKey());
            }
        }
        System.out.println(winners);
        System.out.println(maxVote);
    }
}
