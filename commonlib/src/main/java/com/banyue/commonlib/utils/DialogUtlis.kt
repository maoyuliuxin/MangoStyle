package com.banyue.commonlib.utils

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface


/**
 * Created by Administrator on 2017/8/15.
 */
fun Context.setItem(items: Array<String>, listener: DialogInterface.OnClickListener): AlertDialog {
    return AlertDialog.Builder(this)
            .setItems(items, listener)
            .show()
}

fun Context.showProgress(msg: String = "Login"): ProgressDialog {
    val dialog = ProgressDialog(this)
    dialog.setMessage(msg)
    dialog.isIndeterminate = false
    dialog.setCanceledOnTouchOutside(false)
    dialog.show()
    return dialog
}

fun Context.setSingle(items: Array<String>, listener: DialogInterface.OnClickListener): AlertDialog {
    return AlertDialog.Builder(this)
            .setSingleChoiceItems(items, -1, listener)
            .show()
}

//fun Context.setOptionsList(title: String, list: List<String>): OptionListDialog {
//    val dialog = SmartisanDialog.createOptionListDialog(this)
//    dialog.setTitle(title)
//            .setOptionList(list)
//            .setItemGravity(Gravity.CENTER) // Item是居左、居中还是居右
//            .show()
//    dialog.window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
//            if (list.size > 6) {
//                AppScreenMgr.getScreenHeight(this) / 2
//            } else {
//                WindowManager.LayoutParams.WRAP_CONTENT
//            })
//    dialog.window.attributes.gravity = Gravity.BOTTOM
//    return dialog
//}
//
//fun Context.setWarningDialog(title: String, msg: String): WarningDialog {
//    val dialog = SmartisanDialog.createWarningDialog(this);
//    dialog.setTitle(title)
//            .setConfirmText(msg)
//            .show()
//    return dialog
//}
//
//fun Context.setTwoOptions(title: String, one: String, two: String, listener: TwoOptionsDialog.OnSelectListener): TwoOptionsDialog {
//    val dialog = SmartisanDialog.createTwoOptionsDialog(this);
//    dialog.setTitle(title)
//            .setOp1Text(one)   // 设置第一个选项的文本
//            .setOp2Text(two)   // 设置第二个选项的文本
//            .show()
//    dialog.setOnSelectListener(listener)
//    return dialog
//}
//
//fun Context.setThreeOptions(title: String, one: String, two: String, three: String,
//                            listener: ThreeOptionsDialog.OnSelectListener): ThreeOptionsDialog {
//    val dialog = SmartisanDialog.createThreeOptionsDialog(this);
//    dialog.setTitle(title)
//            .setOp1Text(one)   // 设置第一个选项的文本
//            .setOp2Text(two)// 设置第二个选项的文本
//            .setOp3Text(three)
//            .show()
//    dialog.setOnSelectListener(listener)
//    return dialog
//}
//
////没有标题的dialog,只能用原生的
//fun Context.setDialog(message: String, positive: String, positiveListener: DialogInterface.OnClickListener): AlertDialog {
//    val alertDialog = AlertDialog.Builder(this)
//            .setMessage(message)
//            .setPositiveButton(positive, positiveListener)
//            .show()
//    alertDialog.setCanceledOnTouchOutside(false)
//    return alertDialog
//}
//
//fun Context.setDialog(title: String, message: String, positive: String,
//                      negative: String): NormalDialog {
//    val dialog = SmartisanDialog.createNormalDialog(this)
//    dialog.setTitle(title)
//            .setMsg(message)
//            .setMsgGravity(Gravity.CENTER)
//            .setLeftBtnText(negative)   // 设置文本的按钮会显示，不设置文本则不显示
//            .setRightBtnText(positive)
//            .show()
//    return dialog
//}
//
//fun Context.setDialog(title: String, message: String, positive: String): NormalDialog {
//    val dialog = SmartisanDialog.createNormalDialog(this)
//    dialog.setTitle(title)
//            .setMsg(message)
//            .setMsgGravity(Gravity.CENTER)
//            .setLeftBtnText(positive)   // 设置文本的按钮会显示，不设置文本则不显示
//            .show()
//    return dialog
//}
