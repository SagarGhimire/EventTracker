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
        TextView textVieweventName = (TextView) listViewItem.findViewById(R.id.textView);
        TextView textVieweventcontact = (TextView) listViewItem.findViewById(R.id.textView2);

        EventDetail event = EventList.get(position);
       // textVieweventName.setText(EventDetail.getEventName());
      //  textVieweventcontact.setText(EventDetail.getPhoneNumber());

        return listViewItem;
    }
}

