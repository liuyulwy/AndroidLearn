package com.ly.myandroidapp.model

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableArrayMap
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ly.myandroidapp.BR


class MyViewModel: ViewModel() {
    val name = MutableLiveData<String>()
}

class User() {
    var name = ObservableField<String>().apply { this.set("hello world") }
    var age = ObservableField<Int>()
    var map = ObservableArrayMap<String, Any>().apply {
        this.put("a", "aaaaa")
        this.put("b", 20)
    }
    var p = Parent()
}
class Parent : BaseObservable() {
    @get:Bindable
    var firstName: String = "abc"
        set(value) {
            Log.d("model:",value)
            if (value != field){
                field = value
                notifyPropertyChanged(BR.firstName)
            }
        }

    @get:Bindable
    var lastName: String = ""
        set(lastName) {
            field = lastName
            notifyPropertyChanged(BR.lastName)
        }
}



class HeaderModel {
    val isHeader = true
    var title = ""
    var list:List<NormalModel>? = null
}

class NormalModel {
    var content = ""
}

