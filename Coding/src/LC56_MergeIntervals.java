import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC56_MergeIntervals {


    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {
        //[[1,3],[2,6],[8,10],[15,18]]
        List<Interval> list = new ArrayList<>();
        Interval i1 = new Interval(1,4);
        Interval i2 = new Interval(2,3);
        //Interval i3 = new Interval(8,10);
        //Interval i4 = new Interval(15,18);
        list.add(i1);
        list.add(i2);
        //list.add(i3);
        //list.add(i4);
        List<Interval> result = merge(list);
        System.out.println(result);
    }

    private static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 1) { return intervals; }
        Collections.sort(intervals, (o1, o2) -> {
            if (o1.start < o2.start) { return -1; }
            else if (o1.start == o2.start) { return 0; }
            else { return 1; }
        });
        List<Interval> result = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            if (result.isEmpty() || (intervals.get(i).start > result.get(result.size()-1).end)) {
                result.add(intervals.get(i));
            } else {
                result.get(result.size()-1).end = Math.max(result.get(result.size()-1).end, intervals.get(i).end);
            }
        }
        return result;

        /*if (intervals.get(i+1).start >= intervals.get(i).start
                && intervals.get(i+1).start <= intervals.get(i).end) {
            result.add(new Interval(intervals.get(i).start, intervals.get(i+1).end));
        } else {
            result.add(new Interval(intervals.get(i+1).start, intervals.get(i+1).end));
        }*/
    }
}
