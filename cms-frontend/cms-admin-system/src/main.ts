import { createApp } from "vue";
import App from "./App.vue";
import "./assets/styles/reset.css";

import router from "@/router/index.ts";
import pinia from "@/store";
import * as ElementPlusIconsVue from "@element-plus/icons-vue";

const app = createApp(App);

// 导入图标库并注册
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
	app.component(key, component);
}

app.use(router);
app.use(pinia);

app.mount("#app");
