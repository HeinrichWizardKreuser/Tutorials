/*******************************************************************************
 *  SUMMARY OF HOW TO USE HASHMAPS
 *
 *  HashMaps are very useful arraylist-like collections that allow us to map/link
 *  one data type value to another possibly different data type value.
 *  Think of a hashmap as storing Keys to vaults. Each Key can only open one vault
 *  and each vault stores data
 *
 *  For more information, please visit
 *      https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
 *  or feel free to contact 21040958@sun.ac.za
 *
 *  @author Heinrich Kreuser
 ******************************************************************************/

// Important: must import java.util.HashMap
import java.util.HashMap;

public class HashMaps {

    public static void main(String[] args) {
        HashMap<String, Double> lengths = new HashMap<>();
    /*              (1)            (2)                (3)
        Let's say we wanted to store a list of all students in a class and their
        respective lengths in meters.
    (1) <String, Double> -> <Key, Value>
    >   The two data types contained by the <> symbols indicates the repsective
        data types of the Key and the Value
    >   One can input any class name here, but it must be in "Box format".
        Meaning that we cannot use <int>, <double> or <char>, but instead use
        <Integer>, <Double> and <Character> respectively
    (2) lengths -> name
    >   After declaring the HashMap<String, Integer>, we add a name for our hashmap.
        In this case, we used the word lengths
    (3)
    >   As with defining all data types, we must put "new" followed by the data
        type on the right side of the equals (=) sign.
    >   Here, we use the same format as we did at the beginning but it is not
        neccesary to add the data type between the <> symbols, however you may
        if you wish to do so.
    >   We need to add a bracket () at the end, but we keep it empty
    */
        System.out.println("Adding John with length 1.73 to hashmap...");
        lengths.put("John", 1.73);
    /*
        Here we add an item to our hashmap. When adding Key-Value pairs, we must
        add both the key and the value at the same time and cannot add them
        seperately. Thus saying that the put() method only takes in two parameters
        Now we can fetch the size of john by calling on our get() function
    */
        System.out.println("Size = " +lengths.size());
        System.out.println("lengths.get(John) = " +lengths.get("John"));
    /*
        Note that if the hashamp does not contain a "John" entry, there will be
        a NullPointerException.
        We can check whether the hashamp contains a certain Key or Value by simply
        calling upon the containsKey() and containsValue() methods
    */
        System.out.println("\nChecking if contains an element \"John\" and for a value \"1.73\"...");
        System.out.println("lengths.containsKey(\"John\") = " +lengths.containsKey("John"));
        System.out.println("lengths.containsValue(1.73) = " +lengths.containsValue(1.73));
    /*
        We can also remove items from the hashmap by calling on the remove()
        function.
        This will remove the any the specified key as well as the value it is
        mapped to from the hashmap. Thus leaving our size at 0
    */
        System.out.println("\nremoving element \"John\"...");
        lengths.remove("John");
        System.out.println("Size = " +lengths.size());
    /*
        We can also check if the hashmap is empty by simply calling upon the isEmpty()
        function which will return true if the hashmap's size is 0 and false otherwise
    */
        System.out.println("\nChecking if hashmap is empty...");
        System.out.println("lengths.isEmpty() = " +lengths.isEmpty());

    // adding to hashmap for examples to follow:
        System.out.println("\nAdding elements and then enhanced forloop iteration over them:");
        lengths.put("Gina", 1.62);
        lengths.put("Caleb", 1.7);
        lengths.put("Christopheles", 1.75);
    /*  Iterating through the HashMap
        There is only one way to iterate through all of the entries of a HashMap
        and that is via the enhanced forloop.
        However, we must use the keySet() method of the hashmap as the iterator
    */
        for (String s : lengths.keySet()) {
            System.out.println(s + " = " +lengths.get(s));
        }
    /*
        For more information on Enhanced forloops, see the EnhancedForloop.java
        Summary script.
    */

    }
}
