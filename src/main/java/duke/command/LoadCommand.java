package duke.command;

import duke.DeadlineTask;
import duke.EventTask;
import duke.Parser;
import duke.ToDoTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LoadCommand {
    public static String[] descriptionAndDateTimeFormatter(String[] inputArray) {
        String desc = "";
        String date = "";
        int start = 0;
        for (int i = 1; i < inputArray.length; ++i) {
            if (inputArray[i].equals("(by:") || inputArray[i].equals("(at:")) {
                start = i + 1;
                break;
            }
            desc = desc + " " + inputArray[i];
        }
        desc = desc.trim();
        for (int i = start; i < inputArray.length - 1; ++i) {
            date = date + " " + inputArray[i];
        }
        date = date.trim();
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("E, MMM d yyyy");
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        date = LocalDate.parse(date, inputFormat).format(outputFormat);
        String time = inputArray[inputArray.length - 1].substring(0, inputArray[inputArray.length - 1]
                .length() - 1);
        String dateTime = date + " " + time;
        String[] descDateTime = {desc , dateTime};
        return descDateTime;
    }

    public static void runCommand() throws IOException {
        String line = null;
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/duke/duke.txt"));
        while ((line = br.readLine()) != null) {
            String[] spiltLine = line.split("\\s+");
            char typeOfEvent = spiltLine[0].charAt(1);
            String desc = descriptionAndDateTimeFormatter(spiltLine)[0];
            String dateTime = descriptionAndDateTimeFormatter(spiltLine)[1];
            switch (typeOfEvent) {
            case 'D': {
                DeadlineTask task = new DeadlineTask(desc, dateTime);
                Parser.getTaskList().add(task);
                break;
            }
            case 'E': {
                EventTask task = new EventTask(desc, dateTime);
                Parser.getTaskList().add(task);
                break;
            }
            case 'T': {
                ToDoTask task = new ToDoTask(desc);
                Parser.getTaskList().add(task);
                break;
            }
            default:
                break;
            }
        }
    }
}
