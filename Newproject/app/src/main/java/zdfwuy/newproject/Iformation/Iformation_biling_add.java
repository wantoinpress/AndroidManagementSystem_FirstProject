package zdfwuy.newproject.Iformation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

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
import zdfwuy.newproject.data.SettlementInfo;

public class Iformation_biling_add extends Activity {
    Button btn_sure,btn_cancel;
    EditText et_contract_engineerName,et_contract_numOfItem,et_contract_constructionUnit,
            et_contract_workUnit,et_contract_engineerTime,et_contract_settlementPreparationAmount,
            et_contract_contractMoney,et_contract_notReportedReview,et_contract_comsume_reportConstructionUnit,
            et_contract_reportBudgetDepartment,et_contract_reportAudit,et_contract_pendingAccountAfterAudit,
            et_contract_account,et_contract_postAuditAmount,et_contract_invoiceAmount;
    String  et_contract_engineerName_str,et_contract_numOfItem_str,et_contract_constructionUnit_str,
    et_contract_workUnit_str,et_contract_engineerTime_str,et_contract_settlementPreparationAmount_str,
    et_contract_contractMoney_str,et_contract_notReportedReview_str,et_contract_comsume_reportConstructionUnit_str,
    et_contract_reportBudgetDepartment_str,et_contract_reportAudit_str,et_contract_pendingAccountAfterAudit_str,
    et_contract_account_str,et_contract_postAuditAmount_str,et_contract_invoiceAmount_str;

    List<SettlementInfo> data=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iformation_biling_add);

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

    private void InitEditext() {

        /*et_contract_engineerName,et_contract_numOfItem,et_contract_constructionUnit,
            et_contract_workUnit,et_contract_engineerTime,et_contract_settlementPreparationAmount,
            et_contract_contractMoney,et_contract_notReportedReview,et_contract_comsume_reportConstructionUnit,
            et_contract_reportBudgetDepartment,et_contract_reportAudit,et_contract_pendingAccountAfterAudit,
            et_contract_account,et_contract_postAuditAmount,et_contract_invoiceAmount;*/

        et_contract_engineerName= (EditText) findViewById(R.id.et_contract_engineerName);
        et_contract_numOfItem= (EditText) findViewById(R.id.et_contract_numOfItem);
        et_contract_constructionUnit= (EditText) findViewById(R.id.et_contract_constructionUnit);
        et_contract_workUnit= (EditText) findViewById(R.id.et_contract_workUnit);
        et_contract_engineerTime= (EditText) findViewById(R.id.et_contract_engineerTime);
        et_contract_settlementPreparationAmount= (EditText) findViewById(R.id.et_contract_settlementPreparationAmount);
        et_contract_notReportedReview= (EditText) findViewById(R.id.et_contract_notReportedReview);
        et_contract_comsume_reportConstructionUnit= (EditText) findViewById(R.id.et_contract_comsume_reportConstructionUnit);
        et_contract_contractMoney= (EditText) findViewById(R.id.et_contract_contractMoney);
        et_contract_reportBudgetDepartment= (EditText) findViewById(R.id.et_contract_reportBudgetDepartment);
        et_contract_reportAudit= (EditText) findViewById(R.id.et_contract_reportAudit);
        et_contract_pendingAccountAfterAudit= (EditText) findViewById(R.id.et_contract_pendingAccountAfterAudit);
        et_contract_account= (EditText) findViewById(R.id.et_contract_account);
        et_contract_postAuditAmount= (EditText) findViewById(R.id.et_contract_postAuditAmount);
        et_contract_invoiceAmount= (EditText) findViewById(R.id.et_contract_invoiceAmount);

        et_contract_engineerName_str=et_contract_engineerName.getText().toString();
        et_contract_numOfItem_str=et_contract_numOfItem.getText().toString();
        et_contract_constructionUnit_str=et_contract_constructionUnit.getText().toString();
        et_contract_workUnit_str=et_contract_workUnit.getText().toString();
        et_contract_engineerTime_str=et_contract_engineerTime.getText().toString();
        et_contract_settlementPreparationAmount_str=et_contract_settlementPreparationAmount.getText().toString();
        et_contract_notReportedReview_str =et_contract_notReportedReview.getText().toString();
        et_contract_comsume_reportConstructionUnit_str=et_contract_comsume_reportConstructionUnit.getText().toString();
        et_contract_contractMoney_str=et_contract_contractMoney.getText().toString();
        et_contract_reportBudgetDepartment_str=et_contract_reportBudgetDepartment.getText().toString();
        et_contract_reportAudit_str=et_contract_reportAudit.getText().toString();
        et_contract_pendingAccountAfterAudit_str=et_contract_pendingAccountAfterAudit.getText().toString();
        et_contract_account_str=et_contract_account.getText().toString();

        et_contract_postAuditAmount_str=et_contract_postAuditAmount.getText().toString();
        et_contract_invoiceAmount_str=et_contract_invoiceAmount.getText().toString();

        showresult(et_contract_engineerName_str,et_contract_numOfItem_str,et_contract_constructionUnit_str,et_contract_workUnit_str,
                et_contract_engineerTime_str,et_contract_settlementPreparationAmount_str,et_contract_notReportedReview_str,et_contract_comsume_reportConstructionUnit_str,
                et_contract_contractMoney_str,et_contract_reportBudgetDepartment_str,et_contract_reportAudit_str,et_contract_pendingAccountAfterAudit_str,
                et_contract_account_str);

    }

    private void showresult(final String et_contract_engineerName_str, final String et_contract_numOfItem_str, final String et_contract_constructionUnit_str, final String et_contract_workUnit_str, final String et_contract_engineerTime, final String et_contract_settlementPreparationAmount_str, final String et_contract_notReportedReview_str, final String et_contract_comsume_reportConstructionUnit_str, String et_contract_contractMoney_str, final String et_contract_reportBudgetDepartment_str, final String et_contract_reportAudit_str, final String et_contract_pendingAccountAfterAudit_str, final String et_contract_account_str) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                SettlementInfo setment=new SettlementInfo();
                setment.setEngineerName(et_contract_engineerName_str);
                setment.setNumOfItem(et_contract_numOfItem_str);
                setment.setConstructionUnit(et_contract_constructionUnit_str);
                setment.setWorkUnit(et_contract_workUnit_str);
                Integer et_contract_engineerTime1=Integer.valueOf(et_contract_engineerTime_str);
                setment.setEngineerTime(et_contract_engineerTime1);
                BigDecimal et_contract_settlementPreparationAmount_str1=new BigDecimal(et_contract_settlementPreparationAmount_str);
                setment.setSettlementPreparationAmount(et_contract_settlementPreparationAmount_str1);
                setment.setNotReportedReview(et_contract_notReportedReview_str);
                setment.setReportConstructionUnit(et_contract_comsume_reportConstructionUnit_str);
                setment.setReportBudgetDepartment(et_contract_reportBudgetDepartment_str);
                setment.setReportAudit(et_contract_reportAudit_str);
                setment.setPendingAccountAfterAudit(et_contract_pendingAccountAfterAudit_str);
                setment.setAccount(et_contract_account_str);

                data.add(setment);
            }
        });
    }

    private void postOkhttp3() {
        OkHttpClient okHttpClient=new OkHttpClient();
        MediaType mediaType=MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody= FormBody.create(mediaType, createJson().toString());
        Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/settlement/save")
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
                final int status= (int) jsonObject.get("status");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (status == 1) {
                            Toast.makeText(Iformation_biling_add.this, "添加成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Iformation_biling_add.this, "添加失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }

    private JSONObject createJson() {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("engineerName",data.get(0).getEngineerName());
        jsonObject.put("numOfItem",data.get(0).getNumOfItem());
        jsonObject.put("constructionUnit",data.get(0).getConstructionUnit());
        jsonObject.put("workUnit",data.get(0).getWorkUnit());
        jsonObject.put("engineerTime",data.get(0).getEngineerTime());
        jsonObject.put("settlementPreparationAmount",data.get(0).getSettlementPreparationAmount());
        jsonObject.put("notReportedReview",data.get(0).getNotReportedReview());
        jsonObject.put("reportConstructionUnit",data.get(0).getReportConstructionUnit());
        jsonObject.put("reportBudgetDepartment",data.get(0).getReportBudgetDepartment());
        jsonObject.put("reportAudit",data.get(0).getReportAudit());
        jsonObject.put("pendingAccountAfterAudit",data.get(0).getPendingAccountAfterAudit());
        jsonObject.put("account",data.get(0).getAccount());
        jsonObject.put("postAuditAmount",data.get(0).getPostAuditAmount());
        jsonObject.put("invoiceAmount", data.get(0).getInvoiceAmount());
        JSONObject jsonObject1= (JSONObject) JSON.parseObject(jsonObject.toString(),new TypeReference<List<SettlementInfo>>(){});

        return jsonObject1;
    }
}
