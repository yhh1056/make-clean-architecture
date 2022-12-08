package buckpal.account.common;

import static buckpal.account.common.AccountTestData.defaultAccountId;

import buckpal.account.domain.Account.AccountId;
import buckpal.account.domain.Activity;
import buckpal.account.domain.Activity.ActivityId;
import buckpal.account.domain.Money;
import java.time.LocalDateTime;

public class ActivityTestData {

    public static ActivityBuilder defaultActivity() {
        return new ActivityBuilder()
                .withOwnerAccountId(defaultAccountId())
                .withSourceAccountId(defaultAccountId())
                .withTargetAccountId(new AccountId(101L))
                .withTimestamp(LocalDateTime.now())
                .withMoney(Money.of(500L));
    }

    public static class ActivityBuilder {
        private ActivityId activityId;
        private AccountId ownerAccountId;
        private AccountId sourceAccountId;
        private AccountId targetAccountId;
        private LocalDateTime timestamp;
        private Money money;

        public ActivityBuilder withActivityId(ActivityId activityId) {
            this.activityId = activityId;
            return this;
        }

        public ActivityBuilder withOwnerAccountId(AccountId ownerAccountId) {
            this.ownerAccountId = ownerAccountId;
            return this;
        }

        public ActivityBuilder withSourceAccountId(AccountId sourceAccountId) {
            this.sourceAccountId = sourceAccountId;
            return this;
        }

        public ActivityBuilder withTargetAccountId(AccountId targetAccountId) {
            this.targetAccountId = targetAccountId;
            return this;
        }

        public ActivityBuilder withTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ActivityBuilder withMoney(Money money) {
            this.money = money;
            return this;
        }

        public Activity build() {
            return new Activity(activityId, ownerAccountId, sourceAccountId, targetAccountId, timestamp, money);
        }
    }

}
