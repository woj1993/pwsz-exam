package pl.labno.bernard;

public class ATM {

    private Integer cardNo;

    private Integer pin;

    private String errorMessage;

    private Bank bank;

    public ATM(Bank bank)
    {
        this.bank = bank;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void enterCard(int cardNo)
    {

        this.cardNo = cardNo;
    }

    public void enterPin(int pin)
    {

        this.pin = pin;
    }

    public int withdrawCash(int amount)
    {
        if (null == cardNo || null == pin) {
            throw new IllegalStateException("Pin and Card number required, prior cash withdrawal");
        }
        if (bank.isPinCorrect(cardNo, pin)) {
            try {
                return bank.withdraw(amount);
            } catch (AccountBlockedException exception) {
                this.errorMessage = "Your account is blocked";
                throw new IllegalStateException("Account blocked", exception);
            } finally {
                bank.disconnect();
            }
        } else {
            this.errorMessage = "Incorrect pin";
            throw new IllegalStateException("Pin is incorrect");
        }
    }
}
