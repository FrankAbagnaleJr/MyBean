/*
 * UICSOFT 公司拥有本软件版权2021,并保留所有权利。
 * Copyright 2021, UICSOFT Company Limited.
 * All rights reserved.
 *
 */
package com.frank.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frank.entity.WareIn;
import com.frank.vo.WareInVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 接口权限
 * @author: uicsoft-cg
 * @create: 2021-08-23 11:50
 */
@Mapper
public interface WareInMapper extends BaseMapper<WareIn> {


//    List<WareIn> selectAll(@Param("id") Long id);
    /**
     * 根据id查询所有出库信息
     * @param id
     * @return
     */
    WareIn getOneById(@Param("id") Long id);

    List<WareIn> getAll();

    List<WareInVo> getInList();

    /**
     * 删除全部
     * @param wareInVo
     * @return
     */
    boolean removeAll(WareInVo wareInVo);
}
