package zdfwuy.newproject.dialog;



import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import zdfwuy.newproject.R;

/**
 * 创建自定义的Dialog，主要学习实现原理
 * Created by admin on 2017/8/30.
 */

public class Mydialog extends Dialog {
    private Button yes;//确定按钮
    boolean panduan;
    private Button no;//取消按钮
    private TextView titleTV;//消息标题文本
    private TextView message;//消息提示文本
    private String titleStr;//从外界设置的title文本
    private String messageStr;//从外界设置的消息文本

    public String getEdit_investment_moneystr() {
        Edit_investment_money=(EditText)findViewById(R.id.Edit_investment_money);
        Edit_investment_moneystr=Edit_investment_money.getText().toString();
        return Edit_investment_moneystr;
    }

    public String getEdit_orginal_pijianhaostr() {
        Edit_orginal_pijianhao=(EditText)findViewById(R.id.Edit_orginal_pijianhao);
        Edit_orginal_pijianhaostr=Editext_pijianhao.getText().toString();
        return Edit_orginal_pijianhaostr;
    }

    public String getEdit_project_yearstr() {
        Edit_project_year=(EditText)findViewById(R.id.Edit_project_year);
        Edit_project_yearstr=Edit_project_year.getText().toString();
        return Edit_project_yearstr;
    }

    public String getEdit_wbs_dialogstr() {
        Edit_wbs_dialog=(EditText)findViewById(R.id.Edit_wbs_dialog);
        Edit_wbs_dialogstr=Edit_wbs_dialog.getText().toString();
        return Edit_wbs_dialogstr;
    }

    public String getEditext_pijianhaostr() {
        Editext_pijianhao=(EditText)findViewById(R.id.Editext_pijianhao);
        Editext_pijianhaostr=Editext_pijianhao.getText().toString();
        return Editext_pijianhaostr;
    }

    public String getEditText_engineerprogramstr() {
        EditText_engineerprogram=(EditText)findViewById(R.id.EditText_engineerprogram);
        EditText_engineerprogramstr=EditText_engineerprogram.getText().toString();
        return EditText_engineerprogramstr;
    }

    private EditText EditText_engineerprogram,Editext_pijianhao,Edit_wbs_dialog,Edit_investment_money,Edit_project_year,Edit_orginal_pijianhao,Editext_CompanyType,Editext_buildCompany,Edit_workCompany,Edit_isFin_dialog;
    public void setEditText_engineerprogram(String editText_engineerprogram1) {
        EditText_engineerprogramstr = editText_engineerprogram1;
    }

    private String EditText_engineerprogramstr;//从外界获取的项目称呼

    public void setEditext_pijianhaostr(String editext_pijianhaostr) {
        Editext_pijianhaostr = editext_pijianhaostr;
    }

    private String Editext_pijianhaostr;//从外界获取的劈尖号

    public void setEdit_wbs_dialogstr(String edit_wbs_dialogstr) {
        Edit_wbs_dialogstr = edit_wbs_dialogstr;
    }

    private String Edit_wbs_dialogstr;//从外界获取的wbs


    public void setEdit_investment_moneystr(String edit_investment_moneystr) {
        Edit_investment_moneystr = edit_investment_moneystr;
    }

    private String Edit_investment_moneystr;//从外界获取的投资金额

    public void setEdit_project_yearstr(String edit_project_yearstr) {
        Edit_project_yearstr = edit_project_yearstr;
    }

    private String Edit_project_yearstr;//从外界获取的工程年份

    public void setEdit_orginal_pijianhaostr(String edit_orginal_pijianhaostr) {
        Edit_orginal_pijianhaostr = edit_orginal_pijianhaostr;
    }

    private String Edit_orginal_pijianhaostr;//从外界获取的原批件号

    public String getEditext_CompanyType_str() {
        return Editext_CompanyType_str;
    }

    public void setEditext_CompanyType_str(String editext_CompanyType_str) {
        Editext_CompanyType_str = editext_CompanyType_str;
    }

    public String getEditext_buildCompany_str() {
        return Editext_buildCompany_str;
    }

    public void setEditext_buildCompany_str(String editext_buildCompany_str) {
        Editext_buildCompany_str = editext_buildCompany_str;
    }

    public String getEdit_workCompany_str() {
        return Edit_workCompany_str;
    }

    public void setEdit_workCompany_str(String edit_workCompany_str) {
        Edit_workCompany_str = edit_workCompany_str;
    }

    public String getEdit_isFin_dialog_str() {
        return Edit_isFin_dialog_str;
    }

    public void setEdit_isFin_dialog_str(String edit_isFin_dialog_str) {
        Edit_isFin_dialog_str = edit_isFin_dialog_str;
    }

    private  String Editext_CompanyType_str,Editext_buildCompany_str,Edit_workCompany_str,Edit_isFin_dialog_str;
    public void setYesStr(String yesStr) {
        this.yesStr = yesStr;
    }

    public String getYesStr() {
        return yesStr;
    }

    //确定文本和取消文本的显示的内容
    private String yesStr;
    private String noStr;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    private String pid;
    private onNoOnclickListener noOnclickListener;//取消按钮被点击了的监听器
    private onYesOnclickListener yesOnclickListener;//确定按钮被点击了的监听器

    public Mydialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    /**
     * 设置取消按钮的显示内容和监听
     *
     * @param str
     * @param onNoOnclickListener
     */
    public void setNoOnclickListener(String str, onNoOnclickListener onNoOnclickListener) {
        if (str != null) {
            noStr = str;
        }
        this.noOnclickListener = onNoOnclickListener;
    }
    public void SetEditTextnotENeditable(){
        /*Editext_CompanyType,Editext_buildCompany,Edit_workCompany,Edit_isFin_dialog*/
        EditText_engineerprogram.setEnabled(false);
        Editext_pijianhao.setEnabled(false);
        Edit_wbs_dialog.setEnabled(false);
        Edit_investment_money.setEnabled(false);
        Edit_project_year.setEnabled(false);
        Edit_orginal_pijianhao.setEnabled(false);

        Editext_CompanyType.setEnabled(false);
        Editext_buildCompany.setEnabled(false);
        Edit_workCompany.setEnabled(false);
        Edit_isFin_dialog.setEnabled(false);
        panduan=true;
    }
    public void SetEditTextENeditable(){
        /*Editext_CompanyType,Editext_buildCompany,Edit_workCompany,Edit_isFin_dialog*/
        EditText_engineerprogram=(EditText)findViewById(R.id.EditText_engineerprogram);
        Editext_pijianhao=(EditText)findViewById(R.id.Editext_pijianhao);
        Edit_wbs_dialog=(EditText)findViewById(R.id.Edit_wbs_dialog);
        Edit_investment_money=(EditText)findViewById(R.id.Edit_investment_money);
        Edit_project_year=(EditText)findViewById(R.id.Edit_project_year);
        Edit_orginal_pijianhao=(EditText)findViewById(R.id.Edit_orginal_pijianhao);

        EditText_engineerprogram.setEnabled(true);
        Editext_pijianhao.setEnabled(true);
        Edit_wbs_dialog.setEnabled(true);
        Edit_investment_money.setEnabled(true);
        Edit_project_year.setEnabled(true);
        Edit_orginal_pijianhao.setEnabled(true);

        Editext_CompanyType.setEnabled(true);
        Editext_buildCompany.setEnabled(true);
        Edit_workCompany.setEnabled(true);
        Edit_isFin_dialog.setEnabled(true);
        panduan=false;
    }
    /**
     * 设置确定按钮的显示内容和监听
     *
     * @param str
     * @param yesOnclickListener
     */
    public void setYesOnclickListener(String str, onYesOnclickListener yesOnclickListener) {

            yesStr = str;

        this.yesOnclickListener = yesOnclickListener;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog_layout);
        //空白处不能取消动画
        setCanceledOnTouchOutside(false);

        //初始化界面控件
        initView();

        //初始化界面数据
        initData();
        //初始化界面控件的事件
        initEvent();
        SetEditTextnotENeditable();
    }

    /**
     * 初始化界面控件
     */
    private void initView() {
        yes = (Button)findViewById(R.id.yes);
        no = (Button)findViewById(R.id.no);
        titleTV = (TextView) findViewById(R.id.title);
        message = (TextView) findViewById(R.id.Text_engeenirName);
        EditText_engineerprogram=(EditText)findViewById(R.id.EditText_engineerprogram);
        Editext_pijianhao=(EditText)findViewById(R.id.Editext_pijianhao);
        Edit_wbs_dialog=(EditText)findViewById(R.id.Edit_wbs_dialog);
        Edit_investment_money=(EditText)findViewById(R.id.Edit_investment_money);
        Edit_project_year=(EditText)findViewById(R.id.Edit_project_year);
        Edit_orginal_pijianhao=(EditText)findViewById(R.id.Edit_orginal_pijianhao);
        /*Editext_CompanyType,Editext_buildCompany,Edit_workCompany,Edit_isFin_dialog*/

        Editext_CompanyType=(EditText)findViewById(R.id.Editext_CompanyType);
        Editext_buildCompany=(EditText)findViewById(R.id.Editext_buildCompany);
        Edit_workCompany=(EditText)findViewById(R.id.Edit_workCompany);
        Edit_isFin_dialog=(EditText)findViewById(R.id.Edit_isFin_dialog);
    }

    /**
     * 初始化界面控件的显示数据
     */
    private void initData() {
        //如果用户自定了title和message
        if (titleStr != null) {
            titleTV.setText(titleStr);
        }
        if (messageStr != null) {
            message.setText(messageStr);
        }
        /*Editext_CompanyType,Editext_buildCompany,Edit_workCompany,Edit_isFin_dialog*/
        if(EditText_engineerprogramstr!=null){
            EditText_engineerprogram.setText(EditText_engineerprogramstr);
        }
        if (Editext_pijianhaostr!=null){
            Editext_pijianhao.setText(Editext_pijianhaostr);
        }
        if(Edit_wbs_dialogstr!=null){
            Edit_wbs_dialog.setText(Edit_wbs_dialogstr);
        }
        if (Edit_investment_moneystr!=null){
            Edit_investment_money.setText(Edit_investment_moneystr);
        }
        if(Edit_project_yearstr!=null){
            Edit_project_year.setText(Edit_project_yearstr);
        }
        if(Edit_orginal_pijianhaostr!=null){
            Edit_orginal_pijianhao.setText(Edit_orginal_pijianhaostr);
        }

        if(Editext_CompanyType_str!=null){
            Editext_CompanyType.setText(Editext_CompanyType_str);
        }
        if (Editext_buildCompany_str!=null){
            Editext_buildCompany.setText(Editext_buildCompany_str);
        }
        if(Edit_workCompany_str!=null){
            Edit_workCompany.setText(Edit_workCompany_str);
        }
        if(Edit_isFin_dialog_str!=null){
            Edit_isFin_dialog.setText(Edit_isFin_dialog_str);
        }
        //如果设置按钮文字
        if (yesStr != null) {
            yes.setText("");
            yes.setText(yesStr);
        }
        if (noStr != null) {
            no.setText(noStr);
        }
    }

    /**
     * 初始化界面的确定和取消监听
     */
    private void initEvent() {
        //设置确定按钮被点击后，向外界提供监听
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yesOnclickListener != null) {
                    yesOnclickListener.onYesOnclick();
                }
            }
        });
        //设置取消按钮被点击后，向外界提供监听
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noOnclickListener != null) {
                    noOnclickListener.onNoClick();
                }
            }
        });
    }

    /**
     * 从外界Activity为Dialog设置标题
     *
     * @param title
     */
    public void setTitle(String title) {
        titleStr = title;
    }

    /**
     * 从外界Activity为Dialog设置message
     *
     * @param message
     */
    public void setMessage(String message) {
        messageStr = message;
    }

    public interface onNoOnclickListener {
        public void onNoClick();
    }

    public interface onYesOnclickListener {
        public void onYesOnclick();
    }
}