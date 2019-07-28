package com.muktadir.koadimservices.Modules.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.muktadir.koadimservices.Modules.Events.DataModel.ServiceEvent_Data;
import com.muktadir.koadimservices.R;

import java.util.List;

public class Service_EventRecyclerView extends RecyclerView.Adapter<Service_EventRecyclerView.MyEvents> {

   private Context EventServiceCon;
   private List<ServiceEvent_Data> EventServiceData;

    public Service_EventRecyclerView(Context eventServiceCon, List<ServiceEvent_Data> serviceData) {
        EventServiceCon = eventServiceCon;
        EventServiceData = serviceData;
    }

    @NonNull
    @Override
    public Service_EventRecyclerView.MyEvents onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View Eventservice = LayoutInflater.from(EventServiceCon).inflate(R.layout.event_single_serviceitem,parent,false);
        MyEvents EventSer = new MyEvents(Eventservice);
        return EventSer;
    }

    @Override
    public void onBindViewHolder(@NonNull final Service_EventRecyclerView.MyEvents holder, final int position) {
        final int posi=position;
        holder.EventServiceName.setText(EventServiceData.get(position).getName());
        Glide.with(EventServiceCon).asBitmap().load(EventServiceData.get(position).getImage()).into(new CustomTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                holder.EventServiceImage.setImageBitmap(resource);
            }

            @Override
            public void onLoadCleared(@Nullable Drawable placeholder) {
                holder.EventServiceImage.setImageResource(R.drawable.gradian_color_lower_line);
            }
        });

        //setting up onclick listener for every single item for service
        holder.single_service_itemLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"You Click id : "+EventServiceData.get(posi).getId()+"\n Do something",Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return EventServiceData.size();
    }

    public class MyEvents extends RecyclerView.ViewHolder{
        private TextView EventServiceName;
        private ImageView EventServiceImage;
        private LinearLayout single_service_itemLinear;
        public MyEvents(@NonNull View itemView) {
            super(itemView);
            EventServiceName = itemView.findViewById(R.id.Event_Service_Name);
            EventServiceImage = itemView.findViewById(R.id.Event_Service_image);
            single_service_itemLinear = itemView.findViewById(R.id.Event_service_itemLayout);
        }
    }
}
