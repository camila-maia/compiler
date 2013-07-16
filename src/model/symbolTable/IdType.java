package model.symbolTable;

public enum IdType {
	INTEIRO, REAL, BOOLEANO, CARACTER, CADEIA, VECTOR, PRIMITIVES;	

	public boolean isDifferent(IdType otherOne){
		if(this == otherOne)			
			return true;
		else if(this.equals("PRIMITIVES")){
			if(otherOne.equals("INTEIRO") ||
			   otherOne.equals("REAL") ||
			   otherOne.equals("BOOLEANO") ||
			   otherOne.equals("CARACTER"))
				return true;
			}
			else if(otherOne.equals("PRIMITIVES")){
				if(this.equals("INTEIRO") ||
				   this.equals("REAL") ||
				   this.equals("BOOLEANO") ||
				   this.equals("CARACTER")){
					return true;
				}
		}
		return false;
	}

}
