<template>
    <div class="nearby-store">
        <div class="nearby-store-title">
            <text style="font-size: 36px">———— 附近的店铺一樣 ————</text>
        </div>
        <div class="item-container"
             :style="{ height: (tabPageHeight - 120) + 'px' }">
            <div class="border-cell"></div>
            <div v-for="(store,index) in stores"
                 class="cell"
                 :key="index"
                 @click="storeDetail">
                <store-item :image="store.storeImg"
                            :title="store.storeName"
                            :desc="store.desc"
                            :tags="store.tags"
                            :price="store.storePrice"
                            :price-desc="store.priceDesc"></store-item>
            </div>
        </div>
    </div>
</template>

<script>
    import {WxcTabPage, WxcPanItem, Utils} from 'weex-ui';
    import StoreItem from './storeItem.vue';

    export default {
        components: {WxcTabPage, WxcPanItem, StoreItem},
        data: () => ({
            stores: [
                {
                    id:1,
                    title:'四川旅游',
                    storeImg: 'https://gw.alicdn.com/i1/2935198750/TB26GMgeOC9MuFjSZFoXXbUzFXa_!!2935198750.jpg',
                    storeName: '卡片测试',
                    priceDesc: '月售58笔｜999+条评论',
                    storePrice: 6466,
                    desc: [{
                        type: 'text',
                        value: '特价机票|班期:清明 3/27-4/2等',
                        theme: 'gray'
                    }],
                    tags: [{
                        type: 'tag',
                        value: '满100减20',
                        theme: 'yellow'
                    }]
                },
                {
                    id:2,
                    title:'四川旅游',
                    storeImg: 'https://gw.alicdn.com/i1/2935198750/TB26GMgeOC9MuFjSZFoXXbUzFXa_!!2935198750.jpg',
                    storeName: '卡片测试1',
                    priceDesc: '月售58笔｜999+条评论',
                    storePrice: 6466,
                    desc: [{
                        type: 'text',
                        value: '特价机票|班期:清明 3/27-4/2等',
                        theme: 'gray'
                    }],
                    tags: [{
                        type: 'tag',
                        value: '满100减20',
                        theme: 'yellow'
                    }]
                },
                {
                    id:3,
                    title:'四川旅游',
                    storeImg: 'https://gw.alicdn.com/i1/2935198750/TB26GMgeOC9MuFjSZFoXXbUzFXa_!!2935198750.jpg',
                    storeName: '卡片测试2',
                    priceDesc: '月售58笔｜999+条评论',
                    storePrice: 6466,
                    desc: [{
                        type: 'text',
                        value: '特价机票|班期:清明 3/27-4/2等',
                        theme: 'gray'
                    }],
                    tags: [{
                        type: 'tag',
                        value: '满100减20',
                        theme: 'yellow'
                    }]
                },
                {
                    id:4,
                    title:'四川旅游',
                    storeImg: 'https://gw.alicdn.com/i1/2935198750/TB26GMgeOC9MuFjSZFoXXbUzFXa_!!2935198750.jpg',
                    storeName: '卡片测试3',
                    priceDesc: '月售58笔｜999+条评论',
                    storePrice: 6466,
                    desc: [{
                        type: 'text',
                        value: '特价机票|班期:清明 3/27-4/2等',
                        theme: 'gray'
                    }],
                    tags: [{
                        type: 'tag',
                        value: '满100减20',
                        theme: 'yellow'
                    }]
                },
                {
                    id:5,
                    title:'四川旅游',
                    storeImg: 'https://gw.alicdn.com/i1/2935198750/TB26GMgeOC9MuFjSZFoXXbUzFXa_!!2935198750.jpg',
                    storeName: '卡片测试4',
                    priceDesc: '月售58笔｜999+条评论',
                    storePrice: 6666,
                    desc: [{
                        type: 'text',
                        value: '特价机票|班期:清明 3/27-4/2等',
                        theme: 'gray'
                    }],
                    tags: [{
                        type: 'tag',
                        value: '满100减20',
                        theme: 'yellow'
                    }]
                },
                {
                    id:6,
                    title:'四川旅游',
                    storeImg: 'https://gw.alicdn.com/i1/2935198750/TB26GMgeOC9MuFjSZFoXXbUzFXa_!!2935198750.jpg',
                    storeName: '卡片测试5',
                    priceDesc: '月售58笔｜999+条评论',
                    storePrice: 6566,
                    desc: [{
                        type: 'text',
                        value: '特价机票|班期:清明 3/27-4/2等',
                        theme: 'gray'
                    }],
                    tags: [{
                        type: 'tag',
                        value: '满100减20',
                        theme: 'yellow'
                    }]
                },
                {
                    id:7,
                    title:'四川旅游',
                    storeImg: 'https://gw.alicdn.com/i1/2935198750/TB26GMgeOC9MuFjSZFoXXbUzFXa_!!2935198750.jpg',
                    storeName: '卡片测试6',
                    priceDesc: '月售58笔｜999+条评论',
                    storePrice: 466,
                    desc: [{
                        type: 'text',
                        value: '特价机票|班期:清明 3/27-4/2等',
                        theme: 'gray'
                    }],
                    tags: [{
                        type: 'tag',
                        value: '满100减20',
                        theme: 'yellow'
                    }]
                },
                {
                    id:8,
                    title:'四川旅游',
                    storeImg: 'https://gw.alicdn.com/i1/2935198750/TB26GMgeOC9MuFjSZFoXXbUzFXa_!!2935198750.jpg',
                    storeName: '卡片测试7',
                    priceDesc: '月售58笔｜999+条评论',
                    storePrice: 666,
                    desc: [{
                        type: 'text',
                        value: '特价机票|班期:清明 3/27-4/2等',
                        theme: 'gray'
                    }],
                    tags: [{
                        type: 'tag',
                        value: '满100减20',
                        theme: 'yellow'
                    }]
                }
            ],
            needSlider: true,
            supportSlide: true,
            isTabView: true,
            tabPageHeight: 0,
            desc: [{
                type: 'text',
                value: '特价机票|班期:清明 3/27-4/2等',
                theme: 'gray'
            }],
            tags: [{
                type: 'tag',
                value: '满100减20',
                theme: 'yellow'
            }]
        }),
        created() {
            this.tabPageHeight = Utils.env.getPageHeight();
            console.log('tabPageHeight' + this.tabPageHeight);
        },
        methods: {
            wxcPanItemPan(e) {
                console.log(e)
            },
            storeDetail(e) {
                console.log(e);
                const url = "https://h5.m.taobao.com/trip/ticket/detail/index.html?scenicId=2675";
            }
        }
    }
</script>

<style scoped>
    .nearby-store{
        background-color: #FFF;
    }
    .nearby-store-title {
        align-items: center;
    }

    .item-container {
        width: 750px;
        background-color: #FFF;
    }

    .cell {
        background-color: #FFF;
    }
</style>