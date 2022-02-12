package models;

public class Process {
    private final String processID;
    private final long startTime;
    private long endTime;

    public String getProcessID() {
        return processID;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public Process(final String processID, final long startTime) {
        this.processID = processID;
        this.startTime = startTime;
    }
}
