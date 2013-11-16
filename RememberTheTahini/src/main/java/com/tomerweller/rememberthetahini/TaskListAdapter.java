package com.tomerweller.rememberthetahini;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

/**
 * User: tomerweller
 * Date: 10/9/12
 */
public class TaskListAdapter extends BaseAdapter{

    private String TAG = "RTT_TaskListAdapter";

    private Context context;
    private LayoutInflater inflater;
    private TaskListModel taskListModel;

    public TaskListAdapter(android.content.Context context) {
        this.context = context;
        this.taskListModel = TaskListModel.getInstance(context);
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return taskListModel.getCount();
    }

    @Override
    public boolean isEmpty(){
        return taskListModel.isEmpty();
    }

    @Override
    public Task getItem(int i) {
        return taskListModel.getItem(i);
    }

    @Override
    public long getItemId(int i) {
        return getItem(i).getId();
    }

    @Override
    public boolean hasStableIds (){
        return true;
    }

    private final View.OnClickListener doneButtonOnClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            int position = (Integer) view.getTag();
            Log.d(TAG, "Removing task : " + getItem(position).getDescription());
            taskListModel.removeTask(getItem(position));
            notifyDataSetChanged();
        }
    };

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        TaskRowViewHolder holder;

        if (convertView==null){
            convertView = this.inflater.inflate(R.layout.task_row, null);
            holder = new TaskRowViewHolder();
            holder.descriptionTextView = (TextView) convertView.findViewById(R.id.task_description);
            holder.doneButton = (Button) convertView.findViewById(R.id.done_button);
            holder.doneButton.setOnClickListener(doneButtonOnClickListener);
            convertView.setTag(holder);
        } else {
            holder = (TaskRowViewHolder) convertView.getTag();
        }

        holder.descriptionTextView.setText(getItem(position).getDescription());
        holder.doneButton.setTag(position);

        return convertView;
    }

    static class TaskRowViewHolder {
        TextView descriptionTextView;
        Button doneButton;
    }


}