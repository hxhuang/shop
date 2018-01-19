<template>
    <div class="category">
        <div style="flex-direction: row">
            <div class="row" v-for="category in categorys" @click="jumpCategory(category.id,category.type)">
                <image class="category-img" resize="cover" :src="category.img"></image>
                <text class="category-title">{{category.title}}</text>
            </div>
        </div>
    </div>
</template>

<script>

    const modal = weex.requireModule('modal');
    export default {
        name: "category",
        props: ['categorys'],
        data() {
            return {}
        },
        methods: {
            jumpCategory(id, type) {
                modal.toast({message: '刷新成功' + type, duration: 0.5});
            }
        }
    }
</script>

<style scoped>

    .category {
        background-color: #FFFFFF;
    }

    .row {
        margin: 20px;
        justify-content: center;
        align-items: center;
        flex: 1;
    }

    .category-img {
        width: 125px;
        height: 125px;
        border-radius: 10px;
    }

    .category-title {
        font-size: 28px;
        margin-top: 20px;
        overflow: hidden;
        text-align: center;
        lines: 1;
        white-space: nowrap;
        text-overflow: ellipsis;
    }

</style>