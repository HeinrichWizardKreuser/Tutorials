/*******************************************************************************
 *  SUMMARY OF HOW TO USE ARRAYLISTS
 *
 *  ArrayLists are a very useful data type for making a collection/list of items
 *  without knowing the initial amount of items we will be listing. You can also
 *  think of an arraylist as an Array that's size depends on what's in the list
 *  and you can keeping inserting and deleting the contents
 *
 *  For more information, please visit
 *      https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
 *  or feel free to contact 21040958@sun.ac.za
 *
 *  @author Heinrich Kreuser
 ******************************************************************************/

// Important: must import java.util.ArrayList
import java.util.ArrayList;

public class ArrayLists {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(0);
    /*              (1)    (2)                (3)
    (1) <DataType>
    >   The data type contained by the <> symbols means that we are creating an
        ArrayList of that type.
    >   One can input any class name here, but it must be in "Box format".
        Meaning that we cannot use <int>, <double> or <char>, but instead use
        <Integer>, <Double> and <Character> respectively
    (2) list -> name
    >   After declaring the ArrayList<String>, we add a name for our arraylist.
        In this case, we used the word 'list'
    (3)
    >   As with defining all data types, we must put "new" followed by the data
        type on the right side of the equals (=) sign.
    >   Here, we use the same format as we did at the beginning but it is not
        neccesary to add the data type between the <> symbols, however you may
        if you wish to do so.
    >   We need to add a bracket () at the end and it is suggested to add a zero
        inside these brackets. The number inside the brackets sets the ArrayList's
        initial size.
    */
        System.out.println("adding first string...");
        list.add("First_added_string");
    /*
        Here we add an item to our arraylist. Since the list was empty, the item
        will be stored at index 0 and our size is now 1
        Thus when we retrieve the first index, it will return us our item:
    */
        System.out.println("Size = " +list.size());
        System.out.println("list.get(0) = " +list.get(0));
    /*
        The nice thing about an arraylist is that we can see if it contains a
        certain item very easily by just calling upon the contains() method
    */
        System.out.println("\nChecking if contains an element...");
        System.out.println("list.contains(\"First_added_string\") = " +list.contains("First_added_string"));
    /*
        We can also remove items from the arraylist by calling on the remove()
        function.
        This will remove the item at the specified index
        Thus leaving our size at 0
    */
        System.out.println("\nremoving first element from the list...");
        list.remove(0);
        System.out.println("Size = " +list.size());
    /*
        We can also check if the list is empty by simply calling upon the isEmpty()
        function which will return true if the arraylist's size is 0 and false otherwise
    */
        System.out.println("\nChecking if list is empty...");
        System.out.println("list.isEmpty() = " +list.isEmpty());

    // adding to arraylist for examples to follow:
        for (int i = 0; i < 10; i++) {
            list.add("Original Index " +i);
        }
    /*  Iterating through the arrraylist
        There are two ways to go through all of the entries in an arraylist.

    (1) The one is the type you'll be used to like in an array:
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        Instead, it will look slightly different:
    */

        System.out.println("\nRegular iteration:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    /*
    (2) The second method is using what we call an "Enhanced forloop". You need
        not know about it just yet, but it works as such:
    */
        System.out.println("\nEnhanced forloop iteration:");
        for (String s : list) {
            System.out.println(s);
        }
    /*
        For more information on Enhanced forloops, see the EnhancedForloop.java
        Summary script.
    */

    }
}
