package buckpal.account.domain;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void negate() {
        BigInteger bigInteger = BigInteger.valueOf(1000L);
        BigInteger negate = bigInteger.negate();

        System.out.println(negate);
    }

}
