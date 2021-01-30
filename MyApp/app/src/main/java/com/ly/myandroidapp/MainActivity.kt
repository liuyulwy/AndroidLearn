package com.ly.myandroidapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter
import com.donkingliang.groupedadapter.holder.BaseViewHolder
import com.ly.myandroidapp.button.Buttons
import com.ly.myandroidapp.model.HeaderModel
import com.ly.myandroidapp.model.NormalModel
import kotlinx.android.synthetic.main.activity_main.*

const val LOG = "log"

class MainActivity : AppCompatActivity() {

    private val data = initData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ll = LinearLayoutManager(this)
        ll.orientation = LinearLayoutManager.VERTICAL
        rv.layoutManager = ll
        var adapter = GroupListAdapter(this, data)
        rv.adapter = adapter
        rv.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        adapter.setOnChildClickListener { adapter, holder, groupPosition, childPosition ->

            when(groupPosition){
                0 -> {
                    when(childPosition){
                        0 -> {
                            val intent = Intent(this,Buttons::class.java)
                            startActivity(intent)
                        }
                        1 -> {

                        }
                    }
                }
            }
        }
    }


    fun initData(): ArrayList<HeaderModel> {
        val buttons = listOf("Button1", "Button2")
        val dialogs = listOf("Dialog1", "Dialog2")
        val groupData = HashMap<String, List<String>>()
        groupData.put("Button", buttons)
        groupData.put("Dialog", dialogs)


        val lists = ArrayList<HeaderModel>()
        val entry = groupData.entries
        for (e in entry) {
            val list = ArrayList<NormalModel>()
            for (subTitle in e.value) {
                val normal = NormalModel()
                normal.content = subTitle
                list.add(normal)
            }
            val headerModel = HeaderModel()
            headerModel.list = list
            headerModel.title = e.key
            lists.add(headerModel)
        }

        return lists
    }

}

class GroupListAdapter : GroupedRecyclerViewAdapter {
    var data: ArrayList<HeaderModel>? = null

    constructor(context: Context, data: ArrayList<HeaderModel>) : super(context) {
        this.data = data
    }

    override fun getGroupCount(): Int {
        return data!!.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return data!![groupPosition].list!!.size
    }

    override fun hasHeader(groupPosition: Int): Boolean {
        return true
    }

    override fun hasFooter(groupPosition: Int): Boolean {
        return false
    }

    override fun getHeaderLayout(viewType: Int): Int {
        return R.layout.header_item
    }

    override fun getFooterLayout(viewType: Int): Int {
        return 0
    }

    override fun getChildLayout(viewType: Int): Int {
        return R.layout.text_row_item
    }

    override fun onBindHeaderViewHolder(holder: BaseViewHolder?, groupPosition: Int) {
        holder?.itemView?.findViewById<TextView>(R.id.group_tv)?.text = data!![groupPosition].title
    }

    override fun onBindFooterViewHolder(holder: BaseViewHolder?, groupPosition: Int) {
    }

    override fun onBindChildViewHolder(
        holder: BaseViewHolder?,
        groupPosition: Int,
        childPosition: Int
    ) {
        holder?.itemView?.findViewById<TextView>(R.id.tv)?.text =
            data!![groupPosition].list!![childPosition].content

    }

}