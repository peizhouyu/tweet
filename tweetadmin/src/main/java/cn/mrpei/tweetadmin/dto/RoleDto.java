package cn.mrpei.tweetadmin.dto;

import cn.mrpei.tweetadmin.bean.Role;

/**
 * Create by 裴周宇
 * Date:2017/10/3
 * Time:17:08
 */
public class RoleDto extends Role {
    private String hasAdd;

    public String getHasAdd() {
        return hasAdd;
    }

    public void setHasAdd(String hasAdd) {
        this.hasAdd = hasAdd;
    }
}
