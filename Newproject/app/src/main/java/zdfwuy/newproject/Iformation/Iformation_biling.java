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
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import zdfwuy.newproject.R;
import zdfwuy.newproject.data.SettlementInfo;
import zdfwuy.newproject.dialog.Mydialog_budget;

public class Iformation_biling extends Activity {
    LinearLayout linearLayout;
    ListView listView;
    List<SettlementInfo> data=new ArrayList<>();


    DrawerLayout drawerLayout;
    Mydialog_budget mydialog;
    Button btn_to_submit,btn_to_cancel;
    EditText Edit_company_year_processing,Edit_the_project_company;
    String Edit_company_year_processing_str,Edit_the_project_company_str;
    String companyname="全部";
    int year=0;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                Intent intent=new Intent(Iformation_biling.this,Iformation_budget_add.class);
                startActivity(intent);
                break;
            case R.id.Search_one:
                drawerLayout.openDrawer(Gravity.END);
                break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iformation_biling);
        drawerLayout= (DrawerLayout) findViewById(R.id.dlShow);
        listView= (ListView) findViewById(R.id.Listview_choose_Iformation_biling);
        Edit_company_year_processing= (EditText) findViewById(R.id.Edit_company_year_processing);
        Edit_the_project_company= (EditText) findViewById(R.id.Edit_the_project_company);


        registerForContextMenu(listView);
        //获取查询数据
        getOkhttp3(companyname,year);

        btn_setOnclick();

    }

    private void btn_setOnclick() {

        btn_to_submit= (Button) findViewById(R.id.btn_to_submit);
        btn_to_cancel= (Button) findViewById(R.id.btn_to_cancel);

        btn_to_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_the_project_company_str = Edit_the_project_company.getText().toString().equals("")?"全部":Edit_the_project_company.getText().toString();
                Edit_company_year_processing_str = Edit_company_year_processing.getText().toString().equals("")?"0":Edit_company_year_processing.getText().toString();
                int year = Integer.parseInt(Edit_company_year_processing_str);
                getOkhttp3(Edit_the_project_company_str, year);

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

    private void getOkhttp3(String companyname,int year) {
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/settlement/get?engineertime="+year+"&workunit="+companyname)
                .get()
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Iformation_biling.this, "查询失败(11)", Toast.LENGTH_SHORT).show();
                    }
                });
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
                    Integer engineerTime = (Integer) j.get("engineerTime");
                    String engeenirName = j.getString("engineerName");
                    String constructionUnit = j.getString("constructionUnit");
                    String workUnit = j.getString("workUnit");
                    String numOfItem = j.getString("numOfItem");
                    String account = j.getString("account");
                    BigDecimal settlementPreparationAmount = (BigDecimal) j.get("settlementPreparationAmount");
                    String notReportedReview = j.getString("notReportedReview");
                    String reportConstructionUnit = j.getString("reportConstructionUnit");
                    String reportBudgetDepartment = j.getString("reportBudgetDepartment");
                    String reportAudit = j.getString("reportAudit");
                    String pendingAccountAfterAudit = j.getString("pendingAccountAfterAudit");
                    BigDecimal postAuditAmount = (BigDecimal) j.get("postAuditAmount");
                    BigDecimal invoiceAmount = (BigDecimal) j.get("invoiceAmount");

                    showresult(pid, engineerTime, engeenirName, constructionUnit, workUnit, numOfItem, account, settlementPreparationAmount, notReportedReview, reportConstructionUnit, reportBudgetDepartment, reportAudit, pendingAccountAfterAudit, postAuditAmount, invoiceAmount);

                }
            }
        });
    }

    private void showresult(final Integer pid, final Integer engineerTime, final String engeenirName, final String constructionUnit,
                            final String workUnit, final String numOfItem, final String account, final BigDecimal settlementPreparationAmount,
                            final String notReportedReview, final String reportConstructionUnit, final String reportBudgetDepartment, String reportAudit,
                            final String pendingAccountAfterAudit, final BigDecimal postAuditAmount, final BigDecimal invoiceAmount) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                SettlementInfo settlementinfo=new SettlementInfo();
                settlementinfo.setPid(pid);
                settlementinfo.setEngineerTime(engineerTime);
                settlementinfo.setEngineerName(engeenirName);
                settlementinfo.setConstructionUnit(constructionUnit);
                settlementinfo.setWorkUnit(workUnit);
                settlementinfo.setNumOfItem(numOfItem);
                settlementinfo.setAccount(account);
                settlementinfo.setSettlementPreparationAmount(settlementPreparationAmount);
                settlementinfo.setNotReportedReview(notReportedReview);
                settlementinfo.setReportConstructionUnit(reportConstructionUnit);
                settlementinfo.setReportBudgetDepartment(reportBudgetDepartment);
                settlementinfo.setPendingAccountAfterAudit(pendingAccountAfterAudit);
                settlementinfo.setPostAuditAmount(postAuditAmount);
                settlementinfo.setInvoiceAmount(invoiceAmount);
                data.add(settlementinfo);
                listView.setAdapter(new Myadapter());
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater=new MenuInflater(Iformation_biling.this);
        menuInflater.inflate(R.menu.context_menu,menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final AdapterView.AdapterContextMenuInfo adapterContextMenuInfo= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.context_menu_delete:
                OkHttpClient okHttpClient=new OkHttpClient();
                Request request=new Request.Builder()
                        .url("http://123.56.106.24:8081/settlement/delete/"+data.get(adapterContextMenuInfo.position).getPid())
                        .get()
                        .build();

                Call call=okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        data.remove(adapterContextMenuInfo.position);

                        String result=response.body().string();
                        JSONObject res= JSON.parseObject(result);
                        final int status=(int)res.get("status");
                        System.out.println(status);
                        runOnUiThread(new Runnable() {
                            @Override
                           /* *//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**
                             * 实时更新，数据库信息改变时，客户端内容发生改变
                             *//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**/
                            public void run() {
                                if (status==1){
                                    listView.setAdapter(new Myadapter());
                                    Toast.makeText(Iformation_biling.this, "删除成功！", Toast.LENGTH_SHORT).show();

                                }else {
                                    Toast.makeText(Iformation_biling.this, "删除失败！", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
                    }
                });
                break;
            default:break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
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
            View view=View.inflate(Iformation_biling.this,R.layout.layout_listview_items,null);

            TextView tv_title= (TextView) view.findViewById(R.id.TV_listTitle_Id);
            TextView tv_content= (TextView) view.findViewById(R.id.TV_listTime_Id);
            TextView tv_final= (TextView) view.findViewById(R.id.TV_listContext_Id);

            tv_title.setText(data.get(position).getPid()+"");
            String name = data.get(position).getEngineerName();
            if(name.length() > 12) {
                name = name.substring(0,12) + "...";
            }
            tv_content.setText(name);
            tv_final.setText(data.get(position).getNumOfItem());

            return view;
        }
    }
}
