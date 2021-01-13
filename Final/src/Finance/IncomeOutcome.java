package Finance;

/**
 * This class calculate the profits and expenses
 */
public class IncomeOutcome {
	private double income;
	private double outcome;

	/**
	 * Constructor, initial outcome and income equal to 0
	 */
	public IncomeOutcome() {
		this.outcome = 0;
		this.income = 0;
	}

	/**
	 * getter to income
	 * @return double income
	 */
	public double getIncome() {
		return income;
	}

	/**
	 * getter to outcome
	 * @return double income
	 */
	public double getOutcome() {
		return outcome;
	}

	/**
	 * @param amount add to income. only in the amount greater then 0
	 *
	 */
	public void earn(double amount) {
		if (amount > 0) {
			this.income += amount;
		}
	}

	/**
	 * @param amount remove from outcome. only in the amount greater then 0
	 */
	public void spend(double amount) {
		if (amount > 0) {
			this.outcome += amount;
		}
	}

	/**
	 * @return profit - income subtracted outcome
	 */
	public double getSummery() {
		return this.income - this.outcome;
	}

	/**
	 * @return return getSummery
	 */
	@Override
	public String toString() {
		return "Money left after expenses -> " + this.getSummery();
	}
}
