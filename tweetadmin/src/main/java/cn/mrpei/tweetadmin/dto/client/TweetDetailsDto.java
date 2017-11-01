package cn.mrpei.tweetadmin.dto.client;

import cn.mrpei.tweetadmin.bean.client.TweetDetails;

/**
 * Date:2017/10/26
 * Time:9:59
 *
 * @author 裴周宇
 */
public class TweetDetailsDto extends TweetDetails {

    private String hasUpdate;

    private String hasAdd;

    private String searchCondition;

    private String updateInfo;

    public String getUpdateInfo() {
        return updateInfo;
    }

    public void setUpdateInfo(String updateInfo) {
        this.updateInfo = updateInfo;
    }

    public String getHasUpdate() {
        return hasUpdate;
    }

    public void setHasUpdate(String hasUpdate) {
        this.hasUpdate = hasUpdate;
    }

    public String getHasAdd() {
        return hasAdd;
    }

    public void setHasAdd(String hasAdd) {
        this.hasAdd = hasAdd;
    }

    public String getSearchCondition() {
        return searchCondition;
    }

    public void setSearchCondition(String searchCondition) {
        this.searchCondition = searchCondition;
    }
}
