/*
 * Copyright (c) 2022 FullDive
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package eu.faircode.netguard.appextension

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.widget.AppCompatRatingBar
import androidx.core.content.ContextCompat
import com.full.dialer.top.secure.encrypted.namespace.R
import kotlin.math.roundToInt

object RateUsDialogBuilder {

    fun show(context: Context, onPositiveClicked: (Int) -> Unit) {
        val view = LayoutInflater.from(context).inflate(R.layout.rate_us_dialog_layout, null)
        val ratingBar = view.findViewById<AppCompatRatingBar>(R.id.ratingBar)
        var ratingValue = 0
        ratingBar.setOnRatingBarChangeListener { _, value, fromUser ->
            if (fromUser) {
                ratingValue = value.roundToInt()
            }
        }

        val dialog = AlertDialog
            .Builder(context)
            .setView(view)
            .setTitle(R.string.rate_us_title)
            .setPositiveButton(R.string.rate_submit) { _, _ ->
                onPositiveClicked.invoke(ratingValue)
            }
            .setNegativeButton(R.string.rate_cancel) { _, _ -> }
            .create()

        dialog.setOnShowListener {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE)
                ?.setTextColor(ContextCompat.getColor(context, R.color.textColorAccent))
            dialog.getButton(AlertDialog.BUTTON_NEGATIVE)
                ?.setTextColor(ContextCompat.getColor(context, R.color.textColorSecondary))
        }
        dialog.show()
    }
}