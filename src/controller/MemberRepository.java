package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import util.FileOperations;
import model.Family;
import model.Member;
import exceptions.InvalidBudgetException;
import exceptions.InvalidNameException;
import exceptions.InvalidTypeException;

public class MemberRepository {
	private List<Member> members = new ArrayList<Member>();
	private Family family = new Family();
	private String filename = "D:\\faculta\\an3\\sem2\\verificare\\eclipse\\src\\controller\\membersFile";

	@SuppressWarnings("resource")
	
	public MemberRepository(String fl)
	{
		filename = fl;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String currentLine = null;

		try {
			fileReader = new FileReader(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bufferedReader = new BufferedReader(fileReader);
		
		try {
			while ((currentLine = bufferedReader.readLine()) != null) {
				String line[] = currentLine.split(";");
				Member m = new Member();
				m.setName(line[0]);
				m.setIncome(Integer.parseInt(line[1]));
				m.setCosts(Integer.parseInt(line[2]));
				
				this.members.add(m);
				this.family.addCost(m.getCosts());
				this.family.addIncome(m.getIncome());
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public MemberRepository() throws IOException {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String currentLine = null;

		fileReader = new FileReader(filename);
		bufferedReader = new BufferedReader(fileReader);
		
		while ((currentLine = bufferedReader.readLine()) != null) {
			String line[] = currentLine.split(";");
			Member m = new Member();
			m.setName(line[0]);
			m.setIncome(Integer.parseInt(line[1]));
			m.setCosts(Integer.parseInt(line[2]));
			
			this.members.add(m);
			this.family.addCost(m.getCosts());
			this.family.addIncome(m.getIncome());
		}
	}

	public String create(Member member) throws InvalidBudgetException, InvalidNameException {
		if (member.getIncome() == -1 || member.getIncome() < 90) {
			throw new InvalidBudgetException();
		}	
		
		if (member.getCosts() == -1 || member.getCosts() < 90) {
			throw new InvalidBudgetException();
		}	
		
		if(member.getName().length() > 0) { 
			char first = member.getName().charAt(0);
			if (member.getName() == null || member.getName().equals("") && member.getName().length() > 50 || !(Character.isUpperCase(first))) {
				throw new InvalidNameException();
			}

		}
		else {
			throw new InvalidNameException();
		}
		
		this.members.add(member);
		this.family.addCost(member.getCosts());
		this.family.addIncome(member.getIncome());
		this.save();
		return "Success";
	}
	
	public boolean addNewEntry(String type, int value) throws InvalidBudgetException, InvalidTypeException {
		if (value <= 0) {
			throw new InvalidBudgetException();
		}
		
		if (!(type.equals("income")||type.equals("cost"))) {
			throw new InvalidTypeException();
		}
		
		family.addEntry(type, value);
		return true;
	}
	
	@SuppressWarnings("resource")
	public ArrayList<String> getMemberEvolution(String memberName) throws IOException,
			NumberFormatException, InvalidNameException {
		ArrayList<String> evolutionList = new ArrayList<String>();

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		fileReader = new FileReader(filename);
		bufferedReader = new BufferedReader(fileReader);
		
		String currentLine;
		
		if (memberName == null || memberName.equals("") && memberName.length() <10) {
			throw new InvalidNameException();
		}
		
		while ((currentLine = bufferedReader.readLine()) != null) {
			String line[] = currentLine.split(";");
			String name = line[0];
			
			if (name.equals(memberName))
				evolutionList.add("income = " + line[1] + ",costs = " + line[2]);
		}
		
		if (evolutionList.size() == 0) {
			throw new InvalidNameException();
		}
		return evolutionList;
	}

	public void update(Member o) {
		// TODO Auto-generated method stub

	}

	public void delete(Member o) {
		// TODO Auto-generated method stub

	}

	public List<Member> getAll() {
		return this.members;
	}

	private void save() {
		FileOperations fileWriter = new FileOperations(this.filename);
		List<List<String>> lines = new ArrayList<List<String>>();
		for (Member m : this.members) {
			List<String> line = new ArrayList<String>();
			line.add(m.getName());
			line.add(Integer.toString(m.getIncome()));
			line.add(Integer.toString(m.getCosts()));
			lines.add(line);
		}
		fileWriter.write(lines);
	}
	
	public void eraseAll() throws IOException {
		FileOutputStream writer = new FileOutputStream(filename);
		writer.write(0);
	
		writer.close();
		this.family.eraseAll();
		this.members.clear();
	}
	
	public int getFamilyIncome() {
		return family.getIncome();
	}

	public int getFamilyCosts() {
		return family.getCost();
	}
}
