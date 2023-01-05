package com.rio.instagram.view.default_activity_fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import coil.load
import com.rio.instagram.R
import com.rio.instagram.view.default_activity_fragments.adapters.adapter_data_classes.AdapterPostsClass
import de.hdodenhof.circleimageview.CircleImageView

class HomeFragmentRecyclerViewAdapter (private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<AdapterPostsClass>(){
        override fun areItemsTheSame(oldItem:AdapterPostsClass, newITem:AdapterPostsClass):Boolean {
            return oldItem == newITem
        }

        override fun areContentsTheSame(oldItem:AdapterPostsClass, newITem: AdapterPostsClass):Boolean {
                return oldItem.post_id == newITem.post_id
        }
    }

    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // Todo
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.home_fragment_recycler_view_item, parent, false),
            interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ViewHolder){
            holder.dpImageView.load(differ.currentList[position].dp)
            holder.userNameTextView.text = differ.currentList[position].username
            holder.message.text = differ.currentList[position].message
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

    fun submitList(list:List<AdapterPostsClass>){
        differ.submitList(list)
    }

    class ViewHolder(
        itemView: View,
        private val interaction: Interaction?
    ): RecyclerView.ViewHolder(itemView){
        val dpImageView:CircleImageView = itemView.findViewById(R.id.homeFramgentBottomRecyclerViewDpImageView)
        val userNameTextView: TextView = itemView.findViewById(R.id.homeFragmentRecyclerViewUserProfileName)
        val optionButton: ImageButton = itemView.findViewById(R.id.homeFragmentRecyclerViewOptionButton)
        val postsViewPager: ViewPager2 = itemView.findViewById(R.id.homeFragmentRecyclerViewViewPager)
        val likesButton:ImageButton = itemView.findViewById(R.id.homeFragmentRecyclerViewLikeButton)
        val commentsButton:ImageButton = itemView.findViewById(R.id.homeFragmentRecyclerViewCommentButton)
        val shareButton:ImageButton = itemView.findViewById(R.id.homeFragmentRecyclerviewShareButton)
        val saveButton:ImageButton = itemView.findViewById(R.id.homeFragmentRecyclerViewSaveButton)
        val message:TextView = itemView.findViewById(R.id.homeFragmentRecyclerViewMessageTextView)
    }

    interface Interaction{
        // Todo
    }
}