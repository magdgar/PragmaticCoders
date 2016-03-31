package com.magda.test;

import com.magda.ChartDrawer;

import static org.junit.Assert.*;

/**
 * Created by magdgar on 2016-03-31.
 */
public class ChartDrawerTest {
    ChartDrawer chartDrawer;

    @org.junit.Before
    public void setUp() throws Exception {
        int[] results = {1,1,1,0,-1,-1,1,1,0,0};
        chartDrawer = new ChartDrawer(results);
    }

    @org.junit.Test
    public void testGetChartAsString() throws Exception {
        final String s = "Y\n^\n|         \n" +
                "|  _    __\n" +
                "| / \\  /  \n" +
                "|/   \\/   \n" +
                "/--------------------------------> X\n" +
                "|         \n" +
                "|         \n" +
                "|         \n" +
                "|         \n" +
                "|         \n";
        assertTrue(chartDrawer.getChartAsString().equals(s));
    }
}