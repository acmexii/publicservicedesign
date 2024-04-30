<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: '민원접수' }" />
        <VerticalNavLink
            :item="{
                title: '민원',
                to: '/applications',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '민원유형1' }" />
        <VerticalNavLink
            :item="{
                title: '사실조사',
                to: '/investigations',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '처리',
                to: '/processings',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '민원유형2' }" />
        <VerticalNavLink
            :item="{
                title: '민원유형2',
                to: '/minwonType2s',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '보상처리' }" />
        <VerticalNavLink
            :item="{
                title: '보상신청심의',
                to: '/rewardApplications',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '보상지급',
                to: '/compensationPayments',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '민원분석1' }" />
        <VerticalNavLink
            :item="{
                title: '분석관점1',
                to: '/analysis1s',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '민원분석2' }" />
        <VerticalNavLink
            :item="{
                title: '분석관점',
                to: '/analysis2s',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '기타' }" />
    </ul>
</template>
