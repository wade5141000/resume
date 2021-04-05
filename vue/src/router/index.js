import Vue from "vue";
import VueRouter from "vue-router";
import About from "../views/About.vue";
import Login from "../views/Login.vue";
import Signup from "../views/Signup.vue";
import Privacy from "../views/Privacy.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Login",
    component: Login,
    meta: {
      title: "帳號登入"
    }
  },
  {
    path: "/about",
    name: "About",
    component: About,
    meta: {
      title: "關於我們"
    }
  },
  {
    path: "/signup",
    name: "Signup",
    component: Signup,
    meta: {
      title: "帳號註冊"
    }
  },
  {
    path: "/privacy",
    name: "Privacy",
    component: Privacy,
    meta: {
      title: "使用條款"
    }
  },
  {
    path: "*",
    redirect: "/"
  }
];

const router = new VueRouter({
  mode: "history",
  // base: process.env.BASE_URL,
  routes
});

router.beforeEach((to, from, next) => {
  if (to.meta.title) {
    document.title = to.meta.title;
  }
  next();
});

export default router;
