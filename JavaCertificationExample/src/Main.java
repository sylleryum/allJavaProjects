import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;


public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> original = new ArrayList<>();
        original.add(new Integer(10));
        ArrayList<Integer> cloned = (ArrayList<Integer>) original.clone();
        Integer i1 = cloned.get(0);
        ++i1;
        System.out.println(cloned);
    }
}