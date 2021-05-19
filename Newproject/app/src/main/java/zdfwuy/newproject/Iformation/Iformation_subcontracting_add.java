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

public class Iformation_subcontracting_add extends Activity {
    EditText et_contract_engineerName,et_contract_numOfItem,et_contract_constructionUnit,et_contract_workUnit,
            et_contract_engineerTime,et_contract_wbs,et_contract_subcontractNo,et_contract_subcontractor,
            et_contract_startDate,et_contract_endDate,et_contract_signDate1,et_contract_subcontractContent,
            et_contract_subcontractingType,et_contract_contractMoney,et_contract_performance,
            et_contract_app,et_contract_aabss,et_contract_saoss,et_contract_erpservicePurchaseOrderNumber;

    String et_contract_engineerName_str,et_contract_numOfItem_str,et_contract_constructionUnit_str,et_contract_workUnit_str,
            et_contract_engineerTime_str,et_contract_wbs_str,et_contract_subcontractNo_str,et_contract_subcontractor_str,
            et_contract_startDate_str,et_contract_endDate_str,et_contract_signDate1_str,et_contract_subcontractContent_str,
            et_contract_subcontractingType_str,et_contract_contractMoney_str,et_contract_performance_str,
            et_contract_app_str,et_contract_aabss_str,et_contract_saoss_str,et_contract_erpservicePurchaseOrderNumber_str;
    Button btn_sure,btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iformation_subcontracting_add);

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
                finish();
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
        RequestBody requestBody= FormBody.create(mediaType, createjson().toString());

        Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/subcontract/save")
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
                        if (status == 1) {
                            Toast.makeText(Iformation_subcontracting_add.this, "添加成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Iformation_subcontracting_add.this, "添加失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }

    private JSONObject createjson() {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("engineerName",et_contract_engineerName_str);
        jsonObject.put("numOfItem",et_contract_numOfItem_str);
        jsonObject.put("constructionUnit",et_contract_constructionUnit_str);
        jsonObject.put("workUnit",et_contract_workUnit_str);
        jsonObject.put("engineerTime",et_contract_engineerTime_str);
        jsonObject.put("wbs",et_contract_wbs_str);
        jsonObject.put("subcontractNo",et_contract_subcontractNo_str);
        jsonObject.put("subcontractor",et_contract_subcontractor_str);
        jsonObject.put("subcontractContent",et_contract_subcontractContent_str);
        jsonObject.put("subcontractingType",et_contract_subcontractingType_str);
        jsonObject.put("signDate",et_contract_signDate1_str);

        jsonObject.put("startDate",et_contract_startDate_str);
        jsonObject.put("endDate",et_contract_endDate_str);
        jsonObject.put("contractMoney",et_contract_contractMoney_str);
        jsonObject.put("performance",et_contract_performance_str);
        jsonObject.put("app",et_contract_app_str);
        jsonObject.put("aabss",et_contract_aabss_str);
        jsonObject.put("saoss",et_contract_saoss_str);
        jsonObject.put("erpservicePurchaseOrderNumber", et_contract_erpservicePurchaseOrderNumber_str);
        JSONObject jsonObject1= JSON.parseObject(jsonObject.toString());
        return jsonObject1;
    }

    private void InitEditext() {
        /*et_contract_engineerName,et_contract_numOfItem,et_contract_constructionUnit,et_contract_workUnit,
            et_contract_engineerTime,et_contract_wbs,et_contract_subcontractNo,et_contract_subcontractor,
            et_contract_startDate,et_contract_endDate,et_contract_signDate1,et_contract_subcontractContent,
            et_contract_subcontractingType,et_contract_contractMoney,et_contract_performance,
            et_contract_app,et_contract_aabss,et_contract_saoss,et_contract_erpservicePurchaseOrderNumber;
    */

        et_contract_engineerName= (EditText) findViewById(R.id.et_contract_engineerName);
        et_contract_numOfItem= (EditText) findViewById(R.id.et_contract_numOfItem);
        et_contract_constructionUnit= (EditText) findViewById(R.id.et_contract_constructionUnit);
        et_contract_workUnit= (EditText) findViewById(R.id.et_contract_workUnit);
        et_contract_engineerTime= (EditText) findViewById(R.id.et_contract_engineerTime);
        et_contract_wbs= (EditText) findViewById(R.id.et_contract_wbs);
        et_contract_subcontractNo= (EditText) findViewById(R.id.et_contract_subcontractNo);
        et_contract_subcontractor= (EditText) findViewById(R.id.et_contract_subcontractor);
        et_contract_startDate= (EditText) findViewById(R.id.et_contract_startDate);
        et_contract_endDate= (EditText) findViewById(R.id.et_contract_endDate);
        et_contract_signDate1= (EditText) findViewById(R.id.et_contract_signDate1);
        et_contract_subcontractContent= (EditText) findViewById(R.id.et_contract_subcontractContent);
        et_contract_subcontractingType= (EditText) findViewById(R.id.et_contract_subcontractingType);
        et_contract_contractMoney= (EditText) findViewById(R.id.et_contract_contractMoney);
        et_contract_performance= (EditText) findViewById(R.id.et_contract_performance);
        et_contract_app= (EditText) findViewById(R.id.et_contract_app);
        et_contract_aabss= (EditText) findViewById(R.id.et_contract_aabss);
        et_contract_saoss= (EditText) findViewById(R.id.et_contract_saoss);
        et_contract_erpservicePurchaseOrderNumber= (EditText) findViewById(R.id.et_contract_erpservicePurchaseOrderNumber);

        et_contract_engineerName_str=et_contract_engineerName.getText().toString();
        et_contract_numOfItem_str=et_contract_numOfItem.getText().toString();
        et_contract_constructionUnit_str=et_contract_constructionUnit.getText().toString();
        et_contract_workUnit_str=et_contract_workUnit.getText().toString();
        et_contract_engineerTime_str=et_contract_engineerTime.getText().toString();
        et_contract_wbs_str=et_contract_wbs.getText().toString();
        et_contract_subcontractNo_str=et_contract_subcontractNo.getText().toString();
        et_contract_subcontractor_str=et_contract_subcontractor.getText().toString();
        et_contract_startDate_str=et_contract_startDate.getText().toString();
        et_contract_endDate_str=et_contract_endDate.getText().toString();
        et_contract_signDate1_str=et_contract_signDate1.getText().toString();

        et_contract_subcontractContent_str=et_contract_subcontractContent.getText().toString();
        et_contract_subcontractingType_str=et_contract_subcontractingType.getText().toString();
        et_contract_contractMoney_str=et_contract_contractMoney.getText().toString();
        et_contract_performance_str=et_contract_performance.getText().toString();
        et_contract_app_str=et_contract_app.getText().toString();
        et_contract_aabss_str=et_contract_aabss.getText().toString();
        et_contract_saoss_str=et_contract_saoss.getText().toString();
        et_contract_erpservicePurchaseOrderNumber_str=et_contract_erpservicePurchaseOrderNumber.getText().toString();
    }
}
