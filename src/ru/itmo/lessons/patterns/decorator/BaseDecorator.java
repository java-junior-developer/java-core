package ru.itmo.lessons.patterns.decorator;

public abstract class BaseDecorator implements LogStrategy {
    private LogStrategy logger;

    public BaseDecorator(LogStrategy logger) {
        this.logger = logger;
    }

    @Override
    public void log(String data) {
        logger.log(data);
    }
}