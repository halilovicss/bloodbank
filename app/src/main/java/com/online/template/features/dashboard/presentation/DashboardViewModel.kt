package com.online.template.features.dashboard.presentation

import com.online.template.R
import com.online.template.core.presentation.activity.CoreViewModel
import com.online.template.features.dashboard.domain.entities.DashboardEntity
import com.online.template.features.dashboard.domain.entities.DashboardMenuEntity
import com.online.template.features.dashboard.presentation.adapter.DashboardListener
import dagger.assisted.AssistedInject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow

class DashboardViewModel @AssistedInject constructor() : CoreViewModel(), DashboardListener {
    val profileImage =
        MutableStateFlow("https://ca.slack-edge.com/TEPFK8S6B-U05V9EJALG6-95e93d01fba9-512")
    val fullName = MutableStateFlow("Halilovic Selvedin")
    val userId = MutableStateFlow("User ID: 343242")
    val notificationStatus = MutableStateFlow(false)
    val menuItems = MutableStateFlow<List<DashboardMenuEntity>>(emptyList())
    val dashboardItems = MutableStateFlow<List<Any>>(emptyList())

    init {
        launch {
            val list = listOf(
                DashboardMenuEntity(R.drawable.ic_person_search, "Trazi donore"),
                DashboardMenuEntity(R.drawable.ic_person_search, "Zahtjev za krv"),
                DashboardMenuEntity(R.drawable.ic_person_search, "Mapa")
            )
            val items = mutableListOf<DashboardEntity>()
            items.add(DashboardEntity.BloodStatus("AB", 2))
            items.add(
                DashboardEntity.Headline(
                    "Donori krvi",
                    "Pogledaj sve",
                    dashboardListener = this@DashboardViewModel
                )
            )
            items.addAll(
                listOf(
                    DashboardEntity.BloodDonorList(
                        id = 1,
                        profileImage = com.online.template.features.dashboard.domain.entities.profileImage.value,
                        name = "Selvedin Halilovic",
                        "Kovaci",
                        "3k",
                        dashboardListener = this@DashboardViewModel
                    ),
                    DashboardEntity.BloodDonorList(
                        id = 2,
                        profileImage = com.online.template.features.dashboard.domain.entities.profileImage.value,
                        name = "Selvedin Halilovic",
                        "Kovaci",
                        "3k",
                        dashboardListener = this@DashboardViewModel
                    ),
                    DashboardEntity.BloodDonorList(
                        id = 2,
                        profileImage = com.online.template.features.dashboard.domain.entities.profileImage.value,
                        name = "Selvedin Halilovic",
                        "Kovaci",
                        "3k",
                        dashboardListener = this@DashboardViewModel
                    ),
                    DashboardEntity.BloodDonorList(
                        id = 2,
                        profileImage = com.online.template.features.dashboard.domain.entities.profileImage.value,
                        name = "Selvedin Halilovic",
                        "Kovaci",
                        "3k",
                        dashboardListener = this@DashboardViewModel
                    )
                )
            )
            dashboardItems.emit(items)
            menuItems.emit(list)
            delay(4000L)
            notificationStatus.emit(true)

        }
    }

    override fun openPerson(personId: Int) {
        navigate(DashboardFragmentDirections.actionDashboardFragmentToDonorDetailsFragment())
        println("OTVORI $personId")
    }
}