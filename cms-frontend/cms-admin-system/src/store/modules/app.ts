import { defineStore } from "pinia";
import { Ref, ref } from "vue";

export const useAppStore = defineStore("App", () => {
	const isCollapse: Ref<Boolean> = ref(false);

	const changeCollapseState = () => {
		isCollapse.value = !isCollapse.value;
	};

	return {
		// data
		isCollapse,

		// function
		changeCollapseState,
	};
});
