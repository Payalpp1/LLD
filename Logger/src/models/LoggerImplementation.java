package models;


import db.ProcessMap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LoggerImplementation implements LoggerClient {

    private PriorityQueue<Process> lastEndedProcess = new PriorityQueue<>(Comparator.comparingLong(Process::getStartTime));
    private static LoggerImplementation loggerObject = null;

    private LoggerImplementation() {
    }

    public static LoggerImplementation loggerInstance(){
        if(loggerObject == null)
            loggerObject = new LoggerImplementation();
        return loggerObject;
    }


    @Override
    public void start(String processID) {
        long time = System.currentTimeMillis();
        ProcessMap.startNewProcess(processID, time);
    }

    @Override
    public void end(String processID) {
        long time = System.currentTimeMillis();
        try {
            Process processObj = ProcessMap.removeFinishedProcess(processID, time);
            lastEndedProcess.add(processObj);
        }
        catch (Exception e){
            System.out.println("Invalid processID : " + processID);
        }
    }

    @Override
    public void poll() {
        if(!lastEndedProcess.isEmpty()) {
            Process latest = lastEndedProcess.poll();
            System.out.println("Process " + latest.getProcessID() + " start time " + latest.getStartTime() +
                        " end time " + latest.getEndTime());
        }
    }
}
