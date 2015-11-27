package com.mycompany.app;

import bowlingRefactor.Player;
import java.io.FileNotFoundException;

import bowlingRefactor.ScoreHandler;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp1() throws FileNotFoundException {
        System.out.println("computeScoreFor1");
        Player p = new Player("game1.txt");
        p.play();

        final int expResult = 20;
        p.publishScoreTo(new AssertScoreEquals(expResult));
    }

    public void testApp2() throws FileNotFoundException {
        System.out.println("computeScoreFor2");
        Player p = new Player("game2.txt");
        p.play();

        int expResult = 0;
        p.publishScoreTo(new AssertScoreEquals(expResult));

    }

    public void testApp3() throws FileNotFoundException {
        System.out.println("computeScoreFor3");
        Player p = new Player("game3.txt");
        p.play();

        int expResult = 300;
        p.publishScoreTo(new AssertScoreEquals(expResult));
    }

    public void testApp4() throws FileNotFoundException {
        System.out.println("computeScoreFor4");

        Player p = new Player("game4.txt");
        p.play();

        int expResult = 16;
        p.publishScoreTo(new AssertScoreEquals(expResult));
    }

    public void testApp5() throws FileNotFoundException {
        System.out.println("computeScoreFor5");

        Player p = new Player("game5.txt");
        p.play();

        int expResult = 24;
        p.publishScoreTo(new AssertScoreEquals(expResult));
    }

    public void testApp6() throws FileNotFoundException {
        System.out.println("computeScoreFor6");

        Player p = new Player("game6.txt");
        p.play();

        int expResult = 69;
        p.publishScoreTo(new AssertScoreEquals(expResult));
    }

    public void testApp7() throws FileNotFoundException {
        System.out.println("computeScoreFor7");

        Player p = new Player("game7.txt");
        p.play();

        int expResult = 79;
        p.publishScoreTo(new AssertScoreEquals(expResult));
    }

    public void testApp8() throws FileNotFoundException {
        System.out.println("computeScoreFor8");

        Player p = new Player("game8.txt");
        p.play();

        int expResult = 112;
        p.publishScoreTo(new AssertScoreEquals(expResult));
    }

    public void testApp9() throws FileNotFoundException {
        System.out.println("computeScoreFor9");

        Player p = new Player("game9.txt");
        p.play();

        int expResult = 104;
        p.publishScoreTo(new AssertScoreEquals(expResult));
    }

    public void testApp10() throws FileNotFoundException {
        System.out.println("computeScoreFor10");

        Player p = new Player("game10.txt");
        p.play();

        int expResult = 215;
        p.publishScoreTo(new AssertScoreEquals(expResult));
    }

    public void testApp11() throws FileNotFoundException {
        System.out.println("computeScoreFor11");

        Player p = new Player("game11.txt");
        p.play();

        int expResult = 243;
        p.publishScoreTo(new AssertScoreEquals(expResult));
    }

    public void testApp12() throws FileNotFoundException {
        System.out.println("computeScoreFor12");

        Player p = new Player("game12.txt");
        p.play();

        int expResult = 201;
        p.publishScoreTo(new AssertScoreEquals(expResult));
    }

    public void testApp13() throws FileNotFoundException {
        System.out.println("computeScoreFor13");
        Player p = new Player("game13.txt");
        p.play();

        int expResult = 143;
        p.publishScoreTo(new AssertScoreEquals(expResult));
    }

    public void testApp14() throws FileNotFoundException {
        System.out.println("computeScoreFor14");

        Player p = new Player("game14.txt");
        p.play();

        int expResult = 115;
        p.publishScoreTo(new AssertScoreEquals(expResult));
    }

    public void testApp15() throws FileNotFoundException {
        System.out.println("computeScoreFor15");

        Player p = new Player("game15.txt");
        p.play();

        int expResult = 159;
        p.publishScoreTo(new AssertScoreEquals(expResult));
    }

    public void testApp16() throws FileNotFoundException {
        System.out.println("computeScoreFor16");

        Player p = new Player("game16.txt");
        p.play();

        int expResult = 135;
        p.publishScoreTo(new AssertScoreEquals(expResult));
    }

    public void testApp17() throws FileNotFoundException {
        System.out.println("computeScoreFor17");
        Player p = new Player("game17.txt");
        p.play();

        int expResult = 77;
        p.publishScoreTo(new AssertScoreEquals(expResult));
    }

    //~~~~~~~ Remember: Tell don't ask ~~~~~~


    private static class AssertScoreEquals implements ScoreHandler {
        private final int expResult;

        public AssertScoreEquals(int expResult) {
            this.expResult = expResult;
        }

        @Override
        public void publish(int score) {
            assertEquals(expResult, score);;
        }
    }
}
