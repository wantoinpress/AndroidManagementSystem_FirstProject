package zdfwuy.newproject.Iformation;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.ContextMenu;
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
import zdfwuy.newproject.data.CostInfo;
import zdfwuy.newproject.dialog.Mydialog_cost;

public class Iformation_costing extends Activity {
    LinearLayout linearLayout;
    ListView listView;
    List<CostInfo> data=new ArrayList<>();
    ContractInfo contractinfo;
    DrawerLayout drawerLayout;

    Mydialog_cost mydialog;
    Button btn_to_submit,btn_to_cancel;
    EditText Edit_company_year_processing,Edit_the_project_company;
    String Edit_company_year_processing_str,Edit_the_project_company_str;
    String workunit="全部";
    int year=0;
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater=new MenuInflater(Iformation_costing.this);
        menuInflater.inflate(R.menu.context_menu, menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.context_menu_delete:
                OkHttpClient okHttpClient=new OkHttpClient();
                Request request=new Request.Builder()
                        .url("http://123.56.106.24:8081/cost/delete/"+data.get(adapterContextMenuInfo.position).getPid())
                        .get()
                        .build();
                Call call=okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String res=response.body().string();
                        JSONObject jsonObject= JSON.parseObject(res);
                        final int status= (int) jsonObject.get("status");
                        System.out.println(status);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(status==1){
                                    Toast.makeText(Iformation_costing.this, "删除成功！", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(Iformation_costing.this, "删除失败！", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iformation_costing);
        drawerLayout = (DrawerLayout) findViewById(R.id.dlShow);
        geok_http(workunit);
        listView= (ListView) findViewById(R.id.Listview_choose_Iformation_contract);
        Edit_the_project_company = (EditText) findViewById(R.id.Edit_the_project_company);
        registerForContextMenu(listView);
        ListViewOnclick();
        Btn_setonclick();

    }

    private void Btn_setonclick() {
        btn_to_submit= (Button) findViewById(R.id.btn_to_submit);
        btn_to_cancel= (Button) findViewById(R.id.btn_to_cancel);

        btn_to_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_the_project_company_str = Edit_the_project_company.getText().toString().equals("")?"全部":Edit_the_project_company.getText().toString();
                geok_http(Edit_the_project_company_str);
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

    private void ListViewOnclick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mydialog = new Mydialog_cost(Iformation_costing.this, R.style.MyDialog);

                for (int i = 0; i < data.size(); i++) {
                     /*EditText_engineerprogram_production,Editext_pijianhao,Edit_investment_money,Edit_orginal_pijianhao,Edit_production_engineerTime,
            Edit_production_contractNum,Edit_production_startday,Edit_production_endday,Edit_production_signDate,Edit_production_performance;
*/
                    if (i == position) {
                        mydialog.setPid(data.get(i).getPid().toString());
                        mydialog.setEditext_engineerName_str(data.get(i).getEngineerName());
                        mydialog.setEdit_numOfItem_str(data.get(i).getNumOfItem());

                        mydialog.setEdit_engineerIncome_str(data.get(i).getEngineerIncome());
                        mydialog.setEdit_settlementPreparationAmount_str(data.get(i).getCostTotal());
//                        mydialog.setEdit_notReportedReview_str(data.get(i).getAnsanAntiCorrosionAndPrefabrication().toString());
                        mydialog.setEdit_reportConstructionUnit_str(data.get(i).getAntiCorrosionService().toString());
                        mydialog.setEdit_reportBudgetDepartment_str(data.get(i).getAnticorrosionTeamCost().toString());
                        mydialog.setEdit_reportAudit_str(data.get(i).getEngineerIncome().toString());
                        mydialog.setEdit_pendingAccountAfterAudit_str(data.get(i).getEngineerIncome().toString());
                    }
                }
                mydialog.setYesOnclickListener("修改", new Mydialog_cost.onYesOnclickListener() {
                    @Override
                    public void onYesOnclick() {
                        mydialog.SetEditTextENeditable();
                        mydialog.setYesOnclickListener("提交", new Mydialog_cost.onYesOnclickListener() {
                            @Override
                            public void onYesOnclick() {

                                mydialog.dismiss();
                                postOkhttp3();
                            }
                        });
                    }
                });
                mydialog.setNoOnclickListener("取消", new Mydialog_cost.onNoOnclickListener() {
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
                        .url("http://123.56.106.24:8081/cost/save")
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
                                    Toast.makeText(Iformation_costing.this, "修改成功！", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(Iformation_costing.this, "修改失败！", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                    }
                });
            }

            private JSONObject creatjson() {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("pid", mydialog.getPid());
                jsonObject.put("engineerName", mydialog.getEditext_engineerName_str());
                jsonObject.put("numOfItem", mydialog.getEdit_numOfItem_str());
                jsonObject.put("workUnit", mydialog.getEdit_reportConstructionUnit_str());
                jsonObject.put("engineerIncome", mydialog.getEdit_engineerIncome_str());
                jsonObject.put("transpotCost", mydialog.getEdit_reportAudit_str());
                jsonObject.put("fuelCost", mydialog.getEdit_reportBudgetDepartment_str());
                jsonObject.put("laborSubcontracting", mydialog.getEdit_notReportedReview_str());
                jsonObject.put("earthworkServices", mydialog.getEdit_reportAudit_str());
                jsonObject.put("antiCorrosionService", mydialog.getEdit_pendingAccountAfterAudit_str());

                JSONObject jsonObject1 = JSONObject.parseObject(jsonObject.toString());
                return jsonObject1;
            }
        });
    }

    private void geok_http(String workunit) {
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/cost/get?workunit="+workunit)
                .get()
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();
                JSONArray jsonArray = JSON.parseArray(res);
                System.out.println(jsonArray.toString());
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject j = (JSONObject) jsonArray.get(i);

                    Integer pid = (Integer) j.get("pid");
                    String engeenirName = j.getString("engineerName");
                    String workUnit = j.getString("workUnit");
                    BigDecimal engineerIncome = (BigDecimal) j.get("engineerIncome");
                    String CostTotal = j.getString("CostTotal");
                    String numOfItem = j.getString("numOfItem");
                    String BMaterial = j.getString("BMaterial");
                    BigDecimal transpotCost = (BigDecimal) j.get("transpotCost");
                    BigDecimal fuelCost = (BigDecimal) j.get("fuelCost");
                    BigDecimal laborSubcontracting = (BigDecimal) j.get("laborSubcontracting");
                    BigDecimal earthworkServices = (BigDecimal) j.get("earthworkServices");
                    BigDecimal antiCorrosionService = (BigDecimal) j.get("antiCorrosionService");
                    BigDecimal localEarthwork = (BigDecimal) j.get("localEarthwork");
                    BigDecimal mechanicServices = (BigDecimal) j.get("mechanicServices");
                    BigDecimal professionalSubcontracting = (BigDecimal) j.get("professionalSubcontracting");
                    BigDecimal otherSubcontracting = (BigDecimal) j.get("otherSubcontracting");
                    BigDecimal anticorrosionTeamCost = (BigDecimal) j.get("anticorrosionTeamCost");
                    BigDecimal MetalWorkshopCost = (BigDecimal) j.get("MetalWorkshopCost");
                    BigDecimal AnsanAntiCorrosionAndPrefabrication = (BigDecimal) j.get("AnsanAntiCorrosionAndPrefabrication");
                    BigDecimal municipalAdministration = (BigDecimal) j.get("municipalAdministration");
                    BigDecimal other = (BigDecimal) j.get("other");
                    BigDecimal CostAdjustment = (BigDecimal) j.get("CostAdjustment");
                    BigDecimal marginalProfit = (BigDecimal) j.get("marginalProfit");
                    BigDecimal marginalProfitRate = (BigDecimal) j.get("marginalProfitRate");
                    String fillingDate = j.getString("fillingDate");

                    showresultinfo(pid, engeenirName, workUnit, engineerIncome, CostTotal, numOfItem, BMaterial, transpotCost, fuelCost, laborSubcontracting, earthworkServices, antiCorrosionService, localEarthwork, mechanicServices, professionalSubcontracting, otherSubcontracting, anticorrosionTeamCost, MetalWorkshopCost, AnsanAntiCorrosionAndPrefabrication, municipalAdministration, other, CostAdjustment, marginalProfit, marginalProfitRate, fillingDate);
                }
            }
        });
    }

    private void showresultinfo(final Integer pid, final String engeenirName, final String workUnit, final BigDecimal engineerIncome,
                                final String costTotal, final String numOfItem, final String bMaterial, final BigDecimal transpotCost,
                                final BigDecimal fuelCost, final BigDecimal laborSubcontracting, final BigDecimal earthworkServices,
                                final BigDecimal antiCorrosionService, final BigDecimal localEarthwork, final BigDecimal mechanicServices, final BigDecimal professionalSubcontracting,
                                final BigDecimal otherSubcontracting, final BigDecimal anticorrosionTeamCost, final BigDecimal metalWorkshopCost, final BigDecimal ansanAntiCorrosionAndPrefabrication,
                                final BigDecimal municipalAdministration, final BigDecimal other,
                                final BigDecimal costAdjustment, final BigDecimal marginalProfit,
                                final BigDecimal marginalProfitRate, final String fillingDate) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                CostInfo costinfo=new CostInfo();
                costinfo.setPid(pid);
                costinfo.setEngineerName(engeenirName);
                costinfo.setWorkUnit(workUnit);
                costinfo.setEngineerIncome(engineerIncome);
                costinfo.setCostTotal(costTotal);
                costinfo.setNumOfItem(numOfItem);
                costinfo.setBMaterial(bMaterial);
                costinfo.setTranspotCost(transpotCost);
                costinfo.setFuelCost(fuelCost);
                costinfo.setLaborSubcontracting(laborSubcontracting);
                costinfo.setEarthworkServices(earthworkServices);
                costinfo.setAntiCorrosionService(antiCorrosionService);
                costinfo.setLocalEarthwork(localEarthwork);
                costinfo.setMechanicServices(mechanicServices);
                costinfo.setOtherSubcontracting(otherSubcontracting);
                costinfo.setAnticorrosionTeamCost(anticorrosionTeamCost);
                costinfo.setMunicipalAdministration(municipalAdministration);
                costinfo.setOther(other);
                costinfo.setCostAdjustment(costAdjustment);
                costinfo.setMarginalProfit(marginalProfit);
                costinfo.setMarginalProfitRate(marginalProfitRate);
                costinfo.setFillingDate(fillingDate);
                costinfo.setMetalWorkshopCost(metalWorkshopCost);
                costinfo.setProfessionalSubcontracting(professionalSubcontracting);
                costinfo.setAnsanAntiCorrosionAndPrefabrication(ansanAntiCorrosionAndPrefabrication);

                data.add(costinfo);
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
            View view = View.inflate(Iformation_costing.this, R.layout.layout_listview_items, null);
            TextView tvTitle = (TextView) view.findViewById(R.id.TV_listTitle_Id);
            TextView tvTime = (TextView) view.findViewById(R.id.TV_listTime_Id);
            TextView tvContext = (TextView) view.findViewById(R.id.TV_listContext_Id);

            String name = data.get(position).getEngineerName();
            if(name.length() > 12) {
                name = name.substring(0,12) + "...";
            }
            tvTime.setText(name);
            tvTitle.setText(data.get(position).getEngineerName());
            tvContext.setText(data.get(position).getNumOfItem());
            return view;
        }
    }
}
