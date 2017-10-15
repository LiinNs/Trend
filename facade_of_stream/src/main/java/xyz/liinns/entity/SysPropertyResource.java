package xyz.liinns.entity;

import javax.persistence.*;

@Table(name = "sys_property_resource")
public class SysPropertyResource {
    /**
     * property的名字
     */
    @Column(name = "property_name")
    private String propertyName;

    /**
     * property的属性
     */
    @Column(name = "property_value")
    private String propertyValue;

    /**
     * 获取property的名字
     *
     * @return property_name - property的名字
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * 设置property的名字
     *
     * @param propertyName property的名字
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    /**
     * 获取property的属性
     *
     * @return property_value - property的属性
     */
    public String getPropertyValue() {
        return propertyValue;
    }

    /**
     * 设置property的属性
     *
     * @param propertyValue property的属性
     */
    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }
}