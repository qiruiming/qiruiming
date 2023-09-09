package com.qrm.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("hl_test")
public class User {
    //职工id
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //职工姓名
    @TableField("emp_name")
    private String empName;

    //性别
    private String sex;

    //年龄
    private int age;

    //部门名称
    @TableField("dept_name")
    private String deptName;

    //学历
    @TableField("emp_degree_name")
    private String empDegreeName;

    //状态
    private String state;

    //创建时间
    @TableField("cr_time")
    private String crTime;

    //最后修改时间
    @TableField("last_time")
    private String lastTime;
}
