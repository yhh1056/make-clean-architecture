package buckpal.account.domain;

import static buckpal.account.common.AccountTestData.defaultAccount;
import static buckpal.account.common.ActivityTestData.defaultActivity;
import static org.assertj.core.api.Assertions.assertThat;

import buckpal.account.domain.Account.AccountId;
import buckpal.account.domain.Activity.ActivityId;
import org.junit.jupiter.api.Test;

class AccountTest {

    @Test
    void withdraw() {
        AccountId accountId = new AccountId(1L);
        Account account = defaultAccount()
                .withAccountId(accountId)
                .withBaselineBalance(Money.of(1000L))
                .withActivityWindow(new ActivityWindow(
                        defaultActivity()
                                .withActivityId(new ActivityId(10L))
                                .withTargetAccountId(accountId)
                                .withMoney(Money.of(500L))
                                .build(),
                        defaultActivity()
                                .withActivityId(new ActivityId(10L))
                                .withTargetAccountId(accountId)
                                .withMoney(Money.of(500L))
                                .build()))
                .build();

        account.withdraw(Money.of(1000L), new AccountId(99L));

        assertThat(account.getActivityWindow().getActivities()).hasSize(3);
        assertThat(account.calculateBalance()).isEqualTo(Money.of(1000L));
    }

    @Test
    void deposit() {
        AccountId accountId = new AccountId(1L);
        Account account = defaultAccount()
                .withAccountId(accountId)
                .withBaselineBalance(Money.of(1000L))
                .withActivityWindow(new ActivityWindow(
                        defaultActivity()
                                .withActivityId(new ActivityId(10L))
                                .withTargetAccountId(accountId)
                                .withMoney(Money.of(500L))
                                .build(),
                        defaultActivity()
                                .withActivityId(new ActivityId(10L))
                                .withTargetAccountId(accountId)
                                .withMoney(Money.of(500L))
                                .build()))
                .build();

        account.deposit(Money.of(1000L), new AccountId(22L));

        assertThat(account.getActivityWindow().getActivities()).hasSize(3);
        assertThat(account.calculateBalance()).isEqualTo(Money.of(3000L));
    }
}
