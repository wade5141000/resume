<template>
  <v-row justify="center">
    <v-col cols="12" md="10" lg="9">
      <theStepper non-linear step="1"></theStepper>
      <v-expansion-panels v-model="panel" multiple class="mt-4">
        <v-expansion-panel>
          <v-expansion-panel-header color="blue">
            <template v-slot:actions>
              <v-icon color="white">$expand</v-icon>
            </template>
            <span class="white--text text-h6">基本資料</span>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <v-row no-gutters class="mt-6" justify="center">
              <v-col cols="10" md="10" lg="10">
                <v-alert outlined type="error" prominent border="left">
                  <h3 justify="center" class="my-green">
                    請勾選
                    <strong>{{ template.basicInfo }}</strong>
                    項，欲顯示在履歷表中的項目
                  </h3>
                  您目前已勾選 {{ selectedCount }} 項，若有不足，將以空白呈顯。
                </v-alert>
              </v-col>
            </v-row>
            <v-row no-gutters class="mt-6 mx-auto" justify="center">
              <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                <v-checkbox
                  :label="user.name"
                  color="red darken-3"
                  value="name"
                  v-model="selected"
                  @change="count"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                <v-checkbox
                  :label="user.birthday"
                  color="red darken-3"
                  value="birthday"
                  v-model="selected"
                  @change="count"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                <v-checkbox
                  :label="user.sex"
                  color="red darken-3"
                  value="sex"
                  v-model="selected"
                  @change="count"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                <v-checkbox
                  :label="user.militaryService"
                  color="red darken-3"
                  value="militaryService"
                  v-model="selected"
                  @change="count"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="5" lg="10" class="pa-0 mt-0">
                <v-checkbox
                  :label="user.address"
                  color="red darken-3"
                  value="address"
                  v-model="selected"
                  @change="count"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                <v-checkbox
                  :label="user.phone"
                  color="red darken-3"
                  value="phone"
                  v-model="selected"
                  @change="count"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="5" lg="5" class="pa-0 mt-0">
                <v-checkbox
                  :label="user.email"
                  color="red darken-3"
                  value="email"
                  v-model="selected"
                  @change="count"
                ></v-checkbox>
              </v-col>
              <v-col cols="10" md="10" lg="10" class="pa-0 mt-0">
                <v-checkbox
                  :label="user.driverLicense"
                  color="red darken-3"
                  value="driverLicense"
                  v-model="selected"
                  @change="count"
                ></v-checkbox>
              </v-col>
              <v-col
                cols="10"
                md="10"
                lg="10"
                class="pa-0 mt-0"
                justify="start"
              >
                <v-checkbox
                  :label="user.specialIdentity"
                  color="red darken-3"
                  value="specialIdentity"
                  v-model="selected"
                  @change="count"
                ></v-checkbox>
              </v-col>
            </v-row>

            <v-row no-gutters class="mt-6" justify="center">
              <v-col cols="10" md="10" lg="10" class="pa-0 mt-0">
                <v-checkbox
                  :label="user.introduction"
                  color="red darken-3"
                  value="introduction"
                  v-model="selected"
                  @change="count"
                ></v-checkbox>
              </v-col>
            </v-row>

            <v-row no-gutters class="mt-6" justify="center">
              <v-col cols="10" md="10" lg="10" class="pa-0 mt-0">
                <v-checkbox
                  :label="user.feature"
                  color="red darken-3"
                  value="feature"
                  v-model="selected"
                  @change="count"
                ></v-checkbox>
              </v-col>
            </v-row>

            <!--            <v-row no-gutters class="mt-6" justify="center">-->
            <!--              <v-col cols="10" md="10" lg="10" class="pa-0 mt-0 mb-2">-->
            <!--                <v-checkbox-->
            <!--                  label="個人連結"-->
            <!--                  color="red darken-3"-->
            <!--                  value="個人連結"-->
            <!--                ></v-checkbox>-->
            <!--              </v-col>-->
            <!--            </v-row>-->
            <v-row justify="center" class="mb-2">
              <v-col cols="5" md="4" lg="4">
                <v-btn depressed large block color="primary" @click="nextStep"
                  >儲存，下一步</v-btn
                >
              </v-col>
            </v-row>
          </v-expansion-panel-content>
        </v-expansion-panel>
      </v-expansion-panels>
    </v-col>
  </v-row>
</template>

<script>
import theStepper from "../../components/theStepperApply";
import theDialog from "../../components/theDialog";
import http from "../../utils/http";
export default {
  components: {
    theStepper,
    theDialog
  },
  watch: {},
  created: function() {
    http.get("/user").then(response => {
      this.user = response.data;
    });
    http.get("/template/" + this.$route.query.templateId).then(response => {
      this.template = response.data;
      console.log(response.data);
    });
  },
  data: () => ({
    panel: [0],
    user: {},
    selected: [],
    selectedCount: 0,
    template: {}
  }),
  methods: {
    nextStep() {
      console.log(this.user);
      console.log(this.selected);
      if (this.selected.length > this.template.basicInfo) {
        alert("數量超出限制");
      } else {
        http
          .put("/resume/" + this.template.id + "/basic-info", this.selected)
          .then(response => {
            if (response.data == true) {
              alert("成功");
              this.$router.push(
                "/educationinfo-apply?templateId=" +
                  this.$route.query.templateId
              );
            } else {
              alert("操作失敗");
            }
          });
      }
    },
    count() {
      this.selectedCount = this.selected.length;
    }
  }
};
</script>
