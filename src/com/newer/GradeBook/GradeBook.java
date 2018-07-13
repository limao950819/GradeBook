package com.newer.GradeBook;

/**
 * 
 * 学期成绩的统计
 * 
 * @author lenovo
 *
 */
public class GradeBook {
	
	private String courseName;
	
	private int grades[][];
	
	public GradeBook (String name, int gradeArray[][]) {
		courseName = name;
		grades = gradeArray;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	// 显示welcome to the grades book for “Java程序设计”
	public void displayMessage() {
		System.out.println("Welcome to the grades book for \n");
		getCourseName();
	}
	
	//处理流程
	public void processGrade () {
		outputGrade();
		System.out.printf("\n%s %d\n","the lowest grade in the grade book is", getMinGrade());
		System.out.printf("\n%s %d\n","the highest grade in the grade book is", getMaxGrade());
		outputGradeRate();
	}
	
	private void outputGrade() {
		System.out.println("The grades are: \n");
		for (int test=0; test<grades[0].length; test++) 
			System.out.printf("%d",test+1);
		for (int student=0; student<grades.length; student++) {
			System.out.printf("%d",student+1);
		System.out.println("Average");
		for (int test : grades[student]) {
			System.out.printf("%d",test);
			double average = Average(grades[student]);
			System.out.printf("%s",average);
		    }	
		}
	} 

	private int getMinGrade() {
		int lowGrade = grades[0][0];
		for (int studentGrade[] : grades) {
			for (int grade : studentGrade) {
				if (grade < lowGrade) {
					lowGrade = grade;
				}
			}
		} 
		return lowGrade;
	}

	private int getMaxGrade() {
		int highGrade = grades[0][0];
		for (int studentGrade[] : grades) {
			for (int grade : studentGrade) {
				if (grade > highGrade) {
					highGrade = grade;
				}
			}
		}
		return highGrade;
	}

	private void outputGradeRate() {
		// TODO Auto-generated method stub
		
	}
	
	private double Average(int[] is) {
		int total = 0;
		for (int grade : is) {
			total += grade;
		}
		return (double)total/is.length;
	}
	
}
