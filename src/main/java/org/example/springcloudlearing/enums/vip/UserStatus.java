package org.example.springcloudlearing.enums.vip;


import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import org.example.springcloudlearing.enums.BaseEnum;


public enum UserStatus implements BaseEnum {
    NORMAL("1","正常"),
    FRORZEN("2","冻结"),;

    @EnumValue
    private String key;
    @JsonValue
    private String value;
    /*构造函数*/
    private UserStatus(String key, String value) {
        this.key = key;
        this.value = value;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

}

