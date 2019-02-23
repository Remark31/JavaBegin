package boolindex;

import javafx.util.Pair;

import java.util.Comparator;


/**
 * 实现Pair<String, Pair<Integer, Integer>> 的比较方法，用于排序
 * @author remark
 * @version 2019-2-23
 */
public class PairStringIntSort implements Comparator<Pair<String, Pair<Integer,Integer>>> {

    @Override
    public int compare(Pair<String, Pair<Integer, Integer>> o1, Pair<String, Pair<Integer, Integer>> o2) {
        if (o1.getKey().compareTo(o2.getKey()) != 0) {
            return o1.getKey().compareTo(o2.getKey());
        } else {
            if (o1.getValue().getKey().compareTo(o2.getValue().getKey()) != 0)   {
                return o1.getValue().getKey().compareTo(o2.getValue().getKey());
            } else {
                return o1.getValue().getValue().compareTo(o2.getValue().getValue());
            }
        }



    }
}
