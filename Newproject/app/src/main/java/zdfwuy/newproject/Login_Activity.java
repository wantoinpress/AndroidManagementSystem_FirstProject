package zdfwuy.newproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Login_Activity extends Activity {
    private String mr="admin",mrsoft="hyj123";//定义用户名和密码
    EditText editText_Username,editText_Password;
    String hostName,hostIP;
    static InetAddress addr = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_);


        Button button_login=(Button)findViewById(R.id.Btn_login);
        editText_Username=(EditText)findViewById(R.id.Edit_username);
        editText_Password=(EditText)findViewById(R.id.Edit_password);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    addr = InetAddress.getLocalHost();
                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                }
            }
        }).start();

        final SharedPreferences sp=getSharedPreferences(mrsoft,MODE_PRIVATE);
        //登录按钮的监听事件
        button_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                String Login_name = editText_Username.getText().toString();
                String Login_password = editText_Password.getText().toString();
                hostName = addr.getHostName();
                hostIP = addr.getHostAddress();
//                SharedPreferences.Editor editor=sp.edit();
                if (Login_name == null || Login_password == null) {
                    Toast.makeText(Login_Activity.this, "用户名或者密码不能为空！", Toast.LENGTH_SHORT).show();
                } else {
                    if (Login_name.equals(mr) && Login_password.equals(mrsoft))//登录密码的验证
                    {
//                        editor.putString("username",Login_name);
//                        editor.putString("userpassword", Login_password);
//                        editor.commit();
                        Intent intent = new Intent(Login_Activity.this, MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(Login_Activity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                postOkhttp3();
                            }
                        }).start();

                    } else {
                        Toast.makeText(Login_Activity.this, "用户名或者密码错误！", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }

    private void postOkhttp3() {
        OkHttpClient okhhtp3=new OkHttpClient();
        MediaType media=MediaType.parse("application/json; charset=utf-8");
        RequestBody request=FormBody.create(media, createjson().toString());
        Request request1=new Request.Builder()
                .url("http://123.56.106.24:8081/login/login")
                .post(request)
                .build();
        Call call=okhhtp3.newCall(request1);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

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
                            Toast.makeText(Login_Activity.this, "修改成功！", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(Login_Activity.this, "修改失败！", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }

    private JSONObject createjson() {
        JSONObject jsonObject=new JSONObject();

        jsonObject.put("userName",editText_Username);
        jsonObject.put("password", editText_Password);
        jsonObject.put("loginName","管理员");
        jsonObject.put("loginIP",hostIP);
        jsonObject.put("loginMachineName", hostName);
        JSONObject jsonObject1=JSON.parseObject(jsonObject.toString());
        return  jsonObject1;

    }


}
