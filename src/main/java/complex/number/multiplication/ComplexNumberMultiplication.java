package complex.number.multiplication;


public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        String[] x = a.split("\\+|i");
        String[] y = b.split("\\+|i");
        int aReal = Integer.parseInt(x[0]);
        int aImg = Integer.parseInt(x[1]);
        int bReal = Integer.parseInt(y[0]);
        int bImg = Integer.parseInt(y[1]);
        return (aReal * bReal - aImg * bImg) + "+" + (aReal * bImg + aImg * bReal) + "i";
    }
}
