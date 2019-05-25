/*******************************************************************************
*  SUMMARY OF HOW TO USE LAMBDA FUNCTIONS AND EXPRESSIONS
*
*  Lambda functions are Java's implementation of "function programming", a paradigm
*  focused at using methods as if they were variables by passing them around and
*  editing them.
*
*  For more information, please visit
*      https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
*  or feel free to contact 21040958@sun.ac.za
*
*  @author Heinrich Kreuser
******************************************************************************/
// for the functions in general
import java.util.function.Consumer;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.function.Predicate;
// for filter
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda {

  public static void main(String[] args) {
    basic();
    filters();
    andThen_Compose();
  }

  /*
   * This shows examples of how to practically use the most important lambda
   * functions.
   */
  public static void basic() {
    System.out.println("\nbasic\n");
    // 1 argument, 0 return (void)
    Consumer<String> consumer = (s) -> System.out.println(s);
    consumer.accept("consumer");

    // 2 argument, 0 return
    BiConsumer<String, Integer> biconsumer = (s, i) -> System.out.println(s + "" + i);
    biconsumer.accept("biconsumer", 2);

    // 1 argument, 1 return
    Function<Double, Double> abs = (x) -> {
      if (x < 0) {
        return -x;
      } else {
        return x;
      }
    };
    double x = -2;
    System.out.println("function: abs("+x+") = " + abs.apply(x));

    // 2 arguments, 1 return
    BiFunction<Integer, Integer, Boolean> bifunction = (i1, i2) -> {
      return i1 == i2;
    };
    int i1 = 1;
    int i2 = 2;
    System.out.println("bifunction: i1("+i1+") == i2("+i2+"): " + bifunction.apply(i1, i2));

    // 0 argument, 1 return
    Supplier<Long> time = () -> {
      return System.currentTimeMillis();
    };
    System.out.println("supplier: time = " + time.get());

    Predicate<Integer> lessThan3 = (i) -> {
      return i < 3;
    };
    int i = 2;
    System.out.println("predicate: " + i + " < 3 = " + lessThan3.test(i));
  }

  /*
   * Most list-like data-types implement what we call a "stream", which essentially
   * is the elements of the list themselves. We can call filter() on this stream
   * and input a boolean function/predicate as its parameter. It will then iterate
   * over all elements in the stream and keep those that fulfill the given predicate.
   * We then get a stream back which we convert to a new list using the collect()
   * method. Note that stream() returns a copy of all the elements in the list and
   * thus editing it does not edit the original list
   */
  public static void filters() {
    System.out.println("\nfilters\n");

    System.out.println(" lists:");
    List<String> list = Arrays.asList("1", "22", "333", "4444", "55555");
    List<String> filtered = list
      .stream() // convert list to stream
      .filter(s -> s.length() > 2) // keep all with length greater than 2
      .collect(Collectors.toList()); // collect the output and convert streams to a List
    filtered.forEach(System.out::println);

    System.out.println(" arrays:");
    String[] arr = new String[]{"1", "22", "333", "4444", "55555"};
    List<String> filtered2 = Arrays.stream(arr) // convert list to stream
      .filter(s -> s.length() > 2) // keep all with length greater than 2
      .collect(Collectors.toList()); // collect the output and convert streams to a List
    filtered2.forEach(System.out::println);
  }

  /*
   * "andThen()" and "compose()" are basically the same operation, just reversed.
   * We can use them to combine functions into new ones.
   */
  public static void andThen_Compose() {
    System.out.println("\nandThen_Compose\n");
    // two basic functions
    Function<Integer, Integer> times2 = i -> 2*i;
    Function<Integer, Integer> squared = i -> i*i;

    // compose
    int compose = times2.compose(squared).apply(4);
    System.out.println("compose: (4^2)*2 = " + compose);

    // andThen
    int andThen = times2.andThen(squared).apply(4);
    System.out.println("andThen: (4*2)^2 = " + andThen);
  }
}
