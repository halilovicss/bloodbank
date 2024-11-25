package com.online.template.features.dashboard.presentation.adapter

import android.annotation.SuppressLint
import com.online.template.R
import com.online.template.core.presentation.adapter.CoreDataBoundAdapter
import com.online.template.core.presentation.adapter.view_holder.CoreDataBoundViewHolder
import com.online.template.databinding.LayoutCardDashboardBinding
import com.online.template.features.dashboard.domain.entities.DashboardMenuEntity

class DashboardAdapter : CoreDataBoundAdapter<LayoutCardDashboardBinding>() {
    var items = mutableListOf<DashboardMenuEntity>()
    override fun bindItem(
        holder: CoreDataBoundViewHolder<LayoutCardDashboardBinding>?,
        position: Int,
        payloads: List<Any?>?
    ) {
        holder?.binding?.data = items[position]
    }

    override fun getItemLayoutId(position: Int): Int = R.layout.layout_card_dashboard

    override fun getItemCount(): Int = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(itemList: List<DashboardMenuEntity>) {
        items.clear()
        items.addAll(itemList)
        notifyDataSetChanged()
    }
}