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

public class Mydialog_shudiandui extends Dialog {
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
    EditText EditText_affiliatedUnits,Editext_canUse,Edit_gender,Edit_ppName,Edit_rankNum,
            Edit_telNum,Edit_userName,Edit_userRole,Edit_remarks;
    private String pid;

    public String getEditText_affiliatedUnits_str() {
        return EditText_affiliatedUnits_str;
    }

    public void setEditText_affiliatedUnits_str(String editText_affiliatedUnits_str) {
        EditText_affiliatedUnits_str = editText_affiliatedUnits_str;
    }

    public String getEditext_canUse_str() {
        return Editext_canUse_str;
    }

    public void setEditext_canUse_str(String editext_canUse_str) {
        Editext_canUse_str = editext_canUse_str;
    }

    public String getEdit_gender_str() {
        return Edit_gender_str;
    }

    public void setEdit_gender_str(String edit_gender_str) {
        Edit_gender_str = edit_gender_str;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getEdit_ppName_str() {
        return Edit_ppName_str;
    }

    public void setEdit_ppName_str(String edit_ppName_str) {
        Edit_ppName_str = edit_ppName_str;
    }

    public String getEdit_rankNum_str() {
        return Edit_rankNum_str;
    }

    public void setEdit_rankNum_str(String edit_rankNum_str) {
        Edit_rankNum_str = edit_rankNum_str;
    }

    public String getEdit_telNum_str() {
        return Edit_telNum_str;
    }

    public void setEdit_telNum_str(String edit_telNum_str) {
        Edit_telNum_str = edit_telNum_str;
    }

    public String getEdit_userName_str() {
        return Edit_userName_str;
    }

    public void setEdit_userName_str(String edit_userName_str) {
        Edit_userName_str = edit_userName_str;
    }

    public String getEdit_userRole_str() {
        return Edit_userRole_str;
    }

    public void setEdit_userRole_str(String edit_userRole_str) {
        Edit_userRole_str = edit_userRole_str;
    }

    public String getEdit_remarks_str() {
        return Edit_remarks_str;
    }

    public void setEdit_remarks_str(String edit_remarks_str) {
        Edit_remarks_str = edit_remarks_str;
    }

    private String EditText_affiliatedUnits_str;
    private String Editext_canUse_str;
    private String Edit_gender_str;
    private String Edit_ppName_str;
    private String Edit_rankNum_str;
    private String Edit_telNum_str;
    private String Edit_userName_str;
    private String Edit_userRole_str;
    private String Edit_remarks_str;
    public Mydialog_shudiandui(@NonNull  Context context,@StyleRes int theme) {
        super(context, theme);
    }
    public interface onYesOnclickListener{
        public  void  onyesonclick();
    }
    public interface  onNoOnclickListener{
        public  void onnoonclick();
    }

    public  void setYesOnclickListener(String res,onYesOnclickListener onYesOnclickListener1){
        if(res!=null){
            this.yesStr=res;
        }
        this.yesOnclickListener=onYesOnclickListener1;

    }
    public void setNoOnclickListener(String res,onNoOnclickListener onNoOnclickListener1){
        if(res!=null){
            this.noStr=res;
        }
        this.noOnclickListener=onNoOnclickListener1;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydialog_shudiandui);
        initview();

        initData();

        iniView();

        SetEditTextnotENeditable();
    }

    public void  initview(){
        yes= (Button) findViewById(R.id.yes_production);
        no= (Button) findViewById(R.id.no_produtions);
        titleTV= (TextView) findViewById(R.id.title_production);
        message= (TextView) findViewById(R.id.Text_engeenirName_production);

        EditText_affiliatedUnits= (EditText) findViewById(R.id.EditText_affiliatedUnits);
        Editext_canUse= (EditText) findViewById(R.id.Editext_canUse);
        Edit_gender= (EditText) findViewById(R.id.Edit_gender);
        Edit_ppName= (EditText) findViewById(R.id.Edit_ppName);
//        workUnit= (EditText) findViewById(R.id.Spinner_workCompany_dialog);
        Edit_rankNum= (EditText) findViewById(R.id.Edit_rankNum);
        Edit_telNum= (EditText) findViewById(R.id.Edit_telNum);
        Edit_userName= (EditText) findViewById(R.id.Edit_userName);
        Edit_userRole= (EditText) findViewById(R.id.Edit_userRole);
        Edit_remarks= (EditText) findViewById(R.id.Edit_remarks);


    }

    public void SetEditTextnotENeditable(){
         /*EditText_engineerprogram_production,Editext_pijianhao,Edit_wbs,Edit_orginal_pijianhao,Edit_production_starday,
            Edit_production_endday,Edit_production_num,Edit_production_monthProduceVal,
            Edit_production_monthAMaterial,Edit_production_monthAdBeforeIncome,Edit_production_monthAdBehindIncome,
            Edit_production_yearProduceVal,Edit_production_yearAMaterial,Edit_production_yearAdBeforeIncome,
            Edit_production_yearAdBehindIncome,Edit_production_currentMonthProcess,Edit_production_totalProcess,
            Edit_production_fillingDate;*/
        EditText_affiliatedUnits.setEnabled(false);
        Editext_canUse.setEnabled(false);
        Edit_gender.setEnabled(false);

        Edit_ppName.setEnabled(false);
        Edit_rankNum.setEnabled(false);
        Edit_telNum.setEnabled(false);
        Edit_userName.setEnabled(false);
        Edit_userRole.setEnabled(false);
        Edit_remarks.setEnabled(false);


    }

    public void SetEditTextENeditable(){


        EditText_affiliatedUnits.setEnabled(true);
        Editext_canUse.setEnabled(true);
        Edit_gender.setEnabled(true);

        Edit_ppName.setEnabled(true);
        Edit_rankNum.setEnabled(true);
        Edit_telNum.setEnabled(true);
        Edit_userName.setEnabled(true);
        Edit_userRole.setEnabled(true);
        Edit_remarks.setEnabled(true);


    }

    private void initData() {
        //如果用户自定了title和message

        /*  String EditText_engineerprogram_production_str;
    private String Editext_pijianhao_str;
    private String Edit_wbs_str;
    private String Edit_orginal_pijianhao_str;
    private String Edit_production_starday_str;
    private String Edit_production_endday_str;
    private String Edit_production_num_str;
    private String Edit_production_monthProduceVal_str;
    private String Edit_production_monthAMaterial_str;
    private String Edit_production_monthAdBeforeIncome_str;
    private String Edit_production_monthAdBehindIncome_str;
    private String Edit_production_yearProduceVal_str;
    private String Edit_production_yearAMaterial_str;
    private String Edit_production_yearAdBeforeIncome_str;
    private String Edit_production_yearAdBehindIncome_str;
    private String Edit_production_currentMonthProcess_str;
    private String Edit_production_totalProcess_str;
    private String Edit_production_fillingDate_str;*/
        if (titleStr != null) {
            titleTV.setText(titleStr);
        }
        if (messageStr != null) {
            message.setText(messageStr);
        }
        if(EditText_affiliatedUnits_str!=null){
            EditText_affiliatedUnits.setText(EditText_affiliatedUnits_str);
        }
        if (Editext_canUse_str!=null){
            Editext_canUse.setText(Editext_canUse_str);
        }
        if(Edit_gender_str!=null){
            Edit_gender.setText(Edit_gender_str);
        }
        if(Edit_ppName_str!=null){
            Edit_ppName.setText(Edit_ppName_str);
        }
        if(Edit_rankNum_str!=null){
            Edit_rankNum.setText(Edit_rankNum_str);
        }
        if(Edit_telNum_str!=null){
            Edit_telNum.setText(Edit_telNum_str);
        }
        if(Edit_userName_str!=null){
            Edit_userName.setText(Edit_userName_str);
        }
        if(Edit_userRole_str!=null){
            Edit_userRole.setText(Edit_userRole_str);
        }

        if(Edit_remarks_str!=null){
            Edit_remarks.setText(Edit_remarks_str);
        }




        //如果设置按钮文字
        if (yesStr != null) {
            yes.setText(yesStr);
        }
        if (noStr != null) {
            no.setText(noStr);
        }
    }
    public  void iniView(){
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yesOnclickListener.onyesonclick();
            }

        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noOnclickListener.onnoonclick();
            }
        });
    }
}
