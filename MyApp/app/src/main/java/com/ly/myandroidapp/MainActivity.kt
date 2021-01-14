package com.ly.myandroidapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data = mutableListOf<String>("dofjodjf", "ofjdofjid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ll = LinearLayoutManager(this)
        ll.orientation = LinearLayoutManager.VERTICAL
        rv.layoutManager = ll
        var adapter = CustomAdapter(data)
        rv.adapter = adapter
        adapter.onClickListener = View.OnClickListener {
            Log.d("tag", "------------")
        }
    }


}

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    var data: List<String>? = null
    var onClickListener:View.OnClickListener? = null
    constructor(data: List<String>) {
        this.data = data
    }

    inner class ViewHolder : RecyclerView.ViewHolder {
        val textView: TextView

        constructor(view: View) : super(view) {
            textView = view.findViewById(R.id.tv)
            view.setOnClickListener(onClickListener)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.text_row_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = data?.get(position) ?: ""
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

}