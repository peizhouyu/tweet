package cn.mrpei.tweetadmin.service.impl;

import cn.mrpei.tweetadmin.bean.Role;
import cn.mrpei.tweetadmin.dao.sys.RoleDao;
import cn.mrpei.tweetadmin.dto.RoleDto;
import cn.mrpei.tweetadmin.service.RoleSrevice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by 裴周宇
 * Date:2017/10/3
 * Time:17:13
 */
@Service
public class RoleServiceImpl implements RoleSrevice {

    @Autowired
    private RoleDao roleDao;
    @Override
    public List<RoleDto> getRoleList() {
        List<RoleDto> roleDtos= new ArrayList<RoleDto>();
        List<Role> list = roleDao.findAllRole();
        for (Role roleTemp : list){
            RoleDto roleDto = new RoleDto();
            roleDtos.add(roleDto);
            BeanUtils.copyProperties(roleTemp, roleDto);
        }
        return roleDtos;
    }

    @Override
    public boolean addRole(RoleDto roleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDto, role);
        int result = roleDao.insertRoleByOne(role);
        return result == 1 ? true : false;
    }

    @Override
    public List<RoleDto> getAvailableRoleList() {
        List<RoleDto> roleDtos= new ArrayList<RoleDto>();
        List<Role> list = roleDao.findAvailableRole();
        for (Role roleTemp : list){
            RoleDto roleDto = new RoleDto();
            roleDtos.add(roleDto);
            BeanUtils.copyProperties(roleTemp, roleDto);
        }
        return roleDtos;
    }


}
