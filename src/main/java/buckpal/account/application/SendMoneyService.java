package buckpal.account.application;

import buckpal.account.application.port.in.SendMoneyUseCase;
import buckpal.account.application.port.out.LoadAccountPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class SendMoneyService implements SendMoneyUseCase {

    private final LoadAccountPort loadAccountPort;
}
