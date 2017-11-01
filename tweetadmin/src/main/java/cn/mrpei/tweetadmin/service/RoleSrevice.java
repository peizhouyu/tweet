package cn.mrpei.tweetadmin.service;

import cn.mrpei.tweetadmin.bean.Role;
import cn.mrpei.tweetadmin.dto.RoleDto;

import java.util.List;

/**
 * Create by 裴周宇
 * Date:2017/10/3
 * Time:17:13
 */
public interface RoleSrevice {

    /**
     * Gets role list.
     * 获取所有角色信息
     *
     * @return the role list
     */
    List<RoleDto> getRoleList();

    /**
     * Add role boolean.
     * 添加角色
     *
     * @param roleDto the role dto
     * @return the boolean
     */
    boolean addRole(RoleDto roleDto);

    /**
     * Gets available role list.
     *
     *  获取启用的角色列表 status = 启用
     * @return the available role list
     */
    List<RoleDto> getAvailableRoleList();
}
