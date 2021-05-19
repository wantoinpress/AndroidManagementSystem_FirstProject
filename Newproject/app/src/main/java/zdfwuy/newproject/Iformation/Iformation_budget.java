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
import zdfwuy.newproject.data.BudgetInfo;
import zdfwuy.newproject.dialog.Mydialog_budget;

public class Iformation_budget extends Activity {
    LinearLayout linearLayout;
    ListView listView;
    List<BudgetInfo> data=new ArrayList<>();

    DrawerLayout drawerLayout;
    Mydialog_budget mydialog;
    Button btn_to_submit,btn_to_cancel;
    EditText Edit_company_year_processing,Edit_the_project_company;
    String Edit_company_year_processing_str,Edit_the_project_company_str;
    String companyname="全部";
    int year=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iformation_budget);
        Edit_company_year_processing= (EditText) findViewById(R.id.Edit_company_year_processing);
        Edit_the_project_company= (EditText) findViewById(R.id.Edit_the_project_company);
        listView= (ListView) findViewById(R.id.Listview_choose_Iformation_budget);
        drawerLayout= (DrawerLayout) findViewById(R.id.dlShow);
        registerForContextMenu(listView);
        getOkhttp3(companyname, year);

        btn_setOnclick();

        listView_setonclick();

    }

    private void listView_setonclick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mydialog = new Mydialog_budget(Iformation_budget.this, R.style.MyDialog);
                for (int i = 0; i < data.size(); i++) {
                     /*EditText_engineerprogram_production,Editext_pijianhao,Edit_investment_money,Edit_orginal_pijianhao,Edit_production_engineerTime,
            Edit_production_contractNum,Edit_production_startday,Edit_production_endday,Edit_production_signDate,Edit_production_performance;
*/
                    if (i == position) {
                        mydialog.setPid(data.get(i).getPid().toString());
                        mydialog.setEditText_engineerprogram_production_str(data.get(i).getEngineerName());
                        mydialog.setEditext_pijianhao_str(data.get(i).getNumOfItem());
                        mydialog.setEdit_budgetMoney_money_str(data.get(i).getBudgetMoney().toString());
                        mydialog.setEdit_laborCost_str(data.get(i).getLaborCost().toString());
                        mydialog.setEdit_consumptioncost_str(data.get(i).getConsumptionCost().toString());
                        mydialog.setEdit_mechanicsCost_str(data.get(i).getMechanicsCost().toString());
                        mydialog.setEdit_takeCost_str(data.get(i).getTakeCost().toString());
                        mydialog.setEdit_finalBudget_str(data.get(i).getFinalBudget().toString());
                        mydialog.setEdit_bmaterialCost_str(data.get(i).getBMaterialCost().toString());
                        mydialog.setEdit_amaterialCost_str(data.get(i).getAMaterialCost().toString());
                    }
                }
                mydialog.setYesOnclickListener("修改", new Mydialog_budget.onYesOnclickListener() {
                    @Override
                    public void yesonclick() {
                        mydialog.SetEditTextENeditable();
                        mydialog.setYesOnclickListener("提交", new Mydialog_budget.onYesOnclickListener() {
                            @Override
                            public void yesonclick() {
                                mydialog.setYesStr("提交");
                                mydialog.dismiss();
                                postOkhttp3();
                            }
                        });
                    }


                });
                mydialog.setNoOnclickListener("取消", new Mydialog_budget.onNoOnclickListener() {
                    @Override
                    public void noonclick() {
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
        RequestBody request=RequestBody.create(media, createjson().toString());
        Request request1=new Request.Builder()
                .url("http://123.56.106.24:8081/budget/save")
                .post(request)
                .build();
        Call call=okhhtp3.newCall(request1);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res=response.body().string();
                JSONObject jsonObject=JSON.parseObject(res);
                final int status = (int) jsonObject.get("status");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(status==1){
                            Toast.makeText(Iformation_budget.this, "修改成功！", Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(Iformation_budget.this, "修改失败！", Toast.LENGTH_SHORT).show();

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
        jsonObject.put("engineerName",mydialog.getEditText_engineerprogram_production_str());
        jsonObject.put("numOfItem",mydialog.getEditext_pijianhao_str());
        jsonObject.put("budgetMoney",mydialog.getEdit_budgetMoney_money_str());
        jsonObject.put("laborCost",mydialog.getEdit_laborCost_str());
        jsonObject.put("consumptionCost",mydialog.getEdit_consumptioncost_str());
        jsonObject.put("mechanicsCost",mydialog.getEdit_mechanicsCost_str());
        jsonObject.put("takeCost",mydialog.getEdit_takeCost_str());
        jsonObject.put("finalBudget",mydialog.getEdit_finalBudget_str());

        jsonObject.put("bmaterialCost",mydialog.getEdit_bmaterialCost_str());
        jsonObject.put("amaterialCost", mydialog.getEdit_amaterialCost_str());
        JSONObject jsonObject1=JSON.parseObject(jsonObject.toString());
        return  jsonObject1;

    }

    private void btn_setOnclick() {

            btn_to_submit= (Button) findViewById(R.id.btn_to_submit);
            btn_to_cancel= (Button) findViewById(R.id.btn_to_cancel);

            btn_to_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Edit_the_project_company_str=Edit_the_project_company.getText().toString().equals("")?"全部":Edit_the_project_company.getText().toString();
                    Edit_company_year_processing_str=Edit_company_year_processing.getText().toString().equals("")?"0":Edit_company_year_processing.getText().toString();

                    int year=Integer.parseInt(Edit_company_year_processing_str);
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
                .url("http://123.56.106.24:8081/budget/get?engineertime="+year+"&workunit="+companyname)
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
                JSONArray jsonObject = JSON.parseArray(res);
                System.out.println(jsonObject.toString());
                for (int i = 0; i < jsonObject.size(); i++) {
                    JSONObject j = (JSONObject) jsonObject.get(i);
                    System.out.println(j.get("pid"));
                    Integer pid = (Integer) j.get("pid");
                    String engeenirName = j.getString("engineerName");
                    System.out.println("++++++++" + engeenirName);
                    String constructionUnit = j.getString("constructionUnit");
                    String numOfItem = j.getString("numOfItem");
                    String workUnit = j.getString("workUnit");
                    Integer engineerTime = (Integer) j.get("engineerTime");
                    BigDecimal budgetMoney = (BigDecimal) j.get("budgetMoney");
                    BigDecimal laborCost = (BigDecimal) j.get("laborCost");
                    BigDecimal consumptionCost = (BigDecimal) j.get("consumptionCost");
                    BigDecimal mechanicsCost = (BigDecimal) j.get("mechanicsCost");
                    BigDecimal takeCost = (BigDecimal) j.get("takeCost");
                    BigDecimal finalBudget = (BigDecimal) j.get("finalBudget");
                    BigDecimal bmaterialCost = (BigDecimal) j.get("bmaterialCost");
                    BigDecimal amaterialCost = (BigDecimal) j.get("amaterialCost");

                    ShowRequetResult(pid, engeenirName, constructionUnit, numOfItem, workUnit, engineerTime, budgetMoney, laborCost, consumptionCost, mechanicsCost, takeCost, finalBudget, bmaterialCost, amaterialCost);
                }
            }
        });
    }

    private void ShowRequetResult(final Integer pid, final String engeenirName, final String constructionUnit,
                                  final String numOfItem, final String workUnit, final Integer engineerTime, final BigDecimal budgetMoney,
                                  final BigDecimal laborCost, final BigDecimal consumptionCost, final BigDecimal mechanicsCost,
                                  final BigDecimal takeCost, final BigDecimal finalBudget, final BigDecimal bmaterialCost,
                                  final BigDecimal amaterialCost) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                System.out.println("***********");
                BudgetInfo budgetinfo=new BudgetInfo();
                budgetinfo.setPid(pid);
                budgetinfo.setEngineerName(engeenirName);
                budgetinfo.setConstructionUnit(constructionUnit);
                budgetinfo.setNumOfItem(numOfItem);
                budgetinfo.setWorkUnit(workUnit);
                budgetinfo.setEngineerTime(engineerTime);
                budgetinfo.setBudgetMoney(budgetMoney);
                budgetinfo.setLaborCost(laborCost);
                budgetinfo.setConsumptionCost(consumptionCost);
                budgetinfo.setMechanicsCost(mechanicsCost);
                budgetinfo.setTakeCost(takeCost);
                budgetinfo.setFinalBudget(finalBudget);
                budgetinfo.setBMaterialCost(bmaterialCost);
                budgetinfo.setAMaterialCost(amaterialCost);
                data.add(budgetinfo);
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
            case  R.id.context_menu_delete:
                OkHttpClient okHttpClient=new OkHttpClient();
                final Request request=new Request.Builder()
                        .url("http://123.56.106.24:8081/budget/delete/"+data.get(adapterContextMenuInfo.position).getPid())
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
                                    Toast.makeText(Iformation_budget.this, "删除成功！", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Iformation_budget.this, "删除失败！", Toast.LENGTH_SHORT).show();
                                }
                            }

                        });
                    }
                });
        }
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                System.out.println("打开optionItem");
                Intent intent=new Intent(Iformation_budget.this,Iformation_budget_add.class);
                startActivity(intent);
                break;
            case R.id.Search_one:
                drawerLayout.openDrawer(Gravity.END);
                break;
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
            View view = View.inflate(Iformation_budget.this, R.layout.layout_listview_items, null);
            TextView tv_id = (TextView) view.findViewById(R.id.TV_listTitle_Id);
            TextView tv_title = (TextView) view.findViewById(R.id.TV_listTime_Id);
            TextView tvContext = (TextView) view.findViewById(R.id.TV_listContext_Id);

            tv_id.setText(data.get(position).getPid() + "");
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
