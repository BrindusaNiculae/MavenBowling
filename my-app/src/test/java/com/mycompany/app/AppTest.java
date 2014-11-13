package com.mycompany.app;

import java.io.FileNotFoundException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp1() throws FileNotFoundException
    {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game1.txt");
        int expResult = 20;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }
    public void testApp3() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game3.txt");
        int expResult = 300;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    public void testApp4() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game4.txt");
        int expResult = 16;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    
    public void testApp5() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game5.txt");
        int expResult = 24;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    public void testApp6() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game6.txt");
        int expResult = 69;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    public void testApp7() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game7.txt");
        int expResult = 79;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    public void testApp8() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game8.txt");
        int expResult = 112;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

     public void testApp9() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game9.txt");
        int expResult = 104;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    public void testApp10() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game10.txt");
        int expResult = 215;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    public void testApp11() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game11.txt");
        int expResult = 243;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

     public void testApp12() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game12.txt");
        int expResult = 201;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    public void testApp13() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game13.txt");
        int expResult = 143;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

   public void testApp14() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game14.txt");
        int expResult = 115;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

     public void testApp15() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game15.txt");
        int expResult = 159;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    public void testApp16() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game16.txt");
        int expResult = 135;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

    public void testApp17() throws FileNotFoundException {
        System.out.println("computeScoreFor");

        Bowling instance = new Bowling();
        int[] rolls = instance.readFile("game17.txt");
        int expResult = 77;
        int result = instance.computeScoreFor(rolls);
        assertEquals(expResult, result);

    }

}
