package cn.mrpei.tweetadmin.bean.common;

import cn.mrpei.tweetadmin.bean.Page;

/**
 * Create by 裴周宇
 * Date:2017/10/11
 * Time:10:55
 */
public class BaseBean {
    private Page page;

    public BaseBean() {
        this.page = new Page();
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
