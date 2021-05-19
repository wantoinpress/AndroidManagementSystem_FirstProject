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
import zdfwuy.newproject.data.ProduceInfo;
import zdfwuy.newproject.dialog.Mydialog_production1;

public class Iformation_production extends Activity {
    LinearLayout linearLayout;
    ListView listView;
    boolean weatherMove;
    ProduceInfo produceInfo;
    List<ProduceInfo> data=new ArrayList<>();
    Mydialog_production1 mydialog;

    EditText Iformation_production_add_texttitle;
    DrawerLayout drawerLayout;
    Button button,button1;


    String Iformation_production_company_string;

    /*默认值*/
    String companyname="全部";
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.add:
                Intent intent=new Intent(Iformation_production.this,Iformation_production_add.class);
                startActivity(intent);
                break;
            case R.id.Search_one:
                drawerLayout.openDrawer(Gravity.END);
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iformation_production);
        drawerLayout= (DrawerLayout) findViewById(R.id.production_Drwaerlayout);
        Iformation_production_add_texttitle= (EditText) findViewById(R.id.Iformation_production_company);

        listView= (ListView) findViewById(R.id.Listview_choose_Iformation_production);

        Btn_set_onclick();

        ListViewOnClick();

        getokhttp3(companyname);

        registerForContextMenu(listView);
        
//        initlistonclick();
    }

    /*private void initlistonclick() {
        weatherMove=false;
        listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        // 如果滑动，这里把变量进行改变
                        weatherMove = true;
                        break;
                    case MotionEvent.ACTION_UP:
                        if(!weatherMove){

                        }
                        weatherMove=false;
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }*/


    private void ListViewOnClick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mydialog = new Mydialog_production1(Iformation_production.this, R.style.MyDialog);
                System.out.println("****123355**");
                System.out.println(data.get(0).getPid());
                String data1 = data.get(0).getEngineerName().toString();
                System.out.println(data1);

                for (int i = 0; i < data.size(); i++) {
                    if (i == position) {
                        mydialog.setPid(data.get(i).getPid().toString());
                        mydialog.setEngineerNamestr(data.get(i).getEngineerName());
                        mydialog.setStartDatestr(data.get(i).getStartDate());
                        mydialog.setNumOfItemstr(data.get(i).getNumOfItem());
//                        mydialog.setWorkUnitstr(data.get(i).getWorkUnit());
                        mydialog.setEndDatestr(data.get(i).getEndDate());
                        mydialog.setPlanEndperiodstr(data.get(i).getPlanEndperiod());
                        mydialog.setEngineerMainMessagestr(data.get(i).getEngineerMainMessage());

                        mydialog.setThisWeekCompleteProcessstr(data.get(i).getThisWeekCompleteProcess());
                        mydialog.setRestProcessstr(data.get(i).getRestProcess());
                        mydialog.setNextWeekPlanstr(data.get(i).getNextWeekPlan());
//                        mydialog.setSignPerformencestr(data.get(i).getSignPerformence());
//                        mydialog.setHREquipmentstr(data.get(i).getHREquipment());
//                        mydialog.setFillingDatestr(data.get(i).getFillingDate());
                    }
                }
                mydialog.setYesOnclickListener("修改", new Mydialog_production1.onYesOnclickListener() {
                    @Override
                    public void onYesclick() {
                        mydialog.SetEditTextENeditable();

                        mydialog.setYesOnclickListener("确定", new Mydialog_production1.onYesOnclickListener() {
                            @Override
                            public void onYesclick() {
                                mydialog.setYesstr("确定");
                                mydialog.dismiss();
                                postokHttpClient();

                            }
                        });

                    }


                });
                mydialog.setNoOnclickListener("取消", new Mydialog_production1.onNoOnclickListener() {
                    @Override
                    public void onNoclick() {
                        mydialog.dismiss();
                    }
                });
                mydialog.show();
            }

            private void postokHttpClient() {
                OkHttpClient okHttpClient = new OkHttpClient();
                MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
                RequestBody requestBody = FormBody.create(mediaType, createJson().toString());
                final Request request=new Request.Builder()
                        .url("http://123.56.106.24:8081/product/save")
                        .post(requestBody)
                        .build();
                Call call=okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String res=response.body().string();
                        JSONObject result=JSON.parseObject(res);
                        final int status= (int) result.get("status");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (status==1){
                                    Toast.makeText(Iformation_production.this, "修改成功！", Toast.LENGTH_SHORT).show();

                                }else {
                                    Toast.makeText(Iformation_production.this, "修改失败！", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
            }
        });


    }

    private JSONObject createJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pid",mydialog.getPid());
        jsonObject.put("engineerName", mydialog.getEngineerNamestr());
        jsonObject.put("startDate", mydialog.getStartDatestr());
        jsonObject.put("numOfItem", mydialog.getNumOfItemstr());

        jsonObject.put("endDate", mydialog.getEndDatestr());
        jsonObject.put("planEndperiod", mydialog.getPlanEndperiodstr());
        jsonObject.put("engineerMainMessage", mydialog.getEngineerMainMessagestr());
        jsonObject.put("thisWeekCompleteProcess", mydialog.getThisWeekCompleteProcessstr());
        jsonObject.put("engineerTotalProcess", mydialog.getEngineerTotalProcessstr());
        jsonObject.put("restProcess", mydialog.getRestProcessstr());
        jsonObject.put("nextWeekPlan", mydialog.getNextWeekPlanstr());
//        jsonObject.put("signPerformence", mydialog.getSignPerformencestr());
//        jsonObject.put("hrequipment", mydialog.getHREquipmentstr());
//        jsonObject.put("fillingDate", mydialog.getFillingDatestr());

        JSONObject jsonObject1=JSONObject.parseObject(jsonObject.toString());
        return jsonObject1;
    }


    private void Btn_set_onclick() {
        button= (Button) findViewById(R.id.iformation_production_btn_to_submit);
        button1= (Button) findViewById(R.id.iformation_production_btn_to_cancel);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Iformation_production_company_string = Iformation_production_add_texttitle.getText().toString().equals("")?"全部":Iformation_production_add_texttitle.getText().toString();

                getokhttp3(Iformation_production_company_string);

                drawerLayout.closeDrawers();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });
    }







    /**/
    private void getokhttp3(String companyname) {
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/product/get?workunit="+companyname)
                .get()
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Iformation_production.this, "服务器连接失败!", Toast.LENGTH_SHORT).show();
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

                    Object i1 = jsonArray.size();
                    Integer pid = (Integer) j.get("pid");
                    System.out.println(pid);
                    String engeenirName = j.getString("engineerName");
                    String workUnit = j.getString("workUnit");
                    String numOfItem = j.getString("numOfItem");
                    String startDate = j.getString("startDate");
                    String endDate = j.getString("endDate");
                    String planEndperiod = j.getString("planEndperiod");
                    String engineerMainMessage = j.getString("engineerMainMessage");
                    String thisWeekCompleteProcess = j.getString("thisWeekCompleteProcess");
                    String engineerTotalProcess = j.getString("engineerTotalProcess");
                    String restProcess = j.getString("restProcess");
                    String nextWeekPlan = j.getString("nextWeekPlan");
                    String signPerformence = j.getString("signPerformence");
                    BigDecimal contractMoney = (BigDecimal) j.get("contractMoney");
                    BigDecimal imageProcess = (BigDecimal) j.get("imageProcess");
                    BigDecimal investMoney = (BigDecimal) j.get("investMoney");
                    String remarks = j.getString("remarks");
                    String fillingDate = j.getString("fillingDate");
                    String hrequipment = j.getString("hrequipment");

                    showResult(pid, engeenirName, workUnit, numOfItem, startDate, endDate, planEndperiod, engineerMainMessage, thisWeekCompleteProcess, engineerTotalProcess, restProcess, nextWeekPlan, signPerformence, contractMoney, imageProcess, investMoney, remarks, fillingDate, hrequipment);
                }


            }
        });
    }

    private void showResult(final Integer pid, final String engeenirName, final String workUnit, final String numOfItem, final String startDate,
                            final String endDate, final String planEndperiod, final String engineerMainMessage, final String thisWeekCompleteProcess, final String engineerTotalProcess,
                            final String restProcess, final String nextWeekPlan, final String signPerformence, final BigDecimal contractMoney, final BigDecimal imageProcess,
                            final BigDecimal investMoney, final String remarks, final String fillingDate, final String hrequipment) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                produceInfo=new ProduceInfo();
                produceInfo.setPid(pid);
                produceInfo.setEngineerName(engeenirName);
                produceInfo.setWorkUnit(workUnit);
                produceInfo.setNumOfItem(numOfItem);
                produceInfo.setStartDate(startDate);
                produceInfo.setEndDate(endDate);
                produceInfo.setPlanEndperiod(planEndperiod);
                produceInfo.setEngineerMainMessage(engineerMainMessage);
                produceInfo.setThisWeekCompleteProcess(thisWeekCompleteProcess);
                produceInfo.setRestProcess(restProcess);
                produceInfo.setNextWeekPlan(nextWeekPlan);
                produceInfo.setSignPerformence(signPerformence);
                produceInfo.setContractMoney(contractMoney);
                produceInfo.setEngineerTotalProcess(engineerTotalProcess);
                produceInfo.setImageProcess(imageProcess);
                produceInfo.setInvestMoney(investMoney);
                produceInfo.setRemarks(remarks);
                produceInfo.setFillingDate(fillingDate);
                produceInfo.setHREquipment(hrequipment);

                data.add(produceInfo);
                listView.setAdapter(new MyListViewAdapter());
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
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case  R.id.context_menu_delete:
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("pid", data.get(adapterContextMenuInfo.position).getPid());
                JSONObject jsonObject1=JSON.parseObject(jsonObject.toString());

                OkHttpClient okHttpClient=new OkHttpClient();
                Request request=new Request.Builder()
                        .url("http://123.56.106.24:8081/product/delete/"+data.get(adapterContextMenuInfo.position).getPid())
                        .get()
                        .build();
                Call call=okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
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
                                    Toast.makeText(Iformation_production.this, "删除成功！", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Iformation_production.this, "删除失败！", Toast.LENGTH_SHORT).show();
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
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    private class MyListViewAdapter extends BaseAdapter {

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
            View view=View.inflate(Iformation_production.this,R.layout.layout_listview_items,null);
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
