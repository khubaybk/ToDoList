
public interface LinearList {
	public boolean isEmpty();

	public int size();

	public void add(Object obj);

	public Object remove(int index);

	public Object findToDo(String identfier);

	public boolean checkIfItemExists(String identifier);

}
