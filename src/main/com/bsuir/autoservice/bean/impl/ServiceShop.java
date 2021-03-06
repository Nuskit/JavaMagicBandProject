package main.com.bsuir.autoservice.bean.impl;

import main.com.bsuir.autoservice.bean.Bean;
import main.com.bsuir.autoservice.bean.exception.BeanException;

import java.lang.reflect.Field;
import java.util.*;

public class ServiceShop extends Bean<Integer> {

    @Override
    public Integer getId(){
        return id;
    }

    public void setId(int value){
        this.id = value;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String value){
        this.city = value;
    }

    public String getStreet(){
        return street;
    }

    public void setStreet(String value){
        this.street = value;
    }

    public String getHouse(){
        return house;
    }

    public void setHouse(String value){
        this.house = value;
    }

    public int getChiefId(){
        return chief_id;
    }

    public void setChiefId(int value){
        this.chief_id = value;
    }

    @Override
    public Field[] getFieldsOrdered() throws BeanException {
        try {
            Class type = this.getClass();
            Field[] fields = {
                    type.getDeclaredField("id"),
                    type.getDeclaredField("city"),
                    type.getDeclaredField("street"),
                    type.getDeclaredField("house"),
                    type.getDeclaredField("chief_id")
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
    public ServiceShop setFields(Map<String, String> fieldValues) {
        id = Integer.valueOf(fieldValues.get("id"));
        city = fieldValues.get("city");
        street = fieldValues.get("street");
        house = fieldValues.get("house");
        chief_id = Integer.valueOf(fieldValues.get("chief_id"));
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceShop that = (ServiceShop) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(city, that.city) &&
                Objects.equals(street, that.street) &&
                Objects.equals(house, that.house) &&
                Objects.equals(chief_id, that.chief_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, street, house, chief_id);
    }

    @Override
    public Field[] getRenderFields() throws BeanException{
        List<Field> fields = new ArrayList<>(Arrays.asList(getFieldsOrdered()));
        fields.remove(0);
        Field[] renderFieldsArray = new Field[fields.size()];
        fields.toArray(renderFieldsArray);
        return renderFieldsArray;
    }

    private Integer id;
    private String city;
    private String street;
    private String house;
    private Integer chief_id;
}
