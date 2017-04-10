package main.com.bsuir.autoservice.bean;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.*;

public class order extends Bean{
    public enum State{
        QUEUED, EXECUTING, DONE, REJECTED
    }

    public int getId() {
        return id;
    }

    public void setId(int value){
        this.id = value;
    }

    public int getUserId(){
        return user_id;
    }

    public void setUserId(int value){
        this.user_id = value;
    }

    public int getServiceShopId(){
        return service_shop_id;
    }

    public void setServiceShopId(int value){
        this.service_shop_id = value;
    }

    public Date getDateOpen(){
        return date_open;
    }

    public void setDateOpen(Date value){
        this.date_open = value;
    }

    public Date getDateClose(){
        return date_close;
    }

    public void setDateClose(Date value){
        this.date_close = value;
    }

    public int getSum(){
        return sum;
    }

    public void setSum(int value){
        this.sum = value;
    }

    public State getState(){
        return state;
    }

    public void setState(State value){
        this.state = value;
    }

    @Override
    public Field[] getFieldsOrdered() throws NoSuchFieldException{
        Class type = this.getClass();
        Field[] fields = {
                type.getDeclaredField("id"),
                type.getDeclaredField("user_id"),
                type.getDeclaredField("service_shop_id"),
                type.getDeclaredField("date_open"),
                type.getDeclaredField("date_close"),
                type.getDeclaredField("sum"),
                type.getDeclaredField("state")
        };
        for (Field field: fields) {
            field.setAccessible(true);
        }
        return fields;
    }

    @Override
    public order setFields(Map<String, String> fieldValues) throws ParseException{
        id = Integer.valueOf(fieldValues.get("id"));
        user_id = Integer.valueOf(fieldValues.get("user_id"));
        service_shop_id = Integer.valueOf(fieldValues.get("service_shop_id"));
        date_open = dateFormat.parse(fieldValues.get("date_open"));
        date_close = dateFormat.parse(fieldValues.get("date_close"));
        sum = Integer.valueOf(fieldValues.get("sum"));
        state = State.valueOf(fieldValues.get("state"));
        return this;
    }

    private int id;
    private int user_id;
    private int service_shop_id;
    private Date date_open;
    private Date date_close;
    private int sum;
    private State state;
}
