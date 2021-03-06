package main.com.bsuir.autoservice.bean.impl;

import main.com.bsuir.autoservice.bean.Bean;
import main.com.bsuir.autoservice.bean.exception.BeanException;

import javax.lang.model.type.NullType;
import java.lang.reflect.Field;
import java.util.*;

public class OrderSparePart extends Bean<NullType> {

    public int getSparePartId(){
        return spare_part_id;
    }

    public void setSparePartId(int value){
        this.spare_part_id = value;
    }

    public int getOrderId(){
        return order_id;
    }

    public void setOrderId(int value){
        this.order_id = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int value){
        this.count = value;
    }

    @Override
    public Field[] getFieldsOrdered() throws BeanException {
        try {
            Class type = this.getClass();
            Field[] fields = {
                    type.getDeclaredField("spare_part_id"),
                    type.getDeclaredField("order_id"),
                    type.getDeclaredField("count")
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
        return strings;
    }

    @Override
    public OrderSparePart setFields(Map<String, String> fieldValues) {
        spare_part_id = Integer.valueOf(fieldValues.get("spare_part_id"));
        order_id = Integer.valueOf(fieldValues.get("order_id"));
        count = Integer.valueOf(fieldValues.get("count"));
        return this;
    }

    @Override
    public NullType getId() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderSparePart that = (OrderSparePart) o;
        return Objects.equals(spare_part_id, that.spare_part_id) &&
                Objects.equals(order_id, that.order_id) &&
                Objects.equals(count, that.count);
    }

    @Override
    public Field[] getRenderFields() throws BeanException{
        return getFieldsOrdered();
    }

    @Override
    public int hashCode() {
        return Objects.hash(spare_part_id, order_id, count);
    }

    private Integer spare_part_id;
    private Integer order_id;
    private Integer count;
}
