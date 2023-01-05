package com.rio.instagram.view.default_activity_fragments.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rio.instagram.R
import com.rio.instagram.view.default_activity_fragments.adapters.adapter_data_classes.AdapterSearchDataClass

class SearchViewRecyclerViewAdapter(private val interaction: SearchViewInteraction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<AdapterSearchDataClass>(){
        override fun areItemsTheSame(oldItem:AdapterSearchDataClass, newITem:AdapterSearchDataClass):Boolean {
            return oldItem == newITem
        }

        override fun areContentsTheSame(oldItem:AdapterSearchDataClass, newITem:AdapterSearchDataClass):Boolean {
            return oldItem.post_id == newITem.post_id
        }
    }

    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.search_fragment_recycler_view_item, parent, false),
            interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ViewHolder){
            holder.imageView.load(differ.currentList[position].image)
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

    fun submitList(list:List<AdapterSearchDataClass>){
        differ.submitList(list)
    }

    class ViewHolder(
        itemView: View,
        private val interaction: SearchViewInteraction?
    ): RecyclerView.ViewHolder(itemView){
        val imageView:ImageView = itemView.findViewById(R.id.searchFragmentRecyclerViewImageView)
    }

    interface SearchViewInteraction{
        // Todo
    }
}
