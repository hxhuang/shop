<template>
    <div class="app">
        <scroller class="scroller">
            <p-header></p-header>

            <div class="app-login">
                <div class="login-avatar">
                    <image :src="loginLogo" style="width: 120px;height: 120px;"></image>
                </div>
                <div class="login-content">
                    <text class="login-text">登录 / 注册</text>
                </div>
            </div>

            <p-discount :discount="true" :style="contentStyle" :items="discountBarContent"></p-discount>
            <p-discount :titleBar="true" :orders="true" :items="orderContent"></p-discount>

            <div class="box-list" v-for="box in boxContent">
                <div class="box-item" v-for="item in box.itemData">
                    <div class="box-img">
                        <image :src="item.img" style="width: 80px;height: 80px"></image>
                        <text class="box-text">{{item.name}}</text>
                    </div>
                </div>
            </div>
        </scroller>
    </div>
</template>
<script>

    let modal = weex.requireModule('modal');
    let navigator = weex.requireModule('navigator');

    import {WxcButton} from 'weex-ui'
    import global from '../api/global'
    import PHeader from "../components/personal/pHeader.vue";
    import PDiscount from "../components/personal/pDiscount.vue";

    export default {
        data() {
            return {
                msg: 'Personal',
                loginLogo: global.resource.URL + '/vegetables.png',
                discountBarContent: [
                    {name: '优惠券', img: '', type: 'discount', count: 0},
                    {name: '关注店铺', img: '', type: 'followStore', count: 0},
                    {name: '足迹', img: '', type: 'footprint', count: 0}
                ],
                orderContent: [
                    {name: '待付款', img: global.resource.URL + '/icon/pending_payment.png', type: '', count: 0},
                    {name: '待收货', img: global.resource.URL + '/icon/goods_received.png', type: '', count: 0},
                    {name: '待评价', img: global.resource.URL + '/icon/evaluate.png', type: '', count: 0}
                ],
                right: global.resource.URL + '',
                boxContent: [
                    {
                        "itemData": [{
                            name: '我的关注',
                            img: global.resource.URL + '/icon/pending_payment.png',
                            type: '',
                            count: 0
                        }, {
                            name: '我的评价',
                            img: global.resource.URL + '/icon/pending_payment.png',
                            type: '',
                            count: 0
                        }, {
                            name: '我的地址',
                            img: global.resource.URL + '/icon/pending_payment.png',
                            type: '',
                            count: 0
                        }, {name: '联系客服', img: global.resource.URL + '/icon/pending_payment.png', type: '', count: 0}]
                    },
                    {
                        "itemData": [{
                            name: '领券中心',
                            img: global.resource.URL + '/icon/pending_payment.png',
                            type: '',
                            count: 0
                        }, {
                            name: '账本',
                            img: global.resource.URL + '/icon/pending_payment.png',
                            type: '',
                            count: 0
                        }, {
                            name: '退款 / 售后',
                            img: global.resource.URL + '/icon/pending_payment.png',
                            type: '',
                            count: 0
                        }, {name: '帮助中心', img: global.resource.URL + '/icon/pending_payment.png', type: '', count: 0}]
                    }
                ]
            }
        },
        components: {
            PDiscount,
            PHeader,
            WxcButton
        },
        created() {
            this.contentStyle = {height: '115px'};
        },
        methods: {
            onTabTo(_result) {

            },
            wxcButtonClicked(e) {
                const url = weex.config.bundleUrl;
                console.log(url);
            }
        }
    }
</script>
<style scoped>
    .app {
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        padding-bottom: 5px;
        background-color: #F0F0F0;
    }

    .scroller {
        width: 750px;
        flex: 1;
    }

    .app-login {
        display: flex;
        justify-content: flex-start;
        flex-direction: row;
        align-items: center;
        width: 750px;
        height: 240px;
        bottom: 0;
        padding-top: 60px;
        margin-top: 10px;
        margin-bottom: 20px;
        background-color: chartreuse;
    }

    .login-avatar {
        display: flex;
        flex-direction: row;
        padding-right: 40px;
        padding-left: 60px;
    }

    .login-content {
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;
        flex-wrap: nowrap;
        width: 200px;
        height: 100px;
        background-color: #FFF;
        opacity: .5;
        z-index: 99;
    }

    .login-text {
        font-size: 28px;
        display: flex;
        align-items: center;
        justify-content: center;
        color: #333;
    }

    .box-img {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .box-list {
        width: 750px;
        display: flex;
        flex-direction: row;
        align-items: center;
    }

    .box-item {
        width: 187px;
        padding-top: 20px;
        padding-bottom: 20px;
        background-color: #FFF;
        display: flex;
        flex-wrap: nowrap;
        justify-content: center;
        flex-direction: column;
        border-left: solid;
        border-left-width: 1px;
        border-left-color: rgba(0, 0, 0, .15);
        border-bottom: solid;
        border-bottom-width: 1px;
        border-bottom-color: rgba(0, 0, 0, .15);
    }

    .box-text {
        padding-top: 20px;
    }

</style>
