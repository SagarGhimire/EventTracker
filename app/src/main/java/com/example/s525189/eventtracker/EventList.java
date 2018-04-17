package com.example.s525189.eventtracker;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class EventList extends ArrayAdapter<EventDetail>{
    private Activity context;
    private List<EventDetail> EventList;

    public EventList(Activity context, List<EventDetail> EventList){
        super(context, R.layout.list_layout, EventList);
        this.context =context;
        this.EventList =EventList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.viewname);
        TextView textViewemail = (TextView) listViewItem.findViewById(R.id.viewemail);
        TextView textVieweventname= (TextView) listViewItem.findViewById(R.id.vieweventName);
        TextView textViewphone= (TextView) listViewItem.findViewById(R.id.viewphone);
        TextView textViewabstract = (TextView) listViewItem.findViewById(R.id.viewAbstract);

        EventDetail event = EventList.get(position);
<<<<<<< HEAD
       // textVieweventName.setText(EventDetail.getEventName());
      //  textVieweventcontact.setText(EventDetail.getPhoneNumber());

=======
        textViewName.setText(EventDetail.getName());
        textViewemail.setText(EventDetail.getEmail());
        textVieweventname.setText(EventDetail.getEventName());
        textViewphone.setText(EventDetail.getPhoneNumber());
        textViewabstract.setText(EventDetail.getAbstract());
>>>>>>> 5fceb8aa0b11cf97a7b7ba0d2286da1d8432cc82
        return listViewItem;
    }
}

