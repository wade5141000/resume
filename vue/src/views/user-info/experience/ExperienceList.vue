<template>
  <v-row justify="center">
    <v-col cols="12" md="10" lg="9">
      <theStepper step="3"></theStepper>
      <v-expansion-panels v-model="panel" multiple class="mt-4">
        <v-expansion-panel>
          <v-expansion-panel-header color="blue" hide-actions>
            <v-row>
              <v-col><span class="white--text text-h6">工作經歷</span></v-col>
              <v-col class="d-flex justify-end">
                <v-btn
                  text
                  color="white"
                  @click.native.stop="routeTo('/experience')"
                >
                  <v-icon left>
                    mdi-plus-circle
                  </v-icon>
                  新增工作經歷
                </v-btn>
              </v-col>
            </v-row>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <v-row
              class="mt-4"
              justify="center"
              v-for="(experience, index) in experiences"
              :key="index"
            >
              <v-col cols="12" md="10" lg="8">
                <v-card elevation="2" outlined class="my-0 py-0"
                  ><v-card-title>{{ experience.position }}</v-card-title>
                  <v-card-subtitle class="pt-1"
                    >{{ experience.companyName
                    }}<span class="float-right"
                      >{{ experience.startDate }}~{{ experience.endDate }}</span
                    ></v-card-subtitle
                  >
                  <v-divider class="mx-4 mb-1"></v-divider>
                  <v-card-text class="py-1">{{
                    experience.experienceDesc
                  }}</v-card-text>
                  <v-card-text
                    class="py-1"
                    v-if="
                      experience.ability.split(',').filter(s => s.length > 0)
                        .length > 0
                    "
                  >
                    <v-chip
                      v-for="(ability, index) in experience.ability.split(',')"
                      :key="index"
                      color="blue"
                      text-color="white"
                      class="mr-2"
                      >{{ ability }}</v-chip
                    >
                  </v-card-text>
                  <v-card-actions>
                    <v-btn icon color="primary" @click="edit(experience.sn)">
                      <v-icon>mdi-square-edit-outline</v-icon>
                    </v-btn>
                    <v-btn icon color="red" @click="remove(experience.sn)">
                      <v-icon>mdi-delete-forever</v-icon>
                    </v-btn>
                  </v-card-actions>
                </v-card>
              </v-col>
            </v-row>

            <v-row justify="center" class="mb-2 mt-6">
              <v-col cols="6" md="5" lg="4">
                <v-btn
                  depressed
                  large
                  block
                  color="primary"
                  to="/education-list"
                  >上一步</v-btn
                >
              </v-col>
              <v-col cols="6" md="5" lg="4">
                <v-btn depressed large block color="primary" to="/skill"
                  >下一步</v-btn
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
    experiences: []
  }),
  methods: {
    init() {
      http.get("/experience").then(response => {
        console.log(response);
        this.experiences = response.data;
      });
    },
    edit(id) {
      this.$router.push("/experience?id=" + id);
    },
    remove(id) {
      http.delete("/experience/" + id).then(response => {
        if (response.data === true) {
          this.init();
        } else {
          alert("刪除失敗");
        }
      });
    },
    routeTo(path) {
      this.$router.push(path);
    }
  }
};
</script>
