import Vue from "vue";
import VueRouter from "vue-router";
import About from "../views/About.vue";
import Login from "../views/Login.vue";
import Signup from "../views/Signup.vue";
import Privacy from "../views/Privacy.vue";
import Terms from "../views/Terms.vue";
import Forgetpw from "../views/Forgetpw.vue";
import Resetpw from "../views/Resetpw.vue";
import BasicInfo from "../views/user-info/BasicInfo";
import EducationInfo from "../views/user-info/EducationInfo";
import ExperienceInfo from "../views/user-info/ExperienceInfo";

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
    path: "/forgetpw",
    name: "Forgetpw",
    component: Forgetpw,
    meta: {
      title: "忘記密碼"
    }
  },
  {
    path: "/resetpw",
    name: "Resetpw",
    component: Resetpw,
    meta: {
      title: "重設密碼"
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
    path: "/terms",
    name: "Terms",
    component: Terms,
    meta: {
      title: "使用條款"
    }
  },
  {
    path: "/privacy",
    name: "Privacy",
    component: Privacy,
    meta: {
      title: "隱私權政策"
    }
  },
  {
    path: "/user-info",
    name: "BasicInfo",
    component: BasicInfo,
    meta: {
      title: "基本資料"
    }
  },
  {
    path: "/education",
    name: "EducationInfo",
    component: EducationInfo,
    meta: {
      title: "基本資料"
    }
  },
  {
    path: "/experience",
    name: "ExperienceInfo",
    component: ExperienceInfo,
    meta: {
      title: "基本資料"
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
