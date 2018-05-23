package test.java;
import static org.junit.Assert.*;
import model.Member;

import org.junit.Before;
import org.junit.Test;

import controller.MemberRepository;
import exceptions.InvalidBudgetException;
import exceptions.InvalidNameException;


public class Lab01_ver_Test {
	private MemberRepository mr;
	@Before
	public void setUp() throws Exception {
		mr = new MemberRepository();
	}

	@Test
	public void testCreate1() {
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
	public void testCreate5() {
		String name = "Alex";
		int income = Integer.MAX_VALUE;
		
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
	public void testCreate6() {
		String name = "Alex";
		int income = Integer.MAX_VALUE-1;
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
	public void testCreate7() {
		String name = "Alex";
		int income = 500;
		int cost = Integer.MAX_VALUE;
		
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
	public void testCreate8() {
		String name = "Alex";
		int income = 500;
		int cost = Integer.MAX_VALUE-1;
		
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
	public void testCreate9() {
		String name = "A";
		for(int i=0;i<50;i++)
			name += "a";
		int income = 500;
		int cost = Integer.MAX_VALUE-1;
		
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
	public void testCreate2()
	{
		Member m2 = new Member();
		m2.setCosts(500);
		m2.setIncome(30);
		m2.setName("Alex");
		
		try {
			mr.create(m2);
		} catch (InvalidBudgetException expectedException) {
			assertTrue(true);		
		} catch (InvalidNameException e) {
			fail("Failed assertion");
		}
	}

	
	@Test
	public void testCreate3()
	{
		Member m3 = new Member();
		m3.setCosts(30);
		m3.setIncome(300);
		m3.setName("Alex");
		
		try {
			mr.create(m3);
		} catch (InvalidBudgetException expectedException) {
			assertTrue(true);		
		} catch (InvalidNameException e) {
			fail("Failed assertion");
		}
		
	}
	
	@Test 
	public void testCreate4()
	{
		Member m4 = new Member();
		m4.setCosts(200);
		m4.setIncome(300);
		m4.setName("alex");
		
		try {
			mr.create(m4);
		} catch (InvalidBudgetException expectedException) {
			fail("Failed assertion");
		} catch (InvalidNameException e) {
			//fail("Dsa");
			assertTrue(true);
		}
	}
}
