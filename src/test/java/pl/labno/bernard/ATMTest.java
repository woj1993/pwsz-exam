package pl.labno.bernard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.*;

public class ATMTest {
    private ATM atm;
    private Bank bank;
    private int amount;
    private int pin;
    private int card;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void NoPin() {
        // Given
        bank = mock(Bank.class);
        pin = 67;
        card = 112;
        amount = 100;
        when(bank.isPinCorrect(card, pin)).thenReturn(true);
        when(bank.withdraw(amount)).thenReturn(amount);
        atm = new ATM(bank);
        // When
        atm.enterPin(pin);
        atm.enterCard(card);
        int result = atm.withdrawCash(amount);
        // Then
        Assert.assertEquals(amount, result);
    }

    @Test
    public void CardNull() {
        // Given
        bank = mock(Bank.class);
        pin = 67;
        amount = 100;
        when(bank.isPinCorrect(card, pin)).thenReturn(true);
        when(bank.withdraw(amount)).thenReturn(amount);
        atm = new ATM(bank);
        // When
        atm.enterPin(pin);
        // Then
        exception.expect(IllegalStateException.class);
        int result = atm.withdrawCash(amount);
    }

    @Test
    public void AccountBlocked() {
        // Given
        bank = mock(Bank.class);
        pin = 67;
        card = 112;
        amount = 100;
        when(bank.isPinCorrect(card, pin)).thenThrow(AccountBlockedException.class);
        when(bank.withdraw(amount)).thenReturn(amount);
        atm = new ATM(bank);
        // When
        atm.enterPin(pin);
        atm.enterCard(card);
        // Then
        exception.expect(IllegalStateException.class);
        int result = atm.withdrawCash(amount);
    }

}
