package com.muktadir.koadimservices.Modules.Events;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.muktadir.koadimservices.API.API_Interface;
import com.muktadir.koadimservices.API.RetrofitInstance;
import com.muktadir.koadimservices.APIDataModel.EventData;
import com.muktadir.koadimservices.Modules.Adapters.EventRecyclerView;
import com.muktadir.koadimservices.Modules.Events.DataModel.Category_EventData;
import com.muktadir.koadimservices.Modules.Events.DataModel.ServiceEvent_Data;
import com.muktadir.koadimservices.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Events extends Fragment {
    private RecyclerView recyclerView;
    private List<ServiceEvent_Data> ServiceEvent;
    public Events() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View homeView = inflater.inflate(R.layout.event_content,container,false);
        recyclerView = homeView.findViewById(R.id.Event_content_recycler);
        boolean check = EventContent_data(recyclerView);

        Log.i("Mydata","Text first: "+check);
        return homeView;


    }




    boolean EventContent_data(final RecyclerView recyclerView){
        final List<Category_EventData> EventContent = new ArrayList<>();
        //Data Access begin Here
        API_Interface dataservice = RetrofitInstance.getRetrofitInstance_Events().create(API_Interface.class);
        Call<List<EventData>> call = dataservice.EventContent();

        call.enqueue(new Callback<List<EventData>>() {
            @Override
            public void onResponse(Call<List<EventData>> call, Response<List<EventData>> response) {
                Log.i("Mydata",""+response.body());
                List<EventData> EventData = response.body();
                ServiceEvent = new ArrayList<>();
                int DataSize=0;
                for (int i = 0;i<EventData.size();i++){
                    String images;
                    Log.i("Mydata","Category "+EventData.get(i).getId()+" Name "+EventData.get(i).getName());
                    DataSize=i;
                    for (int l =0;l<EventData.get(i).getService_types().size();l++){


                        Log.i("Mydata","Services "+EventData.get(DataSize).getService_types().get(l).getServiceName());
                        EventData.ImageThumb CheckLink =EventData.get(DataSize).getService_types().get(l).getImage_thumb_url();
                        if(CheckLink == null){
                            images="No";

                        }
                        else
                        {
                            images=EventData.get(DataSize).getService_types().get(l).getImage_thumb_url().getMd();
                            Log.i("Mydata","Image link : "+images);

                        }
                        ServiceEvent.add(new ServiceEvent_Data(EventData.get(DataSize).getService_types().get(l).getId(),EventData.get(DataSize).getService_types().get(l).getServiceName(),images));
                    }
                    Log.i("Mydata","Service Array before : "+ServiceEvent.size());
                    EventContent.add(new Category_EventData(EventData.get(i).getId(),EventData.get(i).getName(),ServiceEvent));
                    ServiceEvent = new ArrayList<>();
                    Log.i("Mydata","Service Array after : "+ServiceEvent.size());
                }
                Log.i("Mydata","Array Size of home : "+EventContent.size());

                //  Log.i("Mydata","Array Size of home onCreate : "+this.HomeContent.size());
                EventRecyclerView EventAdapter = new EventRecyclerView(getContext(),EventContent);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(EventAdapter);


            }


            @Override
            public void onFailure(Call<List<EventData>> call, Throwable t) {
                Toast.makeText(getContext(),"Sorry Fail to data"+t.toString(),Toast.LENGTH_LONG).show();
                Log.i("Mydata",""+t.toString());
            }
        });
        // Log.i("Mydata","Array Size of home Last : "+HomeContent.size());
        Log.i("Mydata","TextLast"+EventContent.size());
        return true;
    }
}
