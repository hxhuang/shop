<template>
    <div class="app">
        <div class="left">
            <scroller class="scroller" show-scrollbar="false">
                <div class="bar" v-for="(item,index) in goodsClass"
                     @click="showGoodsSecondClass(index,item.id,item.goodsClassName)"
                     :style="{backgroundColor:currentPage === index ?categoryStyle.activeBgColor:categoryStyle.bgColor,
                     borderLeftColor:currentPage === index ? titleStyle.activeBorderLeftColor:'',
                     borderLeftStyle:currentPage === index ? titleStyle.activeBorderLeftStyle:'',
                     borderLeftWidth:currentPage === index ? titleStyle.activeBorderLeftWidth:''}">
                    <text :style="{color:currentPage === index ? titleStyle.activeColor:titleStyle.color}">{{item.goodsClassName}}</text>
                </div>
            </scroller>
        </div>
        <div class="right">
            <scroller style="background-color: #FFF;" show-scrollbar="false">
                <div class="content" v-for="item in goodsSecondClass">
                    <div class="title-box">
                        <text class="title">{{item.name}}</text>
                    </div>
                    <div class="gc-content">
                        <div class="gc-item" v-for="gc in item.data">
                            <div class="common center">
                                <image src="http://p323gwkn4.bkt.clouddn.com/images/icon/2018/01/24/people.png"
                                       style="width: 110px;height: 110px;"></image>
                                <text class="goods-class-text">{{gc.goodsClassName}}</text>
                            </div>
                        </div>
                    </div>
                </div>
            </scroller>
        </div>
    </div>
</template>

<style scoped>
    .app {
        width: 750px;
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        padding-bottom: 5px;
        background-color: #F0F0F0;
        display: flex;
        flex-direction: row;
    }

    .left {
        width: 200px;
    }

    .right {
        width: 550px;
    }

    .scroller {
        flex: 1;
        background-color: #f2f3f4;
    }

    .bar {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 80px;
    }

    .title {
        font-size: 24px;
        color:#333;
        opacity: .5;
    }

    .title-box {
        width: 550px;
        height: 80px;
        display: flex;
        justify-content: center;
        padding-left: 20px;
        align-items: center;
    }

    .gc-content {
        display: flex;
        flex-wrap: wrap;
        flex-direction: row;

    }

    .gc-item {
        width: 180px;
        padding-top: 20px;
        padding-bottom: 20px;
        background-color: #FFF;
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        flex-direction: column;
    }
    .common {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .center {
        justify-content: center;
    }

    .goods-class-text{
        padding-top: 20px;
    }

</style>

<script>
    let modal = weex.requireModule('modal');
    export default {
        name: 'v-category',
        props: {
            categoryStyle: {
                type: Object,
                default: () => ({
                    activeBgColor: '#FFF',
                    bgColor: '#efefef'
                })
            },
            titleStyle:{
                type:Object,
                default:()=>({
                    color:'#333',
                    activeColor:'#FF0000',
                    activeBorderLeftColor:'#FF0000',
                    activeBorderLeftStyle:'solid',
                    activeBorderLeftWidth: 6,

                })
            }
        },
        data() {
            return {
                currentPage: 0,
                goodsClass: [
                    {id: 1, goodsClassName: '水果'},
                    {id: 2, goodsClassName: '蔬菜'},
                    {id: 3, goodsClassName: '猪肉'},
                    {id: 4, goodsClassName: '奶类'},
                    {id: 5, goodsClassName: '干货'},
                    {id: 6, goodsClassName: '禽类'},
                    {id: 7, goodsClassName: '蛋类'},
                    {id: 8, goodsClassName: '面食'},
                    {id: 9, goodsClassName: '腌制类'},
                    {id: 10, goodsClassName: '豆制品'},
                    {id: 11, goodsClassName: '活鲜水产'},
                    {id: 12, goodsClassName: '冷冻水产'},
                    {id: 13, goodsClassName: '方便食品'},
                    {id: 14, goodsClassName: '半成品类'}
                ],
                goodsSecondClass: [
                    {
                        "name":"水果",
                        "data":[
                            {
                                id: 1,
                                goodsClassName: '苹果',
                                img: 'http://p323gwkn4.bkt.clouddn.com/images/icon/2018/01/24/people.png'
                            },
                            {
                                id: 2,
                                goodsClassName: '梨',
                                img: 'http://p323gwkn4.bkt.clouddn.com/images/icon/2018/01/24/people.png'
                            },
                            {
                                id: 3,
                                goodsClassName: '猕猴桃',
                                img: 'http://p323gwkn4.bkt.clouddn.com/images/icon/2018/01/24/people.png'
                            },
                            {
                                id: 4,
                                goodsClassName: '柑橘柚',
                                img: 'http://p323gwkn4.bkt.clouddn.com/images/icon/2018/01/24/people.png'
                            },
                            {
                                id: 5,
                                goodsClassName: '瓜类',
                                img: 'http://p323gwkn4.bkt.clouddn.com/images/icon/2018/01/24/people.png'
                            },
                            {
                                id: 6,
                                goodsClassName: '水果',
                                img: 'http://p323gwkn4.bkt.clouddn.com/images/icon/2018/01/24/people.png'
                            }
                        ]
                    },
                    {
                        "name":"蔬菜",
                        "data":[
                            {
                                id: 1,
                                goodsClassName: '根茎类',
                                img: 'http://p323gwkn4.bkt.clouddn.com/images/icon/2018/01/24/people.png'
                            },
                            {
                                id: 2,
                                goodsClassName: '叶菜类',
                                img: 'http://p323gwkn4.bkt.clouddn.com/images/icon/2018/01/24/people.png'
                            },
                            {
                                id: 3,
                                goodsClassName: '瓜果类',
                                img: 'http://p323gwkn4.bkt.clouddn.com/images/icon/2018/01/24/people.png'
                            },
                            {
                                id: 4,
                                goodsClassName: '菇菌类',
                                img: 'http://p323gwkn4.bkt.clouddn.com/images/icon/2018/01/24/people.png'
                            },
                            {
                                id: 5,
                                goodsClassName: '调味类',
                                img: 'http://p323gwkn4.bkt.clouddn.com/images/icon/2018/01/24/people.png'
                            },
                            {
                                id: 6,
                                goodsClassName: '半成品净菜',
                                img: 'http://p323gwkn4.bkt.clouddn.com/images/icon/2018/01/24/people.png'
                            }
                        ]
                    }
                ]
            }
        },
        created(){

        },
        methods: {
            showGoodsSecondClass(index, id, goodsClassName) {
                modal.toast({message: id + goodsClassName})
                const previousPage = this.currentPage;
                this.currentPage = index;
            }
        }
    }
</script>