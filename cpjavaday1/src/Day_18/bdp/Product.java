package Day_18.bdp;

public class Product {
    private String pcode;
    private double pPrize;

    public Product(String pcode, double pPrize) {
        this.pcode = pcode;
        this.pPrize = pPrize;
    }

    public String getPcode() {
        return pcode;
    }

    public double getpPrize() {
        return pPrize;
    }
}
