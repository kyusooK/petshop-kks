<template>
    <v-card outlined>
        <v-card-title>
            Groom
        </v-card-title>

        <v-card-text>
            <Number label="Minutes" v-model="value.minutes" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="groom"
            >
                Groom
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
        name: 'GroomCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.minutes = 0;
        },
        watch: {
        },
        methods: {
            groom() {
                this.$emit('groom', this.value);
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

