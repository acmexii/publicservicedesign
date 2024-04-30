<template>

    <v-card outlined>
        <v-card-title>
            CreateRewardApplication
        </v-card-title>

        <v-card-text>
            <String label="Id" v-model="value.id" :editMode="editMode"/>
            <String label="Reason" v-model="value.reason" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="createRewardApplication"
            >
                CreateRewardApplication
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
    name: 'CreateRewardApplicationCommand',
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
        this.value.reason = '';
    },
    watch: {
    },
    methods: {
        createRewardApplication() {
            this.$emit('createRewardApplication', this.value);
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

