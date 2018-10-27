package com.gnm.finalprojek.views

import android.support.v4.app.Fragment

interface MatchFragmentView {
    fun Loading()
    fun finishLoading()
    fun init()
    fun changeFragment(fragment: Fragment)
}