package com.naman.springboot.myfirstwebapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyfirstwebappApplicationTests {

    @Test
    void contextLoads() {
    }

    List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");

    @Test
    void testAsserts() {
        boolean test = todos.contains("AWS");//Result
        boolean test2 = todos.contains("GCP");//Result
        assertTrue(test);
        assertFalse(test2);
        assertEquals(3, todos.size());
    }

    private MyMath math = new MyMath();

    @Test
    void calculateSum_ThreeMemberArray() {
        assertEquals(6, math.calculateSum(new int[] {1,2,3}));
    }

    @Test
    void calculateSum_ZeroLengthArray() {
        assertEquals(0, math.calculateSum(new int[] {}));
    }

    @Test
    void calculateSum_RerunFalse() {
        assertNotEquals(16, math.calculateSum(new int[] {1,2,3,4,5}));
    }

}
