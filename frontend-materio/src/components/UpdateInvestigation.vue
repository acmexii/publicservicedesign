<template>

    <v-card outlined>
        <v-card-title>
            UpdateInvestigation
        </v-card-title>

        <v-card-text>
            <String label="Result" v-model="value.result" :editMode="editMode"/>
            <Boolean label="Approve" v-model="value.approve" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="updateInvestigation"
            >
                UpdateInvestigation
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
import String from './primitives/String.vue'
import Boolean from './primitives/Boolean.vue'

export default {
    name: 'UpdateInvestigationCommand',
    components:{
        String,
        Boolean,
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.result = '';
        this.value.approve = false;
    },
    watch: {
    },
    methods: {
        updateInvestigation() {
            this.$emit('updateInvestigation', this.value);
        },
        close() {
            this.$emit('closeDialog');
        },
        change() {
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>

