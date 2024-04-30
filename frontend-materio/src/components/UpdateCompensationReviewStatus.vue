<template>

    <v-card outlined>
        <v-card-title>
            UpdateCompensationReviewStatus
        </v-card-title>

        <v-card-text>
            <String label="Id" v-model="value.id" :editMode="editMode"/>
            <String label="Status" v-model="value.status" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="updateCompensationReviewStatus"
            >
                UpdateCompensationReviewStatus
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
import String from './primitives/String.vue';

export default {
    name: 'UpdateCompensationReviewStatusCommand',
    components:{
        String,
        String,
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.id = '';
        this.value.status = '';
    },
    watch: {
    },
    methods: {
        updateCompensationReviewStatus() {
            this.$emit('updateCompensationReviewStatus', this.value);
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

