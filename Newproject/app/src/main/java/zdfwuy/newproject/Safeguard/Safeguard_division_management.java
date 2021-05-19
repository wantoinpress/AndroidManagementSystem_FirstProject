package zdfwuy.newproject.Safeguard;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.ContextMenu;
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
import zdfwuy.newproject.data.ContractInfo;
import zdfwuy.newproject.data_safeguard.DivisionInfo1;
import zdfwuy.newproject.dialog.Mydialog_safeguard.Mydialog_safeguard_division_mangement;

public class Safeguard_division_management extends Activity {
    LinearLayout linearLayout;
    ListView listView;
    List<DivisionInfo1> data=new ArrayList<>();
    ContractInfo contractinfo;
    DrawerLayout drawerLayout;

    Mydialog_safeguard_division_mangement mydialog;
    Button btn_to_submit,btn_to_cancel;
    EditText Edit_company_year_processing,Edit_the_project_company;
    String Edit_company_year_processing_str,Edit_the_project_company_str;
    String company="全部";
    int year=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safeguard_division_management);
        listView = (ListView) findViewById(R.id.Listview_choose_safeguard_division);
        get_okhttpclient();


        /*ListViewOnclick*/
        listView_Onclick();
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
                        .url("http://123.56.106.24:8081/department/delete/"+data.get(adapterContextMenuInfo.position).getPid())
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
                                    Toast.makeText(Safeguard_division_management.this, "删除成功！", Toast.LENGTH_SHORT).show();

                                }else {
                                    Toast.makeText(Safeguard_division_management.this, "删除失败！", Toast.LENGTH_SHORT).show();
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
                Intent intent=new Intent(Safeguard_division_management.this,Safeguard_division_management_add.class);
                startActivity(intent);
                break;

            default:break;
        }
        return true;
    }

    private void listView_Onclick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mydialog = new Mydialog_safeguard_division_mangement(Safeguard_division_management.this, R.style.MyDialog);
                for (int i = 0; i < data.size(); i++) {
                     /*EditText_engineerprogram_production,Editext_pijianhao,Edit_investment_money,Edit_orginal_pijianhao,Edit_production_engineerTime,
            Edit_production_contractNum,Edit_production_startday,Edit_production_endday,Edit_production_signDate,Edit_production_performance;
*/
                    if (i == position) {
                        mydialog.setPid(data.get(i).getPid().toString());

                        mydialog.setEditext_unitName_str(data.get(i).getUnitName());
                        mydialog.setEdit_remarks_str(data.get(i).getRemarks());
                        mydialog.setEdit_internalParameters_str(data.get(i).getInternalParameters());

                    }
                }
                mydialog.setYesOnclickListener("确定", new Mydialog_safeguard_division_mangement.onYesOnclickListener() {
                    @Override
                    public void onYesOnclick() {
                        mydialog.SetEditTextENeditable();
                        mydialog.setYesOnclickListener("确定", new Mydialog_safeguard_division_mangement.onYesOnclickListener() {
                            @Override
                            public void onYesOnclick() {
                                mydialog.dismiss();
                                postOkhttp3();
                            }
                        });
                    }
                });
                mydialog.setNoOnclickListener("取消", new Mydialog_safeguard_division_mangement.onNoOnclickListener() {
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
                        .url("http://123.56.106.24:8081/department/save")
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
                                    Toast.makeText(Safeguard_division_management.this, "修改成功！", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(Safeguard_division_management.this, "修改失败！", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                    }
                });
            }

            private JSONObject creatjson() {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("pid", mydialog.getPid());
                jsonObject.put("isUsed", mydialog.getEdit_internalParameters_str());

                jsonObject.put("unitName", mydialog.getEditext_unitName_str());
                jsonObject.put("remarks", mydialog.getEdit_remarks_str());


                JSONObject jsonObject1 = JSONObject.parseObject(jsonObject.toString());
                return jsonObject1;
            }
        });
    }


    private void get_okhttpclient( ) {
        OkHttpClient okhttp3=new OkHttpClient();
        final Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/department/get")
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


                    String internalParameters = j.getString("internalParameters");


                    ShowResult(pid,unitName, remarks, internalParameters);
                }
            }
        });
    }

    private void ShowResult(final Integer pid, final String unitName, final String remarks, final String internalParameters) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                DivisionInfo1 construct = new DivisionInfo1();
                construct.setPid(pid);
//                construct.setRankNum(rankNum);
                construct.setUnitName(unitName);
                construct.setRemarks(remarks);
                construct.setInternalParameters(internalParameters);

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

            View view=View.inflate(Safeguard_division_management.this,R.layout.layout_listview_items,null);
            TextView tv_manage= (TextView) view.findViewById(R.id.text_pijianhao);
            TextView tv_id= (TextView) view.findViewById(R.id.TV_listTitle_Id);
            TextView tv_title= (TextView) view.findViewById(R.id.TV_listTime_Id);
            TextView tvContext = (TextView) view.findViewById(R.id.TV_listContext_Id);
            tv_manage.setText("内部参数：");
            tv_id.setText(data.get(position).getPid()+"");
            String name = data.get(position).getUnitName();
            if(name.length() > 12) {
                name = name.substring(0,12) + "...";
            }
            tv_title.setText(name);
            tvContext.setText(data.get(position).getInternalParameters());
            return view;
        }
    }

}
