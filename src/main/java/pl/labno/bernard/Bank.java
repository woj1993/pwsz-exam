package pl.labno.bernard;

public interface Bank {

    void disconnect();

    boolean isPinCorrect(int cardNo, int pin);

    int withdraw(int amount);
}
