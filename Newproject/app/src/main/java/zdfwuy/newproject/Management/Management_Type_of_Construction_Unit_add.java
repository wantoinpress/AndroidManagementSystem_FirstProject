package zdfwuy.newproject.Management;

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
import zdfwuy.newproject.Iformation.Iformation_contract;
import zdfwuy.newproject.R;

public class Management_Type_of_Construction_Unit_add extends Activity {
    Button btn_sure,btn_cancel;
    EditText et_rankNum,et_unitType,et_unitName,et_remarks,et_isUsed;
    String et_rankNum_str,et_unitType_str,et_unitName_str,et_remarks_str,et_isUsed_str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management__type_of__construction__unit_add);
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
                .url("http://123.56.106.24:8081/conunitmanage/save")
                .post(requestBody)
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Management_Type_of_Construction_Unit_add.this, "连接服务器失败！", Toast.LENGTH_SHORT).show();
                    }
                });
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res =response.body().string();
                JSONObject result= JSON.parseObject(res);
                final int status= (int) result.get("status");
                System.out.println("*********151515*********");
                System.out.println(status);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (status == 1) {
                            Toast.makeText(Management_Type_of_Construction_Unit_add.this, "添加成功", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Management_Type_of_Construction_Unit_add.this,Iformation_contract.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Management_Type_of_Construction_Unit_add.this, "添加失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }

    private JSONObject createJson() {

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("rankNum",et_rankNum);
        jsonObject.put("unitType",et_unitType);
        jsonObject.put("unitName",et_unitName);
        jsonObject.put("remarks",et_remarks);
        jsonObject.put("isUsed",et_isUsed);
        JSONObject jsonObject1= JSON.parseObject(jsonObject.toString());

        return jsonObject1;
    }

    private void InitEditext() {
        /*et_rankNum_str,et_unitType_str,et_unitName_str,et_remarks_str,et_isUsed_str;*/
        et_rankNum= (EditText) findViewById(R.id.et_rankNum);
        et_unitType= (EditText) findViewById(R.id.et_unitType);
        et_unitName= (EditText) findViewById(R.id.et_unitName);
        et_remarks= (EditText) findViewById(R.id.et_remarks);
        et_isUsed= (EditText) findViewById(R.id.et_isUsed);

        et_rankNum_str=et_rankNum.getText().toString();
        et_unitType_str=et_unitType.getText().toString();
        et_unitName_str=et_unitName.getText().toString();
        et_remarks_str=et_remarks.getText().toString();
        et_isUsed_str=et_isUsed.getText().toString();
    }

}
