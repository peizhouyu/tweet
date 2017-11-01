package cn.mrpei.dto;

import java.util.ArrayList;
import java.util.List;

public class TweetDetailsListDto {
    private boolean hasMore;
    private List<TweetDetailsDto> data;

    public TweetDetailsListDto() {
        this.data = new ArrayList<TweetDetailsDto>();
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<TweetDetailsDto> getData() {
        return data;
    }

    public void setData(List<TweetDetailsDto> data) {
        this.data = data;
    }
}
