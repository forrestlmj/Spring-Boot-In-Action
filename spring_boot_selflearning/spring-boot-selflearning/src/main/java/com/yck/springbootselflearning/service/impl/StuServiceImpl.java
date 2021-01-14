package com.yck.springbootselflearning.service.impl;

import com.yck.springbootselflearning.common.StuEnum;
import com.yck.springbootselflearning.dao.Stu;
import com.yck.springbootselflearning.mapper.StuRowMapper;
import com.yck.springbootselflearning.service.StuService;
import com.yck.springbootselflearning.util.Check;
import io.micrometer.core.instrument.util.StringUtils;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：yangchengkai@yunzhangfang.com
 * @description：TODO
 * @date ：2021/1/14 下午2:32
 */

@Service
public class StuServiceImpl implements StuService {


    @Autowired
    private HbaseTemplate hbaseTemplate;
    private String STU_TABLE_NAME = "stu";
    @Override
    public Stu getStuById(String id) {

        Stu dto = this.hbaseTemplate.get(STU_TABLE_NAME, id, new StuRowMapper());
        if(!Check.AllFieldIsNull(dto)){
            dto.setId(id);
        }
        return dto;
    }

    @Override
    public Stu saveStu(Stu stu) {
        hbaseTemplate.put(STU_TABLE_NAME,stu.getId(), StuEnum.info2.toString(),StuEnum.tel.toString(), Bytes.toBytes(stu.getTel()));
        hbaseTemplate.put(STU_TABLE_NAME,stu.getId(),StuEnum.info1.toString(),StuEnum.name.toString(), Bytes.toBytes(stu.getName()));
        hbaseTemplate.put(STU_TABLE_NAME,stu.getId(),StuEnum.info1.toString(),StuEnum.gender.toString(), Bytes.toBytes(stu.getGender()));
        return stu;
    }

    @Override
    public void deleteStuById(String id) {
        hbaseTemplate.delete(STU_TABLE_NAME,id,StuEnum.info1.toString());
        hbaseTemplate.delete(STU_TABLE_NAME,id,StuEnum.info2.toString());
    }
}
