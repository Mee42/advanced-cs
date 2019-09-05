public class ArrayBasedPoly implements Poly{
	private final double[] values;
	ArrayBasedPoly(double[] v){
		this.values = v;
	}
	ArrayBasedPoly(double coh,int exp){
		this.values = new double[exp + 1];
		values[exp] = coh;
	}
	public int getDegree(){
		return values.length;//this will be good enough.
	}
	// 0 -> Y
	// 1 -> Yx
	// N -> Yx^2
	public double getCoeff(int exponent){
		return values[exponent];
	}
	public double evaluate(double x){
		double value = 0;
		for (int i = 0;i<values.length;i++){
			if (values[i] != 0)
				value += values[i]*Math.pow(x,i);// if values is 0, this will be 1
		}
		return value;
	}

	public Poly plus(Poly other){
		double[] ne = new double[Math.max(getDegree(),other.getDegree())];
		for(int i = 0;i<ne.length;i++){
			if(i < this.getDegree()) ne[i] = this.getCoeff(i);
			if(i <other.getDegree()) ne[i]+= other.getCoeff(i);
		}
		return new ArrayBasedPoly(ne);
	}

	@Override
	public Poly minus(Poly other) {
		return this.plus(other.negative());
	}

	public Poly negative(){
		double[] ne = new double[this.values.length];
		for (int i = 0;i<values.length;i++){
			ne[i] = -1 * (values[i]);
		}
		return new ArrayBasedPoly(ne);
	}

	@Override
	public Poly differentiate() {
		double[] ne = new double[this.values.length];
		for (int i = 0;i<values.length - 1;i++){
			ne[i] = values[i + 1] * (i + 1);
		}
		return new ArrayBasedPoly(ne);
	}

	public String toString(){
		StringBuilder str = new StringBuilder();
		for(int i = values.length - 1;i>=0;i--){
			double v = values[i];
			if (v == 0) continue;
			str.append(" + ").append(v);
			switch (i) {
				case 0:  /* don't do anything */
					break;
				case 1:
					str.append("x");
					break;
				default:
					str.append("x^").append(i);
					break;
			}
		}
		return str.toString().replaceFirst("\\+","").trim();
	}
}
