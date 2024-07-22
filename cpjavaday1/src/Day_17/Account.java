package Day_17;

public class Account {
    private  double balanceAmount;
    public Account(double balanceAmount){
        this.balanceAmount=balanceAmount;
    }
    public  double getBalanceAmount(){
        return balanceAmount;
    }

    public void deposite(double amount){
        balanceAmount=balanceAmount+amount;
    }

    public void  withDrow(double amount){
        balanceAmount=balanceAmount-amount;
    }
}
