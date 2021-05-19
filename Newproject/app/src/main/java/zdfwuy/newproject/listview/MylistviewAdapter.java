//package zdfwuy.newproject.listview;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import java.util.List;
//
//import zdfwuy.newproject.Iformation.Iformation_processing;
//import zdfwuy.newproject.R;
//import zdfwuy.newproject.data.PublicInfo;
//
///**
// * Created by ASUS on 2021/3/24.
// */
//public class MylistviewAdapter extends BaseAdapter {
//    private Context mContext;
//    private List<PublicInfo> data;
//    private int i;
//    private LayoutInflater mLayoutInflater;
//    //MyAdapter的构造函数，一个Context类型的参数，也就是哪一个Activity
//    //这里传进去的是 ListViewActivity,ListView所在的Activity
//    public MylistviewAdapter(Context context,int i){
//        this.mContext=context;
//        mLayoutInflater =LayoutInflater.from(context);
//        this.i=i;
//    }
//    @Override
//    public int getCount() {
//        return i;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return position;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    //写一个静态的class,把layout_list_item的控件转移过来使用
//    static class ViewHolder{
//        //声明引用
//
//        public TextView tvTitle,tvTime,tvContext;
//    }
//    //重要的方法
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
////        //实例化ViewHolder
////        ViewHolder holder = null;
////        //如果视图为空
////        if (convertView == null){
////            //此处需要导入包，填写ListView的图标和标题等控件的来源，来自于layout_list_item这个布局文件
////            convertView = mLayoutInflater.inflate(R.layout.layout_listview_items,null);
////            //生成一个ViewHolder的对象
////            holder = new ViewHolder();
////            //把layout_list_item对象转移过来，以便修改和赋值
////
////
////            holder.tvTitle= (TextView) convertView.findViewById(R.id.TV_listTitle_Id);
////            holder.tvTime = (TextView) convertView.findViewById(R.id.TV_listTime_Id);
////            holder.tvContext= (TextView) convertView.findViewById(R.id.TV_listContext_Id);
////
//////            holder.tvTitle.setText(publicInfo.getPid().toString());
////
////            //把这个holder传递进去
////            convertView.setTag(holder);
////        }else {
////            holder = (ViewHolder) convertView.getTag();
////        }
////        //给控件赋值
////        holder.tvTitle.setText(data.get(position).getPid());
//////        holder.tvTime.setText("2099-09-09！");
//////        holder.tvContext.setText("显示内容！");
////        return convertView;
//
//        View view = View.inflate(Iformation_processing.class, R.layout.layout_listview_items, null);
//
//
//        TextView BuildingNumber = view.findViewById(R.id.BuildNumber);
//        TextView RoomNumber = view.findViewById(R.id.RoomNumber);
//        TextView Time = view.findViewById(R.id.Time);
//        TextView Size = view.findViewById(R.id.Size);
//        TextView Function = view.findViewById(R.id.Function);
//        TextView IsMeeting = view.findViewById(R.id.IsMeeting);
//        TextView Days = view.findViewById(R.id.Days3);
////           Button select=view.findViewById(R.id.select);
////
////            select.setOnClickListener((View.OnClickListener) this);
//
//        BuildingNumber.setText(data.get(position).getBuildingNumber());
//        Size.setText(data.get(position).getSize());
//        RoomNumber.setText(data.get(position).getRoomNumber());
//        Time.setText(data.get(position).getTime());
//        Function.setText(data.get(position).getFunction());
//        IsMeeting.setText(data.get(position).getIsMeeting());
//        Days.setText(data.get(position).getDays());
//        return view;
//    }
//
//
//}
