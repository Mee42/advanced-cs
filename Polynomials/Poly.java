interface Poly {
    int getDegree();
    int getCoeff(int exponent);
    int evaluate(int x);
    Poly add(Poly other);
    Poly minus(Poly other);
    Poly negative();
}

class ArrayBasedPoly implements Poly{
	private final int[] values;
	ArrayBasedPoly(int[] v){
		this.values = v;
	}
	ArrayBasedPoly(int coh,int v){
		this.values = new int[coh + 1];
		values[coh] = v;
	}
	public int getDegree(){
		return values.length;//this will be good enough.
	}
	// 0 -> Y
	// 1 -> Yx
	// N -> Yx^2
	public int getCoeff(int exponent){
		return values[exponent];
	}
	public int evaluate(int x){
		int value = 0;
		for (int i = 0;i<values.length;i++){
			value += Math.pow(values[i]*x,i);
		}
		return value;
	}
        public Poly add(Poly other){
		int[] ne = new int[Math.max(getDegree(),other.getDegree())];
		for(int i = 0;i<ne.length;i++){
			if(i < this.getDegree()) ne[i] = this.getCoeff(i);
			if(i <other.getDegree()) ne[i]+= other.getCoeff(i);
		}
		return ArrayBasedPoly(ne);
	}
	public Poly negative(){
	public String toString(){
		String str = "";
		for(int i = values.length - 1;i>=0;i--){
			int v = values[i];
			if (v == 0) continue;
			str = str + " + " + v;
			if (i == 0) continue;
			else if (i == 1) str += "x";
			else str += "x^" + i;
		}
		return str.replaceFirst("\\+","").trim();
	}
}
