/*
 * Copyright (c) 2021. Proton AG
 *
 * This file is part of ProtonVPN.
 *
 * ProtonVPN is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ProtonVPN is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with ProtonVPN.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.protonvpn.android.logging

import java.util.Locale

enum class LogCategory {
    CONN, CONN_CONNECT, CONN_DISCONNECT, CONN_SERVER_SWITCH,
    LOCAL_AGENT,
    UI,
    USER, USER_CERT, USER_PLAN,
    API,
    NET,
    PROTOCOL,
    APP,
    APP_UPDATE,
    OS,
    SETTINGS;

    fun toLog() = name.lowercase(Locale.US).replace('_', '.')
}

class LogEventType(
    private val category: LogCategory,
    private val name: String,
    val level: LogLevel
) {
    override fun toString() = "${level.toLog()} ${category.toLog()}:$name"
}

val ConnCurrentState = LogEventType(LogCategory.CONN, "current_state", LogLevel.INFO)
val ConnStateChange = LogEventType(LogCategory.CONN, "state_change", LogLevel.INFO)
val ConnError = LogEventType(LogCategory.CONN, "error", LogLevel.ERROR)
val ConnConnectTrigger = LogEventType(LogCategory.CONN_CONNECT, "trigger", LogLevel.INFO)
val ConnConnectScan = LogEventType(LogCategory.CONN_CONNECT, "scan", LogLevel.INFO)
val ConnConnectScanFailed = LogEventType(LogCategory.CONN_CONNECT, "scan_failed", LogLevel.INFO)
val ConnConnectScanResult = LogEventType(LogCategory.CONN_CONNECT, "scan_result", LogLevel.INFO)
val ConnConnectStart = LogEventType(LogCategory.CONN_CONNECT, "start", LogLevel.INFO)
val ConnConnectConnected = LogEventType(LogCategory.CONN_CONNECT, "connected", LogLevel.INFO)

val ConnDisconnectTrigger = LogEventType(LogCategory.CONN_DISCONNECT, "trigger", LogLevel.INFO)