package com.sassaran.finapp.base
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


abstract class GlobalRecyclerAdapter<T, D>(private var mList: ArrayList<T>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    abstract fun getLayoutId(): Int
    abstract fun onBinder(model: T, viewbinding: D, position: Int)


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        var binding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), getLayoutId(), parent, false)
        var viewHolder = ItemViewHolder(binding)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return mList?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        onBinder(mList?.get(position)!!, (holder as GlobalRecyclerAdapter<*, *>.ItemViewHolder).mBinding as D,position = position)
    }


    internal inner class ItemViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        var mBinding: D

        init {
            mBinding = binding as D
        }
    }

}

