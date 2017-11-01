package cn.mrpei.tweetadmin.dao.sys;

import cn.mrpei.tweetadmin.bean.Permission;

import java.util.List;

/**
 * Create by 裴周宇
 * Date:2017/10/4
 * Time:17:23
 */
public interface PermissionDao {
    public List<Permission> findAll();
    public List<Permission> findByAdminUserId(int userId);
}
