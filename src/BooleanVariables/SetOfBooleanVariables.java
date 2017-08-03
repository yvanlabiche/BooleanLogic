package BooleanVariables;

import java.util.*;
import java.util.Iterator;


public class SetOfBooleanVariables {
    private ArrayList theBooleanVariables;
	
    public SetOfBooleanVariables() { theBooleanVariables = new ArrayList(); }

	private BooleanVariable findVariable(String name) {
		Iterator it = theBooleanVariables.iterator();
		BooleanVariable v, res=null;
		while (it.hasNext()) {
			v = (BooleanVariable)it.next();
			if (v.getName().equals(name)) {
				res = v;
				break;
			}
		}
		return res;
	}

	public BooleanVariable addVariable(String name) {
		BooleanVariable v;
		v = findVariable(name);
		if (v==null) {
			v = new BooleanVariable(name, 0);
			theBooleanVariables.add(v);
		}
		return v;
      }

    public int numberOfVariables() {
        return theBooleanVariables.size();
    }

    public void setVariableValue(int varLoc, int varVal) {
        BooleanVariable b;
        if ((varLoc<0)||(varLoc>theBooleanVariables.size()))
            return;
        b = (BooleanVariable)theBooleanVariables.get(varLoc);
         b.setValue(varVal);
    }

    //This method assigns variable-values the given value(in bits)
    public void setVariablesToValue(int value){
    	int previous, current;
    	int insertLocation = numberOfVariables() - 1;
    	while(insertLocation >= 0){
    	previous = value >> 1; current = previous << 1;
    	if(current==value){
    		setVariableValue(insertLocation,0);
    	}
    	else setVariableValue(insertLocation,1);
    	value = value>>1;
    	insertLocation--;
      }
    }
    
    
    public BooleanVariable getVariable(int varLoc) {
        if ((varLoc<0)||(varLoc>theBooleanVariables.size()))
            return null;
        return (BooleanVariable)theBooleanVariables.get(varLoc);
    }

    public Iterator getAllVariables() {
        return theBooleanVariables.iterator();
    }
    
    //Replaces the variables with numbers in the given expression
    public String replaceValuesInExpr(String expression) {
    	String expr, result,token;
    	expr=expression;
    	result = "";
    	
        //This code spaces out the expression before we tokenizer it.
        expr = expr.replace('(','@' ); //This was done since replaceAll cant take "(" as regex.
        expr = expr.replaceAll("@"," ( " );
        expr = expr.replace(')','@' ); //This was done since replaceAll cant take "(" as regex.
        expr = expr.replaceAll("@"," ) " );
        
        StringTokenizer t1 = new StringTokenizer(expr);
		while(t1.hasMoreTokens()){
			token = t1.nextToken();
			if(findVariable(token)!=null)
			  result+= (" " + findVariable(token).getValue());
		    else  
			 result +=(" "+token);
		}
            return result;
    }
    
}


