
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ApplicationApplicationManager from "./components/listers/ApplicationApplicationCards"
import ApplicationApplicationDetail from "./components/listers/ApplicationApplicationDetail"

import Process1InvestigationManager from "./components/listers/Process1InvestigationCards"
import Process1InvestigationDetail from "./components/listers/Process1InvestigationDetail"
import Process1ProcessingManager from "./components/listers/Process1ProcessingCards"
import Process1ProcessingDetail from "./components/listers/Process1ProcessingDetail"

import Process2MinwonType2Manager from "./components/listers/Process2MinwonType2Cards"
import Process2MinwonType2Detail from "./components/listers/Process2MinwonType2Detail"

import CompensationRewardApplicationManager from "./components/listers/CompensationRewardApplicationCards"
import CompensationRewardApplicationDetail from "./components/listers/CompensationRewardApplicationDetail"
import CompensationCompensationPaymentManager from "./components/listers/CompensationCompensationPaymentCards"
import CompensationCompensationPaymentDetail from "./components/listers/CompensationCompensationPaymentDetail"

import Analysis1Analysis1Manager from "./components/listers/Analysis1Analysis1Cards"
import Analysis1Analysis1Detail from "./components/listers/Analysis1Analysis1Detail"

import Analysis2Analysis2Manager from "./components/listers/Analysis2Analysis2Cards"
import Analysis2Analysis2Detail from "./components/listers/Analysis2Analysis2Detail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/applications/applications',
                name: 'ApplicationApplicationManager',
                component: ApplicationApplicationManager
            },
            {
                path: '/applications/applications/:id',
                name: 'ApplicationApplicationDetail',
                component: ApplicationApplicationDetail
            },

            {
                path: '/process1s/investigations',
                name: 'Process1InvestigationManager',
                component: Process1InvestigationManager
            },
            {
                path: '/process1s/investigations/:id',
                name: 'Process1InvestigationDetail',
                component: Process1InvestigationDetail
            },
            {
                path: '/process1s/processings',
                name: 'Process1ProcessingManager',
                component: Process1ProcessingManager
            },
            {
                path: '/process1s/processings/:id',
                name: 'Process1ProcessingDetail',
                component: Process1ProcessingDetail
            },

            {
                path: '/process2s/minwonType2s',
                name: 'Process2MinwonType2Manager',
                component: Process2MinwonType2Manager
            },
            {
                path: '/process2s/minwonType2s/:id',
                name: 'Process2MinwonType2Detail',
                component: Process2MinwonType2Detail
            },

            {
                path: '/compensations/rewardApplications',
                name: 'CompensationRewardApplicationManager',
                component: CompensationRewardApplicationManager
            },
            {
                path: '/compensations/rewardApplications/:id',
                name: 'CompensationRewardApplicationDetail',
                component: CompensationRewardApplicationDetail
            },
            {
                path: '/compensations/compensationPayments',
                name: 'CompensationCompensationPaymentManager',
                component: CompensationCompensationPaymentManager
            },
            {
                path: '/compensations/compensationPayments/:id',
                name: 'CompensationCompensationPaymentDetail',
                component: CompensationCompensationPaymentDetail
            },

            {
                path: '/analysis1s/analysis1s',
                name: 'Analysis1Analysis1Manager',
                component: Analysis1Analysis1Manager
            },
            {
                path: '/analysis1s/analysis1s/:id',
                name: 'Analysis1Analysis1Detail',
                component: Analysis1Analysis1Detail
            },

            {
                path: '/analysis2s/analysis2s',
                name: 'Analysis2Analysis2Manager',
                component: Analysis2Analysis2Manager
            },
            {
                path: '/analysis2s/analysis2s/:id',
                name: 'Analysis2Analysis2Detail',
                component: Analysis2Analysis2Detail
            },




    ]
})
