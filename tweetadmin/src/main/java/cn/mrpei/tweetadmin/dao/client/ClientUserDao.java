package cn.mrpei.tweetadmin.dao.client;

import cn.mrpei.tweetadmin.bean.client.ClientUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by 裴周宇
 * Date:2017/10/11
 * Time:11:03
 */

@Mapper
@Repository
public interface ClientUserDao {
    List<ClientUser> selectAllClientUser();
    List<ClientUser> selectClientUserByPhone(ClientUser user);
    List<ClientUser> selectClientUser(ClientUser user);
    List<ClientUser> selectClientUserByName(ClientUser user);
    int insertClientUser(ClientUser user);
    int updateClientUserHeadImg(ClientUser user);

    int countClientUser();

    ClientUser selectClientUserById(Long id);

    int updateClientUser(ClientUser clientUser);

    int deleteClientUserById(Long id);

    List<ClientUser> selectClientUserBySearch(String name);

    int countClientUserBySearch(String name);

}
