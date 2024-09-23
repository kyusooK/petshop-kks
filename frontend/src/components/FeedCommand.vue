<template>
    <v-card outlined>
        <v-card-title>
            Feed
        </v-card-title>

        <v-card-text>
            <Number label="Gram" v-model="value.gram" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="feed"
            >
                Feed
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
        name: 'FeedCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.gram = 0;
        },
        watch: {
        },
        methods: {
            feed() {
                this.$emit('feed', this.value);
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

