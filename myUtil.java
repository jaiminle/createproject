/*
* Objective: learn to write methods
*/
package createprojectjml;
import java.util.Scanner; 

public class myUtil {

    static Scanner kb = new Scanner(System.in);

    //======== sop and sopl methods =========
    //@parm str is a string that is going to be displayed
    //
    // sopl
    //
    public static void sopl(String str) {
        System.out.println(str);
    } //sopl string

    public static void sopl(int n) {
        System.out.println(n);
    } //sopl int

    public static void sopl(double d) {
        System.out.println(d);
    } //sopl double

    public static void sopl(char c) {
        System.out.println(c);
    } //sopl char

    public static void sopl(boolean b) {
        System.out.println(b);
    } //sopl boolean

    public static void sopl(int[] numArray) {
        sop("[");
        for (int n = 0; n < numArray.length - 1; n++) {
            sop(numArray[n] + ", ");
        }
        sopl(numArray[numArray.length - 1] + "]");
    } //sopl array
    
    public static void sopl(double[] numArray) {
        sop("[");
        for (int n = 0; n < numArray.length - 1; n++) {
            sop(numArray[n] + ", ");
        }
        sopl(numArray[numArray.length - 1] + "]");
    } //sopl array
    
    //
    // sop
    //
    public static void sop(String str) {
        System.out.print(str);
    } //sop string

    public static void sop(int n) {
        System.out.print(n);
    } //sop int

    public static void sop(double d) {
        System.out.print(d);
    } //sop double

    public static void sop(char c) {
        System.out.print(c);
    } //sop char

    public static void sop(boolean b) {
        System.out.print(b);
    } //sop boolean

    //======== read methods =========
    // @parm st is a prompt 
    // @return a int value read from the keyboard
    public static int getI(String st) {
        sop(st + " ");
        return kb.nextInt();
    } //getI

    public static double getD(String st) {
        sop(st + " ");
        return kb.nextDouble();
    } //getD

    public static String getS(String st) {
        sop(st + " ");
        return kb.next();
    } //getS

    public static String getLine(String st) {
        sop(st + " ");
        return kb.nextLine();
    } //getS

    public static char getC(String st) {
        sop(st + " ");
        return kb.next().charAt(0);
    } //getC
    
    public static double[] getDArray(String st, int n) {
        double[] numArray = new double[n];
        sop(st + " ");
        for(int j=0;j < n;j++)
            numArray[j] = kb.nextDouble();
        return numArray;
    }
    
    public static int[] getIArray(String st, int n) {
        int[] numArray = new int[n];
        sop(st + " ");
        for(int j=0;j < n;j++)
            numArray[j] = kb.nextInt();
        return numArray;
    }

    //========== Misc. Methods =========
    // @parm num is the number of lines to be skipped
    // creates blank lines for the num specifice
    public static void skip(int num) {
        for (int x = 0; x < num; x++) {
            sopl(" ");
        }
    } //skip

    //@parm num is the length of the string
    //@return a string the length of num
    public static String blankSpace(int num) {
        String blank = "";
        for (int x = 0; x < num; x++) {
            blank += " ";
        }
        return blank;
    } //blankSpaces 

    //catches white space character and moves on to next line
    public static String catchReturn() {
        return kb.nextLine();
    } //catchReturn

    public static int randomNum(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    } //random number generator

    //=========== my own unique methods =========
    //alternative to sopl("abc"); everytime you want to create a list
    //@parm str is the strings for the list
    //@return enter choice from list
    public static int selectMenu(String Header, String... str) {
        sopl("==== " + Header + " ====");
        int n = 1;

        for (String s : str) {
            sopl("[" + n++ + "] " + s);
        }
        return getI("\nEnter your Choice: ");
    } //showMenu

    //user needs to press [Enter] to continue
    public static void pause(String str) {
        sop(str);
        catchReturn();
        catchReturn();
    } //pause

    //@parm double data is the numbers by programmer
    //@return sum or average of numbers
    public static double Sum(double... data) {
        double sm = 0;
        for (double num : data) {
            sm += num;
        }
        return sm;
    } //sum of numbers

    public static double Average(double... data) {
        double avg = 0;
        for (double num : data) {
            avg += num;
        }
        avg = avg / data.length;
        return avg;
    } //average of numbers

} //UtilJava
