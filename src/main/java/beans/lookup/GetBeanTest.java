package beans.lookup;

/**
 * Copyright (c) 2020 Kimi. All Rights Reserved
 *
 * @Date 2020/5/29 18:53
 * @Author Feng Yalong
 */
public abstract class GetBeanTest {

    public void showMe() {
        this.getBean().showMe();
    }

    public abstract User getBean();
}
