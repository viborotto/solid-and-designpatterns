package com.company.liskov_1;

/**
 * 	Square is a special type of rectangle
 * 	before Override all methods of Rectangle, but only one is comum
 * 	So we create an interface to put comum method between classes
 */
public class Square implements Shape {

	private int side;

	public Square(int side) {
		this.side = side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	public int getSide() {
		return side;
	}

	@Override
	public int computeArea() {
		return side * side;
	}
}
