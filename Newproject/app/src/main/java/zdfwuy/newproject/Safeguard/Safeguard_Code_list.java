package zdfwuy.newproject.Safeguard;

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
import zdfwuy.newproject.Iformation.Iformation_contract_add;
import zdfwuy.newproject.R;
import zdfwuy.newproject.data_collection.DatacollectionInfo;
import zdfwuy.newproject.data_safeguard.CodelistInfo;
import zdfwuy.newproject.dialog.Mydialog_safeguard.Mydialog_code_list_safeguard;

public class Safeguard_Code_list extends Activity {
    ListView listView;
    List<CodelistInfo> data=new ArrayList<>();
    DatacollectionInfo datacollection;
    DrawerLayout drawerLayout;

    Mydialog_code_list_safeguard mydialog;
    Button btn_to_submit,btn_to_cancel;
    EditText Edit_company_year_processing,Edit_the_project_company;
    String Edit_company_year_processing_str,Edit_the_project_company_str;
    String company="单位";
    String isfin="是";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safeguard__code_list);
        listView= (ListView) findViewById(R.id.Listview_choose_Iformation_codelist);
        drawerLayout = (DrawerLayout) findViewById(R.id.dlShow);
        Edit_the_project_company= (EditText) findViewById(R.id.Edit_the_project_company);
        btn_setOnclick();
        getOkhttp3(company);
        listView_Onclick();
    }

    private void listView_Onclick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mydialog = new Mydialog_code_list_safeguard(Safeguard_Code_list.this, R.style.MyDialog);
                for (int i = 0; i < data.size(); i++) {
                     /*EditText_engineerprogram_production,Editext_pijianhao,Edit_investment_money,Edit_orginal_pijianhao,Edit_production_engineerTime,
            Edit_production_contractNum,Edit_production_startday,Edit_production_endday,Edit_production_signDate,Edit_production_performance;
*/
                    if (i == position) {
                        mydialog.setPid(data.get(i).getPid().toString());
                        mydialog.setEdit_exportModel_str(data.get(i).getExportModel());
                        mydialog.setEditext_codeName_str(data.get(i).getCodeName());
                        mydialog.setEdit_sqlSetence_str(data.get(i).getSqlSetence());
                        mydialog.setEdit_topSelect_str(data.get(i).getTopSelect());

                    }
                }
                mydialog.setYesOnclickListener("确定", new Mydialog_code_list_safeguard.onYesOnclickListener() {
                    @Override
                    public void onYesOnclick() {
                        mydialog.SetEditTextENeditable();
                        mydialog.setYesOnclickListener("确定", new Mydialog_code_list_safeguard.onYesOnclickListener() {
                            @Override
                            public void onYesOnclick() {
                                postOkhttp3();
                                mydialog.dismiss();

                            }
                        });
                    }
                });
                mydialog.setNoOnclickListener("取消", new Mydialog_code_list_safeguard.onNoOnclickListener() {
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
                        .url("http://123.56.106.24:8081/codelist/save")
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
                                    Toast.makeText(Safeguard_Code_list.this, "修改成功！", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(Safeguard_Code_list.this, "修改失败！", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                    }
                });
            }

            private JSONObject creatjson() {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("pid", mydialog.getPid());
                jsonObject.put("codeName", mydialog.getEditext_codeName_str());
                jsonObject.put("sqlSetence", mydialog.getEdit_sqlSetence_str());
                jsonObject.put("topSelect", mydialog.getEdit_topSelect_str());
                jsonObject.put("exportModel", mydialog.getEdit_exportModel_str());


                JSONObject jsonObject1 = JSONObject.parseObject(jsonObject.toString());
                return jsonObject1;
            }
        });
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
                        .url("http://123.56.106.24:8081/codelist/delete/"+data.get(adapterContextMenuInfo.position).getPid())
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
                                    listView.setAdapter(new MylistviewAdapter());
                                    Toast.makeText(Safeguard_Code_list.this, "删除成功！", Toast.LENGTH_SHORT).show();

                                }else {
                                    Toast.makeText(Safeguard_Code_list.this, "删除失败！", Toast.LENGTH_SHORT).show();
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
                Intent intent=new Intent(Safeguard_Code_list.this,Iformation_contract_add.class);
                startActivity(intent);
                break;
            case R.id.Search_one:
                drawerLayout.openDrawer(Gravity.END);

                Edit_the_project_company.setText("全部");
            default:break;
        }
        return true;
    }

    private void btn_setOnclick() {

        btn_to_submit= (Button) findViewById(R.id.btn_to_submit);
        btn_to_cancel= (Button) findViewById(R.id.btn_to_cancel);

        btn_to_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_the_project_company_str = Edit_the_project_company.getText().toString();


                getOkhttp3(Edit_the_project_company_str);

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

    private void getOkhttp3(String companyname) {
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/codelist/get?codename="+companyname)
                .get()
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                data.clear();
                String res = response.body().string();
                JSONArray jsonArray = JSON.parseArray(res);
                System.out.println(jsonArray.toString());
                for (int i = 0; i < jsonArray.size(); i++) {
                    CodelistInfo c = new CodelistInfo();
                    JSONObject j = (JSONObject) jsonArray.get(i);

                    c.setPid((Integer) j.get("pid"));
                    c.setCodeName(j.getString("codeName"));
                    c.setSqlSetence(j.getString("sqlSetence"));
                    c.setTopSelect(j.getString("topSelect"));
                    c.setExportModel(j.getString("exportModel"));


                    showresult(c);
                }
            }


        });
    }

    private void showresult(final CodelistInfo c) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                data.add(c);
                listView.setAdapter(new MylistviewAdapter());
            }
        });
    }
    private class MylistviewAdapter extends BaseAdapter {
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
            View view = View.inflate(Safeguard_Code_list.this, R.layout.layout_listview_items, null);
            TextView tvTitle = (TextView) view.findViewById(R.id.TV_listTitle_Id);
            TextView tvTime = (TextView) view.findViewById(R.id.TV_listTime_Id);
            TextView tvContext = (TextView) view.findViewById(R.id.TV_listContext_Id);
            String name = data.get(position).getCodeName();
            if(name.length() > 12) {
                name = name.substring(0,12) + "...";
            }
            tvTime.setText(name);

            tvTitle.setText(data.get(position).getCodeName());
            tvContext.setText(data.get(position).getTopSelect());
            return view;
        }
    }
}
