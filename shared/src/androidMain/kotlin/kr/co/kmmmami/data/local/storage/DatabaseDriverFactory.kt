package kr.co.kmmmami.data.local.storage

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import kr.co.kmmmami.shared.data.storage.KmmMamiDB

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(KmmMamiDB.Schema, context, "kmmmami.db")
    }
}