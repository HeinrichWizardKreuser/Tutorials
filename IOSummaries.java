/*******************************************************************************
 *  SUMMARY OF HOW TO USE IO-RELATED STUFF I.E. FILEWRITER AND READER
 *
 *  A very useful tool is to be able to read and writer files somewhere on the
 *  PC using things like FileWriter and Scanner
 *
 *  NOTE: Remember to delete the currFolder.txt file & someFolder/someFolder.txt
 *  before running program
 *
 *  For more information, please visit
 *      https://docs.oracle.com/javase/7/docs/api/java/io/package-summary.html
 *  or feel free to contact 21040958@sun.ac.za
 *
 *  @author Heinrich Kreuser
 ******************************************************************************/

/**
 *  There are many things we need to import like filereader, filewriter etc
 *  We can thus use "import java.io.*" to import everythin from the java io
 *  libraries
 */
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class IOSummaries {

    public static void main(String[] args) {
        // list files in the listed directories
        ArrayList<String> currFolder = listFiles(".");
        ArrayList<String> someFolder = listFiles("someFolder/");

        // write the stuff to a file
        writeToFile(currFolder, "currFolder.txt");
        writeToFile(someFolder, "someFolder/someFolder.txt");

        // read from a given file
        ArrayList<String> read = readFromFile("currFolder.txt");
        for (String line : read) {
            System.out.println(line);
        }
    }

    public static ArrayList<String> listFiles(String directory) {
      // we create an arraylist in which we will store each line read
      ArrayList<String> list = new ArrayList<>(0);
      // filesList is an array (of type File) housing all of the directorie's files and directories
      File currentFolder = new File(directory);
    	File[] filesList = currentFolder.listFiles(); //create array of type File
      // list all files in the directory
      System.out.println("\n_________Files in '"+directory+"':_________");
      for (File file : filesList) {
    		if (file.isFile()) {
          String filename = file.getName();
          System.out.println(filename);
          list.add(filename);
  		  }
      }
      // list all directories/folders in the directory
      System.out.println("\n_________Directories/Folders in '"+directory+"':_________");
      for (File file : filesList) {
        if (file.isDirectory()) {
          String filename = file.getName();
          System.out.println(filename);
          list.add(filename);
  		   }
      }
      // return the list of file's and directories
      return list;
    }

    public static void writeToFile(ArrayList<String> lines, String filename) {
    	PrintWriter writer = null;
    	try {
        writer = new PrintWriter(filename);
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }
      for (String line : lines) {
        writer.println(line);
      }
      writer.close();
    }

    public static ArrayList<String> readFromFile(String filename) {
      ArrayList<String> lines = new ArrayList<>(0);
    	Scanner reader = null;
    	try {
            File file = new File(filename);
            reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    	while (reader.hasNextLine()) {
            String line = reader.nextLine();
            lines.add(line);
            System.out.println(line);
        }
        return lines;
    }
}
