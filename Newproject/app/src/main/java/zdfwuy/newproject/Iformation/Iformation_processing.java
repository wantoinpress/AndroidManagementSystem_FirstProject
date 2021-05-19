package zdfwuy.newproject.Iformation;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
import zdfwuy.newproject.dialog.Mydialog;
import zdfwuy.newproject.R;
import zdfwuy.newproject.data.PublicInfo;
import zdfwuy.newproject.getpid.togetpid;

public class Iformation_processing extends Activity{
    Intent intent;
    togetpid togetpid;
    PublicInfo publicInfo;
    Bundle bundle;
    List<PublicInfo> data = new ArrayList<>();
    String result,res,engeenirName,companyType,buildCompany,pid;
    LinearLayout linearLayout;
    Spinner Spinner_buildCompany,Spinner_CompanyType,Spinner_workCompany_dialog,Spinner_isFin_dialog;
    ListView listView;
    Mydialog mydialog;
    DrawerLayout drawerLayout;
    EditText Edit_the_project_company,Edit_the_project_year;

    Button button,button1;
    String Edit_project_name="全部",String_Edit_project_name,String_Edit_the_project_year_ = "0";
    int year=0;
    Integer project_year;
    EditText EditText_engineerprogram,Editext_pijianhao,Edit_wbs_dialog,Edit_investment_money,Edit_project_year,Edit_orginal_pijianhao;
    /*创建所需drawlayout数组*/
    private String[] mybrand=new String[]{"1","2","3","4","5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rightplay_test_processing);
        project_year=new Integer(year);
        drawerLayout= (DrawerLayout) findViewById(R.id.dlShow);
        Edit_the_project_year= (EditText) findViewById(R.id.Edit_company_year_processing);
        Edit_the_project_company= (EditText) findViewById(R.id.Edit_the_project_company);
        listView=(ListView)findViewById(R.id.Listview_choose);
        /*设立侧滑按钮的点击事件*/
        btn_onclick_thing();
        /*创建上下文菜单*/
        registerForContextMenu(listView);
        /*设置Listview的点击事件*/
        ListViewOnClick();
        /*设置获取后端的数据*/
        get_okhttpclient(Edit_project_name,year);
        /*设立EditText的数值*/
//        setEditText();
//        GetAddInformation();//获取 添加 信息
        /*绘制表格*/
//        linearLayout=(LinearLayout)findViewById(R.id.table_processing);
//        horizontalScrollView=(HorizontalScrollView)findViewById(R.id.HorizontalScrollView_processing);
//        DescripeTableTile();//画标题
//        DescripeTable();//画表格
    }

    private void btn_onclick_thing() {
        button= (Button) findViewById(R.id.btn_to_cancel);
        button1= (Button) findViewById(R.id.btn_to_submit);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String_Edit_project_name=Edit_the_project_company.getText().toString().equals("") ? "全部" : Edit_the_project_company.getText().toString();
                String_Edit_the_project_year_=Edit_the_project_year.getText().toString().equals("") ? "0" : Edit_the_project_year.getText().toString();
                int project_year=Integer.parseInt(String_Edit_the_project_year_);

                get_okhttpclient(Edit_project_name, project_year);


//                Integer project_new_year=new Integer(project_year);

                drawerLayout.closeDrawers();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });
    }

    /*上下文菜单的处理*/
   @Override
     public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater=new MenuInflater(this);
        menuInflater.inflate(R.menu.context_menu,menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.context_menu_delete:
                Toast.makeText(Iformation_processing.this,"删除"+info.position,Toast.LENGTH_SHORT).show();
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("pid", data.get(info.position).getPid());
                JSONObject jsonObject1=JSONObject.parseObject(jsonObject.toString());
                //创建链接
                OkHttpClient okHttpClient=new OkHttpClient();
                MediaType mediaType=MediaType.parse("application/json; charset=utf-8");
                RequestBody requestBody=FormBody.create(mediaType, jsonObject.toString());
                Request request=new Request.Builder()
                        .url("http://123.56.106.24:8081/delete/"+data.get(info.position).getPid())
                        .post(requestBody)
                        .build();
                Call call=okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        data.remove(info.position);
                        String result=response.body().string();
                        JSONObject res=JSON.parseObject(result);
                        final int status=(int)res.get("status");
                        System.out.println(status);
                        runOnUiThread(new Runnable() {
                            @Override
                           /* *//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**
                             * 实时更新，数据库信息改变时，客户端内容发生改变
                             *//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**/
                            public void run() {

                                listView.setAdapter(new MylistviewAdapter());
                                if (status==1){

                                    Toast.makeText(Iformation_processing.this, "删除成功！", Toast.LENGTH_SHORT).show();

                                }else {
                                    Toast.makeText(Iformation_processing.this, "删除失败！", Toast.LENGTH_SHORT).show();
                                }
                        listView.setAdapter(new MylistviewAdapter());
                            }
                        });
                    }
                });
                break;

            default:break;
        }
        return true;
    }




    private void get_okhttpclient(String companyname,int years) {
        System.out.println("******1231213132*****");
        System.out.println(companyname);
        System.out.println(years);
        OkHttpClient okhtttpclient=new OkHttpClient();
        final Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/produce/get?year=" + years + "&workcompany=" + companyname)
                .get()
                .build();
        Call call=okhtttpclient.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Iformation_processing.this, "服务器连接失败！", Toast.LENGTH_SHORT).show();
                    }
                });
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                /*获取response中的数据,并且转换字符串*/
                data.clear();
                result = response.body().string();
                JSONArray jsonArray = JSON.parseArray(result);
                System.out.println(jsonArray.toString());
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject j = (JSONObject) jsonArray.get(i);


                    /*获取各组数据段*/

                    Object i1 = jsonArray.size();
                    Integer pid = (Integer) j.get("pid");

                    System.out.println(pid);
                    String engeenirName = j.getString("engeenirName");
                    String companyType = j.getString("companyType");
                    String buildCompany = j.getString("buildCompany");
                    String numOfItem = j.getString("numOfItem");
                    String wbs = j.getString("wbs");
                    BigDecimal money = (BigDecimal) j.get("money");
                    String workCompany = j.getString("workCompany");
                    Integer workYear = (Integer) j.get("workYear");
                    String isFin = j.getString("isFin");
                    String originalNum = j.getString("originalNum");


                    ShowRequetResult(pid, engeenirName, companyType, buildCompany, numOfItem, wbs, money, workCompany, workYear, isFin, originalNum, i1);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
                }
//                pid=jsonObject.getString("pid");
////                Log.d("aa",pid);
//
//                engeenirName=jsonObject.getString("engeenirName");
////                Log.d("aa",engeenirName);
//                /*打印出所需数据*/
//                companyType=jsonObject.getString("companyType");
////                Log.d("aa", companyType);


            }
        });
    }

    private void ShowRequetResult(final Integer pid,final String engeenirName,final String companyType,final String buildCompany,final String numOfItem,final String wbs,final BigDecimal money,final String workCompany,final  Integer workYear,final String isFin,final String originalNum,final Object i1) {

        System.out.println("**********");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                publicInfo = new PublicInfo();
                publicInfo.setPid(pid);
                publicInfo.setEngeenirName(engeenirName);
                publicInfo.setCompanyType(companyType);
                publicInfo.setBuildCompany(buildCompany);
                publicInfo.setNumOfItem(numOfItem);
                publicInfo.setWbs(wbs);
                publicInfo.setMoney(money);
                publicInfo.setWorkCompany(workCompany);
                publicInfo.setWorkYear(workYear);
                publicInfo.setIsFin(isFin);
                publicInfo.setOriginalNum(originalNum);
                System.out.println("**********");
                System.out.println(publicInfo.getPid());
                data.add(publicInfo);
                Iformation_processing iformation_processing = new Iformation_processing();
                listView.setAdapter(new MylistviewAdapter());


            }
        });
    }

    private void ListViewOnClick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mydialog=new Mydialog(Iformation_processing.this,R.style.MyDialog);
                System.out.println("****123355**");
                System.out.println(data.get(0).getPid());
                String data1=data.get(0).getEngeenirName();
                for (int i=0;i<data.size();i++){

                        if(i==position) {
        /*Editext_CompanyType,Editext_buildCompany,Edit_workCompany,Edit_isFin_dialog*/
                            String name = data.get(i).getEngeenirName();
                            if(name.length() > 8) {
                                name = name.substring(8) + "...";
                            }
                            mydialog.setEditext_buildCompany_str(data.get(i).getBuildCompany());
                            mydialog.setEdit_workCompany_str(data.get(i).getWorkCompany());
                            mydialog.setEdit_isFin_dialog_str(data.get(i).getIsFin());
                            mydialog.setEditext_CompanyType_str(data.get(i).getCompanyType());
                            mydialog.setPid(data.get(i).getPid().toString());
                            mydialog.setEditText_engineerprogram(data.get(i).getEngeenirName());
                            mydialog.setEditext_pijianhaostr(data.get(i).getNumOfItem());
                            mydialog.setEdit_wbs_dialogstr(data.get(i).getWbs());
                            mydialog.setEdit_investment_moneystr(data.get(i).getMoney().toString());
                            mydialog.setEdit_project_yearstr(data.get(i).getWorkYear().toString());
                            mydialog.setEdit_orginal_pijianhaostr(data.get(i).getOriginalNum());
                        }
//                    switch (position){
//                        case 0:
//                            int a=data.get(0).getPid().intValue();
//                            if (a==22){
//                                mydialog.setEditText_engineerprogram(data.get(0).getEngeenirName());
//                                mydialog.setEditext_pijianhaostr(data.get(0).getNumOfItem());
//                                mydialog.setEdit_wbs_dialogstr(data.get(0).getWbs());
//                                mydialog.setEdit_investment_moneystr(data.get(0).getMoney().toString());
//                                mydialog.setEdit_project_yearstr(data.get(0).getWorkYear().toString());
//                                mydialog.setEdit_orginal_pijianhaostr(data.get(0).getOriginalNum());
//                            };
//                            break;
//                        default:
//                            System.out.println("****");
//                            break;
//                    }
                }



                mydialog.setYesOnclickListener("修改", new Mydialog.onYesOnclickListener() {
                    @Override
                    public void onYesOnclick() {
                        mydialog.SetEditTextENeditable();

                       mydialog.setYesOnclickListener("确定", new Mydialog.onYesOnclickListener() {
                           @Override
                           public void onYesOnclick() {
                               mydialog.setYesStr("确定");
                               mydialog.dismiss();

                               postokHttpClient();
                           }
                       });

                    }



                });
                mydialog.setNoOnclickListener("取消", new Mydialog.onNoOnclickListener() {
                    @Override
                    public void onNoClick() {
                        mydialog.dismiss();
                    }
                });
                mydialog.show();


            }

            private void postokHttpClient() {
                OkHttpClient okHttpClient=new OkHttpClient();
                MediaType mediaType=MediaType.parse("application/json; charset=utf-8");
                RequestBody requestBody= FormBody.create(mediaType, createJsonString().toString());
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
                                Toast.makeText(Iformation_processing.this, "修改失败！", Toast.LENGTH_SHORT).show();
                            }
                        });
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
//                        listView.setAdapter(new MylistviewAdapter());
                        String result=response.body().string();
                        JSONObject res=JSON.parseObject(result);
                        final int status=(int)res.get("status");
                        System.out.println(status);
                        runOnUiThread(new Runnable() {
                            @Override
                            /**
                             * 实时更新，数据库信息改变时，客户端内容发生改变
                             */
                            public void run() {
                                if (status==1){
                                    Toast.makeText(Iformation_processing.this, "修改成功！", Toast.LENGTH_SHORT).show();
                                    get_okhttpclient(Edit_project_name,year);
                                }else {
                                    Toast.makeText(Iformation_processing.this, "修改失败！", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
                    }
                });
            }

            private JSONObject createJsonString() {
                /*Editext_CompanyType,Editext_buildCompany,Edit_workCompany,Edit_isFin_dialog*/
                JSONObject jsonObject=new JSONObject();

                Integer pid = Integer.parseInt(mydialog.getPid());
                jsonObject.put("pid",pid);
                jsonObject.put("companyType",mydialog.getEditext_CompanyType_str());
                jsonObject.put("buildCompany",mydialog.getEditext_buildCompany_str());
                jsonObject.put("workCompany",mydialog.getEdit_workCompany_str());
                jsonObject.put("isFin",mydialog.getEdit_isFin_dialog_str());

                jsonObject.put("pid",mydialog.getPid());
                jsonObject.put("money", mydialog.getEdit_investment_moneystr());
                jsonObject.put("engeenirName",mydialog.getEditText_engineerprogramstr());
                jsonObject.put("numOfItem",mydialog.getEditext_pijianhaostr());
                jsonObject.put("wbs",mydialog.getEdit_wbs_dialogstr());
                jsonObject.put("workYear",mydialog.getEdit_project_yearstr());
                jsonObject.put("originalNum",mydialog.getEdit_orginal_pijianhaostr());
                JSONObject jsonObject1=JSONObject.parseObject(jsonObject.toString());
                System.out.println(jsonObject1.toString());
                return jsonObject1;
            }


        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });
    }


//    private void DescripeTableTile() {
//        for (int i=0;i<1;i++)
//        {//表格有1行
//            LinearLayout varlayout=new LinearLayout(this);
//            varlayout.setOrientation(LinearLayout.HORIZONTAL);
//            //线性布局来画每一行
//
//            for (int j=0;j<7;j++){
//                TextView textView=new TextView(this);
//                switch (j){
//                    case 0:textView.setText("序号");
//                        textView.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
//                        break;
//                    case 1:textView.setText("工程项目名称");
//                        textView.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 2.0f));
//                        break;
//                    case 2:textView.setText("批件号");
//                        textView.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.1f));
//                        break;
//                    case 3:textView.setText("施工单位");
//                        textView.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.5f));
//                        break;
//                    case 4:textView.setText("投资总额(万元)");
//                        textView.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 2.3f));
//                        break;
//                    case 5:textView.setText("工程年份(年)");
//                        textView.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 2.0f));
//                        break;
//                    case 6:textView.setText("是否结转工程");
//                        textView.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 2.0f));
//                        break;
//                    default:
//                        break;
//                }
//                //表格有四列
//
//
//                //设置Textview宽为0，高为不确定，Layout_weight为1
//
//                textView.setSingleLine(true);
//                textView.setTextSize(12);
//                textView.setBackgroundColor(textView.getResources().getColor(R.color.table_reit));
//                textView.setPadding(5, 5, 5, 5);
//                textView.isFocusable();
////                textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
//                textView.setGravity(Gravity.CENTER);
//                varlayout.addView(textView);
////                horizontalScrollView.addView(textView);
//                //画表格竖线
//                TextView reit=new TextView(this);
//                //设置Textview宽为2dp，高为不确定
//                reit.setLayoutParams(new LinearLayout.LayoutParams(2,LinearLayout.LayoutParams.WRAP_CONTENT));
//                reit.setBackgroundColor(reit.getResources().getColor(R.color.table_line));
//                varlayout.addView(reit);
//            }
//            //用来设置横线
//            TextView reit1=new TextView(this);
//            reit1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2));
//            reit1.setBackgroundColor(reit1.getResources().getColor(R.color.table_line));
//            linearLayout.addView(reit1);
//            linearLayout.addView(varlayout, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//
//
//        }
//    }
//    private void DescripeTable() {
//       //表格有1行
//            LinearLayout varlayout=new LinearLayout(this);
//            varlayout.setOrientation(LinearLayout.HORIZONTAL);
//            //线性布局来画每一行
//
//            for (int j=0;j<7;j++){
//                TextView textView=new TextView(this);
//                switch (j){
//                    case 0:textView.setText("1001");
//                        textView.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
//                        break;
//                    case 1:textView.setText("未知的项目");
//                        textView.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 2.0f));
//                        break;
//                    case 2:textView.setText("f1001");
//                        textView.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.1f));
//                        break;
//                    case 3:textView.setText("小力量");
//                        textView.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.5f));
//                        break;
//                    case 4:textView.setText("15");
//                        textView.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 2.3f));
//                        break;
//                    case 5:textView.setText("321");
//                        textView.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 2.0f));
//                        break;
//                    case 6:textView.setText("是");
//                        textView.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 2.0f));
//                        break;
//                    default:
//                        break;
//                }
//                //表格有四列
//
//
//                //设置Textview宽为0，高为不确定，Layout_weight为1
//
//                textView.setSingleLine(true);
//                textView.setTextSize(12);
////                textView.setBackgroundColor(textView.getResources().getColor(R.color.table_reit));
//                textView.setPadding(5, 5, 5, 5);
//                textView.isFocusable();
////                textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
//                textView.setGravity(Gravity.CENTER);
//                varlayout.addView(textView);
//
//
////                horizontalScrollView.addView(textView);
//
//                //画表格竖线
//                TextView reit=new TextView(this);
//                //设置Textview宽为2dp，高为不确定
//                reit.setLayoutParams(new LinearLayout.LayoutParams(2,LinearLayout.LayoutParams.WRAP_CONTENT));
//                reit.setBackgroundColor(reit.getResources().getColor(R.color.table_line));
//                varlayout.addView(reit);
//            }
//            //用来设置横线
//            TextView reit1=new TextView(this);
//            reit1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2));
//            reit1.setBackgroundColor(reit1.getResources().getColor(R.color.table_line));
//            linearLayout.addView(reit1);
//            linearLayout.addView(varlayout, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//
//
//
//    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.add:
                Intent intent=new Intent(Iformation_processing.this,Iformation_processing_add.class);
                startActivity(intent);
                break;
            case R.id.Search_one:
                drawerLayout.openDrawer(Gravity.END);
                break;
            default:break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater(); //实例化一个对象
        menuInflater.inflate(R.menu.menu,menu); //解析菜单文件
        return super.onCreateOptionsMenu(menu);

    }

//    private void GetAddInformation() {
//        intent=getIntent();
//        bundle=intent.getExtras();
//        String site1=bundle.getString("name");
//        String site2=bundle.getString("number");
//        String site3=bundle.getString("Construction");
//        String site4=bundle.getString("Invesment");
//        String site5=bundle.getString("Year");
//        String site6=bundle.getString("Spinner");
//
//        Toast.makeText(Iformation_processing.this,site1,Toast.LENGTH_SHORT).show();
//    }

    private class MylistviewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        //写一个静态的class,把layout_list_item的控件转移过来使用
//        static class ViewHolder{
//            //声明引用
//
//            public TextView tvTitle,tvTime,tvContext;
//        }
        //重要的方法
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
//        //实例化ViewHolder
//        ViewHolder holder = null;
//        //如果视图为空
//        if (convertView == null){
//            //此处需要导入包，填写ListView的图标和标题等控件的来源，来自于layout_list_item这个布局文件
//            convertView = mLayoutInflater.inflate(R.layout.layout_listview_items,null);
//            //生成一个ViewHolder的对象
//            holder = new ViewHolder();
//            //把layout_list_item对象转移过来，以便修改和赋值
//
//
//            holder.tvTitle= (TextView) convertView.findViewById(R.id.TV_listTitle_Id);
//            holder.tvTime = (TextView) convertView.findViewById(R.id.TV_listTime_Id);
//            holder.tvContext= (TextView) convertView.findViewById(R.id.TV_listContext_Id);
//
////            holder.tvTitle.setText(publicInfo.getPid().toString());
//
//            //把这个holder传递进去
//            convertView.setTag(holder);
//        }else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//        //给控件赋值
//        holder.tvTitle.setText(data.get(position).getPid());
////        holder.tvTime.setText("2099-09-09！");
////        holder.tvContext.setText("显示内容！");
//        return convertView;

            View view = View.inflate(Iformation_processing.this, R.layout.layout_listview_items, null);


            TextView tvTitle = (TextView) view.findViewById(R.id.TV_listTitle_Id);
            TextView tvTime = (TextView) view.findViewById(R.id.TV_listTime_Id);
            TextView tvContext = (TextView) view.findViewById(R.id.TV_listContext_Id);

//           Button select=view.findViewById(R.id.select);
//
//            select.setOnClickListener((View.OnClickListener) this);

//            EditText_engineerprogram.setText(data.get(position).getCompanyType());
            tvTitle.setText(data.get(position).getPid() + " ");
            String name = data.get(position).getEngeenirName();
            if(name.length() > 12) {
                name = name.substring(0,12) + "...";
            }
            tvTime.setText(name);
            tvContext.setText(data.get(position).getNumOfItem());


            return view;
        }


    }
//    public Integer getdataPid(Integer Pid){
//        Integer pid=Pid;
//        return pid;
//    }
}
