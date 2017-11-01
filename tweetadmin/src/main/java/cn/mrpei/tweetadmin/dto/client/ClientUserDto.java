package cn.mrpei.tweetadmin.dto.client;

import cn.mrpei.tweetadmin.bean.client.ClientUser;

/**
 * Create by 裴周宇
 * Date:2017/10/11
 * Time:11:09
 */
public class ClientUserDto extends ClientUser {
    private String hasUpdate;

    private String hasAdd;

    private String searchName;

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    private Long clientUserId;

    public Long getClientUserId() {
        return clientUserId;
    }

    public void setClientUserId(Long clientUserId) {
        this.clientUserId = clientUserId;
    }

    public String getHasAdd() {
        return hasAdd;
    }

    public void setHasAdd(String hasAdd) {
        this.hasAdd = hasAdd;
    }

    public String getHasUpdate() {
        return hasUpdate;
    }

    public void setHasUpdate(String hasUpdate) {
        this.hasUpdate = hasUpdate;
    }
}
