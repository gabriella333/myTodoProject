package models;
import java.time.LocalDate;

public class TodoItem {
	private int ID;
	private String todoName;
	private int todoDays;
	private LocalDate  dateCreated;
	private LocalDate endDate;	
	private boolean todoStatus;

	public TodoItem(String todoName, int todoDays, int ID) {
		this.todoName = todoName;
		this.todoDays = todoDays;
		this.ID = ID;
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
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public int getID() {
		return ID;
	}
}
