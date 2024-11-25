package com.online.template.features.dashboard.presentation.adapter

import androidx.databinding.ViewDataBinding
import com.online.template.core.presentation.adapter.MultiTypeDataBoundAdapter
import com.online.template.BR
import com.online.template.R
import com.online.template.core.presentation.adapter.view_holder.CoreDataBoundViewHolder
import com.online.template.features.dashboard.domain.entities.BloodGroupEntity
import com.online.template.features.dashboard.domain.entities.DashboardEntity

class DashBoardMainAdapter : MultiTypeDataBoundAdapter(BR.data) {
    override fun getItemLayoutId(position: Int): Int {
        return when (getItem(position)) {
            is DashboardEntity.BloodStatus -> R.layout.layout_blood_status
            is DashboardEntity.Headline -> R.layout.layout_headline
            is DashboardEntity.BloodDonorList -> R.layout.layout_donor_list
            else -> R.layout.layout_card_dashboard
        }
    }

    override fun bindItem(
        holder: CoreDataBoundViewHolder<ViewDataBinding>?,
        position: Int,
        payloads: List<Any?>?
    ) {
        super.bindItem(holder, position, payloads)
    }
}