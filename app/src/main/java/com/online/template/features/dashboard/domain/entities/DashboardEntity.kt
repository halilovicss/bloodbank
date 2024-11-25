package com.online.template.features.dashboard.domain.entities

import com.online.template.features.dashboard.presentation.adapter.DashboardListener

sealed class DashboardEntity() {
    data class BloodStatus(
        val groupName: String?,
        val groupStatus: Int?
    ) : DashboardEntity()

    data class Headline(
        val title: String?,
        val viewAllText: String?,
        val dashboardListener: DashboardListener?
    ) : DashboardEntity()

    data class BloodDonorList(
        val id: Int? = null,
        val profileImage: String? = null,
        val name: String? = null,
        val address: String? = null,
        val distance: String? = null,
        val dashboardListener: DashboardListener
    ): DashboardEntity()
}
