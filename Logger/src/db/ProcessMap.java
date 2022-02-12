package db;

import java.util.HashMap;
import models.Process;
public class ProcessMap {

    private static HashMap<String, Process> processMap = new HashMap<>();

    public static Process getProcessFromID(String processID) {
        return processMap.getOrDefault(processID, null);
    }

    public static void startNewProcess(String processID, long startTime) {
        Process newProcess = new Process(processID, startTime);
        processMap.put(processID, newProcess);
    }

    public static Process removeFinishedProcess(String processID, long time){
        Process process = getProcessFromID(processID);
        try {
            process.setEndTime(time);
            processMap.remove(processID);
        }
        catch (Exception e){
            System.out.println("Invalid processID : " + processID);
        }
        return process;
    }

}
