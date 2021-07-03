import Vue from "vue";
import VueRouter from "vue-router";
import About from "../views/Index.vue";
import Login from "../views/account/Login.vue";
import Signup from "../views/account/Signup.vue";
import Privacy from "../views/Privacy.vue";
import Terms from "../views/Terms.vue";
import Forgetpw from "../views/account/Forgetpw";
import Resetpw from "../views/account/Resetpw.vue";
import BasicInfo from "../views/user-info/BasicInfo";
import EducationInfo from "../views/user-info/EducationInfo";
import ExperienceInfo from "../views/user-info/ExperienceInfo";
import SkillInfo from "../views/user-info/SkillInfo";
import Autobiography from "../views/user-info/Autobiography";
import Index from "../views/Index";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Index",
    component: Index,
    meta: {
      title: "首頁"
    }
  },
  {
    path: "/login",
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
      title: "學歷"
    }
  },
  {
    path: "/experience",
    name: "ExperienceInfo",
    component: ExperienceInfo,
    meta: {
      title: "工作經歷"
    }
  },
  {
    path: "/skill",
    name: "SkillInfo",
    component: SkillInfo,
    meta: {
      title: "專業技能"
    }
  },
  {
    path: "/autobiography",
    name: "Autobiography",
    component: Autobiography,
    meta: {
      title: "自傳"
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
