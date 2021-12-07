package com.flesh.paginquestion

import android.content.Intent
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.flesh.paginquestion.databinding.ItemStringBinding

//Diff util
class PaginDiffUtil : DiffUtil.ItemCallback<DummyData.Companion.Data>() {
    override fun areItemsTheSame(oldItem: DummyData.Companion.Data, newItem: DummyData.Companion.Data): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DummyData.Companion.Data, newItem: DummyData.Companion.Data): Boolean {
        return oldItem.data == newItem.data
    }

}

//View holder
class ListPaginViewHolder(binding: ItemStringBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(data : DummyData.Companion.Data){
        itemView.findViewById<TextView>(R.id.myText).text = data.data
        itemView.setOnClickListener {
            itemView.context.startActivity(Intent(itemView.context,MainActivity2::class.java))
        }
    }
}

class ListPaginAdapter : PagingDataAdapter<DummyData.Companion.Data, ListPaginViewHolder>(PaginDiffUtil()) {

    override fun onBindViewHolder(holder: ListPaginViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }?:run{
            val dummyID = 1_000_000 + position
            holder.bind(DummyData.Companion.Data(dummyID, "Shit is broke @ $dummyID"))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPaginViewHolder {
        val binding = ItemStringBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListPaginViewHolder(binding)
    }
}