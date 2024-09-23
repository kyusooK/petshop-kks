<template>
    <v-card outlined>
        <v-card-title>
            Sleep
        </v-card-title>

        <v-card-text>
            <Number label="Hour" v-model="value.hour" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="sleep"
            >
                Sleep
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
        name: 'SleepCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.hour = 0;
        },
        watch: {
        },
        methods: {
            sleep() {
                this.$emit('sleep', this.value);
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

