class Account(initialBalance: Double) {
  private var balance: Double = initialBalance

  def getBalance: Double = balance

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited $amount. New balance: $balance")
    } else {
      println("Invalid deposit amount.")
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew $amount. New balance: $balance")
    } else {
      println("Invalid withdrawal amount or insufficient balance.")
    }
  }

  def transfer(amount: Double, targetAccount: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      targetAccount.deposit(amount)
      println(s"Transferred $amount to target account. New balance: $balance")
    } else {
      println("Invalid transfer amount or insufficient balance.")
    }
  }
}

// Usage
val account1 = new Account(1000.0)
val account2 = new Account(500.0)

account1.deposit(200.0)
account1.withdraw(100.0)
account1.transfer(300.0, account2)
