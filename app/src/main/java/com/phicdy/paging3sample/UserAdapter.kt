package com.phicdy.paging3sample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.phicdy.paging3sample.databinding.ItemUserBinding

class UserAdapter(diffCallback: DiffUtil.ItemCallback<User>) :
    PagingDataAdapter<User, UserViewHolder>(diffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = getItem(position)
        // Note that item may be null. ViewHolder must support binding a
        // null item as a placeholder.
        holder.bind(item)
    }
}
