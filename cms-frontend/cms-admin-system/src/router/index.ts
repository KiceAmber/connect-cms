import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
	history: createWebHistory(),
	routes: [
		{
			path: "/",
			redirect: "/login",
		},
		{
			path: "/login",
			component: () => import("../views/Login/index.vue"),
		},
		{
			path: "/admin",
			redirect: "/admin/dashboard",
			component: () => import("../layout/index.vue"),
			children: [
				{
					path: "dashboard",
					component: () => import("../views/Dashboard/index.vue"),
				},
			],
		},
	],
});

// TODO: 添加路由守卫

export default router;
