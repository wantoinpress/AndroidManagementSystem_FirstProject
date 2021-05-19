package zdfwuy.newproject.Daily;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import zdfwuy.newproject.R;
import zdfwuy.newproject.data_collection.DatacollectionInfo;
import zdfwuy.newproject.data_daily.ActiveUserInfo;
import zdfwuy.newproject.dialog.Mydialog_management.Mydialog_subcontractor_management;

public class Daily_active_user extends Activity {
    ListView listView;
    List<ActiveUserInfo> data=new ArrayList<>();
    DatacollectionInfo datacollection;
    DrawerLayout drawerLayout;

    Mydialog_subcontractor_management mydialog;
    Button btn_to_submit,btn_to_cancel;
    EditText Edit_company_year_processing,Edit_the_project_company;
    String Edit_company_year_processing_str,Edit_the_project_company_str;
    String unittype="上市单位";
    String unitname="红岗";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_active_user);
        listView= (ListView) findViewById(R.id.Listview_daily_user);
        get_okhttpclient();
    }

    private void get_okhttpclient( ) {
        OkHttpClient okhttp3=new OkHttpClient();
        final Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/activeuser/get")
                .get()
                .build();
        Call call=okhttp3.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                data.clear();
                String res = response.body().string();
                JSONArray jsonarray = JSON.parseArray(res);
                System.out.println(jsonarray);
                for (int i = 0; i < jsonarray.size(); i++) {
                    ActiveUserInfo operationInfo = new ActiveUserInfo();
                    JSONObject j = (JSONObject) jsonarray.get(i);
                    operationInfo.setPid((Integer) j.get("pid"));
                    String oprationName = j.getString("activeTime");
                    operationInfo.setActiveTime(oprationName);
                    String userName = j.getString("activeName");
                    operationInfo.setActiveName(userName);
                    operationInfo.setUserName(j.getString("userName"));
                    operationInfo.setUnitName(j.getString("unitName"));
                    ShowResult(operationInfo);
                }
            }
        });
    }

    private void ShowResult(final ActiveUserInfo operationInfo) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                data.add(operationInfo);
                listView.setAdapter(new Myadapter());
            }
        });

    }
    private class Myadapter extends BaseAdapter {
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

            View view=View.inflate(Daily_active_user.this,R.layout.layout_listview_items,null);
            TextView tv_user_pianjian= (TextView) view.findViewById(R.id.text_pijianhao);
            TextView tv_id= (TextView) view.findViewById(R.id.TV_listTitle_Id);
            TextView tv_title= (TextView) view.findViewById(R.id.TV_listTime_Id);
            TextView tvContext = (TextView) view.findViewById(R.id.TV_listContext_Id);

            tv_user_pianjian.setText("用户登录时间：");
            tv_id.setText(data.get(position).getPid()+"");
            tv_title.setText(data.get(position).getUserName());
            tvContext.setText(data.get(position).getActiveTime());
            return view;
        }
    }
}
