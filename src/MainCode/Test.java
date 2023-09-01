package MainCode;

import UI.MainFrame;
import UI.StatsMenu;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class Test<T>{

    private static MainFrame mainFrame = new MainFrame();
    private static StatsMenu statsMenu = new StatsMenu();

    static ArrayList jojopopopj = new ArrayList(10);



    public static void main (String args[]){

        ArrayList<String> rerer = new ArrayList<>(Arrays.asList("fffff", "ddddd"));

        List<Integer> hiooh = new ArrayList<>(Arrays.asList(1, 2));

        List<Integer> jojo = new ArrayList<Integer>(10);

        jojo.add(1);
        jojo.add(3);
        jojo.add(-2);

        jojopopopj.add(2);

        jojopopopj.add(1);

        jojopopopj.add("rerer");

        System.out.println(jojopopopj);

        Stream<Integer> fiji = jojo.stream().filter(a -> a > 0);

        fiji.map(a -> a + 1).
                forEach(System.out::println);


        Map<Integer, String> okoko = new HashMap<>(10);

        okoko.put(1, "wewew");

        System.out.println(okoko);

        try {
            System.out.println(okoko);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("worked");
        }

        ExecutorService fefef = Executors.newFixedThreadPool(1);

        int[] gygygy = new int[10];

        gygygy[0] = 1;

    }
}
