package com.frank.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Auther: uicsoft-frank
 * @Date: 2024/4/19 14:15 周五
 * @Project_Name: Study
 * @Version: 1.0
 * @description TODO
 */
@Data
@TableName("uic_ware_in")
public class WareIn {
    private Long id;
    private String wareInNo;
    private LocalDateTime wareInTime;
    private Integer wareInType;
    private Integer wareInStatus;
}
