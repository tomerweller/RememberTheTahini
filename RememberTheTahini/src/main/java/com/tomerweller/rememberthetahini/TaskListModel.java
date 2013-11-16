package com.tomerweller.rememberthetahini;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class TaskListModel{
    private static final int FAKE_NUMBER = 20;
    private static TaskListModel instance = null;
    private List<Task> tasks;
    private Context context;

    //private ctor. enforces singleton
    private TaskListModel(Context context){
        this.context = context;
        tasks = new ArrayList<Task>();
    }

    //public accessor for the class
    public synchronized static TaskListModel getInstance(Context context){
        if (instance==null){
            instance = new TaskListModel(context);
        }
        return instance;
    }

    //add new task
    public void pushTask(String description){
        tasks.add(new Task(System.currentTimeMillis(), description));
    }

    //remove any task
    public void removeTask(Task taskToRemove){
        tasks.remove(taskToRemove);
    }

    public int getCount() {
        return tasks.size();
    }

    public boolean isEmpty(){
        return tasks.isEmpty();
    }

    //get items from new to old
    public Task getItem(int i) {
        return tasks.get(tasks.size()-i-1);
    }

    public void doFakePopulate(){
        for (int i=0; i<FAKE_NUMBER; i++){
            pushTask("Mock task " + i);
        }
        pushTask("Get milk");
        pushTask("Call Amnon");
        pushTask("Taks a vacation");
        pushTask("Prepare shenkar mobile workshop #2");
        pushTask("Find a job");
    }
}
