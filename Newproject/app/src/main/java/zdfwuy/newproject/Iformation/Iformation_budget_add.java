package zdfwuy.newproject.Iformation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
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
import zdfwuy.newproject.R;
import zdfwuy.newproject.data.SettlementInfo;

public class Iformation_budget_add extends Activity {
    Button btn_sure,btn_cancel;
    EditText et_contract_engineerName,et_contract_numOfItem,et_contract_constructionUnit,et_contract_workUnit,et_contract_signDate,et_contract_performance,et_contract_amaterialCost,et_contract_amaterialCost1,
           et_contract_contractMoney,et_contract_engineerTime,et_contract_contractNum,et_contract_comsume_technology,et_contract_takein;
    String et_contract_engineerName_str,et_contract_numOfItem_str,et_contract_constructionUnit_str,et_contract_workUnit_str,et_contract_signDate_str,et_contract_performance_str,et_contract_amaterialCost_str,et_contract_amaterialCost1_str,
            et_contract_contractMoney_str,et_contract_engineerTime_str,et_contract_contractNum_str,et_contract_comsume_technology_str,et_contract_takein_str;
   List<SettlementInfo> data=new ArrayList<>();
    transient JSONObject jsonObject=new JSONObject();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iformation_budget_add);

        InitEvent();
    }

    private void InitEvent() {
        btn_sure= (Button) findViewById(R.id.btn_sure);
        btn_cancel= (Button) findViewById(R.id.btn_cancel);
        InitEditext();

        btn_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postOkhttp3();
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void postOkhttp3() {
        OkHttpClient okHttpClient=new OkHttpClient();
        MediaType mediaType=MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody=FormBody.create(mediaType, createJson());
        Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/budget/save")
                .post(requestBody)
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();
                JSONObject jsonObject = JSON.parseObject(res);
                final int status = (int) jsonObject.get("status");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (status == 1) {

                            Toast.makeText(Iformation_budget_add.this, "添加成功", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Iformation_budget_add.this,Iformation_budget.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(Iformation_budget_add.this, "添加失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    private String createJson() {
        jsonObject.put("engineerName",et_contract_engineerName);
        jsonObject.put("numOfItem",et_contract_numOfItem);
        jsonObject.put("constructionUnit",et_contract_constructionUnit);
        jsonObject.put("workUnit",et_contract_workUnit);
        jsonObject.put("engineerTime",et_contract_engineerTime);
        jsonObject.put("laborCost",et_contract_contractMoney);
        jsonObject.put("consumptionCost",et_contract_signDate);
        jsonObject.put("budgetMoney",et_contract_contractNum);
        jsonObject.put("mechanicsCost",et_contract_comsume_technology);
        jsonObject.put("takeCost",et_contract_takein);
        jsonObject.put("finalBudget",et_contract_performance);
        jsonObject.put("bmaterialCost",et_contract_amaterialCost1);
        jsonObject.put("amaterialCost", et_contract_amaterialCost);
        //这里将json字符串转化成javabean对象
        return JSON.parseObject(jsonObject.toString()).toString();

    }

    private void InitEditext() {
        /*et_contract_engineerName,et_contract_numOfItem,et_contract_constructionUnit,et_contract_workUnit,et_contract_signDate,et_contract_performance,et_contract_amaterialCost,et_contract_amaterialCost1,
           et_contract_contractMoney;*/
        et_contract_engineerName = (EditText) findViewById(R.id.et_contract_engineerName);
        et_contract_numOfItem = (EditText) findViewById(R.id.et_contract_numOfItem);
        et_contract_constructionUnit = (EditText) findViewById(R.id.et_contract_constructionUnit);
        et_contract_workUnit = (EditText) findViewById(R.id.et_contract_workUnit);
        et_contract_signDate = (EditText) findViewById(R.id.et_contract_signDate);
        et_contract_performance = (EditText) findViewById(R.id.et_contract_performance);
        et_contract_amaterialCost = (EditText) findViewById(R.id.et_contract_amaterialCost);
        et_contract_amaterialCost1 = (EditText) findViewById(R.id.et_contract_amaterialCost1);
        et_contract_contractMoney = (EditText) findViewById(R.id.et_contract_contractMoney);
        et_contract_engineerTime = (EditText) findViewById(R.id.et_contract_engineerTime);
        et_contract_contractNum = (EditText) findViewById(R.id.et_contract_contractNum);
        et_contract_comsume_technology = (EditText) findViewById(R.id.et_contract_comsume_technology);
        et_contract_takein = (EditText) findViewById(R.id.et_contract_takein);

        et_contract_engineerName_str = et_contract_engineerName.getText().toString();
        et_contract_numOfItem_str = et_contract_numOfItem.getText().toString();
        et_contract_constructionUnit_str = et_contract_constructionUnit.getText().toString();
        et_contract_workUnit_str = et_contract_workUnit.getText().toString();
        et_contract_signDate_str = et_contract_signDate.getText().toString();
        et_contract_performance_str = et_contract_performance.getText().toString();
        et_contract_amaterialCost_str = et_contract_amaterialCost.getText().toString();
        et_contract_amaterialCost1_str = et_contract_amaterialCost1.getText().toString();
        et_contract_contractMoney_str = et_contract_contractMoney.getText().toString();
        et_contract_engineerTime_str = et_contract_engineerTime.getText().toString();
        et_contract_contractNum_str = et_contract_contractNum.getText().toString();
        et_contract_comsume_technology_str = et_contract_comsume_technology.getText().toString();
        et_contract_takein_str = et_contract_takein.getText().toString();

//        showResult(et_contract_engineerName_str,et_contract_numOfItem_str,et_contract_constructionUnit_str,et_contract_workUnit_str,
//                et_contract_signDate_str, et_contract_performance_str,et_contract_amaterialCost_str,et_contract_amaterialCost1_str,
//                et_contract_contractMoney_str,et_contract_engineerTime_str,et_contract_contractNum_str,et_contract_comsume_technology_str,et_contract_takein_str);
//
    }
//    private void showResult(final String et_contract_engineerName_str, final String et_contract_numOfItem_str, final String et_contract_constructionUnit_str, final String et_contract_workUnit_str, String et_contract_signDate_str, String et_contract_performance_str, String et_contract_amaterialCost_str, String et_contract_amaterialCost1_str, String et_contract_contractMoney_str, String et_contract_engineerTime_str, String et_contract_contractNum_str, String et_contract_comsume_technology_str, String et_contract_takein_str) {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                SettlementInfo settlement=new SettlementInfo();
//                settlement.setEngineerName(et_contract_engineerName_str);
//                settlement.setNumOfItem(et_contract_numOfItem_str);
//                settlement.setConstructionUnit(et_contract_constructionUnit_str);
//                settlement.setWorkUnit(et_contract_workUnit_str);
//                settlement.set
//            }
//        });

}
