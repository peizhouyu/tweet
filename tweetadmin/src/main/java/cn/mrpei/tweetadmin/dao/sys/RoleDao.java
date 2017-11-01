package cn.mrpei.tweetadmin.dao.sys;

import cn.mrpei.tweetadmin.bean.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by 裴周宇
 * Date:2017/10/3
 * Time:17:15
 */
@Mapper
@Repository
public interface RoleDao {
    List<Role> findAllRole();
    int insertRoleByOne(Role role);

    List<Role> findAvailableRole();
}
