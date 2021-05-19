package zdfwuy.newproject.Notice;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
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
import zdfwuy.newproject.data_to_maintain.NoticeTomanageInfo;
import zdfwuy.newproject.dialog.Mydialog_to_Notice.Mydialog_Notice_to_manage;

public class Notice_to_manage extends Activity {
    LinearLayout linearLayout;
    ListView listView;
    List<NoticeTomanageInfo> data=new ArrayList<>();

    DrawerLayout drawerLayout;
    Mydialog_Notice_to_manage mydialog;
    Button btn_to_submit,btn_to_cancel;
    EditText Edit_the_pid;
    String Edit_the_pid_str,Edit_the_project_company_str;
    String company="全部";
    Integer pid=331;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_to_maintain);
        listView= (ListView) findViewById(R.id.Listview_choose_Iformation_maintain);
        Edit_the_pid= (EditText) findViewById(R.id.Edit_the_pid);
        drawerLayout = (DrawerLayout) findViewById(R.id.dlShow);
        registerForContextMenu(listView);
        get_okhttpclient();

        ListViewOnclick();
        Btn_setonclick();
    }

    private void ListViewOnclick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mydialog = new Mydialog_Notice_to_manage(Notice_to_manage.this, R.style.MyDialog);

                for (int i = 0; i < data.size(); i++) {
                     /*EditText_engineerprogram_production,Editext_pijianhao,Edit_investment_money,Edit_orginal_pijianhao,Edit_production_engineerTime,
            Edit_production_contractNum,Edit_production_startday,Edit_production_endday,Edit_production_signDate,Edit_production_performance;
*/
                    if (i == position) {
                        mydialog.setPid(data.get(i).getPid().toString());
                        mydialog.setEditext_title_str(data.get(i).getTitle());
                        mydialog.setEdit_isSeen_str(data.get(i).getIsSeen());
                        mydialog.setEdit_isTop_str(data.get(i).getIsTop());
                        mydialog.setEdit_visibleRange_str(data.get(i).getVisibleRange());
                        mydialog.setEdit_releaseTime_str(data.get(i).getReleaseTime());
                        mydialog.setEdit_releasePeople_str(data.get(i).getReleasePeople());
                        mydialog.setEdit_readTime_str(data.get(i).getReadTime());
                        mydialog.setEdit_bulletinContent_str(data.get(i).getBulletinContent());
                    }
                }
                mydialog.setYesOnclickListener("修改", new Mydialog_Notice_to_manage.onYesOnclickListener() {
                    @Override
                    public void onYesOnclick() {
                        mydialog.SetEditTextENeditable();
                        mydialog.setYesOnclickListener("提交", new Mydialog_Notice_to_manage.onYesOnclickListener() {
                            @Override
                            public void onYesOnclick() {
                                mydialog.setYesStr("提交");
                                mydialog.dismiss();
                                postOkhttp3();
                            }
                        });
                    }
                });
                mydialog.setNoOnclickListener("取消", new Mydialog_Notice_to_manage.onNoOnclickListener() {
                    @Override
                    public void onNoOnclick() {

                        mydialog.dismiss();
                    }
                });
                mydialog.show();
            }

            private void postOkhttp3() {
                OkHttpClient okHttpClient = new OkHttpClient();
                MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
                RequestBody requestBody = FormBody.create(mediaType, creatjson().toString());
                final Request Request=new Request.Builder()
                        .url("http://123.56.106.24:8081/bulletinmaintenance/save")
                        .post(requestBody)
                        .build();
                Call call=okHttpClient.newCall(Request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String res=response.body().string();
                        JSONObject jsonobject=JSON.parseObject(res);
                        final int status= (int) jsonobject.get("status");
                        System.out.println("********测试!!");
                        System.out.println(mydialog.getPid());
                        System.out.println(status);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(status==1){
                                    Toast.makeText(Notice_to_manage.this, "修改成功！", Toast.LENGTH_SHORT).show();

                                }else {
                                    Toast.makeText(Notice_to_manage.this, "修改失败！", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                    }
                });
            }

            private JSONObject creatjson() {
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("pid",mydialog.getPid());
                jsonObject.put("title",mydialog.getEditext_title_str());
                jsonObject.put("isSeen",mydialog.getEdit_isSeen_str());
                jsonObject.put("isTop",mydialog.getEdit_isTop_str());
                jsonObject.put("visibleRange",mydialog.getEdit_visibleRange_str());
                jsonObject.put("releaseTime",mydialog.getEdit_readTime_str());
                jsonObject.put("releasePeople",mydialog.getEdit_releasePeople_str());
                jsonObject.put("readTime",mydialog.getEdit_readTime_str());
                jsonObject.put("bulletinContent",mydialog.getEdit_bulletinContent_str());
                JSONObject jsonObject1=JSONObject.parseObject(jsonObject.toString());
                return jsonObject1;
            }
        });
    }

    private void Btn_setonclick() {
        btn_to_submit= (Button) findViewById(R.id.btn_to_submit);
        btn_to_cancel= (Button) findViewById(R.id.btn_to_cancel);

        btn_to_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_the_pid_str = Edit_the_pid.getText().toString();


                int year = Integer.parseInt(Edit_the_pid_str);
                Integer year1=new Integer(year);
                get_okhttpclient_pid(year1);

                drawerLayout.closeDrawers();
            }
        });

        btn_to_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });
    }
    private void get_okhttpclient() {
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/bulletinmaintenance/getall")
                .get()
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Notice_to_manage.this, "服务器连接失败！", Toast.LENGTH_SHORT).show();
                    }
                });
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                data.clear();
                String result = response.body().string();
                JSONArray jsonArray = JSON.parseArray(result);
                System.out.println(jsonArray.toString());
                for (int i = 0; i < jsonArray.size(); i++) {
                    NoticeTomanageInfo noticeTomanageInfo = new NoticeTomanageInfo();
                    JSONObject j = (JSONObject) jsonArray.get(i);
                    Integer pid = (Integer) j.get("pid");
                    noticeTomanageInfo.setPid(pid);
                    String engeenirName = j.getString("title");
                    noticeTomanageInfo.setTitle(engeenirName);
                    String constructionUnit = j.getString("isSeen");
                    noticeTomanageInfo.setIsSeen(constructionUnit);
                    String workUnit = j.getString("isTop");
                    noticeTomanageInfo.setIsTop(workUnit);
                    String numOfItem = j.getString("visibleRange");
                    noticeTomanageInfo.setVisibleRange(numOfItem);
                    String contractNum = j.getString("releaseTime");
                    noticeTomanageInfo.setReleaseTime(contractNum);
                    String contractNum1 = j.getString("readTime");
                    noticeTomanageInfo.setReadTime(contractNum1);
                    String signDate = j.getString("releasePeople");
                    noticeTomanageInfo.setReleasePeople(signDate);
                    String startDate = j.getString("bulletinContent");
                    noticeTomanageInfo.setBulletinContent(startDate);

                    ShowRequetResult(noticeTomanageInfo);
                }


            }
        });
    }

    private void get_okhttpclient_pid(Integer getpid) {
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/bulletinmaintenance/getcontent/"+getpid)
                .get()
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Notice_to_manage.this, "服务器连接失败！", Toast.LENGTH_SHORT).show();
                    }
                });
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                data.clear();
                String result = response.body().string();
                JSONObject jsonArray = JSON.parseObject(result);
                System.out.println(jsonArray);
                NoticeTomanageInfo noticeTomanageInfo = new NoticeTomanageInfo();
//                for (int i = 0; i < jsonArray.size(); i++) {
//
//                JSONObject j = (JSONObject) jsonArray.get(i);
//
//
//                }

                Integer pid = (Integer) jsonArray.get("pid");
                noticeTomanageInfo.setPid(pid);
                String engeenirName = jsonArray.getString("title");
                noticeTomanageInfo.setTitle(engeenirName);
                String constructionUnit = jsonArray.getString("isSeen");
                noticeTomanageInfo.setIsSeen(constructionUnit);
                String workUnit = jsonArray.getString("isTop");
                noticeTomanageInfo.setIsTop(workUnit);
                String numOfItem = jsonArray.getString("visibleRange");
                noticeTomanageInfo.setVisibleRange(numOfItem);
                String contractNum = jsonArray.getString("releaseTime");
                noticeTomanageInfo.setReleaseTime(contractNum);
                String contractNum1 = jsonArray.getString("readTime");
                noticeTomanageInfo.setReadTime(contractNum1);
                String signDate = jsonArray.getString("releasePeople");
                noticeTomanageInfo.setReleasePeople(signDate);
                String startDate = jsonArray.getString("bulletinContent");
                noticeTomanageInfo.setBulletinContent(startDate);
                ShowRequetResult(noticeTomanageInfo);


            }
        });
    }

    private void ShowRequetResult(final NoticeTomanageInfo noticeTomanageInfo) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                data.add(noticeTomanageInfo);
                listView.setAdapter(new Myadapter());
            }
        });
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
                        .url("http://123.56.106.24:8081/bulletinmaintenance/delete/"+data.get(adapterContextMenuInfo.position).getPid())
                        .get()
                        .build();
                Call call=okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

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
                                    listView.setAdapter(new Myadapter());
                                    Toast.makeText(Notice_to_manage.this, "删除成功！", Toast.LENGTH_SHORT).show();

                                }else {
                                    Toast.makeText(Notice_to_manage.this, "删除失败！", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });

        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                Intent intent=new Intent(Notice_to_manage.this,Notice_to_manage_add.class);
                startActivity(intent);
                break;
            case R.id.Search_one:
                drawerLayout.openDrawer(Gravity.END);
                Edit_the_pid.setText("331");
            default:break;
        }
        return true;
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

            View view=View.inflate(Notice_to_manage.this,R.layout.layout_listview_items,null);
            TextView tv_id= (TextView) view.findViewById(R.id.TV_listTitle_Id);
            TextView tv_title= (TextView) view.findViewById(R.id.TV_listTime_Id);
            TextView tvContext = (TextView) view.findViewById(R.id.TV_listContext_Id);

            tv_id.setText(data.get(position).getPid()+"");
            String name = data.get(position).getTitle();
            if(name.length() > 12) {
                name = name.substring(0,12) + "...";
            }
            tv_title.setText(name);
            tvContext.setText(data.get(position).getReadTime());
            return view;
        }
    }
}
