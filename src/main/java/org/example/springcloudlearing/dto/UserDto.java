package org.example.springcloudlearing.dto;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Data;
import org.example.springcloudlearing.enums.vip.UserStatus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class UserDto {
        private String id;
        private String created_by;
        private Date created_date;
        private Integer deleted;
        private String last_modified_by;
        private Date last_modified_date;
        private Integer version;
        private String email;
        private String name;
        private BigDecimal balance;
        private UserStatus status;
}