package buckpal.account.common;

import static buckpal.account.common.ActivityTestData.*;

import buckpal.account.domain.Account;
import buckpal.account.domain.Account.AccountId;
import buckpal.account.domain.ActivityWindow;
import buckpal.account.domain.Money;
import java.util.Objects;

public class AccountTestData {

	private static final Long DEFAULT_ID = 100L;

	public static AccountBuilder defaultAccount() {
		return new AccountBuilder()
				.withAccountId(defaultAccountId())
				.withBaselineBalance(Money.of(10000L))
				.withActivityWindow(new ActivityWindow(
						defaultActivity().build(),
						defaultActivity().build()));
	}

	public static AccountId defaultAccountId() {
		return new AccountId(DEFAULT_ID);
	}

	public static class AccountBuilder {

		private AccountId accountId;
		private Money baselineBalance;
		private ActivityWindow activityWindow;

		public AccountBuilder withAccountId(AccountId accountId) {
			this.accountId = accountId;
			return this;
		}

		public AccountBuilder withBaselineBalance(Money baselineBalance) {
			this.baselineBalance = baselineBalance;
			return this;
		}

		public AccountBuilder withActivityWindow(ActivityWindow activityWindow) {
			this.activityWindow = activityWindow;
			return this;
		}

		public Account build() {
			return new Account(accountId, baselineBalance, activityWindow);
		}
	}
}
