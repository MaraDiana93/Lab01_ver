package test.java;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import controller.MemberRepository;
import exceptions.InvalidBudgetException;
import exceptions.InvalidNameException;
import exceptions.InvalidTypeException;


public class Lab03_WBT_Test {

	private MemberRepository mr;
	@Before
	public void setUp() throws Exception {
		mr = new MemberRepository();
	}
	
	@Test
	public void test_1() {
		int value = 200;
		String type = "income";
		
		try {
			assertTrue(mr.addNewEntry(type, value));
		} catch (InvalidBudgetException e) {
			fail("Assertion failed");
		} catch (InvalidTypeException e) {
			fail("Assertion failed");
		}
		
	}
	@Test
	public void test_2() {
		int value = -1;
		String type = "income";
		
		try {
			mr.addNewEntry(type, value);
		} catch (InvalidBudgetException e) {
			assertTrue(true);
		} catch (InvalidTypeException e) {
			fail("Assertion failed");
		}
		
	}
	@Test
	public void test_3() {
		int value = 200;
		String type = "name";
		
		try {
			mr.addNewEntry(type, value);
		} catch (InvalidBudgetException e) {
			fail("Assertion failed");
		} catch (InvalidTypeException e) {
			assertTrue(true);
		}
		 
	}
}
