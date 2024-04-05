<script setup lang="ts">
import { Ref, ref } from "vue";

const overlaylong: Ref<string> = ref("overlaylong");
const overlaytitle: Ref<string> = ref("overlaytitle");
const disfiex: Ref<number> = ref(0);

const switchSignin = () => {
	overlaylong.value = "overlaylongleft";
	overlaytitle.value = "overlaytitleright";
	setTimeout(() => {
		disfiex.value = 1;
	}, 200);
};
const switchSignup = () => {
	overlaylong.value = "overlaylongright";
	overlaytitle.value = "overlaytitleleft";
	setTimeout(() => {
		disfiex.value = 0;
	}, 200);
};
</script>

<template>
	<div class="center">
		<div class="logon">
			<div :class="overlaylong">
				<div class="overlaylong-Signin" v-if="disfiex == 0">
					<h2 class="overlaylongH2">Sign in</h2>
					<input type="text" placeholder="Accoutn" />
					<input type="text" placeholder="Password" />
					<h3>Forgot your password?</h3>
					<button class="inupbutton">Sign in</button>
				</div>
				<div class="overlaylong-Signup" v-if="disfiex == 1">
					<h2 class="overlaylongH2">Register</h2>
					<input type="text" placeholder="Account" />
					<input type="text" placeholder="Password" />
					<button class="inupbutton">Sign up</button>
				</div>
			</div>
			<div :class="overlaytitle">
				<div class="overlaytitle-Signin" v-if="disfiex == 0">
					<h2 class="overlaytitleH2">Hello,Admin!</h2>
					<div class="buttongohs" @click="switchSignin">Sign up</div>
				</div>
				<div class="overlaytitle-Signup" v-if="disfiex == 1">
					<h2 class="overlaytitleH2">Welcome Back!</h2>
					<div class="buttongohs" @click="switchSignup">Sign in</div>
				</div>
			</div>
		</div>
	</div>
</template>

<style lang="scss" scoped>
.center {
	width: 100%;
	height: 100vh;
	font-family: 'Courier New', Courier, monospace;
	background-image: url("https://gd-hbimg.huaban.com/9165dc3c0f8279ae5402d1f47212847bff68b49f3cb547-QEli8R");
	background-size: 100% 100%;
	background-repeat: no-repeat;
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
	.logon {
		background-color: #fff;
		border-radius: 10px;
		box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25), 0 10px 10px rgba(0, 0, 0, 0.22);
		/* position: relative;
		overflow: hidden; */
		width: 768px;
		max-width: 100%;
		min-height: 480px;
		margin-top: 20px;
		display: flex;
		background: -webkit-linear-gradient(right, #4284db, #29eac4);
		.overlaylong {
			border-radius: 10px 0 0 10px;
			width: 50%;
			height: 100%;
			background-color: #fff;
			display: flex;
			align-items: center;
			justify-content: center;
		}
		.overlaylongleft {
			border-radius: 0px 10px 10px 0px;
			width: 50%;
			height: 100%;
			background-color: #fff;
			transform: translateX(100%);
			transition: transform 0.6s ease-in-out;
			display: flex;
			align-items: center;
			justify-content: center;
		}
		.overlaylongright {
			border-radius: 10px 0 0 10px;
			width: 50%;
			height: 100%;
			background-color: #fff;
			transform: translateX(0%);
			transition: transform 0.6s ease-in-out;
			display: flex;
			align-items: center;
			justify-content: center;
		}
		.overlaytitle {
			border-radius: 0px 10px 10px 0px;
			width: 50%;
			height: 100%;
			background-color: rgba(0, 0, 0, 0);
			display: flex;
			align-items: center;
			justify-content: center;
		}
	}
}

.overlaytitleH2 {
	font-size: 30px;
	color: #fff;
	margin-top: 20px;
}

.overlaytitleleft {
	border-radius: 0px 10px 10px 0px;
	width: 50%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0);
	display: flex;
	align-items: center;
	justify-content: center;
	transform: translateX(0%);
	transition: transform 0.6s ease-in-out;
}

.overlaytitleright {
	border-radius: 0px 10px 10px 0px;
	width: 50%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0);
	display: flex;
	align-items: center;
	justify-content: center;
	transform: translateX(-100%);
	transition: transform 0.6s ease-in-out;
}

.overlaytitle-Signin {
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
}

.overlaytitle-Signup {
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
}

.buttongohs {
	width: 180px;
	height: 40px;
	border-radius: 50px;
	border: 1px solid #fff;
	color: #fff;
	font-size: 15px;
	text-align: center;
	line-height: 40px;
	margin-top: 40px;
}

.overlaylongH2 {
	font-size: 25px;
	color: black;
	/* width: 250px; */
}

.overlaylong-Signin {
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
}

.overlaylong-Signup {
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
}

input {
	background-color: #eee;
	border: none;
	padding: 12px 15px;
	margin: 10px 0;
	width: 240px;
}
h3 {
	font-size: 10px;
	margin-top: 10px;
	cursor: pointer;
}
.inupbutton {
	background-color: #29eac4;
	border: none;
	width: 180px;
	height: 40px;
	border-radius: 50px;
	font-size: 15px;
	color: #fff;
	text-align: center;
	line-height: 40px;
	margin-top: 30px;
}
</style>
