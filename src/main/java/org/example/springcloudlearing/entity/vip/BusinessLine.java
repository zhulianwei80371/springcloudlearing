package org.example.springcloudlearing.entity.vip;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.springcloudlearing.entity.Base;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName t_business_line
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName(value ="t_business_line")
public class BusinessLine extends Base {


    private String business_line_code;
    private String series;

    @Override
    public void setProperties() {

    }
}