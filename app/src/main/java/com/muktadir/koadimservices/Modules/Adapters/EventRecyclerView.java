package com.muktadir.koadimservices.Modules.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.muktadir.koadimservices.Modules.Events.DataModel.Category_EventData;
import com.muktadir.koadimservices.R;
import java.util.List;

public class EventRecyclerView extends RecyclerView.Adapter<EventRecyclerView.EventHolder> {

    private Context EventContext;
    private List<Category_EventData> MyEvents;

    public EventRecyclerView(Context mcon, List<Category_EventData> EventData) {
        EventContext = mcon;
        MyEvents = EventData;
    }

    @NonNull
    @Override
    public EventRecyclerView.EventHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View EventView= LayoutInflater.from(EventContext).inflate(R.layout.event_services,parent,false);
        EventHolder Events = new EventHolder(EventView);
        return Events;
    }

    @Override
    public void onBindViewHolder(@NonNull EventRecyclerView.EventHolder holder, int position) {
        holder.EventCategory.setText(MyEvents.get(position).getName());
        //setting up service data
        RecyclerView RecylcerMy=  holder.EventServiceRecycler;
        Service_EventRecyclerView ServiceEvent = new Service_EventRecyclerView(EventContext, MyEvents.get(position).getServiceHome());
        RecylcerMy.setLayoutManager(new LinearLayoutManager(EventContext));
        RecylcerMy.setAdapter(ServiceEvent);

    }

    @Override
    public int getItemCount() {
        return MyEvents.size();
    }

    public class EventHolder extends RecyclerView.ViewHolder{
        private TextView EventCategory;
        private CardView MyCatLayout;
        private RecyclerView EventServiceRecycler;

        public EventHolder(@NonNull View itemView) {
            super(itemView);
            EventCategory = itemView.findViewById(R.id.Event_Category_itemName);
            MyCatLayout = itemView.findViewById(R.id.Event_category_itemCard);
            EventServiceRecycler = itemView.findViewById(R.id.Event_Service);
        }
    }
}
