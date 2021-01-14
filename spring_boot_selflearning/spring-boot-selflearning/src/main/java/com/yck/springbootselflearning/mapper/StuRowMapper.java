package com.yck.springbootselflearning.mapper;

import com.yck.springbootselflearning.dao.Stu;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.data.hadoop.hbase.RowMapper;

/**
 * @author ：yangchengkai@yunzhangfang.com
 * @description：TODO
 * @date ：2021/1/14 下午2:12
 */


public class StuRowMapper implements RowMapper<Stu> {

    private static byte[] INFO1 = "info1".getBytes();
    private static byte[] INFO2 = "info2".getBytes();
    private static byte[] NAME = "name".getBytes();
    private static byte[] GENDER = "gender".getBytes();
    private static byte[] TEL = "tel".getBytes();

    @Override
    public Stu mapRow(Result result, int rowNum) throws Exception {

        String name = Bytes.toString(result.getValue(INFO1, NAME));
        String gender = Bytes.toString(result.getValue(INFO1, GENDER));
        String tel = Bytes.toString(result.getValue(INFO2, TEL));
        Stu stu = new Stu();
        stu.setName(name);
        stu.setGender(gender);
        stu.setTel(tel);
        return stu;
    }
}
