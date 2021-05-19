package zdfwuy.newproject.Safeguard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import zdfwuy.newproject.R;
import zdfwuy.newproject.data_safeguard.ManagepeopleInfo;
import zdfwuy.newproject.data_safeguard.SerializableMap;
import zdfwuy.newproject.listview.Myexpandlistview_safeguard_manage;

public class Safeguard_Managing_people extends Activity {
    ExpandableListView expandableListView;
    HashMap<String, JSONArray> map = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safeguard__managing_people);
        expandableListView= (ExpandableListView) findViewById(R.id.expanded_list_manage);
        expandableListView.setAdapter(new Myexpandlistview_safeguard_manage());
        InitfatherListener();
        getOkhttp3();
    }

    private void getOkhttp3() {
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/people/get")
                .get()
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res=response.body().string();
                JSONObject jsonObject= JSON.parseObject(res);
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject managePeopleArray = (JSONObject) jsonArray.get(i);
                    String key = null;
                    JSONArray value = new JSONArray();
                    List<ManagepeopleInfo> list = new ArrayList<ManagepeopleInfo>();
                    for (String s : managePeopleArray.keySet()) {
                        key = s;
                        value = (JSONArray) managePeopleArray.get(key);
                    }
                    map.put(key, value);
                }
            }
        });
    }

    private void InitfatherListener() {
        final SerializableMap myMap=new SerializableMap();
        myMap.setMap(map);//将map数据添加到封装的myMap中
        //设置分组的监听
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                Bundle bundle=new Bundle();
                bundle.putSerializable("map", myMap);
                switch (i){
                    case 0:
                        Intent intent=new Intent(Safeguard_Managing_people.this,Safeguard_Managing_people_shudian.class);
                        //传递数据
                        bundle.putCharSequence("key", "输电队");
                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1=new Intent(Safeguard_Managing_people.this,Safeguard_Managing_people_shudian.class);
                        final SerializableMap myMap=new SerializableMap();
                        myMap.setMap(map);//将map数据添加到封装的myMap中
                        bundle.putCharSequence("key", "安装三队");
                        intent1.putExtras(bundle);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2=new Intent(Safeguard_Managing_people.this,Safeguard_Managing_people_shudian.class);
                        bundle.putCharSequence("key", "防腐队");
                        intent2.putExtras(bundle);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3=new Intent(Safeguard_Managing_people.this,Safeguard_Managing_people_shudian.class);
                        bundle.putCharSequence("key", "安装二队");
                        intent3.putExtras(bundle);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4=new Intent(Safeguard_Managing_people.this,Safeguard_Managing_people_shudian.class);
                        bundle.putCharSequence("key", "建筑工程项目部");
                        intent4.putExtras(bundle);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5=new Intent(Safeguard_Managing_people.this,Safeguard_Managing_people_shudian.class);
                        bundle.putCharSequence("key", "安装一队");
                        intent5.putExtras(bundle);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6=new Intent(Safeguard_Managing_people.this,Safeguard_Managing_people_shudian.class);
                        bundle.putCharSequence("key", "金属车间");
                        intent6.putExtras(bundle);
                        startActivity(intent6);
                        break;
                    default:break;
                }
                return false;
            }
        });
    }
}
