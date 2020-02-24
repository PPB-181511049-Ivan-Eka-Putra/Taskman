package com.example.taskman;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TasksData {
    private static String[] taskNames = {
            "Mengimplementasikan aplikasi dengan menerapkan konsep Activity",
            "Memunculkan data pada RecyclerView",
            "Mengerjakan Front-End fitur log in"
    };

    private static Date[] taskDeadlines;

    static {
        try {
            taskDeadlines = new Date[]{
                        getDateFromString("25/02/2020"),
                        getDateFromString("25/02/2020"),
                        getDateFromString("24/02/2020")
                };
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static String[] taskStatus = {
            "In Progress",
            "In Progress",
            "In Progress"
    };

    private static boolean[] taskTypes = {
            true,
            true,
            true
    };

    public TasksData() throws ParseException {
    }

    public static Date getDateFromString(String s) throws ParseException {
        Date result = new SimpleDateFormat("dd/MM/yyyy").parse(s);
        return result;
    }

    static ArrayList<Task> getListData() {
        ArrayList<Task> list = new ArrayList<>();
        for (int position = 0; position < taskNames.length; position++) {
            Task task = new Task();
            task.setName(taskNames[position]);
            task.setDeadline(taskDeadlines[position]);
            task.setStatus(taskStatus[position]);
            task.setType(taskTypes[position]);
            list.add(task);
        }
        return list;
    }
}
