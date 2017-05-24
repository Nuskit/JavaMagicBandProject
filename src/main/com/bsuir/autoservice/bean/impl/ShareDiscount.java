package main.com.bsuir.autoservice.bean.impl;

import main.com.bsuir.autoservice.bean.Bean;
import main.com.bsuir.autoservice.bean.exception.BeanException;

import javax.lang.model.type.NullType;
import java.lang.reflect.Field;
import java.util.*;

public class ShareDiscount extends Bean<NullType> {

    public int getShareId(){
        return share_id;
    }

    public void setShareId(int value){
        this.share_id = value;
    }

    public int getDiscountId(){
        return discount_id;
    }

    public void setDiscountId(int value){
        this.discount_id = value;
    }

    @Override
    public Field[] getFieldsOrdered() throws BeanException {
        try {
            Class type = this.getClass();
            Field[] fields = {
                    type.getDeclaredField("share_id"),
                    type.getDeclaredField("discount_id")
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
    public ShareDiscount setFields(Map<String, String> fieldValues) {
        share_id = Integer.valueOf(fieldValues.get("share_id"));
        discount_id = Integer.valueOf(fieldValues.get("discount_id"));
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
        ShareDiscount that = (ShareDiscount) o;
        return Objects.equals(share_id, that.share_id) &&
                Objects.equals(discount_id, that.discount_id);
    }

    @Override
    public Field[] getRenderFields() throws BeanException{
        return getFieldsOrdered();
    }

    @Override
    public int hashCode() {
        return Objects.hash(share_id, discount_id);
    }

    private Integer share_id;
    private Integer discount_id;
}
