<template>
    <div class="category">
        <scroller class="scroller" scroll-direction="horizontal" flex-direction="row" show-scrollbar=false>
            <div class="row" v-for="category in categorys">
                <image class="category-img" resize="cover" :src="category.img"></image>
                <text class="category-title">{{category.title}}</text>
            </div>
        </scroller>
    </div>
</template>

<script>
    export default {
        name: "category",
        props: ['categorys'],
        data() {
            return {}
        },
        methods: {}
    }
</script>

<style scoped>
    .scroller {
        height: 250px;
        padding: 10px;
    }
    .category {
        background-color: #FFFFFF;
        align-items: center;
    }

    .row {
        width: 140px;
        height: 200px;
        margin: 20px;
    }

    .category-img {
        /*position: absolute;*/
        top: 0;
        left: 0;
        width: 140px;
        height: 140px;
        border-radius: 10px;
    }

    .category-title {
        font-size: 28px;
        margin-top: 20px;
        /*align-items: center;*/
        /*justify-content: center;*/
        overflow: hidden;
        text-align: center;
        lines:1;
        white-space: nowrap;
        text-overflow: ellipsis;
    }

</style>