package com.example.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.Wisata

import com.bumptech.glide.Glide


class ListWisataAdapter( val listWisata: ArrayList<Wisata>): RecyclerView.Adapter<ListWisataAdapter.ListViewHolder>() {

//    private lateinit var onItemClickCallback: OnItemClickCallback
//
//    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
//        this.onItemClickCallback = onItemClickCallback
//    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_wisata, viewGroup, false)
    return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listWisata.size


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (nama, deskripsi, poto, kecamatan, tahun) = listWisata[position]

        Glide.with(holder.itemView.context)
            .load(poto) // URL Gambar
            .into(holder.imgPhoto) // imageView mana yang akan diterapkan

        holder.tvName.text= nama
        holder.tvDescription.text = deskripsi

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener{
//            onItemClickCallback.onItemClicked(listWisata[holder.adapterPosition])

            val moveDetail = Intent(mContext, DetailWisata::class.java)
            moveDetail.putExtra(DetailWisata.EXTRA_NAME, nama)
            moveDetail.putExtra(DetailWisata.EXTRA_POTO, poto)
            moveDetail.putExtra(DetailWisata.EXTRA_DESKRIPSI, deskripsi)
            moveDetail.putExtra(DetailWisata.EXTRA_KECAMATAN, kecamatan)
            moveDetail.putExtra(DetailWisata.EXTRA_TAHUN, tahun)
            mContext.startActivity(moveDetail)
        }
    }


    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_deskripsi)
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)

    }

    interface OnItemClickCallback{
        fun onItemClicked(data: Wisata)
    }

}