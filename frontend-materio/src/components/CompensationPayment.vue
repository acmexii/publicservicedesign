<template>
    <div>
        <Money offline label="금액" v-model="value.amount" :editMode="editMode" @change="change"/>

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
import Money from './vo/Money.vue'

export default {
    name: 'CompensationPayment',
    mixins:[BaseEntity],
    components:{
        Money,
    },
    
    data: () => ({
        path: "compensationPayments"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
