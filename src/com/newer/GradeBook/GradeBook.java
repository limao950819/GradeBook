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
	
	public GradeBook (String name, int gradesArray[][]) {
		courseName = name;
		grades = gradesArray;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	// 显示welcome to the grades book for “Java程序设计”
	public void displayMessage() {
		System.out.printf("Welcome to the grades book for\n%s!\n\n",getCourseName());
	}
	
	//处理流程
	public void processGrade () {
		outputGrade();
		System.out.printf("\n%s %d\n","the lowest grade in the grade book is", getMinGrade());
		System.out.printf("\n%s %d\n","the highest grade in the grade book is", getMaxGrade());
		outputGradeRate();
	}
	
	//输出关于学生和成绩之间的矩阵
	private void outputGrade() {
		System.out.println("The grades are: \n");
		System.out.println("                  ");
		//test根据列放置：test1，test2，test3
		for (int test=0; test<grades[0].length; test++) 
			System.out.printf("Test %d ",test+1);
		System.out.println("Average");
		//student根据行放置：student1-student10
		for (int student=0; student<grades.length; student++) {
			System.out.printf("Student %2d ",student+1);
		for (int test : grades[student]) 
			System.out.printf("%8d",test);
			double average = Average(grades[student]);
			System.out.printf("%9.2f\n",average);   	
		}
	}
	
	//输出成绩中最小成绩
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
	
	//输出成绩中最大成绩
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
	
	//输出成绩分布率
	private void outputGradeRate() {
		System.out.println("Overall grade distribution");
		int frequency[] = new int[11];
		for (int studentGrade[] : grades) {
			for (int grade : studentGrade) {
				++frequency[grade/10];
			}
		}
		for (int count=0; count<frequency.length; count++) {
			if (count == 10) 
				System.out.printf("%5d","100");
			else
				System.out.printf("%02d-%02d:",
						count*10,count*10+9);
			for (int stars=0; stars<frequency[count]; stars++) {
				System.out.println("*");
				System.out.println();
			}
		}
	}
	
	//输出平均成绩
	private double Average(int[] is) {
		int total = 0;
		for (int grade : is) {
			total += grade;
		}
		return (double)total/is.length;
	}
	
	public static void main(String[] args) {
		int gradeArray[][] = {{87,96,70},{68,87,90},{94,100,90},{100,81,82},{83,65,85},{78,87,65},{85,75,83},{91,94,100},{76,72,84},{87,93,73}};
		GradeBook gradeBook = new GradeBook("Java程序设计", gradeArray);
		gradeBook.displayMessage();
		gradeBook.processGrade();
	}
}
