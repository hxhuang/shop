<template>
    <div class="app-container">
        <scroller class="scroller" show-scrollbar="false">
            <refresh class="refresh" @refresh="onrefresh" @pullingdown="onpullingdown"
                     :display="refreshing ? 'show' : 'hide'">
                <text class="indicator-text">下拉刷新</text>
                <loading-indicator class="loading-indicator"></loading-indicator>
            </refresh>
            <search></search>
            <banner :banners="banners"></banner>
            <category :categorys="categorys"></category>
            <special-area :specials="specials"></special-area>
            <store-list></store-list>
        </scroller>
    </div>
</template>
<style scoped>
    .app-container {
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        padding-bottom: 5px;
        background-color: #F0F0F0;
    }

    .scroller {
        flex: 1;
        width: 750px;
    }

    .refresh {
        width: 750px;
        display: -ms-flex;
        display: -webkit-flex;
        display: flex;
        -ms-flex-align: center;
        -webkit-align-items: center;
        -webkit-box-align: center;
        align-items: center;
    }

    .indicator-text {
        color: #888888;
        font-size: 42px;
        text-align: center;
    }

    .loading-indicator {
        margin-top: 16px;
        height: 40px;
        width: 40px;
        color: blue;
    }
</style>
<script>
    import Search from "../components/search.vue";
    import Banner from "../components/banner/banner.vue";
    import Category from "../components/category.vue";
    import SpecialArea from "../components/special/specialArea.vue";
    import StoreList from "../components/nearby/storeList.vue";
    import global from '../api/global';

    const modal = weex.requireModule('modal');

    export default {
        components: {
            StoreList,
            SpecialArea,
            Category,
            Banner,
            Search
        },
        data() {
            return {
                refreshing: false,
                banners: [
                    {src:'http://p323gwkn4.bkt.clouddn.com/images/banner/2018/01/24/huoguojie.jpg'},
                    {src: 'http://p323gwkn4.bkt.clouddn.com/images/banner/2018/01/24/Invitation.jpg'},
                    {src: 'http://p323gwkn4.bkt.clouddn.com/images/banner/2018/01/24/pangxie.jpg'}
                ],
                categorys: [
                    {
                        id: 1,
                        type: 1,
                        img: 'http://p323gwkn4.bkt.clouddn.com/images/icon/2018/01/24/fruits.png',
                        title: '新鲜果蔬'
                    },
                    {
                        id: 2,
                        type: 2,
                        img: 'http://p323gwkn4.bkt.clouddn.com/images/icon/2018/01/24/pork.png',
                        title: '优选猪肉'
                    },
                    {
                        id: 3,
                        type: 3,
                        img: 'http://p323gwkn4.bkt.clouddn.com/images/icon/2018/01/24/poultry.png',
                        title: '活鲜水产'
                    },
                    {
                        id: 4,
                        type: 4,
                        img: 'http://p323gwkn4.bkt.clouddn.com/images/icon/2018/01/24/half.png',
                        title: '半成品类'
                    }

                ],
                specials: [
                    {
                        id: 123,
                        type: 1,
                        img: 'https://s3.cn-north-1.amazonaws.com.cn/www.taocaimall.com/img/upload/marketactivity/717573479354847232/2018-01-10/cfe2c211-7555-4b64-8645-f91f6d86a361.jpg'
                    }
                ]

            }
        },
        methods: {
            onrefresh(event) {
                modal.toast({message: '刷新成功', duration: 1});
                this.refreshing = true;
                setTimeout(() => {
                    this.refreshing = false
                }, 2000);

                console.log('onrefresh + ' + event)
            },
            onpullingdown(event) {
                console.log('onpullingdown + ' + event)
            }
        }
    }
</script>