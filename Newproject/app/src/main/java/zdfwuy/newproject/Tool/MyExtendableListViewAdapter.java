package zdfwuy.newproject.Tool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import zdfwuy.newproject.R;

/**
 * Created by ASUS on 2021/2/19.
 */
//写自己的适配器！
public class MyExtendableListViewAdapter extends BaseExpandableListAdapter {
    private Context mcontext;
    public String[] groupParent={"信息处理","综合查询","分析预警","基础数据","系统维护","系统日志","公告管理"};
    public String[][] groupChild={
            {"公共信息","合同信息","预算信息","生产信息","统计信息","成本信息","结算信息","分包信息"},

            {"汇总信息"},
            {"时间性分析","数据性分析"},
            {"建设单位类型","建设单位管理","分包类型管理","分包单位管理","是否编码管理","履行情况管理"},
            {"部门管理","人员管理","编码列表","编码样式","退出系统"},
            {"操作日志","登录日志","活动用户"},
            {"公告维护"},
    };
    @Override
    //获得分组个数
    public int getGroupCount() {
        return groupParent.length;
    }

    @Override
    //子选项个数
    public int getChildrenCount(int i) {
        return groupChild[i].length;
    }

    @Override
    //获取分组数据
    public Object getGroup(int i) {
        return groupParent[i];
    }

    @Override
    //获取分组的子选项
    public Object getChild(int i, int i1) {
        return groupChild[i][i1];
    }

    @Override
    //获得分组的id
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    //分组和子选项是否持有稳定的ID，会不会有底层元素影响他们之类的
    public boolean hasStableIds() {
        return true;
    }


    @Override
    //分组视图

    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        GroupViewHolder groupViewHolder;
        if(view==null)
        {
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.partent_item,viewGroup,false);
            groupViewHolder=new GroupViewHolder();
            groupViewHolder.textView=(TextView)view.findViewById(R.id.lable_group_normal);
            view.setTag(groupViewHolder);
        }else {
            groupViewHolder=(GroupViewHolder)view.getTag();
        }
        groupViewHolder.textView.setText(groupParent[i]);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ChildViewHolder childViewHolder;
        if (view==null)
        {
            view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.child_item,viewGroup,false);
            childViewHolder=new ChildViewHolder();
            childViewHolder.textView=(TextView)view.findViewById(R.id.expan_child);
            view.setTag(childViewHolder);
        }else {
            childViewHolder=(ChildViewHolder)view.getTag();
        }
        childViewHolder.textView.setText(groupChild[i][i1]);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    private class GroupViewHolder {
        TextView textView;
    }


    private class ChildViewHolder {
        TextView textView;
    }
}
