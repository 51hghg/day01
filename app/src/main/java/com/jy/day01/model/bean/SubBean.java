package com.jy.day01.model.bean;

import java.util.List;

public class SubBean {

    /**
     * errno : 0
     * errmsg :
     * data : {"count":9,"totalPages":1,"pageSize":100,"currentPage":1,"data":[{"id":1129016,"name":"新疆阿瓦提长绒棉弱捻超柔毛巾","list_pic_url":"http://yanxuan.nosdn.127.net/a7c7eec41194e65d64931a2d08ef4f8c.png","retail_price":29},{"id":1129015,"name":"阿瓦提长绒棉超柔弱捻浴巾","list_pic_url":"http://yanxuan.nosdn.127.net/fc11a482efeece9630548d8b350e7f54.png","retail_price":89},{"id":1128011,"name":"趣味粉彩单面纱布超柔浴巾","list_pic_url":"http://yanxuan.nosdn.127.net/d6e25ec5b4ad7aa37e077ce751b56f46.png","retail_price":79},{"id":1128010,"name":"趣味粉彩单面纱布亲肤毛巾","list_pic_url":"http://yanxuan.nosdn.127.net/a84e8e6979f00efd9a728ed36b154753.png","retail_price":29},{"id":1111010,"name":"静谧森林简欧色织提花面巾","list_pic_url":"http://yanxuan.nosdn.127.net/ef7efe55839e66993fb604dc3c2d9410.png","retail_price":69},{"id":1021001,"name":"全棉进口埃及长绒棉浴巾","list_pic_url":"http://yanxuan.nosdn.127.net/fd5a8622ee1a7dfd4b57b938ebf25b24.png","retail_price":99},{"id":1021000,"name":"埃及进口长绒棉毛巾","list_pic_url":"http://yanxuan.nosdn.127.net/7191f2599c7fe44ed4cff7a76e853154.png","retail_price":39},{"id":1009027,"name":"皇室御用超柔毛巾80s","list_pic_url":"http://yanxuan.nosdn.127.net/71cfd849335c498dee3c54d1eb823c17.png","retail_price":79},{"id":1006051,"name":"皇室御用超柔毛巾","list_pic_url":"http://yanxuan.nosdn.127.net/ad5a317216f9da495b144070ecf1f957.png","retail_price":59}],"filterCategory":[{"id":0,"name":"全部","checked":false},{"id":1005000,"name":"居家","checked":false},{"id":1005001,"name":"餐厨","checked":false},{"id":1008000,"name":"配件","checked":false},{"id":1010000,"name":"服装","checked":false},{"id":1013001,"name":"洗护","checked":true},{"id":1011000,"name":"婴童","checked":false},{"id":1012000,"name":"杂货","checked":false},{"id":1005002,"name":"饮食","checked":false},{"id":1019000,"name":"志趣","checked":false}],"goodsList":[{"id":1129016,"name":"新疆阿瓦提长绒棉弱捻超柔毛巾","list_pic_url":"http://yanxuan.nosdn.127.net/a7c7eec41194e65d64931a2d08ef4f8c.png","retail_price":29},{"id":1129015,"name":"阿瓦提长绒棉超柔弱捻浴巾","list_pic_url":"http://yanxuan.nosdn.127.net/fc11a482efeece9630548d8b350e7f54.png","retail_price":89},{"id":1128011,"name":"趣味粉彩单面纱布超柔浴巾","list_pic_url":"http://yanxuan.nosdn.127.net/d6e25ec5b4ad7aa37e077ce751b56f46.png","retail_price":79},{"id":1128010,"name":"趣味粉彩单面纱布亲肤毛巾","list_pic_url":"http://yanxuan.nosdn.127.net/a84e8e6979f00efd9a728ed36b154753.png","retail_price":29},{"id":1111010,"name":"静谧森林简欧色织提花面巾","list_pic_url":"http://yanxuan.nosdn.127.net/ef7efe55839e66993fb604dc3c2d9410.png","retail_price":69},{"id":1021001,"name":"全棉进口埃及长绒棉浴巾","list_pic_url":"http://yanxuan.nosdn.127.net/fd5a8622ee1a7dfd4b57b938ebf25b24.png","retail_price":99},{"id":1021000,"name":"埃及进口长绒棉毛巾","list_pic_url":"http://yanxuan.nosdn.127.net/7191f2599c7fe44ed4cff7a76e853154.png","retail_price":39},{"id":1009027,"name":"皇室御用超柔毛巾80s","list_pic_url":"http://yanxuan.nosdn.127.net/71cfd849335c498dee3c54d1eb823c17.png","retail_price":79},{"id":1006051,"name":"皇室御用超柔毛巾","list_pic_url":"http://yanxuan.nosdn.127.net/ad5a317216f9da495b144070ecf1f957.png","retail_price":59}]}
     */

    private int errno;
    private String errmsg;
    private DataBeanX data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * count : 9
         * totalPages : 1
         * pageSize : 100
         * currentPage : 1
         * data : [{"id":1129016,"name":"新疆阿瓦提长绒棉弱捻超柔毛巾","list_pic_url":"http://yanxuan.nosdn.127.net/a7c7eec41194e65d64931a2d08ef4f8c.png","retail_price":29},{"id":1129015,"name":"阿瓦提长绒棉超柔弱捻浴巾","list_pic_url":"http://yanxuan.nosdn.127.net/fc11a482efeece9630548d8b350e7f54.png","retail_price":89},{"id":1128011,"name":"趣味粉彩单面纱布超柔浴巾","list_pic_url":"http://yanxuan.nosdn.127.net/d6e25ec5b4ad7aa37e077ce751b56f46.png","retail_price":79},{"id":1128010,"name":"趣味粉彩单面纱布亲肤毛巾","list_pic_url":"http://yanxuan.nosdn.127.net/a84e8e6979f00efd9a728ed36b154753.png","retail_price":29},{"id":1111010,"name":"静谧森林简欧色织提花面巾","list_pic_url":"http://yanxuan.nosdn.127.net/ef7efe55839e66993fb604dc3c2d9410.png","retail_price":69},{"id":1021001,"name":"全棉进口埃及长绒棉浴巾","list_pic_url":"http://yanxuan.nosdn.127.net/fd5a8622ee1a7dfd4b57b938ebf25b24.png","retail_price":99},{"id":1021000,"name":"埃及进口长绒棉毛巾","list_pic_url":"http://yanxuan.nosdn.127.net/7191f2599c7fe44ed4cff7a76e853154.png","retail_price":39},{"id":1009027,"name":"皇室御用超柔毛巾80s","list_pic_url":"http://yanxuan.nosdn.127.net/71cfd849335c498dee3c54d1eb823c17.png","retail_price":79},{"id":1006051,"name":"皇室御用超柔毛巾","list_pic_url":"http://yanxuan.nosdn.127.net/ad5a317216f9da495b144070ecf1f957.png","retail_price":59}]
         * filterCategory : [{"id":0,"name":"全部","checked":false},{"id":1005000,"name":"居家","checked":false},{"id":1005001,"name":"餐厨","checked":false},{"id":1008000,"name":"配件","checked":false},{"id":1010000,"name":"服装","checked":false},{"id":1013001,"name":"洗护","checked":true},{"id":1011000,"name":"婴童","checked":false},{"id":1012000,"name":"杂货","checked":false},{"id":1005002,"name":"饮食","checked":false},{"id":1019000,"name":"志趣","checked":false}]
         * goodsList : [{"id":1129016,"name":"新疆阿瓦提长绒棉弱捻超柔毛巾","list_pic_url":"http://yanxuan.nosdn.127.net/a7c7eec41194e65d64931a2d08ef4f8c.png","retail_price":29},{"id":1129015,"name":"阿瓦提长绒棉超柔弱捻浴巾","list_pic_url":"http://yanxuan.nosdn.127.net/fc11a482efeece9630548d8b350e7f54.png","retail_price":89},{"id":1128011,"name":"趣味粉彩单面纱布超柔浴巾","list_pic_url":"http://yanxuan.nosdn.127.net/d6e25ec5b4ad7aa37e077ce751b56f46.png","retail_price":79},{"id":1128010,"name":"趣味粉彩单面纱布亲肤毛巾","list_pic_url":"http://yanxuan.nosdn.127.net/a84e8e6979f00efd9a728ed36b154753.png","retail_price":29},{"id":1111010,"name":"静谧森林简欧色织提花面巾","list_pic_url":"http://yanxuan.nosdn.127.net/ef7efe55839e66993fb604dc3c2d9410.png","retail_price":69},{"id":1021001,"name":"全棉进口埃及长绒棉浴巾","list_pic_url":"http://yanxuan.nosdn.127.net/fd5a8622ee1a7dfd4b57b938ebf25b24.png","retail_price":99},{"id":1021000,"name":"埃及进口长绒棉毛巾","list_pic_url":"http://yanxuan.nosdn.127.net/7191f2599c7fe44ed4cff7a76e853154.png","retail_price":39},{"id":1009027,"name":"皇室御用超柔毛巾80s","list_pic_url":"http://yanxuan.nosdn.127.net/71cfd849335c498dee3c54d1eb823c17.png","retail_price":79},{"id":1006051,"name":"皇室御用超柔毛巾","list_pic_url":"http://yanxuan.nosdn.127.net/ad5a317216f9da495b144070ecf1f957.png","retail_price":59}]
         */

        private int count;
        private int totalPages;
        private int pageSize;
        private int currentPage;
        private List<DataBean> data;
        private List<FilterCategoryBean> filterCategory;
        private List<GoodsListBean> goodsList;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public List<FilterCategoryBean> getFilterCategory() {
            return filterCategory;
        }

        public void setFilterCategory(List<FilterCategoryBean> filterCategory) {
            this.filterCategory = filterCategory;
        }

        public List<GoodsListBean> getGoodsList() {
            return goodsList;
        }

        public void setGoodsList(List<GoodsListBean> goodsList) {
            this.goodsList = goodsList;
        }

        public static class DataBean {
            /**
             * id : 1129016
             * name : 新疆阿瓦提长绒棉弱捻超柔毛巾
             * list_pic_url : http://yanxuan.nosdn.127.net/a7c7eec41194e65d64931a2d08ef4f8c.png
             * retail_price : 29
             */

            private int id;
            private String name;
            private String list_pic_url;
            private String retail_price;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getList_pic_url() {
                return list_pic_url;
            }

            public void setList_pic_url(String list_pic_url) {
                this.list_pic_url = list_pic_url;
            }

            public String getRetail_price() {
                return retail_price;
            }

            public void setRetail_price(String retail_price) {
                this.retail_price = retail_price;
            }
        }

        public static class FilterCategoryBean {
            /**
             * id : 0
             * name : 全部
             * checked : false
             */

            private int id;
            private String name;
            private boolean checked;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public boolean isChecked() {
                return checked;
            }

            public void setChecked(boolean checked) {
                this.checked = checked;
            }
        }

        public static class GoodsListBean {
            /**
             * id : 1129016
             * name : 新疆阿瓦提长绒棉弱捻超柔毛巾
             * list_pic_url : http://yanxuan.nosdn.127.net/a7c7eec41194e65d64931a2d08ef4f8c.png
             * retail_price : 29
             */

            private int id;
            private String name;
            private String list_pic_url;
            private String retail_price;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getList_pic_url() {
                return list_pic_url;
            }

            public void setList_pic_url(String list_pic_url) {
                this.list_pic_url = list_pic_url;
            }

            public String getRetail_price() {
                return retail_price;
            }

            public void setRetail_price(String retail_price) {
                this.retail_price = retail_price;
            }
        }
    }
}
