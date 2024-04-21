package com.frank.test;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @auther: frank gee
 * @date: 2024-4-21 15:20 周日
 * @project_name: MyBean
 * @version: 1.0
 * @description TODO
 */
@Data
@Accessors(chain = true)
public class Animal {
    private String name;
}
