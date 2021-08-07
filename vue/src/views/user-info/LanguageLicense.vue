<template>
  <v-row justify="center">
    <v-col cols="12" md="10" lg="9">
      <theStepper step="5"></theStepper>
      <v-expansion-panels v-model="panel" multiple class="mt-4">
        <v-expansion-panel>
          <v-expansion-panel-header color="blue">
            <template v-slot:actions>
              <v-icon color="white">$expand</v-icon>
            </template>
            <span class="white--text text-h6">語言能力</span>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <v-row justify="center" class="mt-4 mb-0 py-0">
              <v-col
                cols="12"
                md="11"
                lg="11"
                class="d-flex justify-end py-0 px-0"
              >
                <v-btn text color="primary" @click="addLanguage">
                  <v-icon left>mdi-plus-circle</v-icon>新增語言能力
                </v-btn>
              </v-col>
            </v-row>
            <v-row
              justify="center"
              class="mt-0"
              v-for="(language, index) in languages"
              v-bind:key="index"
            >
              <v-col cols="12" md="3" lg="3">
                <v-text-field
                  :label="'語言類型 ' + (index + 1)"
                  outlined
                  dense
                  hide-details
                  v-model="language.language"
                >
                  <template v-slot:prepend>
                    <v-icon @click="removeLanguage(index)" color="red">
                      mdi-close
                    </v-icon>
                  </template>
                </v-text-field>
              </v-col>
              <v-col cols="6" md="2" lg="2">
                <v-select
                  label="聽"
                  dense
                  outlined
                  :items="languageLevels"
                  v-model="language.listening"
                ></v-select>
              </v-col>
              <v-col cols="6" md="2" lg="2">
                <v-select
                  label="說"
                  dense
                  outlined
                  :items="languageLevels"
                  v-model="language.speaking"
                ></v-select>
              </v-col>
              <v-col cols="6" md="2" lg="2">
                <v-select
                  label="讀"
                  dense
                  outlined
                  :items="languageLevels"
                  v-model="language.reading"
                ></v-select>
              </v-col>
              <v-col cols="6" md="2" lg="2">
                <v-select
                  label="寫"
                  dense
                  outlined
                  :items="languageLevels"
                  v-model="language.writing"
                ></v-select>
              </v-col>
            </v-row>
          </v-expansion-panel-content>
        </v-expansion-panel>
        <v-expansion-panel>
          <v-expansion-panel-header color="blue">
            <template v-slot:actions>
              <v-icon color="white">$expand</v-icon>
            </template>
            <span class="white--text text-h6">證照</span>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <v-row class="mt-4" justify="center">
              <v-col cols="12" md="10" lg="8">
                <v-text-field
                  label="證照名稱"
                  outlined
                  dense
                  v-model="license"
                  v-on:keyup.enter="onLicenseEnter()"
                  maxLength="20"
                  counter="20"
                  hint="輸入完畢按下【Enter】鍵完成新增"
                  persistent-hint
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
import theDialog from "../../components/theDialog";
import http from "../../utils/http";
export default {
  components: {
    theStepper,
    theDialog
  },
  created: function() {
    if (this.languages.length === 0) {
      this.languages.push({
        id: null,
        language: "",
        listening: "",
        speaking: "",
        reading: "",
        writing: ""
      });
    } else {
      //this.links = response.data.links;
    }
  },
  data: () => ({
    panel: [0, 1],
    languages: [],
    license: "",
    licenses: [],
    languageLevels: [
      { text: "精通", value: "精通" },
      { text: "中等", value: "中等" },
      { text: "略懂", value: "略懂" },
      { text: "不會", value: "不會" }
    ]
  }),
  methods: {
    onLicenseEnter() {
      if (this.license.length > 0) {
        this.licenses.push(this.license);
        this.license = "";
      }
    },
    close(str) {
      this.licenses = this.licenses.filter(item => item !== str);
    },
    addLanguage() {
      this.languages.push({
        id: null,
        language: "",
        listening: "",
        speaking: "",
        reading: "",
        writing: ""
      });
    },
    removeLanguage(index) {
      console.log(index);
      this.languages.splice(index, 1);
    },
    nextStep() {
      http.post("/language/languages", this.languages).then(response => {
        console.log(response);
        if (response.data === true) {
          alert("新增成功");
        } else {
          alert("新增失敗");
        }
      });
      //console.log(this.languages);
      //this.$router.push("/autobiography");
    }
  }
};
</script>

<style>
/*span {*/
/*  color: dodgerblue;*/
/*}*/
</style>
