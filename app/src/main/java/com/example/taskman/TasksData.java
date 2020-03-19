package com.example.taskman;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TasksData {
    private static int[] taskIds = {
            1,
            2,
            3
    };

    private static String[] taskNames = {
            "Mengimplementasikan aplikasi dengan menerapkan konsep Activity",
            "Memunculkan data pada RecyclerView",
            "Mengerjakan Front-End fitur log in"
    };

    private static Date[] taskDeadlines = {
                getDateFromString("29/02/2020 15:03:00"),
                getDateFromString("29/02/2020 16:00:00"),
                getDateFromString("01/03/2020 15:03:00")
    };

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

    public static Date getDateFromString(String s){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
        Date result = null;

        try {
            result = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    static ArrayList<Task> getListData() {
        ArrayList<Task> list = new ArrayList<>();
        for (int position = 0; position < taskNames.length; position++) {
            Task task = new Task(taskNames[position], taskDeadlines[position]);
            list.add(task);
        }
        return list;
    }
}
