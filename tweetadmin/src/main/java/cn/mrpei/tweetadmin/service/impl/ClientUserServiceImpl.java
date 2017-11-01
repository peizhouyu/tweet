package cn.mrpei.tweetadmin.service.impl;

import cn.mrpei.tweetadmin.bean.PageBean;
import cn.mrpei.tweetadmin.bean.client.ClientUser;
import cn.mrpei.tweetadmin.dao.client.ClientUserDao;
import cn.mrpei.tweetadmin.dto.client.ClientUserDto;
import cn.mrpei.tweetadmin.service.ClientUserService;
import cn.mrpei.tweetadmin.utils.CommonUtils;
import cn.mrpei.tweetadmin.utils.StaticClass;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by 裴周宇
 * Date:2017/10/12
 * Time:11:27
 */
@Service
public class ClientUserServiceImpl implements ClientUserService {

    @Autowired
    private ClientUserDao clientUserDao;

    @Override
    public PageBean<ClientUserDto> findAllClientUser(int currentPage,int pageSize) {
       PageHelper.startPage(currentPage, pageSize);
       List<ClientUser> list = clientUserDao.selectAllClientUser();

       List<ClientUserDto> result = new ArrayList<>();
       for (ClientUser clientUserTmpl : list){
           //TODO 去除时间转换后 秒 最后面的 点零 这里只是简单的字符串截取  方法需要改进
           clientUserTmpl.setCreateTime(CommonUtils.removeZero(clientUserTmpl.getCreateTime()));
           ClientUserDto clientUserDto = new ClientUserDto();
           result.add(clientUserDto);
           BeanUtils.copyProperties(clientUserTmpl,clientUserDto);
       }
        int countNums = clientUserDao.countClientUser();
        PageBean<ClientUserDto> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(result);
       return pageData;
    }

    @Override
    public ClientUserDto findOneClientUserById(Long id) {
        ClientUserDto clientUserDto = new ClientUserDto();
        ClientUser  clientUser = clientUserDao.selectClientUserById(id);

        BeanUtils.copyProperties(clientUser,clientUserDto);
        return clientUserDto;
    }

    @Override
    public boolean updateClientUser(ClientUserDto clientUserDto) {
        ClientUser clientUser = new ClientUser();
        BeanUtils.copyProperties(clientUserDto, clientUser);
        int result =  clientUserDao.updateClientUser(clientUser);
        return result == 1 ? true : false;
    }

    @Override
    public boolean deleteClientUser(Long id) {
        int result = clientUserDao.deleteClientUserById(id);
        return result == 1 ? true : false;
    }

    @Override
    public PageBean<ClientUserDto> searchClientUserByAccountOrRealName(String name, int currentPage, int pageSize) {
        int countNums = clientUserDao.countClientUserBySearch(name);
        List<ClientUser> list;
        String searchInfo = null;
        if (countNums == 0){
            PageHelper.startPage(currentPage, pageSize);
            list = clientUserDao.selectAllClientUser();
            countNums = clientUserDao.countClientUser();
            searchInfo = StaticClass.SEARCH_CLIENT_USER_INFO;
        }else {
            PageHelper.startPage(currentPage, pageSize);
            list = clientUserDao.selectClientUserBySearch(name);

        }

        List<ClientUserDto> result = new ArrayList<>();
        for (ClientUser clientUserTmpl : list){
            ClientUserDto clientUserDto = new ClientUserDto();
            result.add(clientUserDto);
            BeanUtils.copyProperties(clientUserTmpl,clientUserDto);
        }

        PageBean<ClientUserDto> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(result);
        pageData.setInfo(searchInfo);
        return pageData;

    }



}
