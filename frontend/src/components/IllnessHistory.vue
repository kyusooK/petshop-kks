<template>

    <v-card outlined>
        <v-card-title>
            IllnessHistory
        </v-card-title>

        <v-card-text>
            <String label="IllName" v-model="value.illName" :editMode="editMode"/>
            <Number label="Start" v-model="value.start" :editMode="editMode"/>
            <Number label="End" v-model="value.end" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </v-card>
</template>

<script>

    export default {
        name: 'IllnessHistory',
        components:{},
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
            inList: Boolean,
            label: String,
        },
        data: () => ({
        }),
        async created() {
            if(!Object.values(this.value)[0]) {
                this.$emit('input', {});
                this.newValue = {
                    'illName': '',
                    'start': '',
                    'end': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('illName' in this.value)) {
                    this.value.illName = '';
                }
                if(!('start' in this.value)) {
                    this.value.start = 0;
                }
                if(!('end' in this.value)) {
                    this.value.end = 0;
                }
            }
        },
        watch: {
            value(val) {
                this.$emit('input', val);
            },
            newValue(val) {
                this.$emit('input', val);
            },
        },

        methods: {
            edit() {
                this.editMode = true;
            },
            async add() {
                this.editMode = false;
                this.$emit('input', this.value);

                if(this.isNew){
                    this.$emit('add', this.value);
                } else {
                    this.$emit('edit', this.value);
                }
            },
            async remove(){
                this.editMode = false;
                this.isDeleted = true;

                this.$emit('input', this.value);
                this.$emit('delete', this.value);
            },
            change(){
                this.$emit('change', this.value);
            },
        }
    }
</script>

