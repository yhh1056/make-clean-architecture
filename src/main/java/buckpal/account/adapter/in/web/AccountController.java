package buckpal.account.adapter.in.web;

import buckpal.account.application.port.in.SendMoneyUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountController {

    private final SendMoneyUseCase sendMoneyUseCase;
}
