package zdfwuy.newproject.Safeguard;

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

public class Safeguard_division_management_add extends Activity {
    EditText et_unitName,et_remarks,et_internalParameters;
    String  et_unitName_str,et_remarks_str,et_internalParameters_str;
    Button btn_sure,btn_cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safeguard_division_management_add);
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
        RequestBody requestBody= FormBody.create(mediaType, createJson().toString());
        Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/department/save")
                .post(requestBody)
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();
                JSONObject result = JSON.parseObject(res);
                final int status = (int) result.get("status");
                System.out.println("*********151515*********");
                System.out.println(status);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (status == 1) {
                            Toast.makeText(Safeguard_division_management_add.this, "添加成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Safeguard_division_management_add.this, "添加失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }

    private JSONObject createJson() {
        /*et_unitName,et_remarks,et_internalParameters*/
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("unitName",et_unitName);
        jsonObject.put("remarks",et_remarks);
        jsonObject.put("internalParameters",et_internalParameters);

        JSONObject jsonObject1= JSON.parseObject(jsonObject.toString());

        return jsonObject1;
    }
    private void InitEditext() {

        /* et_unitName,et_remarks,et_internalParameters;*/
        et_unitName= (EditText) findViewById(R.id.et_unitName);
        et_remarks= (EditText) findViewById(R.id.et_remarks);
        et_internalParameters= (EditText) findViewById(R.id.et_internalParameters);


        et_unitName_str=et_unitName.getText().toString();
        et_remarks_str=et_remarks.getText().toString();
        et_internalParameters_str=et_internalParameters.getText().toString();
    }
}
