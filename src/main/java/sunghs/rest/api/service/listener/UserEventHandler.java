package sunghs.rest.api.service.listener;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import sunghs.rest.api.model.AfterTransactionEvent;
import sunghs.rest.api.model.BeforeTransactionEvent;
import sunghs.rest.api.model.UserEventDto;

@Component
@Slf4j
public class UserEventHandler {

    @EventListener
    public void process(UserEventDto userEventDto) {
        log.info("대상자 조회 : {}, 시간 {}", userEventDto, LocalDateTime.now());
    }

    @Async
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void beforeTransactionProcess(BeforeTransactionEvent beforeTransactionEvent) {
        beforeTransactionEvent.callback();
    }

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterTransactionProcess(AfterTransactionEvent afterTransactionEvent) {
        afterTransactionEvent.callback();
    }

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    public void completedTransactionProcess(AfterTransactionEvent afterTransactionEvent) {
        afterTransactionEvent.completed();
    }
}
