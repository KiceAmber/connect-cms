import { createApp } from "vue";
import App from "./App.vue";
import "./assets/styles/reset.css";
import * as ElementPlusIconsVue from "@element-plus/icons-vue";

import router from "./router/index.ts";

const app = createApp(App);

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component);
}

app.use(router);

app.mount("#app");
