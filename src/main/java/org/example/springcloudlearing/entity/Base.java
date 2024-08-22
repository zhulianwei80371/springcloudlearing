package org.example.springcloudlearing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Data
public abstract class Base implements Serializable {
    @TableId(type = IdType.ASSIGN_UUID)
    @ApiModelProperty("主键id")
    private String id;

    @TableField(value = "deleted")
    @ApiModelProperty(value ="删除标识：0-未删除 1-删除")
    @ApiParam(hidden = true)
    private Boolean deleted;

    @TableField(value = "created_by")
    @ApiModelProperty("创建人用户id")
    @ApiParam(hidden = true)
    private String createdBy;

    @TableField(value = "created_date")
    @ApiModelProperty("创建时间")
    @ApiParam(hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdDate;


    @TableField("last_modified_by")
    @ApiModelProperty("最后修改人用户id")
    @ApiParam(hidden = true)
    private String lastModifiedBy;

    @TableField("last_modified_date")
    @ApiModelProperty("最后修改时间")
    @ApiParam(hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastModifiedDate;

    @TableField("version")
    @ApiModelProperty("数据版本")
    @ApiParam(hidden = true)
    private Integer version;

    public abstract void setProperties();

}
