<template>

    <v-card outlined>
        <v-card-title>
            UpdateMinwonType2
        </v-card-title>

        <v-card-text>
            <String label="Name" v-model="value.name" :editMode="editMode"/>
            <String label="Description" v-model="value.description" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="updateMinwonType2"
            >
                UpdateMinwonType2
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
    name: 'UpdateMinwonType2Command',
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
        this.value.name = '';
        this.value.description = '';
    },
    watch: {
    },
    methods: {
        updateMinwonType2() {
            this.$emit('updateMinwonType2', this.value);
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

