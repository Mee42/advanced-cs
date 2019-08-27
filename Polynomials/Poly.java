interface Poly {
    
}

class ArrayBasedPoly implements Poly{
	private final int[] values;
	ArrayBasedPoly(int[] v){
		this.values = v;
	}
	@Override
	public String toString(){
		String str = "";
		for(int i = 0;i<values.length;i++){
			int v = values[i];
			if (v == 0) continue;
			str = str + " " + v + "x^" + i;
		}
		return str;
	}
}
