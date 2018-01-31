<template>
    <div class="app">
        <div class="bar">
            <wxc-minibar title="我的优惠券"
                         background-color="#FFF"
                         text-color="#FF0000"
                         right-text="兑换"
                         @wxcMinibarLeftButtonClicked="back"
                         @wxcMinibarRightButtonClicked="exchange">
            </wxc-minibar>
        </div>
        <div class="content">
            <wxc-tab-page ref="wxc-tab-page"
                          :tab-titles="tabTitles"
                          :tab-styles="tabStyles"
                          title-type="text"
                          :needSlider="needSlider"
                          :is-tab-view="isTabView"
                          :tab-page-height="tabPageHeight"
                          :spm-c="4307989"
                          @wxcTabPageCurrentTabSelected="wxcTabPageCurrentTabSelected">
                <list v-for="(tab,index) in tabList"
                      :key="index"
                      class="item-container"
                      :style="{ height: (tabPageHeight - tabStyles.height) + 'px' }">
                    <cell class="border-cell"></cell>
                    <cell v-for="(discount,key) in tab"
                          :key="key"
                          :accessible="true">
                        <wxc-pan-item :ext-id="'1-' + (tab) + '-' + (key)"
                                      @wxcPanItemPan="wxcPanItemPan">
                            <discount-item :coupon="discount"></discount-item>
                        </wxc-pan-item>
                    </cell>
                </list>
            </wxc-tab-page>
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
        border-bottom-style: solid;
        border-bottom-color: #f2f3f4;
        border-bottom-width: 1px;
    }

    .item-container {
        width: 750px;
        background-color: #f2f3f4;
    }

    .border-cell {
        background-color: #f2f3f4;
        width: 750px;
        height: 24px;
        align-items: center;
        justify-content: center;
        border-bottom-width: 1px;
        border-style: solid;
        border-color: #e0e0e0;
    }

</style>

<script>
    import {WxcMinibar, WxcPanItem, WxcTabPage, Utils} from 'weex-ui'
    import Config from '../../config/discountStyle'
    import DiscountItem from '../../components/personal/discountItem.vue';

    const modal = weex.requireModule('modal');
    export default {
        components: {WxcMinibar, WxcTabPage, WxcPanItem, DiscountItem},
        data() {
            return {
                tabTitles: Config.tabTitles,
                tabStyles: Config.tabStyles,
                tabList: [],
                needSlider: true,
                supportSlide: true,
                isTabView: true,
                coupon:
                    {

                        unused: [{
                            discountType: 1,
                            discountAmount: 33.33,
                            orderAmount: 58.00,
                            beginTime: '2018-01-28',
                            endTime: '2018-02-03'
                        }], used: [
                        {
                            discountType: 2,
                            discountAmount: 33.33,
                            orderAmount: 58.00,
                            beginTime: '2018-01-28',
                            endTime: '2018-02-03'
                        },
                        {
                            discountType: 3,
                            discountAmount: 33.33,
                            orderAmount: 58.00,
                            beginTime: '2018-01-28',
                            endTime: '2018-02-03'
                        },
                        {
                            discountType: 4,
                            discountAmount: 33.33,
                            orderAmount: 58.00,
                            beginTime: '2018-01-28',
                            endTime: '2018-02-03'
                        }
                    ],
                        expired: []
                    }
            }
        },
        created() {
            this.tabPageHeight = Utils.env.getPageHeight();
            this.tabList = [...Array(this.tabTitles.length).keys()].map(i => []);
            Vue.set(this.tabList, 0, this.coupon.unused); // 设置未使用栏数据
            Vue.set(this.tabList, 1, this.coupon.expired); // 设置已失效栏数据
            Vue.set(this.tabList, 2, this.coupon.used); // 设置已使用栏数据
        },
        methods: {
            back(event) {

            },
            exchange(event) {
                modal.toast({
                    message: this.tabList[0],
                    duration: 100
                })
            },
            wxcTabPageCurrentTabSelected(event) {
                const self = this;
                const index = e.page;
                /* 未加载tab模拟数据请求 */
                if (!Utils.isNonEmptyArray(self.tabList[index])) {
                    setTimeout(() => {
                        Vue.set(self.tabList, index, self.demoList);
                    }, 100);
                }
                modal.toast({message: '刷新成功' + type, duration: 0.5});
            },
            wxcPanItemPan(event) {
                if (Utils.env.supportsEBForAndroid()) {
                    this.$refs['wxc-tab-pages'].bindExp(event.element);
                }
            }
        }
    }
</script>