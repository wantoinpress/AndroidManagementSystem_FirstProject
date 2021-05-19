package zdfwuy.newproject.Management;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
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
import zdfwuy.newproject.data_management.ConstructionInfo123;
import zdfwuy.newproject.dialog.Mydialog_management.Mydialog_constrution_unit_management;

public class Management_Type_of_Construction_Unit extends Activity {
    ListView listView;
    List<ConstructionInfo123> data=new ArrayList<>();
    DatacollectionInfo datacollection;
    DrawerLayout drawerLayout;

    Mydialog_constrution_unit_management mydialog;
    Button btn_to_submit,btn_to_cancel;
    EditText Edit_company_year_processing,Edit_the_project_company;
    String Edit_company_year_processing_str,Edit_the_project_company_str;
    String unittype="全部";
    String unitname="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_of__construction__unit);
        listView= (ListView) findViewById(R.id.Listview_choose_Type_construction);
        Edit_company_year_processing = (EditText) findViewById(R.id.Edit_company_year_processing);
        Edit_the_project_company = (EditText) findViewById(R.id.Edit_the_project_company);
        drawerLayout = (DrawerLayout) findViewById(R.id.dlShow);
        get_okhttpclient(unittype , unitname);
        listView_Onclick();
        Btn_setonclick();
    }
    private void Btn_setonclick() {
        btn_to_submit= (Button) findViewById(R.id.btn_to_submit);
        btn_to_cancel= (Button) findViewById(R.id.btn_to_cancel);

        btn_to_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String_Edit_project_name=Edit_the_project_company.getText().toString().equals("") ? "全部" : Edit_the_project_company.getText().toString();
//                String_Edit_the_project_year_=Edit_company_year_processing.getText().toString().equals("") ? "0" : Edit_company_year_processing.getText().toString();
                Edit_company_year_processing_str = Edit_company_year_processing.getText().toString().equals("") ? "" : Edit_company_year_processing.getText().toString();
                Edit_the_project_company_str = Edit_the_project_company.getText().toString().equals("") ? "全部" : Edit_the_project_company.getText().toString();
                System.out.println(Edit_company_year_processing_str + "----------" + Edit_the_project_company_str + "++++++++");
                get_okhttpclient(Edit_the_project_company_str, Edit_company_year_processing_str);
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
                Intent intent=new Intent(Management_Type_of_Construction_Unit.this,Management_Type_of_Construction_Unit_add.class);
                startActivity(intent);
                break;
            case R.id.Search_one:
                drawerLayout.openDrawer(Gravity.END);
            default:break;
        }
        return true;
    }
    private void listView_Onclick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mydialog = new Mydialog_constrution_unit_management(Management_Type_of_Construction_Unit.this, R.style.MyDialog);
                for (int i = 0; i < data.size(); i++) {
                     /*EditText_engineerprogram_production,Editext_pijianhao,Edit_investment_money,Edit_orginal_pijianhao,Edit_production_engineerTime,
            Edit_production_contractNum,Edit_production_startday,Edit_production_endday,Edit_production_signDate,Edit_production_performance;
*/
                    if (i == position) {
                        mydialog.setPid(data.get(i).getPid().toString());
                        mydialog.setEditext_rankNum_str(data.get(i).getRankNum());
                        mydialog.setEditext_unitType_str(data.get(i).getUnitType());
                        mydialog.setEditext_unitName_str(data.get(i).getUnitName());
                        mydialog.setEdit_remarks_str(data.get(i).getRemarks());
                        mydialog.setEdit_isUsed_str(data.get(i).getIsUsed());

                    }
                }
                mydialog.setYesOnclickListener("确定", new Mydialog_constrution_unit_management.onYesOnclickListener() {
                    @Override
                    public void onYesOnclick() {
                        mydialog.SetEditTextENeditable();
                        mydialog.setYesOnclickListener("确定", new Mydialog_constrution_unit_management.onYesOnclickListener() {
                            @Override
                            public void onYesOnclick() {
                                mydialog.dismiss();
                                postOkhttp3();
                            }
                        });
                    }
                });
                mydialog.setNoOnclickListener("取消", new Mydialog_constrution_unit_management.onNoOnclickListener() {
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
                        .url("http://123.56.106.24:8081/conunitmanage/save")
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
                                    Toast.makeText(Management_Type_of_Construction_Unit.this, "修改成功！", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(Management_Type_of_Construction_Unit.this, "修改失败！", Toast.LENGTH_SHORT).show();

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
                jsonObject.put("rankNum", mydialog.getEditext_rankNum_str());
                jsonObject.put("unitType", mydialog.getEditext_unitType_str());
                jsonObject.put("unitName", mydialog.getEditext_unitName_str());
                jsonObject.put("remarks", mydialog.getEdit_remarks_str());


                JSONObject jsonObject1 = JSONObject.parseObject(jsonObject.toString());
                return jsonObject1;
            }
        });
    }

    private void get_okhttpclient(String unittype,String unitname ) {
        OkHttpClient okhttp3=new OkHttpClient();
        final Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/conunitmanage/get?unittype=" + unittype + "&unitname=" + unitname )
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

                    String rankNum = j.getString("rankNum");

                    String unitType = j.getString("unitType");
                    String unitName = j.getString("unitName");
                    String remarks = j.getString("remarks");


                    String isUsed = j.getString("isUsed");


                    ShowResult(pid,rankNum,unitType,unitName, remarks, isUsed);
                }
            }
        });
    }

    private void ShowResult(final Integer pid, final String rankNum , final String unitType,final String unitName, final String remarks, final String isUsed) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ConstructionInfo123 construct = new ConstructionInfo123();
                construct.setPid(pid);
                construct.setRankNum(rankNum);
                construct.setUnitType(unitType);
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

            View view=View.inflate(Management_Type_of_Construction_Unit.this,R.layout.layout_listview_items,null);
            TextView tv_id= (TextView) view.findViewById(R.id.TV_listTitle_Id);
            TextView tv_title= (TextView) view.findViewById(R.id.TV_listTime_Id);
            TextView tvContext = (TextView) view.findViewById(R.id.TV_listContext_Id);

            tv_id.setText(data.get(position).getPid()+"");
            String name = data.get(position).getUnitName();
            if(name.length() > 12) {
                name = name.substring(0,12) + "...";
            }
            tv_title.setText(name);
            tvContext.setText(data.get(position).getRankNum());
            return view;
        }
    }
}
