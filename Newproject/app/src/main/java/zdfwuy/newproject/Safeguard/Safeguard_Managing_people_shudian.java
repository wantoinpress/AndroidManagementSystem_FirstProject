package zdfwuy.newproject.Safeguard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import zdfwuy.newproject.R;
import zdfwuy.newproject.data_safeguard.ManagepeopleInfo;
import zdfwuy.newproject.data_safeguard.SerializableMap;
import zdfwuy.newproject.dialog.Mydialog_shudiandui;

public class Safeguard_Managing_people_shudian extends Activity {

    private List<ManagepeopleInfo> data = new ArrayList<>();
    private ListView listView;
    Mydialog_shudiandui mydialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safeguard__managing_people_shudian);
        listView = (ListView) findViewById(R.id.listview_shudian);
        registerForContextMenu(listView);
        listView_setonclick();
        Intent intent=getIntent();
        Bundle bundle = getIntent().getExtras();
        SerializableMap serializableMap = (SerializableMap) bundle.get("map");
        String key = (String) bundle.get("key");
        HashMap<String, JSONArray> map = (HashMap<String, JSONArray>) serializableMap.getMap();
        JSONArray result = map.get(key);
        System.out.println(result);
        for (int i = 0; i < result.size(); i++) {
            ManagepeopleInfo m = new ManagepeopleInfo();
            JSONObject j = (JSONObject) result.get(i);
            m.setPid((Integer) j.get("pid"));
            m.setAffiliatedUnits((String) j.get("affiliatedUnits"));
            m.setGender((String) j.get("gender"));
            m.setCanUse((String) j.get("canUse"));
            m.setRankNum((String) j.get("rankNum"));
            m.setRemarks((String) j.get("remarks"));
            m.setTelNum((String) j.get("telNum"));
            m.setUserName((String) j.get("userName"));
            m.setPpName((String) j.get("ppName"));
            m.setUserRole((String) j.get("userRole"));
            showResult(m);
        }
    }

    private void listView_setonclick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mydialog = new Mydialog_shudiandui(Safeguard_Managing_people_shudian.this, R.style.MyDialog);
                for (int i = 0; i < data.size(); i++) {
                     /*EditText_engineerprogram_production,Editext_pijianhao,Edit_investment_money,Edit_orginal_pijianhao,Edit_production_engineerTime,
            Edit_production_contractNum,Edit_production_startday,Edit_production_endday,Edit_production_signDate,Edit_production_performance;
*/
                    if (i == position) {
                        mydialog.setPid(data.get(i).getPid().toString());
                        mydialog.setEdit_gender_str(data.get(i).getGender());
                        mydialog.setEdit_ppName_str(data.get(i).getPpName());
                        mydialog.setEdit_telNum_str(data.get(i).getTelNum().toString());
                        mydialog.setEdit_userRole_str(data.get(i).getUserRole().toString());
                        mydialog.setEditext_canUse_str(data.get(i).getCanUse().toString());
                        mydialog.setEdit_remarks_str(data.get(i).getRemarks().toString());
                        mydialog.setEdit_rankNum_str(data.get(i).getRankNum().toString());
                        mydialog.setEditText_affiliatedUnits_str(data.get(i).getAffiliatedUnits().toString());
                        mydialog.setEdit_userName_str(data.get(i).getUserName().toString());

                    }
                }
                mydialog.setYesOnclickListener("修改", new Mydialog_shudiandui.onYesOnclickListener() {
                    @Override
                    public void onyesonclick() {
                        mydialog.SetEditTextENeditable();
                        mydialog.setYesOnclickListener("提交", new Mydialog_shudiandui.onYesOnclickListener() {
                            @Override
                            public void onyesonclick() {
                                mydialog.dismiss();
                                postOkhttp3();
                            }
                        });
                    }


                });
                mydialog.setNoOnclickListener("取消", new Mydialog_shudiandui.onNoOnclickListener() {
                    @Override
                    public void onnoonclick() {
                        mydialog.dismiss();
                    }


                });
                mydialog.show();
            }


        });
    }

    private void postOkhttp3() {
        OkHttpClient okhhtp3=new OkHttpClient();
        MediaType media=MediaType.parse("application/json; charset=utf-8");
        RequestBody request= FormBody.create(media, createjson().toString());
        Request request1=new Request.Builder()
                .url("http://123.56.106.24:8081/people/save")
                .post(request)
                .build();
        Call call=okhhtp3.newCall(request1);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();
                JSONObject jsonObject = JSON.parseObject(res);
                final int status = (int) jsonObject.get("status");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (status == 1) {
                            Toast.makeText(Safeguard_Managing_people_shudian.this, "修改成功！", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(Safeguard_Managing_people_shudian.this, "修改失败！", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }

    private JSONObject createjson() {
        JSONObject jsonObject=new JSONObject();
        Integer integer = Integer.parseInt(mydialog.getPid());
        jsonObject.put("pid",integer);
        jsonObject.put("affiliatedUnits",mydialog.getEditText_affiliatedUnits_str());
        jsonObject.put("canUse",mydialog.getEditext_canUse_str());
        jsonObject.put("gender",mydialog.getEdit_gender_str());
        jsonObject.put("ppName",mydialog.getEdit_ppName_str());
        jsonObject.put("rankNum",mydialog.getEdit_rankNum_str());
        jsonObject.put("remarks",mydialog.getEdit_remarks_str());
        jsonObject.put("telNum",mydialog.getEdit_telNum_str());
        jsonObject.put("userName",mydialog.getEdit_userName_str());
        jsonObject.put("userRole",mydialog.getEdit_userRole_str());
        JSONObject jsonObject1=JSON.parseObject(jsonObject.toString());
        return  jsonObject1;

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater=new MenuInflater(this);
        menuInflater.inflate(R.menu.context_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final AdapterView.AdapterContextMenuInfo adapterContextMenuInfo= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.context_menu_delete:
                OkHttpClient okHttpClient=new OkHttpClient();
                final Request request=new Request.Builder()
                        .url("http://123.56.106.24:8081/people/delete/"+data.get(adapterContextMenuInfo.position).getPid())
                        .get()
                        .build();
                Call call=okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(Safeguard_Managing_people_shudian.this, "服务器连接失败！", Toast.LENGTH_SHORT).show();

                            }
                        });
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        data.remove(adapterContextMenuInfo.position);
                        String res=response.body().string();
                        JSONObject jsonObject= JSON.parseObject(res);
                        final int status= (int) jsonObject.get("status");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (status==1){
                                    listView.setAdapter(new MylistviewAdapter());
                                    Toast.makeText(Safeguard_Managing_people_shudian.this, "删除成功！", Toast.LENGTH_SHORT).show();

                                }else {
                                    Toast.makeText(Safeguard_Managing_people_shudian.this, "删除失败！", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });

        }
        return true;
    }
    private void showResult(final ManagepeopleInfo managePeopleInfo) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                data.add(managePeopleInfo);
                listView.setAdapter(new MylistviewAdapter());
            }
        });
    }


    private class MylistviewAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(Safeguard_Managing_people_shudian.this, R.layout.layout_listview_items, null);
            TextView textView12 = (TextView) view.findViewById(R.id.text_program_name);
            TextView tvTitle1 = (TextView) view.findViewById(R.id.text_pijianhao);
            TextView tvTitle = (TextView) view.findViewById(R.id.TV_listTitle_Id);
            TextView tvTime = (TextView) view.findViewById(R.id.TV_listTime_Id);
            TextView tvContext = (TextView) view.findViewById(R.id.TV_listContext_Id);
            tvTitle1.setText("排序号:");
            textView12.setText("姓名:");
            tvTitle.setText(data.get(position).getPid() + "");
            String name = data.get(position).getPpName();
            if(name.length() > 12) {
                name = name.substring(0,12) + "...";
            }
            tvTime.setText(name);
            tvContext.setText(data.get(position).getRankNum());
            return view;
        }
    }
}
