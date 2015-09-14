package com.example.myultra.listview;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by My ultra on 7/30/2015.
 */
public class JobsAdapter extends BaseExpandableListAdapter   {

    private Context ctx;
    private HashMap<String, List<String>> Jobs_Category;
    private List<String> Jobs_List;

//Constructor 
    public JobsAdapter(Context ctx, HashMap<String, List<String>> Jobs_Category, List<String> Jobs_List)
    {
        this.ctx = ctx;
        this.Jobs_Category = Jobs_Category;
        this.Jobs_List = Jobs_List;

    }

    @Override
    public Object getChild(int parent, int child) {


        return Jobs_Category.get(Jobs_List.get(parent)).get(child);
    }

    @Override
    public long getChildId(int parent, int child) {
        // TODO Auto-generated method stub
        return child;
    }



    @Override
    public View getChildView(int parent, int child, boolean lastChild, View convertview,
                             ViewGroup parentview)
    {
        String child_title =  (String) getChild(parent, child);
        if(convertview == null)
        {
            // It shows how the single child  layout will look like 
            LayoutInflater inflator = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflator.inflate(R.layout.child_layout, parentview,false);
        }
        TextView child_textview = (TextView) convertview.findViewById(R.id.child_txt);
        child_textview.setText(child_title);


        return convertview;
    }

    @Override
    public int getChildrenCount(int arg0) {

        return Jobs_Category.get(Jobs_List.get(arg0)).size();
    }

    @Override
    public Object getGroup(int arg0) {
        // TODO Auto-generated method stub
        return Jobs_List.get(arg0);
    }

    @Override
    public int getGroupCount() {
        // TODO Auto-generated method stub
        return Jobs_List.size();
    }

    @Override
    public long getGroupId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public View getGroupView(int parent, boolean isExpanded, View convertview, ViewGroup parentview) {
        // TODO Auto-generated method stub
        String group_title = (String) getGroup(parent);
        if(convertview == null)
        {
            // It shows how the whole parent layout will look like 
            LayoutInflater inflator = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflator.inflate(R.layout.parent_layout, parentview,false);
        }
        TextView parent_textview = (TextView) convertview.findViewById(R.id.parent_txt);
        parent_textview.setTypeface(null, Typeface.BOLD);
        parent_textview.setText(group_title);
        return convertview;
    }

    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isChildSelectable(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return true;
    }


}
