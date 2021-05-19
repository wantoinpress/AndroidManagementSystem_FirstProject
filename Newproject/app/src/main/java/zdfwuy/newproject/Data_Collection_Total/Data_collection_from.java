package zdfwuy.newproject.Data_Collection_Total;

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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import zdfwuy.newproject.R;
import zdfwuy.newproject.data_collection.DatacollectionInfo;
import zdfwuy.newproject.data_collection.NewCloectionInfo;
import zdfwuy.newproject.data_collection.SerialMap1;
import zdfwuy.newproject.dialog.Mydialog_contract;

public class Data_collection_from extends Activity {
    ListView listView;
    List<NewCloectionInfo> data=new ArrayList<>();
    DatacollectionInfo datacollection;
    DrawerLayout drawerLayout;
    HashMap<String, NewCloectionInfo> map = new HashMap<>();
    Mydialog_contract mydialog;
    Button btn_to_submit,btn_to_cancel;
    EditText Edit_company_year_processing,Edit_the_project_company;
    String Edit_company_year_processing_str,Edit_the_project_company_str;
    String company="全部";
    String isfin="是";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_collection_from);
        listView= (ListView) findViewById(R.id.Listview_choose_Data_collection_from);
        drawerLayout= (DrawerLayout) findViewById(R.id.dlShow);
        Edit_company_year_processing= (EditText) findViewById(R.id.Edit_company_year_processing);
        Edit_the_project_company= (EditText) findViewById(R.id.Edit_the_project_company);
        getOkhttp3(company, isfin);
        /*registerForContextMenu(listView);*/
        listViewsetonclick();
        btn_setOnclick();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_2, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.Search_one:
                drawerLayout.openDrawer(Gravity.END);
                break;
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
                Edit_the_project_company_str = Edit_the_project_company.getText().toString().equals("")?"全部":Edit_the_project_company.getText().toString();
                Edit_company_year_processing_str = Edit_company_year_processing.getText().toString().equals("")?"是":Edit_company_year_processing.getText().toString();


                getOkhttp3(Edit_the_project_company_str, Edit_company_year_processing_str);

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
    private void listViewsetonclick() {
        final SerialMap1 myMap=new SerialMap1();
        myMap.setMap(map);//将map数据添加到封装的myMap中
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Data_collection_from.this,Data_collection_from_onclick.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("map", myMap);
                bundle.putCharSequence("pid", data.get(position).getPid() + "");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void getOkhttp3(String company, String isfin) {
        OkHttpClient okhttp3=new OkHttpClient();
        Request reques=new Request.Builder()
                .url("http://123.56.106.24:8081/summary/get?workunit="+company+"&isfin="+isfin)
                .get()
                .build();
        Call call=okhttp3.newCall(reques);
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
                    NewCloectionInfo newCloectionInfo = new NewCloectionInfo();
                    JSONObject j = (JSONObject) jsonObject.get(i);
                    System.out.println(j.getString("pid"));
                    newCloectionInfo.setPid((Integer) j.get("pid"));
                    newCloectionInfo.setEngineerName(j.getString("engineerName"));
                    newCloectionInfo.setConstructionUnit(j.getString("constructionUnit"));
                    newCloectionInfo.setNumOfItem(j.getString("numOfItem"));
                    newCloectionInfo.setInvestMoney((BigDecimal) j.get("investMoney"));
                    newCloectionInfo.setWorkUnit(j.getString("workUnit"));




//                    Integer pid ;
//    String   engineerName ;
//    String        constructionUnit ;
//    String       numOfItem ;
//    BigDecimal investMoney ;
//    String        workUnit ;
//
                    newCloectionInfo.setIsFin(j.getString("isFin"));
                    newCloectionInfo.setContractNum(j.getString("contractNum"));
                    newCloectionInfo.setContractMoney((BigDecimal) j.get("contractMoney"));
                    newCloectionInfo.setSignDate(j.getString("signDate"));
                    newCloectionInfo.setContractStartDate(j.getString("contractStartDate"));
                    newCloectionInfo.setEndDate(j.getString("contractEndDate"));




//
//    String        isFin ;
//    String       contractNum ;
//    BigDecimal       contractMoney ;
//    String       signDate ;
//    String      contractStartDate ;
//    String       contractEndDate ;

                    newCloectionInfo.setBudgetMoney((BigDecimal) j.get("budgetMoney"));
                    newCloectionInfo.setLaborCost((BigDecimal) j.get("laborCost"));
                    newCloectionInfo.setWorkStartDate(j.getString("workStartDate"));
                    newCloectionInfo.setConsumptionCost((BigDecimal) j.get("consumptionCost"));
                    newCloectionInfo.setMechanicsCost((BigDecimal) j.get("mechanicsCost"));
                    newCloectionInfo.setTakeCost((BigDecimal) j.get("takeCost"));
//    BigDecimal       budgetMoney ;
//    BigDecimal      laborCost ;
//    BigDecimal      consumptionCost ;
//    BigDecimal      mechanicsCost ;
//    BigDecimal      takeCost ;
//    String       workStartDate ;

                    newCloectionInfo.setWorkEndDate(j.getString("workEndDate"));
                    newCloectionInfo.setPlanEndperiod(j.getString("planEndperiod"));
                    newCloectionInfo.setEngineerTotalProcess(j.getString("engineerTotalProcess"));
                    newCloectionInfo.setEngineerMainMessage(j.getString("engineerMainMessage"));
                    newCloectionInfo.setRestProcess(j.getString("restProcess"));
                    newCloectionInfo.setNextWeekPlan(j.getString("nextWeekPlan"));
//    String      workEndDate ;
//    String      planEndperiod ;
//    String       engineerMainMessage  ;
//    String       thisWeekCompleteProcess ;
//    String       engineerTotalProcess ;
//    String       restProcess ;
//    String     nextWeekPlan ;
                    newCloectionInfo.setMonthProduceVal((BigDecimal) j.get("monthProduceVal"));
                    newCloectionInfo.setMonthAMaterial((BigDecimal) j.get("monthAMaterial"));
                    newCloectionInfo.setMonthAdBeforeIncome((BigDecimal) j.get("monthAdBeforeIncome"));
                    newCloectionInfo.setMonthAdBehindIncome((BigDecimal) j.get("monthAdBehindIncome"));
                    newCloectionInfo.setYearProduceVal((BigDecimal) j.get("yearProduceVal"));
                    newCloectionInfo.setYearAMaterial((BigDecimal) j.get("yearAMaterial"));

//    BigDecimal      monthProduceVal ;
//    BigDecimal     monthAMaterial ;
//    BigDecimal        monthAdBeforeIncome ;
//    BigDecimal      monthAdBehindIncome ;
//    BigDecimal       yearProduceVal ;
//    BigDecimal       yearAMaterial ;

                    newCloectionInfo.setYearAdBeforeIncome((BigDecimal) j.get("yearAdBeforeIncome"));
                    newCloectionInfo.setYearAdBeforeIncome((BigDecimal) j.get("yearAdBehindIncome"));
                    newCloectionInfo.setTranspotCost((BigDecimal) j.get("transpotCost"));
                    newCloectionInfo.setFuelCost((BigDecimal) j.get("fuelCost"));
                    newCloectionInfo.setLaborSubcontracting((BigDecimal) j.get("laborSubcontracting"));
                    newCloectionInfo.setEarthworkServices((BigDecimal) j.get("earthworkServices"));
//    BigDecimal      yearAdBeforeIncome ;
//    BigDecimal      yearAdBehindIncome ;
//    BigDecimal       transpotCost ;
//    BigDecimal      fuelCost ;
//    BigDecimal     laborSubcontracting ;
//    BigDecimal        earthworkServices ;
                    newCloectionInfo.setAntiCorrosionService((BigDecimal) j.get("antiCorrosionService"));
                    newCloectionInfo.setLocalEarthwork((BigDecimal) j.get("localEarthwork"));
                    newCloectionInfo.setMechanicServices((BigDecimal) j.get("mechanicServices"));
                    newCloectionInfo.setProfessionalSubcontracting((BigDecimal) j.get("professionalSubcontracting"));
                    newCloectionInfo.setOtherSubcontracting((BigDecimal) j.get("otherSubcontracting"));
                    newCloectionInfo.setAnticorrosionTeamCost((BigDecimal) j.get("anticorrosionTeamCost"));
//    BigDecimal      antiCorrosionService ;
//    BigDecimal       localEarthwork ;
//    BigDecimal       mechanicServices ;
//    BigDecimal      professionalSubcontracting ;
//    BigDecimal       otherSubcontracting ;


//    BigDecimal       anticorrosionTeamCost ;

                    newCloectionInfo.setMunicipalAdministration((BigDecimal) j.get("municipalAdministration"));
                    /*newCloectionInfo.setPid(j.getString("other"));
                    newCloectionInfo.setPid(j.getString("marginalProfit"));
                    newCloectionInfo.setPid(j.getString("marginalProfitRate"));
                    newCloectionInfo.setPid(j.getString("settlementPreparationAmount"));
                    newCloectionInfo.setPid(j.getString("notReportedReview"));*/
//    BigDecimal      municipalAdministration ;
//    BigDecimal      other ;
//    BigDecimal       marginalProfit ;
//    BigDecimal      marginalProfitRate ;
//    String       settlementPreparationAmount ;
//    String       notReportedReview ;


//                    newCloectionInfo.setPid(j.getString("reportConstructionUnit"));
//                    newCloectionInfo.setPid(j.getString("reportBudgetDepartment"));
//                    newCloectionInfo.setPid(j.getString("reportAudit"));
//                    newCloectionInfo.setPid(j.getString("pendingAccountAfterAudit"));
//                    newCloectionInfo.setPid(j.getString("account"));
//                    newCloectionInfo.setPid(j.getString("postAuditAmount"));
//    String       reportConstructionUnit ;
//    String      reportBudgetDepartment ;
//    String      reportAudit ;
//    String      pendingAccountAfterAudit ;
//    String       account ;
//    String      postAuditAmount ;

//                    newCloectionInfo.setPid(j.getString("invoiceAmount"));
//                    newCloectionInfo.setPid(j.getString("subcontractNo"));
//                    newCloectionInfo.setPid(j.getString("subcontractor"));
//                    newCloectionInfo.setPid(j.getString("subcontractContent"));
//                    newCloectionInfo.setPid(j.getString("subcontractingType"));
//                    newCloectionInfo.setPid(j.getString("subcontractSignDate"));
//    String      invoiceAmount ;
//    String     subcontractNo ;
//    String     subcontractor ;
//    String     subcontractContent ;
//    String      subcontractingType ;
//    String      subcontractSignDate ;

//                    newCloectionInfo.setPid(j.getString("startDate"));
//                    newCloectionInfo.setPid(j.getString("endDate"));
//                    newCloectionInfo.setPid(j.getString("subcontractContractMoney"));
//                    newCloectionInfo.setPid(j.getString("performance"));
//                    newCloectionInfo.setPid(j.getString("costTotal"));
//                    newCloectionInfo.setPid(j.getString("bmaterial"));
//    String      startDate ;
//    String     endDate ;
//    BigDecimal      subcontractContractMoney ;
//    String     performance ;
//    String     costTotal ;
//    String     bmaterial ;


//                    newCloectionInfo.setPid(j.getString("metalWorkshopCost"));
//                    newCloectionInfo.setPid(j.getString("ansanAntiCorrosionAndPrefabrication"));
//                    newCloectionInfo.setPid(j.getString("costAdjustment"));
//                    newCloectionInfo.setPid(j.getString("hrequipment"));
//                    newCloectionInfo.setPid(j.getString("app"));
//                    newCloectionInfo.setPid(j.getString("aabss"));
//    BigDecimal       metalWorkshopCost ;
//    BigDecimal        ansanAntiCorrosionAndPrefabrication ;
//    BigDecimal       costAdjustment ;
//    String      hrequipment ;
//    BigDecimal     app ;
//    BigDecimal       aabss ;

//                    newCloectionInfo.setPid(j.getString("saoss"));
//                    newCloectionInfo.setPid(j.getString("erpservicePurchaseOrderNumber"));
//                    newCloectionInfo.setPid(j.getString("amaterialCost"));
//                    newCloectionInfo.setPid(j.getString("bmaterialCost"));

//    String     saoss ;
//    String     erpservicePurchaseOrderNumber ;
//    BigDecimal        amaterialCost ;
//    BigDecimal       bmaterialCost ;

//                    Integer pid = j.getString("pid");
//                    String engeenirName = j.getString("engeenirName");
//                    String constructionUnit = j.getString("constructionUnit");
//                    String numOfItem = j.getString("numOfItem");
//                    String workUnit = j.getString("workUnit");
//                    Integer engineerTime = j.getString("engineerTime");
//                    BigDecimal budgetMoney = (BigDecimal) j.getString("budgetMoney");
//                    BigDecimal laborCost = (BigDecimal) j.getString("laborCost");
//                    BigDecimal consumptionCost = (BigDecimal) j.getString("consumptionCost");
//                    BigDecimal mechanicsCost = (BigDecimal) j.getString("mechanicsCost");
//                    BigDecimal takeCost = (BigDecimal) j.getString("takeCost");
//                    BigDecimal finalBudget = (BigDecimal) j.getString("finalBudget");
//                    BigDecimal bmaterialCost = (BigDecimal) j.getString("bmaterialCost");
//                    BigDecimal amaterialCost = (BigDecimal) j.getString("amaterialCost");
//
//                    /*(pid,engeenirName,constructionUnit,numOfItem,workUnit,engineerTime,budgetMoney,laborCost,
//                    consumptionCost,mechanicsCost,takeCost,finalBudget,bmaterialCost,amaterialCost)*/
//
//
//                    String account = j.getString("account");
//                    BigDecimal settlementPreparationAmount = (BigDecimal) j.getString("settlementPreparationAmount");
//                    String notReportedReview = j.getString("notReportedReview");
//                    String reportConstructionUnit = j.getString("reportConstructionUnit");
//                    String reportBudgetDepartment = j.getString("reportBudgetDepartment");
//                    String reportAudit = j.getString("reportAudit");
//                    String pendingAccountAfterAudit = j.getString("pendingAccountAfterAudit");
//                    BigDecimal postAuditAmount = (BigDecimal) j.getString("postAuditAmount");
//                    BigDecimal invoiceAmount = (BigDecimal) j.getString("invoiceAmount");
//
//                    /*(account,settlementPreparationAmount,notReportedReview,reportConstructionUnit,reportBudgetDepartment,reportAudit,
//                    pendingAccountAfterAudit,postAuditAmount,invoiceAmount)*/
//
//                    BigDecimal contractMoney = (BigDecimal) j.getString("contractMoney");
//                    String contractNum = j.getString("contractNum");
//                    String signDate = j.getString("signDate");
//                    String startDate = j.getString("startDate");
//                    String endDate = j.getString("endDate");
//                    String performance = j.getString("performance");
//
//                    /*(contractMoney,contractNum,signDate,startDate,endDate,performance)*/
//
//
//                    BigDecimal engineerIncome = (BigDecimal) j.getString("engineerIncome");
//                    String CostTotal = j.getString("CostTotal");
//                    String BMaterial = j.getString("BMaterial");
//                    BigDecimal transpotCost = (BigDecimal) j.getString("transpotCost");
//                    BigDecimal fuelCost = (BigDecimal) j.getString("fuelCost");
//                    BigDecimal laborSubcontracting = (BigDecimal) j.getString("laborSubcontracting");
//                    BigDecimal earthworkServices = (BigDecimal) j.getString("earthworkServices");
//                    BigDecimal antiCorrosionService = (BigDecimal) j.getString("antiCorrosionService");
//                    BigDecimal localEarthwork = (BigDecimal) j.getString("localEarthwork");
//                    BigDecimal mechanicServices = (BigDecimal) j.getString("mechanicServices");
//                    BigDecimal professionalSubcontracting = (BigDecimal) j.getString("professionalSubcontracting");
//                    BigDecimal otherSubcontracting = (BigDecimal) j.getString("otherSubcontracting");
//                    BigDecimal anticorrosionTeamCost = (BigDecimal) j.getString("anticorrosionTeamCost");
//                    BigDecimal MetalWorkshopCost = (BigDecimal) j.getString("MetalWorkshopCost");
//                    BigDecimal AnsanAntiCorrosionAndPrefabrication = (BigDecimal) j.getString("AnsanAntiCorrosionAndPrefabrication");
//                    BigDecimal municipalAdministration = (BigDecimal) j.getString("municipalAdministration");
//                    BigDecimal other = (BigDecimal) j.getString("other");
//                    BigDecimal CostAdjustment = (BigDecimal) j.getString("CostAdjustment");
//                    BigDecimal marginalProfit = (BigDecimal) j.getString("marginalProfit");
//                    BigDecimal marginalProfitRate = (BigDecimal) j.getString("marginalProfitRate");
//                    String fillingDate = j.getString("fillingDate");
//
//                    /*(engineerIncome,CostTotal,BMaterial,transpotCost,fuelCost,laborSubcontracting,earthworkServices,antiCorrosionService,
//                    localEarthwork,mechanicServices,professionalSubcontracting,otherSubcontracting,anticorrosionTeamCost,MetalWorkshopCost,
//                    MetalWorkshopCost,AnsanAntiCorrosionAndPrefabrication,municipalAdministration,other,CostAdjustment,marginalProfit,marginalProfitRate,fillingDate)*/
//
//                    String companyType = j.getString("companyType");
//                    String buildCompany = j.getString("buildCompany");
//                    String wbs = j.getString("wbs");
//                    BigDecimal money = (BigDecimal) j.getString("money");
//                    String workCompany = j.getString("workCompany");
//                    Integer workYear = j.getString("workYear");
//                    String isFin = j.getString("isFin");
//                    String originalNum = j.getString("originalNum");
//
//                    /*(companyType,buildCompany,wbs,money,workCompany,workYear,isFin,originalNum)*/
//
//                    String planEndperiod = j.getString("planEndperiod");
//                    String engineerMainMessage = j.getString("engineerMainMessage");
//                    String thisWeekCompleteProcess = j.getString("thisWeekCompleteProcess");
//                    String engineerTotalProcess = j.getString("engineerTotalProcess");
//                    String restProcess = j.getString("restProcess");
//                    String nextWeekPlan = j.getString("nextWeekPlan");
//                    String signPerformence = j.getString("signPerformence");
//                    BigDecimal imageProcess = (BigDecimal) j.getString("imageProcess");
//                    BigDecimal investMoney = (BigDecimal) j.getString("investMoney");
//                    String remarks = j.getString("remarks");
//                    String hrequipment = j.getString("hrequipment");
//
//                    /*(planEndperiod,engineerMainMessage,thisWeekCompleteProcess,engineerTotalProcess,restProcess,
//                    nextWeekPlan,signPerformence,imageProcess,investMoney,remarks,hrequipment)*/
//
//
//                    String measurementUnit = j.getString("measurementUnit");
//                    int amountNum = (int) j.getString("amountNum");
//                    BigDecimal monthProduceVal = (BigDecimal) j.getString("monthProduceVal");
//                    BigDecimal monthAMaterial = (BigDecimal) j.getString("monthAMaterial");
//                    BigDecimal monthAdBeforeIncome = (BigDecimal) j.getString("monthAdBeforeIncome");
//                    BigDecimal monthAdBehindIncome = (BigDecimal) j.getString("monthAdBehindIncome");
//                    BigDecimal yearProduceVal = (BigDecimal) j.getString("yearProduceVal");
//                    BigDecimal yearAMaterial = (BigDecimal) j.getString("yearAMaterial");
//                    BigDecimal yearAdBeforeIncome = (BigDecimal) j.getString("yearAdBeforeIncome");
//                    BigDecimal yearAdBehindIncome = (BigDecimal) j.getString("yearAdBehindIncome");
//                    String currentMonthProcess = j.getString("currentMonthProcess");
//                    String totalProcess = j.getString("totalProcess");
//
//                    /*(measurementUnit,amountNum,monthProduceVal,monthAMaterial,monthAdBeforeIncome,monthAdBehindIncome,
//                    yearProduceVal,yearAMaterial,yearAdBeforeIncome,yearAdBehindIncome,currentMonthProcess,totalProcess)*/
//
//                    String subcontractNo = j.getString("subcontractNo");
//                    String subcontractor = j.getString("subcontractor");
//                    String subcontractContent = j.getString("subcontractContent");
//                    String subcontractingType = j.getString("subcontractingType");
//                    BigDecimal app = (BigDecimal) j.getString("app");
//                    BigDecimal aabss = (BigDecimal) j.getString("aabss");
//                    String erpservicePurchaseOrderNumber = j.getString("erpservicePurchaseOrderNumber");
//                    String saoss = j.getString("saoss");

                    /*(subcontractNo,subcontractor,subcontractContent,subcontractingType,app,aabss,erpservicePurchaseOrderNumber,saoss)*/
                    map.put(newCloectionInfo.getPid()+"", newCloectionInfo);
                    showresult(newCloectionInfo);
                }

            }
        });
    }

    private void showresult(final NewCloectionInfo newCloectionInfo){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                data.add(newCloectionInfo);
                listView.setAdapter(new Mydatapter());
            }
        });

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater=new MenuInflater(Data_collection_from.this);
        menuInflater.inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.context_menu_delete:
                OkHttpClient okHttpClient=new OkHttpClient();
                Request request=new Request.Builder()
                        .url("http://123.56.106.24:8081/cost/delete/"+88)
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
                                    Toast.makeText(Data_collection_from.this, "删除成功！", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(Data_collection_from.this, "删除失败！", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
        }
        return true;

    }

    private class Mydatapter extends BaseAdapter {
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
            View view =View.inflate(Data_collection_from.this,R.layout.layout_listview_items,null);
            TextView tvTitle = (TextView) view.findViewById(R.id.TV_listTitle_Id);
            TextView tvTime = (TextView) view.findViewById(R.id.TV_listTime_Id);
            TextView tvContext = (TextView) view.findViewById(R.id.TV_listContext_Id);
            tvTitle.setText(data.get(position).getPid()+"");
            String name = data.get(position).getEngineerName();
            if(name.length() > 12) {
                name = name.substring(0,12) + "...";
            }
            tvTime.setText(name);
            tvContext.setText(data.get(position).getNumOfItem());
            return view;
        }
    }
}
