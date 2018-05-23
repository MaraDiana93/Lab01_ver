import controller.MemberRepository;

import java.io.IOException;

import exceptions.InvalidTypeException;
import view.ConsoleInterface;


public class Main {

	
	public static void main(String[] args) {
		MemberRepository repo;
		try {
			repo = new MemberRepository();
			ConsoleInterface ui = new  ConsoleInterface(repo);
			ui.run();
		} catch (IOException e) {
			System.out.println("Application could not start:"+e.getMessage());
		} catch (InvalidTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

}
