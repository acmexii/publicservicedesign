<template>
    <div>
        <String label="이름" v-model="value.name" :editMode="editMode"/>
        <Date label="일자" v-model="value.date" :editMode="editMode"/>
        <String label="민원번호" v-model="value.민원번호" :editMode="editMode"/>

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
import Date from './primitives/Date.vue'

export default {
    name: 'Processing',
    mixins:[BaseEntity],
    components:{
        String,
        Date,
    },
    
    data: () => ({
        path: "processings"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
