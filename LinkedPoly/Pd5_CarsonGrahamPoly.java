/**
 * Author: Carson Graham
 * Date: today
 * Notes:
 *
 * this was a pretty easy lab.
 *
 * The only things I had difficulty with were using an array indexes.
 * I would have approched this and used a map. However, after some thought, it makes sense to use an array.
 * The performance overhead is minimal, AND the Poly interface is (hopfully) created in a hypothetical situation
 * as a wrapper to make math easier - and escape the raw implementation details. That's why it's an interface
 *
 * The other thing I had trouble with is the differentiate method, as I'm just starting algebra II this year.
 * This wasn't a huge problem as the internet exists.
 *
 *
 * EDIT: I adopted this interface for the Sll-2 lab, and added the multiply(Poly other) method.
 */

interface Poly {
    int getDegree();
    double getCoeff(int exponent);
    double evaluate(double x);
    Poly plus(Poly other);
    Poly minus(Poly other);
    Poly negative();
    Poly differentiate();
    Poly multiply(Poly other);
}
