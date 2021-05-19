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

public class Mydialog_statistic extends Dialog {
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

    EditText EditText_engineerprogram_production,Editext_pijianhao,Edit_wbs,Edit_orginal_pijianhao,Edit_production_starday,
            Edit_production_endday,Edit_production_monthProduceVal,
            Edit_production_monthAMaterial,Edit_production_monthAdBeforeIncome,Edit_production_monthAdBehindIncome,
            Edit_production_yearProduceVal,Edit_production_yearAMaterial,Edit_production_yearAdBeforeIncome,
            Edit_production_yearAdBehindIncome,Edit_production_currentMonthProcess,Edit_production_totalProcess,
            Edit_production_fillingDate;

    public void setEditText_engineerprogram_production_str(String editText_engineerprogram_production_str) {
        EditText_engineerprogram_production_str = editText_engineerprogram_production_str;
    }

    public void setEditext_pijianhao_str(String editext_pijianhao_str) {
        Editext_pijianhao_str = editext_pijianhao_str;
    }

    public void setEdit_wbs_str(String edit_wbs_str) {
        Edit_wbs_str = edit_wbs_str;
    }

    public void setEdit_orginal_pijianhao_str(String edit_orginal_pijianhao_str) {
        Edit_orginal_pijianhao_str = edit_orginal_pijianhao_str;
    }

    public void setEdit_production_starday_str(String edit_production_starday_str) {
        Edit_production_starday_str = edit_production_starday_str;
    }

    public void setEdit_production_endday_str(String edit_production_endday_str) {
            Edit_production_endday_str = edit_production_endday_str;
    }



    public void setEdit_production_monthProduceVal_str(String edit_production_monthProduceVal_str) {
        Edit_production_monthProduceVal_str = edit_production_monthProduceVal_str;
    }

    public void setEdit_production_monthAMaterial_str(String edit_production_monthAMaterial_str) {
        Edit_production_monthAMaterial_str = edit_production_monthAMaterial_str;
    }

    public void setEdit_production_monthAdBeforeIncome_str(String edit_production_monthAdBeforeIncome_str) {
        Edit_production_monthAdBeforeIncome_str = edit_production_monthAdBeforeIncome_str;
    }

    public void setEdit_production_monthAdBehindIncome_str(String edit_production_monthAdBehindIncome_str) {
        Edit_production_monthAdBehindIncome_str = edit_production_monthAdBehindIncome_str;
    }

    public void setEdit_production_yearProduceVal_str(String edit_production_yearProduceVal_str) {
        Edit_production_yearProduceVal_str = edit_production_yearProduceVal_str;
    }

    public void setEdit_production_yearAMaterial_str(String edit_production_yearAMaterial_str) {
        Edit_production_yearAMaterial_str = edit_production_yearAMaterial_str;
    }

    public void setEdit_production_yearAdBeforeIncome_str(String edit_production_yearAdBeforeIncome_str) {
        Edit_production_yearAdBeforeIncome_str = edit_production_yearAdBeforeIncome_str;
    }

    public void setEdit_production_yearAdBehindIncome_str(String edit_production_yearAdBehindIncome_str) {
        Edit_production_yearAdBehindIncome_str = edit_production_yearAdBehindIncome_str;
    }

    public void setEdit_production_currentMonthProcess_str(String edit_production_currentMonthProcess_str) {
        Edit_production_currentMonthProcess_str = edit_production_currentMonthProcess_str;
    }

    public void setEdit_production_totalProcess_str(String edit_production_totalProcess_str) {
        Edit_production_totalProcess_str = edit_production_totalProcess_str;
    }

    public void setEdit_production_fillingDate_str(String edit_production_fillingDate_str) {
        Edit_production_fillingDate_str = edit_production_fillingDate_str;
    }

    public void setNoStr(String noStr) {
        this.noStr = noStr;
    }

    public void setYesStr(String yesStr) {
        this.yesStr = yesStr;
    }

    private  String EditText_engineerprogram_production_str;
    private String Editext_pijianhao_str;
    private String Edit_wbs_str;
    private String Edit_orginal_pijianhao_str;
    private String Edit_production_starday_str;
    private String Edit_production_endday_str;

    private String Edit_production_monthProduceVal_str;
    private String Edit_production_monthAMaterial_str;
    private String Edit_production_monthAdBeforeIncome_str;
    private String Edit_production_monthAdBehindIncome_str;
    private String Edit_production_yearProduceVal_str;

    public String getEditText_engineerprogram_production_str() {
        return EditText_engineerprogram_production_str;
    }

    public String getEditext_pijianhao_str() {
        return Editext_pijianhao_str;
    }

    public String getEdit_wbs_str() {
        return Edit_wbs_str;
    }

    public String getEdit_orginal_pijianhao_str() {
        return Edit_orginal_pijianhao_str;
    }

    public String getEdit_production_starday_str() {
        return Edit_production_starday_str;
    }

    public String getEdit_production_endday_str() {
        return Edit_production_endday_str;
    }


    public String getEdit_production_monthProduceVal_str() {
        return Edit_production_monthProduceVal_str;
    }

    public String getEdit_production_monthAMaterial_str() {
        return Edit_production_monthAMaterial_str;
    }

    public String getEdit_production_monthAdBeforeIncome_str() {
        return Edit_production_monthAdBeforeIncome_str;
    }

    public String getEdit_production_monthAdBehindIncome_str() {
        return Edit_production_monthAdBehindIncome_str;
    }

    public String getEdit_production_yearProduceVal_str() {
        return Edit_production_yearProduceVal_str;
    }

    public String getEdit_production_yearAMaterial_str() {
        return Edit_production_yearAMaterial_str;
    }

    public String getEdit_production_yearAdBeforeIncome_str() {
        return Edit_production_yearAdBeforeIncome_str;
    }

    public String getEdit_production_yearAdBehindIncome_str() {
        return Edit_production_yearAdBehindIncome_str;
    }

    public String getEdit_production_currentMonthProcess_str() {
        return Edit_production_currentMonthProcess_str;
    }

    public String getEdit_production_totalProcess_str() {
        return Edit_production_totalProcess_str;
    }

    public String getEdit_production_fillingDate_str() {
        return Edit_production_fillingDate_str;
    }

    public String getNoStr() {
        return noStr;
    }

    public String getYesStr() {
        return yesStr;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    private  String pid;
    private String Edit_production_yearAMaterial_str;
    private String Edit_production_yearAdBeforeIncome_str;
    private String Edit_production_yearAdBehindIncome_str;
    private String Edit_production_currentMonthProcess_str;
    private String Edit_production_totalProcess_str;
    private String Edit_production_fillingDate_str;



    public Mydialog_statistic(@NonNull Context context,@StyleRes int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydialog_statistic);
        setCanceledOnTouchOutside(false);

        initview();

        initData();

        iniView();

        SetEditTextnotENeditable();
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
    public void  initview(){
        yes= (Button) findViewById(R.id.yes_production);
        no= (Button) findViewById(R.id.no_produtions);
        titleTV= (TextView) findViewById(R.id.title_production);
        message= (TextView) findViewById(R.id.Text_engeenirName_production);
        EditText_engineerprogram_production= (EditText) findViewById(R.id.EditText_engineerprogram_production);
        Editext_pijianhao= (EditText) findViewById(R.id.Editext_pijianhao);
        Edit_wbs= (EditText) findViewById(R.id.Edit_wbs);
        Edit_orginal_pijianhao= (EditText) findViewById(R.id.Edit_orginal_pijianhao);
//        workUnit= (EditText) findViewById(R.id.Spinner_workCompany_dialog);
        Edit_production_starday= (EditText) findViewById(R.id.Edit_production_starday);
        Edit_production_endday= (EditText) findViewById(R.id.Edit_production_endday);
        Edit_production_monthProduceVal= (EditText) findViewById(R.id.Edit_production_monthProduceVal);
        Edit_production_monthAMaterial= (EditText) findViewById(R.id.Edit_production_monthAMaterial);
        Edit_production_monthAdBeforeIncome= (EditText) findViewById(R.id.Edit_production_monthAdBeforeIncome);
        Edit_production_monthAdBehindIncome= (EditText) findViewById(R.id.Edit_production_monthAdBehindIncome);
        Edit_production_yearProduceVal= (EditText) findViewById(R.id.Edit_production_yearProduceVal);
        Edit_production_yearAMaterial= (EditText) findViewById(R.id.Edit_production_yearAMaterial);

        Edit_production_yearAdBeforeIncome= (EditText) findViewById(R.id.Edit_production_yearAdBeforeIncome);
        Edit_production_yearAdBehindIncome= (EditText) findViewById(R.id.Edit_production_yearAdBehindIncome);
        Edit_production_currentMonthProcess= (EditText) findViewById(R.id.Edit_production_currentMonthProcess);
        Edit_production_totalProcess= (EditText) findViewById(R.id.Edit_production_totalProcess);
        Edit_production_fillingDate= (EditText) findViewById(R.id.Edit_production_fillingDate);

    }

    public void SetEditTextnotENeditable(){
         /*EditText_engineerprogram_production,Editext_pijianhao,Edit_wbs,Edit_orginal_pijianhao,Edit_production_starday,
            Edit_production_endday,Edit_production_num,Edit_production_monthProduceVal,
            Edit_production_monthAMaterial,Edit_production_monthAdBeforeIncome,Edit_production_monthAdBehindIncome,
            Edit_production_yearProduceVal,Edit_production_yearAMaterial,Edit_production_yearAdBeforeIncome,
            Edit_production_yearAdBehindIncome,Edit_production_currentMonthProcess,Edit_production_totalProcess,
            Edit_production_fillingDate;*/
        EditText_engineerprogram_production.setEnabled(false);
        Editext_pijianhao.setEnabled(false);
        Edit_wbs.setEnabled(false);

        Edit_orginal_pijianhao.setEnabled(false);
        Edit_production_starday.setEnabled(false);
        Edit_production_endday.setEnabled(false);
        Edit_production_monthProduceVal.setEnabled(false);
        Edit_production_monthAMaterial.setEnabled(false);
        Edit_production_monthAdBeforeIncome.setEnabled(false);
        Edit_production_monthAdBehindIncome.setEnabled(false);
        Edit_production_yearProduceVal.setEnabled(false);
        Edit_production_yearAMaterial.setEnabled(false);

        Edit_production_yearAdBeforeIncome.setEnabled(false);
        Edit_production_yearAdBehindIncome.setEnabled(false);
        Edit_production_currentMonthProcess.setEnabled(false);
        Edit_production_totalProcess.setEnabled(false);
        Edit_production_fillingDate.setEnabled(false);


    }

    public void SetEditTextENeditable(){
        EditText_engineerprogram_production= (EditText) findViewById(R.id.EditText_engineerprogram_production);
        Editext_pijianhao= (EditText) findViewById(R.id.Editext_pijianhao);
        Edit_wbs= (EditText) findViewById(R.id.Edit_wbs);
        Edit_orginal_pijianhao= (EditText) findViewById(R.id.Edit_orginal_pijianhao);
//        workUnit= (EditText) findViewById(R.id.Spinner_workCompany_dialog);
        Edit_production_starday= (EditText) findViewById(R.id.Edit_production_starday);
        Edit_production_endday= (EditText) findViewById(R.id.Edit_production_endday);
        Edit_production_monthProduceVal= (EditText) findViewById(R.id.Edit_production_monthProduceVal);
        Edit_production_monthAMaterial= (EditText) findViewById(R.id.Edit_production_monthAMaterial);
        Edit_production_monthAdBeforeIncome= (EditText) findViewById(R.id.Edit_production_monthAdBeforeIncome);
        Edit_production_monthAdBehindIncome= (EditText) findViewById(R.id.Edit_production_monthAdBehindIncome);
        Edit_production_yearProduceVal= (EditText) findViewById(R.id.Edit_production_yearProduceVal);
        Edit_production_yearAMaterial= (EditText) findViewById(R.id.Edit_production_yearAMaterial);

        Edit_production_yearAdBeforeIncome= (EditText) findViewById(R.id.Edit_production_yearAdBeforeIncome);
        Edit_production_yearAdBehindIncome= (EditText) findViewById(R.id.Edit_production_yearAdBehindIncome);
        Edit_production_currentMonthProcess= (EditText) findViewById(R.id.Edit_production_currentMonthProcess);
        Edit_production_totalProcess= (EditText) findViewById(R.id.Edit_production_totalProcess);
        Edit_production_fillingDate= (EditText) findViewById(R.id.Edit_production_fillingDate);
        EditText_engineerprogram_production.setEnabled(true);
        Editext_pijianhao.setEnabled(true);
        Edit_wbs.setEnabled(true);

        Edit_orginal_pijianhao.setEnabled(true);
        Edit_production_starday.setEnabled(true);
        Edit_production_endday.setEnabled(true);
        Edit_production_monthProduceVal.setEnabled(true);
        Edit_production_monthAMaterial.setEnabled(true);
        Edit_production_monthAdBeforeIncome.setEnabled(true);
        Edit_production_monthAdBehindIncome.setEnabled(true);
        Edit_production_yearProduceVal.setEnabled(true);
        Edit_production_yearAMaterial.setEnabled(true);

        Edit_production_yearAdBeforeIncome.setEnabled(true);
        Edit_production_yearAdBehindIncome.setEnabled(true);
        Edit_production_currentMonthProcess.setEnabled(true);
        Edit_production_totalProcess.setEnabled(true);
        Edit_production_fillingDate.setEnabled(true);


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
        if(EditText_engineerprogram_production_str!=null){
            EditText_engineerprogram_production.setText(EditText_engineerprogram_production_str);
        }
        if (Editext_pijianhao_str!=null){
            Editext_pijianhao.setText(Editext_pijianhao_str);
        }
        if(Edit_wbs_str!=null){
            Edit_wbs.setText(Edit_wbs_str);
        }
//        if (workUnitstr!=null){
//            workUnit.setText(workUnitstr);
//        }
        if(Edit_orginal_pijianhao_str!=null){
            Edit_orginal_pijianhao.setText(Edit_orginal_pijianhao_str);
        }
        if(Edit_production_starday_str!=null){
            Edit_production_starday.setText(Edit_production_starday_str);
        }
        if(Edit_production_endday_str!=null){
            Edit_production_endday.setText(Edit_production_endday_str);
        }
        if(Edit_production_monthProduceVal_str!=null){
            Edit_production_monthProduceVal.setText(Edit_production_monthProduceVal_str);
        }
        if(Edit_production_monthAMaterial_str!=null){
            Edit_production_monthAMaterial.setText(Edit_production_monthAMaterial_str);
        }

        if(Edit_production_monthAdBeforeIncome_str!=null){
            Edit_production_monthAdBeforeIncome.setText(Edit_production_monthAdBeforeIncome_str);
        }
        if(Edit_production_monthAdBehindIncome_str!=null){
            Edit_production_monthAdBehindIncome.setText(Edit_production_monthAdBehindIncome_str);
        }
        if(Edit_production_yearProduceVal_str!=null){
            Edit_production_yearProduceVal.setText(Edit_production_yearProduceVal_str);
        }
        if (Edit_production_yearAMaterial_str!=null){
            Edit_production_yearAMaterial.setText(Edit_production_yearAMaterial_str);
        }
        if(Edit_production_yearAdBeforeIncome_str!=null){
            Edit_production_yearAdBeforeIncome.setText(Edit_production_yearAdBeforeIncome_str);
        }


        if(Edit_production_yearAdBehindIncome_str!=null){
            Edit_production_yearAdBehindIncome.setText(Edit_production_yearAdBehindIncome_str);
        }
        if(Edit_production_currentMonthProcess_str!=null){
            Edit_production_currentMonthProcess.setText(Edit_production_currentMonthProcess_str);
        }
        if(Edit_production_totalProcess_str!=null){
            Edit_production_totalProcess.setText(Edit_production_totalProcess_str);
        }
        if(Edit_production_fillingDate_str!=null){
            Edit_production_fillingDate.setText(Edit_production_fillingDate_str);
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
