package com.technical.terchnicalsummary.model;

import lombok.Data;

/*
 * @ClassName Menu
 * @Description 菜单
 * @Author shuai_yu
 * @Date 2021/9/14 13:56
 **/
@Data
public class Menu {
    private Long id;
    private String name;
    private String url;
    private Long parentId;
    private String permission;
}
