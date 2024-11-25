package com.online.template.core.presentation.adapter

import androidx.databinding.ViewDataBinding
import com.online.template.core.presentation.adapter.view_holder.CoreDataBoundViewHolder

abstract class MultiTypeDataBoundAdapter(
    private val dataResId: Int,
    items: MutableList<Any>? = mutableListOf()
) : CoreDataBoundAdapter<ViewDataBinding>() {

    val items = items ?: mutableListOf()

    override fun bindItem(
        holder: CoreDataBoundViewHolder<ViewDataBinding>?,
        position: Int,
        payloads: List<Any?>?
    ) {
        holder?.binding?.setVariable(dataResId, items[position])
    }

    override fun getItemCount() = items.size

    fun getItem(position: Int): Any? {
        if (position < 0 || position >= items.size) return null
        return items[position]
    }

    open fun showProgressBar(position: Int, visibility: Boolean) {
        notifyItemChanged(position)
    }

    open fun updateItems(position: Int, added: Boolean, playlistTrackId: Int) {
        notifyItemChanged(position)
    }

    open suspend fun showAddRemoveMessage(message: String, position: Int) {
        notifyItemChanged(position)
    }

    fun setItems(items: List<Any>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addItems(items: List<Any>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(item: Any) {
        this.items.add(item)
        notifyDataSetChanged()
    }

    fun clearItems() {
        this.items.clear()
        notifyDataSetChanged()
    }

    fun updateItem(newItem: Any, position: Int) {
        this.items[position] = newItem
        notifyItemChanged(position)
    }
}
