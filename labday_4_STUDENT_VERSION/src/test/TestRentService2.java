package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.RentService;

import java.lang.reflect.Method; 
import java.util.*;

/**
 * The test class TestRentService.
 *
 * @author  KNOL
 * @version 20241018
 */
public class TestRentService2 {
    private RentService rentService0;
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp(){
        // ARRANGE - shared arrange step
        rentService0 = new RentService(1, "Riding", 12.4);
    }

    @Test
    public void testGetNo() {
        //assert
        assertEquals(1, rentService0.getNo());
    }

    @Test
    public void testGetName() {
        //assert
        assertEquals("Riding", rentService0.getName());
    }

    @Test
    public void testGetPrice() {
        //assert
        assertEquals(12.4, rentService0.getPrice());
    }

    @Test
    public void testIsAvailable() {
        //assert
        assertEquals(true, rentService0.isAvailable());
    }

    @Test
    public void testSetName() {
        //act
        rentService0.setName("Horseback riding");
        //assert
        assertEquals("Horseback riding", rentService0.getName());
    }

    @Test
    public void testSetPrice() {
        //act
        rentService0.setPrice(100d);
        //assert
        assertEquals(100d, rentService0.getPrice());
    }

    @Test 
    public void testSetAvailable() {
        //act
        rentService0.setAvailable(false);
        //assert
        assertEquals(false, rentService0.isAvailable());
    }

    @Test
    public void testSpecification() {
        List<String> nlist = Arrays.asList(new String[]{
        "getName", "setName", "setPrice", "getPrice", "setNo", "getNo", "setAvailable",
        "isAvailable", "equals", "toString", "hashCode", "getClass", "notify", 
        "notifyAll", "wait"});
        Set<String> names = new HashSet<>(nlist);
        Method[] methods = RentService.class.getMethods();
        for(int i = 0; i < methods.length; i++) {
            assertTrue(names.contains(methods[i].getName()));
        }
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown(){
    }
}
