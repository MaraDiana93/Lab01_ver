package test.java;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import model.Member;

import org.junit.Before;
import org.junit.Test;

import controller.MemberRepository;
import exceptions.InvalidNameException;

public class Incremental_Test {

	MemberRepository mr;

    @Before
    public void start() throws Exception {
        String testFile = "test";
        this.mr = new MemberRepository(testFile);
        //this.mr.eraseAll();
    }

    @Test
    public void tc_ia() throws Exception {
		String name = "Alex";
		int income = 500;
		int cost = 100;
		
		Member m = new Member();
		m.setCosts(cost);
		m.setIncome(income);
		m.setName(name);
		mr.create(m);
		
		name = "Alex";
		income = 300;
		cost = 100;
		
		Member m2 = new Member();
		m.setCosts(cost);
		m.setIncome(income);
		m.setName(name);
		mr.create(m2);

		
//		name = "Alex";
//		income = 100;
//		cost = 100;
//		
//		Member m3 = new Member();
//		m.setCosts(cost);
//		m.setIncome(income);
//		m.setName(name);
//		mr.create(m3);

        
        
    }

    @Test
    public void tc_iab() throws Exception {
    	int value = 200;
		String type = "income";
        mr.addNewEntry(type, value);
    }

    @Test
    public void tc_iabc() throws Exception {
    	
		String name = "Alex";
		try {
			 List<String> l = mr.getMemberEvolution(name);
			assertEquals(2, l.size());
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
