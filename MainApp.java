import java.util.*;

class MainApp
{
    // Iterate over Deque in Java
    public static void main (String[] args)
    {

        System.out.println("Case 1");
        case1();
        System.out.println("Case 2");
        case2();
        System.out.println("Case 3");
        case3();
        System.out.println("Case 4");
        case4();




    }

    private static void case4(){
        List<Integer> foo = new ArrayList<>();
        foo.add(1);

        List<Integer> bar = new ArrayList<>();
        bar.add(2);

        List<Integer> baz = new ArrayList<>();
        baz.add(3);
        baz.add(4);
        baz.add(5);

        List<Iterator<Integer>> myIters = new ArrayList<>();
        myIters.add(foo.listIterator());
        myIters.add(bar.listIterator());
        myIters.add(baz.listIterator());

        InterleavingIterator<Integer> ci = new InterleavingIterator(myIters);
        testIt(ci);
    }

    /**
     * Pass
     */
    private static void case3(){
        List<Integer> foo = new ArrayList<>();
        foo.add(1);
        foo.add(4);
        foo.add(5);

        List<Integer> bar = new ArrayList<>();
        bar.add(2);

        List<Integer> baz = new ArrayList<>();
        baz.add(3);

        List<Iterator<Integer>> myIters = new ArrayList<>();
        myIters.add(foo.listIterator());
        myIters.add(bar.listIterator());
        myIters.add(baz.listIterator());

        InterleavingIterator<Integer> ci = new InterleavingIterator(myIters);
        testIt(ci);
    }

    /**
     * Pass
     */
    private static void case2(){
        List<Integer> foo = new ArrayList<>();
        foo.add(1);

        List<Integer> bar = new ArrayList<>();
        bar.add(2);

        List<Integer> baz = new ArrayList<>();
        baz.add(3);

        List<Iterator<Integer>> myIters = new ArrayList<>();
        myIters.add(foo.listIterator());
        myIters.add(bar.listIterator());
        myIters.add(baz.listIterator());

        InterleavingIterator<Integer> ci = new InterleavingIterator(myIters);
        testIt(ci);
    }
    /**
     * Pass
     */
    private static void case1(){
        List<Integer> foo = new ArrayList<>();
        foo.add(1);
        foo.add(4);
        foo.add(6);
        foo.add(8);
        foo.add(10);
        foo.add(11);

        List<Integer> bar = new ArrayList<>();
        bar.add(2);
        bar.add(5);
        bar.add(7);
        bar.add(9);

        List<Integer> baz = new ArrayList<>();
        baz.add(3);

        List<Integer> bazbar = new ArrayList<>();
        bazbar.add(3);
        List<Iterator<Integer>> myIters = new ArrayList<>();
        myIters.add(foo.listIterator());
        myIters.add(bar.listIterator());
        myIters.add(baz.listIterator());

        InterleavingIterator<Integer> ci = new InterleavingIterator(myIters);

        testIt(ci);
    }
    private static void testIt(InterleavingIterator<Integer> ci){
        while(ci.hasNext()) {
            System.out.println(ci.next());
        }
        while(ci.hasPrev()) {
            System.out.println(ci.prev());
        }
    }
}