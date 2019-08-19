package com.soarlibrary.base

interface BaseViewInter<T> {
    fun showWaitting()
    fun disWaitting()
    fun onBindUI()
    fun onFailUI()
    fun getContext():T

}