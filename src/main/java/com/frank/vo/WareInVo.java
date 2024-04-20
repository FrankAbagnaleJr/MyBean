package com.frank.vo;


import com.frank.entity.WareIn;
import com.frank.entity.WareInDetail;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Auther: uicsoft-frank
 * @Date: 2024/4/19 15:55 周五
 * @Project_Name: Study
 * @Version: 1.0
 * @description TODO
 */
@Data
public class WareInVo extends WareIn {

    List<WareInDetailVo> list;
    @Override
    public String toString() {
        //因为不能直接访问父类中的私有属性，的通过get和set方法访问
        return "WareInVo{" +
                "id=" + this.getId() +
                ", wareInNo=" + this.getWareInNo() +
                ", wareInTime=" + this.getWareInTime() +
                ", wareInType=" + this.getWareInType() +
                ", wareInStatus=" + this.getWareInStatus() +
                ", list=" + list +
                '}';
    }

    public WareIn convert() {
        WareIn wareIn = new WareIn();
        BeanUtils.copyProperties(this, wareIn);
        if (Objects.isNull(wareIn.getId())) {
            wareIn.setWareInStatus(0);
            wareIn.setWareInNo("RK20240419-01");
            wareIn.setWareInTime(LocalDateTime.now());
        }
        return wareIn;
    }

    public List<WareInDetail> convertList(Long id){
        List<WareInDetail> detailList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(this.list)) {
            for (WareInDetailVo wareInDetailVo : this.list) {
                WareInDetail wareInDetail = new WareInDetail();
                BeanUtils.copyProperties(wareInDetailVo,wareInDetail);
                wareInDetail.setWareInId(id);
                detailList.add(wareInDetail);
            }
        }
        return detailList;
    }
}
