import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Test: Two Writes and Four Reads
        System.out.println("Test: Two Writes and Four Reads");
        Register register1 = new Register();
        register1.write(0, 1, 3);
        register1.read(2, 4);
        register1.read(4, 5);
        register1.write(1, 6, 10);
        register1.read(7, 8);
        register1.read(8, 9);
        register1.read(12, 13);
        List<List<Integer>> validReads1 = register1.getValidReadValues();
        printValidReadValues(validReads1);
        System.out.println();

        // Test: Back to Back Writes
        System.out.println("Test: Back to Back Writes");
        Register register2 = new Register();
        register2.write(0, 1, 5);
        register2.write(3, 6, 10);
        register2.read(2, 4);
        register2.read(7, 8);
        List<List<Integer>> validReads2 = register2.getValidReadValues();
        printValidReadValues(validReads2);
        System.out.println();

        // Test: Non-Overlapping Reads
        System.out.println("Test: Non-Overlapping Reads");
        Register register3 = new Register();
        register3.write(0, 1, 3);
        register3.read(4, 5);
        register3.read(6, 7);
        register3.read(8, 9);
        List<List<Integer>> validReads3 = register3.getValidReadValues();
        printValidReadValues(validReads3);
        System.out.println();

        // Test: Complex Scenario
        System.out.println("Test: Complex Scenario");
        Register register4 = new Register();
        register4.write(0, 1, 3);
        register4.read(4, 5);
        register4.write(6, 7, 10);
        register4.read(11, 12);
        register4.write(13, 14, 15);
        register4.read(16, 17);
        register4.read(18, 19);
        List<List<Integer>> validReads4 = register4.getValidReadValues();
        printValidReadValues(validReads4);
        System.out.println();

        // Test: No Writes Scenario
        System.out.println("Test: No Writes Scenario");
        Register register5 = new Register();
        register5.read(0, 1);
        register5.read(2, 3);
        register5.read(4, 5);
        List<List<Integer>> validReads5 = register5.getValidReadValues();
        printValidReadValues(validReads5);
        System.out.println();

        // Test: Multiple Consecutive Writes
        System.out.println("Test: Multiple Consecutive Writes");
        Register register6 = new Register();
        register6.write(1, 0, 2);
        register6.write(2, 3, 5);
        register6.write(3, 6, 8);
        register6.read(9, 10);
        List<List<Integer>> validReads6 = register6.getValidReadValues();
        printValidReadValues(validReads6);
        System.out.println();

        // Test: Read Overlapping Multiple Writes
        System.out.println("Test: Read Overlapping Multiple Writes");
        Register register7 = new Register();
        register7.write(1, 0, 3);
        register7.read(2, 4);
        register7.write(2, 3, 5);
        register7.read(4, 6);
        List<List<Integer>> validReads7 = register7.getValidReadValues();
        printValidReadValues(validReads7);
        System.out.println();

        // Test: Reads After All Writes
  
    }

    public static void printValidReadValues(List<List<Integer>> validReadValues) {
        System.out.println("Valid Read Values:");
        for (List<Integer> readList : validReadValues) {
            System.out.println(readList);
        }
    }
}
