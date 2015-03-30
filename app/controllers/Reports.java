package controllers;

import com.avaje.ebean.*;


import models.*;
import models.DateFilter;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.test;
import views.html.test3;


import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by ftominc on 19/03/15.
 */
public class Reports extends Controller{
    /**
     * Generate a report of the neighborhoods
     * with most Car Accidents
     * @return Action Page with neighborhoods sorted
     * by Car Accidents
     */
    public static Result neighborhoodReport(){

        String sql = "select neighborhood,count(Id) as c " +
                "from car_accident " +
                "GROUP BY neighborhood " +
                "ORDER BY count(Id) DESC " +
                "limit 10";

        String[] data = {"neighborhood","c"};

        List l = find(sql,data);
        return ok(test3.render(l));
    }
    public static Result neighborhoodReportByDate(){
        DateFilter dateFilter = Form.form(DateFilter.class).bindFromRequest().get();

        String sql = "select neighborhood,count(Id) as c " +
                "from car_accident " +
                "where date between '" +
                dateFilter.getInitial() +
                "' and '" + dateFilter.getDfinal() +
                "' GROUP BY neighborhood " +
                "ORDER BY count(Id) DESC";

        String[] data = {"neighborhood","c"};


        List l = find(sql,data);
        return ok(test3.render(l));
    }

    private static List find(String sql,String[] params){
        int S = 0;
        SqlQuery sqlQuery = Ebean.createSqlQuery(sql);
        List<SqlRow> list = sqlQuery.findList();
        List<ReportData> l = new ArrayList<>();

        for(SqlRow s: list){
            l.add(new ReportData(s.getString(params[0]), s.getInteger(params[1])));
            S+=s.getInteger(params[1]);
        }
        l.add(new ReportData("Total", S));
        return l;
    }
}