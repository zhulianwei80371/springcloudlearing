package org.example.springcloudlearing.entity.vip;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.springcloudlearing.entity.Base;
import org.example.springcloudlearing.enums.vip.UserStatus;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName t_user
 */
@TableName(value ="t_user")
@Data
@EqualsAndHashCode(callSuper=false)
public class User   extends  Base {
//    @TableId(type = IdType.ASSIGN_UUID)
//    @ApiModelProperty("主键id")
//    private String id;
//
//    @TableField(value = "deleted")
//    @ApiModelProperty(value ="删除标识：0-未删除 1-删除")
//    @ApiParam(hidden = true)
//    private Boolean deleted;
//
//    @TableField(value = "created_by")
//    @ApiModelProperty("创建人用户id")
//    @ApiParam(hidden = true)
//    private String createdBy;
//
//    @TableField(value = "created_date")
//    @ApiModelProperty("创建时间")
//    @ApiParam(hidden = true)
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
//    private Date createdDate;
//
//
//    @TableField("last_modified_by")
//    @ApiModelProperty("最后修改人用户id")
//    @ApiParam(hidden = true)
//    private String lastModifiedBy;
//
//    @TableField("last_modified_date")
//    @ApiModelProperty("最后修改时间")
//    @ApiParam(hidden = true)
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
//    private Date lastModifiedDate;
//
//    @TableField("version")
//    @ApiModelProperty("数据版本")
//    @ApiParam(hidden = true)
//    private Integer version;
//
//    @TableField("txte")
//    @ApiModelProperty("数据版本")
//    @ApiParam(hidden = true)
//    private Integer txte;
    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 余额
     */
    @TableField(value = "balance")
    private BigDecimal balance;

    @TableField(value ="status")
    @Column(type = MySqlTypeConstant.VARCHAR, comment = "用户状态")
    private UserStatus status;

    @Override
    public void setProperties() {

    }
}