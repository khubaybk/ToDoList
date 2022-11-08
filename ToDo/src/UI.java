import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
	boolean running = true;
	toDoLists t = new toDoLists();

	public static void main(String[] args) {
		UI i = new UI();
		while (i.running == true) {
			i.showMenu();
			i.user();
		}

	}
	
	//User menu
	public void showMenu() {
		System.out.println("***************************************************************");
		System.out.println("Welcome to the user interface for a to do list");
		System.out.println("Press 1 to add a to do Item");
		System.out.println("Press 2 to add a to remove an item");
		System.out.println("Press 3 to find a task by name");
		System.out.println("Press 4 to check if an item exists");
		System.out.println("Press 5 to show all tasks");
		System.out.println("Press 6 count how many tasks you currently have");
		System.out.println("Press 7 to exit");
		System.out.println("***************************************************************");
	}
	
	//This takes the user input
	public void user() {
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			addToList();
			break;
		case 2:
			removeItem();
			break;
		case 3:
			find();
			break;
		case 4:
			checkItem();
			break;
		case 5:
			showAllTasks();
			break;
		case 6:
			countTasks();
			break;
		case 7:
			//Keep running the loop and break here if the user enters 7
			running = false;
			break;
		default:
			//User has entered incorrect input
			System.err.println("Please enter a valid input");
		}

	}
	//method to add a task to the list by calling the toDoList 
	public void addToList() {
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter the name of the Task");
		String name = s.nextLine();
		System.out.println("Please enter the desccription for the task MM/DD/YY");
		String description = s.nextLine();
		System.out.println("Please enter the start date  MM/DD/YY");
		String startDate = s.nextLine();
		System.out.println("Please enter the end date");
		String endDate = s.nextLine();
		t.addToList(name, description, startDate, endDate);
		System.out.println("Item Added: Name - " + name + " Description - " + description + " Start Date - " + startDate +" End Date - " + endDate);
	}
	//Method to remove item from arrayList
	public void removeItem() {
		try {
			Scanner s = new Scanner(System.in);
			t.showAllTasks();
			System.out.println("Please Enter the Index");
			int choice = s.nextInt();
			t.removeTask(choice);
			showAllTasks();
		} catch (InputMismatchException e) {
			System.out.println("Please Enter A number");
			removeItem();
		}
	}
	//Method for the user to find an item in the list
	public void find() {
		if (t.getSize() == 0) {
			System.out.println("No Item exists");
		} else {
			Scanner s = new Scanner(System.in);
			System.out.println("Please enter the name of the task you are looking for");
			String response = s.nextLine();
			t.findTask(response); 
		}
	}
	//Method to check item exists
	public void checkItem() {
		if (t.getSize() == 0) {
			System.out.println("No Item exists");
		} else {
			Scanner s = new Scanner(System.in);
			System.out.println("Please enter the name of the task you are looking for");
			String response = s.nextLine();
			t.checkIfTaskExists(response);
		}
	}
	//method to show all tasks
	public void showAllTasks() {
		t.showAllTasks();
	}
	//Method to countTasks
	public void countTasks() {
		System.out.println("You have " +t.getSize() + " in the list");
	}
}
