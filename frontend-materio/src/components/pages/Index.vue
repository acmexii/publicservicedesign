<template>
  <v-container fluid>
    <v-row>
      <v-card
          v-for="(card, index) in cards"
          :key="index"
          class="mx-auto"
          style="height:300px; width:300px; margin-bottom:20px;"
          outlined
      >
        <v-list-item>
          <v-icon style="margin-top: 30%; margin-left: 37.5%;" color="primary" size="64">mdi-apps</v-icon>
        </v-list-item>
        <v-card-actions>
          <v-btn
              class="mx-auto"
              outlined
              rounded
              :to="card.link"
              style="font-weight:500; font-size:20px; border:solid 2px; max-width:250px; overflow:hidden; margin-top: 10%;"
          >
              {{ card.text }}
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'Index',
  data: () => ({
    cards: [
      {
          text: "민원",
          link: "/applications",
      },
      {
          text: "사실조사",
          link: "/investigations",
      },
      {
          text: "처리",
          link: "/processings",
      },
      {
          text: "민원유형2",
          link: "/minwonType2s",
      },
      {
          text: "보상신청심의",
          link: "/rewardApplications",
      },
      {
          text: "보상지급",
          link: "/compensationPayments",
      },
      {
          text: "분석관점1",
          link: "/analysis1s",
      },
      {
          text: "분석관점",
          link: "/analysis2s",
      },
    ],
  }),
};
</script>
