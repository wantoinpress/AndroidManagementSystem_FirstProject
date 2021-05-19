package zdfwuy.newproject.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import zdfwuy.newproject.R;

/**
 * Created by ASUS on 2021/5/9.
 */
public class Myexpandlistview_safeguard_manage extends BaseExpandableListAdapter {
    Context context;
    String groupParent[]={"输电队","防腐队","安装一队","安装二队","安装三队","金属车间","建筑工程项目部"};
  /*  String groupChild[][]={

    }*/

    @Override
    //获得分组个数
    public int getGroupCount() {
        return groupParent.length;
    }

    @Override
    //子选项个数
    public int getChildrenCount(int i) {
        return 0;
}

    @Override
    //获取分组数据
    public Object getGroup(int i) {
        return groupParent[i];
    }

    @Override
    //获取分组的子选项
    public Object getChild(int i, int i1) {
        return null;
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
        /*ChildViewHolder childViewHolder;
        if (view==null)
        {
            view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.child_item,viewGroup,false);
            childViewHolder=new ChildViewHolder();
            childViewHolder.textView=(TextView)view.findViewById(R.id.expan_child);
            view.setTag(childViewHolder);
        }else {
            childViewHolder=(ChildViewHolder)view.getTag();
        }
        childViewHolder.textView.setText(groupChild[i][i1]);*/
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
