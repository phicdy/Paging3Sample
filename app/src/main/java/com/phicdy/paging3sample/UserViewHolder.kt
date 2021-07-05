package com.phicdy.paging3sample

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.phicdy.paging3sample.databinding.ItemUserBinding

class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: User?) {
        binding.userName.text = item?.name
    }
}