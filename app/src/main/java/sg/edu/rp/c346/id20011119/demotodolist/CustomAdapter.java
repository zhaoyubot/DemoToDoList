package sg.edu.rp.c346.id20011119.demotodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Calendar;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<ToDoItem> ToDoList;

    public CustomAdapter(@NonNull Context context, int resource,
                         ArrayList<ToDoItem> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        ToDoList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent, false);
        TextView tvTitle = rowView.findViewById(R.id.textViewName);
        TextView tvDate = rowView.findViewById(R.id.textViewDate);
        ToDoItem currentVersion = ToDoList.get(position);
        tvTitle.setText(currentVersion.getTitle());
        String str = currentVersion.getDate().get(Calendar.DAY_OF_MONTH) + "/" + currentVersion.getDate().get(Calendar.MONTH)
                + "/" + currentVersion.getDate().get(Calendar.YEAR) + " (" + getDay(currentVersion.getDate().get(Calendar.DAY_OF_WEEK)) + ")";
        tvDate.setText(str);
        return rowView;
    }

    private String getDay(int day) {
        switch (day) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                return "";
        }


    }
}
