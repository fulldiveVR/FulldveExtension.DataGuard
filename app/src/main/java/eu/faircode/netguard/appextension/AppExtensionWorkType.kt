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

sealed class AppExtensionWorkType(val id: String) {
    object START: AppExtensionWorkType("start")
    object STOP: AppExtensionWorkType("stop")
    object OPEN: AppExtensionWorkType("open")
    object GetPermissionsRequired : AppExtensionWorkType("get_permissions_required")
    object GetStatus : AppExtensionWorkType("get_status")
}