import java.time.LocalDate;

public class TodoItem {
	String todoName;
	String todoDescription;
	int todoDays;
	LocalDate  dateCreated;
	LocalDate endDate;	
	boolean todoStatus;

	public TodoItem(String todoName, String todoDescription, int todoDays) {
		//super();
		this.todoName = todoName;
		this.todoDescription = todoDescription;
		this.todoDays = todoDays;
		this.dateCreated = LocalDate.now();	
		this.endDate = dateCreated.plusDays(todoDays);
		this.todoStatus = false;
	}


	public String getTodoName() {
		return todoName;
	}
	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}
	public String getTodoDescription() {
		return todoDescription;
	}
	public void setTodoDescription(String todoDescription) {
		this.todoDescription = todoDescription;
	}
	public boolean isTodoStatus() {
		return todoStatus;
	}
	public void setTodoStatus(boolean todoStatus) {
		this.todoStatus = todoStatus;
	}
	public int getTodoDays() {
		return todoDays;
	}
	public LocalDate getDateCreated() {
		return dateCreated;
	}

}
