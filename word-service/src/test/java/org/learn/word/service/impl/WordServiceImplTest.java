/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.learn.word.service.impl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.learn.word.service.WordService;
import static org.junit.Assert.*;

/**
 *
 * @author dillip
 */
public class WordServiceImplTest {

    public WordServiceImplTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getWord method, of class WordServiceImpl.
     */
    @Test
    public void testGetWord() {
        System.out.println("getWord");



        WordService wordService = new WordServiceImpl();
        int[] values = new int[]{
            1, 21, 105,
            0,
            4,
            10,
            12,
            100,
            108,
            299,
            1000,
            1003,
            2040,
            45213,
            100000,
            100005,
            100010,
            202020,
            202022,
            999999,
            1000000,
            1000001,
            10000000,
            10000007,
            99999999,
            1000000,
            1000,
            2000,
            4000001 
//            56945781
        };



        for (int val : values) {
            System.out.println(val + " = " + wordService.getWord(val));
        }


        int number = 56945781;

        String expResult = "fifty six million nine hundred and forty five thousand seven hundred and eighty one";

        String result = wordService.getWord(number);
        assertEquals(expResult, result);
    }
}
