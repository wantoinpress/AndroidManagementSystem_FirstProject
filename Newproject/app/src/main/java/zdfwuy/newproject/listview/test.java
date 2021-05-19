package zdfwuy.newproject.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import zdfwuy.newproject.data.BudgetInfo;

/**
 * Created by ASUS on 2021/5/9.
 */
public class test {
    public static void main(String[] args){
        HashMap<String, List<Integer>> map = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        map.put("输电队", list1);
        List<Integer> list = map.get("安装一队");
        System.out.println(list);
    }
}
