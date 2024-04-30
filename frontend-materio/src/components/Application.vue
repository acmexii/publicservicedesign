<template>
    <div>
        <String label="민원번호" v-model="value.민원번호" :editMode="editMode"/>
        <String label="민원내용" v-model="value.민원내용" :editMode="editMode"/>
        <String label="진행상태" v-model="value.진행상태" :editMode="editMode"/>

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
    name: 'Application',
    mixins:[BaseEntity],
    components:{
        String,
    },
    
    data: () => ({
        path: "applications"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
