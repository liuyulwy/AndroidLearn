package com.ly.myandroidapp.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableArrayMap
import androidx.databinding.ObservableField
import com.ly.myandroidapp.BR


class User() {
    var name = ObservableField<String>().apply { this.set("hello world") }
    var age = ObservableField<Int>()
    var map = ObservableArrayMap<String, Any>().apply {
        this.put("a", "aaaaa")
        this.put("b", 20)
    }
    var p = Parent()
}
class Children() {}
class Parent : BaseObservable() {
    @get:Bindable
    var firstName: String = ""
        set(firstName) {
            field = firstName
            notifyPropertyChanged(BR.firstName)
        }

    @get:Bindable
    var lastName: String = ""
        set(lastName) {
            field = lastName
            notifyPropertyChanged(BR.lastName)
        }
}

