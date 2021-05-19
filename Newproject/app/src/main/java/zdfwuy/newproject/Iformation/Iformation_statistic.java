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
import zdfwuy.newproject.data.StatisticInfo;
import zdfwuy.newproject.dialog.Mydialog_statistic;

public class Iformation_statistic extends Activity {

    ListView listView;
    List<StatisticInfo> data=new ArrayList<>();


    DrawerLayout drawerLayout;
    Mydialog_statistic mydialog;
    Button btn_to_submit,btn_to_cancel;
    EditText Edit_company_year_processing,Edit_the_project_company;
    String Edit_company_year_processing_str,Edit_the_project_company_str;
    String company="全部";
    int year=0;
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater=new MenuInflater(Iformation_statistic.this);
        menuInflater.inflate(R.menu.context_menu,menu);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case  R.id.add:
                Intent intent=new Intent(Iformation_statistic.this,Iformation_statistic_add.class);
                startActivity(intent);
                break;
            case  R.id.Search_one:
                drawerLayout.openDrawer(Gravity.END);
                break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case  R.id.context_menu_delete:
                OkHttpClient okHttpClient=new OkHttpClient();
                Request request=new Request.Builder()
                        .url("http://123.56.106.24:8081/statistic/delete/"+data.get(adapterContextMenuInfo.position).getPid())
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
                        final  int status= (int) jsonObject.get("status");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (status==1){
                                    Toast.makeText(Iformation_statistic.this,"删除成功！",Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(Iformation_statistic.this,"删除失败",Toast.LENGTH_SHORT).show();
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
        setContentView(R.layout.activity_iformation_statistic);
        Edit_the_project_company = (EditText) findViewById(R.id.Edit_the_project_company);
        listView= (ListView) findViewById(R.id.Listview_choose_Iformation_statistic);
        drawerLayout= (DrawerLayout) findViewById(R.id.dlShow);
        btn_setOnclick();
        registerForContextMenu(listView);
        onListItemonclick();
        getOkhttp3(company);
    }

    private void onListItemonclick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mydialog = new Mydialog_statistic(Iformation_statistic.this, R.style.MyDialog);
                for (int i = 0; i < data.size(); i++) {
                     /*EditText_engineerprogram_production,Editext_pijianhao,Edit_investment_money,Edit_orginal_pijianhao,Edit_production_engineerTime,
            Edit_production_contractNum,Edit_production_startday,Edit_production_endday,Edit_production_signDate,Edit_production_performance;
*/
                    if (i == position) {
                        mydialog.setPid(data.get(i).getPid().toString());
                        mydialog.setEditText_engineerprogram_production_str(data.get(i).getEngineerName());
                        mydialog.setEditext_pijianhao_str(data.get(i).getNumOfItem());
                        mydialog.setEdit_wbs_str(data.get(i).getWbs());
                        mydialog.setEdit_production_starday_str(data.get(i).getStartDate());
                        mydialog.setEdit_production_endday_str(data.get(i).getEndDate());
//                        mydialog.setEdit_production_num_str(data.get(i).getAmountNum());
                        mydialog.setEdit_production_monthProduceVal_str(data.get(i).getMonthProduceVal().toString());
                        mydialog.setEdit_production_monthAMaterial_str(data.get(i).getMonthAMaterial().toString());
                        mydialog.setEdit_production_monthAdBeforeIncome_str(data.get(i).getMonthAdBeforeIncome().toString());

                        mydialog.setEdit_production_monthAdBehindIncome_str(data.get(i).getMonthAdBehindIncome().toString());
                        mydialog.setEdit_production_yearProduceVal_str(data.get(i).getYearProduceVal().toString());
                        mydialog.setEdit_production_yearAMaterial_str(data.get(i).getYearAMaterial().toString());
                        mydialog.setEdit_production_yearAdBeforeIncome_str(data.get(i).getYearAdBeforeIncome().toString());
                        mydialog.setEdit_production_yearAdBehindIncome_str(data.get(i).getYearAdBehindIncome().toString());
                        mydialog.setEdit_production_currentMonthProcess_str(data.get(i).getCurrentMonthProcess());

                        mydialog.setEdit_production_totalProcess_str(data.get(i).getTotalProcess());
                        mydialog.setEdit_production_fillingDate_str(data.get(i).getFillingDate());

                    }
                }

                mydialog.setYesOnclickListener("修改", new Mydialog_statistic.onYesOnclickListener() {
                    @Override
                    public void onyesonclick() {
                        mydialog.setYesOnclickListener("确定", new Mydialog_statistic.onYesOnclickListener() {
                            @Override
                            public void onyesonclick() {
                                mydialog.setYesStr("提交");
                                mydialog.dismiss();
                                postOkhttp3();
                            }
                        });
                    }
                });

                mydialog.setNoOnclickListener("取消", new Mydialog_statistic.onNoOnclickListener() {
                    @Override
                    public void onnoonclick() {
                        mydialog.dismiss();
                    }
                });
                mydialog.show();
            }
        });
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
                            Toast.makeText(Iformation_statistic.this, "修改成功！", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(Iformation_statistic.this, "修改失败！", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }

    private JSONObject creatjson() {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("engineerName",mydialog.getEditText_engineerprogram_production_str());
        jsonObject.put("numOfItem",mydialog.getEditext_pijianhao_str());
        jsonObject.put("wbs",mydialog.getEdit_wbs_str());

        jsonObject.put("startDate",mydialog.getEdit_production_starday_str());
        jsonObject.put("endDate",mydialog.getEdit_production_endday_str());

        jsonObject.put("monthProduceVal",mydialog.getEdit_production_monthProduceVal_str());
        jsonObject.put("monthAMaterial",mydialog.getEdit_production_monthAMaterial_str());
        jsonObject.put("monthAdBeforeIncome",mydialog.getEdit_production_monthAdBeforeIncome_str());
        jsonObject.put("monthAdBehindIncome",mydialog.getEdit_production_monthAdBehindIncome_str());
        jsonObject.put("yearProduceVal",mydialog.getEdit_production_yearProduceVal_str());
        jsonObject.put("yearAMaterial",mydialog.getEdit_production_yearAMaterial_str());
        jsonObject.put("yearAdBeforeIncome",mydialog.getEdit_production_yearAdBeforeIncome_str());
        jsonObject.put("yearAdBehindIncome",mydialog.getEdit_production_yearAdBehindIncome_str());
        jsonObject.put("totalProcess",mydialog.getEdit_production_totalProcess_str());
        jsonObject.put("fillingDate", mydialog.getEdit_production_fillingDate_str());
        JSONObject jsonObject1=JSON.parseObject(jsonObject.toString());
        return  jsonObject1;

    }

    private void btn_setOnclick() {

        btn_to_submit= (Button) findViewById(R.id.btn_to_submit);
        btn_to_cancel= (Button) findViewById(R.id.btn_to_cancel);

        btn_to_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_the_project_company_str = Edit_the_project_company.getText().toString().equals("")?"全部":Edit_the_project_company.getText().toString();
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
                .url("http://123.56.106.24:8081/statistic/get?workunit="+companyname)
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
                    String engeenirName = j.getString("engineerName");
                    String workUnit = j.getString("workUnit");
                    String numOfItem = j.getString("numOfItem");
                    String wbs = j.getString("wbs");
                    String endDate = j.getString("endDate");
                    String startDate = j.getString("startDate");
                    String measurementUnit = j.getString("measurementUnit");
                    int amountNum = (int) j.get("amountNum");
                    BigDecimal monthProduceVal = (BigDecimal) j.get("monthProduceVal");
                    BigDecimal monthAMaterial = (BigDecimal) j.get("monthAMaterial");
                    BigDecimal monthAdBeforeIncome = (BigDecimal) j.get("monthAdBeforeIncome");
                    BigDecimal monthAdBehindIncome = (BigDecimal) j.get("monthAdBehindIncome");
                    BigDecimal yearProduceVal = (BigDecimal) j.get("yearProduceVal");
                    BigDecimal yearAMaterial = (BigDecimal) j.get("yearAMaterial");
                    BigDecimal yearAdBeforeIncome = (BigDecimal) j.get("yearAdBeforeIncome");
                    BigDecimal yearAdBehindIncome = (BigDecimal) j.get("yearAdBehindIncome");
                    String currentMonthProcess = j.getString("currentMonthProcess");
                    String totalProcess = j.getString("totalProcess");
                    String fillingDate = j.getString("fillingDate");

                    showresult(pid, engeenirName, workUnit, numOfItem, wbs, endDate, startDate, measurementUnit, amountNum, monthProduceVal, monthAMaterial,
                            monthAdBeforeIncome, monthAdBehindIncome, yearProduceVal, yearAMaterial, yearAdBeforeIncome, yearAdBehindIncome,
                            currentMonthProcess, totalProcess, fillingDate);
                }
            }


        });
    }




    private void showresult(final Integer pid, final String engeenirName, final String workUnit, final String numOfItem, String wbs,
                            final String endDate, final String startDate, final String measurementUnit, final int amountNum,
                            final BigDecimal monthProduceVal, final BigDecimal monthAMaterial, final BigDecimal monthAdBeforeIncome,
                            final BigDecimal monthAdBehindIncome, final BigDecimal yearProduceVal, final BigDecimal yearAMaterial,
                            final BigDecimal yearAdBeforeIncome, final BigDecimal yearAdBehindIncome, final String currentMonthProcess,
                            final String totalProcess, final String fillingDate) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                StatisticInfo statisticinfo=new StatisticInfo();
                statisticinfo.setPid(pid);
                statisticinfo.setEngineerName(engeenirName);
                statisticinfo.setWorkUnit(workUnit);
                statisticinfo.setNumOfItem(numOfItem);
                statisticinfo.setEndDate(endDate);
                statisticinfo.setStartDate(startDate);
                statisticinfo.setMeasurementUnit(measurementUnit);
                statisticinfo.setAmountNum(amountNum);
                statisticinfo.setMonthProduceVal(monthProduceVal);
                statisticinfo.setMonthAMaterial(monthAMaterial);
                statisticinfo.setMonthAdBeforeIncome(monthAdBeforeIncome);
                statisticinfo.setMonthAdBehindIncome(monthAdBehindIncome);
                statisticinfo.setYearProduceVal(yearProduceVal);
                statisticinfo.setYearAMaterial(yearAMaterial);
                statisticinfo.setYearAdBeforeIncome(yearAdBeforeIncome);
                statisticinfo.setYearAdBehindIncome(yearAdBehindIncome);
                statisticinfo.setCurrentMonthProcess(currentMonthProcess);
                statisticinfo.setTotalProcess(totalProcess);
                statisticinfo.setFillingDate(fillingDate);

                data.add(statisticinfo);
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
            View view=View.inflate(Iformation_statistic.this,R.layout.layout_listview_items,null);
            TextView tvTitle = (TextView) view.findViewById(R.id.TV_listTitle_Id);
            TextView tvTime = (TextView) view.findViewById(R.id.TV_listTime_Id);
            TextView tvContext = (TextView) view.findViewById(R.id.TV_listContext_Id);
            String name = data.get(position).getEngineerName();
            if(name.length() > 12) {
                name = name.substring(0,12) + "...";
            }
            tvTitle.setText(data.get(position).getPid()+"");
            tvTime.setText(name);
            tvContext.setText(data.get(position).getNumOfItem());
            return view;
        }
    }
}



