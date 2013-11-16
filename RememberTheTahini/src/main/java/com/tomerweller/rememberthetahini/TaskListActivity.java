package com.tomerweller.rememberthetahini;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class TaskListActivity extends Activity {

    Context context;
    TaskListAdapter taskListAdapter;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        context = this;

        TaskListModel taskListModel = TaskListModel.getInstance(this);
        taskListModel.doFakePopulate();

        ListView taskList = (ListView) findViewById(R.id.task_list);
        taskListAdapter = new TaskListAdapter(this);
        taskList.setAdapter(taskListAdapter);

        Button newTaskButton = (Button) findViewById(R.id.new_task_button);
        newTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, CreateTaskActivity.class));
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        taskListAdapter.notifyDataSetChanged();
    }
}
