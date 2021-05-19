package zdfwuy.newproject.Management;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
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
import zdfwuy.newproject.data_collection.DatacollectionInfo;
import zdfwuy.newproject.data_management.SubcontractInfo12;
import zdfwuy.newproject.dialog.Mydialog_management.Mydialog_subcontract_management;

public class Management_Subcontract_Type extends Activity {
    ListView listView;
    List<SubcontractInfo12> data=new ArrayList<>();
    DatacollectionInfo datacollection;
    DrawerLayout drawerLayout;

    Mydialog_subcontract_management mydialog;
    Button btn_to_submit,btn_to_cancel;
    EditText Edit_company_year_processing,Edit_the_project_company;
    String Edit_company_year_processing_str,Edit_the_project_company_str;
    String unittype="上市单位";
    String unitname="红岗";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcontract__type_management);
        listView= (ListView) findViewById(R.id.Listview_choose_Type_management);
        get_okhttpclient();
        listView_Onclick();
    }
    private void listView_Onclick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mydialog = new Mydialog_subcontract_management(Management_Subcontract_Type.this, R.style.MyDialog);
                for (int i = 0; i < data.size(); i++) {
                     /*EditText_engineerprogram_production,Editext_pijianhao,Edit_investment_money,Edit_orginal_pijianhao,Edit_production_engineerTime,
            Edit_production_contractNum,Edit_production_startday,Edit_production_endday,Edit_production_signDate,Edit_production_performance;
*/
                    if (i == position) {
                        mydialog.setPid(data.get(i).getPid().toString());
                        mydialog.setEditText_rankNum_str(data.get(i).getRankNum());
                        mydialog.setEditext_subcontractName_str(data.get(i).getSubcontractName());
                        mydialog.setEdit_remarks_str(data.get(i).getRemarks());
                        mydialog.setEdit_isUsed_str(data.get(i).getIsUsed());

                    }
                }
                mydialog.setYesOnclickListener("确定", new Mydialog_subcontract_management.onYesOnclickListener() {
                    @Override
                    public void onYesOnclick() {
                        mydialog.SetEditTextENeditable();
                        mydialog.setYesOnclickListener("确定", new Mydialog_subcontract_management.onYesOnclickListener() {
                            @Override
                            public void onYesOnclick() {
                                postOkhttp3();
                                mydialog.dismiss();

                            }
                        });
                    }
                });
                mydialog.setNoOnclickListener("取消", new Mydialog_subcontract_management.onNoOnclickListener() {
                    @Override
                    public void onNoOnclick() {
                        mydialog.dismiss();
                    }
                });
                mydialog.show();
            }

            private void postOkhttp3() {
                OkHttpClient okHttpClient = new OkHttpClient();
                MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
                RequestBody requestBody = FormBody.create(mediaType, creatjson().toString());
                final Request Request = new Request.Builder()
                        .url("http://123.56.106.24:8081/subtypemanage/save")
                        .post(requestBody)
                        .build();
                Call call = okHttpClient.newCall(Request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String res = response.body().string();
                        JSONObject jsonobject = JSON.parseObject(res);
                        final int status = (int) jsonobject.get("status");
                        System.out.println("********测试!!");
                        System.out.println(mydialog.getPid());
                        System.out.println(status);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (status == 1) {
                                    Toast.makeText(Management_Subcontract_Type.this, "修改成功！", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(Management_Subcontract_Type.this, "修改失败！", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                    }
                });
            }

            private JSONObject creatjson() {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("pid", mydialog.getPid());
                jsonObject.put("isUsed", mydialog.getEdit_isUsed_str());
                jsonObject.put("rankNum", mydialog.getEditText_rankNum_str());
                jsonObject.put("subcontractName", mydialog.getEditext_subcontractName_str());
                jsonObject.put("remarks", mydialog.getEdit_remarks_str());


                JSONObject jsonObject1 = JSONObject.parseObject(jsonObject.toString());
                return jsonObject1;
            }
        });
    }
    private void get_okhttpclient( ) {
        OkHttpClient okhttp3=new OkHttpClient();
        final Request request=new Request.Builder()
                .url("http://123.56.106.24:8081/subtypemanage/get")
                .get()
                .build();
        Call call=okhttp3.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                data.clear();
                String res = response.body().string();
                JSONArray jsonarray = JSON.parseArray(res);
                System.out.println(jsonarray);
                for (int i = 0; i < jsonarray.size(); i++) {
                    JSONObject j = (JSONObject) jsonarray.get(i);
                    Integer pid = (Integer) j.get("pid");
                    System.out.println(pid);

                    String rankNum = j.getString("rankNum");
                    String subcontractName = j.getString("subcontractName");
                    String remarks = j.getString("remarks");


                    String isUsed = j.getString("isUsed");


                    ShowResult(pid, rankNum, subcontractName, remarks, isUsed);
                }
            }
        });
    }

    private void ShowResult(final Integer pid, final String rankNum, final String subcontractName, final String remarks, final String isUsed) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                SubcontractInfo12 construct = new SubcontractInfo12();
                construct.setPid(pid);
                construct.setRankNum(rankNum);
                construct.setSubcontractName(subcontractName);
                construct.setRemarks(remarks);
                construct.setIsUsed(isUsed);

                data.add(construct);
                listView.setAdapter(new Myadapter());
            }
        });

    }
    private class Myadapter extends BaseAdapter {
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

            View view=View.inflate(Management_Subcontract_Type.this,R.layout.layout_listview_items,null);
            TextView tv_id= (TextView) view.findViewById(R.id.TV_listTitle_Id);
            TextView tv_title= (TextView) view.findViewById(R.id.TV_listTime_Id);
            TextView tvContext = (TextView) view.findViewById(R.id.TV_listContext_Id);

            tv_id.setText(data.get(position).getPid()+"");
            String name = data.get(position).getSubcontractName();
            if(name.length() > 12) {
                name = name.substring(0,12) + "...";
            }
            tv_title.setText(name);
            tvContext.setText(data.get(position).getRankNum());
            return view;
        }
    }
}
