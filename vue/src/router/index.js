import Vue from "vue";
import VueRouter from "vue-router";
import Index from "../views/Index";
import Login from "../views/account/Login";
import Signup from "../views/account/Signup";
import Privacy from "../views/Privacy";
import Terms from "../views/Terms";
import Forgetpw from "../views/account/Forgetpw";
import Resetpw from "../views/account/Resetpw";
import BasicInfo from "../views/user-info/BasicInfo";
import EducationList from "../views/user-info/education/EducationList";
import EducationInfo from "../views/user-info/education/EducationInfo";
import ExperienceList from "../views/user-info/experience/ExperienceList";
import ExperienceInfo from "../views/user-info/experience/ExperienceInfo";
import SkillInfo from "../views/user-info/SkillInfo";
import Autobiography from "../views/user-info/Autobiography";
import Resume from "../views/Resume";
import Index from "../views/Index";
import store from "../store";

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
    path: "/resume",
    name: "Resume",
    component: Resume,
    meta: {
      title: "我的履歷"
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
    path: "/experience-list",
    name: "ExperienceList",
    component: ExperienceList,
    meta: {
      title: "工作經歷列表"
    }
  },
  {
    path: "/education-list",
    name: "EducationList",
    component: EducationList,
    meta: {
      title: "學歷列表"
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

  let allow = false;
  let allowPass = [
    "/",
    "/login",
    "/forgetpw",
    "/resetpw",
    "/signup",
    "/terms",
    "/privacy"
  ];
  allowPass.forEach(path => {
    if (path === to.path) {
      allow = true;
    }
  });

  if (allow) {
    next();
  } else if (localStorage.getItem("user")) {
    let user = JSON.parse(localStorage.getItem("user"));
    if (user.expiration >= Date.now()) {
      next();
    } else {
      store.commit("logout");
      next({ path: "/login" });
    }
  } else {
    next({ path: "/login" });
  }
});

export default router;
