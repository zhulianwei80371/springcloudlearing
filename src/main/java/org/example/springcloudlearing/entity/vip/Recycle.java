package org.example.springcloudlearing.entity.vip;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.springcloudlearing.entity.Base;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName t_recycle
 */
@TableName(value ="t_recycle")
@Data
@EqualsAndHashCode(callSuper=false)
public class Recycle extends Base {

    private String operation;
    private String lastInfo;
    @Override
    public void setProperties() {

    }
}