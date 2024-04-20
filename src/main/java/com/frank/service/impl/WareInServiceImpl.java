package com.frank.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.frank.entity.WareIn;
import com.frank.entity.WareInDetail;
import com.frank.mapper.WareInMapper;
import com.frank.service.WareInDetailService;
import com.frank.service.WareInService;
import com.frank.vo.WareInDetailVo;
import com.frank.vo.WareInVo;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: uicsoft-frank
 * @Date: 2024/4/19 14:27 周五
 * @Project_Name: Study
 * @Version: 1.0
 * @description TODO
 */
@Service
@AllArgsConstructor
public class WareInServiceImpl extends ServiceImpl<WareInMapper, WareIn> implements WareInService {
    private final WareInDetailService wareInDetailService;


    /**
     * 新增或者更新
     *
     * @param wareInVo
     *
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdateWareIn(WareInVo wareInVo) {
        //如果有id，那么就是更新，全都删掉
        if (wareInVo.getId() != null) {
            this.removeById(wareInVo.getId());
            wareInDetailService.remove(Wrappers.<WareInDetail>lambdaQuery().eq(WareInDetail::getWareInId, wareInVo.getId()));
        }

        WareIn convert = wareInVo.convert();
        boolean b = this.saveOrUpdate(convert);

        List<WareInDetail> detailList = wareInVo.convertList(convert.getId());
        boolean b1 = wareInDetailService.saveOrUpdateBatch(detailList);

        return b && b1;
    }
}
