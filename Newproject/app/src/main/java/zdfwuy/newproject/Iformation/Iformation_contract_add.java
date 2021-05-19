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

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import zdfwuy.newproject.R;

public class Iformation_contract_add extends Activity {

    Button btn_sure,btn_cancel;
    EditText et_contract_engineerName,et_contract_numOfItem,et_contract_constructionUnit,et_contract_workUnit,et_contract_engineerTime,
            et_contract_contractNum,et_contract_contractMoney,et_contract_signDate,et_contract_startDate,et_contract_endDate,
            et_contract_performance;
    String et_contract_engineerName_str,et_contract_numOfItem_str,et_contract_constructionUnit_str,et_contract_workUnit_str,et_contract_engineerTime_str,
            et_contract_contractNum_str,et_contract_contractMoney_str,et_contract_signDate_str,et_contract_startDate_str,et_contract_endDate_str,
            et_contract_performance_str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iformation_contract_add);

        /*初始化View*/
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
        RequestBody requestBody= FormBody.create(mediaType, createJson().toString());
        final Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/contract/save")
                .post(requestBody)
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Iformation_contract_add.this, "连接服务器失败！", Toast.LENGTH_SHORT).show();
                    }
                });
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res =response.body().string();
                JSONObject result=JSON.parseObject(res);
                final int status= (int) result.get("status");
                System.out.println("*********151515*********");
                System.out.println(status);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (status == 1) {
                            Toast.makeText(Iformation_contract_add.this, "添加成功", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Iformation_contract_add.this,Iformation_contract.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Iformation_contract_add.this, "添加失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }

    private JSONObject createJson() {
        /*et_contract_engineerName_str,et_contract_numOfItem_str,et_contract_constructionUnit_str,et_contract_workUnit_str,et_contract_engineerTime_str,
            et_contract_contractNum_str,et_contract_contractMoney_str,et_contract_signDate_str,et_contract_startDate_str,et_contract_endDate_str,
            et_contract_performance_str;*/
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("engineerName",et_contract_engineerName_str);
        jsonObject.put("numOfItem",et_contract_numOfItem_str);
        jsonObject.put("constructionUnit",et_contract_constructionUnit_str);
        jsonObject.put("workUnit",et_contract_workUnit_str);
        jsonObject.put("engineerTime",et_contract_engineerTime_str);
        jsonObject.put("contractNum",et_contract_contractNum_str);
        jsonObject.put("contractMoney",et_contract_contractMoney_str);
        jsonObject.put("signDate",et_contract_signDate_str);
        jsonObject.put("startDate",et_contract_startDate_str);
        jsonObject.put("endDate",et_contract_endDate_str);
        jsonObject.put("performance", et_contract_performance_str);
        JSONObject jsonObject1= JSON.parseObject(jsonObject.toString());

        return jsonObject1;
    }

    private void InitEditext() {
        et_contract_engineerName= (EditText) findViewById(R.id.et_contract_engineerName);
        et_contract_numOfItem= (EditText) findViewById(R.id.et_contract_numOfItem);
        et_contract_constructionUnit= (EditText) findViewById(R.id.et_contract_constructionUnit);
        et_contract_workUnit= (EditText) findViewById(R.id.et_contract_workUnit);
        et_contract_engineerTime= (EditText) findViewById(R.id.et_contract_engineerTime);
        et_contract_contractNum= (EditText) findViewById(R.id.et_contract_contractNum);
        et_contract_contractMoney= (EditText) findViewById(R.id.et_contract_contractMoney);
        et_contract_signDate= (EditText) findViewById(R.id.et_contract_signDate);
        et_contract_startDate= (EditText) findViewById(R.id.et_contract_startDate);
        et_contract_endDate= (EditText) findViewById(R.id.et_contract_endDate);
        et_contract_performance= (EditText) findViewById(R.id.et_contract_performance);

        et_contract_engineerName_str=et_contract_engineerName.getText().toString();
        et_contract_numOfItem_str=et_contract_numOfItem.getText().toString();
        et_contract_constructionUnit_str=et_contract_constructionUnit.getText().toString();
        et_contract_workUnit_str=et_contract_workUnit.getText().toString();
        et_contract_engineerTime_str=et_contract_engineerTime.getText().toString();
        et_contract_contractNum_str=et_contract_contractNum.getText().toString();
        et_contract_contractMoney_str=et_contract_contractMoney.getText().toString();
        et_contract_signDate_str=et_contract_signDate.getText().toString();
        et_contract_startDate_str=et_contract_startDate.getText().toString();
        et_contract_endDate_str=et_contract_endDate.getText().toString();
        et_contract_performance_str=et_contract_performance.getText().toString();
    }

}
