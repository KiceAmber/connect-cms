import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: "/",
      redirect: "/admin",
    },
    {
      path: "/admin",
      redirect: "/admin/dashboard",
      component: () => import("../layout/index.vue"),
      children: [
        {
          path: "dashboard",
          component: () => import("../views/Dashboard.vue"),
        },
      ],
    },
  ],
});

export default router;
