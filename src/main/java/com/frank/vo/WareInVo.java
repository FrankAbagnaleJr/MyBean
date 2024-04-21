package com.frank.vo;


import com.frank.entity.WareIn;
import com.frank.entity.WareInDetail;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
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
@ToString(callSuper = true)
@Accessors(chain = true)
public class WareInVo extends WareIn {

    List<WareInDetailVo> list;

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
