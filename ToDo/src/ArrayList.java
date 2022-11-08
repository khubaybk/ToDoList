import java.lang.IllegalArgumentException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayList<E> implements LinearList {
	protected Object[] elementsForArray;
	protected int size;

	// This is my constructor with a parameter to choose a size
	public ArrayList(int capacity) {
		elementsForArray = new Object[capacity];
		size = capacity;
		if (capacity < 0)
			throw new IllegalArgumentException("capacity must be >= 1");

	}

	// This is my constructor with a default constructor
	public ArrayList() {
		elementsForArray = new Object[0];
		size = 0;
	}

//This is a method that checks if the array is empty 
	@Override
	public boolean isEmpty() {
		if (size == 0) {
			// If array is empty return false
			return false;
		} else {
			// If array is not empty return true
			return true;
		}
	}

//This is a method that checks the size of the array with values that are not null
	@Override
	public int size() {
		// Declare count to be zero
		int count = 0;
		// For loop to cycle through the array for the size
		for (int i = 0; i < elementsForArray.length; i++) {
			// Check if element actually exists
			if (elementsForArray[i] != null)
				// increment count for size
				count++;
		}
		return count;
	}

//Method used to add items to array given an object as the param
	@Override
	public void add(Object obj) {
		// Check why this for loop exists
		int i;
		for (i = 0; i < size; i++) {
			if (elementsForArray[i] == null) {
				// Break to escape loop
				break;
			}
		}
		if (i < elementsForArray.length) {
			// Give the object to element I
			elementsForArray[i] = obj;
		} else {
			// Else statement for creating a new array and copying the elements over
			Object[] newArray = new Object[elementsForArray.length + 1];
			System.arraycopy(elementsForArray, 0, newArray, 0, elementsForArray.length);
			elementsForArray = newArray;
			elementsForArray[elementsForArray.length - 1] = obj;
			size++;
		}
	}

//Remove method to remove item from the index. This will return the object 
	@Override
	public Object remove(int index) {
		index = checkIndex(index);
		// Assigned a temp value to null
		Object temp = null;
		if (index < elementsForArray.length) {
			// temp value given the index
			temp = elementsForArray[index];
			for (int i = index; i < size - 1; i++) {
				// This allows for a removal of elements
				elementsForArray[i] = elementsForArray[i + 1];
			}
			elementsForArray[size - 1] = null;
			// size--;
		}
		return temp;
	}

	public int checkIndex(int index) {
		//try catch for input mismatch
		try {
			//get Element
			Object obj = elementsForArray[index];
			return index;
		} catch (IndexOutOfBoundsException e) {
			//If element is invalid then return not in bounds try again
			System.out.println("Index is not in bounds try again");
			Scanner scan = new Scanner(System.in);
			int a = scan.nextInt();
			return checkIndex(a);
		}

	}

	@Override
	public boolean checkIfItemExists(String identifier) {
		//In case the user types in with capitals
		String a = identifier.toLowerCase();
		//declare a found object to be null
		Object found = null;
		//Declare exists to be false as value is not found yet
		boolean exists = false;
		//for loop to cycle through array
		for (int i = 0; i < elementsForArray.length; i++) {
			//declared new task object
			Tasks t = null;
			//object is now the element [i] in the array
			Object obj = elementsForArray[i];
			//This checks if the objects name is equal to the tasks class 
			if (obj.getClass().getName().equals("Tasks")) {
				//Explicit casting to object
				t = (Tasks) obj;
				
				if (t.nameOfTask().toLowerCase().equals(identifier)) {
					//exists is now true as item is found
					exists = true;
				} 
			}
		}
		return exists;
	}

	@Override
	public Object findToDo(String identfier) {
		//declare a found object to be null
		Object found = null;
		//Declare match to be false as value is not found yet
		boolean match = false;
		//In case the user types in with capitals
		String lower = identfier.toLowerCase();
		//for loop to cycle through the array 
		for (int i = 0; i < elementsForArray.length; i++) {
			//declare a new task object
			Tasks t = null;
			//object is element array i
			Object obj = elementsForArray[i];
			//This checks if the objects name is equal to the tasks class 
			if (obj.getClass().getName().equals("Tasks")) {
				//Explicit casting to object
				t = (Tasks) obj;
				///if statement deciding if the name of the task to lower case is equal to the lowercase identifier
				if (t.nameOfTask().toLowerCase().equals(lower)) {
					System.out.println("Position: " + i++);
					found = t;
					//found is equal to true because item is found 
					match = true;
				}
			}
		}
		if (match == true) {
			//return found of match is false
			return found;
		}
		else {
			System.out.println("Item not found");
			//return null as item is not found
			return null;
		}

	}
	//Method to get element
	public Object getElement(int i) {
		i = checkIndex(i);
		return elementsForArray[i];
	}

}