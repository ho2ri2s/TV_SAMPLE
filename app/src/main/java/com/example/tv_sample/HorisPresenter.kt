package com.example.tv_sample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.leanback.widget.Presenter
import com.example.tv_sample.databinding.LayoutRowItemBinding

class HorisPresenter : Presenter() {

    private lateinit var layoutInflater: LayoutInflater
    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        if (!::layoutInflater.isInitialized) layoutInflater = LayoutInflater.from(parent.context)
        return HorisViewHolder(LayoutRowItemBinding.inflate(layoutInflater, parent, false)).apply {
            view.setOnFocusChangeListener { _, hasFocus ->

            }
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any?) {
        viewHolder as HorisViewHolder
        item as String
        with(viewHolder.binding) {
            value = item
//            root.setOnFocusChangeListener { _, hasFocus ->
//              onCreateViewHolder内でsetしてあげないとFocusHighlightがうまくいかない。
//            }
        }
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) = Unit

    private class HorisViewHolder(val binding: LayoutRowItemBinding) :
        Presenter.ViewHolder(binding.root)
}
