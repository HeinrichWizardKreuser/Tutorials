/*******************************************************************************
 *  SUMMARY OF HOW TO USE ENHANCED FORLOOPS AND ITERATORS
 *
 *  Enhanced Forloops are different than regular forloops that you would be used
 *  to. In regular forloops, we define an int i that travels from 0 to a specified
 *  size, usually because we want to use it to access the index of an array of
 *  sorts. But if we just want to access each element in the array, we can use
 *  the enhanced forloop
 *
 *  For more information, please visit
 *      https://blogs.oracle.com/corejavatechtips/using-enhanced-for-loops-with-your-classes
 *  or feel free to contact 21040958@sun.ac.za
 *
 *  @author Heinrich Kreuser
 ******************************************************************************/

import java.util.ArrayList;
import java.util.HashMap;

public class EnhancedForloops {

    public static void main(String[] args) {

        int N = 10;
        String[] array = new String[N];
        for (int i = 0; i < N; i++) {
            array[i] = "element " +i;
        }

        System.out.println("ARRAY");
        // Here we are just iterating as we regularly would over the array
        System.out.println("index iteration:");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element: " + array[i]);
        }

        // This is how the enhanced forloop looks like, it does the exact same thing
        System.out.println("\nenhanced forloop iteration:");
        for (String element : array) {
            System.out.println("Element: " + element);
        }

        /*
            Instead of iterating over the the indices and then accessing the array
            with each index, we simply iterate over all the elements directly
            We can apply this type of forloop for any Collection such as
            -   HashMap
            -   ArrayList
            -   <Data Type>[]
        */

        System.out.println("\nARRAYLIST");
        ArrayList<String> list = new ArrayList<>(0);
        for (int i = 0; i < 10; i++) {
            list.add("Original Index " +i);
        }

        System.out.println("\nindex iteration:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("\nenhanced forloop iteration:");
        for (String element : list) {
            System.out.println(element);
        }


        /*
            For some collections, like hashmaps, you have to use enhanced forloops
            since those collections don't have things like "indices"
        */
        System.out.println("\nHASHMAP");
        HashMap<String, Double> lengths = new HashMap<>();
        lengths.put("John", 1.73);
        lengths.put("Gina", 1.62);
        lengths.put("Caleb", 1.7);
        lengths.put("Christopheles", 1.75);

        System.out.println("\nHashMap enhanced forloop:");
        for (String key : lengths.keySet()) {
            System.out.println(key + ": " + lengths.get(key));
        }
    }
}
