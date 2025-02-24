import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private static final int INITIAL_BALANCE = 0;
    private static final int FIRST_DEPOSIT = 100;
    private static final int SECOND_DEPOSIT = 50;
    private static final int FIRST_HOLDER_ID = 1;
    private static final int SECOND_HOLDER_ID = 2;
    private static final int WITHDRAW = 70;
    private static final int NEGATE_WITHDRAW = 130;
    private static final int AMOUNT_ATTENDED = 29;


    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", FIRST_HOLDER_ID);
        bankAccount = new SimpleBankAccount(accountHolder, INITIAL_BALANCE);
    }

    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_BALANCE, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), FIRST_DEPOSIT);
        assertEquals(FIRST_DEPOSIT, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), FIRST_DEPOSIT);
        bankAccount.deposit(SECOND_HOLDER_ID, SECOND_DEPOSIT);
        assertEquals(FIRST_DEPOSIT, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), FIRST_DEPOSIT);
        bankAccount.withdraw(accountHolder.getId(), WITHDRAW);
        assertEquals(AMOUNT_ATTENDED, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), FIRST_DEPOSIT);
        bankAccount.withdraw(SECOND_HOLDER_ID, WITHDRAW);
        assertEquals(FIRST_DEPOSIT, bankAccount.getBalance());
    }

    @Test
    void testNegateWithdraw() {
        bankAccount.deposit(accountHolder.getId(), FIRST_DEPOSIT);
        bankAccount.withdraw(accountHolder.getId(), NEGATE_WITHDRAW);
        assertEquals(FIRST_DEPOSIT, bankAccount.getBalance());
    }

    @Test
    void testWithdrawFee() {
        bankAccount.deposit(accountHolder.getId(), FIRST_DEPOSIT);
        bankAccount.withdraw(accountHolder.getId(), FIRST_DEPOSIT);
        assertEquals(FIRST_DEPOSIT, bankAccount.getBalance());
    }
}
