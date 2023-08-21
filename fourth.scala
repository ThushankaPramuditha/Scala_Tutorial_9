class Account(var balance: Double) {
  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
    }
  }

  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05
    } else {
      balance += balance * 0.1
    }
  }

  override def toString: String = s"Balance: $balance"
}

class Bank(val accounts: List[Account]) {
  def accountsWithNegativeBalance: List[Account] = {
    accounts.filter(_.balance < 0)
  }

  def totalBalance: Double = {
    accounts.map(_.balance).sum
  }

  def applyInterestToAllAccounts(): Unit = {
    accounts.foreach(_.applyInterest())
  }
}

// Usage
val account1 = new Account(1000.0)
val account2 = new Account(-500.0)
val account3 = new Account(200.0)

val bank = new Bank(List(account1, account2, account3))

println("Accounts with negative balances:")
val negativeBalances = bank.accountsWithNegativeBalance
negativeBalances.foreach(println)

val totalBalances = bank.totalBalance
println(s"Total balance of all accounts: $totalBalances")

bank.applyInterestToAllAccounts()
println("Balances after applying interest:")
bank.accounts.foreach(println)
