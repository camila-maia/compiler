package model.symbolTable;

public enum IdType {
	INTEIRO, REAL, BOOLEANO, CARACTER, CADEIA, VECTOR, PRIMITIVES, NULL;	

	public boolean isDifferent(IdType otherOne){
		String thisContent = this.toString();
		String otherContent = otherOne.toString();

		if(this.equals(otherOne))			
			return false;
		else if(thisContent.equals("PRIMITIVES")){
			if(otherContent.equals("INTEIRO") ||
					otherContent.equals("REAL") ||
					otherContent.equals("BOOLEANO") ||
					otherContent.equals("CARACTER"))
				return false;
		}
		else if(otherContent.equals("PRIMITIVES")){
			if(thisContent.equals("INTEIRO") ||
					thisContent.equals("REAL") ||
					thisContent.equals("BOOLEANO") ||
					thisContent.equals("CARACTER")){
				return false;
			}
		}
		return true;
	}

	public boolean isEqual(IdType otherOne){
		return !isDifferent(otherOne);
	}
}
