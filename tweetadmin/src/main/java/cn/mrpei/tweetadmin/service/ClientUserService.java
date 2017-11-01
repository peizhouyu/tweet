package cn.mrpei.tweetadmin.service;

import cn.mrpei.tweetadmin.bean.Page;
import cn.mrpei.tweetadmin.bean.PageBean;
import cn.mrpei.tweetadmin.bean.client.ClientUser;
import cn.mrpei.tweetadmin.dto.client.ClientUserDto;

import java.util.List;

/**
 * Create by 裴周宇
 * Date:2017/10/12
 * Time:11:24
 */
public interface ClientUserService {
    /**
     * Find all client user list.
     * 获取全部客户端用户列表
     *
     * @param currentPage the current page
     * @param pageSize    the page size
     * @return the list
     */
    PageBean<ClientUserDto> findAllClientUser(int currentPage, int pageSize);

    /**
     * Find one client user by id client user dto.
     * 通过ID 查询制定用户信息
     *
     * @param id the id
     * @return the client user dto
     */
    ClientUserDto findOneClientUserById(Long id);

    /**
     * Update client user boolean.
     * 管理员修改用户信息
     * @param clientUserDto the client user dto
     * @return the boolean
     */
    boolean updateClientUser(ClientUserDto clientUserDto);


    /**
     * Delete client user boolean.
     * 根据id 删除用户
     * @param id the id
     * @return the boolean
     */
    boolean deleteClientUser(Long id);

    PageBean<ClientUserDto> searchClientUserByAccountOrRealName(String name,int currentPage, int pageSize);
}
