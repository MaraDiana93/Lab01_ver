package view;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.InvalidBudgetException;
import exceptions.InvalidNameException;
import exceptions.InvalidTypeException;
import model.Member;
import controller.MemberRepository;
import controller.MembersController;;

public class ConsoleInterface {

	private MemberRepository repo;
	private MembersController ctrl;

	public ConsoleInterface(MemberRepository repo) {
		this.ctrl = new MembersController(repo);
		this.repo = repo;
	}

	public void run() throws InvalidTypeException, IOException {
		while (true) {
			displayMenu();
			int command;
			Scanner s = new Scanner(System.in);
			try {
				command = s.nextInt();
				switch (command) {
				case 1: {
					System.out.println("Please give a name");
					String name = s.next();
					System.out.println("Please give an income");
					String income = s.next();
					System.out.println("Please give a costs");
					String costs = s.next();
					final Member member = new Member();
					member.setName(name);
					member.setIncome(Integer.parseInt(income));
					member.setCosts(Integer.parseInt(costs));
					ctrl.create(member);
					break;
				}
				case 2: {
					System.out.println("Please give a type");
					String type = s.next();
					System.out.println("Please give an income/cost");
					int value = s.nextInt();
					ctrl.addNewEntry(type, value);
					break;
				}
				case 3: {
					System.out.println("Please give a member name");
					String memberName = s.next();
					System.out.println("Record:");
					for (String record : ctrl.getMemberEvolution(memberName)) {
						System.out.println(record);
					}
					break;
				}
				case 4: {
					s.close();
					return;
				}
				}
			} catch (InputMismatchException ex) {
				System.out.println("Please try again");
				continue;
			} catch (InvalidBudgetException e) {
				System.out.println("Invalid Budget " + e.getMessage());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (InvalidNameException e) {
				System.out.println("Invalid Name " + e.getMessage());
			}
		}
	}

	static void displayMenu() {
		System.out.println("1. Add member");
		System.out.println("2. Add income/cost");
		System.out.println("3. List incomes/costs for a member");
		System.out.println("4. Exit");
	}

}
