<template>
    <div>
        <String label="사유" v-model="value.reason" :editMode="editMode"/>

        <v-divider class="border-opacity-100 my-divider"></v-divider>
        <v-layout row justify-end>
            <v-btn
                width="64px"
                color="primary"
                @click="save"
            >
                저장
            </v-btn>
        </v-layout>
    </div>
</template>


<script>

import BaseEntity from './base-ui/BaseEntity.vue'
import String from './primitives/String.vue'

export default {
    name: 'RewardApplication',
    mixins:[BaseEntity],
    components:{
        String,
    },
    
    data: () => ({
        path: "rewardApplications"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
