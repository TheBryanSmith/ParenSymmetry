import jdk.jshell.spi.ExecutionControl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParenSymmetry {


    Boolean isBalanced(String s) {
        // implement this method




        int scale = 0;//counter  // could be zero; could be less than zero

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {//use a counter set unclosed parenthesis to decrement
                scale--; //makes less than zero
            } else if (s.charAt(i) == ')') { //set closed parenthesis to increment
                scale++; // if ha a matching closing parenthesis than balances back to zero
            }
        }
        return scale == 0; // if balanced it returns scale "is equal to" zero which in turn should return true
    }

    public void checkFile(String filename) {
        // open file named filename
        try {
            File myObj = new File("/Users/bryan/Desktop/zipcode Classwork/Unfinished/ParenSymmetry/TestStrings0.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        // for each line in the file
        // read the line
        // print whether or not the line's parenthesis are balanced
        // CLOSE the file
    }

    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();

        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
