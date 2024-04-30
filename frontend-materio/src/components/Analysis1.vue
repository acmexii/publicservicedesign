<template>
    <div>
        <String label="ComplaintType" v-model="value.complaintType" :editMode="editMode"/>
        <Number label="TotalCount" v-model="value.totalCount" :editMode="editMode"/>
        <Number label="ApprovedCount" v-model="value.approvedCount" :editMode="editMode"/>
        <Number label="RejectedCount" v-model="value.rejectedCount" :editMode="editMode"/>

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
import Number from './primitives/Number.vue'

export default {
    name: 'Analysis1',
    mixins:[BaseEntity],
    components:{
        String,
        Number,
    },
    
    data: () => ({
        path: "analysis1s"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
