package com.frank.vo;

import com.frank.entity.WareInDetail;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @auther: frank gee
 * @date: 2024-4-20 22:30 周六
 * @project_name: MyBean
 * @version: 1.0
 * @description TODO
 */
@Data
public class WareInDetailVo extends WareInDetail {
    private String startDate;
    private String endtDate;

    public WareInDetail convert(Long id){
        WareInDetail wareInDetail = new WareInDetail();
        BeanUtils.copyProperties(this,wareInDetail);
        if (this.getWareInId() == null) {
            wareInDetail.setWareInId(id);
        }
        return wareInDetail;
    }
}
