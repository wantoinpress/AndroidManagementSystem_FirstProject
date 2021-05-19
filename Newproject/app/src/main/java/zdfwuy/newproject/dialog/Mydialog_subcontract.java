package zdfwuy.newproject.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import zdfwuy.newproject.R;

public class Mydialog_subcontract extends Dialog {


    private Button yes;//确定按钮
    private Button no;//取消按钮
    private TextView titleTV;//消息标题文本
    private TextView message;//消息提示文本
    private String titleStr;//从外界设置的title文本
    private String messageStr;//从外界设置的消息文本
    //确定文本和取消文本的显示的内容
    private String yesStr, noStr;
    private onNoOnclickListener noOnclickListener;//取消按钮被点击了的监听器
    private onYesOnclickListener yesOnclickListener;


    EditText EditText_engineerprogram_production,Editext_pijianhao,Edit_egineertime,Edit_wbs,
            Edit_subcontractNo,Edit_subcontractor,Edit_subcontractContent,Edit_subcontractingType,
            Edit_startDate,Edit_endDate,Edit_contractMoney,Edit_performance,Edit_erpservicePurchaseOrderNumber,
            Edit_app,Edit_aabss,Edit_saoss;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    private  String pid;
    private    String EditText_engineerprogram_production_str;
    private    String Editext_pijianhao_str;
    private    String Edit_egineertime_str;
    private   String Edit_wbs_str;
    private   String Edit_subcontractNo_str;
    private   String Edit_subcontractor_str;
    private   String Edit_subcontractContent_str;
    private   String Edit_subcontractingType_str;
    private   String Edit_startDate_str;
    private   String Edit_endDate_str;
    private   String Edit_contractMoney_str;
    private   String Edit_performance_str;
    private   String Edit_erpservicePurchaseOrderNumber_str;
    private   String Edit_app_str;
    private   String Edit_aabss_str;

    public void setEdit_saoss_str(String edit_saoss_str) {
        Edit_saoss_str = edit_saoss_str;
    }

    public void setEditText_engineerprogram_production_str(String editText_engineerprogram_production_str) {
        EditText_engineerprogram_production_str = editText_engineerprogram_production_str;
    }

    public void setEditext_pijianhao_str(String editext_pijianhao_str) {
        Editext_pijianhao_str = editext_pijianhao_str;
    }

    public void setEdit_egineertime_str(String edit_egineertime_str) {
        Edit_egineertime_str = edit_egineertime_str;
    }

    public void setEdit_wbs_str(String edit_wbs_str) {
        Edit_wbs_str = edit_wbs_str;
    }

    public void setEdit_subcontractNo_str(String edit_subcontractNo_str) {
        Edit_subcontractNo_str = edit_subcontractNo_str;
    }

    public void setEdit_subcontractor_str(String edit_subcontractor_str) {
        Edit_subcontractor_str = edit_subcontractor_str;
    }

    public void setEdit_subcontractContent_str(String edit_subcontractContent_str) {
        Edit_subcontractContent_str = edit_subcontractContent_str;
    }

    public void setEdit_subcontractingType_str(String edit_subcontractingType_str) {
        Edit_subcontractingType_str = edit_subcontractingType_str;
    }

    public void setEdit_startDate_str(String edit_startDate_str) {
        Edit_startDate_str = edit_startDate_str;
    }

    public void setEdit_endDate_str(String edit_endDate_str) {
        Edit_endDate_str = edit_endDate_str;
    }

    public void setEdit_contractMoney_str(String edit_contractMoney_str) {
        Edit_contractMoney_str = edit_contractMoney_str;
    }

    public void setEdit_performance_str(String edit_performance_str) {
        Edit_performance_str = edit_performance_str;
    }

    public void setEdit_erpservicePurchaseOrderNumber_str(String edit_erpservicePurchaseOrderNumber_str) {
        Edit_erpservicePurchaseOrderNumber_str = edit_erpservicePurchaseOrderNumber_str;
    }

    public void setEdit_app_str(String edit_app_str) {
        Edit_app_str = edit_app_str;
    }

    public void setEdit_aabss_str(String edit_aabss_str) {
        Edit_aabss_str = edit_aabss_str;
    }

    public void setNoStr(String noStr) {
        this.noStr = noStr;
    }

    public void setYesStr(String yesStr) {
        this.yesStr = yesStr;
    }

    public String getEdit_saoss_str() {
        return Edit_saoss_str;
    }

    public String getEditText_engineerprogram_production_str() {
        return EditText_engineerprogram_production_str;
    }

    public String getEditext_pijianhao_str() {
        return Editext_pijianhao_str;
    }

    public String getEdit_egineertime_str() {
        return Edit_egineertime_str;
    }

    public String getEdit_wbs_str() {
        return Edit_wbs_str;
    }

    public String getEdit_subcontractNo_str() {
        return Edit_subcontractNo_str;
    }

    public String getEdit_subcontractor_str() {
        return Edit_subcontractor_str;
    }

    public String getEdit_subcontractContent_str() {
        return Edit_subcontractContent_str;
    }

    public String getEdit_subcontractingType_str() {
        return Edit_subcontractingType_str;
    }

    public String getEdit_startDate_str() {
        return Edit_startDate_str;
    }

    public String getEdit_endDate_str() {
        return Edit_endDate_str;
    }

    public String getEdit_contractMoney_str() {
        return Edit_contractMoney_str;
    }

    public String getEdit_performance_str() {
        return Edit_performance_str;
    }

    public String getEdit_erpservicePurchaseOrderNumber_str() {
        return Edit_erpservicePurchaseOrderNumber_str;
    }

    public String getEdit_app_str() {
        return Edit_app_str;
    }

    public String getEdit_aabss_str() {
        return Edit_aabss_str;
    }

    public String getNoStr() {
        return noStr;
    }

    public String getYesStr() {
        return yesStr;
    }

    String Edit_saoss_str;

    public Mydialog_subcontract(@NonNull Context context,@StyleRes int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydialog_subcontract);
        InitView();

        initView();

        initData();

        SetEditTextnotENeditable();
    }

    public  interface   onYesOnclickListener{
        public void onyesonclick();
    }
    public  interface onNoOnclickListener{
        public void onnoonclick();
    }

    public  void setYesOnclickListener(String res,onYesOnclickListener onYesOnclickListener1){
        if(res!=null){
            this.yesStr=res;
        }
        this.yesOnclickListener=onYesOnclickListener1;
    }

    public  void setNoOnclickListener(String res ,onNoOnclickListener onNoOnclickListener1){
        if(res!=null){
            this.noStr=res;
        }
        this.noOnclickListener=onNoOnclickListener1;
    }

    public  void   InitView(){
        yes= (Button) findViewById(R.id.yes_production);
        no= (Button) findViewById(R.id.no_produtions);
        titleTV= (TextView) findViewById(R.id.title_production);
        message= (TextView) findViewById(R.id.Text_engeenirName_production);

        /*EditText_engineerprogram_production,Editext_pijianhao,Edit_egineertime,Edit_wbs,
            Edit_subcontractNo,Edit_subcontractor,Edit_subcontractContent,Edit_subcontractingType,
            Edit_startDate,Edit_endDate,Edit_contractMoney,Edit_performance,Edit_erpservicePurchaseOrderNumber,
            Edit_app,Edit_aabss,Edit_saoss;*/


        EditText_engineerprogram_production= (EditText) findViewById(R.id.EditText_engineerprogram_production);
        Editext_pijianhao= (EditText) findViewById(R.id.Editext_pijianhao);
        Edit_egineertime= (EditText) findViewById(R.id.Edit_egineertime);
        Edit_wbs= (EditText) findViewById(R.id.Edit_wbs);
//        workUnit= (EditText) findViewById(R.id.Spinner_workCompany_dialog);
        Edit_subcontractNo= (EditText) findViewById(R.id.Edit_subcontractNo);
        Edit_subcontractor= (EditText) findViewById(R.id.Edit_subcontractor);
        Edit_subcontractContent= (EditText) findViewById(R.id.Edit_subcontractContent);
        Edit_subcontractingType= (EditText) findViewById(R.id.Edit_subcontractingType);
        Edit_startDate= (EditText) findViewById(R.id.Edit_startDate);
        Edit_endDate= (EditText) findViewById(R.id.Edit_endDate);
        Edit_contractMoney= (EditText) findViewById(R.id.Edit_contractMoney);
        Edit_performance= (EditText) findViewById(R.id.Edit_performance);
        Edit_erpservicePurchaseOrderNumber= (EditText) findViewById(R.id.Edit_erpservicePurchaseOrderNumber);

        Edit_app= (EditText) findViewById(R.id.Edit_app);
        Edit_aabss= (EditText) findViewById(R.id.Edit_aabss);
        Edit_saoss= (EditText) findViewById(R.id.Edit_saoss);
    }

    private void initView(){
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yesOnclickListener !=null)
                    yesOnclickListener.onyesonclick();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noOnclickListener != null){
                    noOnclickListener.onnoonclick();
                }
            }
        });
    }

    private void initData() {
        //如果用户自定了title和message

        /*  EditText_engineerprogram_production,Editext_pijianhao,Edit_egineertime,Edit_wbs,
            Edit_subcontractNo,Edit_subcontractor,Edit_subcontractContent,Edit_subcontractingType,
            Edit_startDate,Edit_endDate,Edit_contractMoney,Edit_performance,Edit_erpservicePurchaseOrderNumber,
            Edit_app,Edit_aabss,Edit_saoss;*/
        if (titleStr != null) {
            titleTV.setText(titleStr);
        }
        if (messageStr != null) {
            message.setText(messageStr);
        }
        if(EditText_engineerprogram_production_str!=null){
            EditText_engineerprogram_production.setText(EditText_engineerprogram_production_str);
        }
        if (Editext_pijianhao_str!=null){
            Editext_pijianhao.setText(Editext_pijianhao_str);
        }
        if(Edit_egineertime_str!=null){
            Edit_egineertime.setText(Edit_egineertime_str);
        }
//        if (workUnitstr!=null){
//            workUnit.setText(workUnitstr);
//        }
        if(Edit_wbs_str!=null){
            Edit_wbs.setText(Edit_wbs_str);
        }
        if(Edit_subcontractNo_str!=null){
            Edit_subcontractNo.setText(Edit_subcontractNo_str);
        }
        if(Edit_subcontractor_str!=null){
            Edit_subcontractor.setText(Edit_subcontractor_str);
        }
        if (Edit_subcontractContent_str!=null){
            Edit_subcontractContent.setText(Edit_subcontractContent_str);
        }
        if(Edit_subcontractingType_str!=null){
            Edit_subcontractingType.setText(Edit_subcontractingType_str);
        }
        if(Edit_startDate_str!=null){
            Edit_startDate.setText(Edit_startDate_str);
        }

        if(Edit_endDate_str!=null){
            Edit_endDate.setText(Edit_endDate_str);
        }
        if(Edit_contractMoney_str!=null){
            Edit_contractMoney.setText(Edit_contractMoney_str);
        }
        if(Edit_performance_str!=null){
            Edit_performance.setText(Edit_performance_str);
        }
        if (Edit_erpservicePurchaseOrderNumber_str!=null){
            Edit_erpservicePurchaseOrderNumber.setText(Edit_erpservicePurchaseOrderNumber_str);
        }
        if(Edit_app_str!=null){
            Edit_app.setText(Edit_app_str);
        }

        if(Edit_aabss_str!=null){
            Edit_aabss.setText(Edit_aabss_str);
        }

        if(Edit_saoss_str!=null){
            Edit_saoss.setText(Edit_saoss_str);
        }
        //如果设置按钮文字
        if (yesStr != null) {
            yes.setText(yesStr);
        }
        if (noStr != null) {
            no.setText(noStr);
        }
    }


    public void SetEditTextnotENeditable(){


        /*EditText_engineerprogram_production,Editext_pijianhao,Edit_egineertime,Edit_wbs,
            Edit_subcontractNo,Edit_subcontractor,Edit_subcontractContent,Edit_subcontractingType,
            Edit_startDate,Edit_endDate,Edit_contractMoney,Edit_performance,Edit_erpservicePurchaseOrderNumber,
            Edit_app,Edit_aabss,Edit_saoss;*/
        EditText_engineerprogram_production.setEnabled(false);
        Editext_pijianhao.setEnabled(false);
        Edit_egineertime.setEnabled(false);

        Edit_wbs.setEnabled(false);
        Edit_subcontractNo.setEnabled(false);
        Edit_subcontractor.setEnabled(false);
        Edit_subcontractContent.setEnabled(false);
        Edit_subcontractingType.setEnabled(false);
        Edit_startDate.setEnabled(false);
        Edit_endDate.setEnabled(false);
        Edit_contractMoney.setEnabled(false);
        Edit_performance.setEnabled(false);
        Edit_erpservicePurchaseOrderNumber.setEnabled(false);

        Edit_app.setEnabled(false);
        Edit_aabss.setEnabled(false);
        Edit_saoss.setEnabled(false);


    }
    public void SetEditTextENeditable(){

        EditText_engineerprogram_production= (EditText) findViewById(R.id.EditText_engineerprogram_production);
        Editext_pijianhao= (EditText) findViewById(R.id.Editext_pijianhao);
        Edit_egineertime= (EditText) findViewById(R.id.Edit_egineertime);
        Edit_wbs= (EditText) findViewById(R.id.Edit_wbs);
//        workUnit= (EditText) findViewById(R.id.Spinner_workCompany_dialog);
        Edit_subcontractNo= (EditText) findViewById(R.id.Edit_subcontractNo);
        Edit_subcontractor= (EditText) findViewById(R.id.Edit_subcontractor);
        Edit_subcontractContent= (EditText) findViewById(R.id.Edit_subcontractContent);
        Edit_subcontractingType= (EditText) findViewById(R.id.Edit_subcontractingType);
        Edit_startDate= (EditText) findViewById(R.id.Edit_startDate);
        Edit_endDate= (EditText) findViewById(R.id.Edit_endDate);
        Edit_contractMoney= (EditText) findViewById(R.id.Edit_contractMoney);
        Edit_performance= (EditText) findViewById(R.id.Edit_performance);
        Edit_erpservicePurchaseOrderNumber= (EditText) findViewById(R.id.Edit_erpservicePurchaseOrderNumber);

        EditText_engineerprogram_production.setEnabled(true);
        Editext_pijianhao.setEnabled(true);
        Edit_egineertime.setEnabled(true);
        Edit_wbs.setEnabled(true);
        Edit_subcontractNo.setEnabled(true);
        Edit_subcontractor.setEnabled(true);
        Edit_subcontractContent.setEnabled(true);
        Edit_subcontractingType.setEnabled(true);
        Edit_startDate.setEnabled(true);
        Edit_endDate.setEnabled(true);
        Edit_contractMoney.setEnabled(true);
        Edit_performance.setEnabled(true);
        Edit_erpservicePurchaseOrderNumber.setEnabled(true);
    }
}
