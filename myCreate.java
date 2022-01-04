/*
 * Objective: Create methods to be used for statistical hypothesis calculator.
 */

package createprojectjml;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.apache.commons.math3.distribution.TDistribution;

public class myCreate {    
    
    //General needed methods
    public static double sumUp(double[] numArray) { 
        double sum = 0;
        for (double item : numArray) 
            sum += item;
        return sum;
    } //sumUp() all numbers
    
    public static int tail() { 
        int tail = myUtil.getI("Tail (1 or 2): ");
        if (tail == 1)
            tail = 1;
        else if (tail == 2)
            tail = 2;
        return tail;
    } //determine one or two tail testing

    public static double mean(double[] numArray) {
        int sum = 0;
        for (double item : numArray) 
            sum += item;
        return sum / numArray.length;
    } //mean() all numbers
    
    public static double std(double[] numArray) {
        double var;
        double std;
        double mean = myCreate.mean(numArray);
        double[] s = new double[numArray.length];
        for (int i = 0; i < numArray.length; i++)
            s[i] = Math.pow(numArray[i] - mean, 2);
        double sx = myCreate.sumUp(s);
        var = sx / (numArray.length - 1);
        std = Math.sqrt(var);
        return std;
    } //finding standard deviation of numbers in array
    
    public static void hypoTest(double p) {
        if (p > 0.05)
            myUtil.sopl("Fail to reject the null hypothesis");
        else
            myUtil.sopl("Reject the null hypothesis.");
    } //hypoTest; determine reject or fail to reject
    
    //Chi-Squared
    public static double chiSQ(int[] obsArray, double[] expArray) {
        int n = obsArray.length;
        double[] chiSQ = new double[n];
        for (int i = 0; i < n; i++)
            chiSQ[i] = (Math.pow(obsArray[i]-expArray[i], 2))/expArray[i];
        return myCreate.sumUp(chiSQ);
    } //calculates chi squared value
    
    //returns p value from GOF chi squared test
    public static double pChiSQ(int[] obsArray, double[] expArray) {
        double p = 0.0;
        double chiSQ = myCreate.chiSQ(obsArray, expArray);
        ChiSquaredDistribution chi = new ChiSquaredDistribution(obsArray.length - 1);
        p = 1.0 - chi.cumulativeProbability(chiSQ);
        return p;
    } //pChiSQ
    
    //Normal Distribution
    public static double zScore(double mean, double actual, double std) {
        double z;
        z = (actual - mean) / std;
        return z;
    } //z-score
    
    public static double sdZ(double h, int n) {
        //int n = myUtil.getI("Sample size: ");
        double sd = Math.sqrt((h * (1 - h)) / n);
        return sd;
    } //standard deviation
    
    //returns p value from z-test
    public static double pNorm(double h, double pH, int tail, int n) {
        double p = 0.0;
        //double h = myUtil.getD("h0: ");
        //double std = myUtil.getD("Standard deviation: ");
        //double pH = myUtil.getD("pHat: ");
        double sd = myCreate.sdZ(h, n);
        double z = (pH - h) / sd;
        NormalDistribution dist = new NormalDistribution();
        //int tail = myCreate.tail();
        if (tail == 1)
            p = 1.0 - dist.cumulativeProbability(Math.abs(z));
        else if (tail == 2)
            p = 2 * (1.0 - dist.cumulativeProbability(Math.abs(z)));
        return p;
    } //pNorm
    
    //T-Distribution   
    public static double tVal(double mean, double actual, double s) {
        double t;
        int n = myUtil.getI("Sample size: ");
        double sd = s / Math.pow(n, 0.5);
        t = (mean - actual) / sd;
        return t;
    } //t value or statistics
    
    public static double sdT(double s, int n) {
        double sd = s / Math.sqrt(n);
        return sd;
    } //standard deviation calculation (sdT)
    
    //returns p value from T-test
    public static double pTDist(double mu, double x, double sigma, int n, int tail) {
        double p = 0.0;
        //double h = myUtil.getD("h0: ");
        //double std = myUtil.getD("Standard deviation: ");
        //double pH = myUtil.getD("pHat: ");
        //int n = myUtil.getI("Sample size: ");
        double sd = myCreate.sdT(sigma, n);
        double t = (x - mu) / sd;
        TDistribution dist = new TDistribution(n-1);
        //int tail = myCreate.tail();
        if (tail == 1)
            p = 1.0 - dist.cumulativeProbability(Math.abs(t));
        else if (tail == 2)
            p = 2 * (1.0 - dist.cumulativeProbability(Math.abs(t)));
        return p;
    } //pTDist
    
} //myCreate

