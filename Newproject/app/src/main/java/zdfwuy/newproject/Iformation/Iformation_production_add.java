package zdfwuy.newproject.Iformation;

import android.app.Activity;
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

public class Iformation_production_add extends Activity {
    Button btn_sure,btn_cancel;
    EditText et_engineerName,et_numOfItem,et_workUnit,et_investMoney,
            et_startDate,et_endDate,et_engineerMainMessage,et_thisWeekCompleteProcess,
            et_engineerTotalProcess,et_restProcess,et_nextWeekPlan,et_signPerformence,
            et_contractMoney,et_imageProcess,et_remarks,et_fillingDate,
            et_hrequipment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iformation_production_add);

        btn_sure= (Button) findViewById(R.id.btn_sure);
        btn_cancel=(Button)findViewById(R.id.btn_cancel);



        /*初始化按钮*/
        InitBtn();
    }

    private JSONObject getJSonString() {
        JSONObject jsonobject=new JSONObject();
        jsonobject.put("engineerName",et_engineerName);
        jsonobject.put("numOfItem",et_numOfItem);
        jsonobject.put("workUnit",et_workUnit);
        jsonobject.put("investMoney",et_investMoney);
        jsonobject.put("startDate",et_startDate);
        jsonobject.put("endDate",et_endDate);
        jsonobject.put("planEndperiod",et_nextWeekPlan);
        jsonobject.put("engineerMainMessage",et_engineerMainMessage);
        jsonobject.put("thisWeekCompleteProcess",et_thisWeekCompleteProcess);
        jsonobject.put("engineerTotalProcess",et_engineerTotalProcess);
        jsonobject.put("restProcess",et_restProcess);
        jsonobject.put("nextWeekPlan",et_nextWeekPlan);
        jsonobject.put("signPerformence",et_signPerformence);
        jsonobject.put("contractMoney",et_contractMoney);
        jsonobject.put("imageProcess",et_imageProcess);
        jsonobject.put("remarks",et_remarks);
        jsonobject.put("fillingDate",et_fillingDate);
        jsonobject.put("hrequipment", et_hrequipment);
        JSONObject jsonobject1= JSON.parseObject(jsonobject.toString());
        System.out.println(jsonobject1.toString());
        return jsonobject1;

    }

    private void InitBtn() {
        btn_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_engineerName= (EditText) findViewById(R.id.et_engineerName);
                et_numOfItem= (EditText) findViewById(R.id.et_numOfItem);
                et_workUnit= (EditText) findViewById(R.id.et_workUnit);
                et_investMoney= (EditText) findViewById(R.id.et_investMoney);
                et_startDate= (EditText) findViewById(R.id.et_startDate);
                et_endDate= (EditText) findViewById(R.id.et_endDate);
                et_engineerMainMessage= (EditText) findViewById(R.id.et_engineerMainMessage);
                et_thisWeekCompleteProcess= (EditText) findViewById(R.id.et_thisWeekCompleteProcess);
                et_engineerTotalProcess= (EditText) findViewById(R.id.et_engineerTotalProcess);
                et_restProcess= (EditText) findViewById(R.id.et_restProcess);
                et_nextWeekPlan= (EditText) findViewById(R.id.et_nextWeekPlan);
                et_signPerformence= (EditText) findViewById(R.id.et_signPerformence);
                et_contractMoney= (EditText) findViewById(R.id.et_contractMoney);
                et_imageProcess= (EditText) findViewById(R.id.et_imageProcess);
                et_remarks= (EditText) findViewById(R.id.et_remarks);
                et_fillingDate= (EditText) findViewById(R.id.et_fillingDate);
                et_hrequipment= (EditText) findViewById(R.id.et_hrequipment);




                postOkhttp3Information();
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void postOkhttp3Information() {
        OkHttpClient okHttpClient=new OkHttpClient();
        MediaType mediatype=MediaType.parse("application/json; charset=utf-8");
        RequestBody requestbody= FormBody.create(mediatype, getJSonString().toString());
        Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/product/save")
                .post(requestbody)
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Iformation_production_add.this, "添加信息失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res=response.body().string();
                JSONObject jres=JSON.parseObject(res);

                final int status= (int) jres.get("status");
                System.out.println(status);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(status==1){
                            Toast.makeText(Iformation_production_add.this,"添加信息成功",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(Iformation_production_add.this,"添加信息失败",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });

    }
}
