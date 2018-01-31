<template>
    <div class="app">
        <v-category></v-category>
    </div>
</template>
<script>
    import VCategory from "../components/vCategory.vue";

    let modal = weex.requireModule('modal');
    export default {
        data() {
            return {
                msg: 'Classify'
            }
        },
        components: {VCategory},
        created() {

        },
        methods: {

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

</style>
