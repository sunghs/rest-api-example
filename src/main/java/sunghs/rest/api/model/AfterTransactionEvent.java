package sunghs.rest.api.model;

public interface AfterTransactionEvent extends AbstractTransactionEvent {

    void completed();
}
