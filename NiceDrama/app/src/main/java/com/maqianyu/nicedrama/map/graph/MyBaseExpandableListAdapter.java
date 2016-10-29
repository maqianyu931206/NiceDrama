package com.maqianyu.nicedrama.map.graph;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.maqianyu.nicedrama.R;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 16/10/28.
 * ExpandableListView的适配器
 */
public class MyBaseExpandableListAdapter extends BaseExpandableListAdapter  {
    private Context mContext;
    private List<String> groupTitle;
    private Map<Integer, List<ChildItem>> childMap;

    public MyBaseExpandableListAdapter(Context context, List<String> groupTitle, Map<Integer, List<ChildItem>> childMap) {
        this.mContext = context;
        this.groupTitle = groupTitle;
        this.childMap = childMap;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childMap.get(groupPosition).get(childPosition).getTitle();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder childHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.exchildview, null);
            childHolder = new ChildHolder();
            childHolder.childText = (TextView) convertView.findViewById(R.id.city_child_tv);
            convertView.setTag(childHolder);
        } else {
            childHolder = (ChildHolder) convertView.getTag();
        }
        childHolder.childText.setText(childMap.get(groupPosition).get(childPosition).getTitle());

        return convertView;
    }

    /*
     * 取得指定分组的子元素数
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        // TODO Auto-generated method stub
        return childMap.get(0).size();
    }

    /**
     * 取得与给定分组关联的数据
     */
    @Override
    public Object getGroup(int groupPosition) {
        return groupTitle.get(groupPosition);
    }

    /**
     * 取得分组数
     */
    @Override
    public int getGroupCount() {
        return groupTitle.size();
    }

    /**
     * 取得指定分组的ID.该组ID必须在组中是唯一的.必须不同于其他所有ID（分组及子项目的ID）
     */
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /*
     *Gets a View that displays the given group
     *return: the View corresponding to the group at the specified position
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder groupHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.exgroupview, null);
            groupHolder = new GroupHolder();
            groupHolder.groupImg = (ImageView) convertView.findViewById(R.id.city_group_img);
            groupHolder.groupText = (TextView) convertView.findViewById(R.id.city_group_tv);
            convertView.setTag(groupHolder);
        } else {
            groupHolder = (GroupHolder) convertView.getTag();
        }
        if (isExpanded) {
            groupHolder.groupImg.setBackgroundResource(R.drawable.downarrow);
        } else {
            groupHolder.groupImg.setBackgroundResource(R.drawable.rightarrow);
        }
        groupHolder.groupText.setText(groupTitle.get(groupPosition));
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        // Indicates whether the child and group IDs are stable across changes to the underlying data
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // Whether the child at the specified position is selectable
        return true;
    }

    /**
     * show the text on the child and group item
     */
    private class GroupHolder {
        ImageView groupImg;
        TextView groupText;
    }

    private class ChildHolder {
        ImageView childImg;
        TextView childText;
    }


}

