package zdfwuy.newproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import zdfwuy.newproject.Analysis_Data.Numerical_analysis;
import zdfwuy.newproject.Analysis_Data.Time_possibility_analysis;
import zdfwuy.newproject.Daily.Daily_Logging;
import zdfwuy.newproject.Daily.Daily_Operation;
import zdfwuy.newproject.Daily.Daily_active_user;
import zdfwuy.newproject.Data_Collection_Total.Data_collection_from;
import zdfwuy.newproject.Iformation.Iformation_biling;
import zdfwuy.newproject.Iformation.Iformation_budget;
import zdfwuy.newproject.Iformation.Iformation_contract;
import zdfwuy.newproject.Iformation.Iformation_costing;
import zdfwuy.newproject.Iformation.Iformation_processing;
import zdfwuy.newproject.Iformation.Iformation_production;
import zdfwuy.newproject.Iformation.Iformation_statistic;
import zdfwuy.newproject.Iformation.Iformation_subcontracting;
import zdfwuy.newproject.Management.Management_Performance;
import zdfwuy.newproject.Management.Management_Subcontract_Type;
import zdfwuy.newproject.Management.Management_Subcontractor;
import zdfwuy.newproject.Management.Management_Type_of_Construction_Unit;
import zdfwuy.newproject.Management.Management_Whether_or_not_code;
import zdfwuy.newproject.Management.Management_of_Construction_Unit;
import zdfwuy.newproject.Notice.Notice_to_manage;
import zdfwuy.newproject.Safeguard.Safeguard_Code_list;
import zdfwuy.newproject.Safeguard.Safeguard_Coding_style;
import zdfwuy.newproject.Safeguard.Safeguard_Managing_people;
import zdfwuy.newproject.Safeguard.Safeguard_division_management;
import zdfwuy.newproject.Tool.MyExtendableListViewAdapter;

public class MainActivity extends Activity {
    private ExpandableListView expandableListView;
    public String[] groupParent={"信息处理","综合查询","分析预警","基础数据","系统维护","系统日志","公告管理"};
    public String[][] groupChild={
            {"公共信息","合同信息","预算信息","生产信息","统计信息","成本信息","结算信息","分包信息"},

            {"汇总信息"},
            {"时间性分析","数据性分析"},
            {"建设单位类型","建设单位管理","分包类型管理","分包单位管理","是否编码管理","履行情况管理"},
            {"部门管理","人员管理","编码列表","编码样式","退出系统"},
            {"操作日志","登录日志","活动用户"},
            {"公告管理"},
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView=(ExpandableListView)findViewById(R.id.expanded_list);
        expandableListView.setAdapter(new MyExtendableListViewAdapter());
        InitfatherListener();
        InitchildListener();
    }

    private void InitchildListener() {
        //设置子项布局监听
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {


                //设置各项数据点击监听
                for (int j=8;i<8;i++){
                    if(i==0){
                        switch (i1){
                            case 0:
                                Intent intent1=new Intent(MainActivity.this,Iformation_processing.class);
                                startActivity(intent1);
                                break;
                            case 1:
                                Intent intent2=new Intent(MainActivity.this,Iformation_contract.class);
                                startActivity(intent2);
                                break;
                            case 2:
                                Intent intent3=new Intent(MainActivity.this,Iformation_budget.class);
                                startActivity(intent3);
                                break;
                            case 3:
                                Intent intent4=new Intent(MainActivity.this,Iformation_production.class);
                                startActivity(intent4);
                                break;
                            case 4:
                                Intent intent5=new Intent(MainActivity.this,Iformation_statistic.class);
                                startActivity(intent5);
                                break;
                            case 5:
                                Intent intent6=new Intent(MainActivity.this,Iformation_costing.class);
                                startActivity(intent6);
                                break;
                            case 6:
                                Intent intent7=new Intent(MainActivity.this,Iformation_biling.class);
                                startActivity(intent7);
                                break;
                            case 7:
                                Intent intent8=new Intent(MainActivity.this,Iformation_subcontracting.class);
                                startActivity(intent8);
                                break;
                            default: Toast.makeText(MainActivity.this,"错误",Toast.LENGTH_SHORT).show();
                                break;
                        }

                        break;
                    }else
                    if(i==1){
                        switch (i1){
                            case 0:Intent intent1=new Intent(MainActivity.this,Data_collection_from.class);
                                startActivity(intent1);
                                break;
                            default: Toast.makeText(MainActivity.this,"错误",Toast.LENGTH_SHORT).show();
                                break;
                        }
                        break;
                    }else if (i==2){
                        switch (i1){
                            case 0:Intent intent1=new Intent(MainActivity.this,Time_possibility_analysis.class);
                                startActivity(intent1);
                                break;
                            case 1:Intent intent2=new Intent(MainActivity.this,Numerical_analysis.class);
                                startActivity(intent2);
                                break;
                            default: Toast.makeText(MainActivity.this,"错误",Toast.LENGTH_SHORT).show();
                                break;
                        }
                        break;
                    }else if (i==3){
                        switch (i1){
                            case 0:
                                Intent intent1=new Intent(MainActivity.this,Management_Type_of_Construction_Unit.class);
                                startActivity(intent1);
                                break;
                            case 1:
                                Intent intent2=new Intent(MainActivity.this,Management_of_Construction_Unit.class);
                                startActivity(intent2);
                                break;
                            case 2:
                                Intent intent3=new Intent(MainActivity.this,Management_Subcontract_Type.class);
                                startActivity(intent3);
                                break;
                            case 3:
                                Intent intent4=new Intent(MainActivity.this,Management_Subcontractor.class);
                                startActivity(intent4);
                                break;
                            case 4:
                                Intent intent5=new Intent(MainActivity.this,Management_Whether_or_not_code.class);
                                startActivity(intent5);
                                break;
                            case 5:
                                Intent intent6=new Intent(MainActivity.this,Management_Performance.class);
                                startActivity(intent6);
                                break;
                            default: Toast.makeText(MainActivity.this,"错误",Toast.LENGTH_SHORT).show();
                                break;
                        }
                        break;
                    }else if (i==4){
                        switch (i1) {
                            case 0:
                                Intent intent1=new Intent(MainActivity.this,Safeguard_division_management.class);
                                startActivity(intent1);
                                break;
                            case 1:
                                Intent intent2=new Intent(MainActivity.this,Safeguard_Managing_people.class);
                                startActivity(intent2);
                                break;
//                            case 2:
//                                Intent intent3=new Intent(MainActivity.this,Safeguard_The_staff_query.class);
//                                startActivity(intent3);
//                                break;
//                            case 3:
//                                Intent intent4=new Intent(MainActivity.this,Safeguard_File_management.class);
//                                startActivity(intent4);
//                                break;
                            case 2:
                                Intent intent5=new Intent(MainActivity.this,Safeguard_Code_list.class);
                                startActivity(intent5);
                                break;
                            case 3:
                                Intent intent6=new Intent(MainActivity.this,Safeguard_Coding_style.class);
                                startActivity(intent6);
                                break;
//                            case 6:
//                                Intent intent7=new Intent(MainActivity.this,Safeguard_Changing_password.class);
//                                startActivity(intent7);
//                                break;
                            case 4:
//                                Intent intent8=new Intent(MainActivity.this,Safeguard_Exit_systems.class);
//                                startActivity(intent8);
                               Intent intent = new Intent(MainActivity.this,Login_Activity.class);
                                startActivity(intent);
                                break;
                            default: Toast.makeText(MainActivity.this,"错误",Toast.LENGTH_SHORT).show();
                                break;
                        }
                        break;
                    }else if (i==5) {
                        switch (i1){
                            case 0:Intent intent1=new Intent(MainActivity.this,Daily_Operation.class);
                                startActivity(intent1);
                                break;
                            case 1:Intent intent2=new Intent(MainActivity.this,Daily_Logging.class);
                            startActivity(intent2);
                            break;
                            case 2:Intent intent3=new Intent(MainActivity.this,Daily_active_user.class);
                                startActivity(intent3);
                                break;
                            default: Toast.makeText(MainActivity.this,"错误",Toast.LENGTH_SHORT).show();
                                break;
                        }
                        break;
                    }else if (i==6){
                        switch (i1){
                            case 0:Intent intent1=new Intent(MainActivity.this,Notice_to_manage.class);
                                startActivity(intent1);
                                break;
                            default: Toast.makeText(MainActivity.this,"错误",Toast.LENGTH_SHORT).show();
                                break;
                        }
                        break;
                    }else {
                        Toast.makeText(MainActivity.this,"错误",Toast.LENGTH_SHORT).show();
                    }
                }
                return true;
            }
        });
    }

    private void InitfatherListener() {
        //设置分组的监听
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {

                return false;
            }
        });
    }
}
