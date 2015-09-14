package com.example.myultra.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by My ultra on 7/30/2015.
 */
public class DataProvider {

    public static HashMap<String, List<String>> getInfo()
    {
        HashMap<String, List<String>> JobsDetail = new HashMap<String, List<String>>();

        List<String> Jobs_Department = new ArrayList<String>();
        Jobs_Department.add("Application Programming Jobs");
        Jobs_Department.add("Application Programming Jobs");
        Jobs_Department.add("Business Intelligence Jobs");
        Jobs_Department.add("EDP Jobs");
        Jobs_Department.add("Corporate Planning Jobs");

        List<String> Jobs_Industry = new ArrayList<String>();
        Jobs_Industry.add("KPO Jobs");
        Jobs_Industry.add("Retail Jobs");
        Jobs_Industry.add("Teacher Jobs");
        Jobs_Industry.add("Recruitment Jobs");
        Jobs_Industry.add("Internet Jobs");


        JobsDetail.put("Jobs Department", Jobs_Department);
        JobsDetail.put("Jobs Industry", Jobs_Industry);

        return JobsDetail;

    }
}
