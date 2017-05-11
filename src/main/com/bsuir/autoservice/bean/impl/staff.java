package main.com.bsuir.autoservice.bean.impl;

import main.com.bsuir.autoservice.bean.Bean;
import main.com.bsuir.autoservice.bean.exception.BeanException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class staff extends Bean {
    public enum Specialization{
        MECHANIC, CHIEF_MECHANIC, ADMIN, DIRECTOR
    }

    public int getId(){
        return id;
    }

    public void setId(int value){
        this.id = value;
    }

    public int getServiceShopId(){
        return service_shop_id;
    }

    public void setServiceShopId(int value){
        this.service_shop_id = value;
    }

    public int getUserId(){
        return user_id;
    }

    public void setUserId(int value){
        this.user_id = value;
    }

    public Specialization getSpecialization(){
        return specialization;
    }

    public void setSpecialization(Specialization specialization){
        this.specialization = specialization;
    }

    @Override
    public Field[] getFieldsOrdered() throws BeanException {
        try {
            Class type = this.getClass();
            Field[] fields = {
                    type.getDeclaredField("id"),
                    type.getDeclaredField("service_shop_id"),
                    type.getDeclaredField("user_id"),
                    type.getDeclaredField("specialization")
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
    public staff setFields(Map<String, String> fieldValues) {
        id = Integer.valueOf(fieldValues.get("id"));
        service_shop_id = Integer.valueOf(fieldValues.get("service_shop_id"));
        user_id = Integer.valueOf(fieldValues.get("user_id"));
        specialization = Specialization.valueOf(fieldValues.get("specialization"));
        return this;
    }

    private Integer id;
    private Integer service_shop_id;
    private Integer user_id;
    private Specialization specialization;
}
