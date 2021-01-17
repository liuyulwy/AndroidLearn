package com.ly.myandroidapp

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter
import com.donkingliang.groupedadapter.holder.BaseViewHolder
import com.ly.myandroidapp.model.HeaderModel
import com.ly.myandroidapp.model.NormalModel
import kotlinx.android.synthetic.main.activity_main.*

const val LOG = "log"

class MainActivity : AppCompatActivity() {

    //    val data = mutableListOf<String>("1111", "2222", "3333", "4444")
    val data = initData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ll = LinearLayoutManager(this)
        ll.orientation = LinearLayoutManager.VERTICAL
        rv.layoutManager = ll
//        var adapter = CustomAdapter(data)
//        rv.adapter = adapter
//        rv.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
//        adapter.onClickListener = View.OnClickListener {
//            Log.d("tag", "------------")
//        }

    }


    fun initData(): ArrayList<HeaderModel> {
        val lists = ArrayList<HeaderModel>()
        for (i in 0..3){
            val list = ArrayList<NormalModel>()
            for (j in 0..10){
                val normal =  NormalModel()
                normal.content = "index$j"
                list.add(normal)
            }
            val headerModel = HeaderModel()
            headerModel.list = list
            lists.add(headerModel)
        }

        return lists
    }

}

class GroupListAdapter: GroupedRecyclerViewAdapter {

    constructor(context: Context): super(context){

    }

    override fun getGroupCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        TODO("Not yet implemented")
    }

    override fun hasHeader(groupPosition: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun hasFooter(groupPosition: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun getHeaderLayout(viewType: Int): Int {
        TODO("Not yet implemented")
    }

    override fun getFooterLayout(viewType: Int): Int {
        TODO("Not yet implemented")
    }

    override fun getChildLayout(viewType: Int): Int {
        TODO("Not yet implemented")
    }

    override fun onBindHeaderViewHolder(holder: BaseViewHolder?, groupPosition: Int) {
        TODO("Not yet implemented")
    }

    override fun onBindFooterViewHolder(holder: BaseViewHolder?, groupPosition: Int) {
        TODO("Not yet implemented")
    }

    override fun onBindChildViewHolder(
        holder: BaseViewHolder?,
        groupPosition: Int,
        childPosition: Int
    ) {
        TODO("Not yet implemented")
    }

}

//class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder> {
//    var data: ArrayList<HeaderModel>? = null
//    var onClickListener: View.OnClickListener? = null
//
//    val headerView = 1
//    val normalView = 2
//
//    constructor(data: ArrayList<HeaderModel>) {
//        this.data = data
//    }
//
//    inner class ViewHolder : RecyclerView.ViewHolder {
//        val textView: TextView
//
//        constructor(view: View) : super(view) {
//            textView = view.findViewById(R.id.tv)
//        }
//    }
//
//
//    override fun getItemViewType(position: Int): Int {
//        val headerModel = data?.get(position)
//        return 1
//    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//
//        val view = LayoutInflater.from(parent.context)
//                .inflate(R.layout.text_row_item, parent, false)
//
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.textView.text = data?.get(position) ?: ""
//        holder.itemView.setOnClickListener(onClickListener)
//        if (position == 1) {
//            holder.textView.visibility = View.GONE
//        }else{
//            holder.textView.visibility = View.VISIBLE
//        }
//
//    }
//
//    override fun getItemCount(): Int {
//        return data?.size ?: 0
//    }
//
//}