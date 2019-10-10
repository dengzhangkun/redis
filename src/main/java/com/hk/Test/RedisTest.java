package com.hk.Test;

import com.google.gson.Gson;
import com.hk.util.RedisUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * -
 *
 * @ClassName: RedisTest
 * @Description:
 * @Author: Edwin
 * @Date: 2019/10/9 6:48 PM
 * @Version: 1.0
 */
@RestController
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation(value = "Test", notes = "Test")
    @GetMapping(value = "/Testinterface")
    public void findInterfaceByPage() {

        redisUtil.set("String1", "str");
        System.out.println("String1:  " + redisUtil.get("String1"));
        redisUtil.set("String2", "str2", 60 * 2);
        System.out.println("String2:  " + redisUtil.get("String2"));

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("int1", 1);
        map.put("int2", 2);
        map.put("int3", 3);
        redisUtil.set("map1", map, 60 * 2);
        System.out.println("map1:  " + redisUtil.get("map1"));

        TbReqheadVO vo = new TbReqheadVO();
        vo.setInterfaceId(123);
        vo.setDefaultValue("456");

        redisUtil.set("vo1", vo, 60 * 2);
        System.out.println("vo1:  " + new Gson().toJson(redisUtil.get("vo1")));

        TbReqheadVO vo2 = new TbReqheadVO();
        vo2.setInterfaceId(789);
        vo2.setDefaultValue("000");
        List<TbReqheadVO> listVo = new ArrayList<TbReqheadVO>();
        listVo.add(vo);
        listVo.add(vo2);
        redisUtil.set("listVo1", listVo, 60 * 2);
        System.out.println("listVo1:  " + new Gson().toJson(redisUtil.get("listVo1")));

    }
}