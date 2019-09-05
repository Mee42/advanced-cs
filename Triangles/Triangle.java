class Triangle {
    public static void main(String[] args){
         new Triangle(1,2,3);
	new Triangle(12,1,1);//throws exception
    } 
    final double s1;
    final double s2;
    final double s3;
    public Triangle(double s1,double s2,double s3){
	if (s1 + s2 < s3 || s2 + s3 < s1 || s1 + s3 < s2){
		throw new IllegalTriangleException();
	}	
	    this.s1 = s1;
	    this.s2 = s2;
	    this.s3 = s3;
    
    }
    static class IllegalTriangleException extends RuntimeException {
    
    }
}

