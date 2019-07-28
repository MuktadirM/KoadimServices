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
import com.muktadir.koadimservices.Modules.Home.DataModel.ServiceHome_data;
import com.muktadir.koadimservices.R;

import java.util.List;

public class Service_HomeRecyclerView extends RecyclerView.Adapter<Service_HomeRecyclerView.MyHome>{

   private Context mycon;
   private List<ServiceHome_data> ServiceData;

    public Service_HomeRecyclerView(Context mycon, List<ServiceHome_data> serviceData) {
        this.mycon = mycon;
        ServiceData = serviceData;
    }

    @NonNull
    @Override
    public Service_HomeRecyclerView.MyHome onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View service = LayoutInflater.from(mycon).inflate(R.layout.home_single_serviceitem,parent,false);
        MyHome myHome = new MyHome(service);
        return myHome;
    }

    @Override
    public void onBindViewHolder(@NonNull final Service_HomeRecyclerView.MyHome holder, int position) {
        final int pos=position;
        holder.HomeServiceName.setText(ServiceData.get(position).getName());
        Glide.with(mycon).asBitmap().load(ServiceData.get(position).getImage()).into(new CustomTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                holder.HomeServiceImage.setImageBitmap(resource);
            }

            @Override
            public void onLoadCleared(@Nullable Drawable placeholder) {
                //default image or the image will be shown from xml code default as default
                holder.HomeServiceImage.setImageResource(R.drawable.gradian_color_lower_line);
            }
        });
        //setting up onclick listener for every single item for service
        holder.myCardHome_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"You Click id : "+ServiceData.get(pos).getId()+"\n Do something",Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return ServiceData.size();
    }


    public class MyHome extends RecyclerView.ViewHolder{
           private TextView HomeServiceName;
           private ImageView HomeServiceImage;
           private LinearLayout myCardHome_item;
        public MyHome(@NonNull View itemView) {
            super(itemView);
            HomeServiceName = itemView.findViewById(R.id.Home_Service_Name);
            HomeServiceImage=itemView.findViewById(R.id.Home_Service_image);
            myCardHome_item = itemView.findViewById(R.id.Home_service_itemLayout);

        }
    }
}
