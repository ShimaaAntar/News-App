package com.example.islami.Base

import android.content.DialogInterface
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

open class BaseFragment:Fragment() {
    fun makeToast(message:String){
        Toast.makeText(context,message, Toast.LENGTH_LONG).show()
    }
    fun makeToast(messageId:Int){
        Toast.makeText(context,messageId, Toast.LENGTH_LONG).show()
    }
    fun showDialoge(
        title:String?=null,
        message: String,
        posActionName:String?=null,
        posAction: DialogInterface.OnClickListener?=null,
        negActionName:String?=null,
        negAction: DialogInterface.OnClickListener?=null,
        deleteAction: DialogInterface.OnCancelListener?=null,
    ) {
        val builder= AlertDialog.Builder(context!!)
        builder.setMessage(message)
        builder.setTitle(title)
        builder.setPositiveButton(posActionName,posAction)
        builder.setNegativeButton(negActionName,negAction)
        builder.setOnCancelListener(deleteAction)
        builder.show()
    }
    fun showDialoge(titleId:Int?=null,
                    messageId: Int,
                    posActionName:Int?=null,
                    posAction: DialogInterface.OnClickListener?=null,
                    negActionName:Int?=null,
                    negAction: DialogInterface.OnClickListener?=null){
        val builder= AlertDialog.Builder(context!!)
        builder.setMessage(messageId)
        if (titleId!=null)
            builder.setTitle(titleId)
        if (posActionName!=null)
            builder.setPositiveButton(posActionName,posAction)
        if (negActionName!=null)
            builder.setNegativeButton(negActionName,negAction)
        builder.show()
    }
}