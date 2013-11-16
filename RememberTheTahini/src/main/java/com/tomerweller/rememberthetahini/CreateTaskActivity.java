package com.tomerweller.rememberthetahini;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * User: tomerweller
 * Date: 10/29/12
 */
public class CreateTaskActivity extends Activity {
    private TaskListModel taskListModel;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_task);

         taskListModel = TaskListModel.getInstance(this);

        final TextView descriptionTextView = (TextView) findViewById(R.id.edit_message);
        final Button newTaskButton = (Button) findViewById(R.id.create_task_button);

        newTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taskListModel.pushTask(descriptionTextView.getText().toString());
                finish();
            }
        });
    }
}