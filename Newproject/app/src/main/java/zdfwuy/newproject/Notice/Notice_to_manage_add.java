package zdfwuy.newproject.Notice;

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

public class Notice_to_manage_add extends Activity {
    Button btn_sure,btn_cancel;
    EditText et_title,et_contract_isSeen,et_isTop,et_visibleRange,et_releaseTime,et_releasePeople,et_readTime,et_bulletinContent;
    String et_title_str,et_contract_isSeen_str,et_isTop_str,et_visibleRange_str,et_releaseTime_str,et_readTime_str,et_bulletinContent_str,et_releasePeople_str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_to_manage_add);

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
                .url("http://123.56.106.24:8081/bulletinmaintenance/save")
                .post(requestBody)
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

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
                            Toast.makeText(Notice_to_manage_add.this, "添加成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Notice_to_manage_add.this, "添加失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }

    private JSONObject createJson() {
        /*et_title,et_contract_isSeen,et_isTop,et_visibleRange,et_releaseTime,et_releasePeople,et_readTime,et_bulletinContent;*/
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("title",et_title_str);
        jsonObject.put("isSeen",et_contract_isSeen_str);
        jsonObject.put("isTop",et_isTop_str);
        jsonObject.put("visibleRange",et_visibleRange_str);
        jsonObject.put("releaseTime",et_releaseTime_str);
        jsonObject.put("releasePeople",et_releasePeople_str);
        jsonObject.put("readTime",et_releaseTime_str);
        jsonObject.put("bulletinContent",et_bulletinContent_str);

        JSONObject jsonObject1= JSON.parseObject(jsonObject.toString());

        return jsonObject1;
    }

    private void InitEditext() {
        /*et_title,et_contract_isSeen,et_isTop,et_visibleRange,et_releaseTime,et_releasePeople,et_readTime,et_bulletinContent;*/
        et_title= (EditText) findViewById(R.id.et_title);
        et_contract_isSeen= (EditText) findViewById(R.id.et_contract_isSeen);
        et_isTop= (EditText) findViewById(R.id.et_isTop);
        et_visibleRange= (EditText) findViewById(R.id.et_visibleRange);
        et_releaseTime= (EditText) findViewById(R.id.et_releaseTime);
        et_readTime= (EditText) findViewById(R.id.et_readTime);
        et_bulletinContent= (EditText) findViewById(R.id.et_bulletinContent);
        et_releasePeople= (EditText) findViewById(R.id.et_releasePeople);


        et_title_str=et_title.getText().toString();
        et_contract_isSeen_str=et_contract_isSeen.getText().toString();
        et_isTop_str=et_isTop.getText().toString();
        et_visibleRange_str=et_visibleRange.getText().toString();
        et_releaseTime_str=et_releaseTime.getText().toString();
        et_readTime_str=et_readTime.getText().toString();
        et_bulletinContent_str=et_bulletinContent.getText().toString();
        et_releasePeople_str=et_releasePeople.getText().toString();
    }
}
