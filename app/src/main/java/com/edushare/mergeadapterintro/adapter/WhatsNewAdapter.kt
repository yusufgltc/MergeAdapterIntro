package com.edushare.mergeadapterintro.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.edushare.mergeadapterintro.R
import com.edushare.mergeadapterintro.model.WhatsNew

class WhatsNewAdapter(private val listener: WhatsNewListener) :
    RecyclerView.Adapter<WhatsNewAdapter.WhatsNewViewHolder>() {

    var whatsNew: WhatsNew? = null

    private fun hasWhatsNewData(field: WhatsNew?): Boolean {
        return !field?.description.isNullOrEmpty()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WhatsNewAdapter.WhatsNewViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_whats_new, parent, false)
        return WhatsNewViewHolder(view)
    }

    override fun getItemCount() = if (hasWhatsNewData(whatsNew)) 1 else 0

    override fun getItemViewType(position: Int): Int = R.layout.item_whats_new


    override fun onBindViewHolder(holder: WhatsNewAdapter.WhatsNewViewHolder, position: Int) {
        holder.bind(whatsNew, listener)
    }

    inner class WhatsNewViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        private val textWhatsNew = itemView.findViewById<TextView>(R.id.whatsNew)
        private val textDismiss = itemView.findViewById<TextView>(R.id.dismiss)

        fun bind(
            whatsNew: WhatsNew?,
            listener: WhatsNewListener){
            textWhatsNew.text = whatsNew?.description
            textDismiss.setOnClickListener {
                listener.onDismiss()
            }
        }
    }

    interface WhatsNewListener {
        fun onDismiss()
    }
}