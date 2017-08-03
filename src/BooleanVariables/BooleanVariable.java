package BooleanVariables;

public final class BooleanVariable {
   
	private String name;
	private int boolValue;

	public BooleanVariable(String n, int v) { name = n; boolValue = v; }

	public void setValue(int v) { boolValue = v; }

	public int getValue() { return boolValue; }

	public String getName() { return name; }

	public String toString() { return name+" ("+boolValue+")"; }
}