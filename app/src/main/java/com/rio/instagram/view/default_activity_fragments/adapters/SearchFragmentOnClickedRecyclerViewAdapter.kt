package com.rio.instagram.view.default_activity_fragments.adapters

import android.view.LayoutInflater
import android.view.TextureView
import com.rio.instagram.view.default_activity_fragments.adapters.adapter_data_classes.AdapterSearchOnClickedDataClass
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rio.instagram.R
import de.hdodenhof.circleimageview.CircleImageView

class SearchFragmentOnClickedRecyclerViewAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<AdapterSearchOnClickedDataClass>(){
        override fun areItemsTheSame(oldItem:AdapterSearchOnClickedDataClass, newITem:AdapterSearchOnClickedDataClass):Boolean {
            return oldItem == newITem
        }

        override fun areContentsTheSame(oldItem:AdapterSearchOnClickedDataClass, newITem:AdapterSearchOnClickedDataClass):Boolean {
            return oldItem.userName == newITem.userName
        }
    }

    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.search_fragment_on_clicked_layout,
                parent
            ), interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // Todo
    }

    override fun getItemCount(): Int = differ.currentList.size

    fun submitList(list:List<AdapterSearchOnClickedDataClass>){
        differ.submitList(list)
    }

    class ViewHolder(
        itemView: View,
        private val interaction: Interaction?
    ): RecyclerView.ViewHolder(itemView){
        val userNameTV:TextView = itemView.findViewById(R.id.searchFragmentTopRecyclerViewUserName)
        val dp:CircleImageView = itemView.findViewById(R.id.searchFragmentTopRecyclerViewUserName)
        val descriptionTV:TextureView = itemView.findViewById(R.id.searchFragmentTopRecyclerViewDescriptionTextView)
        val followedByTv:TextView = itemView.findViewById(R.id.searchFragmentTopRecyclerViewfollowedByTextView)
    }

    interface Interaction{
        // Todo
    }
}