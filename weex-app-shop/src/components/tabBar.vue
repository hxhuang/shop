<template>
    <div class="tab-title-list"
         :style="{ backgroundColor: tabStyles.bgColor, height: (tabStyles.height + (isIPhoneX ? 78 : 0))+'px',paddingBottom:isIPhoneX?'78px':'0'}">
        <div class="title-item"
             v-for="(v,index) in tabTitles"
             :key="index"
             @click="setPage(index,v)"
             :style="{ width: tabStyles.width +'px', height: tabStyles.height +'px', backgroundColor: currentPage === index ? tabStyles.activeBgColor : tabStyles.bgColor }"
             :accessible="true"
             :aria-label="`${v.title?v.title:'标签'+index}`">

            <image :src="currentPage === index ? v.activeIcon : v.icon"
                   v-if="titleType === 'icon'"
                   :style="{ width: tabStyles.iconWidth + 'px', height:tabStyles.iconHeight+'px'}"></image>

            <text class="icon-font"
                  v-if="titleType === 'iconFont' && v.codePoint"
                  :style="{fontSize: tabStyles.iconFontSize+'px', color: currentPage === index ? tabStyles.activeIconFontColor : tabStyles.iconFontColor}">
                {{decode(v.codePoint)}}
            </text>

            <text
                    :style="{ fontSize: tabStyles.fontSize+'px', fontWeight: (currentPage === index && tabStyles.isActiveTitleBold)? 'bold' : 'normal', color: currentPage === index ? tabStyles.activeTitleColor : tabStyles.titleColor, paddingLeft:tabStyles.textPaddingLeft+'px', paddingRight:tabStyles.textPaddingRight+'px'}"
                    class="tab-text">{{v.title}}
            </text>
            <div class="desc-tag" v-if="v.badge">
                <text class="desc-text">{{v.badge}}</text>
            </div>
            <div v-if="v.dot && !v.badge" class="dot"></div>
        </div>
    </div>
</template>

<style scoped>

    .tab-title-list {
        flex-direction: row;
        justify-content: space-around;
    }

    .title-item {
        justify-content: center;
        align-items: center;
        flex-direction: column;
        border-bottom-style: solid;
    }

    .tab-text {
        lines: 1;
        text-overflow: ellipsis;
    }

    .desc-tag {
        position: absolute;
        top: 10px;
        right: 20px;
        border-bottom-right-radius: 14px;
        border-bottom-left-radius: 0;
        border-top-left-radius: 14px;
        border-top-right-radius: 14px;
        background-color: #FF5E00;
        height: 26px;
        align-items: center;
        justify-content: center;
        padding-left: 6px;
        padding-right: 6px;
    }

    .dot {
        width: 12px;
        height: 12px;
        border-bottom-right-radius: 12px;
        border-bottom-left-radius: 12px;
        border-top-left-radius: 12px;
        border-top-right-radius: 12px;
        position: absolute;
        top: 10px;
        right: 40px;
        background-color: #FF5E00;
    }

    .desc-text {
        font-size: 18px;
        color: #ffffff;
    }

    .icon-font {
        margin-bottom: 8px;
    }
</style>

<script>
    const animation = weex.requireModule('animation');
    import Utils from '../config/util'

    export default {
        props: {
            tabTitles: {
                type: Array,
                default: () => ([])
            },
            tabStyles: {
                type: Object,
                default: () => ({
                    bgColor: '#FFFFFF',
                    titleColor: '#666666',
                    activeTitleColor: '#3D3D3D',
                    activeBgColor: '#FFFFFF',
                    isActiveTitleBold: true,
                    iconWidth: 70,
                    iconHeight: 70,
                    width: 160,
                    height: 120,
                    fontSize: 24,
                    activeBottomColor: '#FFC900',
                    activeBottomWidth: 120,
                    activeBottomHeight: 6,
                    textPaddingLeft: 10,
                    textPaddingRight: 10
                })
            },
            titleType: {
                type: String,
                default: 'icon'
            },
            isTabView: {
                type: Boolean,
                default: true
            },
            duration: {
                type: [Number, String],
                default: 300
            },
            timingFunction: {
                type: String,
                default: 'cubic-bezier(0.25, 0.46, 0.45, 0.94)'
            },
            wrapBgColor: {
                type: String,
                default: '#f2f3f4'
            }
        },
        data: () => ({
            currentPage: 0,
            translateX: 0
        }),
        created() {
            this.isIPhoneX = Utils.env.isIPhoneX();
        },
        methods: {
            decode(text) {
                return Utils.decodeIconFont(text)
            },
            setPage(page, v) {
                // const {width} = this.tabStyles;
                this.currentPage = page;
                this.$router.push('/' + v.name);
                this.$emit('currentTabSelected', {page});
            }
        }
    };
</script>
