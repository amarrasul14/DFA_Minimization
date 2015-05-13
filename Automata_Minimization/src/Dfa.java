import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Dfa {
	private HashMap<String,State> states;
	private State starting;
	private HashMap<String,State> ending;
	private String[] alphabets;
	
	public Dfa() {
		this.states = new HashMap<String,State>();
		this.starting = new State();
		this.ending = new HashMap<String,State>();
		this.alphabets=null;
	}
	public Dfa(HashMap<String,State> states, State starting, HashMap<String,State> ending, String[] alphabets) {
		this.states = states;
		this.starting = starting;
		this.ending = ending;
		this.alphabets=alphabets;
	}
	
	void init(){
		this.states = new HashMap<String,State>();
		this.starting = new State();
		this.ending = new HashMap<String,State>();
		this.alphabets=null;
		
		ArrayList<String> uninitialized=new ArrayList<String>();
		
		Scanner in= new Scanner(System.in);
		String input="";
		
		System.out.println("Enter all the alphabets separated with a comma");
		input=in.next();
		this.alphabets=input.split(",");
		
		System.out.println("Enter the name of starting state");
		this.starting.name=in.next();
		this.starting.Type=StateType.Start;
		this.states.put(this.starting.name,this.starting);
		uninitialized.add(this.starting.name);
		
		System.out.println("Enter the names of resulting states.If there is no state then just press enter\n");
		
		while(uninitialized.size()!=0){
			String name=uninitialized.get(0);
			System.out.println("/***  Initializing state "+name+" ***/\n");
			State state=this.states.get(name);
		
			for(int i=0; i<alphabets.length;i++){
				System.out.println("Resulting state for input alphabet '"+alphabets[i]+"'");
				input=null;
				input=in.next();
				if(input==null || input ==""){
					state.outflows.put(alphabets[i], null);
				}
				else if(this.states.containsKey(input)){
						state.outflows.put(alphabets[i],this.states.get(input));
				}
				else{
					State tempState=new State(input);
					tempState.Type=StateType.Neither;
					this.states.put(input,tempState);
					state.outflows.put(alphabets[i],this.states.get(input));
					uninitialized.add(input);
				}
			}
			System.out.println(name+" is a final state Enter\n1 for FINAL\n2 for NOT FINAL");
			if(in.nextInt()==1){
				this.ending.put(state.name, state);
				if(state.Type==StateType.Start){
					state.Type=StateType.Both;
				}
				else{
					state.Type=StateType.Final;
				}
			}
		
			uninitialized.remove(0);
		}
	}
	
	void minimize(){
		String[] keys= (String[]) states.keySet().toArray();
		for(int i=0;i<states.size();i++){
			for(int j=i+1;j<states.size();j++){
				State temp=states.get(keys[i]),temp1=states.get(keys[j]);
				if(temp.equals(temp1,"",alphabets)){
					
				}
			}
		}
	}
	
	public HashMap<String,State> getStates() {
		return states;
	}
	public void setStates(HashMap<String,State> states) {
		this.states = states;
	}
	public State getStarting() {
		return starting;
	}
	public void setStarting(State starting) {
		this.starting = starting;
	}
	public HashMap<String,State> getEnding() {
		return ending;
	}
	public void setEnding(HashMap<String,State> ending) {
		this.ending = ending;
	}
	public String[] getAlphabets() {
		return alphabets;
	}
	public void setAlphabets(String[] alphabets) {
		this.alphabets = alphabets;
	}
	
}
