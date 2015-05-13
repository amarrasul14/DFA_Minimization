import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class State {
	String name;
	HashMap<String,State> outflows;
	StateType Type;
	
	State(){
		this.name=null;
		this.outflows=new HashMap<String,State>();
		this.Type=StateType.Neither;
	}
	State(String name){
		this.name=name;
		this.outflows=new HashMap<String,State>();
		this.Type=StateType.Neither;
	}
	State(String name, HashMap<String,State> outflows){
		this.name=name;
		this.outflows=outflows;
		this.Type=StateType.Neither;
	}
	State(String name, HashMap<String,State> outflows, StateType type){
		this.name=name;
		this.outflows=outflows;
		this.Type=type;
	}
	public boolean equals(State state, String initial, String[] alphabets) {
		for(int i=0;i<alphabets.length;i++){
			String temp=initial+alphabets[i];
			if(outflows.get(alphabets[i]).equals(state.outflows.get(alphabets[i]))){
				
			}
			else{
				
			}
		}
		return false;
	}
	
}
