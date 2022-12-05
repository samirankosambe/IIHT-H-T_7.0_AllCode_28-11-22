package com.sprint1;

public class CompetitiveCourse {
	private int courseID;
	private String courseName;
	private String courseTeacher;
	private int courseDuration;
	private int courseFees;

	public CompetitiveCourse() {
		super();
	}

	public CompetitiveCourse(int courseID, String courseName, String courseTeacher, int courseDuration,
			int courseFees) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.courseTeacher = courseTeacher;
		this.courseDuration = courseDuration;
		this.courseFees = courseFees;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseTeacher() {
		return courseTeacher;
	}

	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}

	public int getCourseFees() {
		return courseFees;
	}

	public void setCourseFees(int courseFees) {
		this.courseFees = courseFees;
	}

	@Override
	public String toString() {
		return "CompetitiveCourse [courseID=" + courseID + ", courseName=" + courseName + ", courseTeacher="
				+ courseTeacher + ", courseDuration=" + courseDuration + ", courseFees=" + courseFees + "]";
	}

}
