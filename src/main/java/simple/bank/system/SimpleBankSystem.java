package simple.bank.system;

/**
 * @author hum
 */
public class SimpleBankSystem {
    long[] balance;

    public SimpleBankSystem(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 > this.balance.length || account2 > this.balance.length || account1 < 1 || account2 < 1) {
            return false;
        }
        if (money > this.balance[account1 - 1]) {
            return false;
        }
        this.balance[account1 - 1] -= money;
        this.balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account > this.balance.length || account < 1) {
            return false;
        }
        this.balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account > this.balance.length || account < 1) {
            return false;
        }
        if (money > this.balance[account - 1]) {
            return false;
        }
        this.balance[account - 1] -= money;
        return true;
    }

}
