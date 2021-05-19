package zdfwuy.newproject.Iformation;

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
import java.math.BigDecimal;
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
import zdfwuy.newproject.dialog.Mydialog_contract;

public class Iformation_contract extends Activity {
    LinearLayout linearLayout;
    ListView listView;
    List<ContractInfo> data=new ArrayList<>();
    ContractInfo contractinfo;
    DrawerLayout drawerLayout;

    Mydialog_contract mydialog;
    Button btn_to_submit,btn_to_cancel;
    EditText Edit_company_year_processing,Edit_the_project_company;
    String Edit_project_name="全部",String_Edit_project_name,String_Edit_the_project_year_ = "0";

    String Edit_company_year_processing_str,Edit_the_project_company_str;
    String company="全部";
    int year=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iformation_contract);
        listView= (ListView) findViewById(R.id.Listview_choose_Iformation_contract);
        drawerLayout= (DrawerLayout) findViewById(R.id.dlShow);
        Edit_company_year_processing= (EditText) findViewById(R.id.Edit_company_year_processing);
        Edit_the_project_company= (EditText) findViewById(R.id.Edit_the_project_company);
        registerForContextMenu(listView);
        get_okhttpclient(company,year);

        /*Btn点击事件*/
        Btn_setonclick();

        /*ListViewOnclick*/
        ListViewOnclick();
    }

    private void ListViewOnclick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mydialog = new Mydialog_contract(Iformation_contract.this, R.style.MyDialog);

                for (int i = 0; i < data.size(); i++) {
                     /*EditText_engineerprogram_production,Editext_pijianhao,Edit_investment_money,Edit_orginal_pijianhao,Edit_production_engineerTime,
            Edit_production_contractNum,Edit_production_startday,Edit_production_endday,Edit_production_signDate,Edit_production_performance;
*/
                    if (i == position) {
                        mydialog.setPid(data.get(i).getPid().toString());
                        mydialog.setEditText_engineerprogram_production_str(data.get(i).getEngineerName());
                        mydialog.setEditext_pijianhao_str(data.get(i).getNumOfItem());
                        mydialog.setEdit_investment_money_str(data.get(i).getContractMoney().toString());
                        mydialog.setEdit_production_contractNum_str(data.get(i).getContractNum());
                        mydialog.setEdit_production_engineerTime_str(data.get(i).getEngineerName());
                        mydialog.setEdit_production_startday_str(data.get(i).getStartDate());
                        mydialog.setEdit_production_endday_str(data.get(i).getEndDate());
                        mydialog.setEdit_production_signDate_str(data.get(i).getSignDate());
                        mydialog.setEdit_production_performance_str(data.get(i).getPerformance());
                    }
                }
                mydialog.setYesOnclickListener("修改", new Mydialog_contract.onYesOnclickListener() {
                    @Override
                    public void onYesOnclick() {
                        mydialog.SetEditTextENeditable();
                        mydialog.setYesOnclickListener("提交", new Mydialog_contract.onYesOnclickListener() {
                            @Override
                            public void onYesOnclick() {
                                mydialog.setYesStr("提交");
                                mydialog.dismiss();
                                postOkhttp3();
                            }
                        });
                    }
                });
                mydialog.setNoOnclickListener("取消", new Mydialog_contract.onNoOnclickListener() {
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
                        .url("http://123.56.106.24:8081/contract/save")
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
                                    Toast.makeText(Iformation_contract.this, "修改成功！", Toast.LENGTH_SHORT).show();
                                    get_okhttpclient(company,year);
                                }else {
                                    Toast.makeText(Iformation_contract.this, "修改失败！", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                    }
                });
            }

            private JSONObject creatjson() {
                JSONObject jsonObject=new JSONObject();
                Integer pid = Integer.parseInt(mydialog.getPid());
                jsonObject.put("pid",pid);
                jsonObject.put("engineerName",mydialog.getEditText_engineerprogram_production_str());
                jsonObject.put("numOfItem",mydialog.getEditext_pijianhao_str());
                jsonObject.put("engineerTime",mydialog.getEdit_production_engineerTime_str());
                jsonObject.put("contractNum",mydialog.getEdit_production_contractNum_str());
                jsonObject.put("signDate",mydialog.getEdit_production_signDate_str());
                jsonObject.put("startDate",mydialog.getEdit_production_startday_str());
                jsonObject.put("endDate",mydialog.getEdit_production_endday_str());
                jsonObject.put("performance",mydialog.getEdit_production_performance_str());
                jsonObject.put("contractMoney", mydialog.getEdit_investment_money_str());

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
//                String_Edit_project_name=Edit_the_project_company.getText().toString().equals("") ? "全部" : Edit_the_project_company.getText().toString();
//                String_Edit_the_project_year_=Edit_company_year_processing.getText().toString().equals("") ? "0" : Edit_company_year_processing.getText().toString();
                Edit_company_year_processing_str = Edit_company_year_processing.getText().toString().equals("")?"全部":Edit_company_year_processing.getText().toString();
                Edit_the_project_company_str = Edit_the_project_company.getText().toString().equals("")?"全部":Edit_the_project_company.getText().toString();
                int year1=Integer.parseInt(Edit_company_year_processing_str);
                get_okhttpclient(Edit_the_project_company_str,year1);

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

    private void get_okhttpclient(String company,int year) {
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder()
                .url(" http://123.56.106.24:8081/contract/get?engineertime="+year+"&workunit="+company)
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Iformation_contract.this, "服务器连接失败！", Toast.LENGTH_SHORT).show();
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
                    JSONObject j = (JSONObject) jsonArray.get(i);
                    Integer pid = (Integer) j.get("pid");
                    System.out.println(pid);
                    String engeenirName = j.getString("engineerName");
                    String constructionUnit = j.getString("constructionUnit");
                    String workUnit = j.getString("workUnit");
                    String numOfItem = j.getString("numOfItem");
                    Integer engineerTime = (Integer) j.get("engineerTime");
                    BigDecimal contractMoney = (BigDecimal) j.get("contractMoney");
                    String contractNum = j.getString("contractNum");
                    String signDate = j.getString("signDate");
                    String startDate = j.getString("startDate");
                    String endDate = j.getString("endDate");
                    String performance = j.getString("performance");
                    ShowRequetResult(pid, engeenirName, constructionUnit, workUnit, numOfItem, engineerTime, contractMoney, contractNum, signDate, startDate, endDate, performance);
                }


            }
        });
    }

    private void ShowRequetResult(final Integer pid, final String engeenirName, final String constructionUnit, final String workUnit, final String numOfItem,
                                  final Integer engineerTime, final BigDecimal contractMoney, final String contractNum, final String signDate,
                                  final String startDate, final String endDate, final String performance) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                contractinfo=new ContractInfo();
                contractinfo.setPid(pid);
                contractinfo.setEngineerName(engeenirName);
                contractinfo.setConstructionUnit(constructionUnit);
                contractinfo.setWorkUnit(workUnit);
                contractinfo.setNumOfItem(numOfItem);
                contractinfo.setEngineerTime(engineerTime);
                contractinfo.setContractMoney(contractMoney);
                contractinfo.setContractNum(contractNum);
                contractinfo.setSignDate(signDate);
                contractinfo.setStartDate(startDate);
                contractinfo.setEndDate(endDate);
                contractinfo.setPerformance(performance);
                data.add(contractinfo);
                listView.setAdapter(new Myadapter());
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
                        .url("http://123.56.106.24:8081/contract/delete/"+data.get(adapterContextMenuInfo.position).getPid())
                        .get()
                        .build();
                Call call=okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(Iformation_contract.this, "服务器连接失败！", Toast.LENGTH_SHORT).show();

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
                                    Toast.makeText(Iformation_contract.this, "删除成功！", Toast.LENGTH_SHORT).show();

                                }else {
                                    Toast.makeText(Iformation_contract.this, "删除失败！", Toast.LENGTH_SHORT).show();
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
                Intent intent=new Intent(Iformation_contract.this,Iformation_contract_add.class);
                startActivity(intent);
                break;
            case R.id.Search_one:
                drawerLayout.openDrawer(Gravity.END);
            default:break;
        }
        return true;
    }

    /*创建我的ListView适配器*/
    private class Myadapter extends BaseAdapter{

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
            View view=View.inflate(Iformation_contract.this,R.layout.layout_listview_items,null);
            TextView tv_id= (TextView) view.findViewById(R.id.TV_listTitle_Id);
            TextView tv_title= (TextView) view.findViewById(R.id.TV_listTime_Id);
            TextView tvContext = (TextView) view.findViewById(R.id.TV_listContext_Id);

            tv_id.setText(data.get(position).getPid()+"");
            String name = data.get(position).getEngineerName();
            if(name.length() > 12) {
                name = name.substring(0,12) + "...";
            }
            tv_title.setText(name);
            tvContext.setText(data.get(position).getNumOfItem());
            return view;
        }
    }


}
