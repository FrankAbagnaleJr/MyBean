package com.frank.controller;

import com.frank.entity.WareIn;
import com.frank.entity.WareInDetail;
import com.frank.service.WareInService;
import com.frank.vo.WareInDetailVo;
import com.frank.vo.WareInVo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Auther: uicsoft-frank
 * @Date: 2024/4/19 13:55 周五
 * @Project_Name: Study
 * @Version: 1.0
 * @description TODO
 */
@RestController
@AllArgsConstructor
@RequestMapping("/bean")
public class BeanCotroller {

    private final WareInService wareInService;

    @GetMapping("/save")
    public String save() { // @RequestBody WareInVO wareInVO
        //模拟前端传过来的VO类
        WareInVo wareInVo = new WareInVo();
        wareInVo.setWareInType(0);

        WareInDetailVo wareInDetail = new WareInDetailVo();
        wareInDetail.setProdId(123456L);
        wareInDetail.setWareInNum(100L);
        List<WareInDetailVo> list = new ArrayList<>();
        list.add(wareInDetail);
        wareInVo.setList(list);

        // 模拟数据准备完毕
        boolean saveOrUpdate = wareInService.saveOrUpdateWareIn(wareInVo);

        if (!saveOrUpdate) {
            return "添加失败";
        }

        return "添加成功";
    }

}
