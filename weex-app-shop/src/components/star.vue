<template>
    <div class="star">
        <div class="star-item" v-for="image in images">
            <image :src="image"></image>
        </div>
    </div>
</template>

<script>
    export default {
        name: "star",
        props: {
            image: {
                type: String,
                default: ''
            }
        }
    }
</script>

<style scoped>

</style>