<template>
  <v-row justify="center">
    <v-col cols="12" md="10" lg="9">
      <theStepper step="2"></theStepper>
      <v-expansion-panels v-model="panel" multiple class="mt-4">
        <v-expansion-panel>
          <v-expansion-panel-header color="blue" hide-actions>
            <v-row>
              <v-col><span class="white--text text-h6">學歷</span></v-col>
              <v-col class="d-flex justify-end">
                <v-btn text color="white" @click.native.stop="add">
                  <v-icon left>
                    mdi-plus-circle
                  </v-icon>
                  新增學歷
                </v-btn>
              </v-col>
            </v-row>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <v-row
              class="mt-4"
              justify="center"
              v-for="(education, index) in educations"
              :key="index"
            >
              <v-col cols="12" md="10" lg="6">
                <v-card elevation="2" outlined class="my-0 py-0"
                  ><v-card-title
                    >{{ education.schoolName }}({{
                      education.country
                    }})</v-card-title
                  >
                  <v-card-subtitle class="pb-0"
                    >{{ education.major }}｜{{ education.level
                    }}{{ education.status
                    }}<span class="float-right"
                      >{{ education.startDate }}~{{ education.endDate }}</span
                    ></v-card-subtitle
                  >
                  <v-card-actions>
                    <v-btn icon color="primary" @click="edit(education.id)">
                      <v-icon>mdi-square-edit-outline</v-icon>
                    </v-btn>
                    <v-btn icon color="red" @click="remove(education.id)">
                      <v-icon>mdi-delete-forever</v-icon>
                    </v-btn>
                  </v-card-actions>
                </v-card>
              </v-col>
            </v-row>

            <v-row justify="center" class="mb-2 mt-6">
              <v-col cols="5" md="4" lg="4">
                <v-btn depressed large block color="primary">下一步</v-btn>
              </v-col>
            </v-row>
          </v-expansion-panel-content>
        </v-expansion-panel>
      </v-expansion-panels>
    </v-col>
  </v-row>
</template>

<script>
import theStepper from "../../../components/theStepper";
import theDialog from "../../../components/theDialog";
import http from "../../../utils/http";
export default {
  components: {
    theStepper,
    theDialog
  },
  created: function() {
    this.init();
  },
  data: () => ({
    panel: [0],
    educations: []
  }),
  methods: {
    init() {
      http.get("/education").then(response => {
        console.log(response);
        this.educations = response.data;
      });
    },
    edit(id) {
      this.$router.push("/education?id=" + id);
    },
    remove(id) {
      http.delete("/education/" + id).then(response => {
        if (response.data === true) {
          this.init();
        } else {
          alert("刪除失敗");
        }
      });
    },
    add() {
      this.$router.push("/education");
    }
  }
};
</script>
