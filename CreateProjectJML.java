/*
 * Objective: Create statistical hypothesis calculator.
 */
package createprojectjml;

import java.util.Arrays;

public class CreateProjectJML {
    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int menuChoice;
        
        do {
            
            menuChoice = myUtil.selectMenu("STATISTICAL HYPOTHESIS TESTING CALCULATOR: Main Menu", "1-PropZTest", "1-SampTTest", "1-SampTTest (Data set input)", "χ2 GOF-Test", "QUIT");
            
            if (menuChoice == 1) {
                ztest();
            } //menuChoice == 1;
            else if (menuChoice == 2) {
                ttest();
            } //menuChoice == 2
            else if (menuChoice == 3) {
                ttest1();
            } //menuChoice == 3
            else if (menuChoice == 4) {
                chiSQ();
            } //menuChoice == 4
            
            if (menuChoice != 5) {
               myUtil.pause("\n\nPlease press [ENTER] to continue...");  
            } //end of if loop that carries out pause method; menuChoice == 4
            
        } while (menuChoice != 5);       
    } //main
    
    public static void ztest() {
        
        int subMenu;
        double pZ;
        double p0 = 0.5;
        double p = 0.0;
        int tail = 2;
        int n = 100;
        
        do {
        
            subMenu = myUtil.selectMenu(">>>1-PropZTest<<<", 
                    "Null Hypothesis (p0) : " + Double.toString(p0),
                    "Sample proportion (p̂) : " + Double.toString(p), 
                    "Sample size (n) : " + Integer.toString(n), 
                    "Tail (1 or 2) : " + Integer.toString(tail), 
                    "Run z-test", 
                    "Return");
        
            if (subMenu == 1) {
                p0 = myUtil.getD("Null Hypothesis p0 = ");
            } //subMenu == 1
            else if (subMenu == 2) {
                p = myUtil.getD("Sample Proportion p̂ = ");
            } //subMenu == 2
            else if (subMenu == 3) {
                n = myUtil.getI("Sample size n = ");
            } //subMenu == 3
            else if (subMenu == 4) {
                tail = myUtil.getI("Tail (1 or 2) = ");
            } //subMenu == 4
            else if (subMenu == 5) {
                //double h = myUtil.getD("h0: ");
                //double pH = myUtil.getD("p̂: ");
                pZ = myCreate.pNorm(p0, p, tail, n);
                dispResults(pZ);
                myUtil.pause("\n\nPlease press [ENTER] to continue...");
            } //subMenu == 5
            
        } while (subMenu != 6);  
    } //ztest
    
    public static void ttest() {
        
        int subMenu;
        double pT;
        double μ0 = 0;
        double ȳ = 1;
        double σ = 1;
        int tail = 2;
        int n = 100;
        
        do {
            
            subMenu = myUtil.selectMenu(">>>1-SampTTest<<<", 
                    "Null Hypothesis (μ0) : " + Double.toString(μ0),
                    "Sample mean (ȳ) : " + Double.toString(ȳ),
                    "Standard deviation (σ) : " + Double.toString(σ),
                    "Sample size (n) : " + Integer.toString(n), 
                    "Tail (1 or 2) : " + Integer.toString(tail), 
                    "Run t-test", 
                    "Return");
            
            if (subMenu == 1) {
                μ0 = myUtil.getD("Null Hypothesis μ0 = ");
            } //subMenu == 1
            else if (subMenu == 2) {
                ȳ = myUtil.getD("Sample Proportion ȳ = ");
            } //subMenu == 2
            else if (subMenu == 3) {
                σ = myUtil.getD("Standard deviation σ = ");
            } //subMenu == 3
            else if (subMenu == 4) {
                n = myUtil.getI("Sample size n = ");
            } //subMenu == 4
            else if (subMenu == 5) {
                tail = myUtil.getI("Tail (1 or 2) = ");
            } //subMenu == 5
            else if (subMenu == 6) {
                //double h = myUtil.getD("h0: ");
                //double pH = myUtil.getD("p̂: ");
                pT = myCreate.pTDist(μ0, ȳ, σ, n, tail);
                dispResults(pT);
                myUtil.pause("\n\nPlease press [ENTER] to continue...");
            } //subMenu == 6
            
        } while (subMenu != 7);   
    } //ttest
    
    public static void ttest1() {
        
        int subMenu;
        double pT;
        double μ0 = 0;
        double ȳ = 1;
        double σ = 1;
        int tail = 2;
        int n = myUtil.getI("Sample size n = ");
        double[] numArray;
        numArray = myUtil.getDArray("Data = ", n);
        
        do {
            
            subMenu = myUtil.selectMenu(">>>1-SampTTest (Data input)<<<", 
                    "Null Hypothesis (μ0) : " + Double.toString(μ0),
                    "Sample Size n :  " + Integer.toString(n),
                    "Data : " + Arrays.toString(numArray), 
                    "Tail (1 or 2) : " + Integer.toString(tail), 
                    "Run t-test", 
                    "Return");
            
            if (subMenu == 1) {
                μ0 = myUtil.getD("Null Hypothesis μ0 = ");
            } //subMenu == 1
            else if (subMenu == 2) {
                n = myUtil.getI("Sample size n = ");
            } //subMenu == 4
            else if (subMenu == 2) {
                ȳ = myCreate.mean(numArray);
            } //subMenu == 2
            else if (subMenu == 3) {
                σ = myCreate.std(numArray);
            } //subMenu == 3
            
            else if (subMenu == 5) {
                tail = myUtil.getI("Tail (1 or 2) = ");
            } //subMenu == 5
            else if (subMenu == 6) {
                //double h = myUtil.getD("h0: ");
                //double pH = myUtil.getD("p̂: ");
                pT = myCreate.pTDist(μ0, ȳ, σ, n, tail);
                dispResults(pT);
                myUtil.pause("\n\nPlease press [ENTER] to continue...");
            } //subMenu == 6
            
        } while (subMenu != 7);   
    } //ttest
    
    public static void chiSQ() {
        
        int subMenu;
        double pChi;
        int n = 5;
        int[] obsArray = new int[n];
        double[] expArray = new double[n];
        
        
        do {
            
            subMenu = myUtil.selectMenu(">>>χ2 GOF-Test<<<", 
                    "Sample size (n) : " + Integer.toString(n),
                    "Observed values : " + Arrays.toString(obsArray),
                    "Expected values : " + Arrays.toString(expArray), 
                    "Run χ2 test", 
                    "Return");
            
            if (subMenu == 1) {
                n = myUtil.getI("Category Count n = ");
            } //subMenu == 1
            else if (subMenu == 2) {
                obsArray = myUtil.getIArray("Observed values = ", n);
            } //subMenu == 2
            else if (subMenu == 3) {
                expArray = myUtil.getDArray("Expected values = ", n);
            } //subMenu == 3
            else if (subMenu == 4) {
                pChi = myCreate.pChiSQ(obsArray, expArray);
                dispResults(pChi);
                myUtil.pause("\n\nPlease press [ENTER] to continue...");
            } //subMenu == 4
            
        } while (subMenu != 5);  
    } //chiSQ
       
    public static void dispResults(double p) {
        myUtil.sop("\n>>>Results<<<");
        myUtil.sopl("\np: " + p);
        myCreate.hypoTest(p);
    } //dispResults
    
} //createProjectJML


