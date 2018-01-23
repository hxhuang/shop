<template>
    <div class="app">
        <div class="title-bar" v-if="titleBar">
            <div class="title-right" @click="jumpOrders">
                <text class="title">我的订单</text>
                <image src="http://192.168.199.101:8080/resources/images/icon/right.png"
                       style="width: 30px;height: 30px;padding-right: 10px"></image>
            </div>
        </div>

        <div class="content">
            <div class="content-item" v-for="item in items" @click="setPage(item)">
                <template v-if="discount">
                    <div class="common center">
                        <text class="common discount">{{item.count}}</text>
                        <text class="common discount">{{item.name}}</text>
                    </div>
                </template>
                <template v-else="orders">
                    <div class="common center">
                        <image :src="item.img" style="width: 60px;height: 60px;"></image>
                        <text class="common padding-content">{{item.name}}</text>
                    </div>
                </template>
            </div>
        </div>
    </div>
</template>

<style scoped>
    .app {
        display: flex;
        flex-direction: column;
        flex-wrap: nowrap;
        width: 750px;
        height: 180px;
        margin-bottom: 20px;
        background-color: #FFF;
    }

    .common {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .padding-content {
        padding-top: 15px;
        padding-bottom: 15px
    }

    .title {
        font-size: 26px;
        display: flex;
        align-items: center;
        justify-content: center;
        color: #333;
    }

    .title-bar {
        height: 65px;
        background-color: #FFF;
        border-bottom-width: 1px;
        border-bottom-color: rgba(0, 0, 0, .15);
        display: flex;
        flex-wrap: wrap;
        padding-left: 20px;
        flex-direction: column;
    }

    .title-right {
        height: 65px;
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: space-between;
    }

    .content {
        display: flex;
        flex-wrap: nowrap;
        flex-direction: row;
    }

    .content-item {
        width: 250px;
        background-color: #FFF;
        display: flex;
        flex-wrap: nowrap;
        justify-content: center;
        flex-direction: column;
    }

    .discount {
        font-size: 26px;
        padding-top: 15px;
        padding-bottom: 15px;
    }

    .center {
        justify-content: center;
    }

</style>

<script>
    export default {
        name: 'p-discount',
        props: {
            titleBar: {
                type: Boolean,
                default: false
            },
            items: {
                type: [String, Array],
                default: ''
            },
            discount: {
                type: Boolean,
                default: false
            },
            orders: {
                type: Boolean,
                default: false
            }
        },
        data() {
            return {}
        },
        methods: {
            setPage(item) {

            },
            jumpOrders() {

            }
        }
    }
</script>