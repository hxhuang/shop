<template>
    <div class="app">
        <div class="bar">
            <div class="left" @click="closePage">
                <slot name="left">
                    <image :src="closeBtn"
                           slot="left"
                           style="height: 75px;width: 75px;"></image>
                </slot>
            </div>
            <div class="right" @click="sharePage">
                <slot name="right">
                    <image slot="right"
                           :src="shareBtn"
                           style="height: 75px;width: 75px;"></image>
                </slot>
            </div>
        </div>
        <div class="container">
            <scroller class="scroller" show-scrollbar="false">
                <!-- 商品图片 -->
                <div class="goods-box">

                </div>
                <!-- 商品描述规格-->
                <div class="goods-description">

                    <div class="goods-specification">

                    </div>
                    <!-- 商品价格-->
                    <div class="goods-price">

                    </div>
                    <!-- 商品添加购物车-->
                    <div class="add-goods-cart">

                    </div>
                </div>

                <!-- 所属店铺与联系商家-->
                <div class="goods-connection">
                    <div class="store">
                        <div class="store-name">

                        </div>
                        <div class="store-connection">

                        </div>
                    </div>
                    <div class="goods-evaluation">

                    </div>
                </div>
            </scroller>
        </div>

    </div>
</template>

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

    .bar {
        width: 750px;
        height: 90px;
        flex-direction: row;
        justify-content: space-between;
        align-items: center;
        background-color: #FFF3CD;
    }

    .left {
        width: 180px;
        padding-left: 32px;
    }

    .right {
        width: 180px;
        padding-right: 32px;
        align-items: flex-end;
    }

    .container {
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
    }

    .scroller {
        flex: 1;
        width: 750px;
    }
</style>

<script>
    import {WxcMinibar} from 'weex-ui'

    const modal = weex.requireModule('modal');
    export default {
        components: {WxcMinibar},
        data: () => ({
            closeBtn: 'http://p323gwkn4.bkt.clouddn.com/images/icon/2018/01/24/close.png',
            shareBtn: 'http://p323gwkn4.bkt.clouddn.com/images/icon/2018/01/24/share.png'
        }),
        methods: {
            closePage(event) {

            },
            sharePage(event) {
                modal.toast({
                    message: 'ddddddddddddd',
                    duration: 100
                })
            }
        }
    }
</script>