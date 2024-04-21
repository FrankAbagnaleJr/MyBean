package com.frank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @auther: frank gee
 * @date: 2024-4-21 11:39 周日
 * @project_name: MyBean
 * @version: 1.0
 * @description TODO
 */
@Getter
@Setter
@Accessors(fluent  = true)
public class Student {
    private String name;
    private Integer age;
}
