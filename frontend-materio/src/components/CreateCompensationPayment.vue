<template>

    <v-card outlined>
        <v-card-title>
            CreateCompensationPayment
        </v-card-title>

        <v-card-text>
            <String label="Id" v-model="value.id" :editMode="editMode"/>
            <Money offline label="Amount" v-model="value.amount" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="createCompensationPayment"
            >
                CreateCompensationPayment
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
import Money from './vo/Money.vue'

export default {
    name: 'CreateCompensationPaymentCommand',
    components:{
        String,
        Money,
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.id = '';
        this.value.amount = {};
    },
    watch: {
    },
    methods: {
        createCompensationPayment() {
            this.$emit('createCompensationPayment', this.value);
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

