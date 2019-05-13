package com.goat.B.B07.test;

public class ConcreteFlyweight extends Flyweight {

    private Character intrinsicState;

	public ConcreteFlyweight(Character state){
        this.intrinsicState = state;
	}
	
	public void operation(String state) {
		System.out.print( "\n Intrinsic State = " + intrinsicState + ", Extrinsic State = " + state);
	}
}