package com.example.binlistapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.binlistapp.R
import com.example.binlistapp.data.db.CardInfoEntity

class CardInfoAdapter(
    private val cardInfoList: List<CardInfoEntity>
) : RecyclerView.Adapter<CardInfoAdapter.CardInfoViewHolder>() {

    class CardInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binCode: TextView = itemView.findViewById(R.id.binCode)
        val cardType: TextView = itemView.findViewById(R.id.cardType)
        val bankName: TextView = itemView.findViewById(R.id.bankName)
        val phoneNumber: TextView = itemView.findViewById(R.id.phoneNumber)
        val bankUrl: TextView = itemView.findViewById(R.id.bankUrl)
        val cityText: TextView = itemView.findViewById(R.id.cityText)

        // Метод bind для привязки данных
        fun bind(cardInfo: CardInfoEntity) {
            binCode.text = cardInfo.binCode
            cardType.text = cardInfo.cardType
            bankName.text = cardInfo.bank
            phoneNumber.text = cardInfo.phoneNumber
            bankUrl.text = cardInfo.bankUrl
            cityText.text = cardInfo.city
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardInfoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.v_card_item, parent, false)
        return CardInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardInfoViewHolder, position: Int) {
        val currentItem = cardInfoList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return cardInfoList.size
    }
}