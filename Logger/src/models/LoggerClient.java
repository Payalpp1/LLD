package models;

public interface LoggerClient {
    void start(String processID);
    void end(String processID);
    void poll();
}

