
public enum StateType {
	Start("starting"),Final("Accepting State"),Both("Starting And Accepting State"),Neither("Normal");
	private String value;
	
	private StateType(String value){
		this.value=value;
	}
	public String getValue(){
		return value;
	}
}
