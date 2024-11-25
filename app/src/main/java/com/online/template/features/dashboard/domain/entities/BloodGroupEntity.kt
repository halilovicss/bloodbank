package com.online.template.features.dashboard.domain.entities

import kotlinx.coroutines.flow.MutableStateFlow

data class BloodGroupEntity(
    val groupGroupName: String?,
    val bloodStatus: Int?
)

val profileImage =
    MutableStateFlow("https://ca.slack-edge.com/TEPFK8S6B-U05V9EJALG6-95e93d01fba9-512")
