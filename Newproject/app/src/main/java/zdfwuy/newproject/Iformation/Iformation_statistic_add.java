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

public class Iformation_statistic_add extends Activity {
    String et_engineerName_str,et_numOfItem_str,et_workUnit_str,et_wbs_str,et_startDate_str,et_endDate_str,
            et_measurementUnit_str,et_amountNum_str,et_monthProduceVal_str,et_monthAMaterial_str,et_monthAdBeforeIncome_str,
            et_monthAdBehindIncome_str,et_yearProduceVal_str,et_yearAMaterial_str,et_yearAdBeforeIncome_str,
            et_yearAdBehindIncome_str,et_totalProcess_str,et_fillingDate_str;
    EditText  et_engineerName,et_numOfItem,et_workUnit,et_wbs,et_startDate,et_endDate,
    et_measurementUnit,et_amountNum,et_monthProduceVal,et_monthAMaterial,et_monthAdBeforeIncome,
    et_monthAdBehindIncome,et_yearProduceVal,et_yearAMaterial,et_yearAdBeforeIncome,
    et_yearAdBehindIncome,et_totalProcess,et_fillingDate;
    Button btn_sure,btn_cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iformation_statistic_add);

        btn_sure= (Button) findViewById(R.id.btn_sure);
        btn_cancel=(Button)findViewById(R.id.btn_cancel);

        InitBtn();
    }


    private void InitBtn() {
        btn_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*et_engineerName,et_numOfItem,et_workUnit,et_wbs,et_startDate,et_endDate,
    et_measurementUnit,et_amountNum,et_monthProduceVal,et_monthAMaterial,et_monthAdBeforeIncome,
    et_monthAdBehindIncome,et_yearProduceVal,et_yearAMaterial,et_yearAdBeforeIncome,
    et_yearAdBehindIncome,et_totalProcess,et_fillingDate;
  */
                et_engineerName= (EditText) findViewById(R.id.et_engineerName);
                et_numOfItem= (EditText) findViewById(R.id.et_numOfItem);
                et_workUnit= (EditText) findViewById(R.id.et_workUnit);
                et_wbs= (EditText) findViewById(R.id.et_wbs);
                et_startDate= (EditText) findViewById(R.id.et_startDate);
                et_endDate= (EditText) findViewById(R.id.et_endDate);
                et_measurementUnit= (EditText) findViewById(R.id.et_measurementUnit);
                et_amountNum= (EditText) findViewById(R.id.et_amountNum);
                et_monthProduceVal= (EditText) findViewById(R.id.et_monthProduceVal);
                et_monthAMaterial= (EditText) findViewById(R.id.et_monthAMaterial);
                et_monthAdBeforeIncome= (EditText) findViewById(R.id.et_monthAdBeforeIncome);
                et_monthAdBehindIncome= (EditText) findViewById(R.id.et_monthAdBehindIncome);
                et_yearProduceVal= (EditText) findViewById(R.id.et_yearProduceVal);
                et_yearAMaterial= (EditText) findViewById(R.id.et_yearAMaterial);
                et_yearAdBeforeIncome= (EditText) findViewById(R.id.et_yearAdBeforeIncome);
                et_yearAdBehindIncome= (EditText) findViewById(R.id.et_yearAdBehindIncome);
                et_totalProcess= (EditText) findViewById(R.id.et_totalProcess);
                et_fillingDate= (EditText) findViewById(R.id.et_fillingDate);

                et_engineerName_str=et_engineerName.getText().toString();
                et_numOfItem_str=et_numOfItem.getText().toString();
                et_workUnit_str =et_workUnit.getText().toString();
                et_wbs_str=et_wbs.getText().toString();
                et_startDate_str=et_startDate.getText().toString();
                et_endDate_str=et_endDate.getText().toString();
                et_measurementUnit_str=et_measurementUnit.getText().toString();
                et_amountNum_str=et_amountNum.getText().toString();
                et_monthProduceVal_str=et_monthProduceVal.getText().toString();
                et_monthAMaterial_str=et_monthAMaterial.getText().toString();
                et_monthAdBeforeIncome_str=et_monthAdBeforeIncome.getText().toString();

                et_monthAdBehindIncome_str=et_monthAdBehindIncome.getText().toString();
                et_yearProduceVal_str=et_yearProduceVal.getText().toString();
                et_yearAMaterial_str=et_yearAMaterial.getText().toString();
                et_yearAdBeforeIncome_str=et_yearAdBeforeIncome.getText().toString();
                et_yearAdBehindIncome_str=et_yearAdBehindIncome.getText().toString();
                et_totalProcess_str=et_totalProcess.getText().toString();
                et_fillingDate_str=et_fillingDate.getText().toString();


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
        MediaType mediaType=MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody= FormBody.create(mediaType, CreateJson().toString());
        final Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/statistic/save")
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
                JSONObject jsonObject=JSON.parseObject(res);
                final  int status= (int) jsonObject.get("status");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (status==1){
                            Toast.makeText(Iformation_statistic_add.this,"添加成功",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(Iformation_statistic_add.this,"添加失败",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }

    private JSONObject CreateJson() {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("engineerName",et_engineerName_str);
        jsonObject.put("numOfItem",et_numOfItem_str);
        jsonObject.put("wbs",et_wbs_str);
        jsonObject.put("workUnit",et_workUnit_str);
        jsonObject.put("startDate",et_startDate_str);
        jsonObject.put("endDate",et_endDate_str);
        jsonObject.put("measurementUnit",et_measurementUnit_str);
        jsonObject.put("amountNum",et_amountNum_str);
        jsonObject.put("monthProduceVal",et_monthProduceVal_str);
        jsonObject.put("monthAMaterial",et_monthAMaterial_str);
        jsonObject.put("monthAdBeforeIncome",et_monthAdBeforeIncome_str);
        jsonObject.put("monthAdBehindIncome",et_monthAdBehindIncome_str);
        jsonObject.put("yearProduceVal",et_yearProduceVal_str);
        jsonObject.put("yearAMaterial",et_yearAMaterial_str);
        jsonObject.put("yearAdBeforeIncome",et_yearAdBeforeIncome_str);
        jsonObject.put("yearAdBehindIncome",et_yearAdBehindIncome_str);
        jsonObject.put("totalProcess",et_totalProcess_str);
        jsonObject.put("fillingDate", et_fillingDate_str);
        JSONObject jsonObject1= JSON.parseObject(jsonObject.toString());
        return jsonObject1;
    }
}
