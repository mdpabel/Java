
package Exceptions;

import java.io.IOException;

public class Account {
  private float amount;

  public void deposit(float amount) throws IOException {
    if (amount <= 0) {
      throw new IOException("Amount must be positive");
    }
  }

  public void withdraw(float amount) throws AccountException {
    if (this.amount < amount) {
      throw new AccountException(new InsufficientFundsException());
    }

    // if (this.amount < amount) {
    //   var accountExp = new AccountException();
    //   var insufficientExp = new InsufficientFundsException();
    //   accountExp.initCause(insufficientExp);
    //   throw accountExp;
    // }
  }
}