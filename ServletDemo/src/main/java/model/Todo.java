package model;

public class Todo {
	public String title; 
	public String done;
	
	public Todo(String title, String done) {
		this.title = title;
		this.done = done;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDone() {
		return done;
	}

	public void setDone(String done) {
		this.done = done;
	}
	
}
