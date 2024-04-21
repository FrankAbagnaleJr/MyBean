package com.frank.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.frank.entity.WareIn;
import com.frank.entity.WareInDetail;
import com.frank.vo.WareInVo;

import java.util.List;

/**
 * @Auther: uicsoft-frank
 * @Date: 2024/4/19 14:26 周五
 * @Project_Name: Study
 * @Version: 1.0
 * @description TODO
 */
public interface WareInService extends IService<WareIn> {

    /**
     * 新增或者更新
     * @param wareInVo
     * @return
     */
    boolean saveOrUpdateWareIn(WareInVo wareInVo);

    /**
     * 删除全部
     * @param wareInVo
     * @return
     */
    boolean removeAll(WareInVo wareInVo);

}
