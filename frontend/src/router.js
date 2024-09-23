
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PetmanagementPetManager from "./components/listers/PetmanagementPetCards"
import PetmanagementPetDetail from "./components/listers/PetmanagementPetDetail"

import StoreItemManager from "./components/listers/StoreItemCards"
import StoreItemDetail from "./components/listers/StoreItemDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/petmanagements/pets',
                name: 'PetmanagementPetManager',
                component: PetmanagementPetManager
            },
            {
                path: '/petmanagements/pets/:id',
                name: 'PetmanagementPetDetail',
                component: PetmanagementPetDetail
            },

            {
                path: '/stores/items',
                name: 'StoreItemManager',
                component: StoreItemManager
            },
            {
                path: '/stores/items/:id',
                name: 'StoreItemDetail',
                component: StoreItemDetail
            },



    ]
})
