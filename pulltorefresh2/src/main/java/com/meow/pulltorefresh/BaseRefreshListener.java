package com.meow.pulltorefresh;


public interface BaseRefreshListener {


    /**
     * 刷新
     */
    void refresh();

    /**
     * 加载更多
     */
    void loadMore();
}
