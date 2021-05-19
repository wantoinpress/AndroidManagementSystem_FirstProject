package zdfwuy.newproject.Analysis_Data;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import zdfwuy.newproject.R;
import zdfwuy.newproject.data_analysis.NumericalInFo;
import zdfwuy.newproject.dialog.Mydialog_analysis.Mydialog_Numerical_analysis;

public class Numerical_analysis extends Activity {
    LinearLayout linearLayout;
    ListView listView;
    List<NumericalInFo> data=new ArrayList<>();

    DrawerLayout drawerLayout;

    Mydialog_Numerical_analysis mydialog;
    Button btn_to_submit,btn_to_cancel;
    EditText Edit_company_year_processing,Edit_the_project_company;
    String Edit_company_year_processing_str,Edit_the_project_company_str;
    String company="全部";
    int year=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numerical_analysis);
        listView = (ListView) findViewById(R.id.Listview_choose_Time_possibility_analysis);
        drawerLayout= (DrawerLayout) findViewById(R.id.dlShow);
        Edit_company_year_processing= (EditText) findViewById(R.id.Edit_company_year_processing);
        get_okhttpclient(year);
        listView_Onclick();
        Btn_setonclick();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_2, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case  R.id.Search_one:
                drawerLayout.openDrawer(Gravity.END);
                Edit_company_year_processing.setText("0");
                break;
            default:break;
        }
        return true;
    }


    private void listView_Onclick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mydialog=new Mydialog_Numerical_analysis(Numerical_analysis.this,R.style.MyDialog);
                for (int i = 0; i < data.size(); i++) {
                     /*EditText_engineerprogram_production,Editext_pijianhao,Edit_investment_money,Edit_orginal_pijianhao,Edit_production_engineerTime,
            Edit_production_contractNum,Edit_production_startday,Edit_production_endday,Edit_production_signDate,Edit_production_performance;
*/
                    if (i == position) {
                        mydialog.setPid(data.get(i).getPid().toString());
                        mydialog.setEditText_engeenirName_str(data.get(i).getEngineerName());
                        mydialog.setEditext_pijianhao_str(data.get(i).getNumOfItem());
                        mydialog.setEdit_engineerTime_str(data.get(i).getEngineerTime().toString());
                        mydialog.setEdit_workUnit_str(data.get(i).getWorkUnit());
                        mydialog.setEdit_isAbnormalIncome_str(data.get(i).getIsAbnormalIncome());
                        mydialog.setEdit_isAbnormalMarginalProfit_str(data.get(i).getIsAbnormalMarginalProfit());
                        mydialog.setEdit_isAbnormalMaterialCost_str(data.get(i).getIsAbnormalMaterialCost());

                    }
                }
               mydialog.setYesOnclickListener("确定", new Mydialog_Numerical_analysis.onYesOnclickListener() {
                   @Override
                   public void onYesOnclick() {
                       mydialog.dismiss();
                   }
               });
               mydialog.setNoOnclickListener("取消", new Mydialog_Numerical_analysis.onNoOnclickListener() {
                   @Override
                   public void onNoOnclick() {
                       mydialog.dismiss();
                   }
               });
                mydialog.show();
            }
        });
    }
    private void get_okhttpclient( int year) {
        OkHttpClient okhttp3=new OkHttpClient();
        final Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/dataanalysis/get?engineertime="+year)
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
                    String engeenirName = j.getString("engineerName");
                    String isAbnormalIncome = j.getString("isAbnormalIncome");
                    String workUnit = j.getString("workUnit");
                    String numOfItem = j.getString("numOfItem");
                    Integer engineerTime = (Integer) j.get("engineerTime");

                    String isAbnormalMarginalProfit = j.getString("isAbnormalMarginalProfit");
                    String isAbnormalMaterialCost = j.getString("isAbnormalMaterialCost");

                    ShowResult(pid, engeenirName, isAbnormalIncome, workUnit, numOfItem, engineerTime, isAbnormalMarginalProfit, isAbnormalMaterialCost);
                }
            }
        });
    }

    private void ShowResult(final Integer pid, final String engeenirName, final String isAbnormalIncome, final String workUnit, final String numOfItem, final Integer engineerTime, final String isAbnormalMarginalProfit, final String isAbnormalMaterialCost) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                NumericalInFo analysisinfo=new NumericalInFo();
                analysisinfo.setPid(pid);
                analysisinfo.setEngineerName(engeenirName);
                analysisinfo.setIsAbnormalIncome(isAbnormalIncome);
                analysisinfo.setWorkUnit(workUnit);
                analysisinfo.setNumOfItem(numOfItem);
                analysisinfo.setEngineerTime(engineerTime);
                analysisinfo.setIsAbnormalMarginalProfit(isAbnormalMarginalProfit);
                analysisinfo.setIsAbnormalMaterialCost(isAbnormalMaterialCost);

                data.add(analysisinfo);
                listView.setAdapter(new  Myadapter());
            }
        });
    }

    private void Btn_setonclick() {
        btn_to_submit= (Button) findViewById(R.id.btn_to_submit);
        btn_to_cancel= (Button) findViewById(R.id.btn_to_cancel);

        btn_to_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_company_year_processing_str = Edit_company_year_processing.getText().toString().equals("")?"0":Edit_company_year_processing.getText().toString();
                int year = Integer.parseInt(Edit_company_year_processing_str);
                get_okhttpclient(year);
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

            View view=View.inflate(Numerical_analysis.this,R.layout.layout_listview_items,null);
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
