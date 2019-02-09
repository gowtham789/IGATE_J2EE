package com.igate.ln4.demos;

public class Box {
 int width;
 int height;
 int depth;
 
 //Default Constructor
 Box()
 {
	 this.width=67;
	 this.height=10;
	 this.depth=4;
 }
 
 //Parameterized constructor
 Box(int a, int b, int c)
 {
	 this.width=a;
	 this.height=b;
	 this.depth=c;
 }
 
 public int calculate()
 {
	 return width*height*depth;
 }
}
