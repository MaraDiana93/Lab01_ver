package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exceptions.InvalidBudgetException;
import exceptions.InvalidNameException;
import exceptions.InvalidTypeException;
import model.*;
import exceptions.*;
//import controller.MemberRepository;

public class MembersController {
	private MemberRepository repo;
	public MembersController(MemberRepository repo)
	{
		this.repo = repo;
	}
	
	public void create(Member member) throws InvalidBudgetException, InvalidNameException
	{
		try
		{
			this.repo.create(member);
		}
		catch(InvalidBudgetException e)
		{
			e.printStackTrace();
		}
	}
	
	public void addNewEntry(String type, int value)
	{
		try
		{
			this.repo.addNewEntry(type, value);
		}
		catch(InvalidBudgetException e)
		{
			e.printStackTrace();
		} catch (InvalidTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getMemberEvolution(String memberName)
	{
		try
		{
			return this.repo.getMemberEvolution(memberName);
			
		}
		catch(InvalidNameException e  )
		{
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	public List<Member> getAll()
	{
		return this.repo.getAll();
	}
	
	public void eraseAll()
	{
		try
		{
			this.repo.eraseAll();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public int getFamilyIncome()
	{
		return this.repo.getFamilyIncome();
	}
	
	public int getFamilyCosts()
	{
		return this.repo.getFamilyCosts();
	}
}
