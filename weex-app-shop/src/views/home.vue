<template>
    <div class="app-container">
        <scroller>
            <refresh class="refresh" @refresh="onrefresh" @pullingdown="onpullingdown"
                     :display="refreshing ? 'show' : 'hide'">
                <text class="indicator-text">下拉刷新</text>
                <loading-indicator class="indicator"></loading-indicator>
            </refresh>
            <search></search>
            <banner :banners="banners"></banner>
            <category :categorys="categorys"></category>
            <special-area :specials="specials"></special-area>
        </scroller>
    </div>
</template>
<style scoped>
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

    .indicator {
        margin-top: 16px;
        height: 40px;
        width: 40px;
        color: blue;
    }
</style>
<script>
    import Search from "../components/search.vue";
    import Banner from "../components/banner.vue";
    import Category from "../components/category.vue";
    import SpecialArea from "../components/special/specialArea.vue";


    const modal = weex.requireModule('modal');

    export default {
        components: {
            SpecialArea,
            Category,
            Banner,
            Search
        },
        data() {
            return {
                refreshing: false,
                banners: [
                    {src: 'https://gd2.alicdn.com/bao/uploaded/i2/T14H1LFwBcXXXXXXXX_!!0-item_pic.jpg'},
                    {src: 'https://gd1.alicdn.com/bao/uploaded/i1/TB1PXJCJFXXXXciXFXXXXXXXXXX_!!0-item_pic.jpg'},
                    {src: 'https://gd3.alicdn.com/bao/uploaded/i3/TB1x6hYLXXXXXazXVXXXXXXXXXX_!!0-item_pic.jpg'}
                ],
                categorys:[
                    {img:'https://s3.cn-north-1.amazonaws.com.cn/www.taocaimall.com/img/upload/class_icon/9faf7ba1-972b-4390-8ec8-350896f4d52b.png',title:'水果'},
                    {img:'https://s3.cn-north-1.amazonaws.com.cn/www.taocaimall.com/img/upload/class_icon/9faf7ba1-972b-4390-8ec8-350896f4d52b.png',title:'蔬菜'},
                    {img:'https://s3.cn-north-1.amazonaws.com.cn/www.taocaimall.com/img/upload/class_icon/9faf7ba1-972b-4390-8ec8-350896f4d52b.png',title:'猪肉'},
                    {img:'https://s3.cn-north-1.amazonaws.com.cn/www.taocaimall.com/img/upload/class_icon/9faf7ba1-972b-4390-8ec8-350896f4d52b.png',title:'猪肉'},
                    {img:'https://s3.cn-north-1.amazonaws.com.cn/www.taocaimall.com/img/upload/class_icon/9faf7ba1-972b-4390-8ec8-350896f4d52b.png',title:'水产'}

                ],
                specials:[
                    {id:123,type:1,img:'https://s3.cn-north-1.amazonaws.com.cn/www.taocaimall.com/img/upload/marketactivity/717573479354847232/2018-01-10/cfe2c211-7555-4b64-8645-f91f6d86a361.jpg'},
                    {id:124,type:0,img:'https://s3.cn-north-1.amazonaws.com.cn/www.taocaimall.com/img/upload/marketactivity/717573479354847232/2018-01-10/cfe2c211-7555-4b64-8645-f91f6d86a361.jpg'}
                    ]

            }
        },
        methods: {
            onrefresh(event) {
                modal.toast({message: '刷新成功', duration: 1});
                this.refreshing = true;
                setTimeout(() => {
                    this.refreshing = false
                }, 2000)

                console.log('onrefresh + ' + event)
            },
            onpullingdown(event) {
                console.log('onpullingdown + ' + event)
            }
        }
    }
</script>