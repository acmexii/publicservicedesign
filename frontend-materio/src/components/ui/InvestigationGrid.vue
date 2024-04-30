<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
                <v-btn style="margin-left: 5px;" @click="updateInvestigationDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('담당관')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>사실조사 판정
                </v-btn>
                <v-dialog v-model="updateInvestigationDialog" width="500">
                    <UpdateInvestigation
                        @closeDialog="updateInvestigationDialog = false"
                        @updateInvestigation="updateInvestigation"
                    ></UpdateInvestigation>
                </v-dialog>
            </div>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>설명</th>
                        <th>일자</th>
                        <th>민원번호</th>
                        <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" :key="val" @click="changeSelectedRow(val)" :style="val === selectedRow ? 'background-color: #f0f3ff;':''">
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="설명">{{ val.description }}</td>
                            <td class="whitespace-nowrap" label="일자">{{ val.date }}</td>
                            <td class="whitespace-nowrap" label="민원번호">{{ val.민원번호 }}</td>
                            <td class="whitespace-nowrap" label="Status">{{ val.status }}</td>
                            <Icon style="margin-top: 15px;" icon="mi:delete" @click="deleteRow(val)" />
                        </tr>
                    </tbody>
                </v-table>
            </div>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Investigation 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Investigation :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Investigation 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <String label="이름" v-model="selectedRow.name" :editMode="true"/>
                            <String label="설명" v-model="selectedRow.description" :editMode="true"/>
                            <Date label="일자" v-model="selectedRow.date" :editMode="true"/>
                            <String label="민원번호" v-model="selectedRow.민원번호" :editMode="true"/>
                            <String label="Status" v-model="selectedRow.status" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'
import Investigation from '../Investigation.vue'
import String from '../primitives/String.vue'
import Date from '../primitives/Date.vue'
import UpdateInvestigation from '../UpdateInvestigation.vue'

export default {
    name: 'investigationGrid',
    mixins:[BaseGrid],
    components:{
        Investigation,
        String,
        Date,
        UpdateInvestigation,
    },
    data: () => ({
        path: 'investigations',
        updateInvestigationDialog: false,
    }),
    watch: {
    },
    methods:{
        updateInvestigation(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "updateInvestigation", params)
                this.$EventBus.$emit('show-success','UpdateInvestigation 성공적으로 처리되었습니다.')
                this.updateInvestigationDialog = false
            }catch(e){
                console.log(e)
            }
            
        },
    }
}

</script>