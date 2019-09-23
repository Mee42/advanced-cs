public class LinkedPoly implements Poly{
  private class Node {
    double value;
    Node next;
    int exponent; // store so exponent calls aren't O(n)
    Node(double value,Node next,int exponent){
      this.value    = value;
      this.next     = next;
      this.exponent = exponent;
    }
  }
  // you said to cast, so this is a better way of enfocing type
  LinkedPoly(LinkedPoly other){
    double[] v = new double[other.getDegree()];
    int i = 0;
    for(Node node = other.head;node != null;node = node.next){
      v[i++] = node.value;
    }
    init(v);
  }

  private Node head = null;
  private int size = 0;
  // private final double[] values;
	LinkedPoly(double[] v){
    init(v);
	}
  private void init(double[] v){
    if(v.length == 0){
      head = new Node(0,null,0);
      size = 1;
      return;
    }
    size = v.length;
    Node tail = null;
    for(int index = 0;index < v.length;index++){
      if(tail != null){
        tail.next = new Node(v[index],null,index);
        tail = tail.next;
      } else {
        tail = new Node(v[index],null,index);
        head = tail;
      }
    }
  }

	LinkedPoly(double coh,int exp){
	  double[] values = new double[exp + 1];
	  values[exp] = coh;
    init(values);
	}
	public int getDegree(){
    return size;
  }
    // 0 -> Y
	// 1 -> Yx
	// N -> Yx^2
	public double getCoeff(int exponent){
    Node p = head;
    for(int i = 0;i < exponent;i++){
      p = p.next;
    }
    return p.value;
	}
	public double evaluate(double x){
		double value = 0;
		for (int i = 0;i<getDegree();i++){
			if (getCoeff(i) != 0)
				value += getCoeff(i)*Math.pow(x,i);// if values is 0, this will be 1
		}
		return value;
	}

	public Poly plus(Poly other){
		double[] ne = new double[Math.max(getDegree(),other.getDegree())];
		for(int i = 0;i<ne.length;i++){
			if(i < this.getDegree()) ne[i] = this.getCoeff(i);
			if(i <other.getDegree()) ne[i]+= other.getCoeff(i);
		}
		return new LinkedPoly(ne);
	}

	@Override
	public Poly minus(Poly other) {
		return this.plus(other.negative());
	}

	public Poly negative(){
		double[] ne = new double[getDegree()];
		for (int i = 0;i<getDegree();i++){
			ne[i] = -1 * getCoeff(i);
		}
		return new LinkedPoly(ne);
	}

	@Override
	public Poly differentiate() {
		double[] ne = new double[getDegree()];
		for (int i = 0;i<getDegree() - 1;i++){
			ne[i] = getCoeff(i + 1) * (i + 1);
		}
		return new LinkedPoly(ne);
	}
  @Override
  public Poly multiply(Poly others){
    LinkedPoly other = (LinkedPoly) others;
    Poly p = new LinkedPoly(0,0);
    for(Node one = this.head;one != null;one = one.next){
      for(Node two = other.head;two != null;two = two.next){
        p = p.plus(new LinkedPoly(one.value * two.value,one.exponent + two.exponent));
      }
    }
    return p;
  }

	public String toString(){
		StringBuilder str = new StringBuilder();
		for(int i = getDegree() - 1;i>=0;i--){
			double v = getCoeff(i);
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
