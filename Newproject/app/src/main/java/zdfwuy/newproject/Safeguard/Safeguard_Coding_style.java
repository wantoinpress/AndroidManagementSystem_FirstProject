package zdfwuy.newproject.Safeguard;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import zdfwuy.newproject.Iformation.Iformation_contract_add;
import zdfwuy.newproject.R;
import zdfwuy.newproject.data_collection.DatacollectionInfo;
import zdfwuy.newproject.data_safeguard.CodingStyleInfo;
import zdfwuy.newproject.dialog.Mydialog_safeguard.Mydialog_code_list_safeguard;

public class Safeguard_Coding_style extends Activity {
    ListView listView;
    List<CodingStyleInfo> data=new ArrayList<>();
    DatacollectionInfo datacollection;
    DrawerLayout drawerLayout;

    Mydialog_code_list_safeguard mydialog;
    Button btn_to_submit,btn_to_cancel;
    EditText Edit_company_year_processing,Edit_the_project_company;
    String Edit_company_year_processing_str,Edit_the_project_company_str;
    String company="表单目录";
    String isfin="是";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safeguard__coding_style);
        drawerLayout = (DrawerLayout) findViewById(R.id.dlShow );
        Edit_the_project_company= (EditText) findViewById(R.id.Edit_the_project_company);
        listView = (ListView) findViewById(R.id.Listview_choose_Iformation_statistic);
        btn_setOnclick();
        getOkhttp3(company);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                Intent intent=new Intent(Safeguard_Coding_style.this,Iformation_contract_add.class);
                startActivity(intent);
                break;
            case R.id.Search_one:
                drawerLayout.openDrawer(Gravity.END);

                Edit_the_project_company.setText("全部");
            default:break;
        }
        return true;
    }
    private void btn_setOnclick() {

        btn_to_submit= (Button) findViewById(R.id.btn_to_submit);
        btn_to_cancel= (Button) findViewById(R.id.btn_to_cancel);

        btn_to_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_the_project_company_str = Edit_the_project_company.getText().toString();
                Edit_company_year_processing_str = Edit_company_year_processing.getText().toString();

                int year = Integer.parseInt(Edit_company_year_processing_str);
                getOkhttp3(Edit_the_project_company_str);

                drawerLayout.closeDrawers();
            }
        });

        btn_to_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });

    }
    private void getOkhttp3(String companyname) {
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/codestyle/get?codestyle="+companyname)
                .get()
                .build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                data.clear();
                String res = response.body().string();
                JSONArray jsonArray = JSON.parseArray(res);
                System.out.println(jsonArray.toString());
                for (int i = 0; i < jsonArray.size(); i++) {
                    CodingStyleInfo c = new CodingStyleInfo();
                    JSONObject j = (JSONObject) jsonArray.get(i);


                    /*Integer pid ;
           String  columnField;
           String  columnTitle;
//            columnWidth
           String  alignment;
            String dataType;
            String isSeen;
            String isLock;
            String isEdit;
            String checkBox;
            String selectCondition;
//             conditionWidth
            String listSetences;
            String codeName;*/
                    c.setPid((Integer) j.get("pid"));
                    c.setColumnField(j.getString("columnField"));
                    c.setColumnTitle(j.getString("columnTitle"));
                    c.setAlignment(j.getString("alignment"));
                    c.setDataType(j.getString("dataType"));

                    c.setIsSeen(j.getString("isSeen"));
                    c.setIsLock(j.getString("isLock"));
                    c.setIsEdit(j.getString("isEdit"));
                    c.setCheckBox(j.getString("checkBox"));

                    c.setSelectCondition(j.getString("selectCondition"));
                    c.setListSetences(j.getString("listSetences"));
                    c.setCodeName(j.getString("codeName"));



                    showresult(c);
                }
            }


        });
    }

    private void showresult(final CodingStyleInfo c) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                data.add(c);
                listView.setAdapter(new MylistviewAdapter());
            }
        });
    }
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

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(Safeguard_Coding_style.this, R.layout.layout_listview_items, null);
            TextView textView1 = (TextView) view.findViewById(R.id.text_pijianhao);
            TextView tvTitle = (TextView) view.findViewById(R.id.TV_listTitle_Id);
            TextView tvTime = (TextView) view.findViewById(R.id.TV_listTime_Id);
            TextView tvContext = (TextView) view.findViewById(R.id.TV_listContext_Id);
            String name = data.get(position).getCodeName();
            textView1.setText("数据类型:");

            if(name.length() > 12) {
                name = name.substring(0,12) + "...";
            }
            tvTime.setText(name);
            tvTitle.setText(data.get(position).getPid()+"");
            tvContext.setText(data.get(position).getDataType());
            return view;
        }
    }
}
