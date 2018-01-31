<template>
    <div class="app">
        <div style="position: absolute;">
            <image src="http://p323gwkn4.bkt.clouddn.com/images/coupon/2018/01/24/coupon.png"
                   style="width: 750px;height:246px "></image>
        </div>
        <div class="left">
            <div class="left-top row">
                <text :style="{color:discount[coupon.discountType].textColor,fontSize:discountStyle.amountFlagFontSize}">¥ </text>
                <text :style="{color:discount[coupon.discountType].textColor,fontSize:discountStyle.amountFontSize}">{{coupon.discountAmount}}</text>
            </div>
            <div class="left-bottom">
                <text class="left-bottom-text row">满</text>
                <text class="left-bottom-text row" :style="{color:discount[coupon.discountType].textColor}">{{coupon.orderAmount}}</text>
                <text class="left-bottom-text row">元使用</text>
            </div>
        </div>

        <div class="right">
            <div class="right-box row">
                <text class="font-text row">有效期至：</text>
                <text class="font-text" :style="{color:discount[coupon.discountType].textColor}">{{coupon.endTime}}</text>
            </div>
            <div class="right-box">
                <text class="font-text">{{discount[coupon.discountType].description}}</text>
            </div>
        </div>
        <div class="item-image">
            <image :src="discount[coupon.discountType].itemImage"
                   class="item-image-logo"></image>
        </div>
    </div>
</template>

<style scoped>
    .app {
        position: relative;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        width: 750px;
        height: 246px;
        margin-bottom: 20px;
        flex-direction: row;
    }

    .row {
        flex-direction: row;
    }

    .item-image {
        position: absolute;
        top: 0;
        right: 0;
    }

    .item-image-logo {
        width: 152px;
        height: 127px;

    }

    .left {
        width: 250px;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .left-top {
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .left-bottom {
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: center;
    }

    .left-bottom-text {
        font-size: 28px;
    }

    .right {
        padding-left: 30px;
        width: 450px;
        display: flex;
        justify-content: center;
    }

    .right-box {
        display: flex;
        margin-top: 10px;
        margin-bottom: 10px;
    }

    .column {
        flex-direction: column;
    }

    .font-text {
        font-size: 24px;
    }
</style>

<script>
    const expressionBinding = weex.requireModule('expressionBinding');
    import {WxcRichText, WxcSpecialRichText, Utils} from 'weex-ui';

    export default {
        name: 'discount-item',
        components: {WxcRichText, WxcSpecialRichText},
        props: {
            discountStyle:{
                type:Object,
                default:()=>({
                    amountFlagFontSize: 36,
                    amountFontSize:36
                })
            },
            discount: {
                type: [String, Array],
                default: () => ([
                    {
                        textColor: '#ff0033',
                        itemImage: 'http://p323gwkn4.bkt.clouddn.com/images/coupon/2018/01/24/normal.png',
                        description: '说明：满足本券使用金额即可使用，不得与XXX其它优惠同享（促销、满赠、换购、首单）',
                    }, {
                        textColor: '#f9670f',
                        itemImage: 'http://p323gwkn4.bkt.clouddn.com/images/coupon/2018/01/24/normal_discount.png',
                        description: '说明：满足本券使用金额即可使用，不得与XXX其它优惠同享（促销、满赠、换购、首单）',
                    }, {
                        textColor: '#58b2cc',
                        itemImage: 'http://p323gwkn4.bkt.clouddn.com/images/coupon/2018/01/24/store.png',
                        description: '说明：满足本券使用金额即可使用，不得与XXX其它优惠同享（促销、满赠、换购、首单）',
                    }, {
                        textColor: '#eacf3a',
                        itemImage: 'http://p323gwkn4.bkt.clouddn.com/images/coupon/2018/01/24/all.png',
                        description: '说明：不得与XXX其他优惠同享与XXX其他优惠同享',
                    }, {
                        textColor: '#cc79bf',
                        itemImage: 'http://p323gwkn4.bkt.clouddn.com/images/coupon/2018/01/24/special_discount.png',
                        description: '说明：不得与XXX其他优惠同享与XXX其他优惠同享',
                    }
                ])
            },
            coupon: {
                type: Object,
                default: () => ({
                    discountType:2,
                    discountAmount:33.33,
                    orderAmount:58.00,
                    beginTime:'2018-01-28',
                    endTime:'2018-02-03'

                })
            },
            extId: {
                type: [String, Number],
                default: 0
            }
        },
        data: () => ({
            yenSymbol: '\u00A5'
        }),
        computed: {}
    };
</script>
