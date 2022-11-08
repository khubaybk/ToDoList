//This is the tasks class which gives us accessory and mutator methods
public class Tasks {
	private String nameOfTask;
	private String description;
	private String startDate, endDate;

	public Tasks(String nameOfTask, String description, String startDate, String endDate) {

		this.nameOfTask = nameOfTask;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;

	}

	public String nameOfTask() {
		return nameOfTask;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
