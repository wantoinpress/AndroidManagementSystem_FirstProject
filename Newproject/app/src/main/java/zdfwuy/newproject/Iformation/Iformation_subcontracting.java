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
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import zdfwuy.newproject.R;
import zdfwuy.newproject.data.SubcontractInfo;
import zdfwuy.newproject.dialog.Mydialog_subcontract;

public class Iformation_subcontracting extends Activity {
    LinearLayout linearLayout;
    ListView listView;
    List<SubcontractInfo> data=new ArrayList<>();

    DrawerLayout drawerLayout;
    Mydialog_subcontract mydialog;
    Button btn_to_submit,btn_to_cancel;
    EditText Edit_company_year_processing,Edit_the_project_company;
    String Edit_company_year_processing_str,Edit_the_project_company_str;
    String company="全部";
    int year=0;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuinflater=getMenuInflater();
        menuinflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                Intent intent=new Intent(Iformation_subcontracting.this,Iformation_subcontracting_add.class);
                startActivity(intent);
                break;
            case R.id.Search_one:
                drawerLayout.openDrawer(Gravity.END);
                break;
            default:break;
        }

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iformation_subcontracting);
        Edit_company_year_processing= (EditText) findViewById(R.id.Edit_company_year_processing);
        Edit_the_project_company= (EditText) findViewById(R.id.Edit_the_project_company);
        listView= (ListView) findViewById(R.id.Listview_choose_Iformation_subcontracting);
        drawerLayout= (DrawerLayout) findViewById(R.id.dlShow);
        registerForContextMenu(listView);
        btn_onclick();
        getOkhttp(company, year);
        listView_onclick();
    }

    private void listView_onclick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mydialog = new Mydialog_subcontract(Iformation_subcontracting.this, R.style.MyDialog);
                for (int i = 0; i < data.size(); i++) {
                     /*EditText_engineerprogram_production,Editext_pijianhao,Edit_investment_money,Edit_orginal_pijianhao,Edit_production_engineerTime,
            Edit_production_contractNum,Edit_production_startday,Edit_production_endday,Edit_production_signDate,Edit_production_performance;
*/
                    if (i == position) {
                        mydialog.setPid(data.get(i).getPid().toString());
                        mydialog.setEdit_saoss_str(data.get(i).getSAOSS());
                        mydialog.setEditText_engineerprogram_production_str(data.get(i).getEngineerName());
                        mydialog.setEditext_pijianhao_str(data.get(i).getNumOfItem());
                        mydialog.setEdit_egineertime_str(data.get(i).getEngineerTime().toString());
                        mydialog.setEdit_wbs_str(data.get(i).getWbs());
                        mydialog.setEdit_subcontractNo_str(data.get(i).getSubcontractNo());
                        mydialog.setEdit_subcontractor_str(data.get(i).getSubcontractor());
                        mydialog.setEdit_subcontractContent_str(data.get(i).getSubcontractContent());
                        mydialog.setEdit_subcontractingType_str(data.get(i).getSubcontractingType());

                        mydialog.setEdit_startDate_str(data.get(i).getStartDate());
                        mydialog.setEdit_endDate_str(data.get(i).getEndDate());
                        mydialog.setEdit_contractMoney_str(data.get(i).getContractMoney().toString());
                        mydialog.setEdit_performance_str(data.get(i).getPerformance());
                        mydialog.setEdit_erpservicePurchaseOrderNumber_str(data.get(i).getERPServicePurchaseOrderNumber());
                        mydialog.setEdit_app_str(data.get(i).getAPP().toString());
                        mydialog.setEdit_aabss_str(data.get(i).getAABSS().toString());
                    }
                }

                mydialog.setYesOnclickListener("修改", new Mydialog_subcontract.onYesOnclickListener() {
                    @Override
                    public void onyesonclick() {

                        mydialog.SetEditTextENeditable();
                        mydialog.setYesOnclickListener("提交", new Mydialog_subcontract.onYesOnclickListener() {
                            @Override
                            public void onyesonclick() {
                                mydialog.setYesStr("提交");
                                mydialog.dismiss();
                                postOkhttp3();
                            }
                        });
                    }

                });
                mydialog.setNoOnclickListener("取消", new Mydialog_subcontract.onNoOnclickListener() {
                    @Override
                    public void onnoonclick() {
                        mydialog.dismiss();
                    }
                });
                mydialog.show();
            }

            private void postOkhttp3() {
                OkHttpClient ok = new OkHttpClient();
                MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
                RequestBody requestBody = RequestBody.create(mediaType, createJson().toString());
                Request request=new Request.Builder()
                        .url("http://123.56.106.24:8081/subcontract/save")
                        .post(requestBody)
                        .build();
                Call call=ok.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String res=response.body().string();
                        JSONObject jsonObject=JSON.parseObject(res);
                        final  int status = (int) jsonObject.get("status");
                        if(status==1){
                            Toast.makeText(Iformation_subcontracting.this, "修改成功！", Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(Iformation_subcontracting.this, "修改失败！", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }

    private JSONObject createJson() {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("pid",mydialog.getPid());
        jsonObject.put("engineerName",mydialog.getEditText_engineerprogram_production_str());
        jsonObject.put("numOfItem",mydialog.getEditext_pijianhao_str());
        jsonObject.put("engineerTime",mydialog.getEdit_egineertime_str());
        jsonObject.put("wbs",mydialog.getEdit_wbs_str());
        jsonObject.put("subcontractNo",mydialog.getEdit_subcontractNo_str());
        jsonObject.put("subcontractor",mydialog.getEdit_subcontractor_str());
        jsonObject.put("subcontractContent",mydialog.getEdit_subcontractContent_str());
        jsonObject.put("subcontractingType",mydialog.getEdit_subcontractContent_str());
        jsonObject.put("startDate",mydialog.getEdit_startDate_str());
        jsonObject.put("endDate",mydialog.getEdit_endDate_str());
        jsonObject.put("contractMoney",mydialog.getEdit_contractMoney_str());
        jsonObject.put("performance",mydialog.getEdit_performance_str());
        jsonObject.put("app",mydialog.getEdit_app_str());
        jsonObject.put("aabss",mydialog.getEdit_aabss_str());
        jsonObject.put("saoss",mydialog.getEdit_saoss_str());
        jsonObject.put("erpservicePurchaseOrderNumber", mydialog.getEdit_erpservicePurchaseOrderNumber_str());
        JSONObject jsonObject1=JSON.parseObject(jsonObject.toString());
        return jsonObject1;
    }

    private void btn_onclick() {
        btn_to_submit= (Button) findViewById(R.id.btn_to_submit);
        btn_to_cancel= (Button) findViewById(R.id.btn_to_cancel);

        btn_to_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_the_project_company_str=Edit_the_project_company.getText().toString().equals("")?"全部":Edit_the_project_company.getText().toString();
                Edit_company_year_processing_str=Edit_company_year_processing.getText().toString().equals("")?"0":Edit_company_year_processing.getText().toString();

                int year=Integer.parseInt(Edit_company_year_processing_str);
                getOkhttp(Edit_the_project_company_str,year);

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

    private void getOkhttp(String companyname,int year) {
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/subcontract/get?engineertime="+year+"&workunit="+companyname)
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
                    JSONObject j = (JSONObject) jsonArray.get(i);

                    Integer pid = (Integer) j.get("pid");
                    System.out.println(pid);
                    String engeenirName = j.getString("engineerName");
                    String workUnit = j.getString("workUnit");
                    String numOfItem = j.getString("numOfItem");
                    String wbs = j.getString("wbs");
                    String subcontractNo = j.getString("subcontractNo");
                    String subcontractor = j.getString("subcontractor");
                    String subcontractContent = j.getString("subcontractContent");
                    String subcontractingType = j.getString("subcontractingType");
                    String signDate = j.getString("signDate");
                    Integer engineerTime= (Integer) j.get("engineerTime");
                    String startDate = j.getString("startDate");
                    String endDate = j.getString("endDate");
                    BigDecimal contractMoney = (BigDecimal) j.get("contractMoney");
                    BigDecimal app = (BigDecimal) j.get("app");
                    BigDecimal aabss = (BigDecimal) j.get("aabss");
                    String performance = j.getString("performance");
                    String erpservicePurchaseOrderNumber = j.getString("erpservicePurchaseOrderNumber");
                    String saoss = j.getString("saoss");

                    showResult(pid,engineerTime, engeenirName, workUnit, numOfItem, wbs, subcontractNo, subcontractor, subcontractContent, subcontractingType, signDate, startDate,endDate, contractMoney, app, aabss, performance, erpservicePurchaseOrderNumber, saoss);
                }

            }
        });
    }

    private void showResult(final Integer pid, final Integer engineerTime, final String engeenirName, final String workUnit, final String numOfItem,
                            final String wbs, final String subcontractNo, final String subcontractor, final String subcontractContent,
                            final String subcontractingType, final String signDate, final String startDate,
                            final String endDate, final BigDecimal contractMoney, final BigDecimal app, final BigDecimal aabss,
                            final String performance, final String erpservicePurchaseOrderNumber, final String saoss) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                SubcontractInfo subcontract=new SubcontractInfo();
                subcontract.setPid(pid);
                subcontract.setEngineerName(engeenirName);
                subcontract.setWorkUnit(workUnit);
                subcontract.setNumOfItem(numOfItem);
                subcontract.setWbs(wbs);
                subcontract.setSubcontractNo(subcontractNo);
                subcontract.setSubcontractor(subcontractor);
                subcontract.setSubcontractContent(subcontractContent);
                subcontract.setSubcontractingType(subcontractingType);
                subcontract.setSignDate(signDate);
                subcontract.setStartDate(startDate);
                subcontract.setEndDate(endDate);
                subcontract.setContractMoney(contractMoney);
                subcontract.setEngineerTime(engineerTime);
                subcontract.setAPP(app);
                subcontract.setAABSS(aabss);
                subcontract.setPerformance(performance);
                subcontract.setERPServicePurchaseOrderNumber(erpservicePurchaseOrderNumber);
                subcontract.setSAOSS(saoss);
                data.add(subcontract);
                listView.setAdapter(new Myadapter());
            }
        });


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater=new MenuInflater(Iformation_subcontracting.this);
        menuInflater.inflate(R.menu.context_menu,menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final AdapterView.AdapterContextMenuInfo adapterContextMenuInfo= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.context_menu_delete:
                OkHttpClient okHttpClient=new OkHttpClient();
                Request request=new Request.Builder()
                        .url("http://123.56.106.24:8081/subcontract/delete/"+data.get(adapterContextMenuInfo.position).getPid())
                        .get()
                        .build();
                Call call= okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        data.remove(adapterContextMenuInfo.position);
                        String result = response.body().string();
                        JSONObject res = JSON.parseObject(result);
                        final int status = (int) res.get("status");
                        System.out.println(status);
                        runOnUiThread(new Runnable() {
                            @Override
                            /**
                             * 实时更新，数据库信息改变时，客户端内容发生改变
                             */
                            public void run() {
                                if (status == 1) {
                                    listView.setAdapter(new Myadapter());
                                    Toast.makeText(Iformation_subcontracting.this, "删除成功！", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Iformation_subcontracting.this, "删除失败！", Toast.LENGTH_SHORT).show();
                                }
                            }

                        });
                    }
                });
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
            View view =View.inflate(Iformation_subcontracting.this,R.layout.layout_listview_items,null);
            TextView tvTime = (TextView) view.findViewById(R.id.TV_listTitle_Id);
            TextView tvTitle = (TextView) view.findViewById(R.id.TV_listTime_Id);
            TextView tvContext = (TextView) view.findViewById(R.id.TV_listContext_Id);
            String name = data.get(position).getEngineerName();
            if(name.length() > 12) {
                name = name.substring(0,12) + "...";
            }
            tvTitle.setText(name);

            tvTime.setText(data.get(position).getPid()+"");
            tvContext.setText(data.get(position).getNumOfItem());
            return view;
        }
    }
}
