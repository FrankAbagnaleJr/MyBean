package com.frank.controller;

import com.frank.entity.Student;
import com.frank.entity.WareIn;
import com.frank.entity.WareInDetail;
import com.frank.service.WareInService;
import com.frank.test.Animal;
import com.frank.test.Dog;
import com.frank.vo.WareInDetailVo;
import com.frank.vo.WareInVo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.AllArgsConstructor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        WareInDetailVo wareInDetailVo = new WareInDetailVo();
        wareInDetailVo.setProdId(123456L);
        wareInDetailVo.setWareInNum(100L);
        List<WareInDetailVo> list = new ArrayList<>();
        list.add(wareInDetailVo);
        wareInVo.setList(list);

        //链式编程new对象
//        Student student = new Student().setName("张三").setAge(25);
//        Student student = new Student().age(20).name("张三");

        // 模拟数据准备完毕
        boolean saveOrUpdate = wareInService.saveOrUpdateWareIn(wareInVo);

        if (!saveOrUpdate) {
            return "添加失败";
        }

        return "添加成功";
    }

    @GetMapping("/test")
    public String t() {
        WareInDetailVo wareInDetailVo = new WareInDetailVo();
        wareInDetailVo.setProdId(123456L);
        wareInDetailVo.setWareInNum(100L);
        List<WareInDetailVo> list = new ArrayList<>();
        list.add(wareInDetailVo);

        WareInVo wareInVo = new WareInVo();
        //TODO 此处有bug，其实是vo类，但是这里显示的实体类
        WareIn wareIn = wareInVo.setList(list).setId(1L).setWareInNo("rk6554-3").setWareInStatus(2).setWareInType(1).setWareInTime(LocalDateTime.now());

        System.out.println(wareIn.getClass().getName());
        System.out.println(wareIn.toString());

        List<WareInDetailVo> tlist = null;
        System.out.println(CollectionUtils.isEmpty(tlist));

        wareInService.saveOrUpdateWareIn((WareInVo) wareIn);

        return wareIn.toString();
    }

    public String removeAll(WareInVo wareInVo) {
        boolean b = wareInService.removeAll(wareInVo);
        return "";
    }

    public static void main(String[] args) {
        Animal animal = new Animal().setName("动物");
//        Animal dog = new Dog().setMeta("肉").setName("狗");
        Dog dog =(Dog) new Dog().setMeta("肉").setName("狗");

        System.out.println("animal的类型是："+animal.getClass().getName());
        System.out.println("dog的类型是："+dog.getClass().getName());

        System.out.println(dog);
    }


}
