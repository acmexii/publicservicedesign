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
                    color="primary"
                    text
                    @click="createCompensationPayment"
            >
                CreateCompensationPayment
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'CreateCompensationPaymentCommand',
        components:{},
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
                this.$emit('input', this.value);
            },
        }
    }
</script>

