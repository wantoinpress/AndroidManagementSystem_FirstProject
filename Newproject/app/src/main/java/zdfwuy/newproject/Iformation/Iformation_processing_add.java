package zdfwuy.newproject.Iformation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.lang.reflect.Field;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import zdfwuy.newproject.R;


public class Iformation_processing_add extends Activity {
    Button Submitbutton;
    Spinner spinner_companyType,spinner_buildCompany,spinner_workCompany,spinner_isFin;
    String spinner_companyType1,spinner_buildCompany1,spinner_workCompany1,spinner_isFin1,site_order,site_number,site_wbs,site_investment,site_year,site_origin_order,site_name;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iformation_processing_add);

        Submitbutton=(Button)findViewById(R.id.Btn_submit);

        Submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InitOnClickEvent();
            }
        });
        //建立转换工程的选项
        System.out.println("*******************************");
        InitSpinner1();
        InitSpinner2();
        InitSpinner3();
        InitSpinner4();
    }


    private void InitSpinner4() {
        spinner_isFin=(Spinner)findViewById(R.id.Spinner_ChangeProject);
        String[] Project_items={"是","否"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Project_items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_isFin.setAdapter(adapter);
    }

    private void InitSpinner3() {
        spinner_workCompany=(Spinner)findViewById(R.id.Spinner_workCompany);
        String[] Project_items={"","是","否"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Project_items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_workCompany.setAdapter(adapter);
    }

    private void InitSpinner2() {
        spinner_buildCompany=(Spinner)findViewById(R.id.Spinner_buildCompany);
        String[] Project_items={"","是","否"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Project_items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_buildCompany.setAdapter(adapter);

    }

    //初始按键事件
    public void InitOnClickEvent() {
        site_name=((EditText)findViewById(R.id.Edit_project_name)).getText().toString();
        site_number=((EditText)findViewById(R.id.Edit_pijianhao)).getText().toString();
        site_wbs=((EditText)findViewById(R.id.Edit_wbs)).getText().toString();
        site_investment=((EditText)findViewById(R.id.Edit_Total_Investment)).getText().toString();
        site_year=((EditText)findViewById(R.id.Edit_Year)).getText().toString();
        site_origin_order=((EditText)findViewById(R.id.Edit_originalNum)).getText().toString();


        final boolean b=true;
        final boolean c=true;
        final boolean d=true;
        final boolean e=true;
        //获取Spinner（下拉列表内容）
        spinner_companyType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                try {
                    Class<?> clazz = AdapterView.class;
                    Field field = clazz.getDeclaredField("mOldSelectedPosition");
                    field.setAccessible(true);
                    field.setInt(spinner_companyType,AdapterView.INVALID_POSITION);
                } catch(Exception e){
                    e.printStackTrace();
                }
                spinner_companyType1 = adapterView.getItemAtPosition(i).toString();//如何获取spinner中的值
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        spinner_buildCompany.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(c){
                    view.setVisibility(View.INVISIBLE);
                }else {
                    spinner_buildCompany1 = adapterView.getItemAtPosition(i).toString();//如何获取spinner中的值
                }
                boolean c=false;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        spinner_workCompany.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(d){
                    view.setVisibility(View.INVISIBLE);
                }else {
                    spinner_buildCompany1 = adapterView.getItemAtPosition(i).toString();//如何获取spinner中的值
                }
                boolean d=false;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        spinner_isFin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(e){
                    view.setVisibility(View.INVISIBLE);
                }else {
                    spinner_buildCompany1 = adapterView.getItemAtPosition(i).toString();//如何获取spinner中的值
                }
                boolean e=false;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
//        if(!"".equals(site1)&&!"".equals(site2)&&!"".equals(site3)&&!"".equals(site4)&&!"".equals(site5)&&!"".equals(spinner1)){
////            intent=new Intent(Iformation_processing_add.this,Iformation_processing.class);
////            startActivity(intent);
////            Bundle bundle=new Bundle();
////            bundle.putCharSequence("name",site1);
////            bundle.putCharSequence("number",site2);
////            bundle.putCharSequence("Construction",site3);
////            bundle.putCharSequence("Invesment",site4);
////            bundle.putCharSequence("Year",site5);
////            bundle.putCharSequence("Spinner",spinner1);
////            intent.putExtras(bundle);
//            //创建并获取JSON语句
////            JSONObject obj = JSONObject.fromObject(createJsonObject().toString());
////            String abc=obj.getString("site1_name");
////            Log.d("testview",obj.getString("site1_name"));
////            Toast.makeText(Iformation_processing_add.this,abc,Toast.LENGTH_SHORT).show();
//
//
//        }else {
//            Toast.makeText(Iformation_processing_add.this,"请填写完整的数据！",Toast.LENGTH_SHORT).show();
//        }

        postOkHttpClient();//发送Jsonstring

    }

    private void postOkHttpClient() {
        OkHttpClient okHttpClient=new OkHttpClient();
        MediaType mediaType=MediaType.parse("application/json; charset=utf-8");//传输数据类型
        RequestBody requestBody= FormBody.create(mediaType, createJsonObject().toString());
        final Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/produce/save")
                .post(requestBody)
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Iformation_processing_add.this, "连接服务器失败！", Toast.LENGTH_SHORT).show();
                    }
                });
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                JSONObject res = JSON.parseObject(result);
                final int status = (int) res.get("status");
                System.out.println(status);
                runOnUiThread(new Runnable() {
                    @Override
                    /**
                     * 实时更新，数据库信息改变时，客户端内容发生改变
                     */
                    public void run() {
                        if (status == 1) {
                            Toast.makeText(Iformation_processing_add.this, "添加成功！", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Iformation_processing_add.this,Iformation_processing.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(Iformation_processing_add.this, "添加失败！", Toast.LENGTH_SHORT).show();
                        }
                    }

                });

            }
        });
    }

    //创建JSON对象
//    public tojson<String, Object> createJsonObject(){
//        tojson<String, Object> site11=new tojson<>();
//        site11.put("site1_name",site_name);
//        site11.put("site1_number",site_number);
//        site11.put("site_wbs",site_wbs);
//        site11.put("site1_Investment",site_investment);
//        site11.put("site1_Year",site_year);
//        site11.put("site_origin_order", site_origin_order);
//        System.out.println(site11.toString());
//        return site11;
//    }
    public JSONObject createJsonObject()  {
        JSONObject site11=new JSONObject();
        site11.put("engeenirName", site_name);
        site11.put("numOfItem",site_number);
        site11.put("wbs",site_wbs);
        site11.put("money",site_investment);
        site11.put("workYear",site_year);
        site11.put("originalNum", site_origin_order);
        site11.put("companyType", spinner_companyType1);
        site11.put("buildCompany", spinner_buildCompany1);
        site11.put("workCompany", spinner_workCompany1);
        site11.put("isFin", spinner_isFin1);
        JSONObject jsonObject=JSONObject.parseObject(site11.toString());
        System.out.println(site11.toString());
        return jsonObject;
    }

    private void InitSpinner1() {
        spinner_companyType=(Spinner)findViewById(R.id.Spinner_companyType);
        String[] Project_items={"是","否"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Project_items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_companyType.setAdapter(adapter);

    }
}
