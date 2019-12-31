package com.jeet.demoapp;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<Model> list = new ArrayList<>();
    RecyclerView recyclerView;
    Adapter adapter;
    CheckBox checkBoxAll;
    public static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvMain);
        checkBoxAll = findViewById(R.id.chekAll);
        prepareData();
        adapter = new Adapter(this, list);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        checkBoxAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(buttonView.isPressed())
            {
                if (isChecked) {
//                    for(int i=0;i<list.size();i++)
//                    {
//                        list.get(i).setChecked(true);
//                    }
                    count=5;
                    adapter.notifyDataSetChanged();

                }

                else
                {
                    count=0;
//                    for(int i=0;i<list.size();i++)
//                    {
//                        list.get(i).setChecked(false);
//                    }
                    adapter.notifyDataSetChanged();
                }
            }

            }
        });

    }

    private void prepareData() {
        Model model = new Model("Jeet");
        list.add(model);
        model = new Model("Karan");
        list.add(model);
        model = new Model("Abhi");
        list.add(model);
        model = new Model("Sitender");
        list.add(model);
        model = new Model("Shobin");
        list.add(model);

    }


    public void checkedBox() {
        if(count==5)
        {
            checkBoxAll.setChecked(true);
        }
        else
        {
            checkBoxAll.setChecked(false);
        }
//        if (b) {
//            list.get(position).setChecked(true);
//        } else {
//            list.get(position).setChecked(false);
//        }

//        boolean b1=false;
//        for(int i=0;i<list.size();i++)
//        {
//            if(!list.get(i).isChecked)
//            {
//                checkBoxAll.setChecked(false);
//                b1=true;
//
//            }
//        }
//            if(!b1)
//            {
//                checkBoxAll.setChecked(true);
//            }
//            adapter=new Adapter(this,list);
//      recyclerView.setAdapter(adapter);
    }

   /* void callTheApi(String id){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("MonthNo", id);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call call = apiService.getDataFromServer("", hashMap);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                JsonObject jsonObject = new Gson().toJsonTree(response.body()).getAsJsonObject();
                list = new Gson().fromJson(jsonObject.get("Message").toString(), new TypeToken<List<Model>>() {
                    }.getType());
                    //iLeave.leaveDisplay(leaveDisplayList);


            }



            @Override
            public void onFailure(Call call, Throwable t) {
               // Log.e("Leave Presenter", "error =" + t.toString());
            }

        });

    }*/
}
