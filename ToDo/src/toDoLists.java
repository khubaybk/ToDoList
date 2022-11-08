import java.util.Date;
import java.util.Scanner;

public class toDoLists {
	ArrayList<Tasks> toDoList;

	public toDoLists() {
		toDoList = new ArrayList<Tasks>();
	}
	
	public void showAllTasks() {
		if (toDoList.size() > 0) {
			//For loop to cycle through all tasks and and output them
			for (int i = 0; i < toDoList.size(); i++) {
				//Explicit casting for the element
				Tasks t = (Tasks) toDoList.getElement(i);
				System.out.println(t.nameOfTask() + " " + t.getDescription() + " " + t.getStartDate() + " "
						+ t.getEndDate() + " Index " + i);

			}
		} else {
			System.out.println("No items exist in the list");
		}
	}
	//Add item to list by first creating the object then adding it
	public void addToList(String nameOfTask, String description, String startDate, String endDate) { // User
		Tasks a = new Tasks(nameOfTask, description, startDate, endDate);
		toDoList.add(a);
	}
	//This method removes a task by its index
	public void removeTask(int index) {
		if (toDoList.size() > 0) {
			toDoList.remove(index);
		} else {
			System.out.println("No items in the list. Please add one to remove one");
		}
	}
	//method to find the task but calls the array search method
	public void findTask(String response) {
		toDoList.findToDo(response);
	}
	//Method to check of the item exists and calls the arrayList method
	public void checkIfTaskExists(String response) {
		if(toDoList.checkIfItemExists(response)) {
			System.out.println("Item exists");
		}
		
	}
	//Return the size of the array 
	public int getSize() {
		return toDoList.size;
	}
}