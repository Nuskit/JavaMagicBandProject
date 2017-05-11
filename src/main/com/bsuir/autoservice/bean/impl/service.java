package main.com.bsuir.autoservice.bean.impl;

import main.com.bsuir.autoservice.bean.Bean;
import main.com.bsuir.autoservice.bean.exception.BeanException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class service extends Bean {

    public int getId(){
        return id;
    }

    public void setId(int value){
        this.id = value;
    }

    public String getName(){
        return name;
    }

    public void setName(String value){
        this.name = value;
    }

    public  int getCost(){
        return cost;
    }

    public void setCost(int value){
        this.cost = value;
    }

    @Override
    public Field[] getFieldsOrdered() throws BeanException {
        try {
            Class type = this.getClass();
            Field[] fields = {
                    type.getDeclaredField("id"),
                    type.getDeclaredField("name"),
                    type.getDeclaredField("cost")
            };
            for (Field field: fields) {
                field.setAccessible(true);
            }
            return fields;
        }catch (Exception e){
            throw new BeanException(e);
        }
    }

    public List<String> getAutoGeneratedFields() throws BeanException{
        List<String> strings = new ArrayList<>();
        strings.add("id");
        return strings;
    }

    @Override
    public service setFields(Map<String, String> fieldValues) {
        id = Integer.valueOf(fieldValues.get("id"));
        name = fieldValues.get("name");
        cost = Integer.valueOf(fieldValues.get("cost"));
        return this;
    }

    private Integer id;
    private String name;
    private Integer cost;
}
