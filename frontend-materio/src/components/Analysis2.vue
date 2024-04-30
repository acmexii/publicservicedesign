<template>
    <div>

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

export default {
    name: 'Analysis2',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "analysis2s"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
