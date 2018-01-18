<template>
    <slider class="slider" interval="3000" auto-play="true" @click="jumpToDetail">
        <div class="frame" v-for="img in banners">
            <image class="image" resize="cover" :src="img.src"></image>
        </div>
        <indicator class="indicator"></indicator>
    </slider>
</template>

<script>
    export default {
        name: "banner",
        props: ['banners'],
        data() {
            return {}
        },
        methods: {
            jumpToDetail(event) {

            }
        }
    }
</script>

<style scoped>
    .image {
        width: 750px;
        height: 350px;
    }

    .slider {
        margin-top: 25px;
        width: 750px;
        height: 350px;
        border-width: 2px;
        border-style: solid;
        border-color: #41B883;
    }

    .frame {
        width: 750px;
        height: 350px;
        position: relative;
    }

    .indicator {
        width: 750px;
        height: 700px;
        item-color: green;
        item-selected-color: red;
        item-size: 50px;
        position: absolute;
        top: 200px;
        left: 200px;
    }
</style>