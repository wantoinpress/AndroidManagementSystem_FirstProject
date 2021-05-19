package zdfwuy.newproject.Management;

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
import zdfwuy.newproject.data_collection.DatacollectionInfo;
import zdfwuy.newproject.data_management.SubcontractorInfo12;
import zdfwuy.newproject.dialog.Mydialog_management.Mydialog_subcontractor_management;

public class Management_Subcontractor extends Activity {

    ListView listView;
    List<SubcontractorInfo12> data=new ArrayList<>();
    DatacollectionInfo datacollection;
    DrawerLayout drawerLayout;

    Mydialog_subcontractor_management mydialog;
    Button btn_to_submit,btn_to_cancel;
    EditText Edit_company_year_processing,Edit_the_project_company;
    String Edit_company_year_processing_str,Edit_the_project_company_str;
    String unittype="上市单位";
    String unitname="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcontractor_management);
        Edit_the_project_company = (EditText) findViewById(R.id.Edit_the_project_company);
        drawerLayout = (DrawerLayout) findViewById(R.id.dlShow);
        listView= (ListView) findViewById(R.id.Listview_choose_managetor);
        get_okhttpclient(unitname);
        listView_Onclick();
        Btn_setonclick();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater=new MenuInflater(this);
        menuInflater.inflate(R.menu.context_menu,menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final AdapterView.AdapterContextMenuInfo adapterContextMenuInfo= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.context_menu_delete:
                OkHttpClient okHttpClient=new OkHttpClient();
                final Request request=new Request.Builder()
                        .url("http://123.56.106.24:8081/subunitmanage/delete/"+data.get(adapterContextMenuInfo.position).getPid())
                        .get()
                        .build();
                Call call=okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(Management_Subcontractor.this, "服务器连接失败！", Toast.LENGTH_SHORT).show();

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
                                    listView.setAdapter(new Myadapter());
                                    Toast.makeText(Management_Subcontractor.this, "删除成功！", Toast.LENGTH_SHORT).show();

                                }else {
                                    Toast.makeText(Management_Subcontractor.this, "删除失败！", Toast.LENGTH_SHORT).show();
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
        MenuInflater menuInflater = getMenuInflater();
        menuInflater .inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                Intent intent=new Intent(Management_Subcontractor.this,Management_Subcontractor_add.class);
                startActivity(intent);
                break;
            case R.id.Search_one:
                drawerLayout.openDrawer(Gravity.END);
            default:break;
        }
        return true;
    }
    private void Btn_setonclick() {
        btn_to_submit= (Button) findViewById(R.id.btn_to_submit);
        btn_to_cancel= (Button) findViewById(R.id.btn_to_cancel);

        btn_to_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String_Edit_project_name=Edit_the_project_company.getText().toString().equals("") ? "全部" : Edit_the_project_company.getText().toString();
//                String_Edit_the_project_year_=Edit_company_year_processing.getText().toString().equals("") ? "0" : Edit_company_year_processing.getText().toString();
                Edit_the_project_company_str = Edit_the_project_company.getText().toString().equals("") ? "" : Edit_the_project_company.getText().toString();

                get_okhttpclient(Edit_the_project_company_str);

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

    private void listView_Onclick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mydialog = new Mydialog_subcontractor_management(Management_Subcontractor.this, R.style.MyDialog);
                for (int i = 0; i < data.size(); i++) {
                     /*EditText_engineerprogram_production,Editext_pijianhao,Edit_investment_money,Edit_orginal_pijianhao,Edit_production_engineerTime,
            Edit_production_contractNum,Edit_production_startday,Edit_production_endday,Edit_production_signDate,Edit_production_performance;
*/
                    if (i == position) {
                        mydialog.setPid(data.get(i).getPid().toString());

                        mydialog.setEditext_unitName_str(data.get(i).getUnitName());
                        mydialog.setEdit_remarks_str(data.get(i).getRemarks());
                        mydialog.setEdit_isUsed_str(data.get(i).getIsUsed());

                    }
                }
                mydialog.setYesOnclickListener("确定", new Mydialog_subcontractor_management.onYesOnclickListener() {
                    @Override
                    public void onYesOnclick() {
                        mydialog.SetEditTextENeditable();
                        mydialog.setYesOnclickListener("确定", new Mydialog_subcontractor_management.onYesOnclickListener() {
                            @Override
                            public void onYesOnclick() {
                                mydialog.dismiss();
                                postOkhttp3();
                            }
                        });
                    }
                });
                mydialog.setNoOnclickListener("取消", new Mydialog_subcontractor_management.onNoOnclickListener() {
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
                final Request Request = new Request.Builder()
                        .url("http://123.56.106.24:8081/subunitmanage/save")
                        .post(requestBody)
                        .build();
                Call call = okHttpClient.newCall(Request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String res = response.body().string();
                        JSONObject jsonobject = JSON.parseObject(res);
                        final int status = (int) jsonobject.get("status");
                        System.out.println("********测试!!");
                        System.out.println(mydialog.getPid());
                        System.out.println(status);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (status == 1) {
                                    Toast.makeText(Management_Subcontractor.this, "修改成功！", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(Management_Subcontractor.this, "修改失败！", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                    }
                });
            }

            private JSONObject creatjson() {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("pid", mydialog.getPid());
                jsonObject.put("isUsed", mydialog.getEdit_isUsed_str());

                jsonObject.put("unitName", mydialog.getEditext_unitName_str());
                jsonObject.put("remarks", mydialog.getEdit_remarks_str());


                JSONObject jsonObject1 = JSONObject.parseObject(jsonObject.toString());
                return jsonObject1;
            }
        });
    }

    private void get_okhttpclient(String unitname ) {
        OkHttpClient okhttp3=new OkHttpClient();
        final Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/subunitmanage/get?unitname="+unitname)
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
                    JSONObject j = (JSONObject) jsonarray.get(i);
                    Integer pid = (Integer) j.get("pid");
                    System.out.println(pid);

//                    String rankNum = j.getString("rankNum");
                    String unitName = j.getString("unitName");
                    String remarks = j.getString("remarks");


                    String isUsed = j.getString("isUsed");


                    ShowResult(pid,unitName, remarks, isUsed);
                }
            }
        });
    }

    private void ShowResult(final Integer pid, final String unitName, final String remarks, final String isUsed) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                SubcontractorInfo12 construct = new SubcontractorInfo12();
                construct.setPid(pid);
//                construct.setRankNum(rankNum);
                construct.setUnitName(unitName);
                construct.setRemarks(remarks);
                construct.setIsUsed(isUsed);

                data.add(construct);
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

            View view=View.inflate(Management_Subcontractor.this,R.layout.layout_listview_items,null);
            TextView tv_id= (TextView) view.findViewById(R.id.TV_listTitle_Id);
            TextView tv_title= (TextView) view.findViewById(R.id.TV_listTime_Id);
            TextView tvContext = (TextView) view.findViewById(R.id.TV_listContext_Id);

            tv_id.setText(data.get(position).getPid()+"");
            String name = data.get(position).getUnitName();
            if(name.length() > 12) {
                name = name.substring(0,12) + "...";
            }
            tv_title.setText(name);
            tvContext.setText(data.get(position).getRemarks());
            return view;
        }
    }
}
