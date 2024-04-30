<template>

    <v-card outlined>
        <v-card-title>
            CreateProcessing
        </v-card-title>

        <v-card-text>
            <String label="Name" v-model="value.name" :editMode="editMode"/>
            <Date label="Date" v-model="value.date" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="createProcessing"
            >
                CreateProcessing
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
import Date from './primitives/Date.vue'

export default {
    name: 'CreateProcessingCommand',
    components:{
        String,
        Date,
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.name = '';
        this.value.date = '2024-04-29';
    },
    watch: {
    },
    methods: {
        createProcessing() {
            this.$emit('createProcessing', this.value);
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

