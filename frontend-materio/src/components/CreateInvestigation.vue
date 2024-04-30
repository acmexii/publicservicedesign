<template>

    <v-card outlined>
        <v-card-title>
            CreateInvestigation
        </v-card-title>

        <v-card-text>
            <String label="Name" v-model="value.name" :editMode="editMode"/>
            <String label="Description" v-model="value.description" :editMode="editMode"/>
            <Date label="Date" v-model="value.date" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="createInvestigation"
            >
                CreateInvestigation
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
import Date from './primitives/Date.vue';
import String from './primitives/String.vue';

export default {
    name: 'CreateInvestigationCommand',
    components:{
        String,
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
        this.value.description = '';
        this.value.date = '2024-04-29';
    },
    watch: {
    },
    methods: {
        createInvestigation() {
            this.$emit('createInvestigation', this.value);
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

