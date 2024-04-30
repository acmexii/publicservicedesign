

<template>
    <v-app id="inspire">
        <div>
            <v-app-bar color="primary" app clipped-left flat>
                <v-toolbar-title>
                    <span class="second-word font uppercase"
                        style="font-weight:700;"
                    >
                        <v-app-bar-nav-icon
                            @click="openSideBar()"
                            style="z-index:1;
                            height:56px;
                            width:30px;
                            margin-right:10px;
                            font-weight:300;
                            font-size:55px;"
                        >
                            <div style="line-height:100%;">≡</div>
                        </v-app-bar-nav-icon>
                    </span>
                </v-toolbar-title>
                <span v-if="urlPath!=null" 
                    class="mdi mdi-home" 
                    key="" 
                    to="/" 
                    @click="goHome()"
                    style="margin-left:10px; font-size:20px; cursor:pointer;"
		        ></span> 
                <v-spacer></v-spacer>

            </v-app-bar>

            <v-navigation-drawer app clipped flat v-model="sideBar">
                <v-list>
                    <v-list-item
                        class="px-2"
                        key="applications"
                        to="/applications/applications"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        민원
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="investigations"
                        to="/process1s/investigations"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        사실조사
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="processings"
                        to="/process1s/processings"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        처리
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="minwonType2s"
                        to="/process2s/minwonType2s"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        민원유형2
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="rewardApplications"
                        to="/compensations/rewardApplications"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        보상신청심의
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="compensationPayments"
                        to="/compensations/compensationPayments"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        보상지급
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="analysis1s"
                        to="/analysis1s/analysis1s"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        분석관점1
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="analysis2s"
                        to="/analysis2s/analysis2s"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        분석관점
                    </v-list-item>



                </v-list>
            </v-navigation-drawer>
        </div>

        <v-main>
            <v-container style="padding:0px;" v-if="urlPath" fluid>
                <router-view></router-view>
            </v-container>
            <v-container style="padding:0px;" v-else fluid>
                <div style="width:100%; margin:0px 0px 20px 0px; position: relative;">
                    <v-img style="width:100%; height:300px;"
                        src=""
                    ></v-img>
                    <div class="App-main-text-overlap"></div>
                    <div class="App-sub-text-overlap"></div>
                </div>
                <v-row>
                    <v-col cols="4" class="d-flex justify-center" v-for="(aggregate, index) in aggregate" :key="index">
                        <div 
                            class="flip-card"
                            @mouseover="flipCard(index)"
                            @mouseleave="unflipCard(index)"
                            :class="{ 'is-flipped': flipped[index] }"
                        >
                            <div class="flip-card-inner">
                                <div class="flip-card-front">
                                    <v-card
                                        class="mx-auto"
                                        style="width:300px; min-height: 310px; margin-bottom:20px; text-align: center; border-radius: 10px;"
                                        outlined
                                    >
                                        <v-list-item style="padding:15px; margin:0px;">
                                            <v-img style="width:100%; height:120px; border-radius: 10px;" :src="aggregate.ImageUrl"></v-img>
                                        </v-list-item>
                                        <div style="text-align: left; padding:10px 15px 15px 15px; margin-top:-10px;">
                                            <h2>{{ aggregate.title }}</h2>
                                            <div>{{ aggregate.description }}</div>
                                        </div>
                                    </v-card>
                                </div>
                                <div class="flip-card-back">
                                    <v-card
                                        color="primary"
                                        class="mx-auto"
                                        style="width:300px; min-height: 310px; margin-bottom:20px; text-align: center; border-radius: 10px;"
                                        outlined
                                        :key="aggregate.key"
                                        :to="aggregate.route"
                                        @click="changeUrl()"
                                    >
                                        <v-list-item style="padding:15px; margin:0px;">
                                            <v-img style="width:100%; height:120px; border-radius: 10px;" :src="aggregate.ImageUrl"></v-img>
                                        </v-list-item>
                                        <h2 style="color:white;">{{ aggregate.title }} 관리</h2>
                                    </v-card>
                                </div>
                            </div>
                        </div>
                    </v-col>
                </v-row>
            </v-container>
        </v-main>
    </v-app>
</template>

<script>

export default {
    name: "App",
    data: () => ({
        useComponent: "",
        drawer: true,
        components: [],
        sideBar: true,
        urlPath: null,
        flipped: [],
        ImageUrl: '',
        aggregate: [
            { 
                title: '민원', 
                description: '민원에 대한 설명입니다', 
                key: 'applications', 
                route: '/applications/applications',
                ImageUrl: '',
            },
            { 
                title: '사실조사', 
                description: '민원유형1에 대한 사실 조사', 
                key: 'investigations', 
                route: '/process1s/investigations',
                ImageUrl: '',
            },
            { 
                title: '처리', 
                description: '민원유형1에 대한 처리', 
                key: 'processings', 
                route: '/process1s/processings',
                ImageUrl: '',
            },
            { 
                title: '민원유형2', 
                description: '민원유형2에 대한 처리', 
                key: 'minwonType2s', 
                route: '/process2s/minwonType2s',
                ImageUrl: '',
            },
            { 
                title: '보상신청심의', 
                description: '', 
                key: 'rewardApplications', 
                route: '/compensations/rewardApplications',
                ImageUrl: '',
            },
            { 
                title: '보상지급', 
                description: '', 
                key: 'compensationPayments', 
                route: '/compensations/compensationPayments',
                ImageUrl: '',
            },
            { 
                title: '분석관점1', 
                description: '', 
                key: 'analysis1s', 
                route: '/analysis1s/analysis1s',
                ImageUrl: '',
            },
            { 
                title: '분석관점', 
                description: '', 
                key: 'analysis2s', 
                route: '/analysis2s/analysis2s',
                ImageUrl: '',
            },
            
        ],
    }),
    
    async created() {
      var path = document.location.href.split("#/")
      this.urlPath = path[1];

    },
    watch: {
        cards(newCards) {
            this.flipped = new Array(newCards.length).fill(false);
        },
    },

    mounted() {
        var me = this;
        me.components = this.$ManagerLists;
    },

    methods: {
        openSideBar(){
            this.sideBar = !this.sideBar
        },
        changeUrl() {
            var path = document.location.href.split("#/")
            this.urlPath = path[1];
            this.flipped.fill(false);
        },
        goHome() {
            this.urlPath = null;
        },
        flipCard(index) {
            this.$set(this.flipped, index, true);
        },
        unflipCard(index) {
            this.$set(this.flipped, index, false);
        },
    }
};
</script>
<style>
</style>
