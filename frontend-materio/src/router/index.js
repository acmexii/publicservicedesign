import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/applications',
      component: () => import('../components/ui/ApplicationGrid.vue'),
    },

    {
      path: '/investigations',
      component: () => import('../components/ui/InvestigationGrid.vue'),
    },
    {
      path: '/processings',
      component: () => import('../components/ui/ProcessingGrid.vue'),
    },
    {
      path: '/minwonType2s',
      component: () => import('../components/ui/MinwonType2Grid.vue'),
    },
    {
      path: '/rewardApplications',
      component: () => import('../components/ui/RewardApplicationGrid.vue'),
    },
    {
      path: '/compensationPayments',
      component: () => import('../components/ui/CompensationPaymentGrid.vue'),
    },
    {
      path: '/analysis1s',
      component: () => import('../components/ui/Analysis1Grid.vue'),
    },
    {
      path: '/analysis2s',
      component: () => import('../components/ui/Analysis2Grid.vue'),
    },
  ],
})

export default router;
