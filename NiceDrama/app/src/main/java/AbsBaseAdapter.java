import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/10/18.
 * ListView Adapter适配封装
 * @author 马迁宇
 */
public abstract class AbsBaseAdapter<T, VH extends AbsBaseAdapter.BaseViewHolder> extends BaseAdapter {

    protected List<T> datas;
    protected Context context;

    public AbsBaseAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<T> newList) {
        if (datas == null) {
            datas = new ArrayList<>();
        }
        datas.addAll(newList);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public T getItem(int position) {
        return datas == null ? null : datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VH vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(setItemLayout(), parent, false);
            vh = onCreatViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (VH) convertView.getTag();
        }
        T itemData = getItem(position);
        //设置
        onBindViewHolder(vh, itemData, position);
        return convertView;
    }

    protected abstract int setItemLayout();

    protected abstract VH onCreatViewHolder(View convertView);

    protected abstract void onBindViewHolder(VH vh, T itemData, int position);

    protected static class BaseViewHolder {
        View itemView;

        public BaseViewHolder(View itemView) {
            this.itemView = itemView;
        }
    }
}
