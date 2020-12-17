package com.jy.day01.model.bean;

import java.util.List;

public class Bean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * name : item1
         * select : true
         */

        private String name;
        private boolean select;
        private boolean lv;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isSelect() {
            return select;
        }

        public void setSelect(boolean select) {
            this.select = select;
        }

        public boolean isLv() {
            return lv;
        }

        public void setLv(boolean lv) {
            this.lv = lv;
        }
    }
}
