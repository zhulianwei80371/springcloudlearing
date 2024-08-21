package org.example.springcloudlearing.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.util.concurrent.atomic.AtomicLong;


//public class UUIDGenerator implements IdentifierGenerator {
//    @Override
//    public Number nextId(Object entity) {
//        // 根据业务键调用分布式ID生成服务
//        String id = generateUniqueId();
//        // 返回生成的ID值
//        return RandomGenerator.getDefault().nextInt(999999999);
//    }
////    @Override
////    public Number nextId(Object entity) {
////        return   1d;
////    }
////
////    @Override
////    public String nextUUID(Object entity) {
////        // 使用实体类名作为业务键，或者提取参数生成业务键
////        String bizKey = entity.getClass().getName();
////        // 根据业务键调用分布式ID生成服务
////        String id = generateUniqueId();
////        // 返回生成的ID值
////        return id;
////    }
//
//
//        public static String generateUniqueId() {
//            UUID uuid = UUID.randomUUID();
//            String uniqueId = uuid.toString();
//            return uniqueId;
//        }
//}
    @Slf4j
    public class CustomIdGenerator implements IdentifierGenerator {

        private final AtomicLong al = new AtomicLong(1);

        @Override
        public Long nextId(Object entity) {
            //可以将当前传入的class全类名来作为bizKey,或者提取参数来生成bizKey进行分布式Id调用生成.
            String bizKey = entity.getClass().getName();
            log.info("bizKey:{}", bizKey);
            MetaObject metaObject = SystemMetaObject.forObject(entity);
            String name = (String) metaObject.getValue("name");
            final long id = al.getAndAdd(1);
            log.info("为{}生成主键值->:{}", name, id);
            return id + 20000;
        }

    @Override
    public String nextUUID(Object entity) {
        return IdentifierGenerator.super.nextUUID(entity);
    }
}