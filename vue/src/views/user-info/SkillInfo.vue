<template>
  <v-row justify="center">
    <v-col cols="12" md="8" lg="6" class="mt-6">
      <theStepper step="4"></theStepper>
      <v-expansion-panels v-model="panel" multiple class="mt-8">
        <v-expansion-panel>
          <v-expansion-panel-header color="blue">
            <span class="white--text text-h6">專業技能</span>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <v-row class="mt-6" no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <span>專長名稱</span>
                <v-text-field
                  outlined
                  dense
                  v-model="experience.companyName"
                ></v-text-field>
              </v-col>
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="6" md="5" lg="4">
                <span>專長描述</span>
              </v-col>
              <v-col cols="6" md="5" lg="4" class="d-flex justify-end">
                <span
                  ><v-icon color="blue">mdi-chat-question</v-icon>看看範例</span
                ></v-col
              >
            </v-row>
            <v-row no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <v-textarea
                  outlined
                  v-model="experience.experienceDesc"
                  rows="3"
                  auto-grow
                  no-resize
                  maxLength="100"
                  counter="100"
                ></v-textarea>
              </v-col>
            </v-row>
          </v-expansion-panel-content>
        </v-expansion-panel>

        <v-expansion-panel>
          <v-expansion-panel-header color="blue">
            <span class="white--text text-h6">語言能力</span>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <!--            <v-row class="mt-6" no-gutters justify="center">-->
            <!--              <v-col cols="12" md="10" lg="8">-->
            <!--                <span>語言類型</span>-->
            <!--              </v-col>-->
            <!--            </v-row>-->
            <v-row class="mt-2" justify="center">
              <v-col cols="4" md="4" lg="4">
                <span>語言類型</span>
                <v-text-field
                  outlined
                  dense
                  hide-details
                  v-model="experience.companyName"
                ></v-text-field>
              </v-col>
              <v-col cols="4" md="4" lg="1">
                <span>聽</span>
                <v-select dense outlined></v-select>
              </v-col>
              <v-col cols="4" md="4" lg="1">
                <span>說</span>
                <v-select dense outlined></v-select>
              </v-col>
              <v-col cols="4" md="4" lg="1">
                <span>讀</span>
                <v-select dense outlined></v-select>
              </v-col>
              <v-col cols="4" md="4" lg="1">
                <span>寫</span>
                <v-select dense outlined></v-select>
              </v-col>

              <!--              <v-col cols="1" md="1" lg="1">-->
              <!--                <span>說</span>-->
              <!--                <v-text-field-->
              <!--                    outlined-->
              <!--                    dense-->
              <!--                    v-model="experience.companyName"-->
              <!--                ></v-text-field>-->
              <!--              </v-col>-->
              <!--              <v-col cols="1" md="1" lg="1">-->
              <!--                <span>讀</span>-->
              <!--                <v-text-field-->
              <!--                    outlined-->
              <!--                    dense-->
              <!--                    v-model="experience.companyName"-->
              <!--                ></v-text-field>-->
              <!--              </v-col>-->
              <!--              <v-col cols="1" md="1" lg="1">-->
              <!--                <span>寫</span>-->
              <!--                <v-text-field-->
              <!--                    outlined-->
              <!--                    dense-->
              <!--                    v-model="experience.companyName"-->
              <!--                ></v-text-field>-->
              <!--              </v-col>-->
            </v-row>
          </v-expansion-panel-content>
        </v-expansion-panel>

        <v-expansion-panel>
          <v-expansion-panel-header color="blue">
            <span class="white--text text-h6">證照</span>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <v-row class="mt-6" no-gutters justify="center">
              <v-col cols="12" md="10" lg="8">
                <span>證照名稱</span>
                <v-text-field
                  outlined
                  dense
                  v-model="license"
                  v-on:keyup.enter="onLicenseEnter()"
                  maxLength="20"
                  counter="20"
                ></v-text-field>
                <v-chip
                  v-for="(item, index) in licenses"
                  v-bind:key="index"
                  close
                  color="blue"
                  text-color="white"
                  class="mr-2 mb-2"
                  @click:close="close(item)"
                >
                  {{ item }}
                </v-chip>
              </v-col>
            </v-row>
          </v-expansion-panel-content>
        </v-expansion-panel>
      </v-expansion-panels>
      <v-row no-gutters justify="center" class="my-6">
        <v-col cols="5" md="4" lg="4">
          <v-btn depressed large block color="primary" @click="nextStep"
            >下一步</v-btn
          >
        </v-col>
      </v-row>
    </v-col>
  </v-row>
</template>

<script>
import theStepper from "../../components/theStepper";
export default {
  components: {
    theStepper
  },
  watch: {
    menu(val) {
      val && setTimeout(() => (this.$refs.picker.activePicker = "YEAR"));
    },
    menu2(val) {
      val && setTimeout(() => (this.$refs.picker2.activePicker = "YEAR"));
    }
  },
  data: () => ({
    panel: [0, 1, 2],
    menu: false,
    menu2: false,
    experience: {},
    license: "",
    licenses: [],
    items: []
  }),
  methods: {
    pickStartDate(date) {
      this.$refs.menu.save(date);
    },
    pickEndDate(date) {
      this.$refs.menu2.save(date);
    },
    nextStep() {
      this.experience.license = this.licenses.join(",");
      console.log(this.experience);
      //this.$router.push("/experience");
    },
    onLicenseEnter() {
      if (this.license.length > 0) {
        this.licenses.push(this.license);
        this.license = "";
      }
    },
    close(str) {
      this.licenses = this.licenses.filter(item => item !== str);
    }
  }
};
</script>

<style>
span {
  color: dodgerblue;
}

.v-select {
  display: inline-block;
  width: auto;
}
</style>
