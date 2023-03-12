package com.example.todoappkotlin.dialogs

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import android.os.ProxyFileDescriptorCallback
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class TimePickerDialogFragment(val callback: (Long)->Unit): DialogFragment (),OnTimeSetListener{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val hours =calendar.get(Calendar.HOUR_OF_DAY)
        val minute =calendar.get(Calendar.MINUTE)
        //val seconds =calendar.get(Calendar.SECOND)

       return TimePickerDialog(requireActivity(),this,hours,minute,false)
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
       val calendar =Calendar.getInstance()
        calendar.set(0,0,0,p1,p2)
        callback(calendar.timeInMillis)
    }

}