package test.java;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import model.Member;

import org.junit.Before;
import org.junit.Test;

import controller.MemberRepository;
import exceptions.InvalidBudgetException;
import exceptions.InvalidNameException;
import exceptions.InvalidTypeException;

public class BigBang_Test {

	private MemberRepository mr;
	@Before
	public void setUp() throws Exception {
		mr = new MemberRepository();
	}
	
	@Test
	public void test_a() {
		try {
			mr.eraseAll();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String name = "Alex";
		int income = 500;
		int cost = 100;
		
		Member m = new Member();
		m.setCosts(cost);
		m.setIncome(income);
		m.setName(name);
		
		try {
			assertEquals("Success", mr.create(m));
		} catch (InvalidBudgetException expectedException) {
			fail("Failed assertion");		
		} catch (InvalidNameException e) {
			fail("Failed assertion");
		}
	}
	@Test
	public void test_b() {
		
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
	public void test_c() {
		String name = "Alex";
		try {
			 List<String> l = mr.getMemberEvolution(name);
			assertEquals(1, l.size());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			fail("Assertion failed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			fail("Assertion failed");
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			fail("Assertion failed");
		}
		
	}
}
