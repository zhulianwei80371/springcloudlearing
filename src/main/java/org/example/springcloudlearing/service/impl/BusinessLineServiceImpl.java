package org.example.springcloudlearing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.springcloudlearing.entity.BusinessLine;
import org.example.springcloudlearing.mapper.BusinessLineMapper;
import org.example.springcloudlearing.service.BusinessLineService;
import org.springframework.stereotype.Service;

/**
* @author lianweizhu
* @description 针对表【t_business_line】的数据库操作Service实现
* @createDate 2024-08-19 15:03:23
*/
@Service
public class BusinessLineServiceImpl extends ServiceImpl<BusinessLineMapper, BusinessLine>
    implements BusinessLineService{

}




